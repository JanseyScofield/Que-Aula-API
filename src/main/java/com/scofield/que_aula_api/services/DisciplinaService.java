package com.scofield.que_aula_api.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.scofield.que_aula_api.models.AulasModel;
import com.scofield.que_aula_api.models.DisciplinaModel;
import com.scofield.que_aula_api.repository.DisiciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class DisciplinaService {

    @Autowired
    private DisiciplinaRepository disiciplinaRepository;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public void carregarDisciplinas() {
        try {
            ClassPathResource resource = new ClassPathResource("data.json");
            String json = new String(Files.readAllBytes(resource.getFile().toPath()));

            List<Map<String, Object>> rawList = objectMapper.readValue(json, new TypeReference<>() {});

            List<DisciplinaModel> disciplinas = new ArrayList<>();

            for (Map<String, Object> raw : rawList) {
                String nome = (String) raw.get("name");
                String descricao = (String) raw.get("description");
                int semestre = Integer.parseInt((String) raw.get("semester"));
                boolean multiAulas = (Boolean) raw.get("multiClass");
                boolean greve = (Boolean) raw.get("greve");

                List<AulasModel> aulas = new ArrayList<>();
                List<Map<String, String>> rawAulas = (List<Map<String, String>>) raw.get("classes");

                for (Map<String, String> aula : rawAulas) {
                    int diaSemana = Integer.parseInt(aula.get("weekDay"));
                    int periodo = Integer.parseInt(aula.get("period"));
                    String nomeProfessor = aula.get("teacher");
                    String sala = aula.get("classroom");

                    aulas.add(new AulasModel(diaSemana, periodo, nomeProfessor, sala));
                }

                DisciplinaModel disciplina = new DisciplinaModel(nome, descricao, semestre, multiAulas, greve, aulas);
                disciplinas.add(disciplina);
            }
            disiciplinaRepository.setListaDisciplinas(disciplinas);
        } catch (IOException e) {
            throw new RuntimeException("Erro ao ler o arquivo JSON", e);
        }
    }
}
