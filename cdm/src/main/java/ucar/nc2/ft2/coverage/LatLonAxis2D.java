/*
 * Copyright 1998-2015 John Caron and University Corporation for Atmospheric Research/Unidata
 *
 *  Portions of this software were developed by the Unidata Program at the
 *  University Corporation for Atmospheric Research.
 *
 *  Access and use of this software shall impose the following obligations
 *  and understandings on the user. The user is granted the right, without
 *  any fee or cost, to use, copy, modify, alter, enhance and distribute
 *  this software, and any derivative works thereof, and its supporting
 *  documentation for any purpose whatsoever, provided that this entire
 *  notice appears in all copies of the software, derivative works and
 *  supporting documentation.  Further, UCAR requests that the user credit
 *  UCAR/Unidata in any publications that result from the use of this
 *  software or in any product that includes this software. The names UCAR
 *  and/or Unidata, however, may not be used in any advertising or publicity
 *  to endorse or promote any products or commercial entity unless specific
 *  written permission is obtained from UCAR/Unidata. The user also
 *  understands that UCAR/Unidata is not obligated to provide the user with
 *  any support, consulting, training or assistance of any kind with regard
 *  to the use, operation and performance of this software nor to provide
 *  the user with any updates, revisions, new versions or "bug fixes."
 *
 *  THIS SOFTWARE IS PROVIDED BY UCAR/UNIDATA "AS IS" AND ANY EXPRESS OR
 *  IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 *  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 *  DISCLAIMED. IN NO EVENT SHALL UCAR/UNIDATA BE LIABLE FOR ANY SPECIAL,
 *  INDIRECT OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES WHATSOEVER RESULTING
 *  FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN ACTION OF CONTRACT,
 *  NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF OR IN CONNECTION
 *  WITH THE ACCESS, USE OR PERFORMANCE OF THIS SOFTWARE.
 */
package ucar.nc2.ft2.coverage;

import ucar.ma2.Array;
import ucar.ma2.DataType;
import ucar.nc2.util.Indent;
import ucar.nc2.util.Misc;

import java.io.IOException;
import java.util.Formatter;

/**
 * LatLon axes : lat(y,x), lon(y,x)
 *
 * @author caron
 * @since 7/15/2015
 */
public class LatLonAxis2D extends CoverageCoordAxis {

  // can only be set once, needed for subsetting
  private int[] shape;
  private CoverageCoordAxis[] dependentAxes;

  public LatLonAxis2D( CoverageCoordAxisBuilder builder) {
    super( builder);
  }

  @Override
  protected void setDataset(CoordSysContainer dataset) {
    dependentAxes = new CoverageCoordAxis[2];
    int[] shape = new int[2];
    int count = 0;
    for (String axisName : dependsOn) {
      CoverageCoordAxis axis = dataset.findCoordAxis(axisName);
      shape[count] = axis.getNcoords();
      dependentAxes[count++] = axis;
    }

    if (this.shape != null)
      throw new RuntimeException("Cant change axis shape once set");

    this.shape = shape;
  }

  @Override
  public int[] getShape() {
    return shape;
  }

  @Override
  public void toString(Formatter f, Indent indent) {
    super.toString(f, indent);
    f.format("%s  shape=[%s]%n", indent, Misc.showInts(shape));
  }

  @Override
  public LatLonAxis2D subset(SubsetParams params) {  // LOOK not implemented
    return new LatLonAxis2D( new CoverageCoordAxisBuilder(this));
  }

  @Override
  public LatLonAxis2D subset(double minValue, double maxValue) {
    return this; // LOOK
  }

  @Override
  public LatLonAxis2D subsetDependent(CoverageCoordAxis1D from) {
    return null; // LOOK
  }

  @Override
  public Array getCoordsAsArray() throws IOException {
    double[] values = getValues();
    return Array.factory(DataType.DOUBLE, shape, values);
  }

  @Override
  public Array getCoordBoundsAsArray() {
    return null;   // LOOK
  }
}