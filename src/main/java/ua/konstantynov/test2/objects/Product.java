package ua.konstantynov.test2.objects;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public abstract class Product {
    private String productType;
    private String series;
    private String screenType;
    private int price;
}