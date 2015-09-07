package cl.dgac.arsv.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator(value = "checkboxValidator")
public class CheckboxValidator implements Validator {

@Override
public void validate(FacesContext fc, UIComponent component, Object value) 
throws ValidatorException {
if (value.equals(Boolean.FALSE)) {
FacesMessage message = new FacesMessage();
message.setSummary("El campo es necesario");
message.setSeverity(FacesMessage.SEVERITY_ERROR);
throw new ValidatorException(message);
}
}
}