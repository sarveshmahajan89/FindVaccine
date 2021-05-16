package com.github.ssoni.batch.bean;

public class Footer {

    private int total;
    private int added;
    private String userName;

    public Footer(int total, int added) {
        this.total = total;
        this.added = added;
        this.userName = "Guest";
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getAdded() {
        return added;
    }

    public void setAdded(int added) {
        this.added = added;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
