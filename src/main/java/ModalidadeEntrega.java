public interface ModalidadeEntrega {

    double calcularCusto(Pedido pedido);

    int calcularPrazo(Pedido pedido);
}