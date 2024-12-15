package common;

public enum InfoMessage {
    GREETING("Welcome!👏 This is a bike sharing service."),
    ADD_BICYCLE("[Add a bicycle]"),
    ADD_BICYCLE_INFO("Enter Bicycle model, price, and condition (e.g., Electric, 40, good): "),
    STOP_ADDING("Enter 'exit' at any time to stop adding bicycles."),
    SHOW_BICYCLE("[View bicycles]"),
    SORTING("[Sort by price]"),
    JAVA_SORT("[Sort by price - Java built-in Sort]"),
    INSERTION_SORT("[Sort by price - Insertion Sort]"),
    Merge_SORT("[Sort by price - Merge Sort]"),
    TIM_SORT("[Sort by price - Tim Sort]")
    ;

    InfoMessage(String message) {
        this.message = message;
    }

    private String message;

    public String getMessage() {
        return message;
    }
}
