package com.avianca.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.avianca.utils.Utilidades;

import io.qameta.allure.Step;

public class BusquedaVueloPage extends BasePage{
	
	By lblSoloIda = By.xpath("//div[2]/ul/li[2]/a");
	By txtDesde = By.xpath("//div[2]/div/form/div/div[2]/div/div/div/fieldset/div/div/div/label/div/input");
	By txtHacia = By.xpath("//div[2]/div/form/div/div[2]/div/div/div/fieldset/div/div[3]/div[2]/label/div/input");
	By fechaViaje = By.xpath("//div[2]/fieldset/div/div/div/label/div/input");
	By fechaRetorno = By.name("pbFechaRegreso");
	By btnBuscarVuelo = By.xpath("/html/body/div[3]/div/div[2]/div/div[1]/div/div[2]/div/div[2]/div[1]/div/div/div/div/section/div[3]/div[4]/div[2]/div/form/div/div[2]/div/div/div[3]/fieldset/div/div[4]/button");
	By selHacia = By.xpath("//div[2]/div/ul/li/div/b");
	By rbtnCabinaEconomica = By.xpath("/html/body/app-root/main/div/avail-page/div/div/avail-cont/avail-pres/avail-list-pres/expander-elem[2]/div/div[1]/div/div/div[2]/div[1]/button/div/div[1]/div");
	By selMejorOpcion = By.xpath("/html/body/app-root/main/div/avail-page/div/div/avail-cont/avail-pres/avail-list-pres/expander-elem[2]/div[2]/div/cabin-choice-cont/cabin-choice-pres/div/div[1]/fare-comparison-table-cont/fare-comparison-table-pres/div/button[2]/div[4]");
	By btnContinuar = By.xpath("/html/body/app-root/div[3]/cart-sticky-bottom-cont/cart-sticky-bottom-pres[1]/div[2]/div/div[5]");
	
	public BusquedaVueloPage(WebDriver driver) {
		super(driver);
		
	}
	
	 @Step("Abrir Portal Avianca. Url {0}")
	    public BusquedaVueloPage irPortal(String url)  {
	        driver.get(url);
	        Utilidades.waitInMs(2000);
	        return new BusquedaVueloPage(driver);
	    }
	 @Step("Seleccionar Solo Ida")
	    public BusquedaVueloPage seleccionarSoloIda() {
	        Utilidades.waitInMs(5000);
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("window.scrollBy(0,300)");
	        click(lblSoloIda);
	        Utilidades.waitInMs(5000);
	        return this;
	    }

	    @Step("Buscar Vuelo Ida y Vuelta")
	    public BusquedaVueloPage buscarVueloAvianca(String desde, String hacia, String fechaIda) {
	        Utilidades.waitInMs(2000);
	        
	        Utilidades.waitInMs(1000);
	        //clear(txtDesde);
	        writeText(txtDesde, desde);
	        Utilidades.waitInMs(1000);
	        writeText(txtHacia, hacia);
	        click(selHacia);
	        Utilidades.waitInMs(1000);
	        writeText(fechaViaje, fechaIda);
	        Utilidades.waitInMs(1000);
	       
	        click(btnBuscarVuelo);
	        
	        Utilidades.waitInMs(10000);
	        return this;
	    }
	    
	    @Step("Seleccionar Vuelo y Cabina Economica")
	    public BusquedaVueloPage seleccionarPrecio() {
	        Utilidades.waitInMs(5000);
	        
	        click(rbtnCabinaEconomica);
	        click(selMejorOpcion);
	        click(btnContinuar);
	        Utilidades.waitInMs(5000);
	        return this;
	    }
	

}
