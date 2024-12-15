package common;

public enum InfoMessage {
    GREETING("Welcome!👏 This is a bike sharing service."),
    ADD_BICYCLE("[Add a bicycle]"),
    ADD_BICYCLE_INFO("Enter Bicycle model, price, and condition (e.g., Electric, 40, good): "),
    STOP_ADDING("Enter 'exit' at any time to stop adding bicycles."),
    SHOW_BICYCLE("[View bicycles]"),
    SORTING("[Sort by price]")
    ;

    InfoMessage(String message) {
        this.message = message;
    }

    private String message;

    public String getMessage() {
        return message;
    }
}
