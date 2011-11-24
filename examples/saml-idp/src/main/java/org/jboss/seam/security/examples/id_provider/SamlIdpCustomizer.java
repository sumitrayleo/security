package org.jboss.seam.security.examples.id_provider;

import javax.enterprise.event.Observes;
import javax.servlet.ServletContext;

import org.jboss.seam.security.external.saml.api.SamlIdentityProviderConfigurationApi;
import org.jboss.solder.servlet.event.Initialized;

public class SamlIdpCustomizer {
    public void servletInitialized(@Observes @Initialized final ServletContext context, SamlIdentityProviderConfigurationApi idp) {
        idp.setEntityId("http://www.saml-idp.com");
        idp.setHostName("www.saml-idp.com");
        idp.setProtocol("http");
        idp.setPort(8080);
        idp.setSigningKey("classpath:/test_keystore.jks", "store456", "servercert", "pass456");
        idp.setWantSingleLogoutMessagesSigned(false);
    }
}
