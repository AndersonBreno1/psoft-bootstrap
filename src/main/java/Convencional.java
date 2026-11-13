public class Convencional implements ModalidadeEntrega {
    private double tarifaFixa;
    private double precoPorKm;
    private int prazo;

    public Convencional(double tarifaFixa, double precoPorKm, int prazo) {
        if (tarifaFixa < 0)
            throw new IllegalArgumentException("Tarifa fixa deve ser positiva");
        if (precoPorKm < 0)
            throw new IllegalArgumentException("Valor por km deve ser positivo");
        if (prazo <= 0)
            throw new IllegalArgumentException("Prazo deve ser positivo");

        this.tarifaFixa = tarifaFixa;
        this.precoPorKm = precoPorKm;
        this.prazo = prazo;
    }

    @Override
    public double calcularCusto(Pedido pedido) {
        return tarifaFixa + precoPorKm * pedido.getDistancia();
    }

    @Override
    public int calcularPrazo(Pedido pedido) {
        return prazo;
    }

    @Override
    public String toString() {
        return "Convencional";
    }
}