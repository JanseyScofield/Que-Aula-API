package com.scofield.que_aula_api;

import org.springframework.web.bind.MethodArgumentNotValidException;

public class AulasModel {
    private int diaSemana;
    private int periodo;
    private String nomeProfessor;
    private String sala;

    public AulasModel(int diaSemana, int periodo, String nomeProfessor, String sala){
        this.diaSemana = diaSemana;
        this.periodo = periodo;
        this.nomeProfessor = nomeProfessor;
        this.sala = sala;
    }

    public int getDiaSemana(){
        return this.diaSemana;
    }

    public void setDiaSemana(int novoDiaSemana){
       if(novoDiaSemana < 0 || novoDiaSemana > 6){
           throw new IllegalArgumentException("Valor de dia da semana inválido");
       }
       this.diaSemana = novoDiaSemana;
    }

    public int getPeriodo(){
        return this.periodo;
    }

    public void setPeriodo(int novoPeriodo){
        if(novoPeriodo < 0 || novoPeriodo > 6){
            throw new IllegalArgumentException("Valor de período inválido");
        }
        this.periodo = novoPeriodo;
    }

    public String getNomeProfessor(){
        return this.nomeProfessor;
    }

    public void setNomeProfessor(String novoProfessor){
        if(novoProfessor == null || novoProfessor.trim().isEmpty()){
            throw new IllegalArgumentException("O nome do professor não pode estar vazio");
        }
        this.nomeProfessor = novoProfessor;
    }

    public String getSala(){
        return this.sala;
    }

    public void setSala(String novaSala){
        if(novaSala == null ||novaSala.trim().isEmpty()){
            throw new IllegalArgumentException("O nome da sala não pode estar vazio");
        }
        this.sala = novaSala;
    }
}
