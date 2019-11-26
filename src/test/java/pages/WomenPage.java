package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class WomenPage {
	
	private By selectProductSort;
	private By colorSelection;
	private WebDriver driver;
	
	public WomenPage(WebDriver driver) {
		
		this.driver = driver;
		selectProductSort = By.id("selectProductSort");
		colorSelection = By.xpath("//input[@class='color-option  ']");
	}
	
	public void selectOrderByText(String text) {
		
		Select order = new Select(driver.findElement(selectProductSort));
		order.selectByVisibleText(text);
	}
	
	public void selectOrderByIndex(int index) {
		
		Select order = new Select(driver.findElement(selectProductSort));
		order.selectByIndex(index);
	}
	
	public void selectOrderByValue(String value) {
		
		Select order = new Select(driver.findElement(selectProductSort));
		order.selectByValue(value);
	}
	
	public void selectColor(int color) {
		
		List<WebElement> colorElements = driver.findElements(colorSelection);
		
		/*for(int i = 0; i < colorElements.size(); i++) {
			
			System.out.println("Element " + colorElements.get(i).getAttribute("id"));
		}*/
		
		colorElements.get(color).click();
	}
}
