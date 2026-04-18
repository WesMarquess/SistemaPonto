package service;

import model.Funcionario;

public class PagamentoService {

    public double calcularSalario(Funcionario funcionario) {
        return funcionario.calcularSalario();
    }
}
