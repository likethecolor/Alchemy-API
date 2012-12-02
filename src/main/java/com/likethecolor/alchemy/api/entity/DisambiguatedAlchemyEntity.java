/**
 * File: DisambiguatedAlchemyEntity.java
 * Original Author: Dan Brown <dan@likethecolor.com>
 * Copyright 2012 Dan Brown <Dan Brown <dan@likethecolor.com>>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.likethecolor.alchemy.api.entity;

import com.likethecolor.alchemy.api.Constants;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * disambiguation information for the detected subject/object entity (used only
 * when disambiguation occurred)
 * Example usage {@link <a href="http://www.alchemyapi.com/api/relation/urls.html">http://www.alchemyapi.com/api/relation/urls.html</a>}
 */
public class DisambiguatedAlchemyEntity extends AbstractAlchemyEntity {
  private String census;
  private String ciaFactbook;
  private String crunchbase;
  private String dbpedia;
  private String freebase;
  private String geo;
  private String geonames;
  private double latitude = Constants.DEFAULT_LATITUDE;
  private double longitude = Constants.DEFAULT_LATITUDE;
  private String musicBrainz;
  private String name;
  private String opencyc;
  private String semanticCrunchbase;
  private List<String> subtypes;
  private String umbel;
  private String website;
  private String yago;

  public DisambiguatedAlchemyEntity() {
    super(null);
    subtypes = new ArrayList<String>();
  }

  /**
   * Set the fields of this object using the values from the
   * {@link DisambiguatedAlchemyEntity} passed in.
   *
   * @param disambiguatedAlchemyEntity entity whose values are to be copied to this object
   */
  public void copy(final DisambiguatedAlchemyEntity disambiguatedAlchemyEntity) {
    if(disambiguatedAlchemyEntity != null) {

      Iterator<String> subtypes = disambiguatedAlchemyEntity.subtypeIterator();
      while(subtypes.hasNext()) {
        addSubtype(subtypes.next());
      }

      setName(disambiguatedAlchemyEntity.getName());
      setCensus(disambiguatedAlchemyEntity.getCensus());
      setCIAFactbook(disambiguatedAlchemyEntity.getCIAFactbook());
      setCrunchbase(disambiguatedAlchemyEntity.getCrunchbase());
      setDBPedia(disambiguatedAlchemyEntity.getDBPedia());
      setFreebase(disambiguatedAlchemyEntity.getFreebase());
      setGeo(disambiguatedAlchemyEntity.getGeo());
      setGeonames(disambiguatedAlchemyEntity.getGeonames());
      setMusicBrainz(disambiguatedAlchemyEntity.getMusicBrainz());
      setOpencyc(disambiguatedAlchemyEntity.getOpencyc());
      setSemanticCrunchbase(disambiguatedAlchemyEntity.getSemanticCrunchbase());
      setUmbel(disambiguatedAlchemyEntity.getUmbel());
      setWebsite(disambiguatedAlchemyEntity.getWebsite());
      setYago(disambiguatedAlchemyEntity.getYago());
    }
  }

  /**
   * Set link to USA Census.  Note: Provided only for entities that exist in this
   * that exist in this linked data-set.
   *
   * @param census link to USA Census
   */
  public void setCensus(String census) {
    if(census != null) {
      census = census.trim();
    }
    this.census = census;
  }

  /**
   * Return link to USA Census.  Note: Provided only for entities that exist in this
   * that exist in this linked data-set.
   *
   * @return link to USA Census
   */
  public String getCensus() {
    return census;
  }

  /**
   * Set link to CIA World Factbook.  Note: Provided only for entities that exist in this
   * that exist in this linked data-set.
   *
   * @param ciaFactbook link to CIA World Factbook
   */
  public void setCIAFactbook(String ciaFactbook) {
    if(ciaFactbook != null) {
      ciaFactbook = ciaFactbook.trim();
    }
    this.ciaFactbook = ciaFactbook;
  }

