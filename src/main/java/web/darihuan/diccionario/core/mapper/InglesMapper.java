package web.darihuan.diccionario.core.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import web.darihuan.diccionario.espanol.infrastructure.repository.EspanolRepository;
import web.darihuan.diccionario.ingles.domain.Ingles;
import web.darihuan.diccionario.ingles.infrastructure.controller.dto.InglesInputDto;
import web.darihuan.diccionario.ingles.infrastructure.controller.dto.InglesOutputDto;
import web.darihuan.diccionario.ingles.infrastructure.controller.dto.InglesSimpleOutputDto;

@Component
public class InglesMapper {
    @Autowired
    EspanolRepository repositoryEspanol;
    @Autowired
    EspanolMapper mapperEspanol;

    public Ingles toEntity(InglesInputDto inputDto) {
        Ingles entidad = new Ingles();
        entidad.setPalabra(inputDto.getPalabra());
        /**control errores*/
        entidad.setPalabraEspanol(this.repositoryEspanol.findByPalabra(inputDto.getPalabraEspanol()).get());
        return entidad;
    }

    public InglesSimpleOutputDto toSimpleOutputDto(Ingles entidad) {
        InglesSimpleOutputDto devolver = new InglesSimpleOutputDto();
        devolver.setId(entidad.getId());
        devolver.setPalabra(entidad.getPalabra());
        devolver.setPalabraEspanol(entidad.getPalabraEspanol().getPalabra());
        devolver.setFechaAlta(entidad.getFechaAlta());
        devolver.setFechaModificacion(entidad.getFechaModif());

        return devolver;
    }

    public InglesOutputDto toOutputDto(Ingles entidad) {
        InglesOutputDto devolver = new InglesOutputDto();
        devolver.setId(entidad.getId());
        devolver.setPalabra(entidad.getPalabra());
        devolver.setPalabraEspanol(entidad.getPalabraEspanol().getPalabra());
        devolver.setEspanolSimpleOutputDto(mapperEspanol.toSimpleOutputDto(entidad.getPalabraEspanol()));
        devolver.setFechaAlta(entidad.getFechaAlta());
        devolver.setFechaModificacion(entidad.getFechaModif());
        return devolver;
    }
}
