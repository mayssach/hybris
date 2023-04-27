package de.hybris.reviews.services.service;

import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.core.model.user.CustomerModel;
import org.apache.commons.mail.EmailException;

import javax.mail.MessagingException;

public interface CustomOrderEntryService {
    Boolean haveProductInOrderEntry(ProductModel product, CustomerModel customer);
    Boolean sendEmailToCustomer(String message,String mail) throws EmailException, MessagingException;

}
