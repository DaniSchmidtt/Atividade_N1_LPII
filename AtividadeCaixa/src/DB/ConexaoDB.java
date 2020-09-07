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

import Models.ItemEstoque;

public class ConexaoDB {


    public void insertjson(ItemEstoque item) {   

        Gson gson = new Gson(); // conversor
        String json = gson.toJson( item );
        try 
        {
            FileWriter fileWriter = new FileWriter("saida.LPII",true);
            fileWriter.write(json + "\n");          
            fileWriter.close();
            System.out.println("Sucesso ao salvar!");            
            System.out.println(json);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
        // exportar
    }

    public void selectjson() {

        try {

        BufferedReader br = new BufferedReader(new FileReader("saida.LPII"));
        List<ItemEstoque> itens = new ArrayList<ItemEstoque>();
        Gson gson = new Gson();
        itens = gson.fromJson(br, new TypeToken<List<ItemEstoque>>() {}.getType());

        } catch (Exception e) {
            //TODO: handle exception
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
        }    }

    public void deletejson(int ID) {
        Gson gson = new Gson(); // conversor

    }
}