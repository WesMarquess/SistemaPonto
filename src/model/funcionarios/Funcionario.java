package model.funcionarios;

import enums.FuncionarioStatus;
import enums.TipoFuncionario;
import model.empresa.Empresa;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class Funcionario {

    private static final AtomicInteger contadorId = new AtomicInteger(1);

    protected Long id;
    protected String nome;
    protected Double pisoSalarial;
    protected Integer HorasMensais;
    protected String cargo;
    protected Empresa empresa;
    protected TipoFuncionario tipo;
    protected FuncionarioStatus funcionarioStatus;

    public Funcionario(String nome, Double pisoSalarial, Integer horasMensais,
                       String cargo, Empresa empresa, TipoFuncionario tipo,
                       FuncionarioStatus funcionarioStatus) {
        this.id = (long) contadorId.getAndIncrement();
        this.nome = nome;
        this.pisoSalarial = pisoSalarial;
        HorasMensais = horasMensais;
        this.cargo = cargo;
        this.empresa = empresa;
        this.tipo = tipo;
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

    public abstract double calcularHora();

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