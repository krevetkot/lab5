package exceptions;

import objects.Dragon;

public class FailedBuildingException extends Exception{
    private Class<?> problemClass;
    public FailedBuildingException(String message, Class<?> problemClass) {
        super(message+problemClass);
    }

    //планируется использовать для ситуаций, когда сообщение = не все поля заполнены
}
