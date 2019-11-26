package testsProductos;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import helpers.Helpers;
import pages.IndexPage;
import pages.WomenPage;

public class SearchItemsTest {
	
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
		
		driver.navigate().to("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		
		indexPage = new IndexPage(driver);
		womenPage = new WomenPage(driver);
		indexPage.clickWomenLink();
	}
	
	@AfterMethod
	public void tearDown() {
		helper.waitForTime(5000);
		driver.close();//Se mata una sesión
		driver.quit();//Se cierra el navegador
	}
	
	@Test(description="CP_0002", enabled = false)
	public void clickWomen() {
		
		//driver.findElements(By.tagName("img"));
		List<WebElement> myDivs = driver.findElements(By.tagName("div"));
		
		//Si necesito el 3er elemento de mi lista de Divs
		myDivs.get(2).click();
	}
	
	//Cada método va a tener una prueba, pero puede que no sea tan así
	@Test(description="CP_0001", enabled = false)
	public  void searchNoResults() {
		
		/*
		 * Busco los elementos por id o name
		 * */
		driver.findElement(By.id("search_query_top")).sendKeys("something");
		driver.findElement(By.name("submit_search")).click();
		
		/*Forma de buscar un elemento donde tengo poca info para encontrarlo, es decir cuando tengo una estructura
		 * como ésta:
		 * <p class="alert alert-warning" 
				No results were found for your search&nbsp; "something"
		   </p>	
		   Y por esto no tengo id ni name
		 * Puedo buscarlo a través del XPath
		 * */
		String textResult = driver.findElement(By.xpath("//*[@id=\"center_column\"]/p")).getText();
		/*Si alguien cambia algo de lugar, el Xpath va a fallar.
		 * */
		
		//Assertions (verificaciones). TestNg es quien nos va a decir si la prueba pasó o falló
		Assert.assertTrue(textResult.contains("No results were found for your search"), "Se esperaba el texto: No results were found for your search " + textResult);
		
		//Otra forma de hacerlo:
		//driver.findElement(By.cssSelector("p[class = 'alert alert-warning']"));
				
		helper.waitForTime(5000);
	}
	
	
}
