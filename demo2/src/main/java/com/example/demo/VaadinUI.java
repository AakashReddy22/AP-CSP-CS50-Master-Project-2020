package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinRequest;
import com.vaadin.flow.spring.SpringVaadinServletService;
import com.vaadin.flow.spring.annotation.UIScope;

import java.util.List;

import com.example.demo.CustomerService;
import com.vaadin.flow.*;



@UIScope
public class VaadinUI extends UI {

	@Autowired
    CustomerService service;
    Customer customer;
    Binder<Customer> binder = new Binder<>(Customer.class);
    Grid<Customer> grid1 = new Grid<>();
    TextField firstName = new TextField("First name");
    TextField lastName = new TextField("Last name");


    @Override
    protected void init(VaadinRequest request) {
    	
    	List<Customer> customers = service.findAll();
        grid1.setItems(customers);
        setFormVisible(false);
    	
        grid1.setColumns("firstName", "lastName");
        grid1.addSelectionListener(e -> updateForm());

        binder.bindInstanceFields(this);


    	
        	
    	      
    }

	private void updateGrid() {
        List<Customer> customers = service.findAll();
        grid1.setItems(customers);
        setFormVisible(false);
    }

    private void updateForm() {
        if (grid1.asSingleSelect().isEmpty()) {
            setFormVisible(false);
        } else {
            customer = grid1.asSingleSelect().getValue();
            binder.setBean(customer);
            setFormVisible(true);
        }
    }

    private void setFormVisible(boolean visible) {
        firstName.setVisible(visible);
        lastName.setVisible(visible);
    }


} 