package org.ieeedtu.ieee_dtu;

public class CouncilMembers {
    private String name;
    private String facebook;
    private String linkedin;
    private Integer profile_pic;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public Integer getProfile_pic() {
        return profile_pic;
    }

    public void setProfile_pic(Integer profile_pic) {
        this.profile_pic = profile_pic;
    }


    public CouncilMembers(String name, String facebook, String linkedin, Integer profile_pic) {
        this.name = name;
        this.facebook = facebook;
        this.linkedin = linkedin;
        this.profile_pic = profile_pic;
    }
}
