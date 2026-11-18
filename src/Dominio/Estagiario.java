package Dominio;

public class Estagiario extends BasePrestador {
    private Double valorBolsa;
    private int cargaHorariaSemanal;
    private String areaEstagio;

    public Double getValorBolsa() {
        return valorBolsa;
    }

    public void setValorBolsa(Double valorBolsa) {
        this.valorBolsa = valorBolsa;
    }

    public int getCargaHorariaSemanal() {
        return cargaHorariaSemanal;
    }

    public void setCargaHorariaSemanal(int cargaHorariaSemanal) {
        this.cargaHorariaSemanal = cargaHorariaSemanal;
    }

    public String getAreaEstagio() {
        return areaEstagio;
    }

    public void setAreaEstagio(String areaEstagio) {
        this.areaEstagio = areaEstagio;
    }

    @Override
    public void exibir() {
        System.out.println("[ESTAGIÁRIO] Código: " + this.codigo);
        System.out.print("Nome: " + this.nome);
        System.out.print(" | CPF: " + this.cpf);
        System.out.print(" | E-mail: " + this.email);
        System.out.print(" | Telefone: " + this.telefone);
        System.out.println(" | Endereço: " + this.endereco);
        System.out.print("Bolsa: R$ " + this.valorBolsa);
        System.out.print(" | Carga Horária: " + this.cargaHorariaSemanal + "h/semana");
        System.out.println(" | Área: " + this.areaEstagio);
    }

    public Estagiario(){}

    public Estagiario(int codigo, String nome, String cpf,
        String email, String telefone, String endereco,
        Double valorBolsa, int cargaHorariaSemanal, String areaEstagio){
        super(codigo, nome, cpf, email, telefone, endereco);
        this.valorBolsa = valorBolsa;
        this.cargaHorariaSemanal = cargaHorariaSemanal;
        this.areaEstagio = areaEstagio;
    }
}
