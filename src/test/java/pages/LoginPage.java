package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void preencheSenha(String senha) {
		WebElement txtSenha = driver.findElement(By.id("password"));
		txtSenha.sendKeys(senha);
		txtSenha.submit();
	}

	public void preencheUsuario(String usuario) {
		WebElement txtUsuario = driver.findElement(By.id("user_id"));
		txtUsuario.sendKeys(usuario);
		txtUsuario.submit();
	}

	public void prencheCelular(String celular) {
		driver.findElement(
				By.cssSelector("button[class='ui-button ui-button--primary btn-action']"))
				.click();
		WebElement txtCelular = driver.findElement(By.name("phone_number"));
		txtCelular.sendKeys(celular);
	}
	
	public void recuperarSenha() {
		driver.findElement(By.xpath("//*[contains(text(),'Não sei a minha senha')]")).click();
		driver.findElement(By.id("rejectGoogle")).click();
		driver.findElement(By.cssSelector("input[type='tel']")).click();
	}
}
// <button type="button"
// class="ui-button ui-button--primary btn-action">Começar</button>
// <input type="number" name="phone_number" placeholder=""
// class="ui-form__input">