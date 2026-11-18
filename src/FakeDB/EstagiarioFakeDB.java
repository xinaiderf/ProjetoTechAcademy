package FakeDB;

import java.util.ArrayList;

import Dominio.Estagiario;

public class EstagiarioFakeDB extends AbsGenericFakeDB<Estagiario> {

    @Override
    protected void autoPreencher() {
        this.dados.add(new Estagiario(401, "Gabriel Lopes", "4231", "gabriel@email.com", "67 98888-0001",
            "Av. Afonso Pena, 100", 1200.0, 30, "Desenvolvimento"));
        this.dados.add(new Estagiario(402, "Beatriz Melo", "4232", "beatriz@email.com", "67 98888-0002",
            "Av. Mato Grosso, 200", 1000.0, 20, "Suporte"));
        this.dados.add(new Estagiario(403, "Thiago Prado", "4233", "thiago@email.com", "67 98888-0003",
            "Rua 14 de Julho, 300", 1500.0, 30, "Banco de Dados"));
    }

    public EstagiarioFakeDB(){
        this.dados = new ArrayList<>();
        this.autoPreencher();
    }
}
