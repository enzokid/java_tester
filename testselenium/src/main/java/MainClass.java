import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class MainClass {

    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\enzokid\\Documents\\GitHub\\java_tester\\testselenium\\drivers\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("http://en.wikipedia.org");WebElement link = driver.findElement(By.xpath("//li[@id='n-aboutsite']/a"));
        System.out.println(link.getText());
        link.click();



        driver.get("http://en-gb.facebook.com");

        driver.findElement(By.xpath("//div[@class=\"_9o-r\"]/button[2]")).click();


        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("overstill77@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys("commandoSS77");
        driver.findElement(By.xpath("//div[@class=\"_6ltg\"]/button[1]")).submit();


    }

}
