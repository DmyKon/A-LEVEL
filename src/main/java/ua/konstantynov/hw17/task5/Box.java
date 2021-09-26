package ua.konstantynov.hw17.task5;

import lombok.*;

import java.util.List;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Box {
    private List<Item> Item;
    private int size;
}