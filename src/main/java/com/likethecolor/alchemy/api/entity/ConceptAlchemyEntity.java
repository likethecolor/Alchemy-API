/**
 * File: ConceptAlchemyEntity.java
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

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class ConceptAlchemyEntity extends AbstractAlchemyEntity {
  private String concept;
  private DisambiguatedAlchemyEntity disambiguatedAlchemyEntity;

  public ConceptAlchemyEntity() {
    this(null, null);
  }

  public ConceptAlchemyEntity(final String concept, final Double score) {
    super.setScore(score);
    setConcept(concept);
    this.disambiguatedAlchemyEntity = new DisambiguatedAlchemyEntity();
  }

  public void setDisambiguatedAlchemyEntity(final DisambiguatedAlchemyEntity entity) {
    this.disambiguatedAlchemyEntity = entity;
  }

  /**
   * Set link to USA Census.  Note: Provided only for entities that exist in this
   * that exist in this linked data-set.
   *
   * @param census link to USA Census
   */
  public void setCensus(final String census) {
    disambiguatedAlchemyEntity.setCensus(census);
  }

  /**
   * Return link to USA Census.  Note: Provided only for entities that exist in this
   * that exist in this linked data-set.
   *
   * @return link to USA Census
   */
  public String getCensus() {
    return disambiguatedAlchemyEntity.getCensus();
  }

  /**
   * Set link to CIA World Factbook.  Note: Provided only for entities that exist in this
   * that exist in this linked data-set.
   *
   * @param ciaFactbook link to CIA World Factbook
   */
  public void setCIAFactbook(final String ciaFactbook) {
    disambiguatedAlchemyEntity.setCIAFactbook(ciaFactbook);
  }

  /**
   * Return link to CIA World Factbook.  Note: Provided only for entities that exist in this
   * that exist in this linked data-set.
   *
   * @return link to CIA World Factbook
   */
  public String getCIAFactbook() {
    return disambiguatedAlchemyEntity.getCIAFactbook();
  }

  /**
   * Set the detected concept tag.
   *
   * @param concept detected concept tag
   */
  public void setConcept(String concept) {
    if(concept != null) {
      concept = concept.trim();
    }
    this.concept = concept;
  }

  /**
   * Return detected concept tag.
   *
   * @return detected concept tag
   */
  public String getConcept() {
    return concept;
  }

  /**
   * Set link to CrunchBase.  Note: Provided only for entities that exist in this
   * that exist in this linked data-set.
   *
   * @param crunchbase link to CrunchBase
   */
  public void setCrunchbase(final String crunchbase) {
    disambiguatedAlchemyEntity.setCrunchbase(crunchbase);
  }

  /**
   * Return link to CrunchBase.  Note: Provided only for entities that exist in this
   * that exist in this linked data-set.
   *
   * @return link to CrunchBase
   */
  public String getCrunchbase() {
    return disambiguatedAlchemyEntity.getCrunchbase();
  }

  /**
   * Set link to DBpedia.  Note: Provided only for entities that exist in this
   * that exist in this linked data-set.
   *
   * @param dbpedia link to DBpedia
   */
  public void setDBPedia(final String dbpedia) {
    disambiguatedAlchemyEntity.setDBPedia(dbpedia);
  }

  /**
   * Return link to DBpedia.  Note: Provided only for entities that exist in this
   * that exist in this linked data-set.
   *
   * @return link to DBpedia
   */
  public String getDBPedia() {
    return disambiguatedAlchemyEntity.getDBPedia();
  }

  /**
   * Set link to Freebase.  Note: Provided only for entities that exist in this
   * that exist in this linked data-set.
   *
   * @param freebase link to Freebase
   */
  public void setFreebase(final String freebase) {
    disambiguatedAlchemyEntity.setFreebase(freebase);
  }

  /**
   * Return link to Freebase.  Note: Provided only for entities that exist in this
   * that exist in this linked data-set.
   *
   * @return link to Freebase
   */
  public String getFreebase() {
    return disambiguatedAlchemyEntity.getFreebase();
  }

  /**
   * Set the geographic coordinates associated with this concept tag.
   * <p/>
   * latitude longitude
   *
   * @param geo latitude longitude
   */
  public void setGeo(final String geo) {
    disambiguatedAlchemyEntity.setGeo(geo);
  }

  /**
   * Return the geographic coordinates associated with this concept tag.
   * <p/>
   * latitude longitude
   *
   * @return latitude longitude
   */
  public String getGeo() {
    return disambiguatedAlchemyEntity.getGeo();
  }

  /**
   * Set link to Geonames.  Note: Provided only for entities that exist in this
   * that exist in this linked data-set.
   *
   * @param geonames link to Geonames
   */
  public void setGeonames(final String geonames) {
    disambiguatedAlchemyEntity.setGeonames(geonames);
  }

  /**
   * Return link to Geonames.  Note: Provided only for entities that exist in this
   * that exist in this linked data-set.
   *
   * @return link to Geonames
   */
  public String getGeonames() {
    return disambiguatedAlchemyEntity.getGeonames();
  }

  /**
   * Set the latitude.
   *
   * @param latitude latitude
   */
  public void setLatitude(final double latitude) {
    disambiguatedAlchemyEntity.setLatitude(latitude);
  }

  /**
   * Set the latitude.
   *
   * @param latitude latitude
   */
  public void setLatitude(final String latitude) {
    disambiguatedAlchemyEntity.setLatitude(latitude);
  }

  /**
   * Return the latitude.
   *
   * @return latitude
   */
  public Double getLatitude() {
    return disambiguatedAlchemyEntity.getLatitude();
  }

  /**
   * Set the latitude.
   *
   * @param longitude longitude
   */
  public void setLongitude(final double longitude) {
    disambiguatedAlchemyEntity.setLongitude(longitude);
  }

  /**
   * Set the longitude.
   *
   * @param longitude longitude
   */
  public void setLongitude(final String longitude) {
    disambiguatedAlchemyEntity.setLongitude(longitude);
  }

  /**
   * Return the longitude.
   *
   * @return longitude
   */
  public Double getLongitude() {
    return disambiguatedAlchemyEntity.getLongitude();
  }

  /**
   * Set link to MusicBrainz.  Note: Provided only for entities that exist in this
   * that exist in this linked data-set.
   *
   * @param musicBrainz link to MusicBrainz
   */
  public void setMusicBrainz(final String musicBrainz) {
    disambiguatedAlchemyEntity.setMusicBrainz(musicBrainz);
  }

  /**
   * Return link to MusicBrainz.  Note: Provided only for entities that exist in this
   * that exist in this linked data-set.
   *
   * @return link to MusicBrainz
   */
  public String getMusicBrainz() {
    return disambiguatedAlchemyEntity.getMusicBrainz();
  }

  /**
   * Set link to OpenCyc.  Note: Provided only for entities that exist in this
   * that exist in this linked data-set.
   *
   * @param opencyc link to OpenCyc
   */
  public void setOpencyc(final String opencyc) {
    disambiguatedAlchemyEntity.setOpencyc(opencyc);
  }

  /**
   * Return link to OpenCyc.  Note: Provided only for entities that exist in this
   * that exist in this linked data-set.
   *
   * @return link to OpenCyc
   */
  public String getOpencyc() {
    return disambiguatedAlchemyEntity.getOpencyc();
  }

  /**
   * Set link to Semantic CrunchBase.  Note: Provided only for entities that exist in this
   * that exist in this linked data-set.
   *
   * @param semanticCrunchbase link to Semantic CrunchBase
   */
  public void setSemanticCrunchbase(final String semanticCrunchbase) {
    disambiguatedAlchemyEntity.setSemanticCrunchbase(semanticCrunchbase);
  }

  /**
   * Return link to Semantic CrunchBase.  Note: Provided only for entities that exist in this
   * that exist in this linked data-set.
   *
   * @return link to Semantic CrunchBase
   */
  public String getSemanticCrunchbase() {
    return disambiguatedAlchemyEntity.getSemanticCrunchbase();
  }

  /**
   * Set the website associated with this concept tag.
   *
   * @param website website associated with this concept tag
   */
  public void setWebsite(final String website) {
    disambiguatedAlchemyEntity.setWebsite(website);
  }

  /**
   * Return the website associated with this concept tag.
   *
   * @return website associated with this concept tag
   */
  public String getWebsite() {
    return disambiguatedAlchemyEntity.getWebsite();
  }

  /**
   * Set link to YAGO.  Note: Provided only for entities that exist in this
   * linked data-set.
   *
   * @param yago link to YAGO
   */
  public void setYago(final String yago) {
    disambiguatedAlchemyEntity.setYago(yago);
  }

  /**
   * Return link to YAGO.  Note: Provided only for entities that exist in this
   * linked data-set.
   *
   * @return link to YAGO
   */
  public String getYago() {
    return disambiguatedAlchemyEntity.getYago();
  }

  /**
   * Return a copy of this object.
   *
   * @return copy of this object
   */
  public ConceptAlchemyEntity clone() {
    final ConceptAlchemyEntity clone = new ConceptAlchemyEntity(getConcept(), getScore());
    clone.disambiguatedAlchemyEntity.copy(disambiguatedAlchemyEntity);
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

    ConceptAlchemyEntity entity = (ConceptAlchemyEntity) o;

    if(getCensus() != null ? !getCensus().equals(entity.getCensus())
                           : entity.getCensus() != null) {
      return false;
    }
    if(getCIAFactbook() != null
       ? !getCIAFactbook().equals(entity.getCIAFactbook())
       : entity.getCIAFactbook() != null) {
      return false;
    }
    if(concept != null ? !concept.equals(entity.concept)
                       : entity.concept != null) {
      return false;
    }
    if(getCrunchbase() != null ? !getCrunchbase().equals(entity.getCrunchbase())
                               : entity.getCrunchbase() != null) {
      return false;
    }
    if(getDBPedia() != null ? !getDBPedia().equals(entity.getDBPedia())
                            : entity.getDBPedia() != null) {
      return false;
    }
    if(getFreebase() != null ? !getFreebase().equals(entity.getFreebase())
                             : entity.getFreebase() != null) {
      return false;
    }
    if(getGeo() != null ? !getGeo().equals(entity.getGeo())
                        : entity.getGeo() != null) {
      return false;
    }

    if(Double.compare(entity.getLatitude(), getLatitude()) != 0) {
      return false;
    }
    if(Double.compare(entity.getLongitude(), getLongitude()) != 0) {
      return false;
    }
    if(getGeonames() != null ? !getGeonames().equals(entity.getGeonames())
                             : entity.getGeonames() != null) {
      return false;
    }
    if(getMusicBrainz() != null
       ? !getMusicBrainz().equals(entity.getMusicBrainz())
       : entity.getMusicBrainz() != null) {
      return false;
    }
    if(getOpencyc() != null ? !getOpencyc().equals(entity.getOpencyc())
                            : entity.getOpencyc() != null) {
      return false;
    }
    if(getSemanticCrunchbase() != null
       ? !getSemanticCrunchbase().equals(entity.getSemanticCrunchbase())
       : entity.getSemanticCrunchbase() != null) {
      return false;
    }
    if(getWebsite() != null ? !getWebsite().equals(entity.getWebsite())
                            : entity.getWebsite() != null) {
      return false;
    }
    if(getYago() != null ? !getYago().equals(entity.getYago())
                         : entity.getYago() != null) {
      return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    long temp;
    result = 31 * result + (getCensus() != null ? getCensus().hashCode() : 0);
    result = 31 * result + (getCIAFactbook() != null
                            ? getCIAFactbook().hashCode() : 0);
    result = 31 * result + (getCrunchbase() != null ? getCrunchbase().hashCode()
                                                    : 0);
    result = 31 * result + (getDBPedia() != null ? getCrunchbase().hashCode()
                                                 : 0);
    result = 31 * result + (getFreebase() != null ? getFreebase().hashCode()
                                                  : 0);
    result = 31 * result + (getGeo() != null ? getGeo().hashCode() : 0);
    result = 31 * result + (getGeonames() != null ? getGeonames().hashCode()
                                                  : 0);
    temp = getLatitude() != +0.0d ? Double.doubleToLongBits(getLatitude()) : 0L;
    result = 31 * result + (int) (temp ^ (temp >>> 32));
    temp =
        getLongitude() != +0.0d ? Double.doubleToLongBits(getLongitude()) : 0L;
    result = 31 * result + (int) (temp ^ (temp >>> 32));
    result = 31 * result + (getMusicBrainz() != null
                            ? getMusicBrainz().hashCode() : 0);
    result = 31 * result + (getOpencyc() != null ? getOpencyc().hashCode() : 0);
    result = 31 * result + (getSemanticCrunchbase() != null
                            ? getSemanticCrunchbase().hashCode() : 0);
    result = 31 * result + (getWebsite() != null ? getWebsite().hashCode() : 0);
    result = 31 * result + (getYago() != null ? getYago().hashCode() : 0);
    result = 31 * result + (concept != null ? concept.hashCode() : 0);
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
        .append("cia factbook", getCIAFactbook())
        .append("concept", getConcept())
        .append("crunchbase", getCrunchbase())
        .append("dbpedia", getDBPedia())
        .append("freebase", getFreebase())
        .append("geo", getGeo())
        .append("geonames", getGeonames())
        .append("latitude", getLatitude())
        .append("longitude", getLongitude())
        .append("music brainz", getMusicBrainz())
        .append("opencyc", getOpencyc())
        .append("score", getScore())
        .append("semantic crunchbase", getSemanticCrunchbase())
        .append("website", getWebsite())
        .append("yago", getYago())
        .toString();
  }
}
