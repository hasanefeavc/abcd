import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


import java.io.ByteArrayInputStream;
import java.io.File;
import java.net.URL;
import java.time.Duration;




public class seleniumalluregoogle {


    private static final Logger LOGGER = LoggerFactory.getLogger(seleniumalluregoogle.class.getName());
    private URL pathResources = seleniumalluregoogle.class.getResource("/files/");

    @Test
    public void googlesearch() throws Exception {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.google.com");


        WebElement searchtext = driver.findElement(By.xpath("//input[@class='gLFyf']"));
        searchtext.sendKeys("andasis");

        searchtext.submit();


        driver.findElement(By.xpath("//h3[@class='LC20lb MBeuO DKV0Md']")).click();

        LOGGER.info("test1");
        ByteArrayInputStream imageAsByteArrayIS = new ByteArrayInputStream(FileUtils.readFileToByteArray(new File(pathResources.getPath() +"/"+ "andasis.png")));
        Allure.addAttachment("Some Screenshot", imageAsByteArrayIS);
    }


    @Test
    public void amazonsearch(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com");


        WebElement searchtext = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchtext.sendKeys("C++ code");

        searchtext.submit();


        driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']")).click();

    }

    @Test
    public void mvnrepositorysearch(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.mvnrepository.com");


        WebElement searchtext = driver.findElement(By.xpath("//input[@id='query']"));
        searchtext.sendKeys("TestNG");

        searchtext.submit();


        driver.findElement(By.xpath("//a[@href='/artifact/org.testng/testng']")).click();

        driver.findElement(By.xpath("//a[@class='vbtn release']")).click();

        driver.findElement(By.xpath("//textarea[@id='maven-a']")).click();

    }


    public URL getPathResources() {
        return pathResources;
    }

    public void setPathResources(URL pathResources) {
        this.pathResources = pathResources;
    }
}
