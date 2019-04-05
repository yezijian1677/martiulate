package com.matriculate.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SchoolShort {
    private String pcxx;
    private String yxmc;
    private String zymc;
    private Integer pm;
}
