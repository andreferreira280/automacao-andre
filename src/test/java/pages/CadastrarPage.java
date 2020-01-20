package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CadastrarPage {
	private WebDriver driver;

	public CadastrarPage(WebDriver driver) {
		this.driver = driver;
	}

	public void preencherCampos(String nome, String sobrenome, String email,
			String senha) {
		WebElement txtNome = driver.findElement(By.id("firstName"));
		WebElement txtSobrenome = driver.findElement(By.id("lastName"));
		WebElement txtEmail = driver.findElement(By.id("email"));
		WebElement txtSenha = driver.findElement(By.id("password"));
		txtNome.sendKeys(nome);
		txtSobrenome.sendKeys(sobrenome);
		txtEmail.sendKeys(email);
		txtSenha.sendKeys(senha);
		txtSenha.submit();
	}
}