  /**
   * Return link to CIA World Factbook.  Note: Provided only for entities that exist in this
   * that exist in this linked data-set.
   *
   * @return link to CIA World Factbook
   */
  public String getCIAFactbook() {
    return ciaFactbook;
  }

  /**
   * Set link to CrunchBase.  Note: Provided only for entities that exist in this
   * that exist in this linked data-set.
   *
   * @param crunchbase link to CrunchBase
   */
  public void setCrunchbase(String crunchbase) {
    if(crunchbase != null) {
      crunchbase = crunchbase.trim();
    }
    this.crunchbase = crunchbase;
  }

  /**
   * Return link to CrunchBase.  Note: Provided only for entities that exist in this
   * that exist in this linked data-set.
   *
   * @return link to CrunchBase
   */
  public String getCrunchbase() {
    return crunchbase;
  }

  /**
   * Set link to DBpedia.  Note: Provided only for entities that exist in this
   * that exist in this linked data-set.
   *
   * @param dbpedia link to DBpedia
   */
  public void setDBPedia(String dbpedia) {
    if(dbpedia != null) {
      dbpedia = dbpedia.trim();
    }
    this.dbpedia = dbpedia;
  }

  /**
   * Return link to DBpedia.  Note: Provided only for entities that exist in this
   * that exist in this linked data-set.
   *
   * @return link to DBpedia
   */
  public String getDBPedia() {
    return dbpedia;
  }

  /**
   * Set link to Freebase.  Note: Provided only for entities that exist in this
   * that exist in this linked data-set.
   *
   * @param freebase link to Freebase
   */
  public void setFreebase(String freebase) {
    if(freebase != null) {
      freebase = freebase.trim();
    }
    this.freebase = freebase;
  }

  /**
   * Return link to Freebase.  Note: Provided only for entities that exist in this
   * that exist in this linked data-set.
   *
   * @return link to Freebase
   */
  public String getFreebase() {
    return freebase;
  }

  /**
   * Set the geographic coordinates associated with this concept tag.
   * <p/>
   * latitude longitude
   *
   * @param geo latitude longitude
   *
   * @see #setLatitude(String)
   * @see #setLongitude(String)
   */
  public void setGeo(String geo) {
    if(geo != null) {
      geo = geo.trim();
    }

    if(StringUtils.isBlank(geo)) {
      this.geo = geo;
      setLatitude(Constants.DEFAULT_LATITUDE);
      setLongitude(Constants.DEFAULT_LONGITUDE);
      return;
    }

    String[] split = geo.split("\\s+");
    if(split != null && split.length == 2) {
      this.geo = split[0].trim() + " " + split[1];
      setLatitude(split[0]);
      setLongitude(split[1]);
    }
  }

  /**
   * Return the geographic coordinates associated with this concept tag.
   * <p/>
   * latitude longitude
   *
   * @return latitude longitude
   */
  public String getGeo() {
    return geo;
  }

  /**
   * Set link to Geonames.  Note: Provided only for entities that exist in this
   * that exist in this linked data-set.
   *
   * @param geonames link to Geonames
   */
  public void setGeonames(String geonames) {
    if(geonames != null) {
      geonames = geonames.trim();
    }
    this.geonames = geonames;
  }

  /**
   * Return link to Geonames.  Note: Provided only for entities that exist in this
   * that exist in this linked data-set.
   *
   * @return link to Geonames
   */
  public String getGeonames() {
    return geonames;
  }

  /**
   * Set the latitude.
   *
   * @param latitude latitude
   */
  public void setLatitude(final double latitude) {
    this.latitude = latitude;
  }

  /**
   * Set the latitude.
   *
   * @param latitude latitude
   *
   * @see #setGeo(String)
   */
  public void setLatitude(final String latitude) {
    if(StringUtils.isBlank(latitude)) {
      return;
    }
    try {
      setLatitude(Double.parseDouble(latitude.trim()));
    }
    catch(Exception e) {
      // nothing is set
    }
  }

