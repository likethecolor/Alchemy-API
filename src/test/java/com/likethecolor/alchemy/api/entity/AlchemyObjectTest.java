/**
 * File: ObjectAlchemyEntityTest.java
 *
 * Copyright 2012 Dan Brown <dan@likethecolor.com>
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
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

public class AlchemyObjectTest {
  @Test
  public void testConstructor() {
    final AlchemyObject object = new AlchemyObject();

    assertNull(object.getEntity());
    assertNull(object.getSentiment());
    assertNull(object.getSentimentFromSubject());
    assertNull(object.getText());
  }

  @Test
  public void testEntity() {
    final String census = "http://census.org/resource/Israel";
    final String ciaFactbook = "http://www4.wiwiss.fu-berlin.de/factbook/resource/Israel";
    final String crunchbase = "http://crunchbase.com/resource/Israel";
    final String dbPedia = "http://dbpedia.org/resource/Israel";
    final String freebase = "http://rdf.freebase.com/ns/guid.9202a8c04000641f800000000001e2be";
    final Double latitude = 31.0D;
    final Double longitude = 35.0D;
    final String geo = latitude + " " + longitude;
    final String geonames = "http://geonames.com/Israel";
    final String musicBrainz = "http://musicbrainz.com/Israel";
    final String name = "Israel";
    final String opencyc = "http://sw.opencyc.org/concept/Mx4rvViP55wpEbGdrcN5Y29ycA";
    final String semanticCrunchbase = "http://semanticcrunchbase.com/concept/Mx4rvViP55wpEbGdrcN5Y29ycA";
    final String type = "Country";
    final String text = "Israel";
    final String umbel = "http://umbel.org/umbel/ne/wikipedia/Israel";
    final String website = "http://www.knesset.gov.il/";
    final String yago = "http://mpii.de/yago/resource/Israel";
    final List<String> subtypes = new ArrayList<String>();
    subtypes.add("Location");
    subtypes.add("Country");
    subtypes.add("GovernmentalJurisdiction");

    final AlchemyEntity entityAlchemyEntity = new AlchemyEntity();
    entityAlchemyEntity.setCensus(census);
    entityAlchemyEntity.setCIAFactbook(ciaFactbook);
    entityAlchemyEntity.setCrunchbase(crunchbase);
    entityAlchemyEntity.setDBPedia(dbPedia);
    entityAlchemyEntity.setFreebase(freebase);
    entityAlchemyEntity.setGeo(geo);
    entityAlchemyEntity.setGeonames(geonames);
    entityAlchemyEntity.setMusicBrainz(musicBrainz);
    entityAlchemyEntity.setName(name);
    entityAlchemyEntity.setOpencyc(opencyc);
    entityAlchemyEntity.setSemanticCrunchbase(semanticCrunchbase);
    entityAlchemyEntity.setText(text);
    entityAlchemyEntity.setType(type);
    entityAlchemyEntity.setUmbel(umbel);
    entityAlchemyEntity.setWebsite(website);
    entityAlchemyEntity.setYago(yago);
    for(String subtype : subtypes) {
      entityAlchemyEntity.addSubtype(subtype);
    }

    final AlchemyObject object = new AlchemyObject();

    object.setEntity(entityAlchemyEntity);

    final AlchemyEntity actualEntity = object.getEntity();

    assertEquals(entityAlchemyEntity, actualEntity);
    assertNotSame(entityAlchemyEntity, actualEntity);
  }

  @Test
  public void testSentiment() {
    final boolean isMixed = true;
    final Double sentimentScore = 0.9734D;
    final SentimentAlchemyEntity.TYPE sentimentType = SentimentAlchemyEntity.TYPE.POSITIVE;

    final SentimentAlchemyEntity sentimentEntity = new SentimentAlchemyEntity(isMixed, sentimentScore, sentimentType.toString());

    final AlchemyObject object = new AlchemyObject();

    object.setSentiment(sentimentEntity);

    final SentimentAlchemyEntity actualSentiment = object.getSentiment();

    assertEquals(sentimentEntity, actualSentiment);
    assertNotSame(sentimentEntity, actualSentiment);
  }

  @Test
  public void testSentimentFromSubject() {
    final boolean isMixed = true;
    final Double sentimentScore = 0.9734D;
    final SentimentAlchemyEntity.TYPE sentimentType = SentimentAlchemyEntity.TYPE.POSITIVE;

    final SentimentAlchemyEntity sentimentEntity = new SentimentAlchemyEntity(isMixed, sentimentScore, sentimentType.toString());

    final AlchemyObject object = new AlchemyObject();

    object.setSentimentFromSubject(sentimentEntity);

    final SentimentAlchemyEntity actualSentiment = object.getSentimentFromSubject();

    assertEquals(sentimentEntity, actualSentiment);
    assertNotSame(sentimentEntity, actualSentiment);
  }

  @Test
  public void testText() {
    final String expectedText = "Israel";

    final AlchemyObject object = new AlchemyObject();

    object.setText(expectedText);

    String actualText = object.getText();

    assertEquals(expectedText, actualText);

    // null - should change value
    object.setText(null);

    actualText = object.getText();

    assertNull(actualText);

    // empty string - should change value
    object.setText(expectedText);
    object.setText("");

    actualText = object.getText();

    assertEquals("", actualText);

    // empty white space string - should change value and be trimmed
    object.setText(expectedText);
    object.setText("\t  \t\r\n");

    actualText = object.getText();

    assertEquals("", actualText);

    // should trim
    object.setText("\n\r  " + expectedText + "   \t  ");

    actualText = object.getText();

    assertEquals(expectedText, actualText);
  }

  @Test
  public void testClone() {
    final String text = "Israel";

    final String census = "http://census.org/resource/Israel";
    final String ciaFactbook = "http://www4.wiwiss.fu-berlin.de/factbook/resource/Israel";
    final String crunchbase = "http://crunchbase.com/resource/Israel";
    final String dbPedia = "http://dbpedia.org/resource/Israel";
    final String freebase = "http://rdf.freebase.com/ns/guid.9202a8c04000641f800000000001e2be";
    final Double latitude = 31.0D;
    final Double longitude = 35.0D;
    final String geo = latitude + " " + longitude;
    final String geonames = "http://geonames.com/Israel";
    final String musicBrainz = "http://musicbrainz.com/Israel";
    final String name = "Israel";
    final String opencyc = "http://sw.opencyc.org/concept/Mx4rvViP55wpEbGdrcN5Y29ycA";
    final String semanticCrunchbase = "http://semanticcrunchbase.com/concept/Mx4rvViP55wpEbGdrcN5Y29ycA";
    final String type = "Country";
    final String entityText = "Israel";
    final String umbel = "http://umbel.org/umbel/ne/wikipedia/Israel";
    final String website = "http://www.knesset.gov.il/";
    final String yago = "http://mpii.de/yago/resource/Israel";
    final List<String> subtypes = new ArrayList<String>();
    subtypes.add("Location");
    subtypes.add("Country");
    subtypes.add("GovernmentalJurisdiction");

    final AlchemyEntity entityAlchemyEntity = new AlchemyEntity();
    entityAlchemyEntity.setCensus(census);
    entityAlchemyEntity.setCIAFactbook(ciaFactbook);
    entityAlchemyEntity.setCrunchbase(crunchbase);
    entityAlchemyEntity.setDBPedia(dbPedia);
    entityAlchemyEntity.setFreebase(freebase);
    entityAlchemyEntity.setGeo(geo);
    entityAlchemyEntity.setGeonames(geonames);
    entityAlchemyEntity.setMusicBrainz(musicBrainz);
    entityAlchemyEntity.setName(name);
    entityAlchemyEntity.setOpencyc(opencyc);
    entityAlchemyEntity.setSemanticCrunchbase(semanticCrunchbase);
    entityAlchemyEntity.setText(entityText);
    entityAlchemyEntity.setType(type);
    entityAlchemyEntity.setUmbel(umbel);
    entityAlchemyEntity.setWebsite(website);
    entityAlchemyEntity.setYago(yago);
    for(String subtype : subtypes) {
      entityAlchemyEntity.addSubtype(subtype);
    }

    final boolean isMixed = true;
    final Double sentimentScore = 0.9734D;
    final SentimentAlchemyEntity.TYPE sentimentType = SentimentAlchemyEntity.TYPE.POSITIVE;

    final SentimentAlchemyEntity sentimentEntity = new SentimentAlchemyEntity(isMixed, sentimentScore, sentimentType.toString());


    final boolean isMixedFromSubject = true;
    final Double sentimentScoreFromSubject = 0.9734D;
    final SentimentAlchemyEntity.TYPE sentimentTypeFromSubject = SentimentAlchemyEntity.TYPE.POSITIVE;

    final SentimentAlchemyEntity sentimentEntityFromSubject = new SentimentAlchemyEntity(isMixedFromSubject, sentimentScoreFromSubject, sentimentTypeFromSubject.toString());

    final AlchemyObject object = new AlchemyObject();
    AlchemyObject clone = new AlchemyObject();

    assertEquals(object, clone);
    assertNotSame(object, clone);


    object.setEntity(entityAlchemyEntity);
    clone = object.clone();

    assertEquals(object, clone);
    assertNotSame(object, clone);


    object.setSentiment(sentimentEntity);
    clone = object.clone();

    assertEquals(object, clone);
    assertNotSame(object, clone);

    object.setSentimentFromSubject(sentimentEntityFromSubject);
    clone = object.clone();

    assertEquals(object, clone);
    assertNotSame(object, clone);

    object.setText(text);
    clone = object.clone();

    assertEquals(object, clone);
    assertNotSame(object, clone);
  }

  @Test
  public void testEquals() {
    final String text = "Israel";

    final String census = "http://census.org/resource/Israel";
    final String ciaFactbook = "http://www4.wiwiss.fu-berlin.de/factbook/resource/Israel";
    final String crunchbase = "http://crunchbase.com/resource/Israel";
    final String dbPedia = "http://dbpedia.org/resource/Israel";
    final String freebase = "http://rdf.freebase.com/ns/guid.9202a8c04000641f800000000001e2be";
    final Double latitude = 31.0D;
    final Double longitude = 35.0D;
    final String geo = latitude + " " + longitude;
    final String geonames = "http://geonames.com/Israel";
    final String musicBrainz = "http://musicbrainz.com/Israel";
    final String name = "Israel";
    final String opencyc = "http://sw.opencyc.org/concept/Mx4rvViP55wpEbGdrcN5Y29ycA";
    final String semanticCrunchbase = "http://semanticcrunchbase.com/concept/Mx4rvViP55wpEbGdrcN5Y29ycA";
    final String type = "Country";
    final String entityText = "Israel";
    final String umbel = "http://umbel.org/umbel/ne/wikipedia/Israel";
    final String website = "http://www.knesset.gov.il/";
    final String yago = "http://mpii.de/yago/resource/Israel";
    final List<String> subtypes = new ArrayList<String>();
    subtypes.add("Location");
    subtypes.add("Country");
    subtypes.add("GovernmentalJurisdiction");

    final AlchemyEntity entityAlchemyEntity = new AlchemyEntity();
    entityAlchemyEntity.setCensus(census);
    entityAlchemyEntity.setCIAFactbook(ciaFactbook);
    entityAlchemyEntity.setCrunchbase(crunchbase);
    entityAlchemyEntity.setDBPedia(dbPedia);
    entityAlchemyEntity.setFreebase(freebase);
    entityAlchemyEntity.setGeo(geo);
    entityAlchemyEntity.setGeonames(geonames);
    entityAlchemyEntity.setMusicBrainz(musicBrainz);
    entityAlchemyEntity.setName(name);
    entityAlchemyEntity.setOpencyc(opencyc);
    entityAlchemyEntity.setSemanticCrunchbase(semanticCrunchbase);
    entityAlchemyEntity.setText(entityText);
    entityAlchemyEntity.setType(type);
    entityAlchemyEntity.setUmbel(umbel);
    entityAlchemyEntity.setWebsite(website);
    entityAlchemyEntity.setYago(yago);
    for(String subtype : subtypes) {
      entityAlchemyEntity.addSubtype(subtype);
    }

    final boolean isMixed = true;
    final Double sentimentScore = 0.9734D;
    final SentimentAlchemyEntity.TYPE sentimentType = SentimentAlchemyEntity.TYPE.POSITIVE;

    final SentimentAlchemyEntity sentimentEntity = new SentimentAlchemyEntity(isMixed, sentimentScore, sentimentType.toString());


    final boolean isMixedFromSubject = true;
    final Double sentimentScoreFromSubject = 0.9734D;
    final SentimentAlchemyEntity.TYPE sentimentTypeFromSubject = SentimentAlchemyEntity.TYPE.POSITIVE;

    final SentimentAlchemyEntity sentimentEntityFromSubject = new SentimentAlchemyEntity(isMixedFromSubject, sentimentScoreFromSubject, sentimentTypeFromSubject.toString());

    final AlchemyObject object = new AlchemyObject();

    assertFalse(object.equals(null));
    assertFalse(object.equals(new Double(1312D)));

    assertTrue(object.equals(object));
    assertEquals(object, object);
    assertSame(object, object);


    final AlchemyObject other = new AlchemyObject();

    assertTrue(object.equals(other));
    assertEquals(object, other);
    assertNotSame(object, other);


    // entity
    object.setEntity(entityAlchemyEntity);
    other.setEntity(null);

    assertFalse(object.equals(other));
    assertNotSame(object, other);


    object.setEntity(null);
    other.setEntity(entityAlchemyEntity);

    assertFalse(object.equals(other));
    assertNotSame(object, other);


    object.setEntity(entityAlchemyEntity);
    other.setEntity(entityAlchemyEntity);

    assertTrue(object.equals(other));
    assertEquals(object, other);
    assertNotSame(object, other);


    // sentiment
    object.setSentiment(sentimentEntity);
    other.setSentiment(null);

    assertFalse(object.equals(other));
    assertNotSame(object, other);


    object.setSentiment(null);
    other.setSentiment(sentimentEntity);

    assertFalse(object.equals(other));
    assertNotSame(object, other);


    object.setSentiment(sentimentEntity);
    other.setSentiment(sentimentEntity);

    assertTrue(object.equals(other));
    assertEquals(object, other);
    assertNotSame(object, other);


    // sentiment from subject
    object.setSentimentFromSubject(sentimentEntityFromSubject);
    other.setSentimentFromSubject(null);

    assertFalse(object.equals(other));
    assertNotSame(object, other);


    object.setSentimentFromSubject(null);
    other.setSentimentFromSubject(sentimentEntityFromSubject);

    assertFalse(object.equals(other));
    assertNotSame(object, other);


    object.setSentimentFromSubject(sentimentEntityFromSubject);
    other.setSentimentFromSubject(sentimentEntityFromSubject);

    assertTrue(object.equals(other));
    assertEquals(object, other);
    assertNotSame(object, other);


    // text
    object.setText(null);
    other.setText(text + "foo");

    assertFalse(object.equals(other));
    assertNotSame(object, other);


    object.setText(text);

    assertFalse(object.equals(other));
    assertNotSame(object, other);


    other.setText(text);

    assertTrue(object.equals(other));
    assertEquals(object, other);
    assertNotSame(object, other);
  }

  @Test
  public void testToString() {
    final String text = "Israel";

    final String census = "http://census.org/resource/Israel";
    final String ciaFactbook = "http://www4.wiwiss.fu-berlin.de/factbook/resource/Israel";
    final String crunchbase = "http://crunchbase.com/resource/Israel";
    final String dbPedia = "http://dbpedia.org/resource/Israel";
    final String freebase = "http://rdf.freebase.com/ns/guid.9202a8c04000641f800000000001e2be";
    final Double latitude = 31.0D;
    final Double longitude = 35.0D;
    final String geo = latitude + " " + longitude;
    final String geonames = "http://geonames.com/Israel";
    final String musicBrainz = "http://musicbrainz.com/Israel";
    final String name = "Israel";
    final String opencyc = "http://sw.opencyc.org/concept/Mx4rvViP55wpEbGdrcN5Y29ycA";
    final String semanticCrunchbase = "http://semanticcrunchbase.com/concept/Mx4rvViP55wpEbGdrcN5Y29ycA";
    final String type = "Country";
    final String entityText = "Israel";
    final String umbel = "http://umbel.org/umbel/ne/wikipedia/Israel";
    final String website = "http://www.knesset.gov.il/";
    final String yago = "http://mpii.de/yago/resource/Israel";
    final List<String> subtypes = new ArrayList<String>();
    subtypes.add("Location");
    subtypes.add("Country");
    subtypes.add("GovernmentalJurisdiction");

    final AlchemyEntity entityAlchemyEntity = new AlchemyEntity();
    entityAlchemyEntity.setCensus(census);
    entityAlchemyEntity.setCIAFactbook(ciaFactbook);
    entityAlchemyEntity.setCrunchbase(crunchbase);
    entityAlchemyEntity.setDBPedia(dbPedia);
    entityAlchemyEntity.setFreebase(freebase);
    entityAlchemyEntity.setGeo(geo);
    entityAlchemyEntity.setGeonames(geonames);
    entityAlchemyEntity.setMusicBrainz(musicBrainz);
    entityAlchemyEntity.setName(name);
    entityAlchemyEntity.setOpencyc(opencyc);
    entityAlchemyEntity.setSemanticCrunchbase(semanticCrunchbase);
    entityAlchemyEntity.setText(entityText);
    entityAlchemyEntity.setType(type);
    entityAlchemyEntity.setUmbel(umbel);
    entityAlchemyEntity.setWebsite(website);
    entityAlchemyEntity.setYago(yago);
    for(String subtype : subtypes) {
      entityAlchemyEntity.addSubtype(subtype);
    }

    final boolean isMixed = true;
    final Double sentimentScore = 0.9734D;
    final SentimentAlchemyEntity.TYPE sentimentType = SentimentAlchemyEntity.TYPE.POSITIVE;

    final SentimentAlchemyEntity sentimentEntity = new SentimentAlchemyEntity(isMixed, sentimentScore, sentimentType.toString());


    final boolean isMixedFromSubject = true;
    final Double sentimentScoreFromSubject = 0.9734D;
    final SentimentAlchemyEntity.TYPE sentimentTypeFromSubject = SentimentAlchemyEntity.TYPE.POSITIVE;

    final SentimentAlchemyEntity sentimentEntityFromSubject = new SentimentAlchemyEntity(isMixedFromSubject, sentimentScoreFromSubject, sentimentTypeFromSubject.toString());

    final AlchemyObject object = new AlchemyObject();
    object.setEntity(entityAlchemyEntity);
    object.setSentiment(sentimentEntity);
    object.setSentimentFromSubject(sentimentEntityFromSubject);
    object.setText(text);

    final String expectedString = new ToStringBuilder(object)
        .append("entity", entityAlchemyEntity)
        .append("sentiment", sentimentEntity)
        .append("sentiment from subject", sentimentEntityFromSubject)
        .append("text", text)
        .toString();

    final String actualString = object.toString();

    assertEquals(expectedString, actualString);
  }

  @Test
  public void testToString_Formatted() {
    final ToStringStyle style = ToStringStyle.MULTI_LINE_STYLE;
    final String text = "Israel";

    final String census = "http://census.org/resource/Israel";
    final String ciaFactbook = "http://www4.wiwiss.fu-berlin.de/factbook/resource/Israel";
    final String crunchbase = "http://crunchbase.com/resource/Israel";
    final String dbPedia = "http://dbpedia.org/resource/Israel";
    final String freebase = "http://rdf.freebase.com/ns/guid.9202a8c04000641f800000000001e2be";
    final Double latitude = 31.0D;
    final Double longitude = 35.0D;
    final String geo = latitude + " " + longitude;
    final String geonames = "http://geonames.com/Israel";
    final String musicBrainz = "http://musicbrainz.com/Israel";
    final String name = "Israel";
    final String opencyc = "http://sw.opencyc.org/concept/Mx4rvViP55wpEbGdrcN5Y29ycA";
    final String semanticCrunchbase = "http://semanticcrunchbase.com/concept/Mx4rvViP55wpEbGdrcN5Y29ycA";
    final String type = "Country";
    final String entityText = "Israel";
    final String umbel = "http://umbel.org/umbel/ne/wikipedia/Israel";
    final String website = "http://www.knesset.gov.il/";
    final String yago = "http://mpii.de/yago/resource/Israel";
    final List<String> subtypes = new ArrayList<String>();
    subtypes.add("Location");
    subtypes.add("Country");
    subtypes.add("GovernmentalJurisdiction");

    final AlchemyEntity entityAlchemyEntity = new AlchemyEntity();
    entityAlchemyEntity.setCensus(census);
    entityAlchemyEntity.setCIAFactbook(ciaFactbook);
    entityAlchemyEntity.setCrunchbase(crunchbase);
    entityAlchemyEntity.setDBPedia(dbPedia);
    entityAlchemyEntity.setFreebase(freebase);
    entityAlchemyEntity.setGeo(geo);
    entityAlchemyEntity.setGeonames(geonames);
    entityAlchemyEntity.setMusicBrainz(musicBrainz);
    entityAlchemyEntity.setName(name);
    entityAlchemyEntity.setOpencyc(opencyc);
    entityAlchemyEntity.setSemanticCrunchbase(semanticCrunchbase);
    entityAlchemyEntity.setText(entityText);
    entityAlchemyEntity.setType(type);
    entityAlchemyEntity.setUmbel(umbel);
    entityAlchemyEntity.setWebsite(website);
    entityAlchemyEntity.setYago(yago);
    for(String subtype : subtypes) {
      entityAlchemyEntity.addSubtype(subtype);
    }

    final boolean isMixed = true;
    final Double sentimentScore = 0.9734D;
    final SentimentAlchemyEntity.TYPE sentimentType = SentimentAlchemyEntity.TYPE.POSITIVE;

    final SentimentAlchemyEntity sentimentEntity = new SentimentAlchemyEntity(isMixed, sentimentScore, sentimentType.toString());


    final boolean isMixedFromSubject = true;
    final Double sentimentScoreFromSubject = 0.9734D;
    final SentimentAlchemyEntity.TYPE sentimentTypeFromSubject = SentimentAlchemyEntity.TYPE.POSITIVE;

    final SentimentAlchemyEntity sentimentEntityFromSubject = new SentimentAlchemyEntity(isMixedFromSubject, sentimentScoreFromSubject, sentimentTypeFromSubject.toString());

    final AlchemyObject object = new AlchemyObject();
    object.setEntity(entityAlchemyEntity);
    object.setSentiment(sentimentEntity);
    object.setSentimentFromSubject(sentimentEntityFromSubject);
    object.setText(text);

    final String expectedString = new ToStringBuilder(object, style)
        .append("entity", entityAlchemyEntity.toString(style))
        .append("sentiment", sentimentEntity.toString(style))
        .append("sentiment from subject", sentimentEntityFromSubject.toString(style))
        .append("text", text)
        .toString();

    final String actualString = object.toString(style);

    assertEquals(expectedString, actualString);
  }
}
