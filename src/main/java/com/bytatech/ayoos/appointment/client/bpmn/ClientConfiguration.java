package com.bytatech.ayoos.appointment.client.bpmn;

import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.cloud.security.oauth2.client.feign.OAuth2FeignRequestInterceptor;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.resource.BaseOAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;
import org.springframework.security.oauth2.client.token.grant.implicit.ImplicitResourceDetails;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;

import com.bytatech.ayoos.appointment.client.ExcludeFromComponentScan;

@Configuration
@ExcludeFromComponentScan
@EnableConfigurationProperties
public class ClientConfiguration {

  @Value("${bpm.security.basicAuth.username:}")
  private String basicAuthUsername;

  @Value("${bpm.security.basicAuth.password:}")
  private String basicAuthPassword;

  @Bean
  @ConditionalOnProperty(name = "bpm.security.basicAuth.username")
  public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
    return new BasicAuthRequestInterceptor(this.basicAuthUsername, this.basicAuthPassword);
  }

}
