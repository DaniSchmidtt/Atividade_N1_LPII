import java.util.Date;

import DB.ConexaoDB;

import java.util.Calendar;
import Models.EnumCor;
import Models.EnumTamanho;
import Models.ItemEstoque;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        ItemEstoque teste = new ItemEstoque();
        teste.setCodigoDoItem(9);
        teste.setCaracteristicas("Caracter");
        teste.setCor(EnumCor.AZUL);
        Date date = new Date();
        teste.setDataDeEntrada(date);
        teste.setLocalDaCompra("Local");
        teste.setMarca("Marca");
        teste.setPrecoSugerido(25);
        teste.setTamanho(EnumTamanho.PP);
        teste.setTipo("Tipo");
        teste.setValorEtiquetaCompra(21);
        teste.setValorPagoCompra(475);

        ConexaoDB db = new ConexaoDB();
        db.insertjson(teste);
        db.selectjson();
    }
}
