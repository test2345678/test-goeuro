package com.goeuro.client.entity;

import com.google.gson.annotations.Expose;

public class GeoPosition {

  @Expose
  private Double latitude;
  @Expose
  private Double longitude;

  /**
   * @return the latitude
   */
  public Double getLatitude() {
    return latitude;
  }

  /**
   * @param latitude the latitude to set
   */
  public void setLatitude(final Double latitude) {
    this.latitude = latitude;
  }

  /**
   * @return the longitude
   */
  public Double getLongitude() {
    return longitude;
  }

  /**
   * @param longitude the longitude to set
   */
  public void setLongitude(final Double longitude) {
    this.longitude = longitude;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("GeoPosition [latitude=");
    sb.append(latitude).append(", longitude=");
    sb.append(longitude).append("]");
    return sb.toString();
  }

}
