package ua.konstantynov.test2_stream_api.service;

import ua.konstantynov.test2_stream_api.exceptions.IncorrectValueException;
import ua.konstantynov.test2_stream_api.objects.*;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class ShopService {
    private static final List<Invoice> invoices = new ArrayList<>();
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("[dd MMMMM yyyy kk:mm:ss]");

    public static List<Invoice> getInvoices() {
        return invoices;
    }

    public static List<Product> readCsvFile(String fileName) {
        ClassLoader classLoader = ShopService.class.getClassLoader();
        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            List<String[]> list = new ArrayList<>();
            int type = -1;
            int series = -1;
            int model = -1;
            int diagonal = -1;
            int screenType = -1;
            int country = -1;
            int price = -1;
            try (BufferedReader reader = new BufferedReader(new FileReader(new File(resource.toURI())))) {
                String str;
                String[] csvTitle = reader.readLine().split(",");
                for (int i = 0; i < csvTitle.length; i++) {
                    type = csvTitle[i].equals("type") ? i : type;
                    series = csvTitle[i].equals("series") ? i : series;
                    model = csvTitle[i].equals("model") ? i : model;
                    diagonal = csvTitle[i].equals("diagonal") ? i : diagonal;
                    screenType = csvTitle[i].equals("screen type") ? i : screenType;
                    country = csvTitle[i].equals("country") ? i : country;
                    price = csvTitle[i].equals("price") ? i : price;
                }
                while ((str = reader.readLine()) != null) {
                    String[] strings = str.split(",");
                    try {
                        if (strings[price].matches("[^0-9]+")) {
                            throw new IncorrectValueException("price must be numeric \"" + str + "\"");
                        }
                        if (Arrays.asList(strings).contains("")) {
                            throw new IncorrectValueException("value must be not empty \"" + str + "\"");
                        }
                        list.add(strings);
                    } catch (IncorrectValueException ive) {
                        ive.printStackTrace();
                    }
                }
            } catch (IOException | URISyntaxException e) {
                e.printStackTrace();
            }
            List<Product> products = new ArrayList<>();
            for (String[] strings : list) {
                if (strings[type].equals("Telephone")) {
                    Telephone telephone = new Telephone();
                    telephone.setProductType(strings[type]);
                    telephone.setSeries(strings[series]);
                    telephone.setModel(strings[model]);
                    telephone.setScreenType(strings[screenType]);
                    telephone.setPrice(Integer.parseInt(strings[price]));
                    products.add(telephone);
                } else if (strings[type].equals("Television")) {
                    Television television = new Television();
                    television.setProductType(strings[type]);
                    television.setSeries(strings[series]);
                    television.setDiagonal(strings[diagonal]);
                    television.setScreenType(strings[screenType]);
                    television.setCountry(strings[country]);
                    television.setPrice(Integer.parseInt(strings[price]));
                    products.add(television);
                }
            }
            return products;
        }
    }

    private static void createLog(Invoice invoice) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(
                "src" + File.separator + "main" + File.separator + "resources" +
                        File.separator + "log.txt", true))) {
            bufferedWriter.write(dateFormat.format(invoice.getDateTime()) +
                    " [" + invoice.getCustomer() + "] [Invoice(" + invoice.getProducts() +
                    ", type=" + invoice.getType() + ")]\n");
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void setRandomInvoice(List<Product> productList, int limit) {
        List<Product> products = new ArrayList<>();
        for (int i = 0; i <= ThreadLocalRandom.current().nextInt(1, 6); i++) {
            products.add(productList.get(ThreadLocalRandom.current().nextInt(productList.size())));
        }
        Invoice invoice = new Invoice();
        invoice.setProducts(products);
        invoice.setCustomer(PersonService.setRandom());
        if (products.stream().mapToInt(Product::getPrice).sum() > limit) {
            invoice.setType(InvoiceType.WHOLESALE);
        } else {
            invoice.setType(InvoiceType.RETAIL);
        }
        invoice.setDateTime(new Date());
        createLog(invoice);
        invoices.add(invoice);
    }
}