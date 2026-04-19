package model;

import enums.FuncionarioStatus;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class Funcionario {

    private static final AtomicInteger contadorId = new AtomicInteger(1);

    protected Long id;
    protected String nome;
    protected Double pisoSalarial;
    protected Integer HorasMensais;
    protected String cargo;
    protected Empresa empresa;
    protected FuncionarioStatus funcionarioStatus;

    public Funcionario(String nome, Double pisoSalarial, String cargo, Empresa empresa, FuncionarioStatus funcionarioStatus) {
        this.id = (long) contadorId.getAndIncrement();
        this.nome = nome;
        this.pisoSalarial = pisoSalarial;
        this.HorasMensais = 220;
        this.cargo = cargo;
        this.empresa = empresa;
        this.funcionarioStatus = funcionarioStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPisoSalarial() {
        return pisoSalarial;
    }

    public Integer getHorasMensais() {
        return HorasMensais;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public FuncionarioStatus getFuncionarioStatus() {
        return funcionarioStatus;
    }

    public void setFuncionarioStatus(FuncionarioStatus funcionarioStatus) {
        this.funcionarioStatus = funcionarioStatus;
    }

    public abstract String calcularHora();

    @Override
    public String toString() {
        return "ID: " + id +
                " | Nome: " + nome +
                " | Piso Salarial: " + pisoSalarial +
                " | Horas: " + HorasMensais +
                " | Empresa: " + empresa.getRazaoSocial() +
                " | Cargo: " + cargo +
                " | Status: " + funcionarioStatus;
    }
}