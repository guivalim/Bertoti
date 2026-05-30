import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Teste {

    @Test
    void test() {
        Mercado mercadinho = new Mercado();
        mercadinho.addClientes(new Cliente("Maria", "12345678910", true));

        assertEquals(1, mercadinho.getClientes().size());
        List<Cliente> clientesComCartao = mercadinho.verificarCartao(true);
        
        System.out.println("Clientes com cartão: " + clientesComCartao.size());

        List<Cliente> busca = mercadinho.buscarClienteNome("Maria");
        assertEquals("12345678910", busca.get(0).getCpf());

    }

}
