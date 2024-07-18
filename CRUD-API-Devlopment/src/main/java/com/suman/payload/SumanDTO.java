package com.suman.payload;

import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SumanDTO {
    private long id;
    private String name;
    private String email;
    private String mobile;
}
