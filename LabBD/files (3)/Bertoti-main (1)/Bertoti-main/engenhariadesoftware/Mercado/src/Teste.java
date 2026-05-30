import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
//Atividade 6
class Teste {

    // Método de teste que valida as funcionalidades principais do mercado

    @Test
    void test() {
        // 1. CRIAÇÃO: Instanciar o mercado
        Mercado mercadinho = new Mercado();

        // 2. INSERÇÃO: Adicionar um cliente
        // Cliente: Maria, CPF: 12345678910, Possui cartão: true
        mercadinho.addClientes(new Cliente("Maria", "12345678910", true));

        // 3. TESTE 1: Verificar se o cliente foi adicionado corretamente
        // Deve ter 1 cliente na lista
        assertEquals(1, mercadinho.getClientes().size());

        // 4. TESTE 2: Filtrar clientes que possuem cartão fidelidade
        List<Cliente> clientesComCartao = mercadinho.verificarCartao(true);

        // Exibe no console quantos clientes possuem cartão
        // Esperado: 1 cliente (a Maria)
        System.out.println("Clientes com cartão: " + clientesComCartao.size());

        // 5. TESTE 3: Buscar cliente por nome
        // Busca todos os clientes com nome "Maria"
        List<Cliente> busca = mercadinho.buscarClienteNome("Maria");

        // Verifica se o CPF do primeiro cliente encontrado é "12345678910"
        // assertEquals compara se os dois valores são iguais
        assertEquals("12345678910", busca.get(0).getCpf());

    }
}