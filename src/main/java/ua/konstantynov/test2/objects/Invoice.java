package ua.konstantynov.test2.objects;

import lombok.*;

import java.util.List;

@ToString
@Setter
@Getter
@NoArgsConstructor

public class Invoice {
    private List<Product> products;
    private Customer customer;
    private String type;
}