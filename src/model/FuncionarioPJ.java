package model;

import enums.FuncionarioStatus;

public abstract class FuncionarioPJ extends Funcionario {

    private String mei;

    public FuncionarioPJ(Long id, String nome, Integer horasTrabalhadas, Double salarioBase, FuncionarioStatus funcionarioStatus, String mei) {
        super(nome, horasTrabalhadas, salarioBase, funcionarioStatus);
        this.mei = mei;
    }

    @Override
    public Double calcularSalario() {
        if (!funcionarioStatus.podeReceberSalario()) {
            throw new IllegalStateException("Funcionário não pode receber salário no status atual");
        }
        return (horasTrabalhadas * salarioBase);
    }
}