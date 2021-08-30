package web.darihuan.diccionario.ingles.infrastructure.controller.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import web.darihuan.diccionario.core.validations.anotations.englishParameterNotNull;


@Data
@NoArgsConstructor
public class InglesInputDto {

    @englishParameterNotNull
    String palabra;
    @englishParameterNotNull
    String palabraEspanol;
}
