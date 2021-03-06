/*
 * Copyright (c) 1998-2018 John Caron and University Corporation for Atmospheric Research/Unidata
 * See LICENSE for license information.
 */

package ucar.nc2.grib;

import javax.annotation.concurrent.Immutable;

/**
* Encapsulate the semantics in GRIB level types  (Grib1 table 3, Grib2 code table 4.5).
* These may be dependent on the center, so must be generated by a GribCustomizer.
 *
* @author caron
* @since 1/16/12
*/
@Immutable
public class GribLevelType implements VertCoord.VertUnit {

  private final int code;
  private final String desc;
  private final String abbrev;
  private final String units;
  private final String datum;
  private final boolean isPositiveUp;
  private final boolean isLayer;

  // LOOK for Grib2Utils - CHANGE THIS
  public GribLevelType(int code, String units, String datum, boolean isPositiveUp) {
    this.code = code;
    this.desc = null;
    this.abbrev = null;
    this.units = units;
    this.datum = datum;
    this.isPositiveUp = isPositiveUp;
    this.isLayer = false;
  }

  public GribLevelType(int code, String desc, String abbrev, String units, String datum, boolean isPositiveUp, boolean isLayer) {
    this.code = code;
    this.desc = desc;
    this.abbrev = abbrev;
    this.units = units;
    this.datum = datum;
    this.isPositiveUp = isPositiveUp;
    this.isLayer = isLayer;
  }

  public int getCode() {
    return code;
  }

  public String getDesc() {
    return desc;
  }

  public String getAbbrev() {
    return abbrev;
  }

  public String getUnits() {
    return units;
  }

  public String getDatum() {
    return datum;
  }

  public boolean isPositiveUp() {
    return isPositiveUp;
  }

  @Override
  public boolean isVerticalCoordinate() {
    return getUnits() != null;
  }

  public boolean isLayer() {
    return isLayer;
  }
}
