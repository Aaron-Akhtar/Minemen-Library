# Minemen-Library
A library for the minemen forums (https://minemen.com), this library utilises Web Scraping.

# <-- PLEASE READ
As this library fetches information utilizing web scraping there may be issues that occur in the future, this can occur if a file is renamed or a CSS Style is renamed, at the point of a issue like this occuring please make a issue request or contact me via email:
 - contact@aaronakhtar.me
# PLEASE READ -->

Example one:
```java
List<Resource> resources = MinemenLibrary.getTopFiveRatedResources();
for (Resource resource : resources){
    System.out.println(resource.getResourceDescription());
    System.out.println(resource.getResourceName());
    System.out.println(resource.getResourceUrl());
    System.out.println(resource.getResourceUrlFull());
    System.out.println(resource.getResourceVersion());
}
```

Example two:
```java
List s = MinemenLibrary.getWikiCategories();
for (Object e : s){
    WikiCategory wikiCategory = (WikiCategory) e;
    System.out.println(wikiCategory.getCategoryName() + "  " + wikiCategory.getCategoryUrlFull());
    List<WikiArticle> ss = MinemenLibrary.getWikiArticlesFromCategory(wikiCategory);
    for (WikiArticle a : ss){
        System.out.println(a.getArticleName() + "   "  + a.getArticleUrlFull());
    }
}
```

Example three:
```java
ForumThread forumThread = MinemenLibrary.getLatestNewsPost();
System.out.println(forumThread.getThreadTitle() + "  " + forumThread.getDatePosted() + "  " + forumThread.getThreadCreator() + "  " + forumThread.getThreadUrlFull());
```

A Akhtar Technologies Production.
