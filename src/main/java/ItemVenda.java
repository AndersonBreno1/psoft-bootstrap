public class ItemVenda {
    private int id;
    private Produto produto;
    private int quantidade;

    private static final double FATOR_DESCONTO_VINTE_ITENS = 0.9;

    public ItemVenda(int id, Produto produto, int quantidade) {
        this.id = id;
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double calcularPreco() {
        double preco = this.produto.getPreco() * quantidade;
        if (quantidade >= 20)
            return preco * FATOR_DESCONTO_VINTE_ITENS;
        return preco;
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
        ItemVenda other = (ItemVenda) obj;
        if (id != other.id)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "ItemVenda [id=" + id + ", produto=" + produto + ", quantidade=" + quantidade + "]";
    }

    public int getId() {
        return id;
    }
}
