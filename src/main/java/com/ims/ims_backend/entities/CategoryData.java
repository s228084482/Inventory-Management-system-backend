package com.ims.ims_backend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CategoryData {
    private Long id;
    private String name;
    private Long productAssigned;
    private String percentage;

}
