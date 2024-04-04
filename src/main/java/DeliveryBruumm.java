import java.util.*;

public class DeliveryBruumm {

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int optionSelected;
        ArrayList<Orders>ordersList = new ArrayList<>();
        ArrayList<Orders>deliveredList = new ArrayList<>();

        ArrayList<DeliveryPerson> availableDeliveryPerson = new ArrayList<>();
        availableDeliveryPerson.add(new DeliveryPerson("Juan", DeliveryTransport.MOTOCYCLE));
        availableDeliveryPerson.add(new DeliveryPerson("Maria", DeliveryTransport.BICYCLE));
        availableDeliveryPerson.add(new DeliveryPerson("Jose", DeliveryTransport.WALKING));

do {
        System.out.println("Please select the number of the desired option below");
        System.out.println("1.- Add new order");
        System.out.println("2.- Mark order as delivered");
        System.out.println("3.- Print pending orders");
        System.out.println("4.- Print delivered orders");
        System.out.println("5.- Exit");

        optionSelected = scanner.nextInt();

        switch (optionSelected){
            case 1:
                newOrder(ordersList, availableDeliveryPerson);
                break;
            case 2:
                markAsDelivered(ordersList,deliveredList );
                break;
            case 3:
                printPendingList(ordersList);
                break;
            case 4:
                printDeliveredList(deliveredList);
                break;
            case 5:
                System.out.println("The day has finished, hope you enjoyed the day!");
                break;
            default:
                System.out.println("Invalid option. Please, try again");
                break;
        }

    } while (optionSelected !=5);


}

    static void newOrder(ArrayList<Orders>ordersList, ArrayList<DeliveryPerson> availableDeliveryPerson) {

        if (availableDeliveryPerson.isEmpty()) {
            System.out.println("Hey! No deliveries available!");

        } else {

            Map<Products, Integer> productsOrder = new HashMap<>();
            String option = askString("What product do you want?");
            switch (option) {
                case "Burrito":
                    productsOrder.put(Products.BURRITO, askInt("How many?"));
                    break;
                case "Burger":
                    productsOrder.put(Products.BURGERS, askInt("How many?"));
                    break;
                case "Kebab":
                    productsOrder.put(Products.KEBAB, askInt("How many?"));
                    break;
                case "Pizza":
                    productsOrder.put(Products.PIZZA, askInt("How many?"));
                    break;
                default:
                    System.out.println("Choose an available product.");
                    return;
            }


            ordersList.add(new Orders(newClient(), productsOrder, selectDeliveryPerson(availableDeliveryPerson)));
            System.out.println("The order has created!");
        }
    }

    private static DeliveryPerson selectDeliveryPerson(ArrayList<DeliveryPerson> availableDeliveryPerson) {
        int index = new Random().nextInt(availableDeliveryPerson.size());
        DeliveryPerson deliveryPerson = availableDeliveryPerson.get(index);
        availableDeliveryPerson.remove(index);

        return deliveryPerson;
    }

    static void markAsDelivered (ArrayList<Orders>ordersList, ArrayList<Orders>deliveredList){
        int id= askInt("Id of delivered order:");
        int index;

        for (Orders pendingOrders : ordersList) {
            if (pendingOrders.getId()== id){
                index= ordersList.indexOf(pendingOrders);
                deliveredList.add(ordersList.get(index));
                ordersList.remove(index);
                System.out.println("The order is delivered!");
                return;
            }
        }

        System.out.println("Not order found");

    }

    static void printPendingList (ArrayList<Orders>ordersList) {
        if (ordersList.isEmpty()) {
            System.out.println("There's no pending orders!");
        } else {
            ordersList.forEach(System.out::println);
        }
    }

    static void printDeliveredList (ArrayList<Orders>deliveredList) {
        if (deliveredList.isEmpty()) {
            System.out.println("There's no pending orders!");
        } else {
            deliveredList.forEach(System.out::println);
        }
    }

    static Client newClient () {
        String name;
        String address;
        Client client = new Client(askString("Client name"), askString("Client address"));
        return client;
    }

    static String askString (String message){
        Scanner input = new Scanner(System.in);
        System.out.println(message);
        return input.nextLine();
    }
    static int askInt (String message){
        Scanner input = new Scanner(System.in);
        System.out.println(message);
        return input.nextInt();
    }
}
