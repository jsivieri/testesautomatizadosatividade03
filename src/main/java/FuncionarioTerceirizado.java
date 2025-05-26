
public class FuncionarioTerceirizado extends Funcionario {
    private double despesasAdicionais;

    public FuncionarioTerceirizado(String nome, int horasTrabalhadas, double valorHora, double despesasAdicionais) {
        super(nome, horasTrabalhadas, valorHora);
        if (despesasAdicionais > 1000.00) {
            throw new IllegalArgumentException("Despesas adicionais não podem ultrapassar R$1000.00.");
        }
        this.despesasAdicionais = despesasAdicionais;
    }

    @Override
    public double calcularPagamento() {
        return super.calcularPagamento() + 1.1 * despesasAdicionais;
    }

    public double getDespesasAdicionais() {
        return despesasAdicionais;
    }
}
