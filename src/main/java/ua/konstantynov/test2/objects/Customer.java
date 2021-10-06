package ua.konstantynov.test2.objects;

import lombok.*;

@ToString
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Customer {
    private int id;
    private String email;
    private int age;
}