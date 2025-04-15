package org.hint;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BasePage {
    public static final int WAIT = 30;
    public static final int PAUSE = 3;
    public static WebDriver driver;

    public static String email;
    public static String password;
    public static String phone;
    public static String orderID;
    public static String engraveLetter;

    public static String BASE_URL = "https://hintofyou.playbybeautyhaul.com/en/";

    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickCenter(WebElement e) {
        Actions actions = new Actions(driver);
        int elementX = e.getLocation().getX() + e.getSize().getWidth() / 2;
        int elementY = e.getLocation().getY() + e.getSize().getHeight() / 2;
        actions.moveToElement(e, elementX, elementY).perform();
        e.click();
    }

    public void click(WebElement e) {
        waitForElementVisible(e);
        waitForElementClickable(e);
        e.click();
    }

    public void doubleClick(WebElement e) {
        waitForElementVisible(e);
        waitForElementClickable(e);
        new Actions(driver)
                .doubleClick(e)
                .perform();
    }

    public void clickByCoordinate(WebElement e) {
        int a = e.getLocation().getX();
        int b = e.getLocation().getY();
        System.out.println("location X : " + a);
        System.out.println("location Y : " + b);
        Actions actions = new Actions(driver);
        actions.moveByOffset(a, b).click().build().perform();
    }

    public void zoomInOut(String zoomLevel) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.body.style.zoom='" + zoomLevel + "'");
    }

    public void waitForElementVisible(WebElement e) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT));
        wait.until(ExpectedConditions.visibilityOf(e));
    }

    public void waitForElementClickable(WebElement e) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT));
        wait.until(ExpectedConditions.elementToBeClickable(e));
    }

    public boolean waitForElementDisappear(WebElement e) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT));
        boolean isElementNotPresent = wait.until(ExpectedConditions.invisibilityOf(e));
        if (isElementNotPresent) {
            System.out.println("Element is not present.");
            return true;  // Return true when the element is not present
        } else {
            System.out.println("Element is present.");
            return false;  // Return false when the element is present
        }
    }

    public void sendKeys(WebElement e, String txt) {
        waitForElementVisible(e);
        e.sendKeys(txt);
    }

   //new method for By element which for relocated element then interact with WebElement
    public static void newSendKeys(By locator, String value) {
        for (int attempt = 0; attempt < 3; attempt++) {
            try {
                Thread.sleep(500);
                WebElement element = driver.findElement(locator); // Locate dynamically
                element.sendKeys(value); // Interact
                break; // Exit loop on success
            } catch (StaleElementReferenceException e) {
                System.out.println("Attempt " + attempt + ": Element is stale, retrying...");
            } catch (InterruptedException e) {
                System.out.println("Thread was interrupted during sleep: " + e.getMessage());
                Thread.currentThread().interrupt(); // Preserve the interrupt status
                break; // Exit loop if interrupted
            }
        }
    }

    public static void newClick(By locator) {
        for (int attempt = 0; attempt < 3; attempt++) {
            try {
                Thread.sleep(500);
                WebElement element = driver.findElement(locator); // Locate dynamically
                element.click(); // Perform the click
                break; // Exit loop on success
            } catch (StaleElementReferenceException e) {
                System.out.println("Attempt " + attempt + ": Element is stale, retrying...");
            } catch (InterruptedException e) {
                System.out.println("Thread was interrupted during sleep: " + e.getMessage());
                Thread.currentThread().interrupt(); // Preserve the interrupt status
                break; // Exit loop if interrupted
            }
        }
    }


    public void newWaitForElementVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)); // Use `visibilityOfElementLocated` for By
    }

    public void newWaitForElementClickable(By e) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT));
        wait.until(ExpectedConditions.elementToBeClickable(e));
    }

    public boolean newIsDisplayed(By e) {
        newWaitForElementVisible(e);
        WebElement element = driver.findElement(e); // Find the element dynamically
        return element.isDisplayed(); // Call isDisplayed() on WebElement    }
    }

    public void newScrollIntoView(By locator) {
        // Wait for the element to be visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

        // Execute JavaScript to scroll the element into view
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void newScrollToElement(By locator) {
        // Locate the element dynamically using the By locator
        WebElement element = driver.findElement(locator);

        // Execute JavaScript for smooth scrolling with block positioning
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);

        // Optionally, wait until the element is visible
        newWaitForElementVisible(locator);
    }

    public String getText(WebElement e) {
        return e.getText();
    }

    public boolean isDisplayed(WebElement e) {
        waitForElementVisible(e);
        return e.isDisplayed();
    }

    public void scrollIntoView(WebElement e) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(false);", e);
        waitForElementVisible(e);
    }

    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
    }

    public void clear(WebElement e) {
        waitForElementClickable(e);
        click(e);
        e.clear();
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }

    public void back() {
        driver.navigate().back();
    }

    public void forward() {
        driver.navigate().forward();
    }

    //switch tab berdasarkan urutan tab
    public void switchToWindow(int index) {
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        System.out.println("Window Handles: " + tabs);
        driver.switchTo().window(tabs.get(index));
        System.out.println("Switched to tab" + index);
    }

    public void openNewTab(String newTabUrl) {
        ((JavascriptExecutor) driver).executeScript("window.open(arguments[0], '_blank');", newTabUrl);
    }

    public void inputURL(String URL) {
        driver.get(URL);
    }

    public void inputChar(WebElement e, String charKeyboard) {
        Actions actions = new Actions(driver);
        actions.sendKeys(e, charKeyboard)
                .perform();
    }

    //tag must be select
    public void selectByVisibleText(WebElement e, String visibleText) {
        Select sort = new Select(e);
        sort.selectByVisibleText(visibleText);
    }

    public void selectByIndex(WebElement e, int index) {
        Select sort = new Select(e);
        sort.selectByIndex(index);
    }


    // Method to switch to parent frame
    public void switchToParentFrame() {
        driver.switchTo().parentFrame();
    }

    // Method to switch to frame by index
    public void switchToFrame(int index) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(index));
    }

    public void switchToFrame(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
    }

    public void switchIntoFrame(WebElement element){
        Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(WAIT))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);

        fluentWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
    }

    // Method to switch back to the default content
    public static void switchToDefaultContent() {
        // Create a FluentWait instance with custom timeout and polling
        Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(WebDriverException.class);

        // Use FluentWait to wait for the document to be fully loaded
        fluentWait.until(webDriver -> ((JavascriptExecutor) webDriver)
                .executeScript("return document.readyState").equals("complete"));

        // Now switch to the default content after confirming page load
        driver.switchTo().defaultContent();
    }


    public void directToElement(WebElement e) {
        Actions action = new Actions(driver);
        action.moveToElement(e).build().perform();
        action.click();
    }

    public void dragAndDrop(WebElement elementStart, WebElement elementFinish) {
        new Actions(driver)
                .dragAndDrop(elementStart, elementFinish)
                .perform();
    }

    public void dragAndDropByCoordinate(WebElement elementStart, WebElement elementFinish) {
        Rectangle start = elementStart.getRect();
        Rectangle finish = elementFinish.getRect();
        new Actions(driver)
                .dragAndDropBy(elementStart, finish.getX() - start.getX(), finish.getY() - start.getY())
                .perform();
    }

    public void getCoordinate(WebElement e) {
        Point location = e.getLocation();
        int x = location.getX();
        int y = location.getY();
        System.out.println("coordinate X =" + x + "coordinate Y =" + y);
    }

    public void keyDown(String charKeyboard) {
        new Actions(driver)
                .keyDown(Keys.SHIFT)
                .sendKeys(charKeyboard)
                .perform();
    }

    public void inputCharOnKeyboard(String inputKeys) {
        new Actions(driver)
                .sendKeys(inputKeys)
                .perform();
    }

    public void alertDismiss() {
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    public void acceptAlert() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public void getTextAlert() {
        Alert alert = driver.switchTo().alert();
        String text = alert.getText();
        alert.dismiss();
    }

    public void slide(WebElement slider, int x, int y) {
        Actions actions = new Actions(driver);
        actions.moveToElement(slider, x, y).perform();
        System.out.println("Element already slide to x : " + x + " y : " + y);
    }

    public void wait3second(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(PAUSE));
    }

    public void pause3second(){
        try {
            Thread.sleep(PAUSE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

//    public void waitUntil(ExpectedCondition<WebElement> conditions, Integer timeout) {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
//        wait.until(conditions);
//    }

    private void waitUntilCondition(ExpectedCondition condition, String timeoutMessage, Integer timeout) {
//        WebDriverWait wait = new WebDriverWait(driver, timeout);
//        wait.withMessage(timeoutMessage);
//        wait.until(condition);
        //int timeout

        // Convert the timeout from seconds to Duration
        Duration timeoutDuration = Duration.ofSeconds(timeout);

        // Pass the Duration to WebDriverWait
        WebDriverWait wait = new WebDriverWait(driver, timeoutDuration);
        wait.withMessage(timeoutMessage);
        wait.until(condition);
    }

    public void forLoading(){
        ExpectedCondition<Object> condition = ExpectedConditions.jsReturnsValue("return document.readyState==\"complete\";");
        String timeoutMessage = "Page didn't load after " + Integer.toString(WAIT) + " seconds.";
        waitUntilCondition(condition, timeoutMessage, WAIT);
    }

    public void forElementToBeDisplayed(WebElement webElement, String webElementName){
        ExpectedCondition<WebElement> condition = ExpectedConditions.visibilityOf(webElement);
        String timeoutMessage = webElementName + " wasn't displayed after " + Integer.toString(WAIT) + " seconds.";
        waitUntilCondition(condition, timeoutMessage, WAIT);
    }

    public void forPresenceOfElements(By elementLocator, String elementName){
        ExpectedCondition<List<WebElement>> condition = ExpectedConditions.presenceOfAllElementsLocatedBy(elementLocator);
        String timeoutMessage = elementName + " elements were not displayed after " + Integer.toString(WAIT) + " seconds.";
        waitUntilCondition(condition, timeoutMessage, WAIT);
    }

    public void assertMayContainAlphabetAndSpaceChar(By e, String fieldName) {
        // Wait for the element to be visible
        newWaitForElementVisible(e);

        // Dynamically locate the WebElement
        WebElement element = driver.findElement(e);

        // Assert that the error label is displayed
        Assert.assertTrue(fieldName + " field error label is not displayed!", element.isDisplayed());

        // Assert that the text matches the expected message
        String expectedErrorMessage = "May only contain alphabetical and space characters.";
        String actualErrorMessage = element.getText();
        Assert.assertEquals("Error message for " + fieldName + " does not match!", expectedErrorMessage, actualErrorMessage);
    }

    public void assertRequiredField(By e, String fieldName) {
        // Wait for the element to be visible
        newWaitForElementVisible(e);

        // Locate the element dynamically using the By locator
        WebElement element = driver.findElement(e);

        // Assert that the error label is displayed
        Assert.assertTrue(fieldName + " field error label is not displayed!", element.isDisplayed());

        // Assert that the text matches the expected message
        String expectedErrorMessage = "Required field.";
        String actualErrorMessage = element.getText();
        Assert.assertEquals("Error message for " + fieldName + " does not match!", expectedErrorMessage, actualErrorMessage);
    }

}