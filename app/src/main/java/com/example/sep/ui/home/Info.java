package com.example.sep.ui.home;

import org.w3c.dom.ls.LSOutput;

public class Info {
    private String details;
    private float level;
    private boolean expandable;
    private int imageId;
    private String infoOf;

    public Info(String infoOf, String details, int level, int imageId) {
        this.infoOf = infoOf;
        this.details = details;
        this.level = level;
        this.expandable = false;
        this.imageId = imageId;
    }

    public String getInfoOf() {
        return infoOf;
    }

    public void setInfoOf(String infoOf) {
        this.infoOf = infoOf;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public float getLevel()
    {
     return level;
    }

    public void setLevel(float level) {
        this.level = level;
    }

    public boolean isExpandable() {
        return expandable;
    }

    public void setExpandable(boolean expandable) {
        this.expandable = expandable;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
