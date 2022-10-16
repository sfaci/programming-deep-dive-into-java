package space.harbour.orders;

import space.harbour.orders.domain.Order;
import space.harbour.orders.util.FileUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        try {
            List<Order> orderList = FileUtils.readOrdersFile("/home/astable/orders.csv");
            System.out.println("List customers");
            List<String> customerList = orderList.stream()
                    .map(Order::getCustomerName)
                    .distinct()
                    .collect(Collectors.toList());
            System.out.println(customerList);

            double totalPriceCK = orderList.stream()
                    .filter(order -> order.getCustomerName().equals("Clark Kent"))
                    .mapToDouble(Order::getPrice)
                    .sum();
            System.out.println("Total price: Clark Kent -> " + totalPriceCK);

            double totalPrice = orderList.stream()
                    .mapToDouble(Order::getPrice)
                    .sum();
            System.out.println("Total price -> " + totalPrice);

        } catch (FileNotFoundException fnfe) {
            System.out.println("File doesn't exist");
            fnfe.printStackTrace();
        } catch (IOException ioe) {
            System.out.println("There is a problem while reading the file");
            ioe.printStackTrace();
        }
    }
}
