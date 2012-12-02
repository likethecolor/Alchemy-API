/**
 * File: TargetedSentimentParamsTest.java
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

public class TargetedSentimentParamsTest {
  @Test
  public void testShowSourceText() {
    final TargetedSentimentParams params = new TargetedSentimentParams();

    assertFalse(params.isShowSourceText());


    params.setIsShowSourceText(true);

    assertTrue(params.isShowSourceText());


    params.setIsShowSourceText(false);

    assertFalse(params.isShowSourceText());
  }

  @Test
  public void testTarget() {
    String target = "the target";

    final TargetedSentimentParams params = new TargetedSentimentParams();

    params.setTarget(target);

    assertEquals(target, params.getTarget());

    // trimmed
    params.setTarget("\t" + target + "       \t   ");

    assertEquals(target, params.getTarget());

    // null - should change value
    params.setTarget(target);
    params.setTarget(null);

    assertNull(params.getTarget());

    // empty string - should change value
    params.setTarget(target);
    params.setTarget("");

    assertEquals("", params.getTarget());

    // empty white space string - should change value and be trimmed
    params.setTarget(target);
    params.setTarget("\t   \r\n   \t ");

    assertEquals("", params.getTarget());
  }

  @Test
  public void testToString() {
    final boolean isShowSourceText = true;
    final String target = "the target";

    final TargetedSentimentParams params = new TargetedSentimentParams();
    params.setIsShowSourceText(isShowSourceText);
    params.setTarget(target);

    final String expectedString = new StringBuilder()
        .append("&").append(Constants.PARAM_OUTPUT_FORMAT).append("=").append(Constants.DEFAULT_OUTPUT_FORMAT)
        .append("&").append(Constants.PARAM_SHOW_SOURCE_TEXT).append("=").append(
            isShowSourceText ? 1 : 0)
        .append("&").append(Constants.PARAM_TARGET).append("=").append(encode(target))
        .toString();

    final String actualString = params.toString();

    assertEquals(expectedString, actualString);
  }

  @Test
  public void testToString_FalseShowSourceText() {
    final boolean isShowSourceText = false;
    final String target = "the target";

    final TargetedSentimentParams params = new TargetedSentimentParams();
    params.setIsShowSourceText(isShowSourceText);
    params.setTarget(target);

    final String expectedString = new StringBuilder()
        .append("&").append(Constants.PARAM_OUTPUT_FORMAT).append("=").append(Constants.DEFAULT_OUTPUT_FORMAT)
        .append("&").append(Constants.PARAM_SHOW_SOURCE_TEXT).append("=").append(
            isShowSourceText ? 1 : 0)
        .append("&").append(Constants.PARAM_TARGET).append("=").append(encode(target))
        .toString();

    final String actualString = params.toString();

    assertEquals(expectedString, actualString);
  }

  @Test
  public void testToString_NullTarget() {
    final boolean isShowSourceText = true;
    final String target = null;

    final TargetedSentimentParams params = new TargetedSentimentParams();
    params.setIsShowSourceText(isShowSourceText);
    params.setTarget(target);

    final String expectedString = new StringBuilder()
        .append("&").append(Constants.PARAM_OUTPUT_FORMAT).append("=").append(Constants.DEFAULT_OUTPUT_FORMAT)
        .append("&").append(Constants.PARAM_SHOW_SOURCE_TEXT).append("=").append(
            isShowSourceText ? 1 : 0)
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
