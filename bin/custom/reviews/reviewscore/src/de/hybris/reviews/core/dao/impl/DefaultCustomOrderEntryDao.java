package de.hybris.reviews.core.dao.impl;

import de.hybris.platform.core.model.order.OrderEntryModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.internal.dao.AbstractItemDao;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.SearchResult;
import de.hybris.platform.util.Config;
import de.hybris.reviews.core.dao.CustomOrderEntryDao;


import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DefaultCustomOrderEntryDao extends AbstractItemDao implements CustomOrderEntryDao {
    @Override
    public Integer findOrderEntriesByCustomerAndDateAndProduct(ProductModel product, CustomerModel customer) {

        Calendar calendar = Calendar.getInstance(); // crée une instance de la classe Calendar avec la date et l'heure actuelles
        calendar.add(Calendar.DAY_OF_MONTH, Integer.parseInt(Config.getParameter("nbrOfDays")));
        Date date1 = calendar.getTime();
        Date date2 = new Date();
        FlexibleSearchQuery fsQuery = new FlexibleSearchQuery("SELECT {oe:pk} FROM {orderEntry as oe join order as o on {oe:order}={o:pk}}" +
                " where {oe:product}=?product and {o:user}=?user " +
                "and {oe:creationtime} between ?date1 and ?date2");
        fsQuery.addQueryParameter("product", product);
        fsQuery.addQueryParameter("user", customer.getPk());
        fsQuery.addQueryParameter("date1", date1);
        fsQuery.addQueryParameter("date2", date2);
        SearchResult<OrderEntryModel> result = getFlexibleSearchService().search(fsQuery);
        final List<OrderEntryModel> resultList = result.getResult();
        return resultList.size();
    }

}




