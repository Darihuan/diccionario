package web.darihuan.diccionario.core.validations.restrictions;

import web.darihuan.diccionario.core.exception.NotAcceptableException;
import web.darihuan.diccionario.core.validations.anotations.englishParameterNotNull;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EnglishParameterNotNullValidation implements ConstraintValidator<englishParameterNotNull, Object> {
    public void initialize(englishParameterNotNull constraint) {
    }

    public boolean isValid(Object parameter, ConstraintValidatorContext context) {
        if (parameter == null)
            throw new NotAcceptableException("El parametro no puede ser nulo");
        else
            return true;
    }
}

