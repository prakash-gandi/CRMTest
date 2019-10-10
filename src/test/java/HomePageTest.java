import com.oracle.qa.base.TestBase;
import com.oracle.qa.pages.RediffHomePage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {
    RediffHomePage homepage;

    public HomePageTest() {
        super();
    }

    @BeforeMethod
    public void setup() {
        initialization();
        homepage = new RediffHomePage();
    }

    @Test
    public void validateTitle() {
        String title = homepage.validateTitle();
        Assert.assertEquals(title, "Rediff.com: News | Rediffmail | Stock Quotes | Shopping");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
