package br.com.Andre_dev_ALS.automacaoAmazon.pages;

import static br.com.Andre_dev_ALS.automacaoAmazon.core.DriverFactory.getDriver;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.Andre_dev_ALS.automacaoAmazon.core.BasePage;

public class ProdutoPage extends BasePage {

	public void FazerProcuraDoProduto(String nomeProduto) {
		escrever(By.xpath("//*[@id=\"twotabsearchtextbox\"]"), nomeProduto);
		;
	}

	public void clicarBotaoProcurar() {
		clicarBotao(By.xpath("//*[@id=\"nav-search-submit-button\"]"));
	}

	public List<String> obterNomeProdutoEncontrado() {
		List<WebElement> produtos = getDriver().findElements(By.tagName("h2"));
		List<String> retorno = new ArrayList<String>();

		for (WebElement produto : produtos) {
			retorno.add(produto.getText());
		}
		return retorno;
	}

	public String obterMensagemDeProdutoInexistente() {
		return getDriver().findElement(By.xpath("//span[contains(., 'Nenhum resultado para')]")).getText();
	}
}