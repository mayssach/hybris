package de.hybris.training.facades.populators;

import de.hybris.platform.commercefacades.user.converters.populator.CustomerPopulator;
import de.hybris.platform.commercefacades.user.data.CustomerData;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.core.model.user.TitleModel;
import org.springframework.util.Assert;

public class CustomerPopulator1 extends CustomerPopulator {
    @Override
    public void populate(final CustomerModel source, final CustomerData target)
    {
        super.populate(source,target);
        final String codePostal = source.getCodePostal();
        if (codePostal != null)
        {
            target.setCodePostal(codePostal);
        }

    }
}
