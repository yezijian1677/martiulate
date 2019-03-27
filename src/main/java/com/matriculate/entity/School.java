package com.matriculate.entity;

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

    public School(String ksh, String klmc, String klxx, String pcmc, String pcxx, String yxdm, String yxmc, String zydm, String zymc, Integer zf, Integer pm, String ccdm, String lqzyxh) {
        this.ksh = ksh;
        this.klmc = klmc;
        this.klxx = klxx;
        this.pcmc = pcmc;
        this.pcxx = pcxx;
        this.yxdm = yxdm;
        this.yxmc = yxmc;
        this.zydm = zydm;
        this.zymc = zymc;
        this.zf = zf;
        this.pm = pm;
        this.ccdm = ccdm;
        this.lqzyxh = lqzyxh;
    }

    public School() {
        super();
    }

    public String getKsh() {
        return ksh;
    }

    public void setKsh(String ksh) {
        this.ksh = ksh == null ? null : ksh.trim();
    }

    public String getKlmc() {
        return klmc;
    }

    public void setKlmc(String klmc) {
        this.klmc = klmc == null ? null : klmc.trim();
    }

    public String getKlxx() {
        return klxx;
    }

    public void setKlxx(String klxx) {
        this.klxx = klxx == null ? null : klxx.trim();
    }

    public String getPcmc() {
        return pcmc;
    }

    public void setPcmc(String pcmc) {
        this.pcmc = pcmc == null ? null : pcmc.trim();
    }

    public String getPcxx() {
        return pcxx;
    }

    public void setPcxx(String pcxx) {
        this.pcxx = pcxx == null ? null : pcxx.trim();
    }

    public String getYxdm() {
        return yxdm;
    }

    public void setYxdm(String yxdm) {
        this.yxdm = yxdm == null ? null : yxdm.trim();
    }

    public String getYxmc() {
        return yxmc;
    }

    public void setYxmc(String yxmc) {
        this.yxmc = yxmc == null ? null : yxmc.trim();
    }

    public String getZydm() {
        return zydm;
    }

    public void setZydm(String zydm) {
        this.zydm = zydm == null ? null : zydm.trim();
    }

    public String getZymc() {
        return zymc;
    }

    public void setZymc(String zymc) {
        this.zymc = zymc == null ? null : zymc.trim();
    }

    public Integer getZf() {
        return zf;
    }

    public void setZf(Integer zf) {
        this.zf = zf;
    }

    public Integer getPm() {
        return pm;
    }

    public void setPm(Integer pm) {
        this.pm = pm;
    }

    public String getCcdm() {
        return ccdm;
    }

    public void setCcdm(String ccdm) {
        this.ccdm = ccdm == null ? null : ccdm.trim();
    }

    public String getLqzyxh() {
        return lqzyxh;
    }

    public void setLqzyxh(String lqzyxh) {
        this.lqzyxh = lqzyxh == null ? null : lqzyxh.trim();
    }
}