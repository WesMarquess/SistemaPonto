package model.funcionarios;

import enums.FuncionarioStatus;
import enums.TipoFuncionario;
import model.empresa.Empresa;

public class FuncionarioFreeLancer extends Funcionario {

    public FuncionarioFreeLancer(String nome, Double pisoSalarial, Integer horasMensais, String cargo, Empresa empresa, TipoFuncionario tipo, FuncionarioStatus funcionarioStatus) {
        super(nome, pisoSalarial, horasMensais, cargo, empresa, tipo, funcionarioStatus);
    }

    @Override
    public double calcularHora() {
       return 0.0;
    }
}