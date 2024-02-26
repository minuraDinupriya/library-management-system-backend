package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private long id;
    private Long isbn;
    private String tittle;
    private String author;
    private String category;
    private Integer qty;
}