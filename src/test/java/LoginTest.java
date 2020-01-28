import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.HomePage;
import pages.LoginPage;

public class LoginTest {
	private WebDriver driver;
	private HomePage home;

	@Before
	public void inicializa() {
		driver = new ChromeDriver();
		home = new HomePage(driver);
		home.visita();
	}

	@Test
	public void deveLogarUsuarioQuandoForInseridosDadosCorretamente() {
		LoginPage lp = home.entrar();
		lp.preencheUsuario("bobly@gmail.com");
		lp.preencheSenha("123ABc");
		String titulo = driver.getTitle();
		assertTrue(titulo.contains("Validação de identidade"));
	}

	@Test
	public void deveRecusarLoginQuandoSenhaEstiverIncorreta() {
		LoginPage lp = home.entrar();
		lp.preencheUsuario("bobly@gmail.com");
		lp.preencheSenha("123ABc");
		String text = driver.getPageSource();
		assertTrue(text.contains("Revise a sua senha."));
	}

	@Test
	public void deveRecuzarLoginQuandoEmailEstiverIncorreto() {
		LoginPage lp = home.entrar();
		lp.preencheUsuario("boblyy@gmail.com");
		String text = driver.getPageSource();
		assertTrue(text.contains("Revise o seu e-mail ou usuário."));
	}

	@Test
	public void deveEnviarEmailParaRecuperarSenhaQuandoForInformadoEmail() {
		LoginPage lp = home.entrar();
		lp.preencheUsuario("bobly@gmail.com");
lp.recuperarSenha();
	}

	@After
	public void enserra() {
		 driver.close();
	}
}
