package ch.hearc.hememe.tests.newpost;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SansCategorie {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver", "c:/Soft/chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "http://localhost:8080/HE-Meme/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testSansCategorie() throws Exception {
    driver.get("http://localhost:8080/HE-Meme/faces/crud/posts/List.xhtml");
    driver.findElement(By.linkText("Create New Posts")).click();
    driver.findElement(By.id("j_idt23:imageName")).click();
    driver.findElement(By.id("j_idt23:imageName")).clear();
    driver.findElement(By.id("j_idt23:imageName")).sendKeys("test.png");
    driver.findElement(By.id("j_idt23")).click();
    driver.findElement(By.id("j_idt23:title")).click();
    driver.findElement(By.id("j_idt23:title")).clear();
    driver.findElement(By.id("j_idt23:title")).sendKeys("test2");
    driver.findElement(By.id("j_idt23")).click();
    driver.findElement(By.id("j_idt23")).click();
    driver.findElement(By.id("j_idt23")).click();
    driver.findElement(By.linkText("Save")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
