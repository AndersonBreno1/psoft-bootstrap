public class Economica implements ModalidadeEntrega {
    private double tarifaFixa;
    private double valorPorKm;
    private double desconto;
    private int prazo;

    public Economica(double tarifaFixa, double valorPorKm, double desconto, int prazo) {
        if (tarifaFixa < 0)
            throw new IllegalArgumentException("Tarifa fixa deve ser positiva");
        if (valorPorKm < 0)
            throw new IllegalArgumentException("Valor por km deve ser positivo");
        if (desconto < 0 || desconto > 1)
            throw new IllegalArgumentException("Desconto deve ser uma taxa entre 0 e 1");
        if (prazo <= 0)
            throw new IllegalArgumentException("Prazo deve ser positivo");

        this.tarifaFixa = tarifaFixa;
        this.valorPorKm = valorPorKm;
        this.desconto = desconto;
        this.prazo = prazo;
    }

    @Override
    public double calcularCusto(Pedido pedido) {
        double custoBase = tarifaFixa + valorPorKm * pedido.getDistancia();
        return custoBase * (1 - desconto);
    }

    @Override
    public int calcularPrazo(Pedido pedido) {
        return prazo;
    }

    @Override
    public String toString() {
        return "Economica";
    }
}