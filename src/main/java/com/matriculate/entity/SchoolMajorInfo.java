package com.matriculate.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SchoolMajorInfo {
    private String pcmc;

    private String yxdm;

    private String yxmc;

    private String klmc;

    private String zymc;

    private String lqs;

    private String maxzf;

    private String maxmc;

    private String avgzf;

    private String avgmc;

    private String minzf;

    private String minmc;
}