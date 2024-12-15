package common;

public enum InfoMessage {
    GREETING("Welcome!👏 This is a bike sharing service."),
    ADD_BICYCLE("[Add a bicycle]"),
    ADD_BICYCLE_INFO("Enter Bicycle model, price, and condition (e.g., Electric, 40, good): "),
    ADD_MY_LOCATION_INFO("Enter your current location (e.g., 48.8191, 2.3627): "),
    STOP_ADDING("Enter 'exit' at any time to stop adding bicycles."),
    SHOW_BICYCLE("[View bicycles]"),

    // Sorting bicycles by price
    SORTING_PRICE("[Sort by price]"),
    JAVA_SORT("[Sort by price - Java built-in Sort]"),
    INSERTION_SORT("[Sort by price - Insertion Sort]"),
    Merge_SORT("[Sort by price - Merge Sort]"),
    TIM_SORT("[Sort by price - Tim Sort]"),

    // Sorting bicycles by distance
    SORTING_DISTANCE("[Sort by distance]")
    ;

    InfoMessage(String message) {
        this.message = message;
    }

    private String message;

    public String getMessage() {
        return message;
    }
}
