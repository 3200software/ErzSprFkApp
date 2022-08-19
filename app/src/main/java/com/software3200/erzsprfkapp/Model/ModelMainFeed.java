package com.software3200.erzsprfkapp.Model;

public class ModelMainFeed {

    public String feedImageUrl;
    public String feedTitle;
    public String feedDescription;
    public String feedType;
    public Integer feedLikeCount;
    public String feedDocumentId;

    public ModelMainFeed(String feedImageUrl, String feedTitle, String feedDescription, String feedType, Integer feedLikeCount, String feedDocumentId) {
        this.feedImageUrl = feedImageUrl;
        this.feedTitle = feedTitle;
        this.feedDescription = feedDescription;
        this.feedType = feedType;
        this.feedLikeCount = feedLikeCount;
        this.feedDocumentId = feedDocumentId;
    }
}
