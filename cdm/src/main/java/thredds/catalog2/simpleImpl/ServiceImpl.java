package thredds.catalog2.simpleImpl;

import thredds.catalog.ServiceType;
import thredds.catalog2.Property;
import thredds.catalog2.Service;
import thredds.catalog2.builder.ServiceBuilder;

import java.net.URI;
import java.util.*;

/**
 * _more_
 *
 * @author edavis
 * @since 4.0
 */
public class ServiceImpl implements ServiceBuilder
{
  private String name;
  private String description;
  private ServiceType type;
  private URI baseUri;
  private String suffix;
  private List<Property> properties;
  private Map<String,Property> propertiesMap;
  private List<Service> services;
  private Map<String,Service> servicesMap;

  public ServiceImpl( String name, ServiceType type, URI baseUri )
  {
    if ( name == null ) throw new IllegalArgumentException( "Name must not be null.");
    if ( type == null ) throw new IllegalArgumentException( "Service type must not be null.");
    if ( baseUri == null ) throw new IllegalArgumentException( "Base URI must not be null.");
    this.name = name;
    this.description = "";
    this.type = type;
    this.baseUri = baseUri;
    this.suffix = "";
    this.properties = new ArrayList<Property>();
    this.propertiesMap = new HashMap<String,Property>();
    this.services = new ArrayList<Service>();
    this.servicesMap = new HashMap<String,Service>();
  }

  @Override
  public void setName( String name )
  {
    if ( name == null ) throw new IllegalArgumentException( "Name must not be null." );
    this.name = name;
  }

  @Override
  public void setDescription( String description )
  {
    this.description = description != null ? description : "";
  }

  @Override
  public void setType( ServiceType type )
  {
    if ( type == null ) throw new IllegalArgumentException( "Service type must not be null." );
    this.type = type;
  }

  @Override
  public void setBaseUri( URI baseUri )
  {
    if ( baseUri == null ) throw new IllegalArgumentException( "Base URI must not be null." );
    this.baseUri = baseUri;
  }

  @Override
  public void setSuffix( String suffix )
  {
    this.suffix = suffix != null ? suffix : "";
  }

  @Override
  public void addProperty( String name, String value )
  {
    PropertyImpl property = new PropertyImpl( name, value );
    this.properties.add( property );
    this.propertiesMap.put( name, property );
  }

  @Override
  public ServiceBuilder addService( String name, ServiceType type, URI baseUri )
  {
    ServiceBuilder sb = new ServiceImpl( name, type, baseUri );
    this.services.add( sb );
    this.servicesMap.put( name, sb );
    return sb;
  }

  @Override
  public ServiceBuilder addService( String name, ServiceType type, URI baseUri, int index )
  {
    ServiceBuilder sb = new ServiceImpl( name, type, baseUri );
    this.services.add( index, sb );
    this.servicesMap.put( name, sb );
    return sb;
  }

  @Override
  public String getName()
  {
    return this.name;
  }

  @Override
  public String getDescription()
  {
    return this.description;
  }

  @Override
  public ServiceType getType()
  {
    return this.type;
  }

  @Override
  public URI getBaseUri()
  {
    return this.baseUri;
  }

  @Override
  public String getSuffix()
  {
    return this.suffix;
  }

  @Override
  public List<Property> getProperties()
  {
    return Collections.unmodifiableList( this.properties);
  }

  @Override
  public Property getProperty( String name )
  {
    return this.propertiesMap.get( name );
  }

  @Override
  public List<Service> getServices()
  {
    return Collections.unmodifiableList( this.services );
  }

  @Override
  public Service getService( String name )
  {
    return this.servicesMap.get( name );
  }

  @Override
  public void finish()
  {
  }
}
