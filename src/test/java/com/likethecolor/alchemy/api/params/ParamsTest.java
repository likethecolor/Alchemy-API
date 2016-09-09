/**
 * File: ParamsTest.java
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ParamsTest {
  @Test
  public void testHtml() {
    final String expectedHtml = "<html><body>text</body></html>";

    final Params params = new Params();

    params.setHtml(expectedHtml);

    String actualHtml = params.getHtml();

    assertEquals(expectedHtml, actualHtml);


    // null - should change value
    params.setHtml(null);

    actualHtml = params.getHtml();

    assertNull(actualHtml);

    // empty string - should change value
    params.setHtml(expectedHtml);
    params.setHtml("");

    actualHtml = params.getHtml();

    assertEquals("", actualHtml);

    // empty white space string - should change value and be trimmed
    params.setHtml(expectedHtml);
    params.setHtml("\t  \t\r\n");

    actualHtml = params.getHtml();

    assertEquals("", actualHtml);

    // should trim
    params.setHtml("\n\r  " + expectedHtml + "   \t  ");

    actualHtml = params.getHtml();

    assertEquals(expectedHtml, actualHtml);
  }
  @Test
  public void testLanguage() {
    final Language expectedLanguage = Language.ENGLISH;

    final Params params = new Params();

    params.setLanguage(expectedLanguage);

    Language actualLanguage = params.getLanguage();

    assertEquals(expectedLanguage, actualLanguage);


    // null - should change value
    params.setLanguage(null);

    actualLanguage = params.getLanguage();

    assertNull(actualLanguage);
  }

  @Test
  public void testOutputMode() {
    assertEquals(Constants.DEFAULT_OUTPUT_FORMAT, new Params().getOutputMode());
  }

  @Test
  public void testText() {
    final String expectedText = "This is some text";

    final Params params = new Params();

    params.setText(expectedText);

    String actualText = params.getText();

    assertEquals(expectedText, actualText);


    // null - should change value
    params.setText(null);

    actualText = params.getText();

    assertNull(actualText);

    // empty string - should change value
    params.setText(expectedText);
    params.setText("");

    actualText = params.getText();

    assertEquals("", actualText);

    // empty white space string - should change value and be trimmed
    params.setText(expectedText);
    params.setText("\t  \t\r\n");

    actualText = params.getText();

    assertEquals("", actualText);

    // should trim
    params.setText("\n\r  " + expectedText + "   \t  ");

    actualText = params.getText();

    assertEquals(expectedText, actualText);
  }

  @Test
  public void testURL() {
    final String expectedURL = "http://www.site.com/data";

    final Params params = new Params();

    params.setURL(expectedURL);

    String actualURL = params.getURL();

    assertEquals(expectedURL, actualURL);


    // null - should change value
    params.setURL(null);

    actualURL = params.getURL();

    assertNull(actualURL);

    // empty string - should change value
    params.setURL(expectedURL);
    params.setURL("");

    actualURL = params.getURL();

    assertEquals("", actualURL);

    // empty white space string - should change value and be trimmed
    params.setURL(expectedURL);
    params.setURL("\t  \t\r\n");

    actualURL = params.getURL();

    assertEquals("", actualURL);

    // should trim
    params.setURL("\n\r  " + expectedURL + "   \t  ");

    actualURL = params.getURL();

    assertEquals(expectedURL, actualURL);
  }

  @Test
  public void testToString() {
    final String html = "<html><body>text</body></html>";
    final String text = "This is some text";
    final String url = "http://www.site.com/data";

    Params params = new Params();

    // HTML
    params.setHtml(html);

    String expectedString = "&" + Constants.PARAM_HTML + "=" + encode(html)
                            + "&" + Constants.PARAM_LANGUAGE + "=" + Language.DETECT.toString().toLowerCase()
                            + "&" + Constants.PARAM_OUTPUT_FORMAT + "=" + Constants.DEFAULT_OUTPUT_FORMAT;

    assertEquals(expectedString, params.toString());

    // Text
    params = new Params();

    params.setText(text);

    expectedString = "&" + Constants.PARAM_TEXT + "=" + encode(text)
                     + "&" + Constants.PARAM_LANGUAGE + "=" + Language.DETECT.toString().toLowerCase()
                     + "&" + Constants.PARAM_OUTPUT_FORMAT + "=" + Constants.DEFAULT_OUTPUT_FORMAT;

    assertEquals(expectedString, params.toString());

    // url
    params = new Params();

    params.setURL(url);

    expectedString = "&" + Constants.PARAM_URL + "=" + encode(url)
                     + "&" + Constants.PARAM_LANGUAGE + "=" + Language.DETECT.toString().toLowerCase()
                     + "&" + Constants.PARAM_OUTPUT_FORMAT + "=" + Constants.DEFAULT_OUTPUT_FORMAT;

    assertEquals(expectedString, params.toString());

    // html + text
    params = new Params();

    params.setHtml(html);
    params.setText(text);

    expectedString = "&" + Constants.PARAM_HTML + "=" + encode(html)
                     + "&" + Constants.PARAM_TEXT + "=" + encode(text)
                     + "&" + Constants.PARAM_LANGUAGE + "=" + Language.DETECT.toString().toLowerCase()
                     + "&" + Constants.PARAM_OUTPUT_FORMAT + "=" + Constants.DEFAULT_OUTPUT_FORMAT;

    assertEquals(expectedString, params.toString());

    // text + url
    params = new Params();

    params.setText(text);
    params.setURL(url);

    expectedString = "&" + Constants.PARAM_TEXT + "=" + encode(text)
                     + "&" + Constants.PARAM_URL + "=" + encode(url)
                     + "&" + Constants.PARAM_LANGUAGE + "=" + Language.DETECT.toString().toLowerCase()
                     + "&" + Constants.PARAM_OUTPUT_FORMAT + "=" + Constants.DEFAULT_OUTPUT_FORMAT;

    assertEquals(expectedString, params.toString());

    // html + url
    params = new Params();

    params.setHtml(html);
    params.setURL(url);

    expectedString = "&" + Constants.PARAM_HTML + "=" + encode(html)
                     + "&" + Constants.PARAM_URL + "=" + encode(url)
                     + "&" + Constants.PARAM_LANGUAGE + "=" + Language.DETECT.toString().toLowerCase()
                     + "&" + Constants.PARAM_OUTPUT_FORMAT + "=" + Constants.DEFAULT_OUTPUT_FORMAT;

    assertEquals(expectedString, params.toString());

    // html + text + url
    params = new Params();

    params.setHtml(html);
    params.setText(text);
    params.setURL(url);

    expectedString = "&" + Constants.PARAM_HTML + "=" + encode(html)
                     + "&" + Constants.PARAM_TEXT + "=" + encode(text)
                     + "&" + Constants.PARAM_URL + "=" + encode(url)
                     + "&" + Constants.PARAM_LANGUAGE + "=" + Language.DETECT.toString().toLowerCase()
                     + "&" + Constants.PARAM_OUTPUT_FORMAT + "=" + Constants.DEFAULT_OUTPUT_FORMAT;

    assertEquals(expectedString, params.toString());
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
