package app.loja.controllers;

import app.loja.Entities.Venda;
import app.loja.service.VendaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/app/venda")
public class VendaController {
    @Autowired
    private VendaService vendaService;

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody @Valid Venda venda){
        try {
            String result = this.vendaService.save(venda);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(
                    "Erro:" + e.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@RequestBody @Valid Venda venda, @PathVariable long id){
        try {
            String mensagem = this.vendaService.update(venda, id);
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Deu erro!"+e.getMessage(), HttpStatus.BAD_REQUEST );
        }
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Optional<Venda>> findById(@PathVariable long id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(vendaService.findById(id));
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST );
        }
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Venda>> findAll(){
        try {
            List<Venda> lista = this.vendaService.findAll();
            return new ResponseEntity<>(lista, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST );
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable long id){
        try {
            String mensagem = this.vendaService.deleteById(id);
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST );
        }

    }
}


