import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class testButtons {
    private WebDriver driver;
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void testPageUI(){

        driver.get("https://demoqa.com/elements");
        driver.findElement(By.xpath("//span[text()='Buttons']")).click();
        driver.findElement(By.xpath("//button[text()='Click Me']")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("#dynamicClickMessage")).getText(), "You have done a dynamic click", "Wrong URL");
    }
    @Test
    public void testAdd(){
        driver.get("https://demoqa.com/webtables");

        driver.findElement(By.cssSelector("#addNewRecordButton")).click();
        driver.findElement(By.cssSelector("#firstName")).sendKeys("Alex");
        driver.findElement(By.cssSelector("#lastName")).sendKeys("Shevchenko");
        driver.findElement(By.cssSelector("#userEmail")).sendKeys("email@ukr.com");
        driver.findElement(By.cssSelector("#age")).sendKeys("24");
        driver.findElement(By.cssSelector("#salary")).sendKeys("2400");
        driver.findElement(By.cssSelector("#department")).sendKeys("Analituk");
        driver.findElement(By.cssSelector("#submit")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]/div[1]/div[2]/div[4]/div/div[1]")).getText(), "Alex", "Wrong URL");

        driver.findElement(By.xpath("//*[@id=\"edit-record-4\"]/svg/path")).click();
        driver.findElement(By.cssSelector("#firstName")).sendKeys("Oleg");
        driver.findElement(By.cssSelector("#submit")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"edit-record-4\"]/svg/path")).getText(), "Oleg", "Wrong URL");
    }
    @AfterMethod
    public void cleanUp(){
        driver.close();
        driver.quit();
    }
}
