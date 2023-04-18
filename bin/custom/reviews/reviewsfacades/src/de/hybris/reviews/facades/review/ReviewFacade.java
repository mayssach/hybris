package de.hybris.reviews.facades.review;

import de.hybris.platform.commercefacades.product.data.ReviewData;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.exceptions.UnknownIdentifierException;
import de.hybris.reviews.core.model.model.ModerationRuleModel;
import org.apache.commons.mail.EmailException;

import javax.mail.MessagingException;
import java.util.List;

public interface ReviewFacade {
    Boolean HaveProdcutInOrderEntry(ProductModel product, CustomerModel customer);
    Boolean SendEmailToCustomer(String message,String mail) throws EmailException, MessagingException;

    List<ModerationRuleModel> getAllModerationRules();
    ReviewData postSiteReview(String siteuid, ReviewData reviewData) throws UnknownIdentifierException, IllegalArgumentException;
    List<ReviewData> getSiteReviews(String siteuid) throws UnknownIdentifierException;
    List<ReviewData> getSiteReviews(String siteuid, Integer numberOfReviews) throws UnknownIdentifierException,
            IllegalArgumentException;


    ReviewData postStoreReview(String storeName, ReviewData reviewData) throws UnknownIdentifierException, IllegalArgumentException;
    List<ReviewData> getStoreReviews(String storeName) throws UnknownIdentifierException;
    List<ReviewData> getStoreReviews(String storeName, Integer numberOfReviews) throws UnknownIdentifierException,
            IllegalArgumentException;
}
