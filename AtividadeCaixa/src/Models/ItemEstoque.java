package Models;

import java.util.Date;

public class ItemEstoque {
    private int CodigoDoItem;
    private Date DataDeEntrada;
    private String LocalDaCompra;
    private String Tipo;
    private String Marca;
    private String Caracteristicas;
    private EnumTamanho Tamanho;
    private EnumCor Cor;
    private double ValorEtiquetaCompra;
    private double ValorPagoCompra;
    private double ValorMargem100;
    private double PrecoSugerido;

    /**
     * @return the CodigoDoItem
     */
    public int getCodigoDoItem() {
        return CodigoDoItem;
    }

    /**
     * @param CodigoDoItem the CodigoDoItem to set
     */
    public void setCodigoDoItem( int CodigoDoItem) {
        this.CodigoDoItem = CodigoDoItem;
    }

    /**
     * @return the DataDeEntrada
     */
    public Date getDataDeEntrada() {
        return DataDeEntrada;
    }

    /**
     * @param DataDeEntrada the DataDeEntrada to set
     */
    public void setDataDeEntrada( Date DataDeEntrada) {
        this.DataDeEntrada = DataDeEntrada;
    }

    /**
     * @return the LocalDaCompra
     */
    public String getLocalDaCompra() {
        return LocalDaCompra;
    }

    /**
     * @param LocalDaCompra the LocalDaCompra to set
     */
    public void setLocalDaCompra( String LocalDaCompra) {
        this.LocalDaCompra = LocalDaCompra;
    }

    /**
     * @return the Tipo
     */
    public String getTipo() {
        return Tipo;
    }

    /**
     * @param Tipo the Tipo to set
     */
    public void setTipo( String Tipo) {
        this.Tipo = Tipo;
    }

    /**
     * @return the Marca
     */
    public String getMarca() {
        return Marca;
    }

    /**
     * @param Marca the Marca to set
     */
    public void setMarca( String Marca) {
        this.Marca = Marca;
    }

    /**
     * @return the Caracteristicas
     */
    public String getCaracteristicas() {
        return Caracteristicas;
    }

    /**
     * @param Caracteristicas the Caracteristicas to set
     */
    public void setCaracteristicas( String Caracteristicas) {
        this.Caracteristicas = Caracteristicas;
    }

    /**
     * @return the Tamanho
     */
    public EnumTamanho getTamanho() {
        return Tamanho;
    }

    /**
     * @param Tamanho the Tamanho to set
     */
    public void setTamanho( EnumTamanho Tamanho) {
        this.Tamanho = Tamanho;
    }

    /**
     * @return the Cor
     */
    public EnumCor getCor() {
        return Cor;
    }

    /**
     * @param Cor the Cor to set
     */
    public void setCor( EnumCor Cor) {
        this.Cor = Cor;
    }

    /**
     * @return the ValorEtiquetaCompra
     */
    public double getValorEtiquetaCompra() {
        return ValorEtiquetaCompra;
    }

    /**
     * @param ValorEtiquetaCompra the ValorEtiquetaCompra to set
     */
    public void setValorEtiquetaCompra( double ValorEtiquetaCompra) {
        this.ValorEtiquetaCompra = ValorEtiquetaCompra;
    }

    /**
     * @return the ValorPagoCompra
     */
    public double getValorPagoCompra() {
        return ValorPagoCompra;
    }

    /**
     * @param ValorPagoCompra the ValorPagoCompra to set
     */
    public void setValorPagoCompra( double ValorPagoCompraSET) {
        this.ValorPagoCompra = ValorPagoCompraSET;
        setValorMargem100(ValorPagoCompraSET);
    }

    /**
     * @return the ValorMargem100
     */
    public double getValorMargem100() {
        return ValorMargem100;
    }

    /**
     * @param ValorMargem100 the ValorMargem100 to set Valor da margem é calculado
     *                       automaticamente valorpago*2
     */
    private void setValorMargem100( double ValorPagoCompraSET) {

        this.ValorMargem100 = ValorPagoCompraSET * 2;
    }

    /**
     * @return the PrecoSugerido
     */
    public double getPrecoSugerido() {
        return PrecoSugerido;
    }

    /**
     * @param PrecoSugerido the PrecoSugerido to set
     */
    public void setPrecoSugerido( double PrecoSugerido) {
        this.PrecoSugerido = PrecoSugerido;
    }

    @Override public String toString(){
         String retorno = "";
        return retorno.concat( String.valueOf(CodigoDoItem).concat(Tipo));

    }
}