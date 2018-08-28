package com.springboot.elasticsearch.entity.organization;

public class UnderLineDotElastic {
    private String underLineDotId;

    private String name;

    private String organizationId;

    private String belongOrganizationId;

    public String getUnderLineDotId() {
        return underLineDotId;
    }

    public void setUnderLineDotId(String underLineDotId) {
        this.underLineDotId = underLineDotId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public String getBelongOrganizationId() {
        return belongOrganizationId;
    }

    public void setBelongOrganizationId(String belongOrganizationId) {
        this.belongOrganizationId = belongOrganizationId;
    }
}
