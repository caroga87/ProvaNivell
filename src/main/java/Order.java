import java.util.Map;

public class Order {
    private int id;
    private static int nextId=1;
    private Client client;
    private Map<Product, Integer> productsList;
    private DeliveryPerson deliveryPerson;

    public Order(Client client, Map<Product, Integer> productsList, DeliveryPerson deliveryPerson) {
        id=nextId++;
        this.client = client;
        this.productsList = productsList;
        this.deliveryPerson = deliveryPerson;
    }

    public int getId() {
        return id;
    }

    public Client getClient() {
        return client;
    }

    public Map<Product, Integer> getProductsList() {
        return productsList;
    }

    public DeliveryPerson getDeliveryPerson() {
        return deliveryPerson;
    }

    private String getTotalPrice() {
        return this.productsList.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().getPrice() * entry.getValue() * this.deliveryPerson.getPriceMultiplier())
                .sum() + "€.";
    }

    @Override
    public String toString() {
        return "Orders{\n" +
                "Order's id: " + id + "\n" +
                "Client: " + client + "\n" +
                "Order's product: " + productsList + "\n" +
                "Delivery: " + deliveryPerson + "\n" +
                "}\n" +
                "The total price is " + getTotalPrice();
    }
}
