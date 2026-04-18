package model;

import enums.FuncionarioStatus;

public class FuncionarioFreeLancer extends Funcionario {

    private Integer quantidadeDias;
    private Double valorDiaria;

    public FuncionarioFreeLancer(String nome, Integer horasTrabalhadas, Double salarioBase, FuncionarioStatus funcionarioStatus,
                                 Integer quantidadeDias, Double valorDiaria) {
        super(nome, horasTrabalhadas, salarioBase, funcionarioStatus);
        this.quantidadeDias = quantidadeDias;
        this.valorDiaria = valorDiaria;
    }

    private Double calcularDiaria() {
        return quantidadeDias * valorDiaria;
    }

    @Override
    public Double calcularSalario() {
        if (!funcionarioStatus.podeReceberSalario()) {
            throw new IllegalStateException("Funcionário não pode receber salário no status atual");
        }
        return calcularDiaria();
    }
}