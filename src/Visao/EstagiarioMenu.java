package Visao;

import java.util.Scanner;

import Dominio.Estagiario;
import Servico.EstagiarioServ;
import Tools.Util;

public class EstagiarioMenu extends AbsMenu {

    private EstagiarioServ servico;

    private Estagiario estagiarioSelecionado;

    @Override
    public void executar(){
        int opcao = 0;
        while(opcao != 6){
            System.out.println("\n\n");
            System.out.println("----- MENU PRINCIPAL [ESTAGIARIO] -----");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar Todos");
            System.out.println("3 - Buscar por Código");
            System.out.println("4 - Editar");
            System.out.println("5 - Excluir");
            System.out.println("6 - Sair");
            System.out.print("Selecione uma opção: ");
            opcao = this.scan.nextInt();
            this.scan.nextLine();
            switch (opcao) {
                case 1:
                    this.cadastrar();
                    this.pausar();
                    break;
                case 2:
                    this.listar();
                    this.pausar();
                    break;
                case 3:
                    this.buscarPorCodigo();
                    this.pausar();
                    break;
                case 4:
                    this.editar();
                    break;
                case 5:
                    this.excluir();
                    this.pausar();
                    break;
                case 6:
                    System.out.println("TCHAU");
                    break;
                default:
                    System.out.println("OPA, OPÇÃO ERRADA!!!");
                    this.pausar();
                    break;
            }
            Util.limparTerminal();
        }
    }

    private void cadastrar(){
        System.out.println("\n\n");
        System.out.println("***** CADASTRAR *****");
        System.out.print("Nome: ");
        String nome = this.scan.nextLine();
        System.out.print("CPF: ");
        String cpf = this.scan.nextLine();
        System.out.print("E-mail: ");
        String email = this.scan.nextLine();
        System.out.print("Telefone: ");
        String telefone = this.scan.nextLine();
        System.out.print("Endereço: ");
        String endereco = this.scan.nextLine();
        System.out.print("Valor da Bolsa: ");
        Double valorBolsa = this.scan.nextDouble();
        System.out.print("Carga Horária Semanal: ");
        int cargaHoraria = this.scan.nextInt();
        this.scan.nextLine();
        System.out.print("Área do Estágio: ");
        String area = this.scan.nextLine();
        Estagiario novo = new Estagiario(0, nome, cpf, email, telefone, endereco, valorBolsa, cargaHoraria, area);
        novo = this.servico.adicionar(novo);
        novo.exibir();
    }

    private void listar(){
        System.out.println("\n\n");
        System.out.println("***** LISTAR TODOS *****");
        for(Estagiario item : this.servico.listar()){
            item.exibir();
        }
    }

    private void buscarPorCodigo(){
        System.out.println("\n\n");
        System.out.println("***** BUSCAR POR CÓDIGO *****");
        System.out.print("Digite o código: ");
        int codigo = this.scan.nextInt();
        this.scan.nextLine();
        this.estagiarioSelecionado = this.servico.buscar(codigo);
        if(this.estagiarioSelecionado != null){
            this.estagiarioSelecionado.exibir();
        }
        else{
            System.out.println("ERRO - código inválido");
        }
    }

    private void editar(){
        System.out.println("\n\n");
        System.out.println("***** EDITAR *****");
        this.buscarPorCodigo();
        if (this.estagiarioSelecionado == null){
            System.out.println("ERRO - não posso prosseguir com alteração.");
            this.pausar();
            return;
        }
        int opcao = 0;
        while (opcao != 9) {
            System.out.println("O que vc deseja alterar?");
            System.out.println("1 - Nome");
            System.out.println("2 - CPF");
            System.out.println("3 - E-mail");
            System.out.println("4 - Telefone");
            System.out.println("5 - Endereço");
            System.out.println("6 - Valor da Bolsa");
            System.out.println("7 - Carga Horária Semanal");
            System.out.println("8 - Área do Estágio");
            System.out.println("9 - Salvar");
            System.out.print("Selecione um campo: ");
            opcao = this.scan.nextInt();
            this.scan.nextLine();
            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    this.estagiarioSelecionado.setNome(this.scan.nextLine());
                    break;
                case 2:
                    System.out.print("CPF: ");
                    this.estagiarioSelecionado.setCpf(this.scan.nextLine());
                    break;
                case 3:
                    System.out.print("E-mail: ");
                    this.estagiarioSelecionado.setEmail(this.scan.nextLine());
                    break;
                case 4:
                    System.out.print("Telefone: ");
                    this.estagiarioSelecionado.setTelefone(this.scan.nextLine());
                    break;
                case 5:
                    System.out.print("Endereço: ");
                    this.estagiarioSelecionado.setEndereco(this.scan.nextLine());
                    break;
                case 6:
                    System.out.print("Valor da Bolsa: ");
                    this.estagiarioSelecionado.setValorBolsa(this.scan.nextDouble());
                    this.scan.nextLine();
                    break;
                case 7:
                    System.out.print("Carga Horária Semanal: ");
                    this.estagiarioSelecionado.setCargaHorariaSemanal(this.scan.nextInt());
                    this.scan.nextLine();
                    break;
                case 8:
                    System.out.print("Área do Estágio: ");
                    this.estagiarioSelecionado.setAreaEstagio(this.scan.nextLine());
                    break;
                case 9:
                    this.estagiarioSelecionado = this.servico.editar(this.estagiarioSelecionado);
                    this.estagiarioSelecionado.exibir();
                    this.pausar();
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }
    }

    private void excluir(){
        System.out.println("\n\n");
        System.out.println("***** EXCLUIR *****");
        this.buscarPorCodigo();
        if (this.estagiarioSelecionado == null){
            System.out.println("ERRO - não posso prosseguir com exclusão.");
            return;
        }
        System.out.print("Confirma exclusão (1-Sim / 2-Não)? ");
        int opcao = this.scan.nextInt();
        this.scan.nextLine();
        if (opcao == 1){
            this.estagiarioSelecionado = this.servico.excluir(this.estagiarioSelecionado);
            System.out.println("Excluído:");
            this.estagiarioSelecionado.exibir();
        }
    }

    public EstagiarioMenu(){
        this.servico = new EstagiarioServ();
        this.scan = new Scanner(System.in);
    }
}
