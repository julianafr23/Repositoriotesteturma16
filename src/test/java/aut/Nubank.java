package aut;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Nubank {
	String texto;
	WebDriver driver;
	
	@Before
	public void setUp() throws Exception {
		//comando para inserir a rota de navegação no driver
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		
		//comando para chamar o driver dentro da class
		driver= new ChromeDriver();
		driver.get("https://www.4devs.com.br/gerador_de_pessoas");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		 JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		 
		 //aceitar cookie:
		 driver.findElement(By.id("cookiescript_accept")).click();
		 Thread.sleep(5000);
		 
		 //role a tela até o elemento:
		 jsExecutor.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.cssSelector("#bt_gerar_pessoa")));
		 
		 //clicar no botão gerar pessoas
		 driver.findElement(By.cssSelector("#bt_gerar_pessoa")).click();
		 
		 //pegar os dados do 4devs:
		 Thread.sleep(3000);
		 String cpf;
		 cpf=driver.findElement(By.id("cpf")).getText();
		 System.out.println(cpf);
		 
		 String nome;
		 nome = driver.findElement(By.id("nome")).getText();
		 System.out.println(nome);
		 
		 String celular;
		 celular = driver.findElement(By.id("celular")).getText();
		 System.out.println(celular);
		 
		 String email;
		 email = driver.findElement(By.id("email")).getText();
		 System.out.println(email);
		 
		 String confirmaemail;
		 confirmaemail = driver.findElement(By.id("email")).getText();
		 System.out.println(confirmaemail);
		 Thread.sleep(2000);
		 //ir para o site do nubank:
		 driver.get("https://nubank.com.br/");
		 
		 //preencher o número do cpf:
		 driver.findElement(By.name("cpf")).sendKeys(cpf);
		 driver.findElement(By.cssSelector("#short-form > div.sc-ksNGjt.gDytHF > button")).click();
		 
		 //preencher nome
		 driver.findElement(By.id("field-name")).sendKeys(nome);
		 
		 //preencher celular
		 driver.findElement(By.name("phone")).sendKeys(celular);
		 
		 //preencher email
		 driver.findElement(By.name("email")).sendKeys(email);
		 
		 //preencher confirmação de email
		 driver.findElement(By.name("emailConfirmation")).sendKeys(email);
		 Thread.sleep(3000);
		 
		 //confirmar check box
		 driver.findElement(By.cssSelector("#label-acceptedWhatsapp > span.sc-bYWUiG.gaLLqc > svg")).click();
		 driver.findElement(By.cssSelector("#label-accepted > span.sc-bYWUiG.gaLLqc > svg")).click();
		 
		 //confirmar
		 driver.findElement(By.cssSelector("#complete-form-drawer > div > div > div.sc-kxtUkE.jKEmYc > form > div > div.sc-dsKijY.dTZaxR > div > button")).click();
		 
		 Thread.sleep(5000);
		 //texto de confirmação da abertura de conta
		 texto=driver.findElement(By.xpath("//h4[normalize-space()='Informações enviadas']")).getText();
		 System.out.println(texto);
		 
	}

	@After
	public void tearDown() throws Exception {
		

	}

	@Test
	public void test() {
		assertEquals(texto,"Informações enviadas");
		
	}

}
