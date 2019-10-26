package database;

public final class DatabseSwitcher {

    private static final JsonDatabase jsonDatabase = new JsonDatabase();

    public static Database getDatabase(String databaseName) {
        if(databaseName.equals("json")){
            return jsonDatabase;
        }else { // default value
            return jsonDatabase;
        }
    }
}
