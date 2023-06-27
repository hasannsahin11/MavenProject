package MavenProject.Day03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IsSelected {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        /**
         * 1- Go to: https://demo.seleniumeasy.com/basic-checkbox-demo.html
         * 2- Locate the check box element
         * 3- Select the check box
         * 4- Verify if it's selected
         * */

        driver.get("https://demo.seleniumeasy.com/basic-checkbox-demo.html");

        WebElement checkBox = driver.findElement(By.id("isAgeSelected"));
        checkBox.click();

        if (checkBox.isSelected()){
            System.out.println("Verification has completed: PASS");
        } else {
            System.out.println("FAIL");
        }


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}
