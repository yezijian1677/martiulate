package com.matriculate.entity;

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

    public SchoolInfo(String pcxx, String yxdm, String yxmc, String klmc, Long admitNum, Integer topScore, Integer topRank, Long avgScore, Long avgRank, Integer lastScore, Integer lastRank) {
        this.pcxx = pcxx;
        this.yxdm = yxdm;
        this.yxmc = yxmc;
        this.klmc = klmc;
        this.admitNum = admitNum;
        this.topScore = topScore;
        this.topRank = topRank;
        this.avgScore = avgScore;
        this.avgRank = avgRank;
        this.lastScore = lastScore;
        this.lastRank = lastRank;
    }

    public SchoolInfo() {
        super();
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

    public String getKlmc() {
        return klmc;
    }

    public void setKlmc(String klmc) {
        this.klmc = klmc == null ? null : klmc.trim();
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