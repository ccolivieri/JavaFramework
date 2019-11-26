package testsProductos;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import helpers.Helpers;
import pages.IndexPage;
import pages.WomenPage;

public class WomenSeach {
	
	private WebDriver driver;
	private Helpers helper = new Helpers();
	private IndexPage indexPage;
	private WomenPage womenPage;
	
	@BeforeMethod
	public void setUp() {
				
		//Contra que va a interactuar?
		System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
		
		//Generar una instancia de mi objeto webdriver
		driver = new ChromeDriver();//Levanta un brouser de tipo Chrome y genera una sesión
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.navigate().to("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		
		indexPage = new IndexPage(driver);
		womenPage = new WomenPage(driver);
		indexPage.clickWomenLink();
	}
	
	@AfterMethod
	public void tearDown() {
		//helper.waitForTime(5000); NO HACE FALTA
		driver.close();//Se mata una sesión
		driver.quit();//Se cierra el navegador
	}
	
	@Test(description = "Woman seach by stock", enabled = false)
	public void womanSearchByStock() {
			
		womenPage.selectOrderByText("In stock");

	}
	
	@Test(description = "Woman search by reference", enabled = false)
	public void womanSearchByReference() {

		womenPage.selectOrderByValue("reference:asc");
	}
	
	@Test(description = "Woman search by price lower first", enabled = false)
	public void womanSearchByPriceLowerFirst() {
		
		womenPage.selectOrderByIndex(1);

	}
	
	@Test(description = "See if elements are located", enabled = false)
	public void seeColorChecksLocated() {
		Reporter.log("Voy a seleccionar el color 3");
		womenPage.selectColor(3);
		Reporter.log("Ya seleccioné el color 3");
	}
}
