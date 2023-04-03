package de.hybris.training.services.search.solrfacetsearch.provider.impl;

import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.solrfacetsearch.config.IndexConfig;
import de.hybris.platform.solrfacetsearch.config.IndexedProperty;
import de.hybris.platform.solrfacetsearch.config.exceptions.FieldValueProviderException;
import de.hybris.platform.solrfacetsearch.provider.FieldNameProvider;
import de.hybris.platform.solrfacetsearch.provider.FieldValue;
import de.hybris.platform.solrfacetsearch.provider.FieldValueProvider;
import de.hybris.platform.solrfacetsearch.provider.impl.AbstractPropertyFieldValueProvider;
import de.hybris.training.services.productSales.ProductSalesService;
import org.springframework.beans.factory.annotation.Required;
import java.io.Serializable;
import java.util.*;


public class BestSaleValueProvider extends AbstractPropertyFieldValueProvider implements FieldValueProvider, Serializable {

      private ProductSalesService productSalesService;
      private FieldNameProvider fieldNameProvider;

    public ProductSalesService getProductSalesService() {
        return productSalesService;
    }
    @Required
    public void setProductSalesService(ProductSalesService productSalesService) {
        this.productSalesService = productSalesService;
    }


    @Override
    public Collection<FieldValue> getFieldValues(final IndexConfig indexConfig, final IndexedProperty indexedProperty,
                                                 final Object model) throws FieldValueProviderException
    {
        final ProductModel product = (ProductModel) model;//this provider shall only be used with products
        final Collection<FieldValue> fieldValues = new ArrayList<FieldValue>();
        final long bestSale= getProductSalesService().getQuantityProductSale(product.getCode());
        addFieldValues(indexedProperty, fieldValues, bestSale);
        return fieldValues;
    }

    protected void addFieldValues(final IndexedProperty indexedProperty,final Collection<FieldValue> fieldValues, final long bestSale) {
        final Collection<String> fieldNames = getFieldNameProvider().getFieldNames(indexedProperty,null);
        for (final String fieldName : fieldNames)
        {
            fieldValues.add(new FieldValue(fieldName, bestSale));
        }
    }


    public FieldNameProvider getFieldNameProvider()
        {
            return fieldNameProvider;
        }

        public void setFieldNameProvider(final FieldNameProvider fieldNameProvider)
        {
            this.fieldNameProvider = fieldNameProvider;
        }

}


