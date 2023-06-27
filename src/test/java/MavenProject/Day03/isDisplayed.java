package MavenProject.Day03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class isDisplayed {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        /**
         * 1- Go to: https://the-internet.herokuapp.com/dynamic_loading/1
         * 2- Locate Start Button
         * 3- Click the button
         * 4- Verify if the hidden text is displayed
         * */

        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //<div id="start">
        //    <button>Start</button>
        //  </div>

        WebElement startButton = driver.findElement(By.cssSelector("#start>button"));
        startButton.click();

        //<div id="finish" style="">
        //    <h4>Hello World!</h4>
        //  </div>

        WebElement hiddenText = driver.findElement(By.cssSelector("#finish>h4"));

        System.out.println("Before Sleep: "+ hiddenText.isDisplayed());

        Thread.sleep(5000);

        if (hiddenText.isDisplayed()){
            System.out.println("Verification has completed: PASS");
        } else {
            System.out.println("FAIL");
        }

        System.out.println("After Sleep: "+ hiddenText.isDisplayed());


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();

    }
}
