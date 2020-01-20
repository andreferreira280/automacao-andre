import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
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
	}

	@Test
	public void LogaUsuario() {
		home.visita();
LoginPage lp = home.entrar();
//lp.logaPrimeiraVez("bobly@gmail.com", "123ABc");
lp.loga("andreferreira280@gmail.com", "THgr232527");
	}
}
