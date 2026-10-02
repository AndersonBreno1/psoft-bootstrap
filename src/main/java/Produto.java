public class Produto {
    private String nome;
    private int id;

    public Produto(String nome, int id) {
        this.nome = nome;
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return this.nome + ", id: " + id;
    }

}
