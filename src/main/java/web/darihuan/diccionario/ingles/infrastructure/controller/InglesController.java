package web.darihuan.diccionario.ingles.infrastructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.darihuan.diccionario.ingles.application.InglesServiceImp;
import web.darihuan.diccionario.ingles.infrastructure.controller.dto.InglesInputDto;
import web.darihuan.diccionario.ingles.infrastructure.controller.dto.InglesOutputDto;
import web.darihuan.diccionario.ingles.infrastructure.controller.dto.InglesSimpleOutputDto;

import javax.validation.Valid;
import java.util.List;

@RestController()
@RequestMapping("ingles")
public class InglesController {
    @Autowired
    InglesServiceImp inglesService;

    @PostMapping
    public ResponseEntity<InglesSimpleOutputDto> addPalabra(@RequestBody @Valid InglesInputDto word) {
        return ResponseEntity.status(202).body(this.inglesService.addPalabra(word));
    }

    @PutMapping("{actualWord}")
    public ResponseEntity<InglesSimpleOutputDto> updatePalabra(@RequestBody InglesInputDto newWord, @PathVariable String actualWord) {
        return ResponseEntity.status(200).body(this.inglesService.updatePalabra(newWord, actualWord));

    }

    @DeleteMapping("{deleteWord}")
    public ResponseEntity<?> deletePalabra(@PathVariable String deleteWord) {
        this.inglesService.deletePalabra(deleteWord);
        return ResponseEntity.status(200).body("{'message':'palabra borrada'}");
    }


    @GetMapping("{searchWord}")
    public ResponseEntity<InglesOutputDto> getPalabra(@PathVariable String searchWord) {
        return ResponseEntity.status(200).body(this.inglesService.getPalabra(searchWord));
    }

    @GetMapping
    public ResponseEntity<List<InglesOutputDto>> getDiccionario() {
        return ResponseEntity.status(200).body(this.inglesService.getDiccionario());

    }

}
