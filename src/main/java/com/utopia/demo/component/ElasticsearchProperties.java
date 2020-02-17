package com.utopia.demo.component;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "elasticsearch")
public class ElasticsearchProperties {

    private String hostAndPort;

    @Override
    public String toString() {
        return "ElasticsearchProperties{" +
                "hostAndPort='" + hostAndPort + '\'' +
                '}';
    }

    public String getHostAndPort() {
        return hostAndPort;
    }

    public void setHostAndPort(String hostAndPort) {
        this.hostAndPort = hostAndPort;
    }
}
