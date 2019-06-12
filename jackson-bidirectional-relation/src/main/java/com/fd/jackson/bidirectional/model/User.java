package com.fd.jackson.bidirectional.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class User {

    private int id;
    private String name;

    @JsonBackReference
    private List<Item> userItems = new ArrayList<>();

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void addItem(Item item) {
        this.userItems.add(item);
    }
}
