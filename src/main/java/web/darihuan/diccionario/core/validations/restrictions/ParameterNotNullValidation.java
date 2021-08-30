package web.darihuan.diccionario.core.validations.restrictions;

import web.darihuan.diccionario.core.exception.ParametrosIncorrectosException;
import web.darihuan.diccionario.core.validations.anotations.parameterNotNull;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ParameterNotNullValidation implements ConstraintValidator<parameterNotNull, Object> {
    @Override
    public void initialize(parameterNotNull constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Object parameter, ConstraintValidatorContext context) {
        if (parameter == null)
            throw new ParametrosIncorrectosException("El parametro no puede ser nulo");
        else
            return true;
    }
}
