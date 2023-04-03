package de.hybris.training.services.customer.impl;


import de.hybris.platform.commerceservices.customer.DuplicateUidException;
import de.hybris.platform.commerceservices.customer.impl.DefaultCustomerAccountService;
import de.hybris.platform.commerceservices.event.UpdatedProfileEvent;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.training.services.customer.CustomerAccountService1;
import org.apache.log4j.Logger;

public class DefaultCustomerAccountService1 extends DefaultCustomerAccountService implements CustomerAccountService1 {
    private static final Logger LOG = Logger.getLogger(DefaultCustomerAccountService1.class);

    @Override
    public void updateProfile(final CustomerModel customerModel, final String titleCode, final String name, final String login,final String codePostal)
            throws DuplicateUidException
    {   super.updateProfile(customerModel,titleCode,name,login);
        customerModel.setCodePostal(codePostal);
        internalSaveCustomer(customerModel);
        getEventService().publishEvent(initializeEvent(new UpdatedProfileEvent(), customerModel));
    }

}
