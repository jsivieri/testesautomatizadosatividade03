public class FuncionarioTerceirizado extends Funcionario {
    private double despesasAdicionais;

    public FuncionarioTerceirizado(String nome, int horasTrabalhadas, double valorHora, double despesasAdicionais) {
        super(nome, horasTrabalhadas, valorHora);
        this.despesasAdicionais = validarDespesas(despesasAdicionais);
    }

    @Override
    public double calcularPagamento() {
        return super.calcularPagamento() + 1.1 * despesasAdicionais;
    }

    private double validarDespesas(double valor) {
        if (valor > 1000.00) {
            throw new IllegalArgumentException("Despesas adicionais não podem ultrapassar R$1000.00.");
        }
        return valor;
    }

    public void setDespesasAdicionais(double despesasAdicionais) {
        this.despesasAdicionais = validarDespesas(despesasAdicionais);
    }

    public double getDespesasAdicionais() {
        return despesasAdicionais;
    }
}
