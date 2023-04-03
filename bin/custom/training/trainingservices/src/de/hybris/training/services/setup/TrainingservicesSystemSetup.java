/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.training.services.setup;

import static de.hybris.training.services.constants.TrainingservicesConstants.PLATFORM_LOGO_CODE;

import de.hybris.platform.core.initialization.SystemSetup;

import java.io.InputStream;

import de.hybris.training.services.constants.TrainingservicesConstants;
import de.hybris.training.services.customer.TrainingservicesService;


@SystemSetup(extension = TrainingservicesConstants.EXTENSIONNAME)
public class TrainingservicesSystemSetup
{
	private final TrainingservicesService trainingservicesService;

	public TrainingservicesSystemSetup(final TrainingservicesService trainingservicesService)
	{
		this.trainingservicesService = trainingservicesService;
	}

	@SystemSetup(process = SystemSetup.Process.INIT, type = SystemSetup.Type.ESSENTIAL)
	public void createEssentialData()
	{
		trainingservicesService.createLogo(PLATFORM_LOGO_CODE);
	}

	private InputStream getImageStream()
	{
		return TrainingservicesSystemSetup.class.getResourceAsStream("/trainingservices/sap-hybris-platform.png");
	}
}
