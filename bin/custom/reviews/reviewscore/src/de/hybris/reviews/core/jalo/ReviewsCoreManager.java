/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.reviews.core.jalo;

import de.hybris.platform.basecommerce.jalo.site.BaseSite;
import de.hybris.platform.core.Constants;
import de.hybris.platform.customerreview.jalo.CustomerReview;
import de.hybris.platform.jalo.JaloSession;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.extension.ExtensionManager;
import de.hybris.platform.jalo.flexiblesearch.FlexibleSearch;
import de.hybris.platform.jalo.type.TypeManager;
import de.hybris.platform.jalo.user.UserGroup;
import de.hybris.platform.storelocator.jalo.PointOfService;
import de.hybris.platform.util.JspContext;
import de.hybris.reviews.core.constants.ReviewsCoreConstants;
import de.hybris.reviews.core.model.SiteReview;
import de.hybris.reviews.core.setup.CoreSystemSetup;

import java.util.Collections;
import java.util.List;
import java.util.Map;


/**
 * Do not use, please use {@link CoreSystemSetup} instead.
 * 
 */
public class ReviewsCoreManager extends GeneratedReviewsCoreManager
{
	public static final ReviewsCoreManager getInstance()
	{
		final ExtensionManager em = JaloSession.getCurrentSession().getExtensionManager();
		return (ReviewsCoreManager) em.getExtension(ReviewsCoreConstants.EXTENSIONNAME);
	}


	public void createEssentialData(Map params, JspContext jspc) {
		TypeManager typeManager = this.getSession().getTypeManager();
		UserGroup customers = this.getSession().getUserManager().getUserGroupByGroupID(Constants.USER.CUSTOMER_USERGROUP);
		if (typeManager.getSearchRestriction(typeManager.getComposedType(SiteReview.class), "SiteReviewRestrictions") == null) {
			typeManager.createRestriction("SiteReviewRestrictions", customers, typeManager.getComposedType(SiteReview.class), "{blocked} = 0 OR {blocked} IS NULL");
		}

	}

	@Override
	public Double getAverageRating(SessionContext ctx, BaseSite site) {
		Map<String, BaseSite> values = Collections.singletonMap("site", site);
		List<Double> result = FlexibleSearch.getInstance().search("SELECT avg({rating}) FROM {SiteReview} WHERE {site} = ?site", values, Collections.singletonList(Double.class), true, true, 0, -1).getResult();
		return (Double)result.iterator().next();
	}
	@Override
	public Integer getNumberOfReviews(SessionContext ctx, BaseSite site) {
		Map<String, BaseSite> values = Collections.singletonMap("site", site);
		List<Integer> result = FlexibleSearch.getInstance().search("SELECT count(*) FROM {SiteReview} WHERE {site} = ?site", values, Collections.singletonList(Integer.class), true, true, 0, -1).getResult();
		return (Integer)result.iterator().next();
	}


	public List<CustomerReview> getAllReviews(BaseSite site) {
		return this.getAllReviews(JaloSession.getCurrentSession().getSessionContext(), site);
	}

	public List<CustomerReview> getAllReviews(SessionContext ctx, BaseSite site) {
		Map<String, BaseSite> values = Collections.singletonMap("site", site);
		List<CustomerReview> result = FlexibleSearch.getInstance().search(ctx, "SELECT {pk} FROM {SiteReview} WHERE {site} = ?site ORDER BY {creationtime} DESC", values, Collections.singletonList(CustomerReview.class), true, true, 0, -1).getResult();
		return result;
	}

	@Override
	public Double getAverageRating(SessionContext ctx, PointOfService store) {
		Map<String, PointOfService> values = Collections.singletonMap("store", store);
		List<Double> result = FlexibleSearch.getInstance().search("SELECT avg({rating}) FROM {StoreReview} WHERE {store} = ?store", values, Collections.singletonList(Double.class), true, true, 0, -1).getResult();
		return (Double)result.iterator().next();
	}
	@Override
	public Integer getNumberOfReviews(SessionContext ctx, PointOfService store) {
		Map<String, PointOfService> values = Collections.singletonMap("store", store);
		List<Integer> result = FlexibleSearch.getInstance().search("SELECT count(*) FROM {StoreReview} WHERE {store} = ?store", values, Collections.singletonList(Integer.class), true, true, 0, -1).getResult();
		return (Integer)result.iterator().next();
	}


	public List<CustomerReview> getAllReviews(PointOfService store) {
		return this.getAllReviews(JaloSession.getCurrentSession().getSessionContext(), store);
	}

	public List<CustomerReview> getAllReviews(SessionContext ctx, PointOfService store) {
		Map<String, PointOfService>  values = Collections.singletonMap("store", store);
		List<CustomerReview> result = FlexibleSearch.getInstance().search(ctx, "SELECT {pk} FROM {StoreReview} WHERE {store} = ?store ORDER BY {creationtime} DESC", values, Collections.singletonList(CustomerReview.class), true, true, 0, -1).getResult();
		return result;
	}
}
