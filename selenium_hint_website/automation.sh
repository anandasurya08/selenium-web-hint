#!/bin/bash

# Mengecek jumlah argumen yang diberikan
if [ "$#" -ne 5 ]; then
    echo "Usage: $0 <project_code> <testrun_id> <token> <project_path> <author_id>"
    exit 1
fi

# Assign variabel untuk parameter yang diberikan
PROJECT_CODE="$1"
TESTRUN_ID="$2"
TOKEN="$3"
PROJECT_PATH="$4"
AUTHOR_ID="$5"

# URL untuk curl request
URL="https://api.qase.io/v1/result/$PROJECT_CODE/$TESTRUN_ID"

SUITE_LIST_SIDE="list_side.txt"
if [ ! -f "$SUITE_LIST_SIDE" ]; then
    echo "File $SUITE_LIST_SIDE not found!"
    exit 1
fi

suite_list=$(cat "$SUITE_LIST_SIDE")

# Proses setiap suite dalam list
for suite_file in $suite_list; do
    full_suite_path="$PROJECT_PATH/$suite_file"
    if [ ! -f "$full_suite_path" ]; then
        echo "File $full_suite_path not found!"
        continue
    fi

    suite_name="$(basename ${full_suite_path%.side})"

    # Eksekusi selenium-side-runner untuk setiap file .side
    echo "Running $suite_name"

selenium-side-runner -c "browserName=firefox moz:firefoxOptions.args=[-headless,-no-sandbox]" --jest-timeout 120000 --output-directory="$PROJECT_PATH/hasil" --config-file /builds/hint-of-you/selenium-hint-web/config.yml "$full_suite_path" --debug
    
    json_file=$(find "$PROJECT_PATH/hasil" -name "results*")
    echo "$json_file"
    # Step 3: Merubah nama file .json
    mv "$json_file" "${full_suite_path%.side}.json"
    
    jq -c '.testResults[]' "${full_suite_path%.side}.json" | while IFS= read -r test_result; do
 
    echo "Sending $(basename ${full_suite_path%.side}) Result"
       
    # Step 4: Mengekstrak nilai title dan status dari masing-masing test case
    titles_and_statuses=$(echo "$test_result" | jq -r '.assertionResults[] | "\(.title | sub("Running test "; ""))\n\(.status)\n\(if .failureMessages[0] then .failureMessages[0] | split("\n")[0] else " " end)"' | tr -d '"')

    # Step 5: Loop untuk mengirim curl request dengan nilai title dan status yang diekstrak
    while read -r title && read -r status && read -r messages; do

        # Mengirimkan curl request dengan suite_title yang sesuai
        curl -s --request POST \
             --url "$URL" \
             --header "Token: $TOKEN" \
             --header 'accept: application/json' \
             --header 'content-type: application/json' \
             --data "{
                \"case\": {
                    \"title\": \"$title\",
                    \"suite_title\": \"$(basename ${suite_file%.side})\"
                },
                \"status\": \"$status\",
                \"comment\": \"$messages\",
                \"author_id\": \"$AUTHOR_ID\"
            }"
    done <<< "$titles_and_statuses"
done
done
