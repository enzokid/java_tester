import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MainClass {

    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\enzokid\\Documents\\GitHub\\java_tester\\testselenium\\drivers\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://onoff.ee/televizori-i-domkinoteatr/televizori/#&price=0-6500&onpage=88&list=1");

        List <WebElement> checkboxes;
        checkboxes = driver.findElements(By.xpath("/html/body/div[8]/div/div[1]/nav[2]/form/ul[2]/li[1]/ul//div[@field=\"Производитель\"]"));
        System.out.println(checkboxes.size());

        //if(checkboxes.size()==7)
        //    System.out.println("It's OK!");
        //else System.out.println("Fail!");

        for(WebElement checkbox : checkboxes) {
            checkbox.click();
        }



//      driver.quit();
    }
}

