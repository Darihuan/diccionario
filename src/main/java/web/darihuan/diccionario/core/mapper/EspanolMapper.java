package web.darihuan.diccionario.core.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import web.darihuan.diccionario.espanol.domain.Espanol;
import web.darihuan.diccionario.espanol.infrastructure.controller.dto.EspanolInputDto;
import web.darihuan.diccionario.espanol.infrastructure.controller.dto.EspanolOutputDto;
import web.darihuan.diccionario.espanol.infrastructure.controller.dto.EspanolSimpleOutputDto;
import web.darihuan.diccionario.ingles.infrastructure.controller.dto.InglesSimpleOutputDto;

import javax.persistence.CascadeType;
import java.util.ArrayList;
import java.util.stream.Collectors;


@Component
public class EspanolMapper {
    @Autowired
    InglesMapper inglesMapper;

    public Espanol toEntity(EspanolInputDto inputDto) {
        Espanol entidad = new Espanol();
        entidad.setPalabra(inputDto.getPalabra());
        entidad.setDescripcion(inputDto.getDescripcion());
        return entidad;
    }

    public EspanolOutputDto toOutputDto(Espanol espanol) {
        EspanolOutputDto convertir = new EspanolOutputDto();
        convertir.setId(espanol.getId());
        convertir.setPalabra(espanol.getPalabra());
        convertir.setDescripcion(espanol.getDescripcion());
        convertir.setFechaAlta(espanol.getFechaAlta());
        convertir.setFechaModificacion(espanol.getFecha_modif());
        ArrayList<InglesSimpleOutputDto>palabrasingles=new ArrayList<>();
        espanol.getPalabrasIngles().stream().forEach(palabra->palabrasingles.add(this.inglesMapper.toSimpleOutputDto(palabra)));
        convertir.setPalabrasIngles(palabrasingles);

        return convertir;
    }
    public EspanolSimpleOutputDto toSimpleOutputDto(Espanol espanol) {
        EspanolSimpleOutputDto convertir = new EspanolSimpleOutputDto();
        convertir.setId(espanol.getId());
        convertir.setPalabra(espanol.getPalabra());
        convertir.setDescripcion(espanol.getDescripcion());
        convertir.setFechaAlta(espanol.getFechaAlta());
        convertir.setFechaModificacion(espanol.getFecha_modif());

        return convertir;
    }


}
