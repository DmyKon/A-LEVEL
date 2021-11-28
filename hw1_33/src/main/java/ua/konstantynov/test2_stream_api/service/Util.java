package ua.konstantynov.test2_stream_api.service;

import ua.konstantynov.test2_stream_api.objects.Customer;
import ua.konstantynov.test2_stream_api.objects.InvoiceType;
import ua.konstantynov.test2_stream_api.objects.Product;
import ua.konstantynov.test2_stream_api.objects.Invoice;

import java.util.*;
import java.util.stream.Collectors;

public class Util {
    public static long countOfProductSoldByCategory(String productCategory) {
        return ShopService.getInvoices().stream()
                .map(Invoice::getProducts)
                .flatMap(Collection::stream)
                .filter(x -> x.getProductType().equals(productCategory)).count();
    }

    public static Map.Entry<Integer, Optional<Customer>> minimumCheckAmountAndCustomer() {
        int sum;
        return new AbstractMap.SimpleEntry<>(
                sum = ShopService.getInvoices().isEmpty() ? 0 : ShopService.getInvoices().stream()
                        .map(Invoice::getProducts)
                        .map(x -> x.stream().mapToInt(Product::getPrice).sum())
                        .reduce(Integer.MAX_VALUE, Integer::min),
                ShopService.getInvoices().stream()
                        .filter(x -> x.getProducts().stream().mapToInt(Product::getPrice).sum() == sum)
                        .map(Invoice::getCustomer)
                        .findFirst());
    }

    public static Integer totalAmountSold() {
        return ShopService.getInvoices().stream()
                .flatMap(x -> x.getProducts().stream())
                .mapToInt(Product::getPrice)
                .sum();
    }

    public static long retailCheckCount() {
        return ShopService.getInvoices().stream()
                .filter(x -> x.getType().equals(InvoiceType.RETAIL))
                .count();
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

    public static List<Invoice> lowAgeCheckInfo() {
        return ShopService.getInvoices().stream()
                .filter(x -> x.getCustomer().getAge() < 18)
                .peek(x -> x.setType(InvoiceType.LOW_AGE))
                .collect(Collectors.toList());
    }

    public static List<Invoice> sorting() {
        return ShopService.getInvoices().stream()
                .sorted(Comparator.comparing((Invoice x) -> x.getCustomer().getAge()).reversed()
                        .thenComparing(x -> x.getProducts().size())
                        .thenComparing(x -> x.getProducts().stream()
                                .map(Product::getPrice)
                                .mapToInt(z -> z)
                                .sum()))
                .collect(Collectors.toList());
    }
}