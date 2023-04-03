package de.hybris.training.storefront.forms.validation;

import de.hybris.platform.acceleratorstorefrontcommons.forms.validation.RegistrationValidator;
import de.hybris.training.storefront.forms.RegisterForm1;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
@Component("registrationValidator1")
public class RegistrationValidator1 extends RegistrationValidator {
    @Override
    public boolean supports(final Class<?> aClass)
    {
        return RegisterForm1.class.equals(aClass);
    }
    @Override
    public void validate(final Object object, final Errors errors)
    {
        final RegisterForm1 registerForm = (RegisterForm1) object;
        final String titleCode = registerForm.getTitleCode();
        final String firstName = registerForm.getFirstName();
        final String lastName = registerForm.getLastName();
        final String codePostal = registerForm.getCodePostal();
        final String email = registerForm.getEmail();
        final String pwd = registerForm.getPwd();
        final String checkPwd = registerForm.getCheckPwd();
        final boolean termsCheck = registerForm.isTermsCheck();

        validateTitleCode(errors, titleCode);
        validateName(errors, firstName, "firstName", "register.firstName.invalid");
        validateName(errors, lastName, "lastName", "register.lastName.invalid");
        validateName(errors, codePostal, "codePostal", "register.codePostal.invalid");

        if (StringUtils.length(firstName) + StringUtils.length(lastName) > 255)
        {
            errors.rejectValue("lastName", "register.name.invalid");
            errors.rejectValue("firstName", "register.name.invalid");
        }
        if (StringUtils.length(codePostal)  > 10)
        {
            errors.rejectValue("codePostal", "register.codePostal.invalid");
        }

        validateEmail(errors, email);
        validatePassword(errors, pwd);
        comparePasswords(errors, pwd, checkPwd);
        validateTermsAndConditions(errors, termsCheck);
    }
}
