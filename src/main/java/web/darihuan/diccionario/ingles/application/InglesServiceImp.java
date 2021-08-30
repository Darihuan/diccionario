package web.darihuan.diccionario.ingles.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.darihuan.diccionario.core.exception.NotAcceptableException;
import web.darihuan.diccionario.core.exception.NotFoundException;
import web.darihuan.diccionario.core.mapper.InglesMapper;
import web.darihuan.diccionario.espanol.domain.Espanol;
import web.darihuan.diccionario.espanol.infrastructure.repository.EspanolRepository;
import web.darihuan.diccionario.ingles.domain.Ingles;
import web.darihuan.diccionario.ingles.infrastructure.controller.dto.InglesInputDto;
import web.darihuan.diccionario.ingles.infrastructure.controller.dto.InglesOutputDto;
import web.darihuan.diccionario.ingles.infrastructure.controller.dto.InglesSimpleOutputDto;
import web.darihuan.diccionario.ingles.infrastructure.repository.InglesRepository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InglesServiceImp implements IInglesService {
    @Autowired
    InglesRepository inglesRepository;
    @Autowired
    EspanolRepository espanolRepository;
    @Autowired
    InglesMapper mapper;

    @Transactional
    @Override
    public InglesSimpleOutputDto addPalabra(InglesInputDto word) {
        if (this.inglesRepository.existsByPalabra(word.getPalabra()))
            throw new NotAcceptableException("Palabras duplicadas");

        if (!this.espanolRepository.existsByPalabra(word.getPalabraEspanol()))
            throw new NotAcceptableException("Palabra en español no existe");

        Ingles newWord = mapper.toEntity(word);

        newWord.setFechaAlta(new Date());
        return mapper.toSimpleOutputDto(this.inglesRepository.save(newWord));
    }

    @Transactional
    @Override
    public InglesSimpleOutputDto updatePalabra(InglesInputDto newWord, String oldWord) {

        Ingles wordToUpdate = this.inglesRepository.findByPalabra(oldWord)
                .orElseThrow(() -> new NotAcceptableException("No existe la palabra a actualizar"));
        Espanol traduccion = this.espanolRepository.findByPalabra(newWord.getPalabraEspanol())
                .orElseThrow(() -> new NotAcceptableException("No existe la palabra en español"));

        wordToUpdate.setPalabraEspanol(traduccion);
        wordToUpdate.setFechaModif(new Date());
        return mapper.toSimpleOutputDto(this.inglesRepository.save(wordToUpdate));

    }

    @Transactional
    @Override
    public InglesOutputDto getPalabra(String searchWord) {

        Ingles foundWord = this.inglesRepository.findByPalabra(searchWord)
                .orElseThrow(() -> new NotFoundException("no existe la palabra"));

        return this.mapper.toOutputDto(foundWord);

    }

    @Transactional
    @Override
    public List<InglesOutputDto> getDiccionario() {
        List<Ingles> dictionary = this.inglesRepository.findAll();

        return dictionary.stream()
                .map(palabra -> this.mapper.toOutputDto(palabra))
                .collect(Collectors.toList());

    }

    @Transactional
    @Override
    public void deletePalabra(String palabraBorrar) {
        this.inglesRepository.delete(this.inglesRepository.findByPalabra(palabraBorrar)
                .orElseThrow(() -> new NotFoundException("No existe la palabra a borrar")));
    }

}
