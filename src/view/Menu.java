package view;

import enums.FuncionarioStatus;
import enums.TipoFuncionario;
import model.empresa.Empresa;
import model.funcionarios.Funcionario;
import model.funcionarios.FuncionarioCLT;
import service.EmpresaService;
import service.FuncionarioService;

import java.util.Scanner;

public class Menu {

    private Scanner scanner = new Scanner(System.in);
    private FuncionarioService funcionarioService = new FuncionarioService();
    private EmpresaService empresaService = new EmpresaService();

    public void menuPrincipal() {
        int opcao;

        do {
            System.out.println("1 - Menu Empresa");
            System.out.println("2 - Menu Funcionário");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    exibirEmpresa();
                    break;
                case 2:
                    exibirFuncionario();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);
    }

    public void exibirFuncionario() {
        int opcao;

        do {
            System.out.println("1 - Cadastrar funcionário");
            System.out.println("2 - Listar funcionários");
            System.out.println("3 - Alterar status");
            System.out.println("0 - Voltar");
            System.out.print("Escolha: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarFuncionario();
                    break;
                case 2:
                    funcionarioService.listarTodos();
                    break;
                case 3:
                    alterarStatusFuncionario();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);
    }

    public void exibirEmpresa() {
        int opcao;

        do {
            System.out.println("1 - Cadastrar empresa");
            System.out.println("2 - Listar empresas");
            System.out.println("0 - Voltar");
            System.out.print("Escolha: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarEmpresa();
                    break;
                case 2:
                    listarEmpresas();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);
    }

    //funcionario
    private void cadastrarFuncionario() {

        if (empresaVazia()) {
            System.out.println("Cadastre uma empresa antes!");
            return;
        }

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Piso salarial: ");
        Double piso = scanner.nextDouble();

        System.out.print("Horas mensais: ");
        Integer horas = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Cargo: ");
        String cargo = scanner.nextLine();

        Empresa empresa = escolherEmpresa();

        System.out.println("Tipo de funcionário:");
        System.out.println("1 - CLT");
        System.out.println("2 - PJ");
        System.out.println("3 - FREELANCER");

        int tipoOpcao = scanner.nextInt();
        scanner.nextLine();

        TipoFuncionario tipo;

        switch (tipoOpcao) {
            case 1:
                tipo = TipoFuncionario.CLT;
                break;
            case 2:
                tipo = TipoFuncionario.PJ;
                break;
            case 3:
                tipo = TipoFuncionario.FREELANCER;
                break;
            default:
                System.out.println("Tipo inválido!");
                return;
        }

        Funcionario funcionario = new FuncionarioCLT(
                nome,
                piso,
                horas,
                cargo,
                empresa,
                tipo,
                FuncionarioStatus.ATIVO
        );

        funcionarioService.cadastrar(funcionario);
        System.out.println("Funcionário cadastrado com sucesso!");
    }

    private void alterarStatusFuncionario() {
        System.out.print("Digite o ID: ");
        Long id = scanner.nextLong();
        scanner.nextLine();

        System.out.println("1 - ATIVO");
        System.out.println("2 - INATIVO");
        System.out.println("3 - FÉRIAS");

        int opcao = scanner.nextInt();

        try {
            switch (opcao) {
                case 1:
                    funcionarioService.alterarStatus(id, FuncionarioStatus.ATIVO);
                    break;
                case 2:
                    funcionarioService.alterarStatus(id, FuncionarioStatus.INATIVO);
                    break;
                case 3:
                    funcionarioService.alterarStatus(id, FuncionarioStatus.FERIAS);
                    break;
                default:
                    System.out.println("Opção inválida");
                    return;
            }

            System.out.println("Status atualizado!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //empresa
    private void cadastrarEmpresa() {

        System.out.print("Razão Social: ");
        String razao = scanner.nextLine();

        System.out.print("Nome Fantasia: ");
        String fantasia = scanner.nextLine();

        System.out.print("CNPJ: ");
        String cnpj = scanner.nextLine();

        Empresa empresa = new Empresa(razao, fantasia, cnpj);

        empresaService.cadastrar(empresa);

        System.out.println("Empresa cadastrada com sucesso!");
    }

    private void listarEmpresas() {
        empresaService.listarTodos();
    }

    private Empresa escolherEmpresa() {
        System.out.println("\nEmpresas disponíveis:");
        empresaService.listarTodos();

        System.out.print("Digite o ID da empresa: ");
        Long id = scanner.nextLong();
        scanner.nextLine();

        return empresaService.buscaPorId(id);
    }

    private boolean empresaVazia() {
        try {
            empresaService.listarTodos();
            return false;
        } catch (Exception e) {
            return true;
        }
    }
}