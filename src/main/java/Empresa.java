import java.util.*;

public class Empresa {
    private Map<String, Pessoa> funcionarios;
    private Set<Produto> produtos;
    private List<Time> times;
    private Pessoa po;

    public Empresa() {
        this.funcionarios = new HashMap<>();
        this.produtos = new HashSet<>();
        this.times = new ArrayList<>();
    }

    public void cadastrarFuncionario(String nome, String cpf) {
        Pessoa func = new Pessoa(nome, cpf, "desenvolvedor");
        this.funcionarios.put(cpf, func);
    }

    public void removerFuncionario(String cpf) {
        this.funcionarios.remove(cpf);
    }

    public String[] listarFuncionarios() {
        String[] out = new String[this.funcionarios.size()];

        int i = 0;
        for (Pessoa func : this.funcionarios.values())
            out[i++] = func.toString();

        return out;
    }

    public void cadastrarProduto(String nome, int id) {
        this.produtos.add(new Produto(nome, id));
    }

    public void removerProduto(int id) {
        for (Produto produto : produtos)
            if (produto.getId() == id)
                this.produtos.remove(produto);
    }

    public String[] listarProdutos() {
        String[] out = new String[this.produtos.size()];

        int i = 0;
        for (Produto produto : this.produtos)
            out[i++] = produto.toString();

        return out;
    }

    public Produto getProduto(String nomeProduto) {
        for (Produto produto : this.produtos)
            if (produto.getNome().equals(nomeProduto))
                return produto;
        throw new RuntimeException();
    }

    public void cadastrarTime(String nome, String nomeProduto, int id, String cpfGerente) {
        Pessoa gerente = this.funcionarios.get(cpfGerente);
        Produto produto = getProduto(nomeProduto);
        this.times.add(new Time(nome, produto, id, gerente));
    }

    public void removerTime(int id) {
        this.times.remove(id);
    }

    public String[] listarTimes() {
        String[] out = new String[this.times.size()];

        int i = 0;
        for (Time time : this.times)
            out[i++] = time.toString();

        return out;
    }

    public void adicionarMembroTime(String cpf, int id) {
        this.times.get(id).adicionarMembro(this.funcionarios.get(cpf));
    }

    public void removerMembroTime(String cpf, int id) {
        this.times.get(id).removerMembro(cpf);
    }

    public String[] listarMembrosTime(int id) {
        return this.times.get(id).listarMembros();
    }

    public void adicionarSprintTime(int idTime, int idSprint, String dataIni) {
        getTime(idTime).cadastrarSprint(idSprint, dataIni);
    }

    public void removerSprintTime(int idTime, int idSprint) {
        getTime(idTime).removerSprint(idSprint);
    }

    public String[] listarSprintsTime(int idTime) {
        return getTime(idTime).listarSprints();
    }

    public void promoverGerenteTime(String cpf, int id) {
        Time time = this.times.get(id);
        time.promoverMembro(cpf);
    }

    public void definirGerenteTime(String cpf, int id) {
        Time time = this.times.get(id);
        time.definirGerente(this.funcionarios.get(cpf));
    }

    public void promoverProductOwner(String cpf) {
        Pessoa funcionario = getFuncionario(cpf);

        this.po.alterarCargo("gerente");

        for (Time time : this.times) {
            if (time.getGerente().getCpf().equals(cpf)) {
                time.definirGerente(po);
                time.removerMembro(cpf);
            }
        }

        funcionario.alterarCargo("po");
    }

    public Pessoa getProductOwner() {
        return this.po;
    }

    private Time getTime(int id) {
        return this.times.get(id);
    }

    private Pessoa getFuncionario(String cpf) {
        return this.funcionarios.get(cpf);
    }
}