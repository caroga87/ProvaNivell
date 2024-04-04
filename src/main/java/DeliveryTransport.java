public enum DeliveryTransport {

   BICYCLE(1.01),
   MOTOCYCLE(1.02),
   WALKING(1);

   private final double incrementPrice;

    DeliveryTransport(double incrementPrice) {
        this.incrementPrice = incrementPrice;
    }

    public double getIncrementPrice() {
        return incrementPrice;
    }

    @Override
    public String toString() {
        return "DeliveryTransport{" +
                "incrementPrice=" + incrementPrice +
                '}';
    }
}
