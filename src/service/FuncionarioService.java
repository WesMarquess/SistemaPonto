package service;

import enums.FuncionarioStatus;
import model.funcionarios.Funcionario;

import java.util.HashMap;
import java.util.Map;

public class FuncionarioService {

    FuncionarioStatus funcionarioStatus;
    private Map<Long, Funcionario> funcionarioMap = new HashMap<>();


    public void cadastrar(Funcionario funcionario) {
        funcionarioMap.put(funcionario.getId(), funcionario);
    }

    public void remover(Long id) {
        buscaPorId(id);
        funcionarioMap.remove(id);
    }

    public Funcionario buscaPorId(Long id) {
        Funcionario funcionario = funcionarioMap.get(id);

        if (funcionario == null) {
            throw new IllegalArgumentException("Funcionario não existe");
        }
        return funcionario;
    }

    public void listarTodos() {
        if (funcionarioMap.isEmpty()) {
            System.out.println("Nenhum funcionário cadastrado.");
            return;
        }

        for (Funcionario funcionario : funcionarioMap.values()) {
            System.out.println(funcionario);
        }
    }

    public void alterarStatus(Long id, FuncionarioStatus status) {
        Funcionario funcionario = buscaPorId(id);
        funcionario.setFuncionarioStatus(status);
    }
}














