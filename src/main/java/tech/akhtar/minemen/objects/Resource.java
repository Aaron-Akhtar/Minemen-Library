package tech.akhtar.minemen.objects;

import tech.akhtar.minemen.MinemenLibrary;
import tech.akhtar.minemen.Web;

import java.util.Date;

public class Resource {

    private String resourceName;
    private String resourceDescription;
    private String resourceVersion;
    private String resourceUrl;

    public Resource(String resourceName, String resourceDescription, String resourceVersion, String resourceUrl) {
        this.resourceName = resourceName;
        this.resourceDescription = resourceDescription;
        this.resourceVersion = resourceVersion;
        this.resourceUrl = resourceUrl;
    }

    public String getResourceName() {
        return resourceName;
    }

    public String getResourceDescription() {
        return resourceDescription;
    }

    public String getResourceVersion() {
        return resourceVersion;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public String getResourceUrlFull() {
        return Web.MINEMEN_URL + resourceUrl;
    }

}