  /**
   * Return the latitude.
   *
   * @return latitude
   *
   * @see #setGeo(String)
   */
  public Double getLatitude() {
    return latitude;
  }

  /**
   * Set the latitude.
   *
   * @param longitude longitude
   */
  public void setLongitude(final double longitude) {
    this.longitude = longitude;
  }

  /**
   * Set the longitude.
   *
   * @param longitude longitude
   *
   * @see #setGeo(String)
   */
  public void setLongitude(final String longitude) {
    if(StringUtils.isBlank(longitude)) {
      return;
    }
    try {
      setLongitude(Double.parseDouble(longitude.trim()));
    }
    catch(Exception e) {
      // nothing is set
    }
  }

  /**
   * Return the longitude.
   *
   * @return longitude
   *
   * @see #setGeo(String)
   */
  public Double getLongitude() {
    return longitude;
  }

  /**
   * Set the disambiguated entity name.
   *
   * @param name disambiguated entity name
   */
  public void setName(String name) {
    if(name != null) {
      name = name.trim();
    }
    this.name = name;
  }

  /**
   * Return the disambiguated entity name.
   *
   * @return disambiguated entity name
   */
  public String getName() {
    return name;
  }

  /**
   * Set link to MusicBrainz.  Note: Provided only for entities that exist in this
   * that exist in this linked data-set.
   *
   * @param musicBrainz link to MusicBrainz
   */
  public void setMusicBrainz(String musicBrainz) {
    if(musicBrainz != null) {
      musicBrainz = musicBrainz.trim();
    }
    this.musicBrainz = musicBrainz;
  }

  /**
   * Return link to MusicBrainz.  Note: Provided only for entities that exist in this
   * that exist in this linked data-set.
   *
   * @return link to MusicBrainz
   */
  public String getMusicBrainz() {
    return musicBrainz;
  }

  /**
   * Set link to OpenCyc.  Note: Provided only for entities that exist in this
   * that exist in this linked data-set.
   *
   * @param opencyc link to OpenCyc
   */
  public void setOpencyc(String opencyc) {
    if(opencyc != null) {
      opencyc = opencyc.trim();
    }
    this.opencyc = opencyc;
  }

  /**
   * Return link to OpenCyc.  Note: Provided only for entities that exist in this
   * that exist in this linked data-set.
   *
   * @return link to OpenCyc
   */
  public String getOpencyc() {
    return opencyc;
  }

  /**
   * Set link to Semantic CrunchBase.  Note: Provided only for entities that exist in this
   * that exist in this linked data-set.
   *
   * @param semanticCrunchbase link to Semantic CrunchBase
   */
  public void setSemanticCrunchbase(String semanticCrunchbase) {
    if(semanticCrunchbase != null) {
      semanticCrunchbase = semanticCrunchbase.trim();
    }
    this.semanticCrunchbase = semanticCrunchbase;
  }

  /**
   * Return link to Semantic CrunchBase.  Note: Provided only for entities that exist in this
   * that exist in this linked data-set.
   *
   * @return link to Semantic CrunchBase
   */
  public String getSemanticCrunchbase() {
    return semanticCrunchbase;
  }

  /**
   * Set the disambiguated entity subType.  SubTypes expose additional
   * ontological mappings for a detected entity, such as identification of a
   * Person as a Politician or Athlete.
   *
   * @param subtype disambiguated entity subType
   */
  public void addSubtype(String subtype) {
    if(!StringUtils.isBlank(subtype) && !subtypes.contains(subtype.trim())) {
      subtypes.add(subtype.trim());
    }
  }

  /**
   * Return the disambiguated entity subType.  SubTypes expose additional
   * ontological mappings for a detected entity, such as identification of a
   * Person as a Politician or Athlete.
   *
   * @return disambiguated entity subType
   */
  public Iterator<String> subtypeIterator() {
    return subtypes.iterator();
  }

