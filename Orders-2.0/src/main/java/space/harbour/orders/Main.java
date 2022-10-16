package space.harbour.orders;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import space.harbour.orders.domain.Order;
import space.harbour.orders.exception.CustomerNotFoundException;
import space.harbour.orders.util.FileUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static space.harbour.orders.util.FileUtils.isCsvFile;
import static space.harbour.orders.util.OrderUtil.getTotalPrice;

public class Main {

    private static Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter the filepath: ");
        String filepath = keyboard.nextLine();
        if (!new File(filepath).exists()) {
            System.out.println("File does not exist");
            logger.error("File doest not exist");
            return;
        }

        if (!isCsvFile(filepath)) {
            System.out.println("Invalid file type");
            return;
        }

        try {
            List<Order> orderList = FileUtils.readOrdersFile(filepath);
            System.out.println("Orders Application");
            System.out.println("1. List customers");
            System.out.println("2. Customer total price");
            System.out.println("3. Total price");
            String choice = keyboard.nextLine();
            switch (choice) {
                case "1":
                    logger.debug("User choose choice 1");
                    System.out.println("List customers");
                    List<String> customerList = orderList.stream()
                            .map(Order::getCustomerName)
                            .distinct()
                            .collect(Collectors.toList());
                    System.out.println(customerList);
                    break;
                case "2":
                    logger.debug("User choose choice 2");
                    System.out.print("Full name: ");
                    String customerName = keyboard.nextLine();
                    double customerTotalPrice = getTotalPrice(orderList, customerName);
                    System.out.println("Total price: Clark Kent -> " + customerTotalPrice);
                    break;
                case "3":
                    logger.debug("User choose choice 3");
                    double totalPrice = orderList.stream()
                            .mapToDouble(Order::getPrice)
                            .sum();
                    System.out.println("Total price -> " + totalPrice);
                    break;
            }
        } catch (FileNotFoundException fnfe) {
            System.out.println("File doesn't exist");
            fnfe.printStackTrace();
            logger.error("File doesn't exist");
        } catch (IOException ioe) {
            System.out.println("There is a problem while reading the file");
            ioe.printStackTrace();
            logger.error("There is a problem while reading the file");
        } catch (CustomerNotFoundException cnfe) {
            System.out.println(cnfe.getMessage());
            logger.error(cnfe.getMessage());
        }
    }
}
