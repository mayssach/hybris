/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.reviews.core.jalo;

import de.hybris.platform.jalo.JaloSession;
import de.hybris.platform.jalo.extension.ExtensionManager;
import de.hybris.reviews.core.constants.ReviewsCoreConstants;
import de.hybris.reviews.core.setup.CoreSystemSetup;


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
}
