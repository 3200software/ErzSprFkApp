package com.software3200.erzsprfkapp.Model;

import java.util.Date;

public class ModelStories {

    public String storyVideoUrl;
    public Boolean storyPrivateInfo;
    public Date storyAddDate;

    public ModelStories(String storyVideoUrl, Boolean storyPrivateInfo, Date storyAddDate) {

        this.storyVideoUrl = storyVideoUrl;
        this.storyPrivateInfo = storyPrivateInfo;
        this.storyAddDate = storyAddDate;
    }
}
