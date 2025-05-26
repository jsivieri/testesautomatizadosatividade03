
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FuncionarioTest {

    @Test
    public void testCalculoPagamentoValido() {
        Funcionario funcionario = new Funcionario("João", 30, 70.00);
        assertEquals(2100.00, funcionario.calcularPagamento(), 0.01);
    }

    @Test
    public void testPagamentoAbaixoSalarioMinimo() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Funcionario funcionario = new Funcionario("Ana", 20, 60.00);
            funcionario.calcularPagamento();
        });
        assertEquals("Pagamento abaixo do salário mínimo.", exception.getMessage());
    }

    @Test
    public void testPagamentoAcimaDoTeto() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Funcionario funcionario = new Funcionario("Carlos", 40, 3000.00);
            funcionario.calcularPagamento();
        });
        assertEquals("Pagamento excede o teto permitido.", exception.getMessage());
    }

    @Test
    public void testHorasTrabalhadasInvalidas() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Funcionario("Luana", 10, 80.00);
        });
        assertEquals("Carga horária deve estar entre 20 e 40 horas.", exception.getMessage());
    }

    @Test
    public void testValorHoraInvalido() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Funcionario("Pedro", 25, 40.00);
        });
        assertEquals("Valor por hora deve estar entre 4% e 10% do salário mínimo (R$1518.00).", exception.getMessage());
    }
}
