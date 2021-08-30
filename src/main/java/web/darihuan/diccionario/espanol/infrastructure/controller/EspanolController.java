package web.darihuan.diccionario.espanol.infrastructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.darihuan.diccionario.espanol.application.EspanolServiceImp;
import web.darihuan.diccionario.espanol.infrastructure.controller.dto.EspanolInputDto;
import web.darihuan.diccionario.espanol.infrastructure.controller.dto.EspanolOutputDto;
import web.darihuan.diccionario.espanol.infrastructure.controller.dto.EspanolSimpleOutputDto;

import javax.validation.Valid;


@RestController
@RequestMapping("espanol")
public class EspanolController {
    @Autowired
    EspanolServiceImp espanolservice;

    @PostMapping
    public ResponseEntity<EspanolSimpleOutputDto> addPalabra(@RequestBody @Valid EspanolInputDto word) {
        return ResponseEntity.status(202).body(this.espanolservice.addPalabra(word));

    }

    @PutMapping("{oldWord}")
    public ResponseEntity<EspanolSimpleOutputDto> updatePalabra(@RequestBody EspanolInputDto newWord, @PathVariable String oldWord) {
        return ResponseEntity.status(200).body(this.espanolservice.updatePalabra(newWord, oldWord));

    }

    /*cascade delete */
    @DeleteMapping("{deleteWord}")
    public ResponseEntity<Object> deletePalabra(@PathVariable String deleteWord) {
        this.espanolservice.deletePalabra(deleteWord);
        return ResponseEntity.status(204).body("{'message':'palabra borrada'}");
    }

    @DeleteMapping
    public ResponseEntity<Object> deleteDiccionario() {
        this.espanolservice.deleteDiccionario();
        return ResponseEntity.status(200).body("{'message':'Todas palabras español borradas'}");
    }

    @GetMapping("{searchWord}")
    public ResponseEntity<EspanolOutputDto> getPalabra(@PathVariable String searchWord) {
        return ResponseEntity.status(200).body(this.espanolservice.getPalabra(searchWord));
    }

    @GetMapping
    public ResponseEntity<?> getDiccionario() {
        return ResponseEntity.status(200).body(this.espanolservice.getDiccionario());

    }

}
