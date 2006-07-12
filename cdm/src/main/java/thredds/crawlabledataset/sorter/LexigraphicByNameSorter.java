// $Id$
package thredds.crawlabledataset.sorter;

import thredds.crawlabledataset.CrawlableDatasetSorter;
import thredds.crawlabledataset.CrawlableDataset;

import java.util.List;
import java.util.Collections;
import java.util.Comparator;

/**
 * Sort CrawlableDataset lists lexigraphically on the dataset name.
 *
 * @author edavis
 * @since Nov 18, 2005 4:26:38 PM
 */
public class LexigraphicByNameSorter implements CrawlableDatasetSorter
{
//  private static org.apache.commons.logging.Log log =
//          org.apache.commons.logging.LogFactory.getLog( LexigraphicByNameSorter.class );

  private boolean increasingOrder = false;
  private Comparator comparator;

  public LexigraphicByNameSorter( boolean increasingOrder )
  {
    this.increasingOrder = increasingOrder;
    this.comparator = new java.util.Comparator()
    {
      public int compare( Object obj1, Object obj2 )
      {
        CrawlableDataset ds1 = (CrawlableDataset) obj1;
        CrawlableDataset ds2 = (CrawlableDataset) obj2;

        int compareVal = ds1.getName().compareTo( ds2.getName() );

        return ( LexigraphicByNameSorter.this.increasingOrder ? compareVal : -compareVal );
      }
    };
  }

  public Object getConfigObject() { return null; }
  
  public boolean isIncreasing() { return increasingOrder; }

  public void sort( List datasetList )
  {
    Collections.sort( datasetList, this.comparator );
  }
}
