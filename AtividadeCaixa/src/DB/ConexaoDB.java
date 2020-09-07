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

    public void insertjson(ArrayList<ItemEstoque> item) {

        Gson gson = new Gson(); // conversor
        String json = gson.toJson(item);
        try {
            FileWriter fileWriter = new FileWriter("saida.LPII");
            fileWriter.write(json); 
            fileWriter.close();
            System.out.println("Sucesso ao salvar!");
            System.out.println(json);
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
            return new ArrayList<ItemEstoque>();
            // TODO: handle exception
        }

        // Importar dados do Json

    }

    public void updatejson(int ID, ArrayList<ItemEstoque> item) {


        
    }

    public void deletejson(int ID,ArrayList<ItemEstoque> item) {



    }
}