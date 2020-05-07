package tech.akhtar.minemen.objects;

import tech.akhtar.minemen.Web;

public class WikiArticle {

    private String articleName;
    private String articleUrl;

    public WikiArticle(String articleName, String articleUrl) {
        this.articleName = articleName;
        this.articleUrl = articleUrl;
    }

    public String getArticleName() {
        return articleName;
    }

    public String getArticleUrl() {
        return articleUrl;
    }

    public String getArticleUrlFull() {
        return Web.MINEMEN_URL + articleUrl;
    }
}
