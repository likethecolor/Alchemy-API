/**
 * File: RelationParamsTest.java
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
package com.likethecolor.alchemy.api.params;

import com.likethecolor.alchemy.api.Constants;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class RelationParamsTest {
  @Test
  public void testBaeUrl() {
    final String baseUrl = "http://url.com/";

    final RelationParams params = new RelationParams();

    params.setBaseUrl(baseUrl);

    assertEquals(baseUrl, params.getBaseUrl());

    // null - should change value
    params.setBaseUrl(baseUrl);
    params.setBaseUrl(null);

    assertNull(params.getBaseUrl());

    // empty string - should change value
    params.setBaseUrl(baseUrl);
    params.setBaseUrl("");

    assertEquals("", params.getBaseUrl());


    // empty white space string - should change value and be trimmed
    params.setBaseUrl(baseUrl);
    params.setBaseUrl("\t   \r\n   \t ");

    assertEquals("", params.getBaseUrl());
  }

  @Test
  public void testConstraintQuery() {
    final String constraintQuery = "a-constraint-query";

    final RelationParams params = new RelationParams();

    params.setConstraintQuery(constraintQuery);

    assertEquals(constraintQuery, params.getConstraintQuery());

    // null - should change value
    params.setConstraintQuery(constraintQuery);
    params.setConstraintQuery(null);

    assertNull(params.getConstraintQuery());

    // empty string - should change value
    params.setConstraintQuery(constraintQuery);
    params.setConstraintQuery("");

    assertEquals("", params.getConstraintQuery());


    // empty white space string - should change value and be trimmed
    params.setConstraintQuery(constraintQuery);
    params.setConstraintQuery("\t   \r\n   \t ");

    assertEquals("", params.getConstraintQuery());
  }

  @Test
  public void testCoreference() {
    final RelationParams params = new RelationParams();

    assertFalse(params.isCoreference());


    params.setIsCoreference(true);

    assertTrue(params.isCoreference());


    params.setIsCoreference(false);

    assertFalse(params.isCoreference());
  }

  @Test
  public void testDisambiguate() {
    final RelationParams params = new RelationParams();

    assertFalse(params.isDisambiguate());


    params.setIsDisambiguate(true);

    assertTrue(params.isDisambiguate());


    params.setIsDisambiguate(false);

    assertFalse(params.isDisambiguate());
  }

  @Test
  public void testEntities() {
    final RelationParams params = new RelationParams();

    assertFalse(params.isEntities());


    params.setIsEntities(true);

    assertTrue(params.isEntities());


    params.setIsEntities(false);

    assertFalse(params.isEntities());
  }

  @Test
  public void testLinkedData() {
    final RelationParams params = new RelationParams();

    assertFalse(params.isLinkedData());


    params.setIsLinkedData(true);

    assertTrue(params.isLinkedData());


    params.setIsLinkedData(false);

    assertFalse(params.isLinkedData());
  }

  @Test
  public void testMaxRetrieve() {
    final RelationParams params = new RelationParams();

    assertEquals(Constants.DEFAULT_MAX_RETRIEVE, params.getMaxRetrieve());

    // in between min and max
    params.setMaxRetrieve(Constants.MIN_MAX_RETRIEVE + 1);

    assertEquals(Constants.MIN_MAX_RETRIEVE + 1, params.getMaxRetrieve());

    // too small
    params.setMaxRetrieve(Constants.MIN_MAX_RETRIEVE - 1);

    assertEquals(Constants.DEFAULT_MAX_RETRIEVE, params.getMaxRetrieve());

    // too large
    params.setMaxRetrieve(Constants.MAX_MAX_RETRIEVE + 1);

    assertEquals(Constants.DEFAULT_MAX_RETRIEVE, params.getMaxRetrieve());
  }

  @Test
  public void testRequireEntities() {
    final RelationParams params = new RelationParams();

    assertFalse(params.isRequireEntities());


    params.setIsRequireEntities(true);

    assertTrue(params.isRequireEntities());


    params.setIsRequireEntities(false);

    assertFalse(params.isRequireEntities());
  }

  @Test
  public void testSentiment() {
    final RelationParams params = new RelationParams();

    assertFalse(params.isSentiment());


    params.setIsSentiment(true);

    assertTrue(params.isSentiment());


    params.setIsSentiment(false);

    assertFalse(params.isSentiment());
  }

  @Test
  public void testSentimentExcludeEntities() {
    final RelationParams params = new RelationParams();

    assertFalse(params.isSentimentExcludeEntities());


    params.setIsSentimentExcludeEntities(true);

    assertTrue(params.isSentimentExcludeEntities());


    params.setIsSentimentExcludeEntities(false);

    assertFalse(params.isSentimentExcludeEntities());
  }

  @Test
  public void testShowSourceText() {
    final RelationParams params = new RelationParams();

    assertFalse(params.isShowSourceText());


    params.setIsShowSourceText(true);

    assertTrue(params.isShowSourceText());


    params.setIsShowSourceText(false);

    assertFalse(params.isShowSourceText());
  }

  @Test
  public void testSourceText() {
    String sourceText = Constants.SOURCE_TEXT_CLEANED_OR_RAW;

    final RelationParams params = new RelationParams();

    params.setSourceText(sourceText);

    assertEquals(sourceText, params.getSourceText());


    sourceText = Constants.SOURCE_TEXT_CLEANED;

    params.setSourceText(sourceText);

    assertEquals(sourceText, params.getSourceText());


    sourceText = Constants.SOURCE_TEXT_CONSTRAINTS_QUERY;

    params.setSourceText(sourceText);

    assertEquals(sourceText, params.getSourceText());


    sourceText = Constants.SOURCE_TEXT_RAW;

    params.setSourceText(sourceText);

    assertEquals(sourceText, params.getSourceText());


    sourceText = Constants.SOURCE_TEXT_XPATH;

    params.setSourceText(sourceText);

    assertEquals(sourceText, params.getSourceText());


    // null - should change value
    params.setSourceText(sourceText);
    params.setSourceText(null);

    assertNull(params.getSourceText());

    // empty string - should change value to null
    params.setSourceText(sourceText);
    params.setSourceText("");

    assertNull(params.getSourceText());

    // empty white space string - should change value to null
    params.setSourceText(sourceText);
    params.setSourceText("\t   \r\n   \t ");

    assertNull(params.getSourceText());

    // unknown value should not change value
    params.setSourceText(sourceText);
    params.setSourceText(sourceText + "foo");

    assertEquals(sourceText, params.getSourceText());
  }

  @Test
  public void testXPath() {
    final String xPath = "//top/@attribute";

    final RelationParams params = new RelationParams();

    params.setXPath(xPath);

    assertEquals(xPath, params.getXPath());

    // null - should change value
    params.setXPath(xPath);
    params.setXPath(null);

    assertNull(params.getXPath());

    // empty string - should change value
    params.setXPath(xPath);
    params.setXPath("");

    assertEquals("", params.getXPath());


    // empty white space string - should change value and be trimmed
    params.setXPath(xPath);
    params.setXPath("\t   \r\n   \t ");

    assertEquals("", params.getXPath());
  }

  @Test
  public void testToString() {
    final String baseUrl = "http://url.com/";
    final String constraintQuery = "a-constraint-query";
    final boolean isCoreference = true;
    final boolean isDisambiguate = true;
    final boolean isEntities = true;
    final boolean isLinkedData = true;
    final int maxRetrieve = 25;
    final boolean isRequireEntities = true;
    final boolean isSentiment = true;
    final boolean isSentimentExcludeEntities = true;
    final boolean isShowSourceText = true;
    final String sourceText = Constants.SOURCE_TEXT_XPATH;
    final String xPath = "//top/@attribute";

    final RelationParams params = new RelationParams();
    params.setBaseUrl(baseUrl);
    params.setConstraintQuery(constraintQuery);
    params.setIsCoreference(isCoreference);
    params.setIsDisambiguate(isDisambiguate);
    params.setIsEntities(isEntities);
    params.setIsLinkedData(isLinkedData);
    params.setMaxRetrieve(maxRetrieve);
    params.setIsRequireEntities(isRequireEntities);
    params.setIsSentiment(isSentiment);
    params.setIsSentimentExcludeEntities(isSentimentExcludeEntities);
    params.setIsShowSourceText(isShowSourceText);
    params.setSourceText(sourceText);
    params.setXPath(xPath);

    final String expectedString = new StringBuilder()
        .append("&").append(Constants.PARAM_LANGUAGE).append("=").append(Language.DETECT.toString().toLowerCase())
        .append("&").append(Constants.PARAM_OUTPUT_FORMAT).append("=").append(Constants.DEFAULT_OUTPUT_FORMAT)
        .append("&").append(Constants.PARAM_BASE_URL).append("=").append(encode(baseUrl))
        .append("&").append(Constants.PARAM_CONSTRAINT_QUERY).append("=").append(encode(constraintQuery))
        .append("&").append(Constants.PARAM_COREFERENCE).append("=").append(
            isCoreference ? 1 : 0)
        .append("&").append(Constants.PARAM_DISAMBIGUATE).append("=").append(
            isDisambiguate ? 1 : 0)
        .append("&").append(Constants.PARAM_ENTITIES).append("=").append(
            isEntities ? 1 : 0)
        .append("&").append(Constants.PARAM_LINKED_DATA).append("=").append(
            isLinkedData ? 1 : 0)
        .append("&").append(Constants.PARAM_MAX_RETRIEVE).append("=").append(maxRetrieve)
        .append("&").append(Constants.PARAM_REQUIRE_ENTITIES).append("=").append(
            isRequireEntities ? 1 : 0)
        .append("&").append(Constants.PARAM_SHOW_SENTIMENT).append("=").append(
            isSentiment ? 1 : 0)
        .append("&").append(Constants.PARAM_SHOW_SENTIMENT_EXCLUDE_ENTITIES).append("=").append(
            isSentimentExcludeEntities ? 1 : 0)
        .append("&").append(Constants.PARAM_SHOW_SOURCE_TEXT).append("=").append(
            isShowSourceText ? 1 : 0)
        .append("&").append(Constants.PARAM_SOURCE_TEXT).append("=").append(encode(sourceText))
        .append("&").append(Constants.PARAM_XPATH).append("=").append(encode(xPath))
        .toString();

    final String actualString = params.toString();

    assertEquals(expectedString, actualString);
  }

  @Test
  public void testToString_NullBaseUrl() {
    final String baseUrl = null;
    final String constraintQuery = "a-constraint-query";
    final boolean isCoreference = true;
    final boolean isDisambiguate = true;
    final boolean isEntities = true;
    final boolean isLinkedData = true;
    final int maxRetrieve = 25;
    final boolean isRequireEntities = true;
    final boolean isSentiment = true;
    final boolean isSentimentExcludeEntities = true;
    final boolean isShowSourceText = true;
    final String sourceText = Constants.SOURCE_TEXT_XPATH;
    final String xPath = "//top/@attribute";

    final RelationParams params = new RelationParams();
    params.setBaseUrl(baseUrl);
    params.setConstraintQuery(constraintQuery);
    params.setIsCoreference(isCoreference);
    params.setIsDisambiguate(isDisambiguate);
    params.setIsEntities(isEntities);
    params.setIsLinkedData(isLinkedData);
    params.setMaxRetrieve(maxRetrieve);
    params.setIsRequireEntities(isRequireEntities);
    params.setIsSentiment(isSentiment);
    params.setIsSentimentExcludeEntities(isSentimentExcludeEntities);
    params.setIsShowSourceText(isShowSourceText);
    params.setSourceText(sourceText);
    params.setXPath(xPath);

    final String expectedString = new StringBuilder()
        .append("&").append(Constants.PARAM_LANGUAGE).append("=").append(Language.DETECT.toString().toLowerCase())
        .append("&").append(Constants.PARAM_OUTPUT_FORMAT).append("=").append(Constants.DEFAULT_OUTPUT_FORMAT)
        .append("&").append(Constants.PARAM_CONSTRAINT_QUERY).append("=").append(encode(constraintQuery))
        .append("&").append(Constants.PARAM_COREFERENCE).append("=").append(
            isCoreference ? 1 : 0)
        .append("&").append(Constants.PARAM_DISAMBIGUATE).append("=").append(
            isDisambiguate ? 1 : 0)
        .append("&").append(Constants.PARAM_ENTITIES).append("=").append(
            isEntities ? 1 : 0)
        .append("&").append(Constants.PARAM_LINKED_DATA).append("=").append(
            isLinkedData ? 1 : 0)
        .append("&").append(Constants.PARAM_MAX_RETRIEVE).append("=").append(maxRetrieve)
        .append("&").append(Constants.PARAM_REQUIRE_ENTITIES).append("=").append(
            isRequireEntities ? 1 : 0)
        .append("&").append(Constants.PARAM_SHOW_SENTIMENT).append("=").append(
            isSentiment ? 1 : 0)
        .append("&").append(Constants.PARAM_SHOW_SENTIMENT_EXCLUDE_ENTITIES).append("=").append(
            isSentimentExcludeEntities ? 1 : 0)
        .append("&").append(Constants.PARAM_SHOW_SOURCE_TEXT).append("=").append(
            isShowSourceText ? 1 : 0)
        .append("&").append(Constants.PARAM_SOURCE_TEXT).append("=").append(encode(sourceText))
        .append("&").append(Constants.PARAM_XPATH).append("=").append(encode(xPath))
        .toString();

    final String actualString = params.toString();

    assertEquals(expectedString, actualString);
  }

  @Test
  public void testToString_NullConstraintQuery() {
    final String baseUrl = "http://url.com/";
    final String constraintQuery = null;
    final boolean isCoreference = true;
    final boolean isDisambiguate = true;
    final boolean isEntities = true;
    final boolean isLinkedData = true;
    final int maxRetrieve = 25;
    final boolean isRequireEntities = true;
    final boolean isSentiment = true;
    final boolean isSentimentExcludeEntities = true;
    final boolean isShowSourceText = true;
    final String sourceText = Constants.SOURCE_TEXT_XPATH;
    final String xPath = "//top/@attribute";

    final RelationParams params = new RelationParams();
    params.setBaseUrl(baseUrl);
    params.setConstraintQuery(constraintQuery);
    params.setIsCoreference(isCoreference);
    params.setIsDisambiguate(isDisambiguate);
    params.setIsEntities(isEntities);
    params.setIsLinkedData(isLinkedData);
    params.setMaxRetrieve(maxRetrieve);
    params.setIsRequireEntities(isRequireEntities);
    params.setIsSentiment(isSentiment);
    params.setIsSentimentExcludeEntities(isSentimentExcludeEntities);
    params.setIsShowSourceText(isShowSourceText);
    params.setSourceText(sourceText);
    params.setXPath(xPath);

    final String expectedString = new StringBuilder()
        .append("&").append(Constants.PARAM_LANGUAGE).append("=").append(Language.DETECT.toString().toLowerCase())
        .append("&").append(Constants.PARAM_OUTPUT_FORMAT).append("=").append(Constants.DEFAULT_OUTPUT_FORMAT)
        .append("&").append(Constants.PARAM_BASE_URL).append("=").append(encode(baseUrl))
        .append("&").append(Constants.PARAM_COREFERENCE).append("=").append(
            isCoreference ? 1 : 0)
        .append("&").append(Constants.PARAM_DISAMBIGUATE).append("=").append(
            isDisambiguate ? 1 : 0)
        .append("&").append(Constants.PARAM_ENTITIES).append("=").append(
            isEntities ? 1 : 0)
        .append("&").append(Constants.PARAM_LINKED_DATA).append("=").append(
            isLinkedData ? 1 : 0)
        .append("&").append(Constants.PARAM_MAX_RETRIEVE).append("=").append(maxRetrieve)
        .append("&").append(Constants.PARAM_REQUIRE_ENTITIES).append("=").append(
            isRequireEntities ? 1 : 0)
        .append("&").append(Constants.PARAM_SHOW_SENTIMENT).append("=").append(
            isSentiment ? 1 : 0)
        .append("&").append(Constants.PARAM_SHOW_SENTIMENT_EXCLUDE_ENTITIES).append("=").append(
            isSentimentExcludeEntities ? 1 : 0)
        .append("&").append(Constants.PARAM_SHOW_SOURCE_TEXT).append("=").append(
            isShowSourceText ? 1 : 0)
        .append("&").append(Constants.PARAM_SOURCE_TEXT).append("=").append(encode(sourceText))
        .append("&").append(Constants.PARAM_XPATH).append("=").append(encode(xPath))
        .toString();

    final String actualString = params.toString();

    assertEquals(expectedString, actualString);
  }

  @Test
  public void testToString_NullSourceText() {
    final String baseUrl = "http://url.com/";
    final String constraintQuery = "a-constraint-query";
    final boolean isCoreference = false;
    final boolean isDisambiguate = true;
    final boolean isEntities = false;
    final boolean isLinkedData = true;
    final int maxRetrieve = 25;
    final boolean isRequireEntities = false;
    final boolean isSentiment = true;
    final boolean isSentimentExcludeEntities = false;
    final boolean isShowSourceText = true;
    final String sourceText = null;
    final String xPath = "//top/@attribute";

    final RelationParams params = new RelationParams();
    params.setBaseUrl(baseUrl);
    params.setConstraintQuery(constraintQuery);
    params.setIsCoreference(isCoreference);
    params.setIsDisambiguate(isDisambiguate);
    params.setIsEntities(isEntities);
    params.setIsLinkedData(isLinkedData);
    params.setMaxRetrieve(maxRetrieve);
    params.setIsRequireEntities(isRequireEntities);
    params.setIsSentiment(isSentiment);
    params.setIsSentimentExcludeEntities(isSentimentExcludeEntities);
    params.setIsShowSourceText(isShowSourceText);
    params.setSourceText(sourceText);
    params.setXPath(xPath);

    final String expectedString = new StringBuilder()
        .append("&").append(Constants.PARAM_LANGUAGE).append("=").append(Language.DETECT.toString().toLowerCase())
        .append("&").append(Constants.PARAM_OUTPUT_FORMAT).append("=").append(Constants.DEFAULT_OUTPUT_FORMAT)
        .append("&").append(Constants.PARAM_BASE_URL).append("=").append(encode(baseUrl))
        .append("&").append(Constants.PARAM_CONSTRAINT_QUERY).append("=").append(encode(constraintQuery))
        .append("&").append(Constants.PARAM_COREFERENCE).append("=").append(
            isCoreference ? 1 : 0)
        .append("&").append(Constants.PARAM_DISAMBIGUATE).append("=").append(
            isDisambiguate ? 1 : 0)
        .append("&").append(Constants.PARAM_ENTITIES).append("=").append(
            isEntities ? 1 : 0)
        .append("&").append(Constants.PARAM_LINKED_DATA).append("=").append(
            isLinkedData ? 1 : 0)
        .append("&").append(Constants.PARAM_MAX_RETRIEVE).append("=").append(maxRetrieve)
        .append("&").append(Constants.PARAM_REQUIRE_ENTITIES).append("=").append(
            isRequireEntities ? 1 : 0)
        .append("&").append(Constants.PARAM_SHOW_SENTIMENT).append("=").append(
            isSentiment ? 1 : 0)
        .append("&").append(Constants.PARAM_SHOW_SENTIMENT_EXCLUDE_ENTITIES).append("=").append(
            isSentimentExcludeEntities ? 1 : 0)
        .append("&").append(Constants.PARAM_SHOW_SOURCE_TEXT).append("=").append(
            isShowSourceText ? 1 : 0)
        .append("&").append(Constants.PARAM_XPATH).append("=").append(encode(xPath))
        .toString();

    final String actualString = params.toString();

    assertEquals(expectedString, actualString);
  }

  @Test
  public void testToString_NullXPath() {
    final String baseUrl = "http://url.com/";
    final String constraintQuery = "a-constraint-query";
    final boolean isCoreference = true;
    final boolean isDisambiguate = false;
    final boolean isEntities = true;
    final boolean isLinkedData = false;
    final int maxRetrieve = 25;
    final boolean isRequireEntities = true;
    final boolean isSentiment = false;
    final boolean isSentimentExcludeEntities = true;
    final boolean isShowSourceText = false;
    final String sourceText = Constants.SOURCE_TEXT_XPATH;
    final String xPath = null;

    final RelationParams params = new RelationParams();
    params.setBaseUrl(baseUrl);
    params.setConstraintQuery(constraintQuery);
    params.setIsCoreference(isCoreference);
    params.setIsDisambiguate(isDisambiguate);
    params.setIsEntities(isEntities);
    params.setIsLinkedData(isLinkedData);
    params.setMaxRetrieve(maxRetrieve);
    params.setIsRequireEntities(isRequireEntities);
    params.setIsSentiment(isSentiment);
    params.setIsSentimentExcludeEntities(isSentimentExcludeEntities);
    params.setIsShowSourceText(isShowSourceText);
    params.setSourceText(sourceText);
    params.setXPath(xPath);

    final String expectedString = new StringBuilder()
        .append("&").append(Constants.PARAM_LANGUAGE).append("=").append(Language.DETECT.toString().toLowerCase())
        .append("&").append(Constants.PARAM_OUTPUT_FORMAT).append("=").append(Constants.DEFAULT_OUTPUT_FORMAT)
        .append("&").append(Constants.PARAM_BASE_URL).append("=").append(encode(baseUrl))
        .append("&").append(Constants.PARAM_CONSTRAINT_QUERY).append("=").append(encode(constraintQuery))
        .append("&").append(Constants.PARAM_COREFERENCE).append("=").append(
            isCoreference ? 1 : 0)
        .append("&").append(Constants.PARAM_DISAMBIGUATE).append("=").append(
            isDisambiguate ? 1 : 0)
        .append("&").append(Constants.PARAM_ENTITIES).append("=").append(
            isEntities ? 1 : 0)
        .append("&").append(Constants.PARAM_LINKED_DATA).append("=").append(
            isLinkedData ? 1 : 0)
        .append("&").append(Constants.PARAM_MAX_RETRIEVE).append("=").append(maxRetrieve)
        .append("&").append(Constants.PARAM_REQUIRE_ENTITIES).append("=").append(
            isRequireEntities ? 1 : 0)
        .append("&").append(Constants.PARAM_SHOW_SENTIMENT).append("=").append(
            isSentiment ? 1 : 0)
        .append("&").append(Constants.PARAM_SHOW_SENTIMENT_EXCLUDE_ENTITIES).append("=").append(
            isSentimentExcludeEntities ? 1 : 0)
        .append("&").append(Constants.PARAM_SHOW_SOURCE_TEXT).append("=").append(
            isShowSourceText ? 1 : 0)
        .append("&").append(Constants.PARAM_SOURCE_TEXT).append("=").append(encode(sourceText))
        .toString();

    final String actualString = params.toString();

    assertEquals(expectedString, actualString);
  }

  private String encode(final String value) {
    String encodedValue = "";
    if(value == null) {
      return encodedValue;
    }
    try {
      encodedValue = URLEncoder.encode(value, Constants.DEFAULT_ENCODING);
    }
    catch(UnsupportedEncodingException e) {
      e.printStackTrace();
    }
    return encodedValue;
  }
}
