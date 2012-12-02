/**
 * File: DisambiguatedParserTest.java
 * Original Author: Dan Brown <dan@likethecolor.com>
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
package com.likethecolor.alchemy.api.parser.json;

import com.likethecolor.alchemy.api.entity.DisambiguatedAlchemyEntity;
import org.json.JSONObject;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.assertEquals;

public class DisambiguatedParserTest {
  private static final String SUBTYPE0 = "Location";
  private static final String SUBTYPE1 = "Region";
  private static final String SUBTYPE2 = "AdministrativeDivision";
  private static final String SUBTYPE3 = "GovernmentalJurisdiction";
  private static final String SUBTYPE4 = "FilmEditor";
  private static final String DISAMBIGUATED_NAME = "United States";
  private static final String CENSUS = "http://census.org/United_States";
  private static final String CIA_FACTBOOK = "http://www4.wiwiss.fu-berlin.de/factbook/resource/United_States";
  private static final String CRUNCHBASE = "http://crunchbase.org/United_States";
  private static final String DBPEDIA = "http://dbpedia.org/resource/United_States";
  private static final String FREEBASE = "http://rdf.freebase.com/ns/guid.9202a8c04000641f8000000000959f60";
  private static final String GEO = "38.889722222222225 -77.00888888888889";
  private static final Double LATITUDE = 38.889722222222225D;
  private static final Double LONGITUDE = -77.00888888888889D;
  private static final String GEONAMES = "http://rdf.freebase.com/ns/guid.9202a8c04000641f8000000000959f60";
  private static final String MUSIC_BRAINZ = "http://www.musicbrainz.org/United_States/";
  private static final String OPENCYC = "http://sw.opencyc.org/concept/Mx4rvVikKpwpEbGdrcN5Y29ycA";
  private static final String SEMANTIC_CRUNCHBASE = "http://semanticcrunchbase.org/United_States";
  private static final String UMBEL = "http://umbel.org/United_States";
  private static final String WEBSITE = "http://www.usa.gov/";
  private static final String YAGO = "http://mpii.de/yago/resource/United_States";

  @Test
  public void testGetEntity() {
    final DisambiguatedEntityParser parser = new DisambiguatedEntityParser();
    parser.parse(getJsonString());

    final JSONObject jsonObject = parser.getJSONObject();

    DisambiguatedAlchemyEntity entity = parser.getEntity(jsonObject);

    assertEquals(DISAMBIGUATED_NAME, entity.getName());
    assertEquals(CENSUS, entity.getCensus());
    assertEquals(CIA_FACTBOOK, entity.getCIAFactbook());
    assertEquals(CRUNCHBASE, entity.getCrunchbase());
    assertEquals(DBPEDIA, entity.getDBPedia());
    assertEquals(FREEBASE, entity.getFreebase());
    assertEquals(LATITUDE, entity.getLatitude());
    assertEquals(LONGITUDE, entity.getLongitude());
    assertEquals(GEONAMES, entity.getGeonames());
    assertEquals(MUSIC_BRAINZ, entity.getMusicBrainz());
    assertEquals(OPENCYC, entity.getOpencyc());
    assertEquals(SEMANTIC_CRUNCHBASE, entity.getSemanticCrunchbase());
    assertEquals(UMBEL, entity.getUmbel());
    assertEquals(WEBSITE, entity.getWebsite());
    assertEquals(YAGO, entity.getYago());

    assertEquals(5, entity.getSubtypeSize());
    Iterator<String> subtypes = entity.subtypeIterator();
    assertEquals(SUBTYPE0, subtypes.next());
    assertEquals(SUBTYPE1, subtypes.next());
    assertEquals(SUBTYPE2, subtypes.next());
    assertEquals(SUBTYPE3, subtypes.next());
    assertEquals(SUBTYPE4, subtypes.next());
  }

  /**
   * Has both concept and score.
   */
  private String getJsonString() {
    return "{\"" + JSONConstants.DISAMBIGUATED_SUBTYPE_KEY + "\":" +
           "[\"" + SUBTYPE0 + "\"," +
           "\"" + SUBTYPE1 + "\"," +
           "\"" + SUBTYPE2 + "\"," +
           "\"" + SUBTYPE3 + "\"," +
           "\"" + SUBTYPE4 + "\"]," +
           "\"" + JSONConstants.DISAMBIGUATED_NAME_KEY + "\": \"" + DISAMBIGUATED_NAME + "\"," +
           "\"" + JSONConstants.DISAMBIGUATED_CENSUS_KEY + "\": \"" + CENSUS + "\"," +
           "\"" + JSONConstants.DISAMBIGUATED_CIA_FACTBOOK_KEY + "\": \"" + CIA_FACTBOOK + "\"," +
           "\"" + JSONConstants.DISAMBIGUATED_CRUNCHBASE_KEY + "\": \"" + CRUNCHBASE + "\"," +
           "\"" + JSONConstants.DISAMBIGUATED_DBPEDIA_KEY + "\": \"" + DBPEDIA + "\"," +
           "\"" + JSONConstants.DISAMBIGUATED_FREEBASE_KEY + "\": \"" + FREEBASE + "\"," +
           "\"" + JSONConstants.DISAMBIGUATED_GEO_KEY + "\": \"" + GEO + "\"," +
           "\"" + JSONConstants.DISAMBIGUATED_GEONAMES_KEY + "\": \"" + GEONAMES + "\"," +
           "\"" + JSONConstants.DISAMBIGUATED_MUSIC_BRAINZ_KEY + "\": \"" + MUSIC_BRAINZ + "\"," +
           "\"" + JSONConstants.DISAMBIGUATED_OPENCYC_KEY + "\": \"" + OPENCYC + "\"," +
           "\"" + JSONConstants.DISAMBIGUATED_SEMANTIC_CRUNCHBASE_KEY + "\": \"" + SEMANTIC_CRUNCHBASE + "\"," +
           "\"" + JSONConstants.DISAMBIGUATED_UMBEL_KEY + "\": \"" + UMBEL + "\"," +
           "\"" + JSONConstants.DISAMBIGUATED_WEBSITE_KEY + "\": \"" + WEBSITE + "\"," +
           "\"" + JSONConstants.DISAMBIGUATED_YAGO_KEY + "\": \"" + YAGO + "\"}";
  }
}
