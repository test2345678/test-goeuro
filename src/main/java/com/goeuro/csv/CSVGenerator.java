/**
 * 
 */
package com.goeuro.csv;

import static java.lang.String.format;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.goeuro.client.entity.GeoPosition;
import com.goeuro.client.entity.Position;
import com.goeuro.exception.CSVGeneratorException;

/**
 * @author doancea
 * 
 */
public class CSVGenerator {

  private final static Logger LOG = LoggerFactory.getLogger(CSVGenerator.class);
  private final static String FILE_NAME = "test.csv";

  public static void generate(final Position[] response) throws CSVGeneratorException {
    if (response == null || response.length == 0) {
      LOG.warn("No positions were retrieved! Abort generating the CSV file");
      return;
    }
    try {

      OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(FILE_NAME), "UTF-8");

      writer.append("_id");
      writer.append(",");
      writer.append("name");
      writer.append(",");
      writer.append("type");
      writer.append(",");
      writer.append("latitude");
      writer.append(",");
      writer.append("longitude");
      writer.append("\n");


      for (int i = 0; i < response.length; i++) {
        Position position = response[i];
        writer.append(Integer.toString(position.getId()));
        writer.append(",");
        writer.append(position.getName());
        writer.append(",");
        writer.append(position.getType());
        writer.append(",");
        GeoPosition geoPosition = position.getGeoPosition();
        writer.append(Double.toString(geoPosition.getLatitude()));
        writer.append(",");
        writer.append(Double.toString(geoPosition.getLongitude()));
        writer.append("\n");
      }

      writer.flush();
      writer.close();

    } catch (IOException e) {
      LOG.error("An IO exception has been thrown with message: {}", e.getMessage());
      throw new CSVGeneratorException(format("An IO exception has been thrown with message: %s",
          e.getMessage()));
    }
  }
}
