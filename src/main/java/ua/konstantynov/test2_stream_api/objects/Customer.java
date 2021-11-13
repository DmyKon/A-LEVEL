package ua.konstantynov.test2_stream_api.objects;

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