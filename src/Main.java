import enums.FuncionarioStatus;
import model.Funcionario;
import model.FuncionarioCLT;
import service.FuncionarioService;

public class Main {
    public static void main(String[] args) {
        FuncionarioService service = new FuncionarioService();

        Funcionario funcionario = new FuncionarioCLT(
                "João",
                144,
                20.0,
                FuncionarioStatus.ATIVO,
                500.0
        );

        System.out.println(funcionario.calcularSalario());
        service.cadastrar(funcionario);
        service.listarTodos();
    }
}