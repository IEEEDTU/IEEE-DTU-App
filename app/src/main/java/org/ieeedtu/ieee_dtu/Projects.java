package org.ieeedtu.ieee_dtu;

import java.util.ArrayList;

public class Projects {
    private String title;
    private String[] tags;
    private String desc ;
    private int contact;



    private String year;
    private String link;
    private ArrayList<String[]> madeBy;


    public ArrayList<String[]> getMadeBy() {
        return madeBy;
    }

    public void setMadeBy(ArrayList<String[]> madeBy) {
        this.madeBy = madeBy;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTags(int i) {

        return tags[i];
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }


    public void setYear(String year) {
        this.year = year;
    }

    public String getYear() {

        return year;
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
