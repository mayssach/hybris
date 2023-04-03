package de.hybris.training.storefront.forms.validation;

import de.hybris.platform.acceleratorstorefrontcommons.forms.validation.ProfileValidator;
import de.hybris.training.storefront.forms.UpdateProfileForm1;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@Component("profileValidator1")
public class ProfileValidator1 extends ProfileValidator {
    @Override
    public void validate(final Object object, final Errors errors)
    {
        final UpdateProfileForm1 profileForm = (UpdateProfileForm1) object;
        final String title = profileForm.getTitleCode();
        final String firstName = profileForm.getFirstName();
        final String lastName = profileForm.getLastName();
        final String codePostal = profileForm.getLastName();

        if (StringUtils.isNotEmpty(title) && StringUtils.length(title) > 255)
        {
            errors.rejectValue("titleCode", "profile.title.invalid");
        }

        if (StringUtils.isBlank(firstName))
        {
            errors.rejectValue("firstName", "profile.firstName.invalid");
        }
        else if (StringUtils.length(firstName) > 255)
        {
            errors.rejectValue("firstName", "profile.firstName.invalid");
        }

        if (StringUtils.isBlank(lastName))
        {
            errors.rejectValue("lastName", "profile.lastName.invalid");
        }
        else if (StringUtils.length(lastName) > 255)
        {
            errors.rejectValue("lastName", "profile.lastName.invalid");
        }
        if (StringUtils.isBlank(codePostal))
        {
            errors.rejectValue("codePostal", "profile.codePostal.invalid");
        }
        else if (StringUtils.length(codePostal) > 10)
        {
            errors.rejectValue("codePostal", "profile.codePostal.invalid");
        }
    }
}
