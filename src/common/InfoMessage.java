package common;

public enum InfoMessage {
    GREETING("Welcome!👏 This is a bike sharing service."),

    // CRUD
    ADD_BICYCLE("[Add a bicycle]"),
    ADD_BICYCLE_INFO("Enter Bicycle model, price, condition, and branch (e.g., electric, 40, good): "),
    ADD_MY_LOCATION_INFO("Enter your current location (e.g., 48.8191, 2.3627): "),
    ENTER_NUMBER("Enter the number of the bicycle for which you want to change information."),
    ENTER_BICYCLE_CHANGE("Enter the bicycle information you want to change in order."),
    ENTER_BICYCLE_DELETE("Enter the bicycle number you want to delete in order."),
    STOP_ADDING("Enter 'exit' at any time to stop adding bicycles."),
    SHOW_BICYCLE("[View bicycles]"),
    CHANGE_BICYCLE_INFO("[Change bicycle information]"),
    DELETE_A_BICYCYLE("[Delete bicycle]"),

    // Sorting bicycles by price
    SORTING_PRICE("[Sort by price]"),
    JAVA_SORT_PRICE("[Sort by price - Java built-in Sort]"),
    INSERTION_SORT_PRICE("[Sort by price - Insertion Sort]"),
    Merge_SORT_PRICE("[Sort by price - Merge Sort]"),
    TIM_SORT_PRICE("[Sort by price - Tim Sort]"),

    // Sorting bicycles by distance
    SORTING_DISTANCE("[Sort by distance]"),
    JAVA_SORT_DISTANCE("[Sort by distance - Java built-in Sort]"),
    INSERTION_SORT_DISTANCE("[Sort by distance - Insertion Sort]"),
    Merge_SORT_DISTANCE("[Sort by distance - Merge Sort]"),
    TIM_SORT_DISTANCE("[Sort by distance - Tim Sort]"),

    // Filtering
    FILTERING_PRICE("[Filter by price range]"),
    ENTER_PRICE_RANGE("Enter the minimum and maximum price range for the bike you want. (e.g. 20 - 50)")
    ;

    InfoMessage(String message) {
        this.message = message;
    }

    private String message;

    public String getMessage() {
        return message;
    }
}
