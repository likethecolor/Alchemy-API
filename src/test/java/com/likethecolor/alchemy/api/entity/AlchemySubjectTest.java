/**
 * File: AlchemySubjectTest.java
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

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class AlchemySubjectTest {
  @Test
  public void testConstructor_NoArgs() {
    final AlchemySubject entity = new AlchemySubject();

    assertNull(entity.getEntity());
    assertNull(entity.getText());
  }

  @Test
  public void testConstructor() {
    final String text = "U.S. marshals Deputy John Beeman";
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

    final AlchemyEntity alchemyEntity = new AlchemyEntity();
    alchemyEntity.setCensus(census);
    alchemyEntity.setCIAFactbook(ciaFactbook);
    alchemyEntity.setCrunchbase(crunchbase);
    alchemyEntity.setDBPedia(dbPedia);
    alchemyEntity.setFreebase(freebase);
    alchemyEntity.setGeo(geo);
    alchemyEntity.setGeonames(geonames);
    alchemyEntity.setMusicBrainz(musicBrainz);
    alchemyEntity.setName(name);
    alchemyEntity.setOpencyc(opencyc);
    alchemyEntity.setSemanticCrunchbase(semanticCrunchbase);
    alchemyEntity.setText(entityText);
    alchemyEntity.setType(type);
    alchemyEntity.setUmbel(umbel);
    alchemyEntity.setWebsite(website);
    alchemyEntity.setYago(yago);
    for(String subtype : subtypes) {
      alchemyEntity.addSubtype(subtype);
    }

    final AlchemySubject entity = new AlchemySubject(alchemyEntity, text);

    assertEquals(alchemyEntity, entity.getEntity());
    assertNotSame(alchemyEntity, entity.getEntity());
    assertEquals(text, entity.getText());
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
    final String entityText = "Israel";
    final String umbel = "http://umbel.org/umbel/ne/wikipedia/Israel";
    final String website = "http://www.knesset.gov.il/";
    final String yago = "http://mpii.de/yago/resource/Israel";
    final List<String> subtypes = new ArrayList<String>();
    subtypes.add("Location");
    subtypes.add("Country");
    subtypes.add("GovernmentalJurisdiction");

    final AlchemyEntity alchemyEntity = new AlchemyEntity();
    alchemyEntity.setCensus(census);
    alchemyEntity.setCIAFactbook(ciaFactbook);
    alchemyEntity.setCrunchbase(crunchbase);
    alchemyEntity.setDBPedia(dbPedia);
    alchemyEntity.setFreebase(freebase);
    alchemyEntity.setGeo(geo);
    alchemyEntity.setGeonames(geonames);
    alchemyEntity.setMusicBrainz(musicBrainz);
    alchemyEntity.setName(name);
    alchemyEntity.setOpencyc(opencyc);
    alchemyEntity.setSemanticCrunchbase(semanticCrunchbase);
    alchemyEntity.setText(entityText);
    alchemyEntity.setType(type);
    alchemyEntity.setUmbel(umbel);
    alchemyEntity.setWebsite(website);
    alchemyEntity.setYago(yago);
    for(String subtype : subtypes) {
      alchemyEntity.addSubtype(subtype);
    }

    final AlchemySubject entity = new AlchemySubject();
    entity.setEntity(alchemyEntity);

    assertEquals(alchemyEntity, entity.getEntity());
    assertNotSame(alchemyEntity, entity.getEntity());

    // null should change value
    entity.setEntity(alchemyEntity);
    entity.setEntity(null);

    assertNull(entity.getEntity());
  }

  @Test
  public void testSentiment() {
    final boolean isMixed = false;
    final double score = 0.121;
    final SentimentAlchemyEntity.TYPE sentimentType = SentimentAlchemyEntity.TYPE.POSITIVE;

    final SentimentAlchemyEntity sentimentAlchemyEntity = new SentimentAlchemyEntity(isMixed, score, sentimentType.toString());

    final AlchemySubject entity = new AlchemySubject();
    entity.setSentiment(sentimentAlchemyEntity);

    assertEquals(sentimentAlchemyEntity, entity.getSentiment());
    assertNotSame(sentimentAlchemyEntity, entity.getSentiment());

    // null should change value
    entity.setSentiment(sentimentAlchemyEntity);
    entity.setSentiment(null);

    assertNull(entity.getSentiment());
  }

  @Test
  public void testText() {
    final String text = "U.S. marshals Deputy John Beeman";

    final AlchemySubject entity = new AlchemySubject();

    entity.setText(text);

    assertEquals(text, entity.getText());

    // should be trimmed
    entity.setText("  " + text + "\t   \r\n");

    assertEquals(text, entity.getText());

    // null - should change value
    entity.setText(text);
    entity.setText(null);

    assertNull(entity.getText());

    // empty string - should change value
    entity.setText(text);
    entity.setText("");

    assertEquals("", entity.getText());

    // null - should change value and be trimmed
    entity.setText(text);
    entity.setText("\t  ");

    assertEquals("", entity.getText());
  }

  @Test
  public void testClone() {
    final String text = "U.S. marshals Deputy John Beeman";
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
    final boolean isMixed = false;
    final double score = 0.121;
    final SentimentAlchemyEntity.TYPE sentimentType = SentimentAlchemyEntity.TYPE.POSITIVE;

    final AlchemyEntity alchemyEntity = new AlchemyEntity();
    alchemyEntity.setCensus(census);
    alchemyEntity.setCIAFactbook(ciaFactbook);
    alchemyEntity.setCrunchbase(crunchbase);
    alchemyEntity.setDBPedia(dbPedia);
    alchemyEntity.setFreebase(freebase);
    alchemyEntity.setGeo(geo);
    alchemyEntity.setGeonames(geonames);
    alchemyEntity.setMusicBrainz(musicBrainz);
    alchemyEntity.setName(name);
    alchemyEntity.setOpencyc(opencyc);
    alchemyEntity.setSemanticCrunchbase(semanticCrunchbase);
    alchemyEntity.setText(entityText);
    alchemyEntity.setType(type);
    alchemyEntity.setUmbel(umbel);
    alchemyEntity.setWebsite(website);
    alchemyEntity.setYago(yago);
    for(String subtype : subtypes) {
      alchemyEntity.addSubtype(subtype);
    }

    final SentimentAlchemyEntity sentimentAlchemyEntity = new SentimentAlchemyEntity(isMixed, score, sentimentType.toString());

    final AlchemySubject entity = new AlchemySubject();
    AlchemySubject clone = new AlchemySubject();

    assertEquals(entity, clone);
    assertNotSame(entity, clone);

    entity.setEntity(alchemyEntity);
    clone = entity.clone();

    assertEquals(entity, clone);
    assertNotSame(entity, clone);

    entity.setSentiment(sentimentAlchemyEntity);
    clone = entity.clone();

    assertEquals(entity, clone);
    assertNotSame(entity, clone);

    entity.setText(text);
    clone = entity.clone();

    assertEquals(entity, clone);
    assertNotSame(entity, clone);
  }

  @Test
  public void testEquals() {
    final String text = "U.S. marshals Deputy John Beeman";
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
    final boolean isMixed = false;
    final double score = 0.121;
    final SentimentAlchemyEntity.TYPE sentimentType = SentimentAlchemyEntity.TYPE.POSITIVE;

    final AlchemyEntity alchemyEntity = new AlchemyEntity();
    alchemyEntity.setCensus(census);
    alchemyEntity.setCIAFactbook(ciaFactbook);
    alchemyEntity.setCrunchbase(crunchbase);
    alchemyEntity.setDBPedia(dbPedia);
    alchemyEntity.setFreebase(freebase);
    alchemyEntity.setGeo(geo);
    alchemyEntity.setGeonames(geonames);
    alchemyEntity.setMusicBrainz(musicBrainz);
    alchemyEntity.setName(name);
    alchemyEntity.setOpencyc(opencyc);
    alchemyEntity.setSemanticCrunchbase(semanticCrunchbase);
    alchemyEntity.setText(entityText);
    alchemyEntity.setType(type);
    alchemyEntity.setUmbel(umbel);
    alchemyEntity.setWebsite(website);
    alchemyEntity.setYago(yago);
    for(String subtype : subtypes) {
      alchemyEntity.addSubtype(subtype);
    }

    final SentimentAlchemyEntity sentimentAlchemyEntity = new SentimentAlchemyEntity(isMixed, score, sentimentType.toString());

    final AlchemySubject entity = new AlchemySubject();

    assertFalse(entity.equals(null));
    assertFalse(entity.equals(new Double(1312D)));

    assertTrue(entity.equals(entity));
    assertEquals(entity, entity);
    assertSame(entity, entity);


    final AlchemySubject other = new AlchemySubject();

    assertTrue(entity.equals(other));
    assertEquals(entity, other);
    assertNotSame(entity, other);


    // entity
    entity.setEntity(alchemyEntity);
    other.setEntity(null);

    assertFalse(entity.equals(other));
    assertNotSame(entity, other);


    entity.setEntity(null);
    other.setEntity(alchemyEntity);

    assertFalse(entity.equals(other));
    assertNotSame(entity, other);


    entity.setEntity(alchemyEntity);
    other.setEntity(alchemyEntity);

    assertTrue(entity.equals(other));
    assertEquals(entity, other);
    assertNotSame(entity, other);


    // sentiment
    entity.setSentiment(sentimentAlchemyEntity);
    other.setSentiment(null);

    assertFalse(entity.equals(other));
    assertNotSame(entity, other);


    entity.setSentiment(null);
    other.setSentiment(sentimentAlchemyEntity);

    assertFalse(entity.equals(other));
    assertNotSame(entity, other);


    entity.setSentiment(sentimentAlchemyEntity);
    other.setSentiment(sentimentAlchemyEntity);

    assertTrue(entity.equals(other));
    assertEquals(entity, other);
    assertNotSame(entity, other);


    // text
    entity.setText(null);
    other.setText(text + "foo");

    assertFalse(entity.equals(other));
    assertNotSame(entity, other);


    entity.setText(text);

    assertFalse(entity.equals(other));
    assertNotSame(entity, other);


    other.setText(text);

    assertTrue(entity.equals(other));
    assertEquals(entity, other);
    assertNotSame(entity, other);
  }

  @Test
  public void testToString() {
    final String text = "U.S. marshals Deputy John Beeman";
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
    final boolean isMixed = false;
    final double score = 0.121;
    final SentimentAlchemyEntity.TYPE sentimentType = SentimentAlchemyEntity.TYPE.POSITIVE;

    final AlchemyEntity alchemyEntity = new AlchemyEntity();
    alchemyEntity.setCensus(census);
    alchemyEntity.setCIAFactbook(ciaFactbook);
    alchemyEntity.setCrunchbase(crunchbase);
    alchemyEntity.setDBPedia(dbPedia);
    alchemyEntity.setFreebase(freebase);
    alchemyEntity.setGeo(geo);
    alchemyEntity.setGeonames(geonames);
    alchemyEntity.setMusicBrainz(musicBrainz);
    alchemyEntity.setName(name);
    alchemyEntity.setOpencyc(opencyc);
    alchemyEntity.setSemanticCrunchbase(semanticCrunchbase);
    alchemyEntity.setText(entityText);
    alchemyEntity.setType(type);
    alchemyEntity.setUmbel(umbel);
    alchemyEntity.setWebsite(website);
    alchemyEntity.setYago(yago);
    for(String subtype : subtypes) {
      alchemyEntity.addSubtype(subtype);
    }

    final SentimentAlchemyEntity sentimentAlchemyEntity = new SentimentAlchemyEntity(isMixed, score, sentimentType.toString());

    final AlchemySubject entity = new AlchemySubject();
    entity.setEntity(alchemyEntity);
    entity.setSentiment(sentimentAlchemyEntity);
    entity.setText(text);

    final String expectedString = new ToStringBuilder(entity)
        .append("entity", alchemyEntity.toString())
        .append("sentiment", sentimentAlchemyEntity.toString())
        .append("text", text)
        .toString();

    final String actualString = entity.toString();

    assertEquals(expectedString, actualString);
  }

  @Test
  public void testToString_Formatted() {
    final ToStringStyle style = ToStringStyle.MULTI_LINE_STYLE;
    final String text = "U.S. marshals Deputy John Beeman";
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
    final boolean isMixed = false;
    final double score = 0.121;
    final SentimentAlchemyEntity.TYPE sentimentType = SentimentAlchemyEntity.TYPE.POSITIVE;

    final AlchemyEntity alchemyEntity = new AlchemyEntity();
    alchemyEntity.setCensus(census);
    alchemyEntity.setCIAFactbook(ciaFactbook);
    alchemyEntity.setCrunchbase(crunchbase);
    alchemyEntity.setDBPedia(dbPedia);
    alchemyEntity.setFreebase(freebase);
    alchemyEntity.setGeo(geo);
    alchemyEntity.setGeonames(geonames);
    alchemyEntity.setMusicBrainz(musicBrainz);
    alchemyEntity.setName(name);
    alchemyEntity.setOpencyc(opencyc);
    alchemyEntity.setSemanticCrunchbase(semanticCrunchbase);
    alchemyEntity.setText(entityText);
    alchemyEntity.setType(type);
    alchemyEntity.setUmbel(umbel);
    alchemyEntity.setWebsite(website);
    alchemyEntity.setYago(yago);
    for(String subtype : subtypes) {
      alchemyEntity.addSubtype(subtype);
    }

    final SentimentAlchemyEntity sentimentAlchemyEntity = new SentimentAlchemyEntity(isMixed, score, sentimentType.toString());

    final AlchemySubject entity = new AlchemySubject();
    entity.setEntity(alchemyEntity);
    entity.setSentiment(sentimentAlchemyEntity);
    entity.setText(text);

    final String expectedString = new ToStringBuilder(entity, style)
        .append("entity", alchemyEntity.toString(style))
        .append("sentiment", sentimentAlchemyEntity.toString(style))
        .append("text", text)
        .toString();

    final String actualString = entity.toString(style);

    assertEquals(expectedString, actualString);
  }
}
