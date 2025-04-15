# hint-WebDriver-Automation

This project contains automated test scripts for the BeautyHaul website using Selenium WebDriver, Java, and Maven. The framework integrates with Qase.io for test management and reporting.

---

## Table of Contents
1. [Getting Started](#getting-started)
2. [Setup](#setup)
3. [How to Run Tests](#how-to-run-tests)
4. [Reporting to Qase.io](#reporting-to-qaseio)
5. [Project Structure](#project-structure)
6. [Key Components](#key-components)
7. [Contributing](#contributing)
8. [License](#license)
9. [Project status](#project-status)


---

## Getting Started

This project is designed for QA engineers to automate test cases for the HINT website. Ensure you have the necessary tools and dependencies installed on your system before proceeding.

---

## Setup

### Prerequisites
1. **Java Development Kit (JDK)**  
   Ensure you have JDK 8 or later installed.  
   Download: [Oracle JDK](https://www.oracle.com/java/technologies/javase-downloads.html)

2. **Maven**  
   Install Apache Maven to manage dependencies.  
   Download: [Maven](https://maven.apache.org/download.cgi)

3. **Browser and WebDriver**
    - Install the latest version of Google Chrome or your preferred browser.
    - Download the compatible browser driver (e.g., ChromeDriver, GeckoDriver).  
      [ChromeDriver](https://chromedriver.chromium.org/downloads)

4. **IDE**  
   Use an IDE like IntelliJ IDEA or Eclipse for editing and running the code.

### Installing the Project
1. Clone the repository:
   ```bash
   git clone https://scm.thincbot.com/hint-of-you/hint-webdriver-automation.git
   cd hint-webdriver-automation

2. Install the dependencies:
   ```bash
   mvn clean install
   ```

---

## How to Run Tests

### Run All Tests
To execute all test scenarios, use:
```bash
mvn clean test
```

### Run Specific Tagged Tests
Run tests with a specific tag (e.g., `@sanityTest`):
```bash
mvn clean test -Dcucumber.filter.tags="@sanityTest"
```

### Run Specific All Tests on Spesific Folder
Run tests with a specific folder (e.g., folder `Register`):
```bash
mvn clean test -Dcucumber.features="src/test/resources/Feature/Sanity/Register"
```

### Run Specific Tests
Run tests with a specific folder (e.g., folder `Register`):
```bash
mvn clean test -Dcucumber.features="src/test/resources/Feature/Sanity/Register/Register-account-when-all-fields-are-empty.feature"
```

### Run Tests and Generate Reports
Run tests and generate reports with a specific tag (e.g., `@sanityTest`):
```bash
mvn clean test verify -Dcucumber.filter.tags="@sanityTest"
```

---

## Generate Reports
After running tests, reports will be generated in the following locations:

- **HTML Report:** `target/report/cucumber-pretty.html`
- **JSON Report:** `target/cucumber/cucumber.json`

---

## Reporting to Qase.io

### Test Case Linking

Use the `@qaseId=<case-id>` tag in your test scenarios to link them to Qase.io test cases.

### Custom Comments

Selenium error logs and stack traces are captured and sent as comments to Qase.io if a test fails.

---

## Project Structure
```plaintext
hint-webdriver-automation/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── base/               # Base classes (e.g., BasePage, BaseTest)
│   │   │   ├── pages/              # Page Object Model (POM) classes
│   │   │   ├── utils/              # Utility classes (e.g., ConfigReader, WaitHelper)
│   │   └── resources/
│   │       └── config.properties   # Project configuration file
│   │
│   ├── test/
│       ├── java/
│       │   ├── stepdefinitions/    # Step definition classes for Cucumber
│       │   ├── runners/            # Test runners
│       │   └── hooks/              # Hooks (e.g., @Before, @After)
│       └── resources/
│           └── features/           # Cucumber feature files
│
├── target/                         # Generated reports and compiled classes
├── pom.xml                         # Maven dependencies and build configuration
└── README.md                       # Project documentation
```

---

## Key Components

### Page Object Model (POM)
- Pages in the `pages/` directory represent UI elements and actions for different pages of the website.

### Step Definitions
- Glue code connecting Cucumber feature files to the implementation in the `stepdefinitions/` directory.

### Hooks
- **@Before:** Executes setup tasks like browser initialization.
- **@After:** Handles post-test tasks like closing the browser and updating Qase.io.

### Reports
- HTML and JSON reports are generated after test execution.
- These reports are also parsed to extract test results and comments for Qase.io.

---

## Contributing

We welcome contributions! To contribute:

1. Fork the repository.
2. Create a feature branch.
3. Commit your changes.
4. Submit a pull request.

## License
For open source projects, say how it is licensed.

## Project status
If you have run out of energy or time for your project, put a note at the top of the README saying that development has slowed down or stopped completely. Someone may choose to fork your project or volunteer to step in as a maintainer or owner, allowing your project to keep going. You can also make an explicit request for maintainers.
