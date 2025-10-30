import java.util.LinkedList;
import java.util.List;

public class Empresa {
    private List<Funcionario> funcionarios = new LinkedList<>();
    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }
    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }
    public List<Funcionario> buscarFuncionarioNome(String nome) {
        List<Funcionario> encontrados = new LinkedList<>();
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getNome().equals(nome)) {
                encontrados.add(funcionario);
            }
        }
        return encontrados;
    }
}
