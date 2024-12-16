package domain;

public class Bicycle {
    private int id;
    private String type;
    private double price;
    private String condition;
    private Branch branch;
    private double distance = 0;

    public Bicycle(int id, String type, double price, String condition, Branch branch, double distance) {
        this.id = id;
        this.type = type;
        this.price = price;
        this.condition = condition;
        this.branch = branch;
        this.distance = distance;
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

    public Branch getBranch() {
        return branch;
    }

    public double getDistance() {
        return distance;
    }

    public void setModel(String type) {
        this.type = type;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void update(String type, double price, String condition, Branch branch) {
        this.type = type;
        this.price = price;
        this.condition = condition;
        this.branch = branch;
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
