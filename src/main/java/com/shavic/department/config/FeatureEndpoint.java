package com.shavic.department.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Endpoint(id = "features")
public class FeatureEndpoint {

    private final Map<String, Feature> featureMap = new ConcurrentHashMap<>();


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class Feature {
        // create the different properties for the Entity class
        private boolean isEnabled;

    }

}
