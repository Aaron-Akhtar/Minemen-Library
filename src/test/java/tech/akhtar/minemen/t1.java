package tech.akhtar.minemen;

import tech.akhtar.minemen.objects.Resource;
import tech.akhtar.minemen.objects.WikiArticle;
import tech.akhtar.minemen.objects.WikiCategory;

import java.util.List;

public class t1 {

    public static void main(String[] args){
        List<Resource> resources = MinemenLibrary.getTopFiveRatedResources();
        for (Resource resource : resources){
            System.out.println(resource.getResourceDescription());
            System.out.println(resource.getResourceName());
            System.out.println(resource.getResourceUrl());
            System.out.println(resource.getResourceUrlFull());
            System.out.println(resource.getResourceVersion());
        }
    }

}
