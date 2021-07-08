package tests;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Ent�o;
import cucumber.api.java.pt.Quando;

public class CadastrarFuncionarioValidos {
	
	WebDriver driver;
	
	@Dado("^Acessar a p�gina de cadastro$")
	public void acessar_a_p�gina_de_cadastro() {
		System.setProperty("webdriver.chrome.driver", "c:\\drivers\\chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("http://prjfinalteste-001-site1.ctempurl.com/Home/Exercicio01");
	}

	@Dado("^Informar o nome do Funcion�rio \"([^\"]*)\"$")
	public void informar_o_nome_do_Funcion�rio(String nome) {
		driver.findElement(By.id("Nome")).sendKeys(nome);
	}

	@Dado("^Informar a data de Admiss�o \"([^\"]*)\"$")
	public void informar_a_data_de_Admiss�o(String data) {
		driver.findElement(By.id("DataAdmissao")).sendKeys(data);
	}

	@Dado("^Informar o CPF do Funcion�rio \"([^\"]*)\"$")
	public void informar_o_CPF_do_Funcion�rio(String cpf) {
		driver.findElement(By.id("CPF")).sendKeys(cpf);
	}

	@Dado("^Digitar o Resumo de Atividades \"([^\"]*)\"$")
	public void digitar_o_Resumo_de_Atividades(String resumo) {
		driver.findElement(By.id("ResumoAtividades")).sendKeys(resumo);
	}

	@Quando("^Solicitar o cadastro do funcion�rio$")
	public void solicitar_o_cadastro_do_funcion�rio() {
		driver.findElement(By.xpath("//*[@id=\"btnCadastro\"]")).click();
	}

	@Ent�o("^Sistema informar� a mensagem de sucesso$")
	public void sistema_informar�_a_mensagem_de_sucesso() {
		String mensagem = driver.findElement(By.xpath("//*[@id=\"mensagem\"]")).getText();
	    assertEquals(mensagem, "Funcion�rio cadastrado com sucesso");
	    
	    //evidencias
	    try {
	    	File evidencia = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    	FileUtils.copyFile(evidencia, new File("E:\\marcio_2021\\coti_Informatica\\Teste_Software_Sergio\\projeto_Final\\tarefa1\\evidencias\\tarefa1.png"));
	    }
	    catch(Exception e) {
	    	System.out.println(e.getMessage());
	    }
	}

	@Ent�o("^Sistema informar� que precisam preencher todos os campos$")
	public void sistema_informar�_que_precisam_preencher_todos_os_campos() {
	    
		String NomeBranco = driver.findElement(By.xpath("/html/body/div/div[2]/form/div/div[1]/div[1]/span")).getText();
		String DataBranco = driver.findElement(By.xpath("/html/body/div/div[2]/form/div/div[2]/div[1]/span")).getText();
		String CPFBranco = driver.findElement(By.xpath("/html/body/div/div[2]/form/div/div[1]/div[2]/span")).getText();
		String ResumoBranco = driver.findElement(By.xpath("/html/body/div/div[2]/form/div/div[2]/div[2]/span")).getText();
	    
		//Assert com as mensagens obtida
		assertEquals(NomeBranco, "Informe o nome do funcion�rio.");
		assertEquals(DataBranco, "Informe a data de admiss�o do funcion�rio.");
		assertEquals(CPFBranco, "Informe o cpf do funcion�rio.");
		assertEquals(ResumoBranco, "Informe o resumo de atividades do funcion�rio");
		
		 //evidencias
	    try {
	    	File evidencia = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    	FileUtils.copyFile(evidencia, new File("E:\\marcio_2021\\coti_Informatica\\Teste_Software_Sergio\\projeto_Final\\tarefa1\\evidencias\\tarefa1_Erro.png"));
	    }
	    catch(Exception e) {
	    	System.out.println(e.getMessage());
	    }
	}
}