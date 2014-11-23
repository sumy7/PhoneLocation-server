package com.phonelocation.model;

/**
 * Token信息
 * 
 * @author sumy
 *
 */
public class Token {

    private String owner; // 所属的PhoneID
    private String tokenid;// TokenID
    private Long deadline;// 过期时间

    public Token() {

    }

    public Token(String owner, String tokenid, Long deadline) {
        this.owner = owner;
        this.tokenid = tokenid;
        this.deadline = deadline;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getTokenid() {
        return tokenid;
    }

    public void setTokenid(String tokenid) {
        this.tokenid = tokenid;
    }

    public Long getDeadline() {
        return deadline;
    }

    public void setDeadline(Long deadline) {
        this.deadline = deadline;
    }

}
