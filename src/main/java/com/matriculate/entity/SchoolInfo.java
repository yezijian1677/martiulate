package com.matriculate.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SchoolInfo {
    private String pcxx;

    private String yxdm;

    private String yxmc;

    private String klmc;

    private Long admitNum;

    private Integer topScore;

    private Integer topRank;

    private Long avgScore;

    private Long avgRank;

    private Integer lastScore;

    private Integer lastRank;


}