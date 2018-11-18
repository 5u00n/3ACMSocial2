package com.threeacmvolunteers.a3acmsocial2.SupportClasses;

public class VideoStrings {
    String id,name,title,by,disription,tags,date,time;

    public VideoStrings(String id, String name, String title, String by, String disription, String tags, String date, String time) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.by = by;
        this.disription = disription;
        this.tags = tags;
        this.date = date;
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public String getBy() {
        return by;
    }

    public String getDisription() {
        return disription;
    }

    public String getTags() {
        return tags;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }
}
