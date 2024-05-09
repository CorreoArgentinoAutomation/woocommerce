package pages;

import helpers.Helper;
import org.checkerframework.checker.calledmethods.qual.EnsuresCalledMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

public class Ecommerce {
    private WebDriver driver;

    //webelements del dashboard

    private By inputUsuario;
    private By inputPassword;
    private By btnLogin;
    private By lblCorreo;
    private By lblEcommerce;

    //webelements del ecommerce
    private By btnAgregarAcarrito;
    private By btnVerCarrito;
    private By lblCalcularEnvio;
    private By inputCiudadEnvio;
    private By inputCPEnvio;
    private By btnActualizarDatosEnvio;
    private By btnFinalizarCompra;
    private By btnRealizarPedido;

    //webelements del miCorreo


    public Ecommerce(WebDriver driver) {
        this.driver = driver;
        //dashboard
        inputUsuario = By.xpath("//input[@id='user_login']");
        inputPassword = By.xpath("//input[@id='user_pass']");
        btnLogin = By.xpath("//input[@id='wp-submit']");
        lblCorreo = By.xpath("//div[@class='wp-menu-name' and contains(text(),'Correo')]");;
        lblEcommerce = By.xpath("//li[@id='wp-admin-bar-site-name']");;
        //ecommerce
        btnAgregarAcarrito = By.xpath("//button[@type='submit']");
        btnVerCarrito = By.xpath("//a[contains(text(),'Ver') and @tabindex='1']");
        lblCalcularEnvio = By.xpath("//a[contains(text(),'Calcular')]");
        inputCiudadEnvio = By.xpath("//input[@id='calc_shipping_city']");
        inputCPEnvio = By.xpath("//input[@id='calc_shipping_postcode']");
        btnActualizarDatosEnvio = By.xpath("//p/button[@type='submit']");
        btnFinalizarCompra = By.xpath("//a[contains(text(),'Fin')]");
        btnRealizarPedido = By.xpath("//button[@type='submit' and contains(text(),'Realizar')]");
        //micorreo


    }
    public void metodoE2E(){
        //WebDriver driver = new ChromeDriver();
        //dashboard
        Helper helper = new Helper(driver);
        driver.findElement(inputUsuario).click();
        helper.sleepSeconds(1);
        driver.findElement(inputUsuario).sendKeys("giulliana123@yopmail.com");
        helper.sleepSeconds(1);
        driver.findElement(inputPassword).click();
        helper.sleepSeconds(1);
        driver.findElement(inputPassword).sendKeys("Correo.1234");
        helper.sleepSeconds(1);
        driver.findElement(btnLogin).click();
        helper.sleepSeconds(3);
        driver.findElement(lblCorreo).click();
        helper.sleepSeconds(2);
        driver.findElement(lblEcommerce).click();
        helper.sleepSeconds(8);
        //ecommerce

        // los artículos a elegir se repiten por toda la page, así que hay que indexarlos para que el driver interprete cual clickear.
        List<WebElement> elementosRepetidos = driver.findElements(By.xpath("//*[contains(text(),'Handpicked')]"));
        // Seleccionar uno por índice.
        WebElement elementoDeseado = elementosRepetidos.get(1);
        // Clickea el elemento seleccionado.
        elementoDeseado.click();
        helper.sleepSeconds(3);

        driver.findElement(btnAgregarAcarrito).click();
        helper.sleepSeconds(3);
        driver.findElement(btnVerCarrito).click();
        helper.sleepSeconds(3);

        //A PARTIR DE ACÁ, EL FORMUALRIO NO APARECE MÁS, LAS CREDENCIALES YA TIENEN CARGADOS LOS DATOS
        /* driver.findElement(lblCalcularEnvio).click();
        //ESPERA DE 1 SEGUNDOS

        WebElement dropdownEnvio = driver.findElement(By.xpath("//select[@id='calc_shipping_country']"));
        // Crea un objeto Select pasando el elemento select como argumento
        Select select = new Select(dropdownEnvio);
        // Selecciona una opción por texto visible
        select.selectByVisibleText("Argentina");

        driver.findElement(inputCiudadEnvio).click();
        //ESPERA DE 1 SEGUNDOS
        driver.findElement(inputCiudadEnvio).sendKeys("CABA");
        //ESPERA DE 1 SEGUNDOS
        driver.findElement(inputCPEnvio).click();
        //ESPERA DE 1 SEGUNDOS
        driver.findElement(inputCPEnvio).sendKeys("1406"); //CP FLORES, CABA
        driver.findElement(btnActualizarDatosEnvio).click();
        //ESPERA DE 5 SEGUNDOS */

        driver.findElement(btnFinalizarCompra).click();
        helper.sleepSeconds(5);
        //FORM DE CHECKOUT YA LLENO POR LA CREDENCIAL
        driver.findElement(btnRealizarPedido).click();
        helper.sleepSeconds(5);

    }

    /* public void comprobarNrosDePedido(){
        WebElement nroPedidoLi = driver.findElement(By.xpath(""));

        // Extraer el texto del elemento <li>
        String textoPedidoEcom = nroPedidoLi.getText();

        // Imprimir el string capturado (opcional)
        System.out.println("String capturado: " + textoPedidoEcom);

//...

// Localizar el otro elemento donde se espera que el string esté contenido
        WebElement nroPedidoDash = driver.findElement(By.xpath(""));

        // Extraer el texto del otro elemento
        String textoPedidoDash = nroPedidoDash.getText();

        // Imprimir el texto del otro elemento (opcional)
        System.out.println("Texto en otro elemento: " + textoPedidoDash);

        Assert.assertTrue(textoPedidoDash.contains(textoPedidoEcom));
// Reemplaza "Texto esperado" con el string capturado en la primera prueba
    } */
}