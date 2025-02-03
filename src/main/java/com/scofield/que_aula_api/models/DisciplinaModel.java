    package com.scofield.que_aula_api.models;

    import java.util.List;

    public class DisciplinaModel {
        private String nome;
        private String descricao;
        private int semestre;
        private boolean multiAulas;
        private boolean greve;
        private List<AulasModel> aulas;

        public DisciplinaModel(String nome, String descricao, int semestre, boolean multiAulas, boolean greve , List<AulasModel> aulas) {
            this.nome = nome;
            this.descricao = descricao;
            this.semestre = semestre;
            this.multiAulas = multiAulas;
            this.greve = greve;
            this.aulas = aulas;
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

        public List<AulasModel> getAulas(){
            return this.aulas;
        }

        public void setAulas(List<AulasModel> aulas){
            this.aulas = aulas;
        }
    }
