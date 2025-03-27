package com.TesteEtagio.Teste4.service;

import com.TesteEtagio.Teste4.entity.Operadora;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class OperadoraService {

    private static final String CSV_FILE_PATH = "https://dadosabertos.ans.gov.br/FTP/PDA/operadoras_de_plano_de_saude_ativas/";

    public List<Operadora> buscarOperadoras(String nome) {
        List<Operadora> operadoras = new ArrayList<>();
        try {
            FileReader reader = new FileReader(CSV_FILE_PATH);
            Iterable<CSVRecord> records = CSVFormat.DEFAULT.withHeader().parse(reader);

            for (CSVRecord record : records) {
                String operadoraNome = record.get("NomeOperadora");
                if (operadoraNome != null && operadoraNome.toLowerCase().contains(nome.toLowerCase())) {
                    Operadora operadora = new Operadora();
                    operadora.setNome(operadoraNome);
                    operadora.setCodigo(record.get("Codigo"));
                    // Adicionar outros campos se necessário
                    operadoras.add(operadora);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return operadoras;
    }
}
