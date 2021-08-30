package web.darihuan.diccionario.core.error;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomError {
    private Date timeStamp;
    private int HttpCode;
    private String message;

}
