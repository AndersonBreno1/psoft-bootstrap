public class Cliente {
    private String nome;
    private String cpf;
    private Perfil perfil;

    public Cliente(String nome, String cpf, String perfil) {
        this.nome = nome;
        this.cpf = cpf;
        this.perfil = Perfil.valueOf(perfil.toUpperCase());
    }

    public String getNome() {
        return nome;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = Perfil.valueOf(perfil.toUpperCase());
    }

    public double getFatorDesconto() {
        return this.perfil.getFatorDesconto();
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
        Cliente other = (Cliente) obj;
        if (cpf == null) {
            if (other.cpf != null)
                return false;
        } else if (!cpf.equals(other.cpf))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Cliente [nome=" + nome + ", cpf=" + cpf + ", perfil=" + perfil + "]";
    }
}
