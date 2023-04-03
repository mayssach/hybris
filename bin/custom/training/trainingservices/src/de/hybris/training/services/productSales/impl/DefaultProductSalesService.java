package de.hybris.training.services.productSales.impl;


import de.hybris.training.services.productSales.ProductSalesService;
import de.hybris.training.services.productSales.dao.ProductDao1;
import org.springframework.beans.factory.annotation.Required;


public class DefaultProductSalesService implements ProductSalesService {
    private ProductDao1 productDao1;

    @Required
    public void setProductDao1(ProductDao1 productDao1) {
        this.productDao1 = productDao1;
    }

    public ProductDao1 getProductDao1() {
        return productDao1;
    }

@Override
public long getQuantityProductSale(String code)
    {
       return(productDao1.findQuantitySaledByProduct(code));
    }

}