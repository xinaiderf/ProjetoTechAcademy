package Teste;

import Dominio.Egresso;
import Servico.EgressoServ;

public class EgressoTest {
    public static void main(String[] args) {
        EgressoServ servico = new EgressoServ();

        System.out.println("----- LISTAR -----");
        for (Egresso item : servico.listar()) {
            item.exibir();
        }

        System.out.println("\n----- BUSCAR -----");
        Egresso egresso = servico.buscar(201);
        if (egresso != null) {
            egresso.exibir();
        } else {
            System.out.println("Não encontrado");
        }

        System.out.println("\n----- ADICIONAR -----");
        Egresso novo = new Egresso(0, "Lucia Martins", "2299", 2026, "TADS", "Mobile");
        novo = servico.adicionar(novo);
        novo.exibir();

        System.out.println("\n----- EDITAR -----");
        novo.setAreaAtuacao("Backend");
        novo = servico.editar(novo);
        novo.exibir();

        System.out.println("\n----- EXCLUIR -----");
        Egresso apagado = servico.excluir(novo);
        apagado.exibir();

        System.out.println("\n----- LISTAR DEPOIS DA EXCLUSÃO -----");
        for (Egresso item : servico.listar()) {
            item.exibir();
        }
    }
}
