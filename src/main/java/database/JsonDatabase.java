package database;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JsonDatabase implements Database {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Object getObject(Object o) throws IOException {
        Object list;

        list = objectMapper
                .readValue(getTextFromFile(DatabaseFilePath.getFileUriForObject(o)), new TypeReference<Object>(){});

        return list;
    }

    @Override
    public void setObject(Object o) throws IOException {
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
