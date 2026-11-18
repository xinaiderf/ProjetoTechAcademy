package Teste;

import Dominio.Visitante;
import Servico.VisitanteServ;

public class VisitanteTest {
    public static void main(String[] args) {
        VisitanteServ servico = new VisitanteServ();

        System.out.println("----- LISTAR -----");
        for (Visitante item : servico.listar()) {
            item.exibir();
        }

        System.out.println("\n----- BUSCAR -----");
        Visitante visitante = servico.buscar(301);
        if (visitante != null) {
            visitante.exibir();
        } else {
            System.out.println("Não encontrado");
        }

        System.out.println("\n----- ADICIONAR -----");
        Visitante novo = new Visitante(0, "Igor Campos", "3299", "igor@email.com", "67 99999-0099",
            "Rua D, 40", "Palestra", 4, "Auditório");
        novo = servico.adicionar(novo);
        novo.exibir();

        System.out.println("\n----- EDITAR -----");
        novo.setSetorVisita("Laboratório");
        novo.setEmail("igor.campos@email.com");
        novo = servico.editar(novo);
        novo.exibir();

        System.out.println("\n----- EXCLUIR -----");
        Visitante apagado = servico.excluir(novo);
        apagado.exibir();

        System.out.println("\n----- LISTAR DEPOIS DA EXCLUSÃO -----");
        for (Visitante item : servico.listar()) {
            item.exibir();
        }
    }
}
