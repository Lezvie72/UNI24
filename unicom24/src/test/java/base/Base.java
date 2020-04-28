package base;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.Duration;
import java.util.*;
import java.util.List;

public abstract class Base {

    /**
     * Default timeout for waiting
     */
    private static final int ELEMENT_TIMEOUT_SECONDS = 10;
    private static final int ELEMENT_TIMEOUT_SECONDS_MIN = 5;

    public static SoftAssert sa;


    protected static WebDriver driver;
    public JavascriptExecutor js = (JavascriptExecutor) driver;

    private static boolean isElementPresented(WebElement element) {
        try {
            element.getTagName();
            return true;
        } catch (Exception e) {

        }
        return false;
    }

    /**
     * @param element is element to check
     * @return true i element is visible, otherwise false
     */
    public static Boolean isElementVisible(WebElement element) {
        if (!isElementPresented(element)) {
            return false;
        }

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(ELEMENT_TIMEOUT_SECONDS_MIN));
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Throwable th) {
            return false;
        }
        return true;
    }

    public static void allElementsAreVisible(List<WebElement> elements) {
        for (WebElement webElement : elements) {
            waitForVisibility(webElement);
        }
    }

    protected void typeIntoField(String value, WebElement input) {
        clearField(input);
        input.sendKeys(value);
    }

    protected void scrollTo(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 0);");
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
    }

    public void scrollToTop() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,0);");
    }

    public void waitUntilElementRemove(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(ELEMENT_TIMEOUT_SECONDS));
        wait.until(countOfElementsIsZero(locator));
    }

    private static ExpectedCondition<Boolean> countOfElementsIsZero(By locator) {
        return new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(@Nullable WebDriver driver) {
                List<WebElement>elements = driver.findElements(locator);
                if(elements.size() != 0) {
                    elements = driver.findElements(locator);
                    System.out.println(elements.size());
                    return false;
                }
                return true;
            }
        };
    }

    public void waitForTextChanged(String text, By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(ELEMENT_TIMEOUT_SECONDS));
        wait.until(textNotEquals(text, locator));
    }

    private static ExpectedCondition<Boolean> textNotEquals(String text, By locator) {
        return new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(@Nullable WebDriver driver) {
                WebElement elements = driver.findElement(locator);
                return !elements.getText().equals(text);
            }
        };
    }

    public void click(WebElement element) {
        waitForVisibility(element);
        waitToBeClickable(element);
        element.click();
    }

    public static void waitForVisibility(WebElement element) {
        waitForVisibility(element, ELEMENT_TIMEOUT_SECONDS);
    }

    protected static void waitForVisibility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected static void waitForVisibility(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(ELEMENT_TIMEOUT_SECONDS));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected static void waitForInvisibility(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(ELEMENT_TIMEOUT_SECONDS));
        try {
            wait.until(elementIsNotVisible(element));
        } catch (NoSuchElementException | StaleElementReferenceException e) {
        }
    }

    protected static void waitForInvisibilityOfAllElements(List<WebElement> elements) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(ELEMENT_TIMEOUT_SECONDS));
        try {
            for (WebElement element : elements) {
                wait.until(elementIsNotVisible(element));
            }
        } catch (NoSuchElementException | StaleElementReferenceException e) {
        }
    }

    protected static WebElement waitToBeClickable(By selector) {
        return new WebDriverWait(driver, Duration.ofSeconds(ELEMENT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(selector));
    }

    protected static WebElement waitToBeClickable(WebElement webElement) {
        return new WebDriverWait(driver, Duration.ofSeconds(ELEMENT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public static void waitForPageLoaded(String pagePartialUrl) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(ELEMENT_TIMEOUT_SECONDS));
        wait.until(pageLoaded(pagePartialUrl));
    }

    protected static void waitForText(WebElement element, String text) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(ELEMENT_TIMEOUT_SECONDS));
        wait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    static ExpectedCondition<Boolean> pageLoaded(String pagePartialUrl) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return driver -> (js.executeScript("return window.location.href").toString().contains(pagePartialUrl) &&
                js.executeScript("return document.readyState").equals("complete"));
    }

    static ExpectedCondition<Boolean> elementIsNotVisible(final WebElement element) {
        return driver -> !element.isDisplayed();
    }

    public static void openNewTab() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open();");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }

    public static void switchToTheFirstTab() {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
    }

    public static void switchToTheSecondTab() {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }

    public static void switchToTheThirdTab() {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(2));
    }

    public void openLinkInTheNewTab(WebElement element) {
        String keyOpenNewTab = Keys.chord(Keys.CONTROL, Keys.RETURN);
        element.sendKeys(keyOpenNewTab);
        switchToTheSecondTab();
    }

    public void closeTab() {
        driver.close();
    }

    public void closeSecondTab() {
        switchToTheSecondTab();
        closeTab();
    }

    public static void refreshPage() {
        driver.navigate().refresh();
    }

    public static long folderSize(File directory) {
        long length = 0;
        for (File file : directory.listFiles()) {
            if (file.isFile())
                length += file.length();
            else
                length += folderSize(file);
        }
        return length;
    }

    public static String getFileExtension(File directory) {
        File[] fileList = directory.listFiles();
        String fileName = fileList[0].getName();
        // если в имени файла есть точка и она не является первым символом в названии файла
        if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
            // то вырезаем все знаки после последней точки в названии файла, то есть ХХХХХ.txt -> txt
            return fileName.substring(fileName.lastIndexOf(".") + 1);
            // в противном случае возвращаем заглушку, то есть расширение не найдено
        else return "";
    }

    public void waitForUrlContains(String url) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(ELEMENT_TIMEOUT_SECONDS));
        wait.until(ExpectedConditions.urlContains(url));
    }

    public void waitForUrlEquals(String url) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(ELEMENT_TIMEOUT_SECONDS));
        wait.until(ExpectedConditions.urlToBe(url));
    }

    public void waitForAjaxElementIsVisible(WebElement element) {
        try {
            waitForVisibility(element);
        } catch (NoSuchElementException | StaleElementReferenceException e) {

        }
    }

    public void waitForAllAjaxElementIsVisible(List<WebElement> elements) {
        try {
            allElementsAreVisible(elements);
        } catch (NoSuchElementException | StaleElementReferenceException e) {

        }
    }

    public WebElement waitForAjaxElementIsVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(ELEMENT_TIMEOUT_SECONDS));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        waitForVisibility(element);
        return element;
    }

    public void waitForCountOfAjaxElementsEqualTo(By locator, int count) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(ELEMENT_TIMEOUT_SECONDS));
        wait.until(countOfAjaxElementsEqualTo(locator, count));
    }

    public void waitForCountOfAjaxElementsMoreThan(By locator, int count) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(ELEMENT_TIMEOUT_SECONDS));
        wait.until(countOfAjaxElementsMoreThen(locator, count));
    }

    public static void clickOnAjaxElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(ELEMENT_TIMEOUT_SECONDS));
        wait.until(waitForAjaxElementWasClicked(element));
    }

    private static ExpectedCondition<Boolean> countOfAjaxElementsEqualTo(By locator, int count) {
        return new ExpectedCondition<Boolean>() {
            @Nullable
            @Override
            public Boolean apply(@Nullable WebDriver driver) {
                List<WebElement>elements = driver.findElements(locator);
                if(elements.size() != count) {
                    elements = driver.findElements(locator);
                    System.out.println(elements.size());
                    return false;
                }
                return true;
            }
        };
    }

    private static ExpectedCondition<Boolean> countOfAjaxElementsMoreThen(By locator, int count) {
        return new ExpectedCondition<Boolean>() {
            @Nullable
            @Override
            public Boolean apply(@Nullable WebDriver driver) {
                List<WebElement>elements = driver.findElements(locator);
                if(elements.size() < count) {
                    elements = driver.findElements(locator);
                    System.out.println(elements.size());
                    return false;
                }
                return true;
            }
        };
    }

    private static ExpectedCondition<Boolean> waitForAjaxElementWasClicked(WebElement element) {
        return new ExpectedCondition<Boolean>() {
            @Nullable
            @Override
            public Boolean apply(@Nullable WebDriver driver) {
                try {
                    element.click();
                } catch (NoSuchElementException | StaleElementReferenceException ex) {
                    return false;
                }
                return true;
            }
        };
    }

    public void mouseOver(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }

    public void chromeBrowserBackBtn() {
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ALT);
            robot.keyPress(KeyEvent.VK_LEFT);
            robot.keyRelease(KeyEvent.VK_LEFT);
            robot.keyRelease(KeyEvent.VK_ALT);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public void clearField(WebElement element) {
        element.sendKeys(Keys.CONTROL + "a");
        element.sendKeys(Keys.BACK_SPACE);
    }

    public void testNewClear(String text, WebElement element) {
        while (!element.getAttribute("value").equals(text)) {
            clearField(element);
            typeIntoField(text, element);
        }
    }

    //Метод посимвольного ввода в поле
    public void typeIntoFieldCharByChar(String text, WebElement element) {
        clearField(element);
        char[] strToArray = text.toCharArray();
//        char[] valueToChar = element.getAttribute("value").toCharArray();
//        List<Character>charByInput = new ArrayList<Character>();
        ArrayList<Character> arrayList = new ArrayList<>();

        for(int i=0; i<strToArray.length; i++) {
            element.sendKeys(String.valueOf(strToArray[i]));
            arrayList.add(strToArray[i]);
//            while(!element.getAttribute("value").equals(getStringRepresentation(arrayList))) {
//                element.sendKeys(Keys.BACK_SPACE);
//                element.sendKeys(String.valueOf(strToArray[i]));
//            }
        }
    }

    //Приводит массив Char в нормальную строку
    String getStringRepresentation(ArrayList<Character> list)
    {
        StringBuilder builder = new StringBuilder(list.size());
        for(Character ch: list) {
            builder.append(ch);
        }
        return builder.toString();
    }

    //Метод для специального падения шага
    public static void testFail(String message) {
        Assert.assertTrue(message, 0>5);
    }
}
