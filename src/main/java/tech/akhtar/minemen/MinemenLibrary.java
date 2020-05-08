package tech.akhtar.minemen;

import tech.akhtar.minemen.objects.ForumThread;
import tech.akhtar.minemen.objects.Resource;
import tech.akhtar.minemen.objects.WikiArticle;
import tech.akhtar.minemen.objects.WikiCategory;
import java.util.ArrayList;
import java.util.List;

public class MinemenLibrary {

    /***
     *
     * @return List of all the Wiki's Categories
     */
    public static List<WikiCategory> getWikiCategories() {
        List<WikiCategory> wikiCategories = new ArrayList<>();
        List<String> source = Web.getWebSourceCode("/wiki/");
        for (int f = 0; f < source.size(); f++) {
            String x = source.get(f);
            if (x.contains("fauxBlockLink-blockLink") && x.contains("category")) {
                String p = ((source.get(f + 11).contains("<dl class=\"pairs pairs--rows pairs--rows--centered\">")) ? source.get(f + 14) : source.get(f + 10));
                wikiCategories.add(new WikiCategory(source.get(f + 1).replaceAll("^\\s++", ""), Integer.parseInt(p.replaceAll("\\<.*?>", "")
                        .replaceAll("^\\s++", "")), x.split("\"")[1]));

            }
        }
        return wikiCategories;
    }

    /***
     *
     * @param wikiCategory the category you wish to get the articles from
     * @return List of all the Category's Articles
     */
    public static List<WikiArticle> getWikiArticlesFromCategory(WikiCategory wikiCategory) {
        List<WikiArticle> wikiArticles = new ArrayList<>();
        List<String> source = Web.getWebSourceCode(wikiCategory.getCategoryUrl());
        for (int f = 0; f < source.size(); f++) {
            String x = source.get(f);
            if (x.contains("fauxBlockLink-blockLink")) {
                wikiArticles.add(new WikiArticle(source.get(f + 1).replaceAll("^\\s++", ""), x.split("\"")[1]));
            }
        }
        return wikiArticles;
    }

    /***
     *
     * @return List of the Top Five Resources
     */
    public static List<Resource> getTopFiveRatedResources(){
        List<Resource> resources = new ArrayList<>();
        List<String> source = Web.getWebSourceCode("/resources/?order=rating_weighted");
        for (int f = 0; f < source.size(); f++) {
            if (resources.size() == 4) break;
            String x = source.get(f);
            if (x.contains("structItem-title")){
                resources.add(new Resource(
                        source.get(f + 3).replaceAll("^\\s+", ""),
                        source.get(f + 14).replaceAll("^\\s+", "").replaceAll("\\<.*?>", ""),
                        source.get(f + 6).replaceAll("\\<.*?>", "").replaceAll("^\\s+", ""),
                        source.get(f + 2).split("\"")[1].replaceAll("^\\s+", "")
                ));
            }
        }

        return resources;
    }

    /***
     *
     * @return ForumThread Object for the latest news posting on Minemen.
     */
    public static ForumThread getLatestNewsPost(){
        ForumThread forumThread = null;
        List<String> source = Web.getWebSourceCode("/forums/2/");
        for (int f =700; f < source.size(); f++){       // f = 700 so that we skip all pinned threads as we do not want to fetch pinned threads.
            String x = source.get(f);
            if (x.contains("structItem-title")){
                forumThread = new ForumThread(
                        source.get(f + 3).replaceAll("\\<.*?>", "").replaceAll("^\\s+", ""),
                        source.get(f + 11).replaceAll("\\<.*?>", "").replaceAll("^\\s+", ""),
                        source.get(f + 12).replaceAll("\\<.*?>", "").replaceAll("^\\s+", ""),
                        source.get(f + 3).split("\"")[1].replaceAll("\\<.*?>", "").replaceAll("^\\s+", "")
                );
                break;
            }
        }
        return forumThread;
    }




}
