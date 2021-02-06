import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class MainClass {

    public static void main (String[] args){
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\enzokid\\Documents\\GitHub\\java_tester\\testselenium\\drivers\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.manage().window().setSize(new Dimension(900, 500));

        driver.get("https://www.google.com/");
        driver.navigate().to("http://seleniumhq.org");
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();

        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        driver.get("http://en.wikipedia.org");
        WebElement link = driver.findElement(By.linkText("Log in"));
        WebElement link2 = driver.findElement(By.partialLinkText("Donate"));
        WebElement link3 = driver.findElement(By.name("search"));

        driver.quit();

    }

}
