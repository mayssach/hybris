package de.hybris.reviews.services.service;

import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.core.model.user.CustomerModel;
import org.apache.commons.mail.EmailException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

public interface ReviewService {
    Boolean HaveReviewsPending(ProductModel product, CustomerModel customer);
    Boolean HaveProdcutInOrderEntry(ProductModel product, CustomerModel customer);
    Boolean SendEmailToCustomer(String message,String mail) throws EmailException, MessagingException;

}
