import java.util.List;

public class Main {
    public static void main(String[] args) {
        Empresa empresa = new Empresa();

        //criando funcionarios

        Funcionario funcionario1 = new Funcionario("Guilherme","chefe");
        Funcionario funcionario2 = new Funcionario("Jonatan","empregado");
        Funcionario funcionario3 = new Funcionario("Caua","gerente");
        Funcionario funcionario4 = new Funcionario("Leticia","auxiliar");

        //adicionado funcionarios a empresa

        empresa.adicionarFuncionario(funcionario1);
        empresa.adicionarFuncionario(funcionario2);
        empresa.adicionarFuncionario(funcionario3);
        empresa.adicionarFuncionario(funcionario4);

        //listando todos funcinarios

        System.out.println("Todos funcionarios da empresa:");
        for (Funcionario funcionario : empresa.getFuncionarios()) {
            System.out.println(funcionario.getNome() + ", cuja função é: " + funcionario.getFuncao());
        }
        //buscando funcionario por nome

        System.out.println("\nFuncionarios da empresa com o nome Guilherme:");
        List<Funcionario> buscarNome = empresa.buscarFuncionarioNome("Guilherme");
        for (Funcionario funcionario : buscarNome) {
            System.out.println(funcionario.getNome() + ", cuja função é: " + funcionario.getFuncao());
        }
    }
}
