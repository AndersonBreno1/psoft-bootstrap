public enum Perfil {
    STANDARD(1),
    PREMIUM(0.95);

    private final double fatorDesconto;

    private Perfil(double fatorDesconto) {
        this.fatorDesconto = fatorDesconto;
    }

    public double getFatorDesconto() {
        return this.fatorDesconto;
    }
}
