package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	private WebDriver driver;
	private By infoAccount;
	private By userEmail;
	private By userPasswd;
	private By submit;
	private By login;
	private By alert;
	/*private String email;
	private String passwd;
	private String submitLogin;*/
	
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
		infoAccount = By.className("info-account");
		login = By.className("login");
		userEmail = By.id("email");
		userPasswd = By.id("passwd");
		submit = By.id("SubmitLogin");
		alert = By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li");
	}
	
	public void setUserOk(String email, String pass) {
		
		driver.findElement(login).click();
		driver.findElement(userEmail).sendKeys(email);
		driver.findElement(userPasswd).sendKeys(pass);
		driver.findElement(submit).click();
	}
	
	public void setUserNoOk(String email, String pass) {
		
		driver.findElement(login).click();
		driver.findElement(userEmail).sendKeys(email);
		driver.findElement(userPasswd).sendKeys(pass);
		driver.findElement(submit).click();	
	}
	
	public String getText() {
		
		return driver.findElement(infoAccount).getText();
	}
	
	public String getAlert() {
		
		return driver.findElement(alert).getText();
	}
}
