package database;

import java.util.HashMap;

//public class ApartmentDatabaseSwitcher {


    private static HashMap<String, ApartmentDatabase> databaseNameMap = new HashMap<String, ApartmentDatabase>();
    public static ApartmentDatabase getDatabase(String databaseType) throws ClassNotFoundException{

        databaseNameMap.put("json", new JsonApartmentDatabase());

        ApartmentDatabase db;
        for ( String key : databaseNameMap.keySet() ) {
            if(key.equals(databaseType)){
                db = databaseNameMap.get(key);
                return db;
            }
        }
        throw new ClassNotFoundException("Database "+databaseType+" not found");
    }
}
