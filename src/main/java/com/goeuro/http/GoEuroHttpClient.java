/**
 * 
 */
package com.goeuro.http;

import static java.lang.String.format;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.goeuro.client.entity.Position;
import com.goeuro.exception.http.HttpResponseException;
import com.goeuro.util.PropertiesLoader;
import com.google.gson.Gson;

/**
 * @author doancea
 * 
 */
public class GoEuroHttpClient {

  private static final Logger LOG = LoggerFactory.getLogger(GoEuroHttpClient.class);

  public GoEuroHttpClient() {}

  public Position[] get(final String location) throws HttpResponseException {
    if (StringUtils.isEmpty(location) || StringUtils.isBlank(location)) {
      throw new IllegalArgumentException("The location is empty or blank!");
    }
    String cleanLocation = location.trim();
    if (!StringUtils.isAlpha(cleanLocation)) {
      throw new IllegalArgumentException("The location doesn't have alpha characters!");
    }
    final HttpClient client = new HttpClient();
    final String url = buildURL(cleanLocation);
    final HttpMethod method = new GetMethod(url);
    try {
      int status = client.executeMethod(method);
      if (status != HttpStatus.SC_OK) {
        final String msg = "An error occoured while executing GET to RESTfull API: %s";
        throw new HttpResponseException(format(msg, url), status);
      }
      final String response = method.getResponseBodyAsString();
      Position[] data = convert(response);
      return data;
    } catch (HttpException e) {
      LOG.error("HttpException: {}", e.getMessage());
      throw new HttpResponseException(e.getMessage());
    } catch (IOException e) {
      LOG.error("An IO exception was thrown with message: {}", e.getMessage());
      throw new HttpResponseException(e.getMessage());
    } finally {
      method.releaseConnection();
    }
  }

  private Position[] convert(final String response) {
    final Gson gson = new Gson();
    return gson.fromJson(response, Position[].class);
  }

  private String buildURL(final String location) {
    StringBuilder sb = new StringBuilder(PropertiesLoader.getURL());
    sb.append(location);
    return sb.toString();
  }
}
