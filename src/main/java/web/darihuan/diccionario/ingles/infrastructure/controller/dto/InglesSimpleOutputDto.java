package web.darihuan.diccionario.ingles.infrastructure.controller.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class InglesSimpleOutputDto {
    Integer id;
    String palabra;
    String palabraEspanol;
    Date fechaAlta;
    Date fechaModificacion;
}
