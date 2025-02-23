package com.alfonsovidrio.springboot.di.factura.springboot_difactura;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
// import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import com.alfonsovidrio.springboot.di.factura.springboot_difactura.models.Item;
import com.alfonsovidrio.springboot.di.factura.springboot_difactura.models.Product;

@Configuration
@PropertySource(value="classpath:data.properties", encoding = "UTF-8")
public class AppConfig {

    @Bean("default")
    // @Primary
    List<Item> itemsInvoice() {
        
        return Arrays.asList(
            new Item(new Product("Camara Sony",1000), 2), 
            new Item(new Product("Bicicleta",1200), 1), 
            new Item(new Product("Pantalon",320), 4));
    }

    @Bean
    List<Item> itemsInvoiceOffice() {

        return Arrays.asList(
            new Item(new Product("Monitor LG",2500), 2), 
            new Item(new Product("Escritorio Oficina",5000), 1), 
            new Item(new Product("Silla Oficina",1500), 6),
            new Item(new Product("Impresora HP",1500), 1),
            new Item(new Product("Computadora Portatil",12000), 1));
    }
}
