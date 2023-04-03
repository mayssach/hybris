package de.hybris.training.facades.populators;

import de.hybris.platform.commercefacades.storesession.data.CurrencyData;
import de.hybris.platform.commercefacades.storesession.data.LanguageData;
import de.hybris.platform.commercefacades.user.data.CustomerData;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.servlet.http.HttpServletRequest;
@Component("httpRequestCustomerDataPopulator1")
public class HttpRequestCustomerDataPopulator implements Populator<HttpServletRequest, CustomerData>
{

    private static final String TITLECODE = "titleCode";
    private static final String FIRSTNAME = "firstName";
    private static final String LASTNAME = "lastName";
    private static final String CODEPOSTAL = "codePostal";
    private static final String LANGUAGE = "language";
    private static final String CURRENCY = "currency";

    @Override
    public void populate(final HttpServletRequest source, final CustomerData target) throws ConversionException //NOSONAR
    {
        Assert.notNull(source, "Parameter source cannot be null.");
        Assert.notNull(target, "Parameter target cannot be null.");

        target.setTitleCode(StringUtils.defaultString(source.getParameter(TITLECODE), target.getTitleCode()));
        target.setFirstName(StringUtils.defaultString(source.getParameter(FIRSTNAME), target.getFirstName()));
        target.setLastName(StringUtils.defaultString(source.getParameter(LASTNAME), target.getLastName()));
        target.setCodePostal(StringUtils.defaultString(source.getParameter(CODEPOSTAL), target.getCodePostal()));

        if (source.getParameter(CURRENCY) != null)
        {
            final CurrencyData currency = new CurrencyData();
            currency.setIsocode(source.getParameter(CURRENCY));
            target.setCurrency(currency);
        }

        if (source.getParameter(LANGUAGE) != null)
        {
            final LanguageData language = new LanguageData();
            language.setIsocode(source.getParameter(LANGUAGE));
            target.setLanguage(language);
        }

    }

}