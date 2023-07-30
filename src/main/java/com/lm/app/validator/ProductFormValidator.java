package com.lm.app.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.lm.app.dao.ProductDAO;
import com.lm.app.entity.Product;
import com.lm.app.form.ProductForm;

// This annotation is used to denote classes as components that are to be auto-detected by Spring's scanning.
@Component
public class ProductFormValidator implements Validator {
 
   // Autowired to inject an instance of ProductDAO for product operations.
   @Autowired
   private ProductDAO productDAO;
 
   // This validator only checks for the ProductForm.
   // Returns true if this validator can validate instances of the supplied class.
   @Override
   public boolean supports(Class<?> clazz) {
      return clazz == ProductForm.class;
   }
 
   // Implementing the validation logic for ProductForm in this method.
   @Override
   public void validate(Object target, Errors errors) {
      // Cast the target object to a ProductForm.
      ProductForm productForm = (ProductForm) target;
 
      // Using ValidationUtils to reject empty or whitespace only fields.
      ValidationUtils.rejectIfEmptyOrWhitespace(errors, "code", "NotEmpty.productForm.code");
      ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty.productForm.name");
      ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "NotEmpty.productForm.price");
 
      // Extracting the product code from the form.
      String code = productForm.getCode();
      if (code != null && code.length() > 0) {
         // Rejecting product codes that only contain whitespace.
         if (code.matches("\\s+")) {
            errors.rejectValue("code", "Pattern.productForm.code");
         } else if (productForm.isNewProduct()) {
            // Checking if the product code already exists in the database for new products.
            Product product = productDAO.findProduct(code);
            if (product != null) {
               // Rejecting product codes that already exist in the database.
               errors.rejectValue("code", "Duplicate.productForm.code");
            }
         }
      }
   }
}
