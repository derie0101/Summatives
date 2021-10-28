/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Dto.Order;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author QUEEN
 */
public class OrderFileImpl implements OrderDao {
      String folder;
        public OrderFileImpl( String folder ){
            this.folder = folder;
        }


    private void writeOrders(List<Order> ordersList, LocalDate date)
            throws FlooringDaoException {

        String filePath = DateName(date);
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(filePath));
        } catch (IOException e) {
            throw new FlooringDaoException(
                    "Could not save order data.", e);
        }


        for (Order currentOrder : ordersList) {

            out.println(currentOrder.getOrderNumber() + ","
                    + currentOrder.getCustomerName() + ","
                    + currentOrder.getState() + ","
                    + currentOrder.getTaxRate() + ","
                    + currentOrder.getProductName() + ","
                    + currentOrder.getArea() + ","
                    + currentOrder.getCostPerSq() + ","
                    + currentOrder.getLaborPerSq() + ","
                    + currentOrder.getMaterialCost() + ","
                    + currentOrder.getLaborCost() + ","
                    + currentOrder.getTotalTax() + ","
                    + currentOrder.getTotalAmount());

            out.flush();
        }

        out.close();
    }

    @Override
    public Order getOrder(LocalDate date, int orderNumber)
            throws FlooringDaoException {

        List<Order> fileList = getAllOrders(date);
          throw new UnsupportedOperationException();
        
    


    }

    @Override
    public Order addOrder(Order newOrder)
            throws FlooringDaoException  {
        LocalDate date = newOrder.getOrderDate();
        List<Order> fileList = getAllOrders(date);
          return null;

    }

    @Override
    public List<Order> getAllOrders(LocalDate date) throws FlooringDaoException {

        List<Order> toReturn = new ArrayList<Order>();

        String fileName = DateName(date);
        File fileCheck = new File(fileName);
        if (fileCheck.exists()) {
            Scanner scanner;

            try {

                scanner = new Scanner(
                        new BufferedReader(
                                new FileReader(fileName)));
            } catch (FileNotFoundException e) {
                throw new FlooringDaoException(
                        "-_- Could not load item data into memory.", e);
            }
            String currentLine;

            String[] currentTokens;

            //scanner.nextLine();

            while (scanner.hasNextLine()) {

                currentLine = scanner.nextLine();

                currentTokens = currentLine.split(",");

                Order currentOrder = new Order(date);
                currentOrder.setOrderNumber(Integer.parseInt(currentTokens[0]));
                currentOrder.setCustomerName(currentTokens[1]);
                currentOrder.setState((currentTokens[2]));
                currentOrder.setTaxRate(new BigDecimal(currentTokens[3]));
                currentOrder.setProductName(currentTokens[4]);
                currentOrder.setArea(new BigDecimal(currentTokens[5]));
                currentOrder.setCostPerSq(new BigDecimal(currentTokens[6]));
                currentOrder.setLaborPerSq(new BigDecimal(currentTokens[7]));

                toReturn.add(currentOrder);

            }

            scanner.close();
        }
        return toReturn;
    }

    @Override
    public void removeOrder(LocalDate date, int orderNumber)
            throws FlooringDaoException {
        List<Order> fileList = getAllOrders(date);
       
    }

    private String DateName(LocalDate date) {

        LocalDate Date = date;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMddyyyy");
        String formatted = Date.format(formatter);
        
        String fileName = "Order" + formatted + ".txt";
        String fullPath = Paths.get(folder, fileName).toString();
        
        return fullPath;

    }

    @Override
    public Order editOrder(Order order)
            throws FlooringDaoException {

        LocalDate date = order.getOrderDate();
        int orderNumber = order.getOrderNumber();

        removeOrder(date, orderNumber);
        List<Order> fileList = getAllOrders(date);

        fileList.add(order);
        writeOrders(fileList, date);
        return order;

    }

}
