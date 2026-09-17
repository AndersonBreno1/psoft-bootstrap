import java.util.HashSet;
import java.util.Set;

public class Pessoa {
    private String nome;
    private int idade;
    private String cpf;
    private String telefone;
    private Set<String> enderecos;
    private String profissao;
    private Papel papel;

    public Pessoa(String nome, int idade, String cpf, String telefone, String endereco, String profissao,
            String papel) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.telefone = telefone;
        this.enderecos = new HashSet<>();
        this.enderecos.add(endereco);
        this.profissao = profissao;
        adicionaPapel(papel);
    }

    public void adicionaPapel(String papel) throws RuntimeException {
        if (papel == null)
            throw new RuntimeException("Papel invalido " + papel);

        switch (papel.toLowerCase()) {
            case "cliente":
                this.papel = Papel.CLIENTE;
                break;
            case "funcionario":
                this.papel = Papel.FUNCIONARIO;
                break;
            default:
                throw new RuntimeException("Papel invalido " + papel);
        }
    }

    public void cadastraEndereco(String endereco) {
        this.enderecos.add(endereco);
    }

    public void removeEndereco(String endereco) {
        this.enderecos.remove(endereco);
    }

    public String recuperarEndereco(String endereco) {
        for (String end : this.enderecos) {
            if (end.equals(endereco.toLowerCase())) {
                return end;
            }
        }
        return null;
    }

    public String[] listarEnderecos() {
        return this.enderecos.toArray(new String[this.enderecos.size()]);
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getProfissao() {
        return profissao;
    }

    public Papel getPapel() {
        return papel;
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
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Pessoa [nome=" + nome + ", idade=" + idade + ", cpf=" + cpf + ", telefone=" + telefone + ", enderecos="
                + enderecos + ", profissao=" + profissao + ", papel=" + papel + "]";
    }
}