package jcg.zheng.demo.vaadinwebdemo.view;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.data.Binder;
import com.vaadin.data.validator.EmailValidator;
import com.vaadin.data.validator.RegexpValidator;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

import jcg.zheng.demo.vaadinwebdemo.entity.Contact;
import jcg.zheng.demo.vaadinwebdemo.service.ContactService;
import jcg.zheng.demo.vaadinwebdemo.type.PhoneType;

@SpringComponent
@UIScope
public class ContactDetailView extends VerticalLayout {

	private static final long serialVersionUID = -3307156756600939660L;

	private static final String ENTER_VALID_EMAIL_ADDRESS = "Enter valid email address";

	private static final String ENTER_VALID_PHONE_NUMBER = "Enter valid phone number!";

	private static final String PHONE_FORMAT = "\\D*([2-9]\\d{2})(\\D*)([2-9]\\d{2})(\\D*)(\\d{4})\\D*";

	private static final String MAX_LENGTH_OF_NAME_IS_30_CHARS = "Max length of name is 30 chars";
	private static final String PHONE_NUMBER_IS_REQUIRED = "Every contact must have a phone number";

	private static final String LAST_NAME_IS_REQUIRED = "Every contact must have a last name";

	private static final String FIRST_NAME_IS_REQUIRED = "Every contact must have a first name";

	private static final String OUTLINED = "outlined";

	@Autowired
	private ContactService service;

	private Contact contact;

	Binder<Contact> binder = new Binder<>(Contact.class);

	TextField firstName = new TextField("First name");
	TextField lastName = new TextField("Last name");
	TextField email = new TextField("Email");
	TextField phoneNumber = new TextField("Phone number");
	NativeSelect<String> phoneType = new NativeSelect<>("Phone Type");
	TextField socialMediaLink = new TextField("Social Media Link");
	TextArea notes = new TextArea("Notes");

	Button save = new Button("Save");
	Button delete = new Button("Delete");
	Button cancel = new Button("Cancel");

	CssLayout actions = new CssLayout(save, delete, cancel);

	@Autowired
	public ContactDetailView() {

		phoneType.setItems(Stream.of(PhoneType.values()).map(PhoneType::name).collect(Collectors.toList()));
		phoneType.setValue(PhoneType.OFFICE.name());
		notes.setSizeFull();

		addComponents(nameRow(), phoneRow(), emailRow(), notes);
		setSpacing(true);
		actions.setStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);

		save.setStyleName(ValoTheme.BUTTON_PRIMARY);

		save.addClickListener(e -> service.save(contact));
		delete.addClickListener(e -> service.delete(contact));
		cancel.addClickListener(e -> hide());

		bindingFields();

		addComponent(actions);
		setVisible(false);
	}

	private void bindingFields() {
		binder.forField(this.firstName).withNullRepresentation("")
				.withValidator(str -> str.length() <= 30, MAX_LENGTH_OF_NAME_IS_30_CHARS)
				.asRequired(FIRST_NAME_IS_REQUIRED).bind(Contact::getFirstName, Contact::setFirstName);

		binder.forField(this.lastName).withNullRepresentation("")
				.withValidator(str -> str.length() <= 30, MAX_LENGTH_OF_NAME_IS_30_CHARS)
				.asRequired(LAST_NAME_IS_REQUIRED).bind(Contact::getLastName, Contact::setLastName);

		binder.forField(this.email).withValidator(new EmailValidator(ENTER_VALID_EMAIL_ADDRESS)).bind(Contact::getEmail,
				Contact::setEmail);

		binder.forField(this.phoneNumber).withValidator(new RegexpValidator(ENTER_VALID_PHONE_NUMBER, PHONE_FORMAT))
				.asRequired(PHONE_NUMBER_IS_REQUIRED).bind(Contact::getPhoneNumber, Contact::setPhoneNumber);

		binder.bindInstanceFields(this);
	}

	private HorizontalLayout nameRow() {
		HorizontalLayout sample = new HorizontalLayout();
		sample.addStyleName(OUTLINED);
		sample.setSpacing(false);
		sample.setMargin(false);
		sample.setSizeFull();

		sample.addComponents(firstName, lastName);
		return sample;
	}

	private HorizontalLayout phoneRow() {
		HorizontalLayout sample = new HorizontalLayout();
		sample.addStyleName(OUTLINED);
		sample.setSpacing(false);
		sample.setMargin(false);
		sample.setSizeFull();

		sample.addComponents(phoneType, phoneNumber);
		return sample;
	}

	private HorizontalLayout emailRow() {
		HorizontalLayout sample = new HorizontalLayout();
		sample.addStyleName(OUTLINED);
		sample.setSpacing(false);
		sample.setMargin(false);
		sample.setSizeFull();

		sample.addComponents(email, socialMediaLink);
		return sample;
	}

	public final void hide() {
		setVisible(false);
	}

	public interface ChangeHandler {
		void onChange();
	}

	public final void showDetail(Contact c) {
		contact = c;

		binder.setBean(contact);

		setVisible(true);
		save.focus();
	}

	public void setChangeHandler(ChangeHandler h) {
		save.addClickListener(e -> h.onChange());
		delete.addClickListener(e -> h.onChange());
	}

}
