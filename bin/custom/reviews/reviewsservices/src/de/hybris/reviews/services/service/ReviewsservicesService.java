/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.reviews.services.service;

public interface ReviewsservicesService
{
	String getHybrisLogoUrl(String logoCode);

	void createLogo(String logoCode);
}
