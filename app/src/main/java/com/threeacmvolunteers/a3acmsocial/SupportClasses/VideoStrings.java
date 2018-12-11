package com.threeacmvolunteers.a3acmsocial.SupportClasses;

public class VideoStrings {
    String id,name,title,by,discription,tags,date,time,src;

    public VideoStrings(String id, String name, String title, String by, String discription, String tags, String date, String time,String src) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.by = by;
        this.discription = discription;
        this.tags = tags;
        this.date = date;
        this.time = time;
        this.src= src;

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

    public String getDiscription() {
        return discription;
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

    public String getSrc() {
        return src;
    }
}
