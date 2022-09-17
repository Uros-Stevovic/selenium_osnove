package d_15_09_2022;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class zadatak1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

//		Napisati program koji:
//			Ucitava stranicu https://s.bootsnipp.com/iframe/Dq2X
//			Klikce na svaki iks da ugasi obavestenje i proverava da li se nakon klika element obrisao sa stranice i ispisuje odgovarajuce
//			poruke (OVO JE POTREBNO RESITI PETLJOM)
//			POMOC: Brisite elemente odozdo.
//			(ZA VEZBANJE)Probajte da resite da se elemementi brisu i odozgo

		
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.get("https://s.bootsnipp.com/iframe/Dq2X");
		boolean obrisanX = true;
		for (int i = 0; i < 5; i++) {
			driver.findElement(By.xpath("//*[@class='close']")).click();

		}

		try {
			driver.findElement(By.xpath("//*[@class='close']"));
		} catch (Exception e) {
			obrisanX = false;
		}
		if (obrisanX == true) {
			System.out.println("Radnja je uspesno izvrsena");
		} else {
			System.out.println("Radnja nije uspesno izvrsena.");

		}

		Thread.sleep(5000);
		driver.quit();
	}
}
