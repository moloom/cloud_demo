package com.mo.moloom.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Long id;
    private Long price;
    private String name;
    private Integer num;
    private Long userId;
    private User user;
}