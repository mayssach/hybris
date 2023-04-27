package de.hybris.reviews.core.dao;

import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.core.model.user.CustomerModel;

public interface CustomOrderEntryDao {
    Integer findOrderEntriesByCustomerAndDateAndProduct(ProductModel product, CustomerModel customer);
}
