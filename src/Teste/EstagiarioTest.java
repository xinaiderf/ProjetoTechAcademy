package Teste;

import Dominio.Estagiario;
import Servico.EstagiarioServ;

public class EstagiarioTest {
    public static void main(String[] args) {
        EstagiarioServ servico = new EstagiarioServ();

        System.out.println("----- LISTAR -----");
        for (Estagiario item : servico.listar()) {
            item.exibir();
        }

        System.out.println("\n----- BUSCAR -----");
        Estagiario estagiario = servico.buscar(401);
        if (estagiario != null) {
            estagiario.exibir();
        } else {
            System.out.println("Não encontrado");
        }

        System.out.println("\n----- ADICIONAR -----");
        Estagiario novo = new Estagiario(0, "Larissa Pinto", "4299", "larissa@email.com", "67 98888-0099",
            "Rua das Garças, 400", 1100.0, 25, "Redes");
        novo = servico.adicionar(novo);
        novo.exibir();

        System.out.println("\n----- EDITAR -----");
        novo.setValorBolsa(1300.0);
        novo.setTelefone("67 97777-0000");
        novo = servico.editar(novo);
        novo.exibir();

        System.out.println("\n----- EXCLUIR -----");
        Estagiario apagado = servico.excluir(novo);
        apagado.exibir();

        System.out.println("\n----- LISTAR DEPOIS DA EXCLUSÃO -----");
        for (Estagiario item : servico.listar()) {
            item.exibir();
        }
    }
}
