package d20_09_2022_pages;



import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LayerCartPage {
//	continue shopping dugme
//	proced to checkout dugme
//	element koji vraca atrubute
//	 proizvoda (sa slike je to desno od devojke)
//	element koji cuva quantity
//	(takodje desno od devojke)
//	element koji cuva total price
//	metodu koja ceka da dijalog bude vidljiv
//	metodu koja ceka da dijalog bude nevidljiv


	private WebDriver driver;
	private WebDriverWait wait;

	public LayerCartPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
	
	public void getWaitForDialogToBeVisible() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated
				(By.xpath("//*[@class='layer_cart_cart col-xs-12 col-md-6']")));
	}
	
	public WebElement getContinueShopingButton() {
		return driver.findElement(By.xpath("//*[@title='Continue shopping']"));
	}
	
	public WebElement getProcedToCheckoutButton() {
		return driver.findElement(By.xpath("//*[@title='Proceed to checkout']"));
	}
	
	public WebElement getAtributes() {
		return driver.findElement(By.xpath("//*[@class = 'layer_cart_product_info']"));
	}
	
	public WebElement getQuantity() {
		return driver.findElement(By.xpath("//*[@id = 'layer_cart_product_quantity']"));
	}
	
	public WebElement getTotalPrice() {
		return driver.findElement(By.xpath("//*[@class = 'ajax_block_cart_total']"));
	}
	
	public void getwaitForDialogToBeInvisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated
        		(By.xpath("//*[@class='layer_cart_cart col-xs-12 col-md-6']")));
    }
	
	
	
	
	
	
	
	
	
	
	
	
}
