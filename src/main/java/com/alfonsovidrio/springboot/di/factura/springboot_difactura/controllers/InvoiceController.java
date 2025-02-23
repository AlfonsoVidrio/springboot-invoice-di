package com.alfonsovidrio.springboot.di.factura.springboot_difactura.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alfonsovidrio.springboot.di.factura.springboot_difactura.models.Client;
import com.alfonsovidrio.springboot.di.factura.springboot_difactura.models.Invoice;

@RestController
@RequestMapping("/api/invoice")
public class InvoiceController {

    @Autowired
    private Invoice invoice;

    @GetMapping("/show")
    public Invoice show() {
        Invoice i = new Invoice();
        Client c = new Client();
        c.setName(invoice.getClient().getName());
        c.setLastname(invoice.getClient().getLastname());

        i.setClient(c);
        i.setDescription(invoice.getDescription());
        i.setItems(invoice.getItems());
        return i;
    }
}
