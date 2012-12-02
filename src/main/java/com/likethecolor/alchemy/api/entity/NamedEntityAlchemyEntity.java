/**
 * File: NamedEntityAlchemyEntity.java
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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NamedEntityAlchemyEntity extends AbstractAlchemyEntity {
  private int count;
  private DisambiguatedAlchemyEntity disambiguatedAlchemyEntity;
  private List<QuotationAlchemyEntity> quotations;
  private SentimentAlchemyEntity sentimentAlchemyEntity;
  private String type;
  private String text;

  public NamedEntityAlchemyEntity() {
    this(null, null, 0, null);
  }

  public NamedEntityAlchemyEntity(final String text, final String type, final int count, final Double score) {
    super.setScore(score);
    setText(text);
    setType(type);
    setCount(count);
    quotations = new ArrayList<QuotationAlchemyEntity>();
    disambiguatedAlchemyEntity = new DisambiguatedAlchemyEntity();
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
   * Set the number of times an entity was seen within the source text.
   *
   * @param count number of times an entity was seen within the source text
   */
  public void setCount(final int count) {
    this.count = count;
  }

  /**
   * Return the number of times an entity was seen within the source text.
   *
   * @return number of times an entity was seen within the source text
   */
  public int getCount() {
    return count;
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
   * Set the {@link DisambiguatedAlchemyEntity} for this entity.
   *
   * @param entity {@link DisambiguatedAlchemyEntity} for this entity
   */
  public void setDisambiguatedAlchemyEntity(final DisambiguatedAlchemyEntity entity) {
    this.disambiguatedAlchemyEntity = entity;
  }

  /**
   * Return the {@link DisambiguatedAlchemyEntity} for this entity.
   *
   * @return {@link DisambiguatedAlchemyEntity} for this entity
   */
  public DisambiguatedAlchemyEntity getDisambiguatedAlchemyEntity() {
    return disambiguatedAlchemyEntity;
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
   * Set the disambiguated entity name.
   *
   * @param name disambiguated entity name
   */
  public void setName(final String name) {
    disambiguatedAlchemyEntity.setName(name);
  }

  /**
   * Return the disambiguated entity name.
   *
   * @return disambiguated entity name
   */
  public String getName() {
    return disambiguatedAlchemyEntity.getName();
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
   * Set extracted quotations for the detected entity.
   *
   * @param quotation extracted quotations for the detected entity
   */
  public void addQuotation(final QuotationAlchemyEntity quotation) {
    if(quotation != null && !quotations.contains(quotation)) {
      quotations.add(quotation);
    }
  }

  /**
   * Return extracted quotations for the detected entity.
   *
   * @return extracted quotations for the detected entity
   */
  public Iterator<QuotationAlchemyEntity> quotationIterator() {
    return quotations.iterator();
  }

  /**
   * Return the number of quotations.
   *
   * @return number of quotations
   */
  public int getQuotationCount() {
    return quotations.size();
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
   * Set the sentiment of this entity.
   *
   * @param sentimentAlchemyEntity sentiment of this entity
   */
  public void setSentiment(SentimentAlchemyEntity sentimentAlchemyEntity) {
    this.sentimentAlchemyEntity = sentimentAlchemyEntity;
  }

  /**
   * Return the sentiment of this entity.
   *
   * @return sentiment of this entity
   */
  public SentimentAlchemyEntity getSentiment() {
    return sentimentAlchemyEntity;
  }

  /**
   * Set the disambiguated entity subType.  SubTypes expose additional
   * ontological mappings for a detected entity, such as identification of a
   * Person as a Politician or Athlete.
   *
   * @param subtype disambiguated entity subType
   */
  public void addSubtype(String subtype) {
    disambiguatedAlchemyEntity.addSubtype(subtype);
  }

  /**
   * Return the disambiguated entity subType.  SubTypes expose additional
   * ontological mappings for a detected entity, such as identification of a
   * Person as a Politician or Athlete.
   *
   * @return disambiguated entity subType
   */
  public Iterator<String> subtypeIterator() {
    return disambiguatedAlchemyEntity.subtypeIterator();
  }

  /**
   * Return the number of subtypes.
   *
   * @return number of subtypes
   */
  public int getSubtypeSize() {
    return disambiguatedAlchemyEntity.getSubtypeSize();
  }

  /**
   * Set the detected entity text.
   *
   * @param text detected entity text
   */
  public void setText(String text) {
    if(text != null) {
      text = text.trim();
    }
    this.text = text;
  }

  /**
   * Return the detected entity text.
   *
   * @return detected entity text
   */
  public String getText() {
    return text;
  }

  /**
   * Set the detected entity type.
   *
   * @param type detected entity type
   */
  public void setType(String type) {
    if(type != null) {
      type = type.trim();
    }
    this.type = type;
  }

  /**
   * Return the detected entity type.
   *
   * @return detected entity type
   */
  public String getType() {
    return type;
  }

  /**
   * Set link to UMBEL.  Note: Provided only for entities that exist in this
   * that exist in this linked data-set.
   *
   * @param umbel link to UMBEL
   */
  public void setUmbel(final String umbel) {
    disambiguatedAlchemyEntity.setUmbel(umbel);
  }

  /**
   * Return link to UMBEL.  Note: Provided only for entities that exist in this
   * that exist in this linked data-set.
   *
   * @return link to UMBEL
   */
  public String getUmbel() {
    return disambiguatedAlchemyEntity.getUmbel();
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

  public NamedEntityAlchemyEntity clone() {
    final NamedEntityAlchemyEntity clone = new NamedEntityAlchemyEntity(getText(), getType(), getCount(), getScore());
    clone.setSentiment(sentimentAlchemyEntity);
    clone.disambiguatedAlchemyEntity.copy(disambiguatedAlchemyEntity);

    Iterator<QuotationAlchemyEntity> iterator = quotationIterator();
    while(iterator.hasNext()) {
      clone.addQuotation(iterator.next());
    }
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

    NamedEntityAlchemyEntity entity = (NamedEntityAlchemyEntity) o;

    if(count != entity.count) {
      return false;
    }
    if(disambiguatedAlchemyEntity != null
       ? !disambiguatedAlchemyEntity.equals(entity.disambiguatedAlchemyEntity)
       : entity.disambiguatedAlchemyEntity != null) {
      return false;
    }
    if(quotations != null ? !quotations.equals(entity.quotations)
                          : entity.quotations != null) {
      return false;
    }
    if(sentimentAlchemyEntity != null
       ? !sentimentAlchemyEntity.equals(entity.sentimentAlchemyEntity)
       : entity.sentimentAlchemyEntity != null) {
      return false;
    }
    if(text != null ? !text.equals(entity.text) : entity.text != null) {
      return false;
    }
    if(type != null ? !type.equals(entity.type) : entity.type != null) {
      return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + count;
    result = 31 * result + (disambiguatedAlchemyEntity != null
                            ? disambiguatedAlchemyEntity.hashCode() : 0);
    result = 31 * result + (quotations != null ? quotations.hashCode() : 0);
    result = 31 * result + (sentimentAlchemyEntity != null
                            ? sentimentAlchemyEntity.hashCode() : 0);
    result = 31 * result + (type != null ? type.hashCode() : 0);
    result = 31 * result + (text != null ? text.hashCode() : 0);
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
        .append("count", getCount())
        .append("quotation count", getQuotationCount())
        .append("quotations", quotations)
        .append("score", getScore())
        .append("sentiment", sentimentAlchemyEntity)
        .append("text", getText())
        .append("type", getType())
        .append("disambiguated", disambiguatedAlchemyEntity.toString())
        .toString();
  }
}
