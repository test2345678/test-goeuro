/**
 * 
 */
package com.goeuro.client.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * @author doancea
 * 
 */
public class Position {

  @SerializedName("_type")
  @Expose
  private String typeName;

  @SerializedName("_id")
  @Expose
  private Integer id;
  @Expose
  private Object key;
  @Expose
  private String name;
  @Expose
  private String fullName;
  @SerializedName("iata_airport_code")
  @Expose
  private Object iataAirportCode;
  @Expose
  private String type;
  @Expose
  private String country;
  @SerializedName("geo_position")
  @Expose
  private GeoPosition geoPosition;
  @Expose
  private Integer locationId;
  @Expose
  private Boolean inEurope;
  @Expose
  private String countryCode;
  @Expose
  private Boolean coreCountry;
  @Expose
  private Object distance;

  /**
   * @return the typeName
   */
  public String getTypeName() {
    return typeName;
  }

  /**
   * @return the id
   */
  public Integer getId() {
    return id;
  }

  /**
   * @return the key
   */
  public Object getKey() {
    return key;
  }

  /**
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @return the fullName
   */
  public String getFullName() {
    return fullName;
  }

  /**
   * @return the iataAirportCode
   */
  public Object getIataAirportCode() {
    return iataAirportCode;
  }

  /**
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * @return the country
   */
  public String getCountry() {
    return country;
  }

  /**
   * @return the geoPosition
   */
  public GeoPosition getGeoPosition() {
    return geoPosition;
  }

  /**
   * @return the locationId
   */
  public Integer getLocationId() {
    return locationId;
  }

  /**
   * @return the inEurope
   */
  public Boolean getInEurope() {
    return inEurope;
  }

  /**
   * @return the countryCode
   */
  public String getCountryCode() {
    return countryCode;
  }

  /**
   * @return the coreCountry
   */
  public Boolean getCoreCountry() {
    return coreCountry;
  }

  /**
   * @return the distance
   */
  public Object getDistance() {
    return distance;
  }

}
