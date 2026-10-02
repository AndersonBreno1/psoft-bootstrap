public class Sprint {
    private Pessoa lider;
    private String dataIni;
    private String dataFim;
    private int id;

    public Sprint(Pessoa lider, int id, String dataIni) {
        this.lider = lider;
        this.id = id;
    }

    public Pessoa getLider() {
        return lider;
    }

    public void setLider(Pessoa lider) {
        this.lider = lider;
    }

    public int getId() {
        return id;
    }

    public String getDataIni() {
        return dataIni;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void finalizarSprint(String dataFim) {
        this.dataFim = dataFim;
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
        Sprint other = (Sprint) obj;
        if (id != other.id)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Sprint [lider=" + lider + ", dataIni=" + dataIni + ", dataFim=" + dataFim + ", id=" + id + "]";
    }
}
