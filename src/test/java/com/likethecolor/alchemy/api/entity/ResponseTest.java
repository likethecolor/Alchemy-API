/**
 * File: ResponseTest.java
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
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class ResponseTest {
  @Test
  public void testConstructor() {
    final Response.STATUS expectedStatus = Response.STATUS.UNSET;

    final Response response = new Response();

    assertNull(response.getLanguage());
    assertEquals(expectedStatus, response.getStatus());
    assertNull(response.getStatusInfo());
    assertNull(response.getText());
    assertNull(response.getURL());
    assertNull(response.getUsage());
    assertEquals(0, response.size());
  }

  @Test
  public void testLanguage() {
    final String expectedLanguage = "english";

    final Response response = new Response();

    response.setLanguage(expectedLanguage);

    assertEquals(expectedLanguage, response.getLanguage());

    // null - should change value
    response.setLanguage(null);

    assertNull(response.getLanguage());


    // empty string - should change value
    response.setLanguage(expectedLanguage);
    response.setLanguage("");

    assertEquals("", response.getLanguage());


    // empty white space string - should change value and be trimmed
    response.setLanguage(expectedLanguage);
    response.setLanguage("\t   ");

    assertEquals("", response.getLanguage());


    // should be trimmed
    response.setLanguage("\t   " + expectedLanguage + " ");

    assertEquals(expectedLanguage, response.getLanguage());
  }

  @Test
  public void testStatus() {
    final Response.STATUS defaultStatus = Response.STATUS.UNSET;
    final Response.STATUS expectedStatus0 = Response.STATUS.OK;
    final Response.STATUS expectedStatus1 = Response.STATUS.ERROR;

    final Response response = new Response();

    assertEquals(defaultStatus, response.getStatus());

    response.setStatus(expectedStatus0.toString());

    assertEquals(expectedStatus0, response.getStatus());

    response.setStatus(expectedStatus1.toString());

    assertEquals(expectedStatus1, response.getStatus());

    response.setStatus(defaultStatus.toString());

    assertEquals(defaultStatus, response.getStatus());

    // null - should not change value
    response.setStatus(expectedStatus0.toString());
    response.setStatus(null);

    assertEquals(expectedStatus0, response.getStatus());

    // empty string - should not change value
    response.setStatus(expectedStatus0.toString());
    response.setStatus("");

    assertEquals(expectedStatus0, response.getStatus());

    // empty white space string - should not change value
    response.setStatus(expectedStatus0.toString());
    response.setStatus("\t   ");

    assertEquals(expectedStatus0, response.getStatus());

    // unknown string - should not change value
    response.setStatus(expectedStatus0.toString());
    response.setStatus("foo bar");

    assertEquals(expectedStatus0, response.getStatus());
  }

  @Test
  public void testStatusInfo() {
    final String expectedStatusInfo = "invalid-api-key";

    final Response response = new Response();

    response.setStatusInfo(expectedStatusInfo);

    assertEquals(expectedStatusInfo, response.getStatusInfo());

    // null - should change value
    response.setStatusInfo(null);

    assertNull(response.getStatusInfo());


    // empty string - should change value
    response.setStatusInfo(expectedStatusInfo);
    response.setStatusInfo("");

    assertEquals("", response.getStatusInfo());


    // empty white space string - should change value and be trimmed
    response.setStatusInfo(expectedStatusInfo);
    response.setStatusInfo("\t   ");

    assertEquals("", response.getStatusInfo());


    // should be trimmed
    response.setStatusInfo("\t   " + expectedStatusInfo + " ");

    assertEquals(expectedStatusInfo, response.getStatusInfo());
  }

  @Test
  public void testText() {
    final String expectedText = "Some sort of text";

    final Response response = new Response();

    response.setText(expectedText);

    assertEquals(expectedText, response.getText());

    // null - should change value
    response.setText(null);

    assertNull(response.getText());


    // empty string - should change value
    response.setText(expectedText);
    response.setText("");

    assertEquals("", response.getText());


    // empty white space string - should change value and be trimmed
    response.setText(expectedText);
    response.setText("\t   ");

    assertEquals("", response.getText());


    // should be trimmed
    response.setText("\t   " + expectedText + " ");

    assertEquals(expectedText, response.getText());
  }

  @Test
  public void testURL() {
    final String expectedURL = "http://www.cnn.com/2009/CRIME/01/13/missing.pilot/index.html";

    final Response response = new Response();

    response.setURL(expectedURL);

    assertEquals(expectedURL, response.getURL());

    // null - should change value
    response.setURL(null);

    assertNull(response.getURL());


    // empty string - should change value
    response.setURL(expectedURL);
    response.setURL("");

    assertEquals("", response.getURL());


    // empty white space string - should change value and be trimmed
    response.setURL(expectedURL);
    response.setURL("\t   ");

    assertEquals("", response.getURL());


    // should be trimmed
    response.setURL("\t   " + expectedURL + " ");

    assertEquals(expectedURL, response.getURL());
  }

  @Test
  public void testUsage() {
    final String expectedUsage = "By accessing AlchemyAPI or using information generated by AlchemyAPI, you are agreeing to be bound by the AlchemyAPI Terms of Use: http://www.alchemyapi.com/company/terms.html";

    final Response response = new Response();

    response.setUsage(expectedUsage);

    assertEquals(expectedUsage, response.getUsage());

    // null - should change value
    response.setUsage(null);

    assertNull(response.getUsage());


    // empty string - should change value
    response.setUsage(expectedUsage);
    response.setUsage("");

    assertEquals("", response.getUsage());


    // empty white space string - should change value and be trimmed
    response.setUsage(expectedUsage);
    response.setUsage("\t   ");

    assertEquals("", response.getUsage());


    // should be trimmed
    response.setUsage("\t   " + expectedUsage + " ");

    assertEquals(expectedUsage, response.getUsage());
  }

  @Test
  public void testAddEntity_OneEntity() {
    final Double expectedScore = 0.1467D;
    final String expectedCategory = "culture_politics";

    final CategoryAlchemyEntity entity = new CategoryAlchemyEntity(expectedCategory, expectedScore);

    final Response<CategoryAlchemyEntity> response = new Response<CategoryAlchemyEntity>();

    response.addEntity(entity);

    assertEquals(1, response.size());

    final CategoryAlchemyEntity actualEntity = response.iterator().next();

    assertEquals(entity, actualEntity);
  }

  @Test
  public void testAddEntity_TwoEntities() {
    final Double expectedScore0 = 0.805279D;
    final String expectedCategory0 = "George_W._Bush";
    final Double expectedScore1 = 0.971001D;
    final String expectedCategory1 = "Barack_Obama";

    final CategoryAlchemyEntity entity0 = new CategoryAlchemyEntity(expectedCategory0, expectedScore0);
    final CategoryAlchemyEntity entity1 = new CategoryAlchemyEntity(expectedCategory1, expectedScore1);

    final Response<CategoryAlchemyEntity> response = new Response<CategoryAlchemyEntity>();

    response.addEntity(entity0);
    response.addEntity(entity1);

    assertEquals(2, response.size());


    // NOTE: The order is from large score to small score
    final Iterator<CategoryAlchemyEntity> iter = response.iterator();
    CategoryAlchemyEntity actualEntity = iter.next();

    assertEquals(entity1, actualEntity);

    actualEntity = iter.next();

    assertEquals(entity0, actualEntity);
  }

  @Test
  public void testAddEntity_ThreeEntities_WithNull_AndDuplicates() {
    final boolean isMixed0 = true;
    final Double score0 = 0.222333D;
    final SentimentAlchemyEntity.TYPE type0 = SentimentAlchemyEntity.TYPE.POSITIVE;
    final boolean isMixed1 = false;
    final Double score1 = 0.111222D;
    final SentimentAlchemyEntity.TYPE type1 = SentimentAlchemyEntity.TYPE.NEGATIVE;
    final boolean isMixed2 = true;
    final Double score2 = 0.333444D;
    final SentimentAlchemyEntity.TYPE type2 = SentimentAlchemyEntity.TYPE.NEUTRAL;

    final SentimentAlchemyEntity entity0 = new SentimentAlchemyEntity(isMixed0, score0, type0.toString());
    final SentimentAlchemyEntity entity1 = new SentimentAlchemyEntity(isMixed1, score1, type1.toString());
    final SentimentAlchemyEntity entity2 = new SentimentAlchemyEntity(isMixed2, score2, type2.toString());

    final Response<SentimentAlchemyEntity> response = new Response<SentimentAlchemyEntity>();

    response.addEntity(null);
    response.addEntity(entity0);
    response.addEntity(null);
    response.addEntity(entity0);
    response.addEntity(entity1);
    response.addEntity(null);
    response.addEntity(entity2);
    response.addEntity(entity1);

    assertEquals(3, response.size());


    // NOTE: The order is from large score to small score
    final Iterator<SentimentAlchemyEntity> iter = response.iterator();

    SentimentAlchemyEntity actualEntity = iter.next();

    assertEquals(entity2, actualEntity);

    actualEntity = iter.next();

    assertEquals(entity0, actualEntity);

    actualEntity = iter.next();

    assertEquals(entity1, actualEntity);
  }

  @Test
  public void testClone() {
    final String language = "english";
    final Response.STATUS status = Response.STATUS.OK;
    final String statusInfo = "invalid-api-key";
    final String text = "Some sort of text";
    final String url = "http://www.cnn.com/2009/CRIME/01/13/missing.pilot/index.html";
    final String usage = "By accessing AlchemyAPI or using information generated by AlchemyAPI, you are agreeing to be bound by the AlchemyAPI Terms of Use: http://www.alchemyapi.com/company/terms.html";
    final Double expectedScore0 = 0.805279D;
    final String expectedCategory0 = "George_W._Bush";
    final Double expectedScore1 = 0.765733D;
    final String expectedCategory1 = "Inauguration_of_Barack_Obama";
    final Double expectedScore2 = 0.971001D;
    final String expectedCategory2 = "Barack_Obama";

    final CategoryAlchemyEntity entity0 = new CategoryAlchemyEntity(expectedCategory0, expectedScore0);
    final CategoryAlchemyEntity entity1 = new CategoryAlchemyEntity(expectedCategory1, expectedScore1);
    final CategoryAlchemyEntity entity2 = new CategoryAlchemyEntity(expectedCategory2, expectedScore2);

    final Response<CategoryAlchemyEntity> response = new Response<CategoryAlchemyEntity>();
    Response<CategoryAlchemyEntity> clone = new Response<CategoryAlchemyEntity>();

    assertTrue(response.equals(clone));
    assertNotSame(response, clone);


    response.setLanguage(language);
    clone = response.clone();

    assertTrue(response.equals(clone));
    assertNotSame(response, clone);


    response.setStatus(status.toString());
    clone = response.clone();

    assertTrue(response.equals(clone));
    assertNotSame(response, clone);


    response.setStatusInfo(statusInfo);
    clone = response.clone();

    assertTrue(response.equals(clone));
    assertNotSame(response, clone);


    response.setText(text);
    clone = response.clone();

    assertTrue(response.equals(clone));
    assertNotSame(response, clone);


    response.setURL(url);
    clone = response.clone();

    assertTrue(response.equals(clone));
    assertNotSame(response, clone);


    response.setUsage(usage);
    clone = response.clone();

    assertTrue(response.equals(clone));
    assertNotSame(response, clone);


    response.addEntity(entity0);
    clone = response.clone();

    assertTrue(response.equals(clone));
    assertNotSame(response, clone);


    response.addEntity(entity1);
    clone = response.clone();

    assertTrue(response.equals(clone));
    assertNotSame(response, clone);


    response.addEntity(entity2);
    clone = response.clone();

    assertTrue(response.equals(clone));
    assertNotSame(response, clone);
  }

  @Test
  public void testEquals() {
    final String language = "english";
    final Response.STATUS defaultStatus = Response.STATUS.UNSET;
    final Response.STATUS status = Response.STATUS.OK;
    final String statusInfo = "invalid-api-key";
    final String text = "Some sort of text";
    final String url = "http://www.cnn.com/2009/CRIME/01/13/missing.pilot/index.html";
    final String usage = "By accessing AlchemyAPI or using information generated by AlchemyAPI, you are agreeing to be bound by the AlchemyAPI Terms of Use: http://www.alchemyapi.com/company/terms.html";
    final Double expectedScore0 = 0.805279D;
    final String expectedCategory0 = "George_W._Bush";
    final Double expectedScore1 = 0.765733D;
    final String expectedCategory1 = "Inauguration_of_Barack_Obama";
    final Double expectedScore2 = 0.971001D;
    final String expectedCategory2 = "Barack_Obama";

    final CategoryAlchemyEntity entity0 = new CategoryAlchemyEntity(expectedCategory0, expectedScore0);
    final CategoryAlchemyEntity entity1 = new CategoryAlchemyEntity(expectedCategory1, expectedScore1);
    final CategoryAlchemyEntity entity2 = new CategoryAlchemyEntity(expectedCategory2, expectedScore2);

    final Response<CategoryAlchemyEntity> response = new Response<CategoryAlchemyEntity>();

    assertFalse(response.equals(null));
    assertFalse(response.equals(new Double(1312D)));

    assertTrue(response.equals(response));
    assertEquals(response, response);
    assertSame(response, response);


    Response<CategoryAlchemyEntity> other = new Response<CategoryAlchemyEntity>();

    assertTrue(response.equals(other));
    assertEquals(response, other);
    assertNotSame(response, other);


    // language
    response.setLanguage(null);
    other.setLanguage(language);

    assertFalse(response.equals(other));
    assertNotSame(response, other);


    response.setLanguage(language);
    other.setLanguage(null);

    assertFalse(response.equals(other));
    assertNotSame(response, other);


    other.setLanguage(language);

    assertTrue(response.equals(other));
    assertEquals(response, other);
    assertNotSame(response, other);


    // status
    response.setStatus(defaultStatus.toString());
    other.setStatus(status.toString());

    assertFalse(response.equals(other));
    assertNotSame(response, other);


    response.setStatus(status.toString());
    other.setStatus(defaultStatus.toString());

    assertFalse(response.equals(other));
    assertNotSame(response, other);


    other.setStatus(status.toString());

    assertTrue(response.equals(other));
    assertEquals(response, other);
    assertNotSame(response, other);


    // statusInfo
    response.setStatusInfo(null);
    other.setStatusInfo(statusInfo);

    assertFalse(response.equals(other));
    assertNotSame(response, other);


    response.setStatusInfo(statusInfo);
    other.setStatusInfo(null);

    assertFalse(response.equals(other));
    assertNotSame(response, other);


    other.setStatusInfo(statusInfo);

    assertTrue(response.equals(other));
    assertEquals(response, other);
    assertNotSame(response, other);


    // text
    response.setText(null);
    other.setText(text);

    assertFalse(response.equals(other));
    assertNotSame(response, other);


    response.setText(text);
    other.setText(null);

    assertFalse(response.equals(other));
    assertNotSame(response, other);


    other.setText(text);

    assertTrue(response.equals(other));
    assertEquals(response, other);
    assertNotSame(response, other);


    // url
    response.setURL(null);
    other.setURL(url);

    assertFalse(response.equals(other));
    assertNotSame(response, other);


    response.setURL(url);
    other.setURL(null);

    assertFalse(response.equals(other));
    assertNotSame(response, other);


    other.setURL(url);

    assertTrue(response.equals(other));
    assertEquals(response, other);
    assertNotSame(response, other);


    // usage
    response.setUsage(null);
    other.setUsage(usage);

    assertFalse(response.equals(other));
    assertNotSame(response, other);


    response.setUsage(usage);
    other.setUsage(null);

    assertFalse(response.equals(other));
    assertNotSame(response, other);


    other.setUsage(usage);

    assertTrue(response.equals(other));
    assertEquals(response, other);
    assertNotSame(response, other);


    // entities
    // cannot test everything since null entities cannot be added
    // and no entity can be removed
    response.addEntity(entity0);

    assertFalse(response.equals(other));
    assertNotSame(response, other);


    other.addEntity(entity0);

    assertTrue(response.equals(other));
    assertEquals(response, other);
    assertNotSame(response, other);


    // entities - add null entity - should not change the number of entities
    response.addEntity(null);

    assertTrue(response.equals(other));
    assertEquals(response, other);
    assertNotSame(response, other);


    // entities - add entity that already exists
    other.addEntity(entity0);

    assertTrue(response.equals(other));
    assertEquals(response, other);
    assertNotSame(response, other);


    response.addEntity(entity1);

    assertFalse(response.equals(other));
    assertNotSame(response, other);


    other.addEntity(entity1);

    assertTrue(response.equals(other));
    assertEquals(response, other);
    assertNotSame(response, other);


    response.addEntity(entity2);

    assertFalse(response.equals(other));
    assertNotSame(response, other);


    other.addEntity(entity2);

    assertTrue(response.equals(other));
    assertEquals(response, other);
    assertNotSame(response, other);
  }

  @Test
  public void testToString() {
    final String language = "english";
    final Response.STATUS status = Response.STATUS.OK;
    final String statusInfo = "invalid-api-key";
    final String text = "Some sort of text";
    final String url = "http://www.cnn.com/2009/CRIME/01/13/missing.pilot/index.html";
    final String usage = "By accessing AlchemyAPI or using information generated by AlchemyAPI, you are agreeing to be bound by the AlchemyAPI Terms of Use: http://www.alchemyapi.com/company/terms.html";
    final Double expectedScore0 = 0.805279D;
    final String expectedCategory0 = "George_W._Bush";
    final Double expectedScore1 = 0.765733D;
    final String expectedCategory1 = "Inauguration_of_Barack_Obama";
    final Double expectedScore2 = 0.971001D;
    final String expectedCategory2 = "Barack_Obama";

    final CategoryAlchemyEntity entity0 = new CategoryAlchemyEntity(expectedCategory0, expectedScore0);
    final CategoryAlchemyEntity entity1 = new CategoryAlchemyEntity(expectedCategory1, expectedScore1);
    final CategoryAlchemyEntity entity2 = new CategoryAlchemyEntity(expectedCategory2, expectedScore2);

    final Response<CategoryAlchemyEntity> response = new Response<CategoryAlchemyEntity>();
    response.setLanguage(language);
    response.setStatus(status.toString());
    response.setStatusInfo(statusInfo);
    response.setText(text);
    response.setURL(url);
    response.setUsage(usage);
    response.addEntity(entity0);
    response.addEntity(entity1);
    response.addEntity(entity2);

    final List<CategoryAlchemyEntity> entities = new ArrayList<CategoryAlchemyEntity>(3);
    entities.add(entity2);
    entities.add(entity0);
    entities.add(entity1);

    final String expectedString = new ToStringBuilder(response)
        .append("language", language)
        .append("status", status)
        .append("text", text)
        .append("url", url)
        .append("usage", usage)
        .append("entities", entities)
        .toString();

    final String actualString = response.toString();

    assertEquals(expectedString, actualString);
  }

  @Test
  public void testToString_Formatted() {
    final ToStringStyle style = ToStringStyle.NO_FIELD_NAMES_STYLE;
    final String language = "english";
    final Response.STATUS status = Response.STATUS.OK;
    final String statusInfo = "invalid-api-key";
    final String text = "Some sort of text";
    final String url = "http://www.cnn.com/2009/CRIME/01/13/missing.pilot/index.html";
    final String usage = "By accessing AlchemyAPI or using information generated by AlchemyAPI, you are agreeing to be bound by the AlchemyAPI Terms of Use: http://www.alchemyapi.com/company/terms.html";
    final Double expectedScore0 = 0.805279D;
    final String expectedCategory0 = "George_W._Bush";
    final Double expectedScore1 = 0.765733D;
    final String expectedCategory1 = "Inauguration_of_Barack_Obama";
    final Double expectedScore2 = 0.971001D;
    final String expectedCategory2 = "Barack_Obama";

    final CategoryAlchemyEntity entity0 = new CategoryAlchemyEntity(expectedCategory0, expectedScore0);
    final CategoryAlchemyEntity entity1 = new CategoryAlchemyEntity(expectedCategory1, expectedScore1);
    final CategoryAlchemyEntity entity2 = new CategoryAlchemyEntity(expectedCategory2, expectedScore2);

    final Response<CategoryAlchemyEntity> response = new Response<CategoryAlchemyEntity>();
    response.setLanguage(language);
    response.setStatus(status.toString());
    response.setStatusInfo(statusInfo);
    response.setText(text);
    response.setURL(url);
    response.setUsage(usage);
    response.addEntity(entity0);
    response.addEntity(entity1);
    response.addEntity(entity2);

    final List<CategoryAlchemyEntity> entities = new ArrayList<CategoryAlchemyEntity>(3);
    entities.add(entity2);
    entities.add(entity0);
    entities.add(entity1);

    final String expectedString = new ToStringBuilder(response, style)
        .append("language", language)
        .append("status", status)
        .append("text", text)
        .append("url", url)
        .append("usage", usage)
        .append("entities", entities)
        .toString();

    final String actualString = response.toString(style);

    assertEquals(expectedString, actualString);
  }
}
