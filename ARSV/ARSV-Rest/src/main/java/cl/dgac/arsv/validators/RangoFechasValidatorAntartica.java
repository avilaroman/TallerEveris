package cl.dgac.arsv.validators;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("rangoFechasValidatorAntartica")
public class RangoFechasValidatorAntartica implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		if (value == null) {
			return; // Es obligatoria.
		}

		UIInput startDateComponent = (UIInput) component.getAttributes().get("fechaArriboComponent");

		if (!startDateComponent.isValid()) {
			return; // No es valida.
		}

		Date startDate = (Date) startDateComponent.getValue();

		if (startDate == null) {
			return; // Es obligatoria.
		}

		Date endDate = (Date) value;

		if (startDate.after(endDate)) {
			startDateComponent.setValid(false);
			throw new ValidatorException(new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"La fecha de salida debe ser mayor a la fecha de arribo", null));
		}
	}

}
