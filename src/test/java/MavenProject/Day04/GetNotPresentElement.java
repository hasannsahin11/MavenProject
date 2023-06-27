package MavenProject.Day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetNotPresentElement {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


        /**
         * Go to the website
         * Click on Start button
         * Verify if the hidden text (Hello World) is displayed
         * */

        driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");

        //<button>Start</button>
        WebElement startButton = driver.findElement(By.cssSelector("#start>button"));
        startButton.click();

        Thread.sleep(5000);

        // <h4>Hello World!</h4>
        WebElement message = driver.findElement(By.id("finish"));
        String hiddenText = message.getText();
        System.out.println(hiddenText);

        Thread.sleep(3000);
        driver.quit();
    }
}
