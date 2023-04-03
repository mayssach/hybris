package de.hybris.reviews.services.service.impl;


import de.hybris.platform.acceleratorservices.email.EmailService;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.util.Config;
import de.hybris.reviews.core.dao.ReviewDao;
import de.hybris.reviews.services.service.ReviewService;
import org.apache.commons.mail.EmailException;
import org.springframework.beans.factory.annotation.Required;
import javax.mail.*;
import javax.mail.internet.*;

import java.util.Properties;

public class DefaultReviewService implements ReviewService {
    private ReviewDao reviewDao;
    private EmailService emailService;
    public EmailService getEmailService() {
        return emailService;
    }

    public void setEmailService(EmailService emailService) {
        this.emailService = emailService;
    }


    public ReviewDao getReviewDao() {
        return reviewDao;
    }
    @Required
    public void setReviewDao(ReviewDao reviewDao) {
        this.reviewDao = reviewDao;
    }

    @Override
    public Boolean HaveReviewsPending(ProductModel product, CustomerModel customer) {
        Integer count=getReviewDao().findReviewByCustomerAndProductAndStatus(product,customer);
        if(count==0)
            return false;
        return true;
    }

    @Override
    public Boolean HaveProdcutInOrderEntry(ProductModel product, CustomerModel customer) {
        Integer count=getReviewDao().findOrderByCustomerAndDateAndProduct(product,customer);
        if(count==0)
            return false;
        return true;
    }


    @Override
    public Boolean SendEmailToCustomer(String message,String mail) throws EmailException, MessagingException {

        Properties props = new Properties();
        props.setProperty("mail.smtp.auth", Config.getParameter("mail.smtp.auth").toString());
        props.setProperty("mail.smtp.starttls.enable",Config.getParameter("mail.smtp.starttls.enable").toString());
        props.setProperty("mail.smtp.host", Config.getParameter("mail.smtp.host").toString());
        props.setProperty("mail.smtp.port", Config.getParameter("mail.smtp.port").toString());
        props.setProperty("mail.smtp.ssl.protocols", Config.getParameter("mail.smtp.ssl.protocols").toString());

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(Config.getParameter("mail.smtp.user").toString(), Config.getParameter("mail.smtp.password").toString());
            }
        });

        try {
            // Créer un message de courriel
            MimeMessage email = new MimeMessage(session);
            email.setFrom(InternetAddress.parse(Config.getParameter("mail.smtp.user").toString())[0]);
            email.setRecipients(Message.RecipientType.TO, mail);
            email.setSubject("Review Added");
            email.setText(message);

            // Envoyer le courriel en utilisant le transport SMTP
            Transport transport = session.getTransport("smtp");
            transport.connect();
            transport.sendMessage(email, email.getAllRecipients());
            transport.close();
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


}
     /*  EmailMessageModel emailMessage = new EmailMessageModel();
        EmailAddressModel from = new EmailAddressModel();
        from.setEmailAddress("reviews.avis123@gmail.com");
        emailMessage.setFromAddress(from);
// Créez un objet EmailAddressModel pour le destinataire
        EmailAddressModel to = new EmailAddressModel();
        to.setEmailAddress(mail);
        emailMessage.setToAddresses(Collections.singletonList(to));
        emailMessage.setSubject("Review added!");
        emailMessage.setBody(message);
        emailService.send(emailMessage);
        System.out.println("message envoyée");
        return true;*/
/* }*/