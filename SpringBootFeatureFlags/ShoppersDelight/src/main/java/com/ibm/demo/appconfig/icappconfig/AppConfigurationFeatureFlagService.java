package com.ibm.demo.appconfig.icappconfig;

import com.ibm.cloud.appconfiguration.sdk.AppConfiguration;
import com.ibm.cloud.appconfiguration.sdk.configurations.ConfigurationUpdateListener;
import com.ibm.cloud.appconfiguration.sdk.configurations.models.Feature;

import org.springframework.stereotype.Component;
import com.ibm.demo.appconfig.service.FeatureFlagService;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Primary;
import org.springframework.beans.factory.annotation.Value;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.json.JSONObject;

@Component
@Primary
@ConfigurationProperties()
public class AppConfigurationFeatureFlagService implements FeatureFlagService {
    
    static AppConfiguration appConfiguration = AppConfiguration.getInstance();
    private static final Logger logger = LoggerFactory.getLogger(AppConfigurationFeatureFlagService.class);
    private String appconfigGuid;
    private String appconfigApikey;
    private String appconfigEnv;
    private String appconfigCollection;

    public AppConfigurationFeatureFlagService(@Value("${ibmcloud.appconfig.guid}") String appconfigGuidProp, 
        @Value("${ibmcloud.appconfig.apikey}") String appconfigApikeyProp,
        @Value("${ibmcloud.appconfig.env}") String appconfigEnvProp,
        @Value("${ibmcloud.appconfig.collection}") String appconfigCollectionProp ) {
        this.appconfigGuid = appconfigGuidProp;
        this.appconfigApikey = appconfigApikeyProp;
        this.appconfigEnv = appconfigEnvProp;
        this.appconfigCollection = appconfigCollectionProp;
    }
    
    public void setup() {
        appConfiguration.init(AppConfiguration.REGION_AU_SYD, this.appconfigGuid, this.appconfigApikey);
        appConfiguration.setContext(this.appconfigCollection, this.appconfigEnv);
        logger.debug("appConfiguration is initialized " + appConfiguration);   
        appConfiguration.registerConfigurationUpdateListener(new ConfigurationUpdateListener() {
            @Override
            public void onConfigurationUpdate() {
                logger.debug("Received updates from app configuration");
            }
        });
        appConfiguration.enableDebug(false);
    }

    public String getExclusiveOffers(final String user) {
        Feature exclusiveOffers = appConfiguration.getFeature("exclusive-offers-section");
        return createEntity(user, exclusiveOffers);
    }

    public String getFlashSale(final String user) {
        Feature flashSale = appConfiguration.getFeature("flashsale-banner");
        return createEntity(user, flashSale);
    }

    public String getBluetoothEarPhones(String user) {
        Feature bluetoothEarPhones = appConfiguration.getFeature("bluetooth-earphones");
        return createEntity(user, bluetoothEarPhones);
    }

    private String createEntity(final String user, final Feature feature) {
        JSONObject entityAttributes = new JSONObject();
        if(user != null & !user.isEmpty()) {
            entityAttributes.put("email", user);
            return String.valueOf(feature.getCurrentValue(user, entityAttributes));
        }
        return String.valueOf(feature.getCurrentValue("noAuthUser", null));
    }
}
