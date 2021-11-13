package ua.konstantynov.hw23_jdbc.objects;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@ToString
@Setter
@Getter
@NoArgsConstructor
public class Device {
    private String id;
    private String type;
    private String deviceModel;
    private Double price;
    private Date creationDate;
    private String description;
    private boolean isInStock;
    private Factory factory;
}
