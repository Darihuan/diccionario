package web.darihuan.diccionario.core.error;

import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class ErrorInParams extends CustomError {
    private Date timeStamp;
    private int HttpCode;
    private String message;
    List<ParameterViolations> parameterViolations;

    public ErrorInParams(Date timeStamp, int HttpCode, String message, List<ParameterViolations> parameterViolations) {
        super(timeStamp, HttpCode, message);
        this.parameterViolations=parameterViolations;
    }
}
