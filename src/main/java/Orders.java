import java.util.ArrayList;
import java.util.Map;

public class Orders {
    private int id;
    private static int nextId=1;
    private Client client;
    private Map<Products, Integer> productsList;
    private DeliveryPerson deliveryPerson;

    public Orders(Client client, Map<Products, Integer> productsList, DeliveryPerson deliveryPerson) {
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

    public Map<Products, Integer> getProductsList() {
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
        return "Orders{" +
                "id=" + id +
                ", client=" + client +
                ", productsList=" + productsList +
                ", deliveryPerson=" + deliveryPerson +
                '}' +"Total price" +getTotalPrice();
    }
}
