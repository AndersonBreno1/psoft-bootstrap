import java.util.*;

public class Central {
    private static Central instancia;
    private List<Pedido> pedidos;
    private Map<String, Cliente> clientes;

    private Central() {
        this.pedidos = new ArrayList<>();
    }

    public static Central getInstancia() {
        if (instancia == null)
            instancia = new Central();

        return instancia;
    }

    public boolean cadastrarCliente(String cpf, String nome, String telefone, String email) {
        if (clientes.containsKey(cpf))
            return false;

        clientes.put(cpf, new Cliente(cpf, nome, telefone, email));
        return true;
    }

    public Pedido registrarPedido(String cpfCliente, String origem, String destino, double peso, double distancia) {
        Cliente cliente = getCliente(cpfCliente);
        Pedido pedido = new Pedido(pedidos.size() + 1, cliente, origem, destino, peso, distancia);
        pedidos.add(pedido);
        return pedido;
    }

    public Pedido recuperarPedido(int id) {
        for (Pedido p : pedidos) {
            if (p.getId() == id)
                return p;
        }
        return null;
    }

    public boolean alterarModalidadeEntrega(int id, ModalidadeEntrega modalidade) {
        Pedido pedido = recuperarPedido(id);
        if (modalidade == null || pedido == null || pedido.isDespachado())
            return false;

        pedido.setModalidadeEntrega(modalidade);
        return true;
    }

    public String solicitarEntrega(int id) {
        Pedido pedido = recuperarPedido(id);
        if (pedido == null)
            return "Pedido não encontrado";
        if (pedido.getModalidadeEntrega() == null)
            return "Pedido " + id + " sem modalidade de entrega";

        return "Pedido " + id + " | " + pedido.getModalidadeEntrega().toString()
                + " | custo: R$ " + String.format("%.2f", pedido.calcularCusto())
                + " | prazo: " + pedido.calcularPrazo() + " dias";
    }

    public boolean despacharPedido(int id) {
        Pedido pedido = recuperarPedido(id);
        if (pedido == null || pedido.isDespachado() || pedido.getModalidadeEntrega() == null)
            return false;

        pedido.despachar();
        return true;
    }

    public List<Pedido> acompanharPedidos() {
        return List.copyOf(pedidos);
    }

    private Cliente getCliente(String cpf) {
        return clientes.get(cpf);
    }
}