package web.darihuan.diccionario.core.validations.anotations;

import web.darihuan.diccionario.core.validations.restrictions.ParameterNotNullValidation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ParameterNotNullValidation.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface parameterNotNull {
    String message() default "El parametro no puede ser nulo";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
