package com.goeuro.util;

import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * An utility for reading the application property file.
 * 
 * @author doancea
 * 
 */
public class PropertiesLoader {

  private static final Logger LOG = LoggerFactory.getLogger(PropertiesLoader.class);
  private static Properties prop;

  static {
    prop = new Properties();
    try {
      prop.load(ClassLoader.getSystemResourceAsStream("application.properties"));
    } catch (IOException e) {
      LOG.error("An error occured while loading application properties!");
      e.printStackTrace();
    }
  }

  public static String getURL() {
    StringBuilder sb = new StringBuilder();
    String url = prop.getProperty("url");
    sb.append(url);
    if (url.endsWith("/")) {
      return sb.toString();
    } else {
      return sb.append("/").toString();
    }
  }

}
