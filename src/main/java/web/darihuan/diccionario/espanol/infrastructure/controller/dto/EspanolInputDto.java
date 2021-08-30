package web.darihuan.diccionario.espanol.infrastructure.controller.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import web.darihuan.diccionario.core.validations.anotations.parameterNotNull;

@Data
@NoArgsConstructor
@Component
public class EspanolInputDto {
    @parameterNotNull
    String palabra;
    @parameterNotNull
    String descripcion;
}
