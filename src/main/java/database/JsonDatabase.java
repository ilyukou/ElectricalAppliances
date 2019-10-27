package database;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import jdk.nashorn.internal.parser.JSONParser;
import model.apartment.Apartment;
import model.apartment.Room;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.json.JSONObject;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JsonDatabase implements Database {

    private ObjectMapper objectMapper = new ObjectMapper();
    private Gson gson = new Gson();

    /*
    Exception in thread "main" java.lang.RuntimeException:
    Unable to invoke no-args constructor for class model.ElectricAppliance.
    Registering an InstanceCreator with Gson for this type may fix this problem.
     */
    @Override
    public Apartment getApartment() throws IOException {

        Reader reader = new FileReader(DatabaseFilePath.getApartmentFileUri());

        return gson.fromJson(reader, new TypeToken<Apartment>() {}.getType());
    }


    @Override
    public void setObject(Object o) throws IOException {
        System.out.println();
        FileWriter fileWriter = new FileWriter(DatabaseFilePath.getFileUriForObject(o));

        fileWriter.write(objectMapper.writeValueAsString(o));

        fileWriter.close();
    }

    private String getTextFromFile(final String filePath){
        String content = "";
        try{
            BufferedReader br = new BufferedReader(new FileReader(filePath));

            String text;

            while ((text = br.readLine()) != null) {
                content += text;
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return content;
    }

}
