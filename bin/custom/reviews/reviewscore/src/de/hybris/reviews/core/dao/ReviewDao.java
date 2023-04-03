package de.hybris.reviews.core.dao;

import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.core.model.user.CustomerModel;

public interface ReviewDao {
    Integer findOrderByCustomerAndDateAndProduct(ProductModel product, CustomerModel customer);
    Integer findReviewByCustomerAndProductAndStatus(ProductModel product, CustomerModel customer);
}
