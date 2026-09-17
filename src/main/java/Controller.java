import java.util.HashMap;
import java.util.Map;

public class Controller {
    private Map<String, Pessoa> pessoas;

    public Controller() {
        this.pessoas = new HashMap<>();
    }

    public boolean cadastraPessoa(String nome, int idade, String cpf, String telefone, String endereco,
            String profissao, String papel) throws RuntimeException {
        if (temPessoa(cpf))
            return false;

        Pessoa pessoa = new Pessoa(nome, idade, cpf, telefone, endereco, profissao, papel);
        this.pessoas.put(cpf, pessoa);
        return true;
    }

    public boolean cadastraEnderecoPessoa(String cpf, String endereco) {
        if (temPessoa(cpf)) {
            Pessoa pessoa = getPessoa(cpf);
            pessoa.cadastraEndereco(endereco);
            return true;
        }
        return false;
    }

    public boolean removeEnderecoPessoa(String cpf, String endereco) {
        if (temPessoa(cpf)) {
            Pessoa pessoa = getPessoa(cpf);
            pessoa.removeEndereco(endereco);
            return true;
        }
        return false;
    }

    public String[] listarEnderecosPessoa(String cpf, String endereco) {
        if (temPessoa(cpf)) {
            Pessoa pessoa = getPessoa(cpf);
            String[] enderecos = pessoa.listarEnderecos();
            return enderecos;
        }
        return null;
    }

    public String[] listarPessoas() {
        String[] out = new String[this.pessoas.size()];

        String[] chaves = this.pessoas.keySet().toArray(new String[this.pessoas.size()]);
        for (int i = 0; i < this.pessoas.size(); i++) {
            out[i] = this.pessoas.get(chaves[i]).toString();
        }

        return out;
    }

    public boolean removerPessoa(String cpf) {
        if (temPessoa(cpf)) {
            this.pessoas.remove(cpf);
            return true;
        }
        return false;
    }

    public String recuperarPessoa(String cpf) {
        if (temPessoa(cpf))
            return this.pessoas.get(cpf).toString();
        return null;
    }

    public Pessoa getPessoa(String cpf) {
        return this.pessoas.get(cpf);
    }

    public void atualizaIdadePessoa(int idade, String cpf) {
        if (temPessoa(cpf)) {
            Pessoa pessoa = getPessoa(cpf);
            pessoa.setIdade(idade);
        }
    }

    public void atualizaTelefonePessoa(String telefone, String cpf) {
        if (temPessoa(cpf)) {
            Pessoa pessoa = getPessoa(cpf);
            pessoa.setTelefone(telefone);
        }
    }

    public void atualizaProfissaoPessoa(String profissao, String cpf) {
        if (temPessoa(cpf)) {
            Pessoa pessoa = getPessoa(cpf);
            pessoa.setProfissao(profissao);
        }
    }

    public void atualizaPapelPessoa(String papel, String cpf) throws RuntimeException {
        if (temPessoa(cpf)) {
            Pessoa pessoa = getPessoa(cpf);
            pessoa.adicionaPapel(papel);
        }
    }

    public String recuperaNomePessoa(String cpf) {
        if (temPessoa(cpf)) {
            Pessoa pessoa = getPessoa(cpf);
            return pessoa.getNome();
        }
        return null;
    }

    public int recuperaIdadePessoa(String cpf) {
        if (temPessoa(cpf)) {
            Pessoa pessoa = getPessoa(cpf);
            return pessoa.getIdade();
        }
        return -1;
    }

    public String recuperaCpfPessoa(String cpf) {
        if (temPessoa(cpf)) {
            Pessoa pessoa = getPessoa(cpf);
            return pessoa.getCpf();
        }
        return null;
    }

    public String recuperaTelefonePessoa(String cpf) {
        if (temPessoa(cpf)) {
            Pessoa pessoa = getPessoa(cpf);
            return pessoa.getTelefone();
        }
        return null;
    }

    public String recuperaProfissaoPessoa(String cpf) {
        if (temPessoa(cpf)) {
            Pessoa pessoa = getPessoa(cpf);
            return pessoa.getProfissao();
        }
        return null;
    }

    public Papel recuperaPapelPessoa(String cpf) {
        if (temPessoa(cpf)) {
            Pessoa pessoa = getPessoa(cpf);
            return pessoa.getPapel();
        }
        return null;
    }

    private boolean temPessoa(String cpf) {
        return this.pessoas.get(cpf) != null;
    }
}
