// $Id$

/*
 * Copyright 1997-2006 Unidata Program Center/University Corporation for
 * Atmospheric Research, P.O. Box 3000, Boulder, CO 80307,
 * support@unidata.ucar.edu.
 *
 * This library is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation; either version 2.1 of the License, or (at
 * your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser
 * General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this library; if not, write to the Free Software Foundation,
 * Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
 */
package thredds.cataloggen.config;

import thredds.catalog.InvDataset;
import thredds.catalog.InvCatalog;

import java.util.List;

public class GrADSDataServerDatasetSource extends DatasetSource
{
  static private org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(GrADSDataServerDatasetSource.class);

  public GrADSDataServerDatasetSource()
  {
    this.type = DatasetSourceType.getType( "GrADSDataServer");
  }

  // @todo Implement the GrADSDataServer type of DatasetSource.

  protected InvDataset createDataset( String datasetLocation, String prefixUrlPath )
  {
    throw( new UnsupportedOperationException( "GrADSDataServerDatasetSource class not implemented."));
  }

  protected InvCatalog createSkeletonCatalog( String prefixUrlPath )
  {
    throw( new UnsupportedOperationException( "GrADSDataServerDatasetSource class not implemented."));
  }

  protected boolean isCollection( InvDataset dataset )
  {
    throw( new UnsupportedOperationException( "GrADSDataServerDatasetSource class not implemented."));
  }

  protected List expandThisLevel( InvDataset collectionDataset, String prefixUrlPath )
  {
    throw( new UnsupportedOperationException( "GrADSDataServerDatasetSource class not implemented."));
  }
}
