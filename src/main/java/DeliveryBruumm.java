import java.util.*;

public class DeliveryBruumm {

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int optionSelected;
        ArrayList<Order> orderList = new ArrayList<>();
        ArrayList<Order>deliveredList = new ArrayList<>();

        ArrayList<DeliveryPerson> availableDeliveryPerson = new ArrayList<>();
        availableDeliveryPerson.add(new DeliveryPerson("Juan", DeliveryTransport.MOTOCYCLE));
        availableDeliveryPerson.add(new DeliveryPerson("Maria", DeliveryTransport.BICYCLE));
        availableDeliveryPerson.add(new DeliveryPerson("Jose", DeliveryTransport.WALKING));

    do {
        optionSelected = askInt("Please select the number of the desired option below\n" +
            "1.- Add new order\n" +
            "2.- Mark order as delivered\n" +
            "3.- Print pending orders\n" +
            "4.- Print delivered orders\n" +
            "5.- Exit");


        switch (optionSelected){
            case 1:
                newOrder(orderList, availableDeliveryPerson);
                break;
            case 2:
                markAsDelivered(orderList,deliveredList, availableDeliveryPerson );
                break;
            case 3:
                printPendingList(orderList);
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

    static void newOrder(ArrayList<Order> orderList, ArrayList<DeliveryPerson> availableDeliveryPerson) {

        if (availableDeliveryPerson.isEmpty()) {
            System.out.println("Hey! No deliveries available!");

        } else {

            Map<Product, Integer> productsOrder = new HashMap<>();
            String option;

            do {
                option = askString("What product do you want? Choose between burrito, burger, kebab or pizza");

                switch (option.toLowerCase()) {
                    case "burrito":
                        productsOrder.put(Product.BURRITO, askInt("How many?"));
                        System.out.println("You get a pin as a gift!");
                        break;
                    case "burger":
                        productsOrder.put(Product.BURGERS, askInt("How many?"));
                        System.out.println("You get a cap as a gift!");
                        break;
                    case "kebab":
                        productsOrder.put(Product.KEBAB, askInt("How many?"));
                        break;
                    case "pizza":
                        productsOrder.put(Product.PIZZA, askInt("How many?"));
                        break;
                    default:
                        System.out.println("Choose an available product.");
                        return;
                }
            } while (askString("Do you want another product? Yes/No").equalsIgnoreCase("yes"));


            orderList.add(new Order(newClient(), productsOrder, selectDeliveryPerson(availableDeliveryPerson)));
            System.out.println("The order has created!");
        }
    }

    private static DeliveryPerson selectDeliveryPerson(ArrayList<DeliveryPerson> availableDeliveryPerson) {
        int index = new Random().nextInt(availableDeliveryPerson.size());
        DeliveryPerson deliveryPerson = availableDeliveryPerson.get(index);
        availableDeliveryPerson.remove(index);

        return deliveryPerson;
    }

    static void markAsDelivered (ArrayList<Order> orderList, ArrayList<Order>deliveredList, ArrayList<DeliveryPerson> availableDeliveryPerson){
        int id= askInt("Id of delivered order:");
        int index;

        for (Order pendingOrder : orderList) {
            if (pendingOrder.getId()== id){
                index= orderList.indexOf(pendingOrder);
                deliveredList.add(orderList.get(index));
                availableDeliveryPerson.add(orderList.get(index).getDeliveryPerson());
                orderList.remove(index);
                System.out.println("The order number " +id +" is delivered!");
                System.out.println("The deliver " +pendingOrder.getDeliveryPerson().getName() +" is available again.");
                return;
            }
        }

        System.out.println("Not order found");

    }

    static void printPendingList (ArrayList<Order> orderList) {
        if (orderList.isEmpty()) {
            System.out.println("There's no pending orders!");
        } else {
            orderList.forEach(System.out::println);
        }
    }

    static void printDeliveredList(ArrayList<Order> deliveredList) {
        if (deliveredList.isEmpty()) {
            System.out.println("There's no pending orders!");
        } else {
            deliveredList.forEach(System.out::println);
        }
    }

    static Client newClient() {
        String name;
        String address;
        Client client = new Client(askString("Client name"), askString("Client address"));
        return client;
    }

    static String askString(String message) {
        Scanner input = new Scanner(System.in);
        System.out.println(message);
        return input.nextLine();
    }

    static int askInt(String message) {
        Scanner input = new Scanner(System.in);
        int value = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.println(message);
                value = input.nextInt();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                input.next();
            }
        }

        return value;
    }
}

