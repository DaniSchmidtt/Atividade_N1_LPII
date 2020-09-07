package DB;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.google.gson.reflect.TypeToken;

import Models.ItemEstoque;

public class ConexaoDB {

    public void insertjson(ItemEstoque item) {

        List<ItemEstoque> itemestoque = this.selectjson();
        Gson gson = new Gson(); // conversor
        String json = gson.toJson(itemestoque);
        try {
            FileWriter fileWriter = new FileWriter("saida.LPII", false);
            fileWriter.write(json + "\n");
            fileWriter.close();
            System.out.println("Sucesso ao salvar!");
            System.out.println(json);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        // exportar
    }

    public List<ItemEstoque> selectjson() {

        try {

            BufferedReader br = new BufferedReader(new FileReader("saida.LPII"));
            List<ItemEstoque> itens = new ArrayList<ItemEstoque>();
            Gson gson = new Gson();
            itens = gson.fromJson(br, new TypeToken<List<ItemEstoque>>() {}.getType());
            System.out.println("Sucesso");

            int index = 0;

            for (ItemEstoque itemEstoque : itens) {
                System.out.println(itens.get(index).toString());
                index++;
            }
            return itens;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
            // TODO: handle exception
        }

        // Importar dados do Json

    }

    public void updatejson(int ID) {
        Gson gson = new Gson(); // conversor
        try {
            BufferedReader br = new BufferedReader(new FileReader("saida.LPII"));
            ItemEstoque item = gson.fromJson(br, ItemEstoque.class);
            System.out.println("Sucesso ao salvar!");
            System.out.println(item.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void deletejson(int ID) {
        Gson gson = new Gson(); // conversor

    }
}