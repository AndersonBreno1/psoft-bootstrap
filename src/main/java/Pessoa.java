public class Pessoa {
    private String nome;
    private String cpf;
    private Papel cargo;

    public Pessoa(String nome, String cpf, String cargo) throws RuntimeException {
        this.nome = nome;
        this.cpf = cpf;
        this.cargo = criarCargo(cargo);
    }

    private Papel criarCargo(String cargo) throws RuntimeException {
        switch (cargo.toLowerCase()) {
            case "desenvolvedor":
                return new Desenvolvedor();
            case "gerente":
                return new Gerente();
            case "productowner":
                return new ProductOwner();
            case "po":
                return new ProductOwner();
            default:
                throw new RuntimeException("Cargo invalido");
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pessoa other = (Pessoa) obj;
        if (cpf == null) {
            if (other.cpf != null)
                return false;
        } else if (!cpf.equals(other.cpf))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Pessoa [nome=" + nome + ", cargo=" + cargo + "]";
    }

    public String getNome() {
        return nome;
    }

    public Papel getCargo() {
        return cargo;
    }

    public String getCpf() {
        return cpf;
    }

    public void alterarCargo(String cargo) {
        this.cargo = criarCargo(cargo);
    }
}
