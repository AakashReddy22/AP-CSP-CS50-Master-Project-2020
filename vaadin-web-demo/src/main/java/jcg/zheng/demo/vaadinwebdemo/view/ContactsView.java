package jcg.zheng.demo.vaadinwebdemo.view;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Grid.SelectionMode;
import com.vaadin.ui.VerticalLayout;

import jcg.zheng.demo.vaadinwebdemo.entity.Contact;
import jcg.zheng.demo.vaadinwebdemo.service.ContactService;

@UIScope
@SpringView(name = ContactsView.VIEW_NAME)
public class ContactsView extends VerticalLayout implements View {

	private static final long serialVersionUID = -3089511061636116441L;

	public static final String VIEW_NAME = "contacts";

	@Autowired
	private ContactService contactService;

	@Autowired
	private ContactDetailView contactDetail;

	Button newBtn = new Button("New Contact");
	Button refreshBtn = new Button("Refresh");
	CssLayout actions = new CssLayout(newBtn, refreshBtn);
	Grid<Contact> grid = new Grid<>(Contact.class);

	@PostConstruct
	void init() {
		
		newBtn.addClickListener(e -> contactDetail.showDetail(new Contact()));
		refreshBtn.addClickListener(e -> refresh());

		grid.setSizeFull();
		grid.setSelectionMode(SelectionMode.SINGLE);
		grid.setColumns("id", "firstName", "lastName", "email", "phoneNumber");
		grid.setItems(contactService.getContacts());
		
		grid.asSingleSelect().addValueChangeListener(e -> {
			contactDetail.showDetail(e.getValue());
		});

		addComponent(grid);
		addComponent(actions);
		addComponent(contactDetail);

		contactDetail.setChangeHandler(() -> {
			contactDetail.setVisible(false);
			refresh();
		});

	}

	public final void refresh() {
		grid.setItems(contactService.getContacts());
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// This view is constructed in the init() method()
	}
}
