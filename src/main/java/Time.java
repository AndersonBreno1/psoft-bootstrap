import java.util.*;

public class Time {
    private String nome;
    private Map<String, Pessoa> membros;
    private List<Sprint> sprints;
    private Produto produto;
    private int id;
    private Pessoa gerente;

    public Time(String nome, Produto produto, int id, Pessoa gerente) {
        this.nome = nome;
        this.produto = produto;
        this.id = id;
        this.gerente = gerente;
        this.membros = new HashMap<>();
        this.sprints = new ArrayList<>();
    }

    public void adicionarMembro(Pessoa pessoa) {
        this.membros.put(pessoa.getCpf(), pessoa);
    }

    public void removerMembro(String cpf) {
        this.membros.remove(cpf);
    }

    public void definirGerente(Pessoa pessoa) {
        adicionarMembro(pessoa);
        promoverMembro(pessoa.getCpf());
    }

    public String[] listarMembros() {
        String[] out = new String[this.membros.size()];

        int i = 0;
        for (Pessoa membro : this.membros.values())
            out[i++] = membro.toString();

        return out;
    }

    public boolean temMembro(String cpf) {
        return this.membros.get(cpf) != null;
    }

    public void cadastrarSprint(int id, String dataIni) {
        Sprint sprint = new Sprint(selecionarLider(), id, dataIni);
        this.sprints.add(sprint);
    }

    public void removerSprint(int id) {
        for (Sprint sprint : sprints)
            if (sprint.getId() == id)
                this.sprints.remove(sprint);
    }

    public String[] listarSprints() {
        String[] out = new String[this.membros.size()];

        int i = 0;
        for (Pessoa membro : this.membros.values())
            out[i++] = membro.toString();

        return out;
    }

    private Pessoa selecionarLider() {
        Random rand = new Random();
        String chave = this.membros.keySet().toArray(new String[0])[rand.nextInt(this.membros.size())];
        return this.membros.get(chave);
    }

    public void promoverMembro(String cpf) {
        Pessoa membro = this.membros.get(cpf);
        membro.alterarCargo("gerente");
        rebaixarGerente();
        this.gerente = membro;
    }

    public void rebaixarGerente() {
        this.gerente.alterarCargo("desenvolvedor");
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
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
        Time other = (Time) obj;
        if (id != other.id)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Time [nome=" + nome + ", membros=" + Arrays.toString(listarMembros()) + ", sprints="
                + Arrays.toString(listarSprints())
                + ", produto="
                + produto + ", id="
                + id + "]";
    }

    public String getNome() {
        return nome;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getId() {
        return id;
    }

    public Pessoa getGerente() {
        return gerente;
    }
}
