package tech.akhtar.minemen;

import tech.akhtar.minemen.objects.WikiArticle;
import tech.akhtar.minemen.objects.WikiCategory;

import java.util.List;

public class t1 {

    public static void main(String[] args){
        List s = MinemenLibrary.getWikiCategories();
        for (Object e : s){
            WikiCategory wikiCategory = (WikiCategory) e;
            System.out.println(wikiCategory.getCategoryName() + "  " + wikiCategory.getCategoryUrlFull());
            List<WikiArticle> ss = MinemenLibrary.getWikiArticlesFromCategory(wikiCategory);
            for (WikiArticle a : ss){
                System.out.println(a.getArticleName() + "   "  + a.getArticleUrlFull());
            }
        }
    }

}
