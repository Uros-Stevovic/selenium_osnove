package d20_09_2022_pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BuyBoxPage {

	private WebDriver driver;
	private WebDriverWait wait;

	public BuyBoxPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	public WebElement getQuantityButton() {
		return driver.findElement(By.xpath("//*[@id='quantity_wanted']"));
	}

	public WebElement getSizeButton() {
		return driver.findElement(By.xpath("//*[@id='uniform-group_1']"));

	}

	public void getWaitForDialogToBeVisible() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@title='M']")));
	}

	public WebElement getChooseSizeButton() {
		return driver.findElement(By.xpath("//*[@title='M']"));

	}

	public WebElement getAddToChartButton() {
		return driver.findElement(By.xpath("//*[@name='Submit']"));
	}

	public WebElement getAddWishListButton() {
		return driver.findElement(By.xpath("//*[@id='wishlist_button']"));

	}

	public WebElement getChooseColourButton(String colour) {

		if (colour.equals("blue")) {
			return driver.findElement(By.xpath("//*[@title='Blue']"));
		} else {
			return driver.findElement(By.xpath("//*[@title='Orange']"));
		}
	}
	
	public void getScroolToElement() {
		WebElement we = driver.findElement(By.xpath("//*[@name='Submit']"));
		 new Actions(driver)
         .scrollToElement(we)
         .perform();
	}
	
	
}
