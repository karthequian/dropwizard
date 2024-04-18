package io.dropwizard.configuration;

import io.github.pixee.security.HostValidator;
import io.github.pixee.security.Urls;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * An implementation of {@link ConfigurationSourceProvider} that reads the configuration from a
 * {@link URL}.
 */
public class UrlConfigurationSourceProvider implements ConfigurationSourceProvider {
    @Override
    public InputStream open(String path) throws IOException {
        return Urls.create(path, Urls.HTTP_PROTOCOLS, HostValidator.DENY_COMMON_INFRASTRUCTURE_TARGETS).openStream();
    }
}
