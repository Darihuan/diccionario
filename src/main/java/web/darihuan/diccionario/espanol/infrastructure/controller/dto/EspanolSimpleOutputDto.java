package web.darihuan.diccionario.espanol.infrastructure.controller.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;
@Data
@NoArgsConstructor
@Component
public class EspanolSimpleOutputDto {
    Integer id;
    String palabra;
    String descripcion;
    Date fechaAlta;
    Date fechaModificacion;
}
