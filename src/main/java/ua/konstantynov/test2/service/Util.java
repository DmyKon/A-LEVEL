package ua.konstantynov.test2.service;

import ua.konstantynov.test2.objects.Customer;
import ua.konstantynov.test2.objects.Product;
import ua.konstantynov.test2.objects.Invoice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Util {
    public static long countOfProductSoldByCategory(String productCategory) {
        return ShopService.getInvoices().stream()
                .map(Invoice::getProducts)
                .flatMap(Collection::stream)
                .filter(x -> x.getProductType().equals(productCategory)).count();
    }

    public static Integer minimumCheckAmount() {
        return ShopService.getInvoices().stream()
                .map(Invoice::getProducts)
                .map(x -> x.stream().mapToInt(Product::getPrice).sum())
                .reduce(Integer.MAX_VALUE, Integer::min);
    }

    public static List<Customer> customerInfoByCheckAmount(int sum) {
        return ShopService.getInvoices().stream()
                .filter(x -> x.getProducts().stream().mapToInt(Product::getPrice).sum() == sum)
                .map(Invoice::getCustomer)
                .collect(Collectors.toList());
    }

    public static Integer totalAmountSold() {
        return ShopService.getInvoices().stream()
                .flatMap(x -> x.getProducts().stream())
                .mapToInt(Product::getPrice)
                .sum();
    }

    public static long retailCheckCount() {
        return ShopService.getInvoices().stream()
                .filter(x -> x.getType().contains("retail"))
                .count();
    }

    public static List<Invoice> lowAgeCheckInfo() {
        return ShopService.getInvoices().stream()
                .filter(x -> x.getCustomer().getAge() < 18)
                .peek(x -> x.setType("low_age"))
                .collect(Collectors.toList());
    }

    public static List<Invoice> sorting() {
        return ShopService.getInvoices().stream()
                .sorted(Comparator.comparing((Invoice x) -> x.getCustomer().getAge())
                        .thenComparing(x -> x.getProducts().size())
                        .thenComparing(x -> x.getProducts().stream()
                                .map(Product::getPrice)
                                .mapToInt(z -> z)
                                .sum()))
                .collect(Collectors.toList());
    }

    public static List<Invoice> onlyOneCategoryChecks() {
        Object[] productTypes = ShopService.getInvoices().stream()
                .flatMap(x -> x.getProducts().stream())
                .map(Product::getProductType)
                .distinct()
                .toArray();
        List<Invoice> list = new ArrayList<>();
        for (Object type : productTypes) {
            list.addAll(ShopService.getInvoices().stream()
                    .filter(x -> x.getProducts().stream()
                            .map(Product::getProductType)
                            .allMatch(y -> y.equals(type)))
                    .collect(Collectors.toList()));
        }
        return list;
    }
}