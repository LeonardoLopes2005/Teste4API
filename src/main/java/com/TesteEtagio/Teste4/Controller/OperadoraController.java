package com.TesteEtagio.Teste4.Controller;


import com.TesteEtagio.Teste4.entity.Operadora;
import com.TesteEtagio.Teste4.service.OperadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/operadoras")
public class OperadoraController {

    @Autowired
    private OperadoraService operadoraService;

    //buscar operadoras no CSV
    @GetMapping("/buscar")
    public List<Operadora> buscarOperadoras(@RequestParam String nome) {
        return operadoraService.buscarOperadoras(nome);
    }
}
