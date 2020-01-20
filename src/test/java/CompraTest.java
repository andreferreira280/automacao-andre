import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.ComprarPage;
import pages.HomePage;

public class CompraTest {
	private WebDriver driver;
	private HomePage home;

	@Before
	public void inicializa() {
		driver = new ChromeDriver();
		home = new HomePage(driver);
	}

	@Test
	public void PesquisaProduto() {
		home.visita();
//LoginPage lp = home.entrar();
//lp.loga("andreferreira280@gmail.com", "THgr232527");
ComprarPage cp = new ComprarPage(driver);
cp.pesquisa("smart tv");
cp.adicionaProduto(6);

	}
	
	
}
