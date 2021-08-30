package web.darihuan.diccionario.ingles.application;

import web.darihuan.diccionario.ingles.infrastructure.controller.dto.InglesInputDto;
import web.darihuan.diccionario.ingles.infrastructure.controller.dto.InglesOutputDto;
import web.darihuan.diccionario.ingles.infrastructure.controller.dto.InglesSimpleOutputDto;

import java.util.List;

public interface IInglesService {
    InglesSimpleOutputDto addPalabra(InglesInputDto palabra);

    InglesSimpleOutputDto updatePalabra(InglesInputDto palabraNueva, String palabraVieja);

    InglesOutputDto getPalabra(String palabraBuscar);

    List<InglesOutputDto> getDiccionario();

    void deletePalabra(String palabraBorrar);


}
