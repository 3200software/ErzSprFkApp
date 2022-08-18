package com.software3200.erzsprfkapp.Model;

public class ModelMainStories {

    public String mainStoriesTitle;
    public String mainStoriesImgUrl;
    public String mainStoriesVideoUrl;
    public Integer mainStoriesViewCount;
    public Integer mainStoriesLikeCount;
    public Boolean mainStoriesPrivateContent;

    public ModelMainStories(String mainStoriesTitle, String mainStoriesImgUrl, String mainStoriesVideoUrl, Integer mainStoriesViewCount, Integer mainStoriesLikeCount, Boolean mainStoriesPrivateContent) {
        this.mainStoriesTitle = mainStoriesTitle;
        this.mainStoriesImgUrl = mainStoriesImgUrl;
        this.mainStoriesVideoUrl = mainStoriesVideoUrl;
        this.mainStoriesViewCount = mainStoriesViewCount;
        this.mainStoriesLikeCount = mainStoriesLikeCount;
        this.mainStoriesPrivateContent = mainStoriesPrivateContent;
    }
}
