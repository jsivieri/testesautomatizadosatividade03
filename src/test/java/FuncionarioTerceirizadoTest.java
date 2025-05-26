
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FuncionarioTerceirizadoTest {

    @Test
    public void testCalculoPagamentoTerceirizadoValido() {
        FuncionarioTerceirizado funcionario = new FuncionarioTerceirizado("Marcos", 30, 70.00, 500.00);
        assertEquals(2100.00 + 550.00, funcionario.calcularPagamento(), 0.01);
    }

    @Test
    public void testDespesasAdicionaisAcimaLimite() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new FuncionarioTerceirizado("Lucas", 30, 70.00, 1500.00);
        });
        assertEquals("Despesas adicionais não podem ultrapassar R$1000.00.", exception.getMessage());
    }
}
