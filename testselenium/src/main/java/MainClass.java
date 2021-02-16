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

//      driver.get("http://en.wikipedia.org");
//        driver.findElement(By.xpath("//input[@id='searchButton']")).click();


//        driver.get("http://github.com");
//        WebElement button = driver.findElement(By.xpath("//form[@class='mx-auto mx-md-0 col-5-max js-signup-form position-relative z-2']//button"));
//        if(button.getText().equals("Sign up for GitHub")) {
//            System.out.println("Success!!");
//        }
//        else System.out.println("Fail!");

//        button.submit();

//        driver.findElement(By.xpath("//a[@href='/login']")).click();

        driver.get("http://en-gb.facebook.com");

        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("testmail");
        driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys("testpass");
        driver.findElement(By.xpath("//button[@id=\"u_0_j_VD\"]")).click();

        driver.findElement(By.xpath("//button[@id=\"u_0_d_NV\"]")).submit();

//      driver.quit();

    }

}
