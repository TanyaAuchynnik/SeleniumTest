package Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public abstract class BaseTest {
  private WebDriver driver;

  protected WebDriver getDriver() {
    return driver;
  }

  protected void getWeb() {
    driver.get("https://www.ikea.com/us/en");
  }

  @BeforeClass
  protected void before() {
    WebDriverManager.chromedriver().setup();
  }

  @BeforeMethod
  protected void beforeTest() {
    driver = new ChromeDriver();
    getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    getWeb();
    getDriver().manage().window().maximize();
  }

  @AfterMethod
  protected void afterTest() {
    getDriver().quit();
  }
}
