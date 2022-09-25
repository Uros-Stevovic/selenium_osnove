package d20_09_2022_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TopMenuPage {
	
//	metodu koja vraca WOMEN link iz glavnom menija
//	metodu koja vraca DRESSES link iz glavnom menija
//	metodu koja vraca T-SHIRTS link iz glavnom menija
//	metodu koja vraca podmeni za WOMEN
//	metodu koja vraca podmeni za DRESSES


	private WebDriver driver;
	private WebDriverWait wait;

	public TopMenuPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
	
	public WebElement getWomanButton() {
		return driver.findElement(By.xpath("//*[@title = 'Women']"));
	}
	public WebElement getDressesButton() {
		return driver.findElement(By.xpath("//*[@title = 'Dresses']"));
	}
	public WebElement getTshirtButton() {
		return driver.findElement(By.xpath("//*[@title = 'T-shirts']"));
	}
	
	public WebElement getWomanMenu() {
		return driver.findElement(By.xpath("//*[@class = 'submenu-container clearfix first-in-line-xs']"));
	}
	public WebElement getDressesMenu() {
		return driver.findElement(By.xpath("//*[@class = 'submenu-container clearfix first-in-line-xs']"));
	}
	
	public void getScroolToTShirtElement() {
		new Actions(driver)
        .moveToElement(driver.findElement(By.xpath("//*[@class = 'sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li[3]")))
         .perform();
	}
	public void getScroolToWomenElement() {
		new Actions(driver)
        .moveToElement(driver.findElement(By.xpath("//*[@id = 'block_top_menu']/ul/li[1]")))
         .perform();
	}
	public void getScroolToDressesElement() {
		new Actions(driver)
        .moveToElement(driver.findElement(By.xpath("//*[@id = 'block_top_menu']/ul/li[2]")))
         .perform();
	}
	
}
