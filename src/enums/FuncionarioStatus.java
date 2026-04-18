package enums;

public enum FuncionarioStatus {
    ATIVO {
        @Override
        public boolean podeReceberSalario() {
            return true;
        }
    },
    FERIAS {
        @Override
        public boolean podeReceberSalario() {
            return false;
        }
    },
    INATIVO {
        @Override
        public boolean podeReceberSalario() {
            return false;
        }
    };

    public abstract boolean podeReceberSalario();
}