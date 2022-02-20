package com.ibm.demo.appconfig.service;

public interface FeatureFlagService {
    
    void setup();
    /**
     * A  boolean feature flag that returns either true or false for all users.
     */
    String getExclusiveOffers(String user);

    /**
     * A boolean feature flag that is targeted at a cohort of users.
     */
    String getFlashSale(String user);

    /**
     * A boolean feature flag that is targeted at a cohort of users.
     */
    String getBluetoothEarPhones(String user);
}
