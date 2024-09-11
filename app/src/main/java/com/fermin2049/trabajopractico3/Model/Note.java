package com.fermin2049.trabajopractico3.Model;

import java.util.Date;

public class Note {
    private String content;
    private Date creationDate;
    private Date endDate;
    private String color; // Agregar campo de color

    public Note(String content, Date creationDate, Date endDate) {
        this.content = content;
        this.creationDate = creationDate;
        this.endDate = endDate;
        this.color = "green"; // Valor predeterminado
    }

    // Getters y Setters
    public String getContent() {
        return content;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


}
