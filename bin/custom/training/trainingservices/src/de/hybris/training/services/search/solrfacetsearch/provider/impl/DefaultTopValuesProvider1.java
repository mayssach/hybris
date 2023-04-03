package de.hybris.training.services.search.solrfacetsearch.provider.impl;

import de.hybris.platform.commerceservices.search.solrfacetsearch.provider.impl.DefaultTopValuesProvider;



public class DefaultTopValuesProvider1 extends DefaultTopValuesProvider
{
    private int topFacetCount = 3;
    @Override
    public int getTopFacetCount() {
        return topFacetCount;
    }
    @Override
    public void setTopFacetCount(int topFacetCount) {

        this.topFacetCount = topFacetCount;
    }


}
