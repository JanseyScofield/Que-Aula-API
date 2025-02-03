package com.scofield.que_aula_api.controllers;

import com.scofield.que_aula_api.models.DisciplinaModel;
import com.scofield.que_aula_api.services.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/disciplinas")
public class DisciplinaController {

    @Autowired
    private DisciplinaService disciplinaService;

    @GetMapping
    public String carregarDisciplinas(){
        try{
           disciplinaService.carregarDisciplinas();
           return "Disciplinas carregadas com sucesso!";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/obter")
    public List<DisciplinaModel> obterDisciplinas(){
        try{
            return disciplinaService.obterTodasDisciplinas();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
