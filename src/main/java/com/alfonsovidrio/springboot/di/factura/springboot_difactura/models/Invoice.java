package com.alfonsovidrio.springboot.di.factura.springboot_difactura.models;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
// @SessionScope
@RequestScope
// @JsonIgnoreProperties({"advisors","targetSource"})
public class Invoice {

    @Autowired
    private Client client;

    @Value("${invoice.description}")
    private String description;

    @Autowired
    @Qualifier("default")
    private List<Item> items;

    public Invoice() {
        System.out.println("Creating component invoice (constructor)");
        System.out.println(client);
        System.out.println(description);
    }

    @PostConstruct
    public void init() {
        System.out.println("Creating component invoice (init)");
        client.setName(client.getName().concat(" Pepe"));
        description = description.concat(" del cliente ").concat(client.getName()).concat(client.getLastname());
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Destroying component or bean invoice");
    }

    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public List<Item> getItems() {
        return items;
    }
    public void setItems(List<Item> items) {
        this.items = items;
    }

    public int getTotal() {
        // int total = 0;
        // for(Item item: items) {
        //     total += item.getImport();
        // }
        
        return items.stream().
        map(item -> item.getImport()).
        reduce(0, (sum, itemImport) -> sum + itemImport);
    }

}
