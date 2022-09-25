package d20_09_2022_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HeadrerPage {

	
//	shop phone element - gde je prikazan broj telefona
//	contact us link
//	sign in link

	
	private WebDriver driver;
	private WebDriverWait wait;

	public HeadrerPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
	
	public WebElement getShopPhone() {
		return driver.findElement(By.xpath("//*[@class = 'shop-phone']"));
	}
	
	public WebElement getContactUs() {
		return driver.findElement(By.xpath("//*[@id = 'contact-link']"));
	
	}
	
	public WebElement getSingIn() {
		return driver.findElement(By.xpath("//*[@class = 'login']"));
	}
	
	
}
