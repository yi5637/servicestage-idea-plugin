package com.huawei.cloud.servicestage.intellij.setting;

import com.huawei.cloud.servicestage.intellij.RequestManager;
import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.util.xmlb.XmlSerializerUtil;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * ServiceStage setting persistent
 */
@State(name = "ServiceStageSetting", storages = {@Storage("ServiceStageSetting.xml")})
public class SettingState implements PersistentStateComponent<SettingState> {

    private String region;
    private String regionText;
    private String domain;
    private String domainReal;
    private String username;
    private String password;
    private String tokenContent;
    
    public SettingState() {
    }

    public static SettingState getInstance() {
        return ServiceManager.getService(SettingState.class);
    }

    public void updateValue(String regionText, String domain, String username, String password) {
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

    @Nullable
    @Override
    public SettingState getState() {
        return this;
    }

    @Override
    public void loadState(@NotNull SettingState settingState) {
        XmlSerializerUtil.copyBean(settingState, this);
    }

    @Override
    public void noStateLoaded() {
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
        return "SettingState{" +
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
