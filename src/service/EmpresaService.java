package service;

import model.empresa.Empresa;
import model.funcionarios.Funcionario;

import java.util.HashMap;
import java.util.Map;

public class EmpresaService {

    private Map<Long, Empresa> empresaMap = new HashMap<>();

    public void cadastrar(Empresa empresa) {
        empresaMap.put(empresa.getId(), empresa);
    }

    public void remover(Long id) {
        buscaPorId(id);
        empresaMap.remove(id);
    }

    public Empresa buscaPorId(Long id) {
        Empresa empresa = empresaMap.get(id);

        if (empresa == null) {
            throw new IllegalArgumentException("Funcionario não existe");
        }
        return empresa;
    }

    public void listarTodos() {
        if (empresaMap.isEmpty()) {
            System.out.println("Nenhum funcionário cadastrado.");
            return;
        }
        for (Empresa empresa : empresaMap.values()) {
            System.out.println(empresa);
        }
    }

    public void validarSalario(Empresa empresa, Funcionario funcionario) {

        boolean valido = empresa.salarioDentroDoPiso(
                funcionario.getClass().getSimpleName(),
                funcionario.calcularHora()
        );

        if (!valido) {
            throw new IllegalArgumentException("Salário abaixo do piso");
        }
    }
}