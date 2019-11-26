package testAuthentication;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.LoginPage;

public class LoginTest {
	
	private WebDriver driver;
	private String txtResult;
	private LoginPage login;
	
	@BeforeMethod
	public void setUp() {
		//Contra que va a interactuar?
		System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
		
		//Generar una instancia de mi objeto webdriver
		driver = new ChromeDriver();//Levanta un brouser de tipo Chrome y genera una sesión
		
		driver.navigate().to("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		
		login = new LoginPage(driver);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();//Se mata una sesión
		driver.quit();//Se cierra el navegador
	}
	
	@Test(description="Verifica si se ingresó un usuario válido", enabled = true)
	public void loginUserExists() {
		
		login.setUserOk("ccolivieri@yahoo.com", "pepe987");
		txtResult = login.getText();
		
		Assert.assertTrue(txtResult.contains("Welcome to your account. Here you can manage all of your personal information and orders"));
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test(description="Verifica si se ingresó un usuario inválido", enabled = true)
	public void loginUserNotExists() {
		
		login.setUserNoOk("ccolivieri@yahoo.com", "pepe986");
		txtResult = login.getAlert();
		
		Assert.assertTrue(txtResult.contains("Authentication failed."));
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
