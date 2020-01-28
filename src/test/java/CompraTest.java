import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
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
		home.visita();
	}

	@Test
	public void deveRetornarProdutoPesquisadoQuandoProdutoForBuscadoPeloUsuario() {
		ComprarPage cp = new ComprarPage(driver);
		cp.pesquisa("smart tv");
		String titlo = driver.getTitle();
		assertTrue(titlo.contains("Smart Tv"));
	}

	@Test
	public void deveFiltrarOsResultadosEmOrdemCrescenteQuandoOUsuarioEscolherFiltrarPeloMenorPreco() {
		ComprarPage cp = new ComprarPage(driver);
		cp.pesquisa("smart tv");
		cp.filtraCompra(2);
		assertTrue(driver.findElement(
				By.xpath("//*[contains(text(),'Menor preço')]")).isEnabled());
	}

	@Test
	public void deveFiltrarOsResultadosEmOrdemDecrescenteQuandoOUsuarioEscolherFiltrarPeloMaiorPreco() {
		ComprarPage cp = new ComprarPage(driver);
		cp.pesquisa("smart tv");
		cp.filtraCompra(3);
		assertTrue(driver.findElement(
				By.xpath("//*[contains(text(),'Maior preço')]")).isEnabled());
	}

	@Test
	public void deveSelecionarOProdutoQuandoOUsuarioClicarNoElementoDoEscolhido() {
		ComprarPage cp = new ComprarPage(driver);
		cp.pesquisa("smart tv");
		cp.escolheProduto();
		assertTrue(driver.getPageSource().contains("Descrição"));
		assertTrue(driver.findElement(
				By.xpath("//*[contains(text(),'Comprar agora')]"))
				.isDisplayed());
	}

	@Test
	public void deveSelecionarQuantidadeQuandoUsuarioEscolherComprarMaisDeUmaUnidade() {
		ComprarPage cp = new ComprarPage(driver);
		cp.pesquisa("smart tv");
		cp.escolheProduto();
		cp.adicionaProduto(2);
		assertTrue(driver.findElement(
				By.xpath("//*[contains(text(),'2 unidades')]")).isEnabled());
	}

	@Test
	public void deveAdicionarProdutosAoCarrinhoQuandoUsuarioSelecionarAdicionarAoCarrinho() {
		ComprarPage cp = new ComprarPage(driver);
		cp.pesquisa("smart tv");
		cp.escolheProduto();
		cp.adicionaProduto(2);
		cp.adicionaAoCarrinho();
		assertTrue(driver.getTitle().contains(
				"Olá! Para adicionar ao carrinho, acesse a sua conta"));
	}

	@Test
	public void deveComprarProdutosQuandoUsuarioAcessarComprarDoCarrinho() {
		ComprarPage cp = new ComprarPage(driver);
		cp.pesquisa("smart tv");
		cp.escolheProduto();
		cp.adicionaProduto(2);
		cp.comprarOQueEstaNoCarrinho();
		assertTrue(driver.getTitle().contains(
				"Olá! Para comprar, acesse a sua conta"));
	}

	@Test
	public void deveFiltrarPorMarcaQuandoUsuarioEscolherUmaMarcaEspecifica() {
		ComprarPage cp = new ComprarPage(driver);
		cp.pesquisa("smart tv");
		cp.filtraMarca("Sony");
	}

	@After
	public void enserra() {
		 driver.close();
	}
}
