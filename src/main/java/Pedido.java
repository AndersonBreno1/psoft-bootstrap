public class Pedido {
    private int id;
    private Cliente cliente;
    private String enderecoOrigem;
    private String enderecoDestino;
    private double peso;
    private double distancia;
    private ModalidadeEntrega modalidadeEntrega;
    private boolean despachado;

    public Pedido(int id, Cliente cliente, String origem, String destino, double peso, double distancia,
            ModalidadeEntrega modalidadeEntrega) {
        if (id <= 0)
            throw new IllegalArgumentException("Id deve ser positivo");
        if (cliente == null)
            throw new IllegalArgumentException("Cliente nao pode ser vazio");
        if (origem == null || origem.isBlank())
            throw new IllegalArgumentException("Origem nao pode ser vazia");
        if (destino == null || destino.isBlank())
            throw new IllegalArgumentException("Destino nao pode ser vazio");
        if (peso <= 0)
            throw new IllegalArgumentException("Peso deve ser positivo");
        if (distancia < 0)
            throw new IllegalArgumentException("Distancia deve ser positiva");

        this.id = id;
        this.cliente = cliente;
        this.enderecoOrigem = origem;
        this.enderecoDestino = destino;
        this.peso = peso;
        this.distancia = distancia;
        this.modalidadeEntrega = modalidadeEntrega;
        this.despachado = false;
    }

    public double calcularCusto() {
        if (modalidadeEntrega == null)
            throw new IllegalStateException("Pedido sem modalidade de entrega");

        return modalidadeEntrega.calcularCusto(this);
    }

    public int calcularPrazo() {
        if (modalidadeEntrega == null)
            throw new IllegalStateException("Pedido sem modalidade de entrega");

        return modalidadeEntrega.calcularPrazo(this);
    }

    public void setModalidadeEntrega(ModalidadeEntrega modalidade) {
        if (modalidade == null)
            throw new IllegalArgumentException("Modalidade não pode ser nula");
        if (despachado)
            throw new IllegalStateException("Pedido ja despachado, não pode alterar a modalidade");

        this.modalidadeEntrega = modalidade;
    }

    public void despachar() {
        if (modalidadeEntrega == null)
            throw new IllegalStateException("Pedido sem modalidade de entrega");

        this.despachado = true;
    }

    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String getEnderecoOrigem() {
        return enderecoOrigem;
    }

    public String getEnderecoDestino() {
        return enderecoDestino;
    }

    public double getPeso() {
        return peso;
    }

    public double getDistancia() {
        return distancia;
    }

    public ModalidadeEntrega getModalidadeEntrega() {
        return modalidadeEntrega;
    }

    public boolean isDespachado() {
        return despachado;
    }

    @Override
    public String toString() {
        String modalidade = modalidadeEntrega == null ? "nenhuma" : modalidadeEntrega.toString();
        return "Pedido " + id + " - " + cliente + " (" + enderecoOrigem + " -> " + enderecoDestino + ")"
                + " | modalidade: " + modalidade
                + " | despachado: " + despachado;
    }
}