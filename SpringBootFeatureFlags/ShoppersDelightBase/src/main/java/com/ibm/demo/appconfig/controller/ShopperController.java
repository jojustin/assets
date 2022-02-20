package com.ibm.demo.appconfig.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;    
import com.ibm.demo.appconfig.service.FeatureFlagService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.security.Principal;

@Controller
@RequestMapping("/")
public class ShopperController {
    
    private static final Logger logger = LoggerFactory.getLogger(ShopperController.class);
    private final FeatureFlagService featureFlagService;

    ShopperController(FeatureFlagService featureFlagService) {
        this.featureFlagService = featureFlagService;
        this.featureFlagService.setup();
    }

    @GetMapping(path = {"/"})
    public String viewShop(ModelMap model, Principal principal) {
        String user= "";
        logger.debug("Shopping Home page. Principal is " + principal);
        if (principal != null) {
            user = principal.getName();
        }
        model.addAttribute("bluetoothEarphones", featureFlagService.getBluetoothEarPhones(user));
        model.addAttribute("exclusiveOffers", featureFlagService.getExclusiveOffers(user));
        model.addAttribute("flashSale", featureFlagService.getFlashSale(user));
        model.addAttribute("indexPage", true);
        return "index";
    }

    @RequestMapping(value="/login", method=RequestMethod.GET)    
    public String login() {        
        return "login";    
    }
}
