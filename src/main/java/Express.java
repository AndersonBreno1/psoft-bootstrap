public class Express implements ModalidadeEntrega {
    private double tarifaFixa;
    private double valorPorKm;
    private double taxaPrioridade;
    private int prazo;

    public Express(double tarifaFixa, double valorPorKm, double taxaPrioridade, int prazo) {
        if (tarifaFixa < 0)
            throw new IllegalArgumentException("Tarifa fixa deve ser positiva");
        if (valorPorKm < 0)
            throw new IllegalArgumentException("Valor por km deve ser positivo");
        if (taxaPrioridade < 0)
            throw new IllegalArgumentException("Taxa de prioridade deve ser positiva");
        if (prazo <= 0)
            throw new IllegalArgumentException("Prazo deve ser positivo");

        this.tarifaFixa = tarifaFixa;
        this.valorPorKm = valorPorKm;
        this.taxaPrioridade = taxaPrioridade;
        this.prazo = prazo;
    }

    @Override
    public double calcularCusto(Pedido pedido) {
        return tarifaFixa + valorPorKm * pedido.getDistancia() + taxaPrioridade;
    }

    @Override
    public int calcularPrazo(Pedido pedido) {
        return prazo;
    }

    @Override
    public String toString() {
        return "Express";
    }
}