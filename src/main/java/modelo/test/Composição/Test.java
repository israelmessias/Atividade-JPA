package modelo.test.Composição;
import modelo.Composição.Endereço;
import modelo.Composição.Fornecedor;
import modelo.Composição.Funcionario;
import modelo.Infra.DAO;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        DAO<Object> dao = new DAO<>();

        System.out.println("Digite o nome do Funcionario: ");
        String nomeFun = input.nextLine();
        System.out.println("Digite o longradouro: ");
        String longradouroFun = input.nextLine();
        System.out.println("Digite Complemento do endereço: ");
        String complementoFun = input.nextLine();

        System.out.println("Digite o nome do Fornecedores: ");
        String nomeFor = input.nextLine();
        System.out.println("Digite o longradouro: ");
        String longradouroFor = input.nextLine();
        System.out.println("Digite Complemento do endereço: ");
        String complementoFor = input.nextLine();

        Endereço endereçoFuncionarios = new Endereço(longradouroFun, complementoFun);
        Endereço endereçoFornecedores = new Endereço(longradouroFor, complementoFor);

        Funcionario funcionario = new Funcionario(nomeFun, endereçoFuncionarios);
        Fornecedor fornecedores = new Fornecedor(nomeFun, endereçoFuncionarios);

        dao.openTransi().input(funcionario);
        dao.input(fornecedores).closeTransi().close();
    }
}
