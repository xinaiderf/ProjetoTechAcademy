package FakeDB;

import java.util.ArrayList;

import Dominio.Egresso;

public class EgressoFakeDB extends AbsGenericFakeDB<Egresso> {

    @Override
    protected void autoPreencher() {
        this.dados.add(new Egresso(201, "Rafael Souza", "2231", 2022, "TADS", "Desenvolvimento Web"));
        this.dados.add(new Egresso(202, "Juliana Rocha", "2232", 2023, "Ciência da Computação", "Ciência de Dados"));
        this.dados.add(new Egresso(203, "Bruno Teixeira", "2233", 2024, "TADS", "Infraestrutura"));
        this.dados.add(new Egresso(204, "Fernanda Dias", "2234", 2025, "Engenharia de Software", "QA"));
    }

    public EgressoFakeDB(){
        this.dados = new ArrayList<>();
        this.autoPreencher();
    }
}
