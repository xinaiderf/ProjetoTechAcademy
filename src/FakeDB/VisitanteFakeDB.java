package FakeDB;

import java.util.ArrayList;

import Dominio.Visitante;

public class VisitanteFakeDB extends AbsGenericFakeDB<Visitante> {

    @Override
    protected void autoPreencher() {
        this.dados.add(new Visitante(301, "Carla Mendes", "3231", "carla@email.com", "67 99999-0001",
            "Rua A, 10", "Reunião", 1, "Diretoria"));
        this.dados.add(new Visitante(302, "Paulo Ramos", "3232", "paulo@email.com", "67 99999-0002",
            "Rua B, 20", "Entrevista", 2, "RH"));
        this.dados.add(new Visitante(303, "Sofia Nunes", "3233", "sofia@email.com", "67 99999-0003",
            "Rua C, 30", "Manutenção", 3, "TI"));
    }

    public VisitanteFakeDB(){
        this.dados = new ArrayList<>();
        this.autoPreencher();
    }
}
