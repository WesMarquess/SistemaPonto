package model;

import enums.FuncionarioStatus;

public class FuncionarioCLT extends Funcionario {

    private Double bonificacao;

    public FuncionarioCLT(String nome, Integer horasTrabalhadas, Double salarioBase, FuncionarioStatus funcionarioStatus, Double bonificacao) {
        super(nome, horasTrabalhadas, salarioBase, funcionarioStatus);
        this.bonificacao = bonificacao;
    }

    public Double getBonificacao() {
        return bonificacao;
    }

    @Override
    public Double calcularSalario() {
        if (!funcionarioStatus.podeReceberSalario()) {
            throw new IllegalStateException("Funcionário não pode receber salário no status atual");
        }
        return (horasTrabalhadas * salarioBase) + bonificacao;
    }
}