  /**
   * Return the number of subtypes.
   *
   * @return number of subtypes
   */
  public int getSubtypeSize() {
    return subtypes.size();
  }

  /**
   * Set link to UMBEL.  Note: Provided only for entities that exist in this
   * that exist in this linked data-set.
   *
   * @param umbel link to UMBEL
   */
  public void setUmbel(String umbel) {
    if(umbel != null) {
      umbel = umbel.trim();
    }
    this.umbel = umbel;
  }

  /**
   * Return link to UMBEL.  Note: Provided only for entities that exist in this
   * that exist in this linked data-set.
   *
   * @return link to UMBEL
   */
  public String getUmbel() {
    return umbel;
  }

  /**
   * Set the website associated with this concept tag.
   *
   * @param website website associated with this concept tag
   */
  public void setWebsite(String website) {
    if(website != null) {
      website = website.trim();
    }
    this.website = website;
  }

  /**
   * Return the website associated with this concept tag.
   *
   * @return website associated with this concept tag
   */
  public String getWebsite() {
    return website;
  }

  /**
   * Set link to YAGO.  Note: Provided only for entities that exist in this
   * linked data-set.
   *
   * @param yago link to YAGO
   */
  public void setYago(String yago) {
    if(yago != null) {
      yago = yago.trim();
    }
    this.yago = yago;
  }

  /**
   * Return link to YAGO.  Note: Provided only for entities that exist in this
   * linked data-set.
   *
   * @return link to YAGO
   */
  public String getYago() {
    return yago;
  }

  public DisambiguatedAlchemyEntity clone() {
    final DisambiguatedAlchemyEntity clone = new DisambiguatedAlchemyEntity();
    clone.setCensus(getCensus());
    clone.setCIAFactbook(getCIAFactbook());
    clone.setCrunchbase(getCrunchbase());
    clone.setDBPedia(getDBPedia());
    clone.setFreebase(getFreebase());
    clone.setGeo(getGeo());
    clone.setGeonames(getGeonames());
    clone.setName(getName());
    clone.setOpencyc(getOpencyc());
    clone.setMusicBrainz(getMusicBrainz());
    clone.setSemanticCrunchbase(getSemanticCrunchbase());
    Iterator<String> iterator = subtypeIterator();
    while(iterator.hasNext()) {
      clone.addSubtype(iterator.next());
    }
    clone.setUmbel(getUmbel());
    clone.setWebsite(getWebsite());
    clone.setYago(getYago());
    return clone;
  }

