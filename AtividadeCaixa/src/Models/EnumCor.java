package Models;

public enum EnumCor {

    AZUL("azul"),
    AMARELO("amarelo"),
    VERMELHO("vermelho"),
    ROSA("rosa"),
    ROXO("roxo"),
    VERDE("verde");

    private String cor;

    EnumCor(String cor)
    {
        this.cor = cor;
    }

    public String getCor()
    {
        return cor;
    }
}
