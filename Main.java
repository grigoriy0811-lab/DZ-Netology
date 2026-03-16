import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Address, Integer> PriceForDelivery = new HashMap<>();

        int shippingCost = 0;
        Set<String> newCountries = new HashSet<>();

        PriceForDelivery.put(new Address("Россия", "Якутск"), 150);
        PriceForDelivery.put(new Address("Азербайджан", "Баку"), 250);
        PriceForDelivery.put(new Address("США", "Остин"), 350);

        while (true) {
            System.out.println("Выберите операцию:\n" +
                    "1. Заполнить новый заказ. \n" +
                    "end - Выход из программы!");

            String choiceOne = (scanner.nextLine());

            if ("end".equals(choiceOne)) {
                System.out.println("Выход из программы!");
                break;
            } else if (choiceOne.equals("1")) {
                System.out.print("Введите страну: ");
                String country = scanner.nextLine();
                System.out.print("Введите город: ");
                String city = scanner.nextLine();
                System.out.print("Введите вес(кг): ");
                int totalWeight = Integer.parseInt(scanner.nextLine());

                Address userAddress = new Address(country, city);

                if (PriceForDelivery.containsKey(userAddress)) {
                    int pricePerKg = PriceForDelivery.get(userAddress);
                    int deliveryCost = pricePerKg * totalWeight;
                    shippingCost += deliveryCost;

                    newCountries.add(country);

                    System.out.println("Стоимость доставки составит: " + deliveryCost + " руб.");
                    System.out.println("Общая стоимость всех доставок: " + shippingCost + " руб.");
                    System.out.println("Количество стран доставки: " + newCountries.size());
                } else {
                    System.out.println("Доставка по этому адресу отсутствует!");
                }
            }
        }
    }
}