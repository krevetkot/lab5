package exceptions;

public class IllegalValueException extends Exception{
    private String value;
    public IllegalValueException(String message, String value) {
        super(message + "Введенное значение: " + value);
        this.value = value;
    }
}
