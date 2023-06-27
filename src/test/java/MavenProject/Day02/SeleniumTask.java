package MavenProject.Day02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.print.DocFlavor;

public class SeleniumTask {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


        driver.get("https://demo.seleniumeasy.com/basic-first-form-demo.html");
        WebElement message = driver.findElement(By.id("user-message"));
        message.sendKeys("Hello World");
        WebElement showMessageButton = driver.findElement(By.cssSelector("button[class='btn btn-primary']"));
        showMessageButton.click();

        WebElement result = driver.findElement(By.id("display"));
        String displayedMessage = result.getText();
        System.out.println(displayedMessage);

        String expectedResult = "Hello World";
        String actualResult = result.getText();

        if (expectedResult.equals(actualResult)){
            System.out.println("Verification has completed: PASS");
        } else {
            System.out.println("Verification has completed: FAIL");
        }

        //// TASK

        int num1 = 9;
        int num2 = 8;

        WebElement value1 = driver.findElement(By.id("value1"));
        value1.sendKeys(Integer.toString(num1));
        WebElement value2 = driver.findElement(By.id("value2"));
        value2.sendKeys(Integer.toString(num2));
        WebElement getTotal = driver.findElement(By.cssSelector("button[onclick='return total()']"));
        getTotal.click();
        WebElement displayedValue = driver.findElement(By.id("displayvalue"));
        int expectedValue = 17;
        System.out.println(displayedValue.getText());

        if (expectedValue == Integer.parseInt(displayedValue.getText())){
            System.out.println("Verification has completed: PASS");
        } else {
            System.out.println("Verification has FAILED");
        }

        Thread.sleep(3000);
        driver.quit();
    }
}
