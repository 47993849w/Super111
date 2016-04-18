
package com.example.tomecabello.myapplication.JSON;


public class Move {


    private String learnType;

    private String name;

    private String resourceUri;

    private Integer level;

    /**
     * 
     * @return
     *     The learnType
     */
    public String getLearnType() {
        return learnType;
    }

    /**
     * 
     * @param learnType
     *     The learn_type
     */
    public void setLearnType(String learnType) {
        this.learnType = learnType;
    }

    /**
     * 
     * @return
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return
     *     The resourceUri
     */
    public String getResourceUri() {
        return resourceUri;
    }

    /**
     * 
     * @param resourceUri
     *     The resource_uri
     */
    public void setResourceUri(String resourceUri) {
        this.resourceUri = resourceUri;
    }

    /**
     * 
     * @return
     *     The level
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * 
     * @param level
     *     The level
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

}
