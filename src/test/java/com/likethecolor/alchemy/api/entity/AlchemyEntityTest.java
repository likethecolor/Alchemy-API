/**
 * File: EntityAlchemyEntityTest.java
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

import com.likethecolor.alchemy.api.Constants;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

public class AlchemyEntityTest {
  @Test
  public void testConstructor() {
    final String type = "Country";
    final String text = "Israel";
    final AlchemyEntity entity = new AlchemyEntity(text, type);

    assertEquals(text, entity.getText());
    assertEquals(type, entity.getType());
    assertNull(entity.getCensus());
    assertNull(entity.getCIAFactbook());
    assertNull(entity.getCrunchbase());
    assertNull(entity.getDBPedia());
    assertNull(entity.getFreebase());
    assertEquals(Constants.DEFAULT_LATITUDE, entity.getLatitude());
    assertEquals(Constants.DEFAULT_LONGITUDE, entity.getLongitude());
    assertNull(entity.getGeo());
    assertNull(entity.getGeonames());
    assertNull(entity.getMusicBrainz());
    assertNull(entity.getName());
    assertNull(entity.getOpencyc());
    assertNull(entity.getSemanticCrunchbase());
    assertNull(entity.getUmbel());
    assertNull(entity.getWebsite());
    assertNull(entity.getYago());

    assertEquals(0, entity.getSubtypeSize());
  }

  @Test
  public void testConstructor_NoArgs() {
    final AlchemyEntity entity = new AlchemyEntity();

    assertNull(entity.getText());
    assertNull(entity.getType());
    assertNull(entity.getCensus());
    assertNull(entity.getCIAFactbook());
    assertNull(entity.getCrunchbase());
    assertNull(entity.getDBPedia());
    assertNull(entity.getFreebase());
    assertEquals(Constants.DEFAULT_LATITUDE, entity.getLatitude());
    assertEquals(Constants.DEFAULT_LONGITUDE, entity.getLongitude());
    assertNull(entity.getGeo());
    assertNull(entity.getGeonames());
    assertNull(entity.getMusicBrainz());
    assertNull(entity.getName());
    assertNull(entity.getOpencyc());
    assertNull(entity.getSemanticCrunchbase());
    assertNull(entity.getUmbel());
    assertNull(entity.getWebsite());
    assertNull(entity.getYago());

    assertEquals(0, entity.getSubtypeSize());
  }

  @Test
  public void testCensus() {
    final String expectedCensus = "http://census.org/resource/Israel";

    final AlchemyEntity entity = new AlchemyEntity();

    entity.setCensus(expectedCensus);

    assertEquals(expectedCensus, entity.getCensus());

    // null - should change value
    entity.setCensus(null);

    assertNull(entity.getCensus());


    // empty string - should change value
    entity.setCensus(expectedCensus);
    entity.setCensus("");

    assertEquals("", entity.getCensus());


    // empty white space string - should change value and be trimmed
    entity.setCensus(expectedCensus);
    entity.setCensus("\t   ");

    assertEquals("", entity.getCensus());


    // should be trimmed
    entity.setCensus("\t   " + expectedCensus + " ");

    assertEquals(expectedCensus, entity.getCensus());
  }

  @Test
  public void testCIAFactbook() {
    final String expectedCIAFactbook = "http://www4.wiwiss.fu-berlin.de/factbook/resource/Israel";

    final AlchemyEntity entity = new AlchemyEntity();

    entity.setCIAFactbook(expectedCIAFactbook);

    assertEquals(expectedCIAFactbook, entity.getCIAFactbook());

    // null - should change value
    entity.setCIAFactbook(null);

    assertNull(entity.getCIAFactbook());


    // empty string - should change value
    entity.setCIAFactbook(expectedCIAFactbook);
    entity.setCIAFactbook("");

    assertEquals("", entity.getCIAFactbook());


    // empty white space string - should change value and be trimmed
    entity.setCIAFactbook(expectedCIAFactbook);
    entity.setCIAFactbook("\t   ");

    assertEquals("", entity.getCIAFactbook());


    // should be trimmed
    entity.setCIAFactbook("\t   " + expectedCIAFactbook + " ");

    assertEquals(expectedCIAFactbook, entity.getCIAFactbook());
  }

  @Test
  public void testCrunchbase() {
    final String expectedCrunchbase = "http://crunchbase.com/resource/Israel";

    final AlchemyEntity entity = new AlchemyEntity();

    entity.setCrunchbase(expectedCrunchbase);

    assertEquals(expectedCrunchbase, entity.getCrunchbase());

    // null - should change value
    entity.setCrunchbase(null);

    assertNull(entity.getCrunchbase());


    // empty string - should change value
    entity.setCrunchbase(expectedCrunchbase);
    entity.setCrunchbase("");

    assertEquals("", entity.getCrunchbase());


    // empty white space string - should change value and be trimmed
    entity.setCrunchbase(expectedCrunchbase);
    entity.setCrunchbase("\t   ");

    assertEquals("", entity.getCrunchbase());


    // should be trimmed
    entity.setCrunchbase("\t   " + expectedCrunchbase + " ");

    assertEquals(expectedCrunchbase, entity.getCrunchbase());
  }

  @Test
  public void testDBPedia() {
    final String expectedDBPedia = "http://dbpedia.org/resource/Israel";

    final AlchemyEntity entity = new AlchemyEntity();

    entity.setDBPedia(expectedDBPedia);

    assertEquals(expectedDBPedia, entity.getDBPedia());

    // null - should change value
    entity.setDBPedia(null);

    assertNull(entity.getDBPedia());


    // empty string - should change value
    entity.setDBPedia(expectedDBPedia);
    entity.setDBPedia("");

    assertEquals("", entity.getDBPedia());


    // empty white space string - should change value and be trimmed
    entity.setDBPedia(expectedDBPedia);
    entity.setDBPedia("\t   ");

    assertEquals("", entity.getDBPedia());


    // should be trimmed
    entity.setDBPedia("\t   " + expectedDBPedia + " ");

    assertEquals(expectedDBPedia, entity.getDBPedia());
  }

  @Test
  public void testFreebase() {
    final String expectedFreebase = "http://rdf.freebase.com/ns/guid.9202a8c04000641f800000000001e2be";

    final AlchemyEntity entity = new AlchemyEntity();

    entity.setFreebase(expectedFreebase);

    assertEquals(expectedFreebase, entity.getFreebase());

    // null - should change value
    entity.setFreebase(null);

    assertNull(entity.getFreebase());


    // empty string - should change value
    entity.setFreebase(expectedFreebase);
    entity.setFreebase("");

    assertEquals("", entity.getFreebase());


    // empty white space string - should change value and be trimmed
    entity.setFreebase(expectedFreebase);
    entity.setFreebase("\t   ");

    assertEquals("", entity.getFreebase());


    // should be trimmed
    entity.setFreebase("\t   " + expectedFreebase + " ");

    assertEquals(expectedFreebase, entity.getFreebase());
  }

  @Test
  public void testGeo() {
    final Double expectedLatitude = 31.0D;
    final Double expectedLongitude = 35.0D;
    final String expectedGeo = expectedLatitude + " " + expectedLongitude;

    final AlchemyEntity entity = new AlchemyEntity();

    entity.setGeo(expectedGeo);

    assertEquals(expectedGeo, entity.getGeo());
    assertEquals(expectedLatitude, entity.getLatitude());
    assertEquals(expectedLongitude, entity.getLongitude());


    // null - should change value
    entity.setGeo(null);

    assertNull(entity.getGeo());
    assertEquals(Constants.DEFAULT_LATITUDE, entity.getLatitude());
    assertEquals(Constants.DEFAULT_LONGITUDE, entity.getLongitude());


    // empty string - should change value
    entity.setGeo(expectedGeo);
    entity.setGeo("");

    assertEquals("", entity.getGeo());
    assertEquals(Constants.DEFAULT_LATITUDE, entity.getLatitude());
    assertEquals(Constants.DEFAULT_LONGITUDE, entity.getLongitude());


    // empty white space string - should change value and be trimmed
    entity.setGeo(expectedGeo);
    entity.setGeo("\t    \n\r  ");

    assertEquals("", entity.getGeo());
    assertEquals(Constants.DEFAULT_LATITUDE, entity.getLatitude());
    assertEquals(Constants.DEFAULT_LONGITUDE, entity.getLongitude());


    // should be trimmed - inside and out
    entity.setGeo("\t  " + expectedLatitude + "  \t   \n  " + expectedLongitude);

    assertEquals(expectedGeo, entity.getGeo());
    assertEquals(expectedLatitude, entity.getLatitude());
    assertEquals(expectedLongitude, entity.getLongitude());


    // value has no spaces - i.e., a single value - should not change value
    entity.setGeo(expectedGeo);
    entity.setGeo("\t  " + expectedLatitude);

    assertEquals(expectedGeo, entity.getGeo());
    assertEquals(expectedLatitude, entity.getLatitude());
    assertEquals(expectedLongitude, entity.getLongitude());
  }

  @Test
  public void testGeonames() {
    final String expectedGeonames = "http://geonames.com/Israel";

    final AlchemyEntity entity = new AlchemyEntity();

    entity.setGeonames(expectedGeonames);

    assertEquals(expectedGeonames, entity.getGeonames());

    // null - should change value
    entity.setGeonames(null);

    assertNull(entity.getGeonames());


    // empty string - should change value
    entity.setGeonames(expectedGeonames);
    entity.setGeonames("");

    assertEquals("", entity.getGeonames());


    // empty white space string - should change value and be trimmed
    entity.setGeonames(expectedGeonames);
    entity.setGeonames("\t   ");

    assertEquals("", entity.getGeonames());


    // should be trimmed
    entity.setGeonames("\t   " + expectedGeonames + " ");

    assertEquals(expectedGeonames, entity.getGeonames());
  }

  @Test
  public void testLatitude() {
    final Double expectedLatitude = 35.123D;

    final AlchemyEntity entity = new AlchemyEntity();

    entity.setLatitude(expectedLatitude);

    assertEquals(expectedLatitude, entity.getLatitude());
  }

  @Test
  public void testLatitude_String() {
    final Double expectedLatitude = 35.123D;
    final String latitude = expectedLatitude.toString();

    final AlchemyEntity entity = new AlchemyEntity();

    entity.setLatitude(latitude);

    assertEquals(expectedLatitude, entity.getLatitude());

    // null - should not change value
    entity.setLatitude(latitude);
    entity.setLatitude(null);

    assertEquals(expectedLatitude, entity.getLatitude());

    // empty string - should not change value
    entity.setLatitude(latitude);
    entity.setLatitude("");

    assertEquals(expectedLatitude, entity.getLatitude());

    // empty white space string - should not change value
    entity.setLatitude(latitude);
    entity.setLatitude("\t   \r\n  ");

    assertEquals(expectedLatitude, entity.getLatitude());

    // should be trimmed
    entity.setLatitude("\t   \r\n  \n\n" + latitude + "   ");

    assertEquals(expectedLatitude, entity.getLatitude());

    // non-number - should not change value
    entity.setLatitude(latitude);
    entity.setLatitude("foo");

    assertEquals(expectedLatitude, entity.getLatitude());
  }

  @Test
  public void testLongitude() {
    final Double expectedLongitude = 23.3345D;

    final AlchemyEntity entity = new AlchemyEntity();

    entity.setLongitude(expectedLongitude);

    assertEquals(expectedLongitude, entity.getLongitude());
  }

  @Test
  public void testLongitude_String() {
    final Double expectedLongitude = -22.87D;
    final String longitude = expectedLongitude.toString();

    final AlchemyEntity entity = new AlchemyEntity();

    entity.setLongitude(longitude);

    assertEquals(expectedLongitude, entity.getLongitude());

    // null - should not change value
    entity.setLongitude(longitude);
    entity.setLongitude(null);

    assertEquals(expectedLongitude, entity.getLongitude());

    // empty string - should not change value
    entity.setLongitude(longitude);
    entity.setLongitude("");

    assertEquals(expectedLongitude, entity.getLongitude());

    // empty white space string - should not change value
    entity.setLongitude(longitude);
    entity.setLongitude("\t   \r\n  ");

    assertEquals(expectedLongitude, entity.getLongitude());

    // should be trimmed
    entity.setLongitude("\t   \r\n  \n\n" + longitude + "   ");

    assertEquals(expectedLongitude, entity.getLongitude());

    // non-number - should not change value
    entity.setLongitude(longitude);
    entity.setLongitude("foo");

    assertEquals(expectedLongitude, entity.getLongitude());
  }

  @Test
  public void testMusicBrainz() {
    final String expectedMusicBrainz = "http://musicbrainz.com/Israel";

    final AlchemyEntity entity = new AlchemyEntity();

    entity.setMusicBrainz(expectedMusicBrainz);

    assertEquals(expectedMusicBrainz, entity.getMusicBrainz());

    // null - should change value
    entity.setMusicBrainz(null);

    assertNull(entity.getMusicBrainz());


    // empty string - should change value
    entity.setMusicBrainz(expectedMusicBrainz);
    entity.setMusicBrainz("");

    assertEquals("", entity.getMusicBrainz());


    // empty white space string - should change value and be trimmed
    entity.setMusicBrainz(expectedMusicBrainz);
    entity.setMusicBrainz("\t   ");

    assertEquals("", entity.getMusicBrainz());


    // should be trimmed
    entity.setMusicBrainz("\t   " + expectedMusicBrainz + " ");

    assertEquals(expectedMusicBrainz, entity.getMusicBrainz());
  }

  @Test
  public void testName() {
    final String expectedName = "Israel";

    final AlchemyEntity entity = new AlchemyEntity();

    entity.setName(expectedName);

    assertEquals(expectedName, entity.getName());

    // null - should change value
    entity.setName(null);

    assertNull(entity.getName());


    // empty string - should change value
    entity.setName(expectedName);
    entity.setName("");

    assertEquals("", entity.getName());


    // empty white space string - should change value and be trimmed
    entity.setName(expectedName);
    entity.setName("\t   ");

    assertEquals("", entity.getName());


    // should be trimmed
    entity.setName("\t   " + expectedName + " ");

    assertEquals(expectedName, entity.getName());
  }

  @Test
  public void testOpencyc() {
    final String expectedOpencyc = "http://sw.opencyc.org/concept/Mx4rvViP55wpEbGdrcN5Y29ycA";

    final AlchemyEntity entity = new AlchemyEntity();

    entity.setOpencyc(expectedOpencyc);

    assertEquals(expectedOpencyc, entity.getOpencyc());

    // null - should change value
    entity.setOpencyc(null);

    assertNull(entity.getOpencyc());


    // empty string - should change value
    entity.setOpencyc(expectedOpencyc);
    entity.setOpencyc("");

    assertEquals("", entity.getOpencyc());


    // empty white space string - should change value and be trimmed
    entity.setOpencyc(expectedOpencyc);
    entity.setOpencyc("\t   ");

    assertEquals("", entity.getOpencyc());


    // should be trimmed
    entity.setOpencyc("\t   " + expectedOpencyc + " ");

    assertEquals(expectedOpencyc, entity.getOpencyc());
  }

  @Test
  public void testSemanticCrunchbase() {
    final String expectedSemanticCrunchbase = "http://semanticcrunchbase.com/concept/Mx4rvViP55wpEbGdrcN5Y29ycA";

    final AlchemyEntity entity = new AlchemyEntity();

    entity.setSemanticCrunchbase(expectedSemanticCrunchbase);

    assertEquals(expectedSemanticCrunchbase, entity.getSemanticCrunchbase());

    // null - should change value
    entity.setSemanticCrunchbase(null);

    assertNull(entity.getSemanticCrunchbase());


    // empty string - should change value
    entity.setSemanticCrunchbase(expectedSemanticCrunchbase);
    entity.setSemanticCrunchbase("");

    assertEquals("", entity.getSemanticCrunchbase());


    // empty white space string - should change value and be trimmed
    entity.setSemanticCrunchbase(expectedSemanticCrunchbase);
    entity.setSemanticCrunchbase("\t   ");

    assertEquals("", entity.getSemanticCrunchbase());


    // should be trimmed
    entity.setSemanticCrunchbase("\t   " + expectedSemanticCrunchbase + " ");

    assertEquals(expectedSemanticCrunchbase, entity.getSemanticCrunchbase());
  }

  @Test
  public void testSubtypes_OneSubtype() {
    final List<String> subtypes = new ArrayList<String>();
    subtypes.add("Location");

    final AlchemyEntity entity = new AlchemyEntity();
    for(String subtype : subtypes) {
      entity.addSubtype(subtype);
    }

    assertEquals(subtypes.size(), entity.getSubtypeSize());

    int subtypeIndex = 0;
    Iterator<String> iter = entity.subtypeIterator();
    while(iter.hasNext()) {
      assertEquals(subtypes.get(subtypeIndex), iter.next());
      subtypeIndex++;
    }
  }

  @Test
  public void testSubtypes_TwoSubtypes() {
    final List<String> subtypes = new ArrayList<String>();
    subtypes.add("Location");
    subtypes.add("Country");

    final AlchemyEntity entity = new AlchemyEntity();
    for(String subtype : subtypes) {
      entity.addSubtype(subtype);
    }

    assertEquals(subtypes.size(), entity.getSubtypeSize());

    int subtypeIndex = 0;
    Iterator<String> iter = entity.subtypeIterator();
    while(iter.hasNext()) {
      assertEquals(subtypes.get(subtypeIndex), iter.next());
      subtypeIndex++;
    }
  }

  @Test
  public void testSubtypes_ThreeSubtypes() {
    final List<String> subtypes = new ArrayList<String>();
    subtypes.add("Location");
    subtypes.add("Country");
    subtypes.add("GovernmentalJurisdiction");

    final AlchemyEntity entity = new AlchemyEntity();
    for(String subtype : subtypes) {
      entity.addSubtype(subtype);
    }

    assertEquals(subtypes.size(), entity.getSubtypeSize());

    int subtypeIndex = 0;
    Iterator<String> iter = entity.subtypeIterator();
    while(iter.hasNext()) {
      assertEquals(subtypes.get(subtypeIndex), iter.next());
      subtypeIndex++;
    }
  }

  @Test
  public void testSubtypes_FourSubtypes_DuplicatesAndNulls() {
    final List<String> subtypes = new ArrayList<String>();
    subtypes.add("Location");
    subtypes.add("Country");
    subtypes.add("GovernmentalJurisdiction");
    subtypes.add("FilmArtDirector");

    final AlchemyEntity entity = new AlchemyEntity();
    for(String subtype : subtypes) {
      entity.addSubtype(subtype);
      entity.addSubtype(null);
      entity.addSubtype(subtype);
    }

    assertEquals(subtypes.size(), entity.getSubtypeSize());

    int subtypeIndex = 0;
    Iterator<String> iter = entity.subtypeIterator();
    while(iter.hasNext()) {
      assertEquals(subtypes.get(subtypeIndex), iter.next());
      subtypeIndex++;
    }
  }

  @Test
  public void testText() {
    final String text = "Israel";

    final AlchemyEntity entity = new AlchemyEntity();

    entity.setText(text);

    String actualText = entity.getText();

    assertEquals(actualText, entity.getText());

    // null - should change value
    entity.setText(null);

    actualText = entity.getText();

    assertNull(actualText);

    // empty string - should change value
    entity.setText(text);
    entity.setText("");

    actualText = entity.getText();

    assertEquals("", actualText);

    // empty white space string - should change value and be trimmed
    entity.setText(text);
    entity.setText("\t  \t\r\n");

    actualText = entity.getText();

    assertEquals("", actualText);

    // should trim
    entity.setText("\n\r  " + text + "   \t  ");

    actualText = entity.getText();

    assertEquals(text, actualText);
  }

  @Test
  public void testType() {
    final String type = "Country";

    final AlchemyEntity entity = new AlchemyEntity();

    entity.setType(type);

    String actualType = entity.getType();

    assertEquals(actualType, entity.getType());

    // null - should change value
    entity.setType(null);

    actualType = entity.getType();

    assertNull(actualType);

    // empty string - should change value
    entity.setType(type);
    entity.setType("");

    actualType = entity.getType();

    assertEquals("", actualType);

    // empty white space string - should change value and be trimmed
    entity.setType(type);
    entity.setType("\t  \t\r\n");

    actualType = entity.getType();

    assertEquals("", actualType);

    // should trim
    entity.setType("\n\r  " + type + "   \t  ");

    actualType = entity.getType();

    assertEquals(type, actualType);
  }

  @Test
  public void testUmbel() {
    final String expectedUmbel = "http://umbel.org/umbel/ne/wikipedia/Israel";

    final AlchemyEntity entity = new AlchemyEntity();

    entity.setUmbel(expectedUmbel);

    assertEquals(expectedUmbel, entity.getUmbel());

    // null - should change value
    entity.setUmbel(null);

    assertNull(entity.getUmbel());


    // empty string - should change value
    entity.setUmbel(expectedUmbel);
    entity.setUmbel("");

    assertEquals("", entity.getUmbel());


    // empty white space string - should change value and be trimmed
    entity.setUmbel(expectedUmbel);
    entity.setUmbel("\t   ");

    assertEquals("", entity.getUmbel());


    // should be trimmed
    entity.setUmbel("\t   " + expectedUmbel + " ");

    assertEquals(expectedUmbel, entity.getUmbel());
  }

  @Test
  public void testWebsite() {
    final String expectedWebsite = "http://www.knesset.gov.il/";

    final AlchemyEntity entity = new AlchemyEntity();

    entity.setWebsite(expectedWebsite);

    assertEquals(expectedWebsite, entity.getWebsite());

    // null - should change value
    entity.setWebsite(null);

    assertNull(entity.getWebsite());


    // empty string - should change value
    entity.setWebsite(expectedWebsite);
    entity.setWebsite("");

    assertEquals("", entity.getWebsite());


    // empty white space string - should change value and be trimmed
    entity.setWebsite(expectedWebsite);
    entity.setWebsite("\t   ");

    assertEquals("", entity.getWebsite());


    // should be trimmed
    entity.setWebsite("\t   " + expectedWebsite + " ");

    assertEquals(expectedWebsite, entity.getWebsite());
  }

  @Test
  public void testYago() {
    final String expectedYago = "http://mpii.de/yago/resource/Israel";

    final AlchemyEntity entity = new AlchemyEntity();

    entity.setYago(expectedYago);

    assertEquals(expectedYago, entity.getYago());

    // null - should change value
    entity.setYago(null);

    assertNull(entity.getYago());


    // empty string - should change value
    entity.setYago(expectedYago);
    entity.setYago("");

    assertEquals("", entity.getYago());


    // empty white space string - should change value and be trimmed
    entity.setYago(expectedYago);
    entity.setYago("\t   ");

    assertEquals("", entity.getYago());


    // should be trimmed
    entity.setYago("\t   " + expectedYago + " ");

    assertEquals(expectedYago, entity.getYago());
  }

  @Test
  public void testClone() {
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
    final Double score = 0.9834D;
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
    subtypes.add("FilmArtDirector");

    final AlchemyEntity entity = new AlchemyEntity();
    AlchemyEntity clone = new AlchemyEntity();

    assertEquals(entity, clone);
    assertNotSame(entity, clone);


    entity.setCensus(census);
    clone = entity.clone();

    assertEquals(entity, clone);
    assertNotSame(entity, clone);


    entity.setCIAFactbook(ciaFactbook);
    clone = entity.clone();

    assertEquals(entity, clone);
    assertNotSame(entity, clone);


    entity.setCrunchbase(crunchbase);
    clone = entity.clone();

    assertEquals(entity, clone);
    assertNotSame(entity, clone);


    entity.setDBPedia(dbPedia);
    clone = entity.clone();

    assertEquals(entity, clone);
    assertNotSame(entity, clone);


    entity.setFreebase(freebase);
    clone = entity.clone();

    assertEquals(entity, clone);
    assertNotSame(entity, clone);


    entity.setGeo(geo);
    clone = entity.clone();

    assertEquals(entity, clone);
    assertNotSame(entity, clone);


    entity.setGeonames(geonames);
    clone = entity.clone();

    assertEquals(entity, clone);
    assertNotSame(entity, clone);


    entity.setMusicBrainz(musicBrainz);
    clone = entity.clone();

    assertEquals(entity, clone);
    assertNotSame(entity, clone);


    entity.setName(name);
    clone = entity.clone();

    assertEquals(entity, clone);
    assertNotSame(entity, clone);


    entity.setOpencyc(opencyc);
    clone = entity.clone();

    assertEquals(entity, clone);
    assertNotSame(entity, clone);


    entity.setSemanticCrunchbase(semanticCrunchbase);
    clone = entity.clone();

    assertEquals(entity, clone);
    assertNotSame(entity, clone);


    entity.setText(text);
    clone = entity.clone();

    assertEquals(entity, clone);
    assertNotSame(entity, clone);


    entity.setType(type);
    clone = entity.clone();

    assertEquals(entity, clone);
    assertNotSame(entity, clone);


    entity.setUmbel(umbel);
    clone = entity.clone();

    assertEquals(entity, clone);
    assertNotSame(entity, clone);


    entity.setWebsite(website);
    clone = entity.clone();

    assertEquals(entity, clone);
    assertNotSame(entity, clone);


    entity.setYago(yago);
    clone = entity.clone();

    assertEquals(entity, clone);
    assertNotSame(entity, clone);


    entity.addSubtype(subtypes.get(0));
    clone = entity.clone();

    assertEquals(entity, clone);
    assertNotSame(entity, clone);


    entity.addSubtype(subtypes.get(1));
    clone = entity.clone();

    assertEquals(entity, clone);
    assertNotSame(entity, clone);


    entity.addSubtype(subtypes.get(2));
    clone = entity.clone();

    assertEquals(entity, clone);
    assertNotSame(entity, clone);


    entity.addSubtype(subtypes.get(3));
    clone = entity.clone();

    assertEquals(entity, clone);
    assertNotSame(entity, clone);
  }

  @Test
  public void testEquals() {
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

    final AlchemyEntity entity = new AlchemyEntity();

    assertFalse(entity.equals(null));
    assertFalse(entity.equals(new Double(1312D)));

    assertTrue(entity.equals(entity));
    assertEquals(entity, entity);
    assertSame(entity, entity);


    final AlchemyEntity other = new AlchemyEntity();

    assertTrue(entity.equals(other));
    assertEquals(entity, other);
    assertNotSame(entity, other);


    // census
    entity.setCensus(null);
    other.setCensus(census + "foo");

    assertFalse(entity.equals(other));
    assertNotSame(entity, other);


    entity.setCensus(census);

    assertFalse(entity.equals(other));
    assertNotSame(entity, other);


    other.setCensus(census);

    assertTrue(entity.equals(other));
    assertEquals(entity, other);
    assertNotSame(entity, other);


    // ciaFactbook
    entity.setCIAFactbook(null);
    other.setCIAFactbook(ciaFactbook + "foo");

    assertFalse(entity.equals(other));
    assertNotSame(entity, other);


    entity.setCIAFactbook(ciaFactbook);

    assertFalse(entity.equals(other));
    assertNotSame(entity, other);


    other.setCIAFactbook(ciaFactbook);

    assertTrue(entity.equals(other));
    assertEquals(entity, other);
    assertNotSame(entity, other);


    // crunchbase
    entity.setCrunchbase(null);
    other.setCrunchbase(crunchbase + "foo");

    assertFalse(entity.equals(other));
    assertNotSame(entity, other);


    entity.setCrunchbase(crunchbase);

    assertFalse(entity.equals(other));
    assertNotSame(entity, other);


    other.setCrunchbase(crunchbase);

    assertTrue(entity.equals(other));
    assertEquals(entity, other);
    assertNotSame(entity, other);


    // dbPedia
    entity.setDBPedia(null);
    other.setDBPedia(dbPedia + "foo");

    assertFalse(entity.equals(other));
    assertNotSame(entity, other);


    entity.setDBPedia(dbPedia);

    assertFalse(entity.equals(other));
    assertNotSame(entity, other);


    other.setDBPedia(dbPedia);

    assertTrue(entity.equals(other));
    assertEquals(entity, other);
    assertNotSame(entity, other);


    // freebase
    entity.setFreebase(null);
    other.setFreebase(freebase + "foo");

    assertFalse(entity.equals(other));
    assertNotSame(entity, other);


    entity.setFreebase(freebase);

    assertFalse(entity.equals(other));
    assertNotSame(entity, other);


    other.setFreebase(freebase);

    assertTrue(entity.equals(other));
    assertEquals(entity, other);
    assertNotSame(entity, other);


    // geo
    entity.setGeo(null);
    other.setGeo(geo + "foo");

    assertFalse(entity.equals(other));
    assertNotSame(entity, other);


    entity.setGeo(geo);

    assertFalse(entity.equals(other));
    assertNotSame(entity, other);


    other.setGeo(geo);

    assertTrue(entity.equals(other));
    assertEquals(entity, other);
    assertNotSame(entity, other);


    // geonames
    entity.setGeonames(null);
    other.setGeonames(geonames + "foo");

    assertFalse(entity.equals(other));
    assertNotSame(entity, other);


    entity.setGeonames(geonames);

    assertFalse(entity.equals(other));
    assertNotSame(entity, other);


    other.setGeonames(geonames);

    assertTrue(entity.equals(other));
    assertEquals(entity, other);
    assertNotSame(entity, other);


    // latitude
    entity.setGeo(null);
    other.setGeo(null);
    entity.setLatitude(latitude);

    assertFalse(entity.equals(other));
    assertNotSame(entity, other);


    other.setLatitude(latitude);

    assertTrue(entity.equals(other));
    assertEquals(entity, other);
    assertNotSame(entity, other);


    // longitude
    entity.setGeo(null);
    other.setGeo(null);
    entity.setLongitude(longitude);

    assertFalse(entity.equals(other));
    assertNotSame(entity, other);


    other.setLongitude(longitude);

    assertTrue(entity.equals(other));
    assertEquals(entity, other);
    assertNotSame(entity, other);


    // musicBrainz
    entity.setMusicBrainz(null);
    other.setMusicBrainz(musicBrainz + "foo");

    assertFalse(entity.equals(other));
    assertNotSame(entity, other);


    entity.setMusicBrainz(musicBrainz);

    assertFalse(entity.equals(other));
    assertNotSame(entity, other);


    other.setMusicBrainz(musicBrainz);

    assertTrue(entity.equals(other));
    assertEquals(entity, other);
    assertNotSame(entity, other);


    // name
    entity.setName(null);
    other.setName(name + "foo");

    assertFalse(entity.equals(other));
    assertNotSame(entity, other);


    entity.setName(name);

    assertFalse(entity.equals(other));
    assertNotSame(entity, other);


    other.setName(name);

    assertTrue(entity.equals(other));
    assertEquals(entity, other);
    assertNotSame(entity, other);


    // opencyc
    entity.setOpencyc(null);
    other.setOpencyc(opencyc + "foo");

    assertFalse(entity.equals(other));
    assertNotSame(entity, other);


    entity.setOpencyc(opencyc);

    assertFalse(entity.equals(other));
    assertNotSame(entity, other);


    other.setOpencyc(opencyc);

    assertTrue(entity.equals(other));
    assertEquals(entity, other);
    assertNotSame(entity, other);


    // semanticCrunchbase
    entity.setSemanticCrunchbase(null);
    other.setSemanticCrunchbase(semanticCrunchbase + "foo");

    assertFalse(entity.equals(other));
    assertNotSame(entity, other);


    entity.setSemanticCrunchbase(semanticCrunchbase);

    assertFalse(entity.equals(other));
    assertNotSame(entity, other);


    other.setSemanticCrunchbase(semanticCrunchbase);

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


    // type
    entity.setType(null);
    other.setType(type + "foo");

    assertFalse(entity.equals(other));
    assertNotSame(entity, other);


    entity.setType(type);

    assertFalse(entity.equals(other));
    assertNotSame(entity, other);


    other.setType(type);

    assertTrue(entity.equals(other));
    assertEquals(entity, other);
    assertNotSame(entity, other);


    // umbel
    entity.setUmbel(null);
    other.setUmbel(umbel + "foo");

    assertFalse(entity.equals(other));
    assertNotSame(entity, other);


    entity.setUmbel(umbel);

    assertFalse(entity.equals(other));
    assertNotSame(entity, other);


    other.setUmbel(umbel);

    assertTrue(entity.equals(other));
    assertEquals(entity, other);
    assertNotSame(entity, other);


    // website
    entity.setWebsite(null);
    other.setWebsite(website + "foo");

    assertFalse(entity.equals(other));
    assertNotSame(entity, other);


    entity.setWebsite(website);

    assertFalse(entity.equals(other));
    assertNotSame(entity, other);


    other.setWebsite(website);

    assertTrue(entity.equals(other));
    assertEquals(entity, other);
    assertNotSame(entity, other);


    // yago
    entity.setYago(null);
    other.setYago(yago + "foo");

    assertFalse(entity.equals(other));
    assertNotSame(entity, other);


    entity.setYago(yago);

    assertFalse(entity.equals(other));
    assertNotSame(entity, other);


    other.setYago(yago);

    assertTrue(entity.equals(other));
    assertEquals(entity, other);
    assertNotSame(entity, other);


    // subtypes
    // cannot test everything since null entities cannot be added
    // and no entity can be removed
    entity.addSubtype(subtypes.get(0));

    assertFalse(entity.equals(other));
    assertNotSame(entity, other);


    other.addSubtype(subtypes.get(0));

    assertTrue(entity.equals(other));
    assertEquals(entity, other);
    assertNotSame(entity, other);


    // subtypes - add null entity - should not change the number of entities
    entity.addSubtype(null);

    assertTrue(entity.equals(other));
    assertEquals(entity, other);
    assertNotSame(entity, other);


    // subtypes - add subtype that already exists
    other.addSubtype(subtypes.get(0));

    assertTrue(entity.equals(other));
    assertEquals(entity, other);
    assertNotSame(entity, other);


    entity.addSubtype(subtypes.get(1));

    assertFalse(entity.equals(other));
    assertNotSame(entity, other);


    other.addSubtype(subtypes.get(1));

    assertTrue(entity.equals(other));
    assertEquals(entity, other);
    assertNotSame(entity, other);


    entity.addSubtype(subtypes.get(2));

    assertFalse(entity.equals(other));
    assertNotSame(entity, other);


    other.addSubtype(subtypes.get(2));

    assertTrue(entity.equals(other));
    assertEquals(entity, other);
    assertNotSame(entity, other);
  }

  @Test
  public void testToString() {
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

    final AlchemyEntity entity = new AlchemyEntity();
    entity.setCensus(census);
    entity.setCIAFactbook(ciaFactbook);
    entity.setCrunchbase(crunchbase);
    entity.setDBPedia(dbPedia);
    entity.setFreebase(freebase);
    entity.setGeo(geo);
    entity.setGeonames(geonames);
    entity.setMusicBrainz(musicBrainz);
    entity.setName(name);
    entity.setOpencyc(opencyc);
    entity.setSemanticCrunchbase(semanticCrunchbase);
    entity.setText(text);
    entity.setType(type);
    entity.setUmbel(umbel);
    entity.setWebsite(website);
    entity.setYago(yago);
    for(String subtype : subtypes) {
      entity.addSubtype(subtype);
    }

    final DisambiguatedAlchemyEntity disambiguatedAlchemyEntity = entity.getDisambiguatedAlchemyEntity();

    final String expectedString = new ToStringBuilder(entity)
        .append("text", text)
        .append("type", type)
        .append(disambiguatedAlchemyEntity.toString())
        .toString();

    final String actualString = entity.toString();

    assertEquals(expectedString, actualString);
  }

  @Test
  public void testToString_Formatted() {
    final ToStringStyle style = ToStringStyle.MULTI_LINE_STYLE;
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
    final String type = "Country";
    final String text = "Israel";
    final String semanticCrunchbase = "http://semanticcrunchbase.com/concept/Mx4rvViP55wpEbGdrcN5Y29ycA";
    final String umbel = "http://umbel.org/umbel/ne/wikipedia/Israel";
    final String website = "http://www.knesset.gov.il/";
    final String yago = "http://mpii.de/yago/resource/Israel";
    final List<String> subtypes = new ArrayList<String>();
    subtypes.add("Location");
    subtypes.add("Country");
    subtypes.add("GovernmentalJurisdiction");

    final AlchemyEntity entity = new AlchemyEntity();
    entity.setCensus(census);
    entity.setCIAFactbook(ciaFactbook);
    entity.setCrunchbase(crunchbase);
    entity.setDBPedia(dbPedia);
    entity.setFreebase(freebase);
    entity.setGeo(geo);
    entity.setGeonames(geonames);
    entity.setMusicBrainz(musicBrainz);
    entity.setName(name);
    entity.setOpencyc(opencyc);
    entity.setSemanticCrunchbase(semanticCrunchbase);
    entity.setText(text);
    entity.setType(type);
    entity.setUmbel(umbel);
    entity.setWebsite(website);
    entity.setYago(yago);
    for(String subtype : subtypes) {
      entity.addSubtype(subtype);
    }

    final DisambiguatedAlchemyEntity disambiguatedAlchemyEntity = entity.getDisambiguatedAlchemyEntity();

    final String expectedString = new ToStringBuilder(entity, style)
        .append("text", text)
        .append("type", type)
        .append(disambiguatedAlchemyEntity.toString(style))
        .toString();

    final String actualString = entity.toString(style);

    assertEquals(expectedString, actualString);
  }
}
