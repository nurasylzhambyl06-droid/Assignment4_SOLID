package service.interfaces;

public interface PricedItem {
    double getPrice();

    default boolean isExpensive() {
        return getPrice() > 1000;
    }

    static void printPrice(double price) {
        System.out.println("Price: " + price);
    }
}
