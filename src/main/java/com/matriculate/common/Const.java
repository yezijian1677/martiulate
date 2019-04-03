package com.matriculate.common;

public class Const {


   public static String getKlmcName(String klmc){
        if (klmc.equals("文史类")){
            return "Wk";
        }
        else if (klmc.equals("理工类")){
            return "Lk";
        }else {
            throw new RuntimeException("类型不符");
        }
    }

}
