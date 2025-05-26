public class Funcionario {
    private String nome;
    private int horasTrabalhadas;
    private double valorHora;

    public Funcionario(String nome, int horasTrabalhadas, double valorHora) {
        this.nome = nome;
        this.horasTrabalhadas = validarHorasTrabalhadas(horasTrabalhadas);
        this.valorHora = validarValorHora(valorHora);
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

    private int validarHorasTrabalhadas(int horas) {
        if (horas < 20 || horas > 40) {
            throw new IllegalArgumentException("Carga horária deve estar entre 20 e 40 horas.");
        }
        return horas;
    }

    private double validarValorHora(double valor) {
        if (valor < 60.72 || valor > 151.80) {
            throw new IllegalArgumentException("Valor por hora deve estar entre 4% e 10% do salário mínimo (R$1518.00).");
        }
        return valor;
    }

    public void setHorasTrabalhadas(int horasTrabalhadas) {
        this.horasTrabalhadas = validarHorasTrabalhadas(horasTrabalhadas);
    }

    public void setValorHora(double valorHora) {
        this.valorHora = validarValorHora(valorHora);
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
