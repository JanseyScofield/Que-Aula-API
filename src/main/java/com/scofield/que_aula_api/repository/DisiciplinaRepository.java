package com.scofield.que_aula_api.repository;

import com.scofield.que_aula_api.models.DisciplinaModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DisiciplinaRepository {
    private List<DisciplinaModel> listaDisciplinas;

    public DisiciplinaRepository(){
        this.listaDisciplinas = null;
    }

    public List<DisciplinaModel> getListaDisciplinas(){
        return this.listaDisciplinas;
    }

    public void setListaDisciplinas(List<DisciplinaModel> disciplinas){
        this.listaDisciplinas = disciplinas;
    }
}
