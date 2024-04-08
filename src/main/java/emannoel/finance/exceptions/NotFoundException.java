package emannoel.finance.exceptions;

public class NotFoundException extends  Exception {

    public NotFoundException(String message){
        super("[NotFound] " + message);
    }
}
