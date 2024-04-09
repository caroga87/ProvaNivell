public enum Product {

    BURRITO ("Burrito", 6.50, "pin"),
    BURGERS ("Burger", 8.90, "cap"),
    KEBAB ("Kebab", 4.50),
    PIZZA ("Pizza",7.90);
    private String name;
    private double price;
    private String gift;

    Product(String name, double price, String gift) {
        this.name=name;
        this.price = price;
        this.gift = gift;
    }

    Product(String name, double price) {
        this.name=name;
        this.price=price;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", gift='" + gift + '\'' +
                '}';
    }
}
