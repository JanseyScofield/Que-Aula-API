package com.scofield.que_aula_api.controllers;

import com.scofield.que_aula_api.models.DisciplinaModel;
import com.scofield.que_aula_api.services.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/disciplinas")
public class DisciplinaController {

    @Autowired
    private DisciplinaService disciplinaService;

    @GetMapping
    public ResponseEntity<String> carregarDisciplinas(){
        disciplinaService.carregarDisciplinas();
        return ResponseEntity.ok("Disciplinas carregadas com sucesso!");
    }

    @GetMapping("/obter")
    public ResponseEntity<List<DisciplinaModel>> obterDisciplinas(){
        return ResponseEntity.ok().body(disciplinaService.obterTodasDisciplinas());
    }
}
