public class Pagamento {
    private double valorPago;
    private String forma;

    public Pagamento(double valorPago, String forma) {
        this.valorPago = valorPago;
        this.forma = forma;
    }

    public double getValorPago() {
        return valorPago;
    }

    public String getForma() {
        return forma;
    }
}
