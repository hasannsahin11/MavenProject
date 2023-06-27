package MavenProject.Day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MoreNavigations {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://demo.seleniumeasy.com/");
        System.out.println("Title of Seleniumeasy page =" + driver.getTitle());

        String expectedTitle = "Selenium Easy - Best Demo website to practice Selenium Webdriver Online";
        String actualTitle = driver.getTitle();

        if (expectedTitle.equals(actualTitle)){
            System.out.println("Verification: PASS");
            System.out.println("actualTitle = " + actualTitle);
        } else {
            System.out.println("Verification: FAIL");
        }

        String teslaURL = "https://www.tesla.com/";
        driver.navigate().to(teslaURL);
        System.out.println("Tesla.com title is = " + driver.getTitle());


        Thread.sleep(2000);
        driver.quit();
    }
}
