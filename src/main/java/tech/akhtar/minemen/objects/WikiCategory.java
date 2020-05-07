package tech.akhtar.minemen.objects;

import tech.akhtar.minemen.Web;

public class WikiCategory {

    private String categoryName;
    private int numberOfWikiArticles;
    private String categoryUrl;

    public WikiCategory(String categoryName, int numberOfWikiArticles, String categoryUrl) {
        this.categoryName = categoryName;
        this.numberOfWikiArticles = numberOfWikiArticles;
        this.categoryUrl = categoryUrl;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public int getNumberOfWikiArticles() {
        return numberOfWikiArticles;
    }

    public String getCategoryUrl() {
        return categoryUrl;
    }

    public String getCategoryUrlFull() {
        return Web.MINEMEN_URL + categoryUrl;
    }

}
