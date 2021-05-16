package com.github.ssoni.batch.bean;

import java.util.List;

public class ResponseBean {


    private List<CenterDetail> sessions;


    public ResponseBean() {
    }

    public ResponseBean(List<CenterDetail> sessions) {
        this.sessions = sessions;
    }

    public List<CenterDetail> getSessions() {
        return sessions;
    }

    public void setSessions(List<CenterDetail> sessions) {
        this.sessions = sessions;
    }

    @Override
    public String toString() {
        return "ResponseBean{" +
                "sessions=" + sessions +
                '}';
    }
}
