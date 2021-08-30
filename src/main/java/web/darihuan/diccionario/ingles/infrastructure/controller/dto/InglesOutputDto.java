package web.darihuan.diccionario.ingles.infrastructure.controller.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import web.darihuan.diccionario.espanol.infrastructure.controller.dto.EspanolSimpleOutputDto;

import java.util.Date;

@Data
@NoArgsConstructor
public class InglesOutputDto {
    Integer id;
    String palabra;
    String palabraEspanol;
    Date fechaAlta;
    Date fechaModificacion;
    EspanolSimpleOutputDto espanolSimpleOutputDto;
}
