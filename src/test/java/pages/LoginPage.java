package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void loga(String usuario, String senha) {
		WebElement txtUsuario = driver.findElement(By.id("user_id"));
		txtUsuario.sendKeys(usuario);
		txtUsuario.submit();
		WebElement txtSenha = driver.findElement(By.id("password"));
		txtSenha.sendKeys(senha);
		txtSenha.submit();
	}

	public void logaPrimeiraVez(String usuario, String senha) {
		WebElement txtUsuario = driver.findElement(By.id("user_id"));
		txtUsuario.sendKeys(usuario);
		txtUsuario.submit();
		WebElement txtSenha = driver.findElement(By.id("password"));
		txtSenha.sendKeys(senha);
		txtSenha.submit();
		driver.findElement(By.cssSelector("button[class='ui-button ui-button--primary btn-action']")).click();
		WebElement txtCelular = driver.findElement(By.name("phone_number"));
		txtCelular.sendKeys("11987654321");
}
}
// <button type="button"
// class="ui-button ui-button--primary btn-action">Começar</button>
//<input type="number" name="phone_number" placeholder="" class="ui-form__input">