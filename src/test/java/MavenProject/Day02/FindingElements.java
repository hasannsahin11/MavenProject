package MavenProject.Day02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindingElements {
    public static void main(String[] args) throws InterruptedException {
        // set up the browser driver (Selenium gonna knock the door of browser driver (chrome driver))
        WebDriverManager.chromedriver().setup();

        // to open the browser
        WebDriver driver = new ChromeDriver();

        driver.get("https://test.mersys.io/");   // get() waits until the page is loaded
        Thread.sleep(2000);
        driver.navigate().to("https://www.facebook.com/");  // navigate() doesn't wait for the page to load
        Thread.sleep(2000);
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();

        // find the webelement on facebook page (Connect with friends and the world around you on Facebook.)
        WebElement sloganText = driver.findElement(By.className("_8eso"));
        String expSloganText = "Connect with friends and the world around you on Facebook.";
        String actSloanText = sloganText.getText();

        if (expSloganText.equals(actSloanText)){
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("Actual Slogan Text Is: " + actSloanText);
        }

        Thread.sleep(2000);

        driver.quit();
    }
}
