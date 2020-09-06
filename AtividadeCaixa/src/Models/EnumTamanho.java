package Models;

public enum EnumTamanho {

    PP ("PP"),

    P("P"),

    M("M"),

    G("G"),

    GG("GG");

    private String tamanho;

    EnumTamanho(String tamanho)
    {
        this.tamanho = tamanho;
    }

    public String getTamanho()
    {
        return tamanho;
    }
}
