package browserfactory;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class TestSuite extends Utility {
    String BaseUrl = "https://www.amazon.co.uk/";

    @Before

    public void setUp() {
        openBrowser(BaseUrl);
    }

    @Test
    public void verifyProductList() {
        //accept the cookies
        clickOnElement(By.id("sp-cc-accept"));
        //Type "Dell Laptop" in the search box
        sendTextToElement(By.id("twotabsearchtextbox"), "Dell Laptop");
        // click on search
        clickOnElement(By.id("nav-search-submit-button"));
        // Click on the checkbox brand dell on the left side.
        clickOnElement(By.xpath("//li[@id='p_89/Dell']/descendant::div"));
        //Verify 30 products are displayed with the products name
        List<WebElement> productList = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
        int size = productList.size();
        System.out.println("Total number of products:" + size); //30
        for (WebElement w : productList) {
            System.out.println("List of all products:");
            System.out.println(w.getText()); // this will print all 30 products
        }
    }

    @After
    public void tearDown() {
        //close the browser
        closeBrowser();
    }


}

