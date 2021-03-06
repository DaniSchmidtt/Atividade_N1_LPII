//package javaapplication5;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import DB.ConexaoDB;
import Models.EnumCor;
import Models.EnumTamanho;
import Models.ItemEstoque;
import TableWAGU.Board;
import TableWAGU.Table;

public class App {

    public static void novoitem(ConexaoDB db, ArrayList<ItemEstoque> itens, int auxcod) {
        ItemEstoque Item = new ItemEstoque();
        int cache = 0;
        while (true) {
            Scanner scan = new Scanner(System.in);
            int scanerint;
            double scanerdouble;
            try {
                if (cache == 0) {
                    Item.setCodigoDoItem(auxcod);
                    cache++;
                }
                if (cache == 1) {
                    System.out.println("Digite as caracteristicas");
                    Item.setCaracteristicas(scan.next());
                    cache++;
                }
                if (cache == 2) {

                    System.out.println("Selecione a Cor:");
                    System.out.println("1 - AZUL");
                    System.out.println("2 - AMARELO");
                    System.out.println("3 - ROSA");
                    System.out.println("4 - ROXO");
                    System.out.println("5 - VERDE");
                    scanerint = Integer.valueOf(scan.next());
                    switch (scanerint) {
                        case 1:
                            Item.setCor(EnumCor.AZUL);
                        case 2:
                            Item.setCor(EnumCor.AMARELO);
                        case 3:
                            Item.setCor(EnumCor.ROSA);
                        case 4:
                            Item.setCor(EnumCor.ROXO);
                        case 5:
                            Item.setCor(EnumCor.VERDE);
                    }
                    if (scanerint >= 1 && scanerint <= 5) {
                        cache++;
                    }
                }
                if (cache == 3) {
                    System.out.println("Digite o local da compra");
                    Item.setLocalDaCompra(scan.next());
                    cache++;
                }
                if (cache == 4) {
                    System.out.println("Digite a marca");
                    Item.setMarca(scan.next());
                    cache++;
                }
                if (cache == 5) {
                    System.out.println("Digite o preço sugerido");
                    scanerdouble = Double.valueOf(scan.next());
                    Item.setPrecoSugerido(scanerdouble);
                    cache++;
                }
                if (cache == 6) {
                    System.out.println("Selecione o tamanho:");
                    System.out.println("1 - PP");
                    System.out.println("2 - P");
                    System.out.println("3 - M");
                    System.out.println("4 - G");
                    System.out.println("5 - GG");
                    scanerint = Integer.valueOf(scan.next());
                    switch (scanerint) {
                        case 1:
                            Item.setTamanho(EnumTamanho.PP);
                        case 2:
                            Item.setTamanho(EnumTamanho.P);
                        case 3:
                            Item.setTamanho(EnumTamanho.M);
                        case 4:
                            Item.setTamanho(EnumTamanho.G);
                        case 5:
                            Item.setTamanho(EnumTamanho.GG);
                    }
                    if (scanerint >= 1 && scanerint <= 5) {
                        cache++;
                    }
                }
                if (cache == 7) {
                    System.out.println("Selecione o tipo:");
                    Item.setTipo(scan.next());
                    cache++;
                }
                if (cache == 8) {
                    System.out.println("Selecione o valor da etiqueta de compra:");
                    scanerdouble = Double.valueOf(scan.next());
                    Item.setValorEtiquetaCompra(scanerdouble);
                    cache++;
                }
                if (cache == 9) {
                    System.out.println("Selecione o valor pago na compra:");
                    scanerdouble = Double.valueOf(scan.next());
                    Item.setValorPagoCompra(scanerdouble);
                    cache++;
                }
                if (cache == 10) {
                    Date date = new Date();
                    Item.setDataDeEntrada(date);
                    break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        itens.add(Item);
        db.insertjson(itens);
    }

    public static void selectparametro(ConexaoDB db, ArrayList<ItemEstoque> itens) {
        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Passe um codigo de item valido");
            System.out.println("Ou digite 0 para Sair");
            int Codigo;
            try {
                Codigo = Integer.valueOf(scan.next());
                if (Codigo == 0) {
                    break;
                } else {
                    // db.selectjson(Codigo);
                    System.out.println("1 - Deseja alterar esse item?");
                    System.out.println("2- Deseja deletar esse item?");
                    System.out.println("para sair digite qualquer outro numero");
                    int scanerint = Integer.valueOf(scan.next());
                    if (scanerint == 1) {
                        db.updatejson(Codigo, itens);
                    } else if (scanerint == 2) {
                        db.deletejson(Codigo, itens);
                    } else {
                        break;
                    }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }
    public static void DesenhaTabela(ArrayList<ItemEstoque> items){
        try{
        DateFormat df = new SimpleDateFormat("dd-mm-yyyy");
        List<String> headersList = Arrays.asList("Código Do Item", "Data De Entrada", "Local Da Compra", "Tipo", "Marca", "Caracteristicas", "Tamanho", "Cor",
         "Valor Etiqueta", "Valor Pago", "ValorMargem 100", "Preco Sugerido");
         List<List<String>> rowsList = new ArrayList<List<String>>();
         for(int i = 0; i < items.size(); i++){
             var ListString = Arrays.asList(
                 Integer.toString(items.get(i).getCodigoDoItem()),
                  df.format(items.get(i).getDataDeEntrada()),
                  items.get(i).getLocalDaCompra(),
                  items.get(i).getTipo(),
                  items.get(i).getMarca(),
                  items.get(i).getCaracteristicas(),
                  items.get(i).getTamanho().toString(),
                  items.get(i).getCor().toString(),
                  Double.toString(items.get(i).getValorEtiquetaCompra()),
                  Double.toString(items.get(i).getValorPagoCompra()),
                  Double.toString(items.get(i).getValorMargem100()),
                  Double.toString(items.get(i).getPrecoSugerido())
                 );
            rowsList.add(ListString);
         }

        Board board = new Board(200);

        String tableString = board.setInitialBlock(new Table(board, 200, headersList, rowsList).tableToBlocks()).build().getPreview();

        System.out.println(tableString);
        return;
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
    }
    public static void main(String[] args) throws Exception {

        ArrayList<ItemEstoque> itens = new ArrayList<ItemEstoque>();
        ConexaoDB db = new ConexaoDB();
        itens = db.selectjson();
        Integer auxcod = 0;
        System.out.println("Bem vindo ao sistema.");
        System.out.println("---------------------");
        while (true) {
            for (ItemEstoque itemEstoque : itens) {
                if(itemEstoque.getCodigoDoItem() > auxcod){
                    auxcod = itemEstoque.getCodigoDoItem();
                }
            }
            auxcod = auxcod + 1;
            Scanner scan = new Scanner(System.in);
            System.out.println("Opções:");
            System.out.println("1 - Cadastrar novo Item no estoque");
            System.out.println("2 - Visualizar todos os itens do estoque");
            System.out.println("3 - Procurar item no estoque");
            System.out.println("4 - Sair");
            try {
                int scanerint = Integer.valueOf(scan.next());
                switch (scanerint) {
                    case 1:
                        novoitem(db, itens, auxcod);
                        continue;
             case 2:
             DesenhaTabela(itens);
             continue;
                    case 3:
                        selectparametro(db, itens);
                        continue;
                    case 4:
                        System.exit(0);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
