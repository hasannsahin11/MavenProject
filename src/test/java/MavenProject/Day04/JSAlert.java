package MavenProject.Day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class JSAlert {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        /**
         * Visit this page: https://the-internet.herokuapp.com/javascript_alerts
         * Click on JS Alert
         * Get the Text from Alert
         * Click OK
         * */

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");


        //      JS ALERT
        // <button onclick="jsAlert()">Click for JS Alert</button>
//        WebElement jsAlert = driver.findElement(By.cssSelector("button[onclick='jsAlert()']"));
//        jsAlert.click();
//
//        String jsAlertText = driver.switchTo().alert().getText();
//        System.out.println(jsAlertText);
//
//        driver.switchTo().alert().accept();


        //      JS CONFIRM
//        // <button onclick="jsConfirm()">Click for JS Confirm</button>
//        WebElement jsConfirm = driver.findElement(By.cssSelector("button[onclick='jsConfirm()']"));
//        jsConfirm.click();
//
//        String jsConfirmText = driver.switchTo().alert().getText();
//        System.out.println(jsConfirmText);
//
//        driver.switchTo().alert().accept();


        //    JS PROMPT
// <button onclick="jsPrompt()">Click for JS Prompt</button>
        WebElement jsPrompt = driver.findElement(By.cssSelector("button[onclick='jsPrompt()']"));
        jsPrompt.click();

        driver.switchTo().alert().sendKeys("Hasan Sahin");
        driver.switchTo().alert().accept();

        //<p id="result" style="color:green">You entered: Hasan Sahin</p>

        WebElement promptMessage= driver.findElement(By.id("result"));
        String actualResult = promptMessage.getText();
        String expectedResult = "You entered: Hasan Sahin";

        if (actualResult.equals(expectedResult)){
            System.out.println(actualResult);
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
    }
}
