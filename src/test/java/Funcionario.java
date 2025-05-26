public class Funcionario {
    private String nome;
    private int horasTrabalhadas;
    private double valorHora;

    public Funcionario(String nome, int horasTrabalhadas, double valorHora) {
        if (horasTrabalhadas < 20 || horasTrabalhadas > 40) {
            throw new IllegalArgumentException("Carga horária deve estar entre 20 e 40 horas.");
        }
        if (valorHora < 60.72 || valorHora > 151.80) {
            throw new IllegalArgumentException("Valor por hora deve estar entre 4% e 10% do salário mínimo (R$1518.00).");
        }

        this.nome = nome;
        this.horasTrabalhadas = horasTrabalhadas;
        this.valorHora = valorHora;
    }

    public double calcularPagamento() {
        double pagamento = horasTrabalhadas * valorHora;

        if (pagamento < 1518.00) {
            throw new IllegalArgumentException("Pagamento abaixo do salário mínimo.");
        }

        if (pagamento > 100000.00) {
            throw new IllegalArgumentException("Pagamento excede o teto permitido.");
        }

        return pagamento;
    }

    public String getNome() {
        return nome;
    }

    public int getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public double getValorHora() {
        return valorHora;
    }
}
