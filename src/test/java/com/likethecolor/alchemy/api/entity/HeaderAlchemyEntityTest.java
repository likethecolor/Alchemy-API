/**
 * File: AlchemyHeaderTest.java
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

public class HeaderAlchemyEntityTest {
  @Test
  public void testConstructor() {
    final Response.STATUS expectedStatus = Response.STATUS.UNSET;

    final HeaderAlchemyEntity headerAlchemyEntity = new HeaderAlchemyEntity();

    assertNull(headerAlchemyEntity.getLanguage());
    assertEquals(expectedStatus, headerAlchemyEntity.getStatus());
    assertNull(headerAlchemyEntity.getStatusInfo());
    assertNull(headerAlchemyEntity.getText());
    assertNull(headerAlchemyEntity.getURL());
    assertNull(headerAlchemyEntity.getUsage());
  }

  @Test
  public void testLanguage() {
    final String expectedLanguage = "english";

    final HeaderAlchemyEntity headerAlchemyEntity = new HeaderAlchemyEntity();

    headerAlchemyEntity.setLanguage(expectedLanguage);

    assertEquals(expectedLanguage, headerAlchemyEntity.getLanguage());

    // null - should change value
    headerAlchemyEntity.setLanguage(null);

    assertNull(headerAlchemyEntity.getLanguage());


    // empty string - should change value
    headerAlchemyEntity.setLanguage(expectedLanguage);
    headerAlchemyEntity.setLanguage("");

    assertEquals("", headerAlchemyEntity.getLanguage());


    // empty white space string - should change value and be trimmed
    headerAlchemyEntity.setLanguage(expectedLanguage);
    headerAlchemyEntity.setLanguage("\t   ");

    assertEquals("", headerAlchemyEntity.getLanguage());


    // should be trimmed
    headerAlchemyEntity.setLanguage("\t   " + expectedLanguage + " ");

    assertEquals(expectedLanguage, headerAlchemyEntity.getLanguage());
  }

  @Test
  public void testStatus() {
    final Response.STATUS defaultStatus = Response.STATUS.UNSET;
    final Response.STATUS expectedStatus0 = Response.STATUS.OK;
    final Response.STATUS expectedStatus1 = Response.STATUS.ERROR;

    final HeaderAlchemyEntity headerAlchemyEntity = new HeaderAlchemyEntity();

    assertEquals(defaultStatus, headerAlchemyEntity.getStatus());

    headerAlchemyEntity.setStatus(expectedStatus0.toString());

    assertEquals(expectedStatus0, headerAlchemyEntity.getStatus());

    headerAlchemyEntity.setStatus(expectedStatus1.toString());

    assertEquals(expectedStatus1, headerAlchemyEntity.getStatus());

    headerAlchemyEntity.setStatus(defaultStatus.toString());

    assertEquals(defaultStatus, headerAlchemyEntity.getStatus());

    // null - should not change value
    headerAlchemyEntity.setStatus(expectedStatus0.toString());
    headerAlchemyEntity.setStatus(null);

    assertEquals(expectedStatus0, headerAlchemyEntity.getStatus());

    // empty string - should not change value
    headerAlchemyEntity.setStatus(expectedStatus0.toString());
    headerAlchemyEntity.setStatus("");

    assertEquals(expectedStatus0, headerAlchemyEntity.getStatus());

    // empty white space string - should not change value
    headerAlchemyEntity.setStatus(expectedStatus0.toString());
    headerAlchemyEntity.setStatus("\t   ");

    assertEquals(expectedStatus0, headerAlchemyEntity.getStatus());

    // unknown string - should not change value
    headerAlchemyEntity.setStatus(expectedStatus0.toString());
    headerAlchemyEntity.setStatus("foo bar");

    assertEquals(expectedStatus0, headerAlchemyEntity.getStatus());
  }

  @Test
  public void testStatusInfo() {
    final String expectedStatusInfo = "invalid-api-key";

    final HeaderAlchemyEntity headerAlchemyEntity = new HeaderAlchemyEntity();

    headerAlchemyEntity.setStatusInfo(expectedStatusInfo);

    assertEquals(expectedStatusInfo, headerAlchemyEntity.getStatusInfo());

    // null - should change value
    headerAlchemyEntity.setStatusInfo(null);

    assertNull(headerAlchemyEntity.getStatusInfo());


    // empty string - should change value
    headerAlchemyEntity.setStatusInfo(expectedStatusInfo);
    headerAlchemyEntity.setStatusInfo("");

    assertEquals("", headerAlchemyEntity.getStatusInfo());


    // empty white space string - should change value and be trimmed
    headerAlchemyEntity.setStatusInfo(expectedStatusInfo);
    headerAlchemyEntity.setStatusInfo("\t   ");

    assertEquals("", headerAlchemyEntity.getStatusInfo());


    // should be trimmed
    headerAlchemyEntity.setStatusInfo("\t   " + expectedStatusInfo + " ");

    assertEquals(expectedStatusInfo, headerAlchemyEntity.getStatusInfo());
  }

  @Test
  public void testText() {
    final String expectedText = "Some sort of text";

    final HeaderAlchemyEntity headerAlchemyEntity = new HeaderAlchemyEntity();

    headerAlchemyEntity.setText(expectedText);

    assertEquals(expectedText, headerAlchemyEntity.getText());

    // null - should change value
    headerAlchemyEntity.setText(null);

    assertNull(headerAlchemyEntity.getText());


    // empty string - should change value
    headerAlchemyEntity.setText(expectedText);
    headerAlchemyEntity.setText("");

    assertEquals("", headerAlchemyEntity.getText());


    // empty white space string - should change value and be trimmed
    headerAlchemyEntity.setText(expectedText);
    headerAlchemyEntity.setText("\t   ");

    assertEquals("", headerAlchemyEntity.getText());


    // should be trimmed
    headerAlchemyEntity.setText("\t   " + expectedText + " ");

    assertEquals(expectedText, headerAlchemyEntity.getText());
  }

  @Test
  public void testURL() {
    final String expectedURL = "http://www.cnn.com/2009/CRIME/01/13/missing.pilot/index.html";

    final HeaderAlchemyEntity headerAlchemyEntity = new HeaderAlchemyEntity();

    headerAlchemyEntity.setURL(expectedURL);

    assertEquals(expectedURL, headerAlchemyEntity.getURL());

    // null - should change value
    headerAlchemyEntity.setURL(null);

    assertNull(headerAlchemyEntity.getURL());


    // empty string - should change value
    headerAlchemyEntity.setURL(expectedURL);
    headerAlchemyEntity.setURL("");

    assertEquals("", headerAlchemyEntity.getURL());


    // empty white space string - should change value and be trimmed
    headerAlchemyEntity.setURL(expectedURL);
    headerAlchemyEntity.setURL("\t   ");

    assertEquals("", headerAlchemyEntity.getURL());


    // should be trimmed
    headerAlchemyEntity.setURL("\t   " + expectedURL + " ");

    assertEquals(expectedURL, headerAlchemyEntity.getURL());
  }

  @Test
  public void testUsage() {
    final String expectedUsage = "By accessing AlchemyAPI or using information generated by AlchemyAPI, you are agreeing to be bound by the AlchemyAPI Terms of Use: http://www.alchemyapi.com/company/terms.html";

    final HeaderAlchemyEntity headerAlchemyEntity = new HeaderAlchemyEntity();

    headerAlchemyEntity.setUsage(expectedUsage);

    assertEquals(expectedUsage, headerAlchemyEntity.getUsage());

    // null - should change value
    headerAlchemyEntity.setUsage(null);

    assertNull(headerAlchemyEntity.getUsage());


    // empty string - should change value
    headerAlchemyEntity.setUsage(expectedUsage);
    headerAlchemyEntity.setUsage("");

    assertEquals("", headerAlchemyEntity.getUsage());


    // empty white space string - should change value and be trimmed
    headerAlchemyEntity.setUsage(expectedUsage);
    headerAlchemyEntity.setUsage("\t   ");

    assertEquals("", headerAlchemyEntity.getUsage());


    // should be trimmed
    headerAlchemyEntity.setUsage("\t   " + expectedUsage + " ");

    assertEquals(expectedUsage, headerAlchemyEntity.getUsage());
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

    final HeaderAlchemyEntity headerAlchemyEntity = new HeaderAlchemyEntity();
    HeaderAlchemyEntity clone = new HeaderAlchemyEntity();

    assertTrue(headerAlchemyEntity.equals(clone));
    assertNotSame(headerAlchemyEntity, clone);


    headerAlchemyEntity.setLanguage(language);
    clone = headerAlchemyEntity.clone();

    assertTrue(headerAlchemyEntity.equals(clone));
    assertNotSame(headerAlchemyEntity, clone);


    headerAlchemyEntity.setStatus(status.toString());
    clone = headerAlchemyEntity.clone();

    assertTrue(headerAlchemyEntity.equals(clone));
    assertNotSame(headerAlchemyEntity, clone);


    headerAlchemyEntity.setStatusInfo(statusInfo);
    clone = headerAlchemyEntity.clone();

    assertTrue(headerAlchemyEntity.equals(clone));
    assertNotSame(headerAlchemyEntity, clone);


    headerAlchemyEntity.setText(text);
    clone = headerAlchemyEntity.clone();

    assertTrue(headerAlchemyEntity.equals(clone));
    assertNotSame(headerAlchemyEntity, clone);


    headerAlchemyEntity.setURL(url);
    clone = headerAlchemyEntity.clone();

    assertTrue(headerAlchemyEntity.equals(clone));
    assertNotSame(headerAlchemyEntity, clone);


    headerAlchemyEntity.setUsage(usage);
    clone = headerAlchemyEntity.clone();

    assertTrue(headerAlchemyEntity.equals(clone));
    assertNotSame(headerAlchemyEntity, clone);
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

    final HeaderAlchemyEntity headerAlchemyEntity = new HeaderAlchemyEntity();

    assertFalse(headerAlchemyEntity.equals(null));
    assertFalse(headerAlchemyEntity.equals(new Double(1312D)));

    assertTrue(headerAlchemyEntity.equals(headerAlchemyEntity));
    assertEquals(headerAlchemyEntity, headerAlchemyEntity);
    assertSame(headerAlchemyEntity, headerAlchemyEntity);


    HeaderAlchemyEntity other = new HeaderAlchemyEntity();

    assertTrue(headerAlchemyEntity.equals(other));
    assertEquals(headerAlchemyEntity, other);
    assertNotSame(headerAlchemyEntity, other);


    // language
    headerAlchemyEntity.setLanguage(null);
    other.setLanguage(language);

    assertFalse(headerAlchemyEntity.equals(other));
    assertNotSame(headerAlchemyEntity, other);


    headerAlchemyEntity.setLanguage(language);
    other.setLanguage(null);

    assertFalse(headerAlchemyEntity.equals(other));
    assertNotSame(headerAlchemyEntity, other);


    other.setLanguage(language);

    assertTrue(headerAlchemyEntity.equals(other));
    assertEquals(headerAlchemyEntity, other);
    assertNotSame(headerAlchemyEntity, other);


    // status
    headerAlchemyEntity.setStatus(defaultStatus.toString());
    other.setStatus(status.toString());

    assertFalse(headerAlchemyEntity.equals(other));
    assertNotSame(headerAlchemyEntity, other);


    headerAlchemyEntity.setStatus(status.toString());
    other.setStatus(defaultStatus.toString());

    assertFalse(headerAlchemyEntity.equals(other));
    assertNotSame(headerAlchemyEntity, other);


    other.setStatus(status.toString());

    assertTrue(headerAlchemyEntity.equals(other));
    assertEquals(headerAlchemyEntity, other);
    assertNotSame(headerAlchemyEntity, other);


    // statusInfo
    headerAlchemyEntity.setStatusInfo(null);
    other.setStatusInfo(statusInfo);

    assertFalse(headerAlchemyEntity.equals(other));
    assertNotSame(headerAlchemyEntity, other);


    headerAlchemyEntity.setStatusInfo(statusInfo);
    other.setStatusInfo(null);

    assertFalse(headerAlchemyEntity.equals(other));
    assertNotSame(headerAlchemyEntity, other);


    other.setStatusInfo(statusInfo);

    assertTrue(headerAlchemyEntity.equals(other));
    assertEquals(headerAlchemyEntity, other);
    assertNotSame(headerAlchemyEntity, other);


    // text
    headerAlchemyEntity.setText(null);
    other.setText(text);

    assertFalse(headerAlchemyEntity.equals(other));
    assertNotSame(headerAlchemyEntity, other);


    headerAlchemyEntity.setText(text);
    other.setText(null);

    assertFalse(headerAlchemyEntity.equals(other));
    assertNotSame(headerAlchemyEntity, other);


    other.setText(text);

    assertTrue(headerAlchemyEntity.equals(other));
    assertEquals(headerAlchemyEntity, other);
    assertNotSame(headerAlchemyEntity, other);


    // url
    headerAlchemyEntity.setURL(null);
    other.setURL(url);

    assertFalse(headerAlchemyEntity.equals(other));
    assertNotSame(headerAlchemyEntity, other);


    headerAlchemyEntity.setURL(url);
    other.setURL(null);

    assertFalse(headerAlchemyEntity.equals(other));
    assertNotSame(headerAlchemyEntity, other);


    other.setURL(url);

    assertTrue(headerAlchemyEntity.equals(other));
    assertEquals(headerAlchemyEntity, other);
    assertNotSame(headerAlchemyEntity, other);


    // usage
    headerAlchemyEntity.setUsage(null);
    other.setUsage(usage);

    assertFalse(headerAlchemyEntity.equals(other));
    assertNotSame(headerAlchemyEntity, other);


    headerAlchemyEntity.setUsage(usage);
    other.setUsage(null);

    assertFalse(headerAlchemyEntity.equals(other));
    assertNotSame(headerAlchemyEntity, other);


    other.setUsage(usage);

    assertTrue(headerAlchemyEntity.equals(other));
    assertEquals(headerAlchemyEntity, other);
    assertNotSame(headerAlchemyEntity, other);
  }

  @Test
  public void testToString() {
    final String language = "english";
    final Response.STATUS status = Response.STATUS.OK;
    final String statusInfo = "invalid-api-key";
    final String text = "Some sort of text";
    final String url = "http://www.cnn.com/2009/CRIME/01/13/missing.pilot/index.html";
    final String usage = "By accessing AlchemyAPI or using information generated by AlchemyAPI, you are agreeing to be bound by the AlchemyAPI Terms of Use: http://www.alchemyapi.com/company/terms.html";

    final HeaderAlchemyEntity headerAlchemyEntity = new HeaderAlchemyEntity();
    headerAlchemyEntity.setLanguage(language);
    headerAlchemyEntity.setStatus(status.toString());
    headerAlchemyEntity.setStatusInfo(statusInfo);
    headerAlchemyEntity.setText(text);
    headerAlchemyEntity.setURL(url);
    headerAlchemyEntity.setUsage(usage);

    final String expectedString = new ToStringBuilder(headerAlchemyEntity)
        .append("language", language)
        .append("status", status)
        .append("text", text)
        .append("url", url)
        .append("usage", usage)
        .toString();

    final String actualString = headerAlchemyEntity.toString();

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

    final HeaderAlchemyEntity headerAlchemyEntity = new HeaderAlchemyEntity();
    headerAlchemyEntity.setLanguage(language);
    headerAlchemyEntity.setStatus(status.toString());
    headerAlchemyEntity.setStatusInfo(statusInfo);
    headerAlchemyEntity.setText(text);
    headerAlchemyEntity.setURL(url);
    headerAlchemyEntity.setUsage(usage);

    final String expectedString = new ToStringBuilder(headerAlchemyEntity, style)
        .append("language", language)
        .append("status", status)
        .append("text", text)
        .append("url", url)
        .append("usage", usage)
        .toString();

    final String actualString = headerAlchemyEntity.toString(style);

    assertEquals(expectedString, actualString);
  }
}
