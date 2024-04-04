public class DeliveryPerson {

    private String name;
    private DeliveryTransport transport;


    public DeliveryPerson(String name, DeliveryTransport transport) {
        this.name = name;
        this.transport = transport;

    }

    public String getName() {
        return name;
    }

    public DeliveryTransport getTransport() {
        return transport;
    }

    public double getPriceMultiplier(){
        return this.transport.getIncrementPrice();
    }

    @Override
    public String toString() {
        return "DeliveryPerson{" +
                "name='" + name + '\'' +
                ", transport=" + transport +
                '}';
    }
}
