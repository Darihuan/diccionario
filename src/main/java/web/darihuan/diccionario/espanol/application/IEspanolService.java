package web.darihuan.diccionario.espanol.application;

import web.darihuan.diccionario.espanol.infrastructure.controller.dto.EspanolInputDto;
import web.darihuan.diccionario.espanol.infrastructure.controller.dto.EspanolOutputDto;
import web.darihuan.diccionario.espanol.infrastructure.controller.dto.EspanolSimpleOutputDto;

import java.util.List;

public interface IEspanolService {
    EspanolSimpleOutputDto addPalabra(EspanolInputDto palabra) throws Exception;

    EspanolSimpleOutputDto updatePalabra(EspanolInputDto palabraNueva, String palabraVieja);

    EspanolOutputDto getPalabra(String palabraBuscar);

    List<EspanolOutputDto> getDiccionario();

    void deletePalabra(String palabraBorrar);

    void deleteDiccionario();
}
