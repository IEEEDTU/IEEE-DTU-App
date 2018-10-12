package org.ieeedtu.ieee_dtu;

import java.util.ArrayList;

public class Projects {
    private String title;
    private ArrayList<String> tags;
    private String desc ;
    private int contact;
    private String link;
    private String madeBy;


    public String getMadeBy() {
        return madeBy;
    }

    public void setMadeBy(String madeBy) {
        this.madeBy = madeBy;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getContact() {
        return contact;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }




}
