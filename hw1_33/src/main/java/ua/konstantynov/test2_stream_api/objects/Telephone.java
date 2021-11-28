package ua.konstantynov.test2_stream_api.objects;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class Telephone extends Product {
    private String model;

    @Override
    public String toString() {
        return super.getProductType() + "{" +
                "series='" + super.getSeries() + '\'' +
                ", model=" + model + '\'' +
                ", screenType='" + super.getScreenType() + '\'' +
                ", price=" + super.getPrice() +
                '}';
    }
}