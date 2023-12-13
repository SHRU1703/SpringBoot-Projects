package com.pdfdata.controller;

public class PdfRequest {

    private String title;
    private String content;

    // Getters and Setters (or use Lombok annotations if available)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
