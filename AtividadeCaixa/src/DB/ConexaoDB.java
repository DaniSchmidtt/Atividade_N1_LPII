package DB;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import com.google.gson.Gson;

import Models.ItemEstoque;

public class ConexaoDB {

    public void insertjson(ItemEstoque item) {

        Gson gson = new Gson(); // conversor
        String json = gson.toJson( item );
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
        // Gson gson = new Gson(); // conversor
        // String json = gson.toJson( objCliente );

    }

    public void selectjson() {

        Gson gson = new Gson(); // conversor
        
        try {
            BufferedReader br = new BufferedReader(new FileReader("saida.LPII"));
            ItemEstoque item = gson.fromJson(br, ItemEstoque.class);
            br.close();
            System.out.println("Sucesso ao Selecionar!");            
            System.out.println(item.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        // Importar dados do Json
        // Gson gson = new Gson(); // conversor
        // ItemEstoque objCliente = gson.fromJson(json, ItemEstoque.class);

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