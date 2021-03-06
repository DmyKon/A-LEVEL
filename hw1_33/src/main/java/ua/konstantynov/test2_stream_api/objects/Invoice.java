package ua.konstantynov.test2_stream_api.objects;

import lombok.*;

import java.util.Date;
import java.util.List;

@ToString
@Setter
@Getter
@NoArgsConstructor

public class Invoice {
    private List<Product> products;
    private Customer customer;
    private InvoiceType type;
    private Date dateTime;
}