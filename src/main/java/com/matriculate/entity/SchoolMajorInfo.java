package com.matriculate.entity;

public class SchoolMajorInfo {
    private String pcmc;

    private String yxdm;

    private String yxmc;

    private String klmc;

    private String zymc;

    private Long admitNum;

    private Integer topScore;

    private Integer topRank;

    private Long avgScore;

    private Long avgRank;

    private Integer lastScore;

    private Integer lastRank;

    public SchoolMajorInfo(String pcmc, String yxdm, String yxmc, String klmc, String zymc, Long admitNum, Integer topScore, Integer topRank, Long avgScore, Long avgRank, Integer lastScore, Integer lastRank) {
        this.pcmc = pcmc;
        this.yxdm = yxdm;
        this.yxmc = yxmc;
        this.klmc = klmc;
        this.zymc = zymc;
        this.admitNum = admitNum;
        this.topScore = topScore;
        this.topRank = topRank;
        this.avgScore = avgScore;
        this.avgRank = avgRank;
        this.lastScore = lastScore;
        this.lastRank = lastRank;
    }

    public SchoolMajorInfo() {
        super();
    }

    public String getPcmc() {
        return pcmc;
    }

    public void setPcmc(String pcmc) {
        this.pcmc = pcmc == null ? null : pcmc.trim();
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

    public String getKlmc() {
        return klmc;
    }

    public void setKlmc(String klmc) {
        this.klmc = klmc == null ? null : klmc.trim();
    }

    public String getZymc() {
        return zymc;
    }

    public void setZymc(String zymc) {
        this.zymc = zymc == null ? null : zymc.trim();
    }

    public Long getAdmitNum() {
        return admitNum;
    }

    public void setAdmitNum(Long admitNum) {
        this.admitNum = admitNum;
    }

    public Integer getTopScore() {
        return topScore;
    }

    public void setTopScore(Integer topScore) {
        this.topScore = topScore;
    }

    public Integer getTopRank() {
        return topRank;
    }

    public void setTopRank(Integer topRank) {
        this.topRank = topRank;
    }

    public Long getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(Long avgScore) {
        this.avgScore = avgScore;
    }

    public Long getAvgRank() {
        return avgRank;
    }

    public void setAvgRank(Long avgRank) {
        this.avgRank = avgRank;
    }

    public Integer getLastScore() {
        return lastScore;
    }

    public void setLastScore(Integer lastScore) {
        this.lastScore = lastScore;
    }

    public Integer getLastRank() {
        return lastRank;
    }

    public void setLastRank(Integer lastRank) {
        this.lastRank = lastRank;
    }
}