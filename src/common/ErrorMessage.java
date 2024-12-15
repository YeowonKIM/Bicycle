package common;

public enum ErrorMessage {
    INPUT_ERROR("[ERROR] Invalid input. Please try again."),
    ;

    ErrorMessage(String message) {
        this.message = message;
    }

    private String message;

    public String getMessage() {
        return message;
    }
}
