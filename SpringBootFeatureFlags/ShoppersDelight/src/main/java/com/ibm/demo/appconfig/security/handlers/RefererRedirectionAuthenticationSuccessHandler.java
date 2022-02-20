package com.ibm.demo.appconfig.security.handlers;

import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

public class RefererRedirectionAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

  public RefererRedirectionAuthenticationSuccessHandler() {
      super();
      setUseReferer(true);
  }
}
