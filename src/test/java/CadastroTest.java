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
	}

	@Test
	public void cadastraUsuario() {
		home.visita();
		CadastrarPage cp = home.novo();
		cp.preencherCampos("bob", "lee", "bobly@gmail.com", "123ABc");
	}
}