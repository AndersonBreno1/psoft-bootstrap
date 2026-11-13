public class Cliente {
    private String nome;
    private String cpf;
    private String telefone;
    private String email;

    public Cliente(String nome, String cpf, String telefone, String email) {
        if (nome == null || nome.isBlank())
            throw new IllegalArgumentException("Nome não pode ser vazio");
        if (cpf == null || cpf.isBlank())
            throw new IllegalArgumentException("CPF não pode ser vazio");
        if (telefone == null || telefone.isBlank())
            throw new IllegalArgumentException("Telefone não pode ser vazio");
        if (email == null || email.isBlank())
            throw new IllegalArgumentException("Email não pode ser vazio");

        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return getNome();
    }
}
