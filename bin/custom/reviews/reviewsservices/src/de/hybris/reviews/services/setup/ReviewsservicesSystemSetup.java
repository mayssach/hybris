/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.reviews.services.setup;

import static de.hybris.reviews.services.constants.ReviewsservicesConstants.PLATFORM_LOGO_CODE;

import de.hybris.platform.core.initialization.SystemSetup;

import java.io.InputStream;

import de.hybris.reviews.services.constants.ReviewsservicesConstants;
import de.hybris.reviews.services.service.ReviewsservicesService;


@SystemSetup(extension = ReviewsservicesConstants.EXTENSIONNAME)
public class ReviewsservicesSystemSetup
{
	private final ReviewsservicesService reviewsservicesService;

	public ReviewsservicesSystemSetup(final ReviewsservicesService reviewsservicesService)
	{
		this.reviewsservicesService = reviewsservicesService;
	}

	@SystemSetup(process = SystemSetup.Process.INIT, type = SystemSetup.Type.ESSENTIAL)
	public void createEssentialData()
	{
		reviewsservicesService.createLogo(PLATFORM_LOGO_CODE);
	}

	private InputStream getImageStream()
	{
		return ReviewsservicesSystemSetup.class.getResourceAsStream("/reviewsservices/sap-hybris-platform.png");
	}
}
