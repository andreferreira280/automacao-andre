package pages;

import java.util.List;

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
		WebElement txtPesquisa = driver.findElement(By
				.xpath("/html/body/header/div/form/input"));
		txtPesquisa.sendKeys(produto);
		txtPesquisa.submit();
		// WebDriverWait espera = new WebDriverWait(driver, 90);
		// espera.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/main/div[2]/div/aside/section[2]/dl/div/div/div/div/ul/li[3]/a")));
	}

	public void filtraCompra(int option) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		WebElement fltPreco;
		if (option == 1) {
			fltPreco = driver.findElement(By
					.xpath("//*[contains(text(),'Mais relevantes')]"));
			executor.executeScript("arguments[0].click();", fltPreco);
		}
		if (option == 2) {
			fltPreco = driver.findElement(By
					.xpath("//*[contains(text(),'Menor preço')]"));
			executor.executeScript("arguments[0].click();", fltPreco);
		}
		if (option == 3) {
			fltPreco = driver.findElement(By
					.xpath("//*[contains(text(),'Maior preço')]"));
			executor.executeScript("arguments[0].click();", fltPreco);
		}
	}

	public void filtraMarca(String marca) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		List<WebElement> fltMarcas = driver.findElements(By
				.cssSelector("a[class='results-carousel__link']"));
		for (WebElement we : fltMarcas) {
			if (we.getText().contains(marca)) {
				executor.executeScript("arguments[0].click();", we);
			}
		}
	}

	public void escolheProduto() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		List<WebElement> listaDeProdutos = driver.findElements(By
				.cssSelector("a[class='item__info-link item__js-link ']"));
		executor.executeScript("arguments[0].click();", listaDeProdutos.get(0));
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

	public void comprarOQueEstaNoCarrinho() {
		driver.findElement(By.xpath("//*[contains(text(),'Comprar agora')]"))
				.click();
	}

	public void adicionaAoCarrinho() {
		driver.findElement(
				By.xpath("//*[contains(text(),'Adicionar ao carrinho')]"))
				.click();
	}

	public void tipoDeEntrega() {
		driver.findElement(By.xpath("//button[contains(text(),'Continuar')]"))
				.submit();
	}

	public void escolherTipoDeEndereco() {
		driver.findElement(By.cssSelector("input[value='residential']"))
				.click();
		// elemento para submeter o tipo de endereço escolhido
		driver.findElement(By.xpath("//button[contains(text(),'Continuar')]"))
				.submit();
	}

	public void EscolherTipoDePagamento() {
		driver.findElement(By.cssSelector("input[value='TICKET']")).click();
		// elemento para submeter a escolha do tipo de pagamento
		driver.findElement(By.xpath("//button[contains(text(),'Continuar')]"))
				.submit();
	}

	public void preencheNome(String nome) {
		// elemento para preencher o primeiro nome
		driver.findElement(By.id("firstName")).sendKeys(nome);
	}

	public void preencheSobrenome(String sobrenome) {
		// elemento para preencher o campo sobrenome
		driver.findElement(By.id("lastName")).sendKeys(sobrenome);
	}

	public void preencheCpf(String cpf) {
		// elemento para preencher o campo CPF
		driver.findElement(By.id("docNumber")).sendKeys(cpf);
	}

	public void preencheEndereco(String endereco) {
		// elemento para preencher o campo endereço
		driver.findElement(By.id("street")).sendKeys(endereco);
	}

	public void preencheNumero(int numero) {
		if (numero != 0) {
			// elemento para preencher o campo número do logradouro
			driver.findElement(By.id("streetNumber")).sendKeys(
					String.valueOf(numero));
		} else if (numero == 0) {
			// elemento para marcar caso o endereço não possua número
			driver.findElement(
					By.cssSelector("input[class='ui-checkbox__input")).click();
		}
	}

	public void preencheComplemento(String complemento) {
		// elemento para preencher o campo complemento
		driver.findElement(By.id("additionalInfo")).sendKeys(complemento);
	}

	public void preencheCep(String cep) {
		// elemento para preencher o campo cep
		driver.findElement(By.id("zipCode")).sendKeys(cep);
	}

	public void preencheCidade(String cidade) {
		// elemento para preencher o campo cidade
		driver.findElement(By.id("city")).sendKeys(cidade);
	}

	public void preencheBairro(String bairro) {
		// elemento para preencher o campo bairro
		driver.findElement(By.id("colony")).sendKeys(bairro);
	}

	public void enviaDados() {
		// elemento para submeter a confirmação dos dados para NF
		driver.findElement(By.xpath("//button[contains(text(),'Continuar')]"))
				.submit();
	}
}
// JavascriptExecutor executor = (JavascriptExecutor)driver;
// executor.executeScript("arguments[0].click();", ele);
