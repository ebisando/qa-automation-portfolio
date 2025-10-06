import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertTrue;

public class scenario1 {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.google.com");
    }
    @Test
    public void testGoogleSearch() {
        assertTrue(driver.findElement(By.className("gLFyf")).isDisplayed());
        assertTrue(driver.findElement(By.className("lnXdpd")).isDisplayed()); //logo is visible
        driver.findElement(By.className("gLFyf")).sendKeys("QA engineer");
        // driver.findElement(By.className("gLFyf")).submit();
        // assertTrue(driver.getTitle().toLowerCase().contains("qa engineer"));
    }

    @After
    public void tearDown(){
        driver.quit();
    }    

}

