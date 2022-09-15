package d13_09_2022;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class zadatak2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://s.bootsnipp.com/iframe/WaXlr");

		List<WebElement> zvezdice = driver.findElements(By.xpath("//*[contains(@id , 'rating-star')]"));

		Scanner s = new Scanner(System.in);
		System.out.println("Unesite ocenu: ");
		int ocena = s.nextInt();
		if (ocena < 1) {
			ocena = 1;
		} else if (ocena > 5) {
			ocena = 5;
		}

		zvezdice.get(ocena - 1).click();

		Thread.sleep(5000);
		driver.quit();

	}

}
