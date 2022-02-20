package com.ibm.demo.appconfig.properties;

import org.springframework.stereotype.Component;
import com.ibm.demo.appconfig.service.FeatureFlagService;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Component
@ConfigurationProperties(prefix = "features")
public class PropertiesBackedFeatureFlagService implements FeatureFlagService {
    
    private String exclusiveOffers;
    private String flashSale;
    private String bluetoothEarPhones;

    public void setup() {
        //Do nothing
    }
    public String getExclusiveOffers(String user) {
        return exclusiveOffers;
    }

    public void setExclusiveOffers(String exclusiveOffers) {
        this.exclusiveOffers = exclusiveOffers;
    }

    public String getFlashSale(String user) {
        return flashSale;
    }

    public void setFlashSale(String flashSale) {
        this.flashSale = flashSale;
    }

    public String getBluetoothEarPhones(String user) {
        return bluetoothEarPhones;
    }

    public void setBluetoothEarPhones(String bluetoothEarPhones) {
        this.bluetoothEarPhones = bluetoothEarPhones;
    }
}
