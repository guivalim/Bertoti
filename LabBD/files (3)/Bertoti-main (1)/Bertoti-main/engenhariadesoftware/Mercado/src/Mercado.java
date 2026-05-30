
import java.util.LinkedList;
import java.util.List;

public class Mercado {
   
    private List<Cliente> clientes = new LinkedList<>();
    
    public void addClientes(Cliente cliente) {
        clientes.add(cliente);
    }

    public List<Cliente> buscarClienteNome(String nome) {
       
        List<Cliente> encontrados = new LinkedList<Cliente>();

        for (Cliente cliente : clientes) {
            if (cliente.getNome().equals(nome))
                encontrados.add(cliente);  
        }

        return encontrados;
    }

    public Cliente buscarClienteCpf(String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;  
            }
        }
        return null;
    }

    public List<Cliente> verificarCartao(boolean possuiCartao) {

        List<Cliente> encontrados = new LinkedList<Cliente>();

        for (Cliente cliente : clientes) {
            if (cliente.isCartao() == possuiCartao) {
                encontrados.add(cliente);  
            }
        }
        return encontrados;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }
}