  @Override
  public boolean equals(Object o) {
    if(this == o) {
      return true;
    }
    if(o == null || getClass() != o.getClass()) {
      return false;
    }
    if(!super.equals(o)) {
      return false;
    }

    DisambiguatedAlchemyEntity entity = (DisambiguatedAlchemyEntity) o;

    if(census != null ? !census.equals(entity.census) : entity.census != null) {
      return false;
    }
    if(ciaFactbook != null ? !ciaFactbook.equals(entity.ciaFactbook)
                           : entity.ciaFactbook != null) {
      return false;
    }
    if(crunchbase != null ? !crunchbase.equals(entity.crunchbase)
                          : entity.crunchbase != null) {
      return false;
    }
    if(dbpedia != null ? !dbpedia.equals(entity.dbpedia)
                       : entity.dbpedia != null) {
      return false;
    }
    if(freebase != null ? !freebase.equals(entity.freebase)
                        : entity.freebase != null) {
      return false;
    }
    if(geo != null ? !geo.equals(entity.geo) : entity.geo != null) {
      return false;
    }

    if(Double.compare(entity.latitude, latitude) != 0) {
      return false;
    }
    if(Double.compare(entity.longitude, longitude) != 0) {
      return false;
    }
    if(geonames != null ? !geonames.equals(entity.geonames)
                        : entity.geonames != null) {
      return false;
    }
    if(musicBrainz != null ? !musicBrainz.equals(entity.musicBrainz)
                           : entity.musicBrainz != null) {
      return false;
    }
    if(name != null ? !name.equals(entity.name) : entity.name != null) {
      return false;
    }
    if(opencyc != null ? !opencyc.equals(entity.opencyc)
                       : entity.opencyc != null) {
      return false;
    }
    if(semanticCrunchbase != null
       ? !semanticCrunchbase.equals(entity.semanticCrunchbase)
       : entity.semanticCrunchbase != null) {
      return false;
    }
    if(subtypes != null ? !subtypes.equals(entity.subtypes)
                        : entity.subtypes != null) {
      return false;
    }
    if(umbel != null ? !umbel.equals(entity.umbel) : entity.umbel != null) {
      return false;
    }
    if(website != null ? !website.equals(entity.website)
                       : entity.website != null) {
      return false;
    }
    if(yago != null ? !yago.equals(entity.yago) : entity.yago != null) {
      return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    long temp;
    result = 31 * result + (census != null ? census.hashCode() : 0);
    result = 31 * result + (ciaFactbook != null ? ciaFactbook.hashCode() : 0);
    result = 31 * result + (crunchbase != null ? crunchbase.hashCode() : 0);
    result = 31 * result + (dbpedia != null ? dbpedia.hashCode() : 0);
    result = 31 * result + (freebase != null ? freebase.hashCode() : 0);
    result = 31 * result + (geo != null ? geo.hashCode() : 0);
    result = 31 * result + (geonames != null ? geonames.hashCode() : 0);
    temp = latitude != +0.0d ? Double.doubleToLongBits(latitude) : 0L;
    result = 31 * result + (int) (temp ^ (temp >>> 32));
    temp = longitude != +0.0d ? Double.doubleToLongBits(longitude) : 0L;
    result = 31 * result + (int) (temp ^ (temp >>> 32));
    result = 31 * result + (musicBrainz != null ? musicBrainz.hashCode() : 0);
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (opencyc != null ? opencyc.hashCode() : 0);
    result = 31 * result + (semanticCrunchbase != null
                            ? semanticCrunchbase.hashCode() : 0);
    result = 31 * result + (subtypes != null ? subtypes.hashCode() : 0);
    result = 31 * result + (umbel != null ? umbel.hashCode() : 0);
    result = 31 * result + (website != null ? website.hashCode() : 0);
    result = 31 * result + (yago != null ? yago.hashCode() : 0);
    return result;
  }

  /**
   * @return string representing this object
   *
   * @see #toString(org.apache.commons.lang.builder.ToStringStyle)
   */
  @Override
  public String toString() {
    return toString(ToStringStyle.DEFAULT_STYLE);
  }

  /**
   * @return string representing this object
   *
   * @see ToStringBuilder
   */
  public String toString(final ToStringStyle style) {
    // note - do not do super.toString
    // it will result in a StackOverflowError from ToStringStyle
    return new ToStringBuilder(this, style)
        .append("census", getCensus())
        .append("CIA Factbook", getCIAFactbook())
        .append("crunchbase", getCrunchbase())
        .append("dbpedia", getDBPedia())
        .append("freebase", getFreebase())
        .append("geo", getGeo())
        .append("geonames", getGeonames())
        .append("latitude", getLatitude())
        .append("longitude", getLongitude())
        .append("musicBrainz", getMusicBrainz())
        .append("name", getName())
        .append("opencyc", getOpencyc())
        .append("semanticCrunchbase", getSemanticCrunchbase())
        .append("subtype count", getSubtypeSize())
        .append("subtypes", subtypes)
        .append("umbel", getUmbel())
        .append("website", getWebsite())
        .append("yago", getYago())
        .toString();
  }
}
