package com.lm.app.validator;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.lm.app.form.CustomerForm;

// Indicates that an annotated class is a "component".
// Such classes are considered as candidates for auto-detection when using annotation-based configuration and classpath scanning.
@Component
public class CustomerFormValidator implements Validator {
 
   // Apache Commons Validator routine used for email validation.
   private EmailValidator emailValidator = EmailValidator.getInstance();
 
   // Checks if this validator is applicable for the provided class (CustomerForm in this case).
   @Override
   public boolean supports(Class<?> clazz) {
      return clazz == CustomerForm.class;
   }
 
   // Validates the form object. Errors encountered are registered into the provided Errors object.
   @Override
   public void validate(Object target, Errors errors) {
      // Cast the target object (form) to a CustomerForm.
      CustomerForm custInfo = (CustomerForm) target;
 
      // Check the fields of the CustomerForm using ValidationUtils utility methods.
      // These methods reject the value if it's empty or only contains whitespace.
      ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty.customerForm.name");
      ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty.customerForm.email");
      ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "NotEmpty.customerForm.address");
      ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "NotEmpty.customerForm.phone");
 
      // Validate the email field specifically for the correct pattern using Apache Commons EmailValidator. 
      // If the email is not valid, reject the value and register an error message.
      if (!emailValidator.isValid(custInfo.getEmail())) {
         errors.rejectValue("email", "Pattern.customerForm.email");
      }
   }
 
}
