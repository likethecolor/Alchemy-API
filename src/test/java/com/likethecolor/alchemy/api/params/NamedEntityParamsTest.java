/**
 * File: NamedEntityParamsTest.java
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

public class NamedEntityParamsTest {
  @Test
  public void testBaeUrl() {
    final String baseUrl = "http://url.com/";

    final NamedEntityParams params = new NamedEntityParams();

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

    final NamedEntityParams params = new NamedEntityParams();

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
    final NamedEntityParams params = new NamedEntityParams();

    assertFalse(params.isCoreference());


    params.setIsCoreference(true);

    assertTrue(params.isCoreference());


    params.setIsCoreference(false);

    assertFalse(params.isCoreference());
  }

  @Test
  public void testDisambiguate() {
    final NamedEntityParams params = new NamedEntityParams();

    assertFalse(params.isDisambiguate());


    params.setIsDisambiguate(true);

    assertTrue(params.isDisambiguate());


    params.setIsDisambiguate(false);

    assertFalse(params.isDisambiguate());
  }

  @Test
  public void testLinkedData() {
    final NamedEntityParams params = new NamedEntityParams();

    assertFalse(params.isLinkedData());


    params.setIsLinkedData(true);

    assertTrue(params.isLinkedData());


    params.setIsLinkedData(false);

    assertFalse(params.isLinkedData());
  }

  @Test
  public void testMaxRetrieve() {
    final NamedEntityParams params = new NamedEntityParams();

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
  public void testQuotations() {
    final NamedEntityParams params = new NamedEntityParams();

    assertFalse(params.isQuotations());


    params.setIsQuotations(true);

    assertTrue(params.isQuotations());


    params.setIsQuotations(false);

    assertFalse(params.isQuotations());
  }

  @Test
  public void testSentiment() {
    final NamedEntityParams params = new NamedEntityParams();

    assertFalse(params.isSentiment());


    params.setIsSentiment(true);

    assertTrue(params.isSentiment());


    params.setIsSentiment(false);

    assertFalse(params.isSentiment());
  }

  @Test
  public void testShowSourceText() {
    final NamedEntityParams params = new NamedEntityParams();

    assertFalse(params.isShowSourceText());


    params.setIsShowSourceText(true);

    assertTrue(params.isShowSourceText());


    params.setIsShowSourceText(false);

    assertFalse(params.isShowSourceText());
  }

  @Test
  public void testSourceText() {
    String sourceText = Constants.SOURCE_TEXT_CLEANED_OR_RAW;

    final NamedEntityParams params = new NamedEntityParams();

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

    final NamedEntityParams params = new NamedEntityParams();

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
    final boolean isLinkedData = true;
    final int maxRetrieve = 25;
    final boolean isQuotations = true;
    final boolean isSentiment = true;
    final boolean isShowSourceText = true;
    final String sourceText = Constants.SOURCE_TEXT_XPATH;
    final String xPath = "//top/@attribute";

    final NamedEntityParams params = new NamedEntityParams();
    params.setBaseUrl(baseUrl);
    params.setConstraintQuery(constraintQuery);
    params.setIsCoreference(isCoreference);
    params.setIsDisambiguate(isDisambiguate);
    params.setIsLinkedData(isLinkedData);
    params.setMaxRetrieve(maxRetrieve);
    params.setIsQuotations(isQuotations);
    params.setIsSentiment(isSentiment);
    params.setIsShowSourceText(isShowSourceText);
    params.setSourceText(sourceText);
    params.setXPath(xPath);

    final String expectedString = new StringBuilder()
        .append("&").append(Constants.PARAM_LANGUAGE).append("=").append(Language.DETECT.toString().toLowerCase())
        .append("&").append(Constants.PARAM_OUTPUT_FORMAT).append("=").append(Constants.DEFAULT_OUTPUT_FORMAT)
        .append("&").append(Constants.PARAM_BASE_URL).append("=").append(encode(baseUrl))
        .append("&").append(Constants.PARAM_CONSTRAINT_QUERY).append("=").append(encode(constraintQuery))
        .append("&").append(Constants.PARAM_COREFERENCE).append("=").append(isCoreference ? 1 : 0)
        .append("&").append(Constants.PARAM_DISAMBIGUATE).append("=").append(isDisambiguate ? 1 : 0)
        .append("&").append(Constants.PARAM_LINKED_DATA).append("=").append(isLinkedData ? 1 : 0)
        .append("&").append(Constants.PARAM_MAX_RETRIEVE).append("=").append(maxRetrieve)
        .append("&").append(Constants.PARAM_QUOTATION).append("=").append(isQuotations ? 1 : 0)
        .append("&").append(Constants.PARAM_SHOW_SENTIMENT).append("=").append(isSentiment ? 1 : 0)
        .append("&").append(Constants.PARAM_SHOW_SOURCE_TEXT).append("=").append(isShowSourceText ? 1 : 0)
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
    final boolean isLinkedData = true;
    final int maxRetrieve = 25;
    final boolean isQuotations = true;
    final boolean isSentiment = true;
    final boolean isShowSourceText = true;
    final String sourceText = Constants.SOURCE_TEXT_XPATH;
    final String xPath = "//top/@attribute";

    final NamedEntityParams params = new NamedEntityParams();
    params.setBaseUrl(baseUrl);
    params.setConstraintQuery(constraintQuery);
    params.setIsCoreference(isCoreference);
    params.setIsDisambiguate(isDisambiguate);
    params.setIsLinkedData(isLinkedData);
    params.setMaxRetrieve(maxRetrieve);
    params.setIsQuotations(isQuotations);
    params.setIsSentiment(isSentiment);
    params.setIsShowSourceText(isShowSourceText);
    params.setSourceText(sourceText);
    params.setXPath(xPath);

    final String expectedString = new StringBuilder()
        .append("&").append(Constants.PARAM_LANGUAGE).append("=").append(Language.DETECT.toString().toLowerCase())
        .append("&").append(Constants.PARAM_OUTPUT_FORMAT).append("=").append(Constants.DEFAULT_OUTPUT_FORMAT)
        .append("&").append(Constants.PARAM_CONSTRAINT_QUERY).append("=").append(encode(constraintQuery))
        .append("&").append(Constants.PARAM_COREFERENCE).append("=").append(isCoreference ? 1 : 0)
        .append("&").append(Constants.PARAM_DISAMBIGUATE).append("=").append(isDisambiguate ? 1 : 0)
        .append("&").append(Constants.PARAM_LINKED_DATA).append("=").append(isLinkedData ? 1 : 0)
        .append("&").append(Constants.PARAM_MAX_RETRIEVE).append("=").append(maxRetrieve)
        .append("&").append(Constants.PARAM_QUOTATION).append("=").append(isQuotations ? 1 : 0)
        .append("&").append(Constants.PARAM_SHOW_SENTIMENT).append("=").append(isSentiment ? 1 : 0)
        .append("&").append(Constants.PARAM_SHOW_SOURCE_TEXT).append("=").append(isShowSourceText ? 1 : 0)
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
    final boolean isLinkedData = true;
    final int maxRetrieve = 25;
    final boolean isQuotations = true;
    final boolean isSentiment = true;
    final boolean isShowSourceText = true;
    final String sourceText = Constants.SOURCE_TEXT_XPATH;
    final String xPath = "//top/@attribute";

    final NamedEntityParams params = new NamedEntityParams();
    params.setBaseUrl(baseUrl);
    params.setConstraintQuery(constraintQuery);
    params.setIsCoreference(isCoreference);
    params.setIsDisambiguate(isDisambiguate);
    params.setIsLinkedData(isLinkedData);
    params.setMaxRetrieve(maxRetrieve);
    params.setIsQuotations(isQuotations);
    params.setIsSentiment(isSentiment);
    params.setIsShowSourceText(isShowSourceText);
    params.setSourceText(sourceText);
    params.setXPath(xPath);

    final String expectedString = new StringBuilder()
        .append("&").append(Constants.PARAM_LANGUAGE).append("=").append(Language.DETECT.toString().toLowerCase())
        .append("&").append(Constants.PARAM_OUTPUT_FORMAT).append("=").append(Constants.DEFAULT_OUTPUT_FORMAT)
        .append("&").append(Constants.PARAM_BASE_URL).append("=").append(encode(baseUrl))
        .append("&").append(Constants.PARAM_COREFERENCE).append("=").append(isCoreference ? 1 : 0)
        .append("&").append(Constants.PARAM_DISAMBIGUATE).append("=").append(isDisambiguate ? 1 : 0)
        .append("&").append(Constants.PARAM_LINKED_DATA).append("=").append(isLinkedData ? 1 : 0)
        .append("&").append(Constants.PARAM_MAX_RETRIEVE).append("=").append(maxRetrieve)
        .append("&").append(Constants.PARAM_QUOTATION).append("=").append(isQuotations ? 1 : 0)
        .append("&").append(Constants.PARAM_SHOW_SENTIMENT).append("=").append(isSentiment ? 1 : 0)
        .append("&").append(Constants.PARAM_SHOW_SOURCE_TEXT).append("=").append(isShowSourceText ? 1 : 0)
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
    final boolean isCoreference = true;
    final boolean isDisambiguate = false;
    final boolean isLinkedData = true;
    final int maxRetrieve = 25;
    final boolean isQuotations = false;
    final boolean isSentiment = true;
    final boolean isShowSourceText = false;
    final String sourceText = null;
    final String xPath = "//top/@attribute";

    final NamedEntityParams params = new NamedEntityParams();
    params.setBaseUrl(baseUrl);
    params.setConstraintQuery(constraintQuery);
    params.setIsCoreference(isCoreference);
    params.setIsDisambiguate(isDisambiguate);
    params.setIsLinkedData(isLinkedData);
    params.setMaxRetrieve(maxRetrieve);
    params.setIsQuotations(isQuotations);
    params.setIsSentiment(isSentiment);
    params.setIsShowSourceText(isShowSourceText);
    params.setSourceText(sourceText);
    params.setXPath(xPath);

    final String expectedString = new StringBuilder()
        .append("&").append(Constants.PARAM_LANGUAGE).append("=").append(Language.DETECT.toString().toLowerCase())
        .append("&").append(Constants.PARAM_OUTPUT_FORMAT).append("=").append(Constants.DEFAULT_OUTPUT_FORMAT)
        .append("&").append(Constants.PARAM_BASE_URL).append("=").append(encode(baseUrl))
        .append("&").append(Constants.PARAM_CONSTRAINT_QUERY).append("=").append(encode(constraintQuery))
        .append("&").append(Constants.PARAM_COREFERENCE).append("=").append(isCoreference ? 1 : 0)
        .append("&").append(Constants.PARAM_DISAMBIGUATE).append("=").append(isDisambiguate ? 1 : 0)
        .append("&").append(Constants.PARAM_LINKED_DATA).append("=").append(isLinkedData ? 1 : 0)
        .append("&").append(Constants.PARAM_MAX_RETRIEVE).append("=").append(maxRetrieve)
        .append("&").append(Constants.PARAM_QUOTATION).append("=").append(isQuotations ? 1 : 0)
        .append("&").append(Constants.PARAM_SHOW_SENTIMENT).append("=").append(isSentiment ? 1 : 0)
        .append("&").append(Constants.PARAM_SHOW_SOURCE_TEXT).append("=").append(isShowSourceText ? 1 : 0)
        .append("&").append(Constants.PARAM_XPATH).append("=").append(encode(xPath))
        .toString();

    final String actualString = params.toString();

    assertEquals(expectedString, actualString);
  }

  @Test
  public void testToString_NullXPath() {
    final String baseUrl = "http://url.com/";
    final String constraintQuery = "a-constraint-query";
    final boolean isCoreference = false;
    final boolean isDisambiguate = true;
    final boolean isLinkedData = false;
    final int maxRetrieve = 25;
    final boolean isQuotations = true;
    final boolean isSentiment = false;
    final boolean isShowSourceText = true;
    final String sourceText = Constants.SOURCE_TEXT_XPATH;
    final String xPath = null;

    final NamedEntityParams params = new NamedEntityParams();
    params.setBaseUrl(baseUrl);
    params.setConstraintQuery(constraintQuery);
    params.setIsCoreference(isCoreference);
    params.setIsDisambiguate(isDisambiguate);
    params.setIsLinkedData(isLinkedData);
    params.setMaxRetrieve(maxRetrieve);
    params.setIsQuotations(isQuotations);
    params.setIsSentiment(isSentiment);
    params.setIsShowSourceText(isShowSourceText);
    params.setSourceText(sourceText);
    params.setXPath(xPath);

    final String expectedString = new StringBuilder()
        .append("&").append(Constants.PARAM_LANGUAGE).append("=").append(Language.DETECT.toString().toLowerCase())
        .append("&").append(Constants.PARAM_OUTPUT_FORMAT).append("=").append(Constants.DEFAULT_OUTPUT_FORMAT)
        .append("&").append(Constants.PARAM_BASE_URL).append("=").append(encode(baseUrl))
        .append("&").append(Constants.PARAM_CONSTRAINT_QUERY).append("=").append(encode(constraintQuery))
        .append("&").append(Constants.PARAM_COREFERENCE).append("=").append(isCoreference ? 1 : 0)
        .append("&").append(Constants.PARAM_DISAMBIGUATE).append("=").append(isDisambiguate ? 1 : 0)
        .append("&").append(Constants.PARAM_LINKED_DATA).append("=").append(isLinkedData ? 1 : 0)
        .append("&").append(Constants.PARAM_MAX_RETRIEVE).append("=").append(maxRetrieve)
        .append("&").append(Constants.PARAM_QUOTATION).append("=").append(isQuotations ? 1 : 0)
        .append("&").append(Constants.PARAM_SHOW_SENTIMENT).append("=").append(isSentiment ? 1 : 0)
        .append("&").append(Constants.PARAM_SHOW_SOURCE_TEXT).append("=").append(isShowSourceText ? 1 : 0)
        .append("&").append(Constants.PARAM_SOURCE_TEXT).append("=").append(encode(sourceText))
        .toString();

    final String actualString = params.toString();

    assertEquals(expectedString, actualString);
  }

  private String encode(final String value) {
    String encodedValue = "";
    try {
      encodedValue = URLEncoder.encode(value, Constants.DEFAULT_ENCODING);
    }
    catch(UnsupportedEncodingException e) {
      e.printStackTrace();
    }
    return encodedValue;
  }
}
