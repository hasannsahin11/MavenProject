package MavenProject.Day03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IsDisabled {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        /**
         * 1- Go to: https://the-internet.herokuapp.com/dynamic_controls
         * 2- Locate the enable button
         * 3- Click on the button
         * 4- Verify if it's ENABLED
         * */

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        // <button autocomplete="off" type="button"
        // onclick="swapInput()" fdprocessedid="uf7s7e">Enable</button>

        WebElement enableButton = driver.findElement(By.cssSelector("#input-example>button"));
        enableButton.click();
        Thread.sleep(3000);
        WebElement inputBox = driver.findElement(By.cssSelector("#input-example>input"));

        if (inputBox.isEnabled()){
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

