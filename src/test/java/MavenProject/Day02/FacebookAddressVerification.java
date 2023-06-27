package MavenProject.Day02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookAddressVerification {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String username = "hasansahin@gmail.com";
        String password = "12345";

        driver.get("https://www.facebook.com/");
        // <input type="text" class="inputtext _55r1 _6luy" name="email" id="email"
        // data-testid="royal_email" placeholder="Email or phone number" autofocus="1"
        // aria-label="Email or phone number" fdprocessedid="4vpe1r">

        WebElement emailInput = driver.findElement(By.id("email"));
        emailInput.sendKeys(username);
        WebElement passwordInput = driver.findElement(By.id("pass"));
        passwordInput.sendKeys(password);

        //<button value="1" class="_42ft _4jy0 _6lth _4jy6 _4jy1 selected _51sy"
        // name="login" data-testid="royal_login_button" type="submit" id="u_0_5_sh"
        // fdprocessedid="i9to9o">Log In</button>

        WebElement logInButton = driver.findElement(By.cssSelector("button[name='login']"));
        logInButton.click();

        Thread.sleep(3000);

        driver.quit();
    }
}
