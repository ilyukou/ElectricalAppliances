package database;

import model.apartment.Apartment;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

//public class JsonApartmentDatabase implements ApartmentDatabase {

    private static String fileUri = "src/main/resources/database/apartments.json";
    private ObjectMapper objectMapper = new ObjectMapper();


    @Override
    public Apartment getApartments() throws IOException {
        List<Apartment> list;

            list = objectMapper
                    .readValue(getTextFromFile(fileUri), new TypeReference<List<Apartment>>(){});

            return list.get(0);

}

    @Override
    public void setApartments(Apartment apartment) throws IOException {
        FileWriter fileWriter = new FileWriter(fileUri);

        fileWriter.write(objectMapper.writeValueAsString(apartment));

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
