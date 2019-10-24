package model.exception;

public class NotEnoughFreeSockets extends Exception {
    public NotEnoughFreeSockets(String message){
        super(message);
    }
}
