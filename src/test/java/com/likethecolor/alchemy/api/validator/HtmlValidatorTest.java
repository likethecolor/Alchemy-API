/**
 * File: HtmlValidatorTest.java
 * Original Author: <dan@likethecolor.com>
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
package com.likethecolor.alchemy.api.validator;

import org.junit.Test;

public class HtmlValidatorTest {
  @Test(expected = IllegalArgumentException.class)
  public void testValidate_NullHtml() {
    final String html = null;
    final String url = "http://some.host.com";
    HtmlValidator.validate(html, url);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testValidate_NullUrl() {
    final String html = "<head><body>foo</body></head>";
    final String url = null;
    HtmlValidator.validate(html, url);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testValidate_HtmlLessThanMinimumLength() {
    final String html = "<a>";
    final String url = "http://some.host.com";
    HtmlValidator.validate(html, url);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testValidate_UrlLessThanMinimumLength() {
    final String html = "<head><body>foo</body></head>";
    final String url = "http://";
    HtmlValidator.validate(html, url);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testValidate_HtmlTrimmedLessThanMinimumLength() {
    final String html = "     <a>\t   \t\n";
    final String url = "http://some.host.com";
    HtmlValidator.validate(html, url);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testValidate_UrlTrimmedLessThanMinimumLength() {
    final String html = "<head><body>foo</body></head>";
    final String url = "\t\t\t\thttp://    \r\n";
    HtmlValidator.validate(html, url);
  }

  @Test
  public void testValidate_HtmlEqualsMinimumLength() {
    final String html = "<head";
    final String url = "http://some.host.com";
    HtmlValidator.validate(html, url);
  }

  @Test
  public void testValidate_UrlEqualsMinimumLength() {
    final String html = "<head><body>foo</body></head>";
    final String url = "http://som";
    HtmlValidator.validate(html, url);
  }

  @Test
  public void testValidate() {
    final String html = "<head><body>foo</body></head>";
    final String url = "http://some.host.com";
    HtmlValidator.validate(html, url);
  }
}
