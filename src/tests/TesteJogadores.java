package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteJogadores {

    public static void main(String[] args) throws InterruptedException {
        String userPath = System.getProperty("user.dir");
        String chromeDriverPath = userPath + "/lib/chromedriver/chromedriver.exe"; //in windows .exe must be included
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        String baseURL = "http://127.0.0.1:5500/";

        WebDriver driver = new ChromeDriver();

        // Inicia o Navegador
        driver.get(baseURL);
        driver.manage().window().maximize();

        // Acessa o cadastro de jogadores
        WebElement btnCadJogadores = driver.findElement(By.linkText("Cadastrar Jogador"));
        btnCadJogadores.click();

        // VALIDAÇÃO DE JOGADORES
        // Valida drop-down
        playersDropdownValidate(driver);
        // Valida Inputs
        playersInputsValidate(driver);

        // Volta pro index e vai para cadastrar time
        Thread.sleep(5000);
        driver.navigate().back();
        WebElement btnCadTime = driver.findElement(By.linkText("Cadastrar Time"));
        btnCadTime.click();

        // VALIDAÇÃO DE TIME
        // Valida drop-down
        timeDropdownValidate(driver);
        // Valida Inputs
        timeInputsValidate(driver);

        // Volta pro index
        Thread.sleep(5000);
        driver.navigate().back();

        // Fecha o Navegador
        Thread.sleep(10000);
        driver.quit();

    }

    public static void playersDropdownValidate(WebDriver driver) {
        //Valida drop-down
        WebElement dropDown = driver.findElement(By.xpath("//*[@id=\"positions\"]"));
        if(dropDown.isDisplayed()) {
            System.out.println("Dropdown está sendo mostrado");
        }
        if (dropDown.isEnabled()) {
            System.out.println("Dropdown está ativo");
        }
        Select dd = new Select(dropDown);
        dd.selectByValue("goleiro");
        if(dd.getFirstSelectedOption().getText().equals("Goleiro")){
            System.out.println("Dropdown contém valor esperado");
        } else {
            System.out.println("Dropdown não contém valor esperado");
        }
    }

    public static void timeDropdownValidate(WebDriver driver) {
        //Valida drop-down
        WebElement dropDown = driver.findElement(By.xpath("//*[@id=\"state\"]"));
        if(dropDown.isDisplayed()) {
            System.out.println("Dropdown está sendo mostrado");
        }
        if (dropDown.isEnabled()) {
            System.out.println("Dropdown está ativo");
        }
        Select dd = new Select(dropDown);
        dd.selectByValue("SP");
        if(dd.getFirstSelectedOption().getText().equals("São Paulo")){
            System.out.println("Dropdown contém valor esperado");
        } else {
            System.out.println("Dropdown não contém valor esperado");
        }
    }

    public static void playersInputsValidate(WebDriver driver) throws InterruptedException {
        // Campos obrigatórios
        WebElement cpfInput = driver.findElement(By.xpath("//*[@id=\"cpf\"]"));
        WebElement nameInput = driver.findElement(By.xpath("//*[@id=\"name\"]"));
        WebElement emailInput = driver.findElement(By.xpath("//*[@id=\"email\"]"));
        WebElement phoneInput = driver.findElement(By.xpath("//*[@id=\"phone\"]"));

        if(cpfInput.isEnabled()) {
            System.out.println("Input cpf está habilitado");
        } else {
            System.out.println("Input cpf não está habilitado");
        }

        if(nameInput.isEnabled()) {
            System.out.println("Input name está habilitado");
        } else {
            System.out.println("Input name não está habilitado");
        }

        if(phoneInput.isEnabled()) {
            System.out.println("Input phone está habilitado");
        } else {
            System.out.println("Input phone não está habilitado");
        }

        if(emailInput.isEnabled()) {
            System.out.println("Input email está habilitado");
        } else {
            System.out.println("Input email não está habilitado");
        }

        // Clica no botão de cadastrar
        WebElement button = driver.findElement(By.xpath("/html/body/main/form/input"));
        Thread.sleep(3000);
        button.click();

        // Textos de erro dos inputs obrigatórios
        String errorTxtCpfInput = driver.findElement(By.id("cpf-error")).getText();
        String expectedCpfErrorTxt = "O campo cpf é obrigatório";

        String errorTxtNameInput = driver.findElement(By.id("name-error")).getText();
        String expectedNameErrorTxt = "O campo nome é obrigatório";

        String errorTxtEmailInput = driver.findElement(By.id("email-error")).getText();
        String expectedEmailErrorTxt = "O campo email é obrigatório";

        String errorTxtPhoneInput = driver.findElement(By.id("phone-error")).getText();
        String expectedPhoneErrorTxt = "O campo telefone é obrigatório";

        if(errorTxtCpfInput.equals(expectedCpfErrorTxt)){
            System.out.println("O texto de cpf vazio está correto: "+errorTxtCpfInput);
        } else {
            System.out.println("O texto de cpf vazio está incorreto: "+errorTxtCpfInput);
        }

        if(errorTxtNameInput.equals(expectedNameErrorTxt)){
            System.out.println("O texto de nome vazio está correto: "+errorTxtNameInput);
        } else {
            System.out.println("O texto de nome vazio está incorreto: "+errorTxtNameInput);
        }

        if(errorTxtEmailInput.equals(expectedEmailErrorTxt)){
            System.out.println("O texto de email vazio está correto: "+errorTxtEmailInput);
        } else {
            System.out.println("O texto de email vazio está incorreto: "+errorTxtEmailInput);
        }

        if(errorTxtPhoneInput.equals(expectedPhoneErrorTxt)){
            System.out.println("O texto de telefone vazio está correto: "+errorTxtPhoneInput);
        } else {
            System.out.println("O texto de telefone vazio está incorreto: "+errorTxtPhoneInput);
        }

    }

    public static void timeInputsValidate(WebDriver driver) throws InterruptedException {
        // Campos obrigatórios
        WebElement codeInput = driver.findElement(By.xpath("//*[@id=\"code\"]"));
        WebElement nameInput = driver.findElement(By.xpath("//*[@id=\"name\"]"));
        WebElement cepInput = driver.findElement(By.xpath("//*[@id=\"cep\"]"));
        WebElement phoneInput = driver.findElement(By.xpath("//*[@id=\"phone\"]"));

        if(codeInput.isEnabled()) {
            System.out.println("Input code está habilitado");
        } else {
            System.out.println("Input code não está habilitado");
        }

        if(nameInput.isEnabled()) {
            System.out.println("Input name está habilitado");
        } else {
            System.out.println("Input name não está habilitado");
        }

        if(phoneInput.isEnabled()) {
            System.out.println("Input phone está habilitado");
        } else {
            System.out.println("Input phone não está habilitado");
        }

        if(cepInput.isEnabled()) {
            System.out.println("Input cep está habilitado");
        } else {
            System.out.println("Input cep não está habilitado");
        }

        // Clica no botão de cadastrar
        WebElement button = driver.findElement(By.xpath("/html/body/main/form/input"));
        Thread.sleep(3000);
        button.click();

        // Textos de erro dos inputs obrigatórios
        String errorTxtCodeInput = driver.findElement(By.id("code-error")).getText();
        String expectedCodeErrorTxt = "O campo codigo é obrigatório";

        String errorTxtNameInput = driver.findElement(By.id("name-error")).getText();
        String expectedNameErrorTxt = "O campo nome é obrigatório";

        String errorTxtEmailInput = driver.findElement(By.id("email-error")).getText();
        String expectedEmailErrorTxt = "O campo email é obrigatório";

        String errorTxtCepInput = driver.findElement(By.id("cep-error")).getText();
        String expectedCepErrorTxt = "O campo cep é obrigatório";

        if(errorTxtCodeInput.equals(expectedCodeErrorTxt)){
            System.out.println("O texto de cpf vazio está correto: "+errorTxtCodeInput);
        } else {
            System.out.println("O texto de cpf vazio está incorreto: "+errorTxtCodeInput);
        }

        if(errorTxtNameInput.equals(expectedNameErrorTxt)){
            System.out.println("O texto de nome vazio está correto: "+errorTxtNameInput);
        } else {
            System.out.println("O texto de nome vazio está incorreto: "+errorTxtNameInput);
        }

        if(errorTxtEmailInput.equals(expectedEmailErrorTxt)){
            System.out.println("O texto de email vazio está correto: "+errorTxtEmailInput);
        } else {
            System.out.println("O texto de email vazio está incorreto: "+errorTxtEmailInput);
        }

        if(errorTxtCepInput.equals(expectedCepErrorTxt)){
            System.out.println("O texto de telefone vazio está correto: "+errorTxtCepInput);
        } else {
            System.out.println("O texto de telefone vazio está incorreto: " + errorTxtCepInput);
        }

    }
}
