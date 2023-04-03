package de.hybris.training.services.productSales.dao.impl;


import de.hybris.platform.core.model.order.OrderEntryModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.internal.dao.AbstractItemDao;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.SearchResult;
import de.hybris.training.services.productSales.dao.ProductDao1;


import java.util.List;


public class DefaultProductDao1 extends AbstractItemDao implements ProductDao1 {
    @Override
    public long findQuantitySaledByProduct(final String code) {
        long bestSale =0;
        final String fsq = "SELECT {o:pk} FROM {OrderEntry AS o join Product AS p ON {p:pk}={o:product}} where {p:code}=?code";
        final FlexibleSearchQuery query = new FlexibleSearchQuery(fsq);
        query.addQueryParameter(ProductModel.CODE, code);
        SearchResult<OrderEntryModel> result = getFlexibleSearchService().search(query);
        final List<OrderEntryModel> resultList = result.getResult();
        if(result.getCount()!=0)
            for (OrderEntryModel o:resultList)
                bestSale+=o.getQuantity();
        return bestSale;
    }
}



