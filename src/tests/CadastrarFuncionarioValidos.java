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
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class CadastrarFuncionarioValidos {
	
	WebDriver driver;
	
	@Dado("^Acessar a página de cadastro$")
	public void acessar_a_página_de_cadastro() {
		System.setProperty("webdriver.chrome.driver", "c:\\drivers\\chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("http://prjfinalteste-001-site1.ctempurl.com/Home/Exercicio01");
	}

	@Dado("^Informar o nome do Funcionário \"([^\"]*)\"$")
	public void informar_o_nome_do_Funcionário(String nome) {
		driver.findElement(By.id("Nome")).sendKeys(nome);
	}

	@Dado("^Informar a data de Admissão \"([^\"]*)\"$")
	public void informar_a_data_de_Admissão(String data) {
		driver.findElement(By.id("DataAdmissao")).sendKeys(data);
	}

	@Dado("^Informar o CPF do Funcionário \"([^\"]*)\"$")
	public void informar_o_CPF_do_Funcionário(String cpf) {
		driver.findElement(By.id("CPF")).sendKeys(cpf);
	}

	@Dado("^Digitar o Resumo de Atividades \"([^\"]*)\"$")
	public void digitar_o_Resumo_de_Atividades(String resumo) {
		driver.findElement(By.id("ResumoAtividades")).sendKeys(resumo);
	}

	@Quando("^Solicitar o cadastro do funcionário$")
	public void solicitar_o_cadastro_do_funcionário() {
		driver.findElement(By.xpath("//*[@id=\"btnCadastro\"]")).click();
	}

	@Então("^Sistema informará a mensagem de sucesso$")
	public void sistema_informará_a_mensagem_de_sucesso() {
		String mensagem = driver.findElement(By.xpath("//*[@id=\"mensagem\"]")).getText();
	    assertEquals(mensagem, "Funcionário cadastrado com sucesso");
	    
	    //evidencias
	    try {
	    	File evidencia = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    	FileUtils.copyFile(evidencia, new File("E:\\marcio_2021\\coti_Informatica\\Teste_Software_Sergio\\projeto_Final\\tarefa1\\evidencias\\tarefa1.png"));
	    }
	    catch(Exception e) {
	    	System.out.println(e.getMessage());
	    }
	}

	@Então("^Sistema informará que precisam preencher todos os campos$")
	public void sistema_informará_que_precisam_preencher_todos_os_campos() {
	    
		String NomeBranco = driver.findElement(By.xpath("/html/body/div/div[2]/form/div/div[1]/div[1]/span")).getText();
		String DataBranco = driver.findElement(By.xpath("/html/body/div/div[2]/form/div/div[2]/div[1]/span")).getText();
		String CPFBranco = driver.findElement(By.xpath("/html/body/div/div[2]/form/div/div[1]/div[2]/span")).getText();
		String ResumoBranco = driver.findElement(By.xpath("/html/body/div/div[2]/form/div/div[2]/div[2]/span")).getText();
	    
		//Assert com as mensagens obtida
		assertEquals(NomeBranco, "Informe o nome do funcionário.");
		assertEquals(DataBranco, "Informe a data de admissão do funcionário.");
		assertEquals(CPFBranco, "Informe o cpf do funcionário.");
		assertEquals(ResumoBranco, "Informe o resumo de atividades do funcionário");
		
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