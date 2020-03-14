public class CustomException extends RuntimeException {
    String message;
    CustomException (String message)
    {
        super(message);
        this.message = message;
        System.out.println(message);
    }

}
