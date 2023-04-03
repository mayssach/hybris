package de.hybris.training.facades.customer.impl;

import de.hybris.platform.commercefacades.customer.impl.DefaultCustomerFacade;
import de.hybris.platform.commercefacades.user.data.CustomerData;
import de.hybris.platform.commercefacades.user.data.RegisterData;
import de.hybris.platform.commerceservices.customer.CustomerAccountService;
import de.hybris.platform.commerceservices.customer.DuplicateUidException;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.training.services.customer.CustomerAccountService1;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.util.Assert;


import static de.hybris.platform.servicelayer.util.ServicesUtil.validateParameterNotNullStandardMessage;


public class DefaultCustomerFacade1 extends DefaultCustomerFacade {

    private static final Logger LOG = Logger.getLogger(DefaultCustomerFacade1.class);
    private CustomerAccountService1 customerAccountService;


    protected CustomerAccountService1 getCustomerAccountService()
    {
        return customerAccountService;
    }

    @Required
    public void setCustomerAccountService(final CustomerAccountService1 customerAccountService)
    {
        this.customerAccountService = customerAccountService;
    }


    @Override
    public void register(final RegisterData registerData) throws DuplicateUidException
    {
        validateParameterNotNullStandardMessage("registerData", registerData);
        Assert.hasText(registerData.getFirstName(), "The field [FirstName] cannot be empty");
        Assert.hasText(registerData.getLastName(), "The field [LastName] cannot be empty");
        Assert.hasText(registerData.getLogin(), "The field [Login] cannot be empty");
        Assert.hasText(registerData.getCodePostal(), "The field [codePostal] cannot be empty");

        final CustomerModel newCustomer = getModelService().create(CustomerModel.class);
        setCommonPropertiesForRegister(registerData, newCustomer);
        getCustomerAccountService().register(newCustomer, registerData.getPassword());
    }


    //redefiniton
    @Override
    protected void setCommonPropertiesForRegister(final RegisterData registerData, final CustomerModel customerModel)
    {
        super.setCommonPropertiesForRegister(registerData,customerModel);
        customerModel.setCodePostal(registerData.getCodePostal());

    }


    @Override
    public void updateProfile(final CustomerData customerData) throws DuplicateUidException
    {
        validateDataBeforeUpdate(customerData);
        final String name = getCustomerNameStrategy().getName(customerData.getFirstName(), customerData.getLastName());
        final String codePostal = customerData.getCodePostal();
        final CustomerModel customer = getCurrentSessionCustomer();
        customer.setOriginalUid(customerData.getDisplayUid());
        getCustomerAccountService().updateProfile(customer, customerData.getTitleCode(), name, customerData.getUid(),codePostal);
    }



}
