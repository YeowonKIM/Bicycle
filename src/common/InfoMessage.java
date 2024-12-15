package common;

public enum InfoMessage {
    GREETING("Welcome! This is a bike sharing service."),
    ;

    InfoMessage(String message) {
        this.message = message;
    }

    private String message;

    public String getMessage() {
        return message;
    }
}
