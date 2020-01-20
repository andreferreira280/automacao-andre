package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	private WebDriver driver;

	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void visita() {
			driver.get("https://www.mercadolivre.com.br/");
	}
	
	public CadastrarPage novo() {
		driver.findElement(By.cssSelector("a[data-link-id='registration']")).click();
		return new CadastrarPage(driver);	
	}
	
	public LoginPage entrar() {

		driver.findElement(By.cssSelector("a[data-link-id='login']")).click();
		return new LoginPage(driver);		
	}
}
