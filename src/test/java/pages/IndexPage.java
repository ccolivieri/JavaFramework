package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IndexPage {
	
	//Va a tener elementos que vayamos a usar
	/*
	 * Un link, combos, etc
	 * */
	
	private By womanLink;
	private WebDriver driver;
	
	public IndexPage(WebDriver driver) {
		
		this.driver = driver;
		womanLink = By.linkText("Women");//Instancio el objeto de mi página
	}
	
	public void clickWomenLink() {
		
		WebDriverWait wait = new WebDriverWait(driver, 5);
		WebElement womanButton = wait.until(ExpectedConditions.elementToBeClickable(womanLink));
		//driver.findElement(womanLink).click();
		womanButton.click();
	}
}
