package com.scofield.que_aula_api;

public class DisciplinaModel {
    private String nome;
    private String descricao;
    private int semestre;
    private boolean multiAulas;
    private boolean greve;

    public DisciplinaModel(String nome, String descricao, int semestre, boolean multiAulas, boolean greve) {
        this.nome = nome;
        this.descricao = descricao;
        this.semestre = semestre;
        this.multiAulas = multiAulas;
        this.greve = greve;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String novoNome) {
        if (novoNome == null || novoNome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome da disciplina não pode estar vazio");
        }
        this.nome = novoNome;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String novaDescricao) {
        if (novaDescricao == null || novaDescricao.trim().isEmpty()) {
            throw new IllegalArgumentException("A descrição da disciplina não pode estar vazia");
        }
        this.descricao = novaDescricao;
    }

    public int getSemestre() {
        return this.semestre;
    }

    public void setSemestre(int novoSemestre) {
        if (novoSemestre < 0 || novoSemestre > 6) {
            throw new IllegalArgumentException("O semestre não pode ser negativo");
        }
        this.semestre = novoSemestre;
    }

    public boolean isMultiAulas() {
        return this.multiAulas;
    }

    public void setMultiAulas(boolean multiAulas) {
        this.multiAulas = multiAulas;
    }

    public boolean isGreve() {
        return this.greve;
    }

    public void setGreve(boolean greve) {
        this.greve = greve;
    }
}
