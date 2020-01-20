package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ComprarPage {
	private WebDriver driver;

	public ComprarPage(WebDriver driver) {
		this.driver = driver;
	}

	public void pesquisa(String produto) {
		// WebElement txtPesquisa =
		// driver.findElement(By.cssSelector("input[class='nav-search-input']"));
		WebElement txtPesquisa = driver.findElement(By
				.xpath("/html/body/header/div/form/input"));
		txtPesquisa.sendKeys(produto);
		txtPesquisa.submit();
		// WebDriverWait espera = new WebDriverWait(driver, 90);
		// espera.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/main/div[2]/div/aside/section[2]/dl/div/div/div/div/ul/li[3]/a")));
		WebElement fltMaiorPreco = driver
				.findElement(By
						.xpath("/html/body/main/div[2]/div/aside/section[2]/dl/div/div/div/div/ul/li[3]/a"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", fltMaiorPreco);
		WebElement lnkPrimeiroProduto = driver.findElement(By
				.xpath("/html/body/main/div[2]/div/section/ol/li[1]/div/a"));
		executor.executeScript("arguments[0].click();", lnkPrimeiroProduto);
	}

	public void adicionaProduto(int quantidade) {
		if (quantidade != 1) {
			driver.findElement(
					By.xpath("/html/body/main/div/div[2]/div[1]/div[2]/div[1]/form/div[4]/div/div/button"))
					.click();
			System.out.println("clicou em quantidade");
			if (quantidade == 2) {
				driver.findElement(
						By.xpath("/html/body/div[4]/div/div/div/div[2]/div/div[2]/div/div[3]/div/ul/li[2]/button"))
						.click();
				System.out.println("clicou no dois");
			}
			if (quantidade == 3) {
				driver.findElement(
						By.xpath("//*[contains(text(),'3 unidades')]")).click();
				System.out.println("clicou no 3");
			}
			if (quantidade == 4) {
				driver.findElement(
						By.xpath("//*[contains(text(),'4 unidades')]")).click();
				System.out.println("clicou no 4");
			}
			if (quantidade == 5) {
				driver.findElement(
						By.xpath("//*[contains(text(),'5 unidades')]")).click();
				System.out.println("clicou no 5");
			}
			if (quantidade == 6) {
				driver.findElement(
						By.xpath("//*[contains(text(),'6 unidades')]")).click();
				System.out.println("clicou no 6");
			}
			return;
		}
		driver.findElement(
				By.xpath("/html/body/main/div/div[2]/div[1]/div[2]/div[1]/form/div[5]/div[3]/button[2]"))
				.click();
		driver.findElement(By.xpath("//button[contains(text(),'Continuar')]"))
				.click();
	}

	public void finalizarCompra(String nome, String sobrenome, String cpf,
			String endereco, String numero, String cidade, String bairro,
			String cep, String complemento) {
		// elemento para comprar o que está no carrinho
		driver.findElement(
				By.xpath("//*[contains(text(),'Comprar do carrinho'])"))
				.click();
		// elemento para continuar a compra após escolher o tipo de entrega
		driver.findElement(By.xpath("//button[contains(text(),'Continuar')]"))
				.submit();
		// elemento para selecionar a opção residência no tipo de endereço
		driver.findElement(By.cssSelector("input[value='residential']"))
				.click();
		// elemento para submeter o tipo de endereço escolhido
		driver.findElement(By.xpath("//button[contains(text(),'Continuar')]"))
				.submit();
		// elemento para escolher tipo de pagamento boleto
		driver.findElement(By.cssSelector("input[value='TICKET']")).click();
		// elemento para submeter a escolha do tipo de pagamento
		driver.findElement(By.xpath("//button[contains(text(),'Continuar')]"))
				.submit();
		// elemento para preencher o primeiro nome
		driver.findElement(By.id("firstName")).sendKeys(nome);
		// elemento para preencher o campo sobrenome
		driver.findElement(By.id("lastName")).sendKeys(sobrenome);
		// elemento para preencher o campo CPF
		driver.findElement(By.id("docNumber")).sendKeys(cpf);
		// elemento para preencher o campo endereço
		driver.findElement(By.id("street")).sendKeys(endereco);
		// elemento para preencher o campo número do logradouro
		driver.findElement(By.id("streetNumber")).sendKeys(numero);
		// elemento para marcar caso o endereço não possua número
		driver.findElement(By.cssSelector("input[class='ui-checkbox__input"))
				.click();
		// elemento para preencher o campo complemento
		driver.findElement(By.id("additionalInfo")).sendKeys(complemento);
		// elemento para preencher o campo cep
		driver.findElement(By.id("zipCode")).sendKeys(cep);
		// elemento para preencher o campo cidade
		driver.findElement(By.id("city")).sendKeys(cidade);
		// elemento para preencher o campo bairro
		driver.findElement(By.id("colony")).sendKeys(bairro);
		// elemento para submeter a confirmação dos dados para NF
		driver.findElement(By.xpath("//button[contains(text(),'Continuar')]"))
				.submit();
	}
}
// JavascriptExecutor executor = (JavascriptExecutor)driver;
// executor.executeScript("arguments[0].click();", ele);
