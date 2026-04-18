package model;

import enums.FuncionarioStatus;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class Funcionario {

    private static final AtomicInteger contadorId = new AtomicInteger(1);

    protected Long id;
    protected String nome;
    protected Integer horasTrabalhadas;
    protected Double salarioBase;
    protected FuncionarioStatus funcionarioStatus;

    public Funcionario(String nome, Integer horasTrabalhadas, Double salarioBase,
                       FuncionarioStatus funcionarioStatus) {
        this.id = (long) contadorId.getAndIncrement();
        this.nome = nome;
        this.horasTrabalhadas = horasTrabalhadas;
        this.salarioBase = salarioBase;
        this.funcionarioStatus = funcionarioStatus;
    }

    public Long getId() {
        return id;
    }

    public boolean podeCalcularSalario() {
        return funcionarioStatus == FuncionarioStatus.ATIVO;
    }

    public abstract Double calcularSalario();

    @Override
    public String toString() {
        return "ID: " + id +
                " | Nome: " + nome +
                " | Horas: " + horasTrabalhadas +
                " | Status: " + funcionarioStatus;
    }
}