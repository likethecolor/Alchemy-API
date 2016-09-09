/**
 * File: TextParamsTest.java
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

import static org.junit.Assert.*;

public class TextParamsTest {
  @Test
  public void testExtractLinks() {
    final TextParams params = new TextParams();

    assertFalse(params.isExtractLinks());


    params.setIsExtractLinks(true);

    assertTrue(params.isExtractLinks());


    params.setIsExtractLinks(false);

    assertFalse(params.isExtractLinks());
  }

  @Test
  public void testUseMetaData() {
    final TextParams params = new TextParams();

    assertFalse(params.isUseMetaData());


    params.setUseMetaData(true);

    assertTrue(params.isUseMetaData());


    params.setUseMetaData(false);

    assertFalse(params.isUseMetaData());
  }

  @Test
  public void testToString() {
    final boolean extractLinks = true;
    final boolean useMetaData = true;

    final TextParams params = new TextParams();
    params.setIsExtractLinks(extractLinks);
    params.setUseMetaData(useMetaData);

    final String expectedString = new StringBuilder()
        .append("&").append(Constants.PARAM_LANGUAGE).append("=").append(Language.DETECT.toString().toLowerCase())
        .append("&").append(Constants.PARAM_OUTPUT_FORMAT).append("=").append(Constants.DEFAULT_OUTPUT_FORMAT)
        .append("&").append(Constants.PARAM_EXTRACT_LINKS).append("=").append(extractLinks ? 1 : 0)
        .append("&").append(Constants.PARAM_USE_META_DATA).append("=").append(useMetaData ? 1 : 0)
        .toString();

    final String actualString = params.toString();

    assertEquals(expectedString, actualString);
  }

  @Test
  public void testToString_False() {
    final boolean extractLinks = false;
    final boolean useMetaData = false;

    final TextParams params = new TextParams();
    params.setIsExtractLinks(extractLinks);
    params.setUseMetaData(useMetaData);

    final String expectedString = new StringBuilder()
        .append("&").append(Constants.PARAM_LANGUAGE).append("=").append(Language.DETECT.toString().toLowerCase())
        .append("&").append(Constants.PARAM_OUTPUT_FORMAT).append("=").append(Constants.DEFAULT_OUTPUT_FORMAT)
        .append("&").append(Constants.PARAM_EXTRACT_LINKS).append("=").append(extractLinks ? 1 : 0)
        .append("&").append(Constants.PARAM_USE_META_DATA).append("=").append(useMetaData ? 1 : 0)
        .toString();

    final String actualString = params.toString();

    assertEquals(expectedString, actualString);
  }
}
