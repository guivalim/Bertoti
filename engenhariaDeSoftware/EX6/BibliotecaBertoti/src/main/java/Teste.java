import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class Teste {
    @Test
    void testAdicionarFuncionario(){
        Empresa empresa = new Empresa();
        empresa.adicionarFuncionario(new Funcionario("Guilherme", "Gerente"));
        assertEquals(1, empresa.getFuncionarios().size());
    }

    @Test
    void testBuscarFuncionarioNome(){
        Empresa empresa = new Empresa();
        Funcionario funcionario = new Funcionario("Tiago", "Operador");
        empresa.adicionarFuncionario(funcionario);

        List<Funcionario> achado = empresa.buscarFuncionarioNome("Tiago");
        assertNotNull(achado);
        assertEquals(funcionario.getNome(), achado.get(0).getNome());

    }


}
