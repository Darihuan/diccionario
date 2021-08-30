package web.darihuan.diccionario.espanol.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.darihuan.diccionario.core.exception.ConflictException;
import web.darihuan.diccionario.core.exception.NotFoundException;
import web.darihuan.diccionario.core.mapper.EspanolMapper;
import web.darihuan.diccionario.espanol.domain.Espanol;
import web.darihuan.diccionario.espanol.infrastructure.controller.dto.EspanolInputDto;
import web.darihuan.diccionario.espanol.infrastructure.controller.dto.EspanolOutputDto;
import web.darihuan.diccionario.espanol.infrastructure.controller.dto.EspanolSimpleOutputDto;
import web.darihuan.diccionario.espanol.infrastructure.repository.EspanolRepository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EspanolServiceImp implements IEspanolService {
    @Autowired
    EspanolRepository espanolRepository;
    @Autowired
    EspanolMapper mapper;

    @Transactional
    @Override
    public EspanolSimpleOutputDto addPalabra(EspanolInputDto word) {
        Espanol wordToSave = mapper.toEntity(word);

        if (this.espanolRepository.existsByPalabra(wordToSave.getPalabra()))
            throw new ConflictException("Palabra duplicada");

        wordToSave.setFechaAlta(new Date());
        return mapper.toSimpleOutputDto(this.espanolRepository.save(wordToSave));


    }

    @Transactional
    @Override
    public EspanolSimpleOutputDto updatePalabra(EspanolInputDto newWord, String oldWord) {
        Espanol updatedWord = this.espanolRepository
                .findByPalabra(oldWord)
                .orElseThrow(() -> new NotFoundException("No existe la palabra"));

        updatedWord.setDescripcion(newWord.getDescripcion());
        updatedWord.setFecha_modif(new Date());
        return mapper.toSimpleOutputDto(this.espanolRepository.save(updatedWord));


    }

    @Transactional
    @Override
    public EspanolOutputDto getPalabra(String searchWord) {
        Espanol foundWord = this.espanolRepository
                .findByPalabra(searchWord)
                .orElseThrow(() -> new NotFoundException("No existe la palabra"));

        return this.mapper.toOutputDto(foundWord);

    }

    @Transactional
    @Override
    public List<EspanolOutputDto> getDiccionario() {
        List<Espanol> diccionario = this.espanolRepository.findAll();
        return diccionario.stream()
                .map(palabra -> this.mapper.toOutputDto(palabra))
                .collect(Collectors.toList());

    }

    @Transactional
    @Override
    public void deletePalabra(String deleteword) {
        this.espanolRepository.delete(this.espanolRepository.findByPalabra(deleteword)
                .orElseThrow(() -> new NotFoundException("No existe la palabra")));
    }

    @Transactional
    @Override
    public void deleteDiccionario() {
        this.espanolRepository.deleteAll();
    }
}
