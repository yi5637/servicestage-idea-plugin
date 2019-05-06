package com.huawei.cloud.servicestage.intellij.model;

import com.huawei.cloud.servicestage.intellij.RequestManager;
import org.apache.commons.lang3.StringUtils;

public class SettingModel {

    private String region;

    private String regionText;

    private String domain;

    private String domainReal;

    private String username;

    private String password;

    private String tokenContent;

    public SettingModel() {
    }

    public SettingModel(String regionText, String domain, String username, String password) {
        this.regionText = regionText;
        this.region = RequestManager.getInstance().getRegions().get(regionText);
        this.domain = domain;
        this.domainReal = StringUtils.isEmpty(domain) ? username : domain;
        this.username = username;
        this.password = password;
    }

    public boolean isModified(String regionText, String domain, String username, String password) {
        return !(StringUtils.equals(this.regionText, regionText) && StringUtils.equals(this.domain, domain)
                && StringUtils.equals(this.username, username) && StringUtils.equals(this.password, password));
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getRegionText() {
        return regionText;
    }

    public void setRegionText(String regionText) {
        this.regionText = regionText;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getDomainReal() {
        return domainReal;
    }

    public void setDomainReal(String domainReal) {
        this.domainReal = domainReal;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTokenContent() {
        return tokenContent;
    }

    public void setTokenContent(String tokenContent) {
        this.tokenContent = tokenContent;
    }

    @Override
    public String toString() {
        return "SettingModel{" +
                "region='" + region + '\'' +
                ", regionText='" + regionText + '\'' +
                ", domain='" + domain + '\'' +
                ", domainReal='" + domainReal + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", tokenContent='" + tokenContent + '\'' +
                '}';
    }
}
