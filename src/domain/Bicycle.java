package domain;

public class Bicycle {
    private int id;
    private String type;
    private double price;
    private String condition;

    public Bicycle(int id, String type, double price, String condition) {
        this.id = id;
        this.type = type;
        this.price = price;
        this.condition = condition;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }
    public String getCondition() {
        return condition;
    }

    public double getPrice() {
        return price;
    }

    public void setModel(String type) {
        this.type = type;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Bike{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", price=" + price +
                '}';
    }
}
