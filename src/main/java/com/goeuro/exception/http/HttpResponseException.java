package com.goeuro.exception.http;

import org.apache.commons.httpclient.HttpException;

/**
 * Exception class for Http responses
 */
public class HttpResponseException extends HttpException {
  private static final long serialVersionUID = 112341241L;
  private int statusCode = 200;

  public HttpResponseException(String message, int statusCode) {
    super(message);
    this.statusCode = statusCode;
  }

  public HttpResponseException() {
    super();
  }

  public HttpResponseException(String message, Throwable cause) {
    super(message, cause);
  }

  public HttpResponseException(String message) {
    super(message);
  }

  /**
   * @return Returns the statusCode.
   */
  public int getStatusCode() {
    return statusCode;
  }

  /**
   * @param statusCode The statusCode to set.
   */
  public void setStatusCode(int statusCode) {
    this.statusCode = statusCode;
  }

}
