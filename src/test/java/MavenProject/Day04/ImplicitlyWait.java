package MavenProject.Day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ImplicitlyWait {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        /**
         * Go to the website
         * Click on Start button
         * Verify if the hidden text (Hello World) is displayed
         * */

        driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");

        //<button>Start</button>
        WebElement startButton = driver.findElement(By.cssSelector("#start>button"));
        startButton.click();

        WebElement hiddenText = driver.findElement(By.id("finish"));
        String text = hiddenText.getText();
        System.out.println(text);


        driver.quit();
    }
}
