package com.example.endtoendTest.confogurations;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CustomProperties {
    private String proFilename;
    Properties properties;

    public String getCustomProperty(String propertyName) {

        return properties.getProperty(propertyName);
    }

    public CustomProperties(String proFilename) throws IOException {
        this.proFilename = proFilename;
        properties = new Properties();
        InputStream i = CustomProperties.class.getClassLoader().getResourceAsStream(proFilename);
        properties.load(i);
    }

    public void setProFilename(String proFilename) {
        this.proFilename = proFilename;
    }
}
