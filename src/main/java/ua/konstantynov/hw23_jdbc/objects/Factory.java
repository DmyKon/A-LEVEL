package ua.konstantynov.hw23_jdbc.objects;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
@NoArgsConstructor
public class Factory {
    private String id;
    private String name;
    private String country;
}