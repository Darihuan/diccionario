package web.darihuan.diccionario.espanol.infrastructure.controller.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import web.darihuan.diccionario.ingles.infrastructure.controller.dto.InglesSimpleOutputDto;

import java.util.Date;
import java.util.List;
@Data
@NoArgsConstructor
@Component
public class EspanolOutputDto {
    Integer id;
    String palabra;
    String descripcion;
    Date fechaAlta;
    Date fechaModificacion;
    List<InglesSimpleOutputDto> palabrasIngles;
}
