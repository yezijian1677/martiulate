package com.matriculate.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class School {
    private String ksh;

    private String klmc;

    private String klxx;

    private String pcmc;

    private String pcxx;

    private String yxdm;

    private String yxmc;

    private String zydm;

    private String zymc;

    private Integer zf;

    private Integer pm;

    private String ccdm;

    private String lqzyxh;
}