package model;

import enums.FuncionarioStatus;

public class FuncionarioPJ extends Funcionario {

    public FuncionarioPJ(String nome, Double pisoSalarioal, String cargo, Empresa empresa, FuncionarioStatus funcionarioStatus) {
        super(nome, pisoSalarioal, cargo, empresa, funcionarioStatus);
    }

    @Override
    public String calcularHora() {
        return "0.0";
    }
}