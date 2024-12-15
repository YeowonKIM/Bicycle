package domain;

public class Bicycle {
    private int id;
    private String model;
    private double price;
    private String condition;

    public Bicycle(int id, String model, double price, String condition) {
        this.id = id;
        this.model = model;
        this.price = price;
        this.condition = condition;
    }

    public int getId() {
        return id;
    }

    public String getModel() {
        return model;
    }
    public String getCondition() {
        return condition;
    }

    public double getPrice() {
        return price;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Bike{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", price=" + price +
                '}';
    }
}
