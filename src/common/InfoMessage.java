package common;

public enum InfoMessage {
    GREETING("Welcome! This is a bike sharing service."),
    ADD_BICYCLE("[Add a bicycle]"),
    ADD_BICYCLE_INFO("Enter Bicycle model and price (e.g., Electric, 40): "),
    SHOW_BICYCLE("[View bike inventory]")
    ;

    InfoMessage(String message) {
        this.message = message;
    }

    private String message;

    public String getMessage() {
        return message;
    }
}