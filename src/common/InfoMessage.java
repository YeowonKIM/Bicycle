package common;

public enum InfoMessage {
    GREETING("Welcome! This is a bike sharing service."),
    ADD_BICYCLE("Enter Bicycle model and price (e.g., Electric, 40):")
    ;

    InfoMessage(String message) {
        this.message = message;
    }

    private String message;

    public String getMessage() {
        return message;
    }
}
