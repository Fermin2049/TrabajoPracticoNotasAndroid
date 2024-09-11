package com.fermin2049.trabajopractico3.Model;

import java.util.Date;

public class Note {
    private String content;
    private Date creationDate;
    private Date endDate;

    public Note(String content, Date creationDate, Date endDate) {
        this.content = content;
        this.creationDate = creationDate;
        this.endDate = endDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }


}
