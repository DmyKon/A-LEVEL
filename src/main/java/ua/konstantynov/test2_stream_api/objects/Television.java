package ua.konstantynov.test2_stream_api.objects;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class Television extends Product {
    private String diagonal;
    private String country;

    @Override
    public String toString() {
        return super.getProductType() + "{" +
                "series='" + super.getSeries() + '\'' +
                ", diagonal='" + diagonal + '\'' +
                ", screenType='" + super.getScreenType() + '\'' +
                ", country='" + country + '\'' +
                ", price=" + super.getPrice() +
                '}';
    }
}