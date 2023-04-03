package de.hybris.training.facades.customer;

import de.hybris.platform.commercefacades.customer.CustomerFacade;
import de.hybris.platform.commercefacades.user.data.CustomerData;
import de.hybris.platform.commercefacades.user.data.RegisterData;
import de.hybris.platform.commerceservices.customer.DuplicateUidException;

public interface CustomerFacade1 extends CustomerFacade {
    public void register(final RegisterData registerData) throws DuplicateUidException;
    public void updateProfile(final CustomerData customerData) throws DuplicateUidException;
}
