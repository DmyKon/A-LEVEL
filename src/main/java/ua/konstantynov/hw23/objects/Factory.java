package ua.konstantynov.hw23.objects;

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