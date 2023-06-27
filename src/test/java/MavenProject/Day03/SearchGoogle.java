package MavenProject.Day03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchGoogle {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.google.com/");

        //1- Go to google.com
        //2- Locate the search box
        //3 -Send bamboo pen keys to the box
        //4- Get the title pf the new opened page
        //5- Do verification with actual one and expected one


     //   <textarea class="gLFyf" jsaction="paste:puy29d;"
        //   id="APjFqb" maxlength="2048" name="q" rows="1" aria-activedescendant=""
        //   aria-autocomplete="both" aria-controls="Alh6id" aria-expanded="false"
        //   aria-haspopup="both" aria-owns="Alh6id" autocapitalize="off" autocomplete="off"
        //   autocorrect="off" autofocus="" role="combobox" spellcheck="false" title="Search"
        //   type="search" value="" aria-label="Search" data-ved="0ahUKEwiyscm84Nr_AhVoBDQIHfFGAUgQ39UDCAY"></textarea>

        WebElement searchBox = driver.findElement(By.id("APjFqb"));
        String input= "bamboo pen";
        searchBox.sendKeys(input+ Keys.ENTER);


        String expTitle = "bamboo pen - Google Search";
        String actTitle = driver.getTitle();

        if (expTitle.equals(actTitle)){
            System.out.println("Verification has completed: PASS");
        } else {
            System.out.println("Verification has completed: FAIL");
            System.out.println("Actual title is: "+ actTitle);
        }

        Thread.sleep(2000);
        driver.quit();
    }
}
