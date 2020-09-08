package DB;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.google.gson.reflect.TypeToken;

import Models.EnumCor;
import Models.EnumTamanho;
import Models.ItemEstoque;

public class ConexaoDB {

    public void insertjson(ArrayList<ItemEstoque> item) {

        Gson gson = new Gson(); // conversor
        String json = gson.toJson(item);
        try {
            FileWriter fileWriter = new FileWriter("saida.LPII");
            fileWriter.write(json);
            fileWriter.close();
            System.out.println("Sucesso ao salvar!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        // exportar
    }

    public ArrayList<ItemEstoque> selectjson() {

        try {

            BufferedReader br = new BufferedReader(new FileReader("saida.LPII"));
            ArrayList<ItemEstoque> itens = new ArrayList<ItemEstoque>();
            Gson gson = new Gson();
            itens = gson.fromJson(br, new TypeToken<List<ItemEstoque>>() {
            }.getType());
            System.out.println("Sucesso");

            int index = 0;

            for (ItemEstoque itemEstoque : itens) {
                System.out.println(itens.get(index).toString());
                index++;
            }
            return itens;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ArrayList<ItemEstoque>();
            // TODO: handle exception
        }

        // Importar dados do Json

    }

    public void updatejson(int ID, ArrayList<ItemEstoque> Itens) {
        ItemEstoque aux = new ItemEstoque();
        ItemEstoque Item = new ItemEstoque();
        for (ItemEstoque itemEstoque : Itens) {
            if (itemEstoque.getCodigoDoItem() == ID) {
                int cache = 0;
                while (true) {
                    Scanner scan = new Scanner(System.in);
                    int scanerint;
                    double scanerdouble;
                    try {
                        if (cache == 0) {
                            Item.setCodigoDoItem(ID);
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
                            System.out.println("Selecione o valor da pago na compra:");
                            scanerdouble = Double.valueOf(scan.next());
                            Item.setValorPagoCompra(scanerdouble);
                            cache++;
                        }
                        if (cache == 10) {
                            Item.setDataDeEntrada(itemEstoque.getDataDeEntrada());
                            aux = itemEstoque;
                            break;
                        }

                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                }
            }
        }
        if (Item.getCodigoDoItem() != 0) {
            Itens.remove(aux);
            Itens.add(Item);
            insertjson(Itens);
        }
        else{
            System.out.println("Código de item invalido!");
        }
    }

    public void deletejson(int ID, ArrayList<ItemEstoque> Itens) {
        ItemEstoque aux = new ItemEstoque();
        int existe = 0;
        for (ItemEstoque itemEstoque : Itens) {
            if (itemEstoque.getCodigoDoItem() == ID) {
                aux = itemEstoque;
                existe = 1;
            }
        }
        if(existe == 1){
            Itens.remove(aux);
        }
        else{
            System.out.println("Código de item invalido!");
        }
    }
}