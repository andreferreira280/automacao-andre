package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CadastrarPage {
	private WebDriver driver;

	public CadastrarPage(WebDriver driver) {
		this.driver = driver;
	}

	public void preencheNome(String nome) {
		WebElement txtNome = driver.findElement(By.id("firstName"));
		txtNome.sendKeys(nome);
	}

	public void preencheSobrenome(String sobrenome) {
		WebElement txtSobrenome = driver.findElement(By.id("lastName"));
		txtSobrenome.sendKeys(sobrenome);
	}

	public void preencheEmail(String email) {
		WebElement txtEmail = driver.findElement(By.id("email"));
		txtEmail.sendKeys(email);
	}

	public void preencheSenha(String senha) {
		WebElement txtSenha = driver.findElement(By.id("password"));
		txtSenha.sendKeys(senha);
		txtSenha.submit();
	}
}
