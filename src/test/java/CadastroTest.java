import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.CadastrarPage;
import pages.HomePage;

public class CadastroTest {
	private WebDriver driver;
	private HomePage home;

	@Before
	public void inicializa() {
		driver = new ChromeDriver();
		home = new HomePage(driver);
		home.visita();
	}

	@Test
	public void cadastraUsuarioQuandoTodosOsDadosEstaoCorretos() {
		CadastrarPage cp = home.novo();
		cp.preencheNome("deny");
		cp.preencheSobrenome("lee");
		cp.preencheEmail("denyly@gmail.com");
		cp.preencheSenha("123ABc");
		String texto = driver.getPageSource();
		assertTrue(texto.contains("Você se cadastrou! Entre com o seu e-mail"));
	}

	public void deveSolicitarSenhaNovamenteDuranteOCadastroQuandoAMesmaNaoForDigitada() {
		CadastrarPage cp = home.novo();
		cp.preencheNome("deny");
		cp.preencheSobrenome("lee");
		cp.preencheEmail("denyly@gmail.com");
		String texto = driver.getPageSource();
		assertTrue(texto.contains("Preencha esse dado"));
	}

	public void deveRecusarEmailQuandoForInseridoDadosForaDoFormatoPadraoParaEnderecosDeEmail() {
		CadastrarPage cp = home.novo();
		cp.preencheNome("deny");
		cp.preencheSobrenome("lee");
		cp.preencheEmail("denyly@gmail");
		String texto = driver.getPageSource();
		assertTrue(texto.contains("Utilize o formato nome@exemplo.com"));
	}

}