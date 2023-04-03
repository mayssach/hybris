package de.hybris.training.services.customer;

import de.hybris.platform.commerceservices.customer.CustomerAccountService;
import de.hybris.platform.commerceservices.customer.DuplicateUidException;
import de.hybris.platform.core.model.user.CustomerModel;

public interface CustomerAccountService1 extends CustomerAccountService {

    public void updateProfile(final CustomerModel customerModel, final String titleCode, final String name, final String codePostal, final String login)
            throws DuplicateUidException;
}
