package model.empresa;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Empresa {

    private static final AtomicInteger contadorId = new AtomicInteger(1);

    private Long id;
    private String razaoSocial;
    private String nomeFantasia;
    private String cnpj;
    private Map<String, Double> pisosSalariais;

    public Empresa(String razaoSocial, String nomeFantasia, String cnpj) {
        this.id = (long) contadorId.getAndIncrement();
        this.razaoSocial = razaoSocial;
        this.nomeFantasia = nomeFantasia;
        this.cnpj = cnpj;
        this.pisosSalariais = new HashMap<>();
    }

    public Long getId() {
        return id;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Map<String, Double> getPisosSalariais() {
        return pisosSalariais;
    }

    public boolean salarioDentroDoPiso(String tipo, double salario) {
        Double piso = pisosSalariais.get(tipo);

        if (piso == null) {
            throw new IllegalArgumentException("Tipo não encontrado");
        }

        return salario >= piso;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("ID: ").append(id).append("\n");
        sb.append("Razão Social: ").append(razaoSocial).append("\n");
        sb.append("Nome Fantasia: ").append(nomeFantasia).append("\n");
        sb.append("CNPJ: ").append(cnpj).append("\n");

        if (pisosSalariais != null && !pisosSalariais.isEmpty()) {
            sb.append("Pisos Salariais:\n");
            for (Map.Entry<String, Double> entry : pisosSalariais.entrySet()) {
                sb.append(" - ")
                        .append(entry.getKey())
                        .append(": R$ ")
                        .append(entry.getValue())
                        .append("\n");
            }
        } else {
            sb.append("Pisos Salariais: Não cadastrados\n");
        }
        return sb.toString();
    }
}
