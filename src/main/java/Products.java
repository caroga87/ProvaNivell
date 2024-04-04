public enum Products {

    BURRITO (6.50, "pin"),
    BURGERS (8.90, "cap"),
    KEBAB (4.50),
    PIZZA (7.90);
    private double price;
    private String gift;

    Products(double price, String gift) {
        this.price = price;
        this.gift = gift;
    }

    Products (double price) {
        this.price=price;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Products{" +
                "price=" + price +
                ", gift='" + gift + '\'' +
                '}';
    }
}
