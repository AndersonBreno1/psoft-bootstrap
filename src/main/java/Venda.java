import java.util.ArrayList;
import java.util.List;

public class Venda {
    private int id;
    private Cliente cliente;
    private List<ItemVenda> itens;
    private Pagamento pagamento;

    public Venda(int id, Cliente cliente) {
        this.id = id;
        this.cliente = cliente;
        this.itens = new ArrayList<>();
    }

    public boolean cadastrarItemVenda(int id, Produto produto, int quantidade) {
        ItemVenda item = new ItemVenda(id, produto, quantidade);
        this.itens.add(item);
        return true;
    }

    public boolean removerItemVenda(int id) {
        for (ItemVenda item : itens) {
            if (item.getId() == id) {
                this.itens.remove(item);
                return true;
            }
        }
        return false;
    }

    public int getId() {
        return id;
    }

    public String[] listarItensVenda() {
        String[] out = new String[this.itens.size()];
        for (int i = 0; i < this.itens.size(); i++) {
            out[i] = this.itens.get(i).toString();
        }
        return out;
    }

    public double calcularValorTotal() {
        double valor = 0;
        for (ItemVenda item : this.itens) {
            valor += item.calcularPreco();
        }
        return valor * this.cliente.getFatorDesconto();
    }

    public double realizarPagamento(String forma) {
        double valor = calcularValorTotal();
        Pagamento pagamento = new Pagamento(valor, forma);
        this.pagamento = pagamento;
        return valor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Pagamento getPagamento() {
        return pagamento;
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
        Venda other = (Venda) obj;
        if (id != other.id)
            return false;
        return true;
    }
}