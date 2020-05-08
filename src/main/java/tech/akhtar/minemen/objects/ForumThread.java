package tech.akhtar.minemen.objects;

import tech.akhtar.minemen.Web;

public class ForumThread {

    private String threadTitle;
    private String threadCreator;
    private String datePosted;
    private String threadUrl;

    public ForumThread(String threadTitle, String threadCreator, String datePosted, String threadUrl) {
        this.threadTitle = threadTitle;
        this.threadCreator = threadCreator;
        this.datePosted = datePosted;
        this.threadUrl = threadUrl;
    }

    public String getThreadTitle() {
        return threadTitle;
    }

    public String getThreadCreator() {
        return threadCreator;
    }

    public String getDatePosted() {
        return datePosted;
    }

    public String getThreadUrl() {
        return threadUrl;
    }

    public String getThreadUrlFull() {
        return Web.MINEMEN_URL + threadUrl;
    }
}
