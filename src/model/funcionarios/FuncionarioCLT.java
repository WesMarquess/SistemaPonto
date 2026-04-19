package model;

import enums.FuncionarioStatus;

public class FuncionarioCLT extends Funcionario {

    public FuncionarioCLT(String nome, Double pisoSalarioal, String cargo, Empresa empresa, FuncionarioStatus funcionarioStatus) {
        super(nome, pisoSalarioal, cargo, empresa, funcionarioStatus);
    }

    @Override
    public String calcularHora() {
        return String.format("%.2f", pisoSalarial / getHorasMensais());
    }
}