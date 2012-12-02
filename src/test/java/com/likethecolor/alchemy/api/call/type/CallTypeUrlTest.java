/**
 * File: CallTypeUrlTest.java
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
package com.likethecolor.alchemy.api.call.type;

import com.likethecolor.alchemy.api.Constants;
import com.likethecolor.alchemy.api.params.Params;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class CallTypeUrlTest {
  @Test
  public void testGetPrefix() {
    final String url = "http://some.host.com/";
    final CallType callType = new CallTypeUrl(url);

    final String actualPrefix = callType.getPrefix();

    assertEquals(Constants.CALL_TYPE_PREFIX_URL, actualPrefix);
  }

  @Test
  public void testGetType() {
    final String url = "http://some.host.com/";
    final CallType callType = new CallTypeUrl(url);

    final String actualType = callType.getType();

    assertEquals(Constants.CALL_TYPE_URL, actualType);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNullUrl() {
    final String url = null;
    new CallTypeUrl(url);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidUrl() {
    final String url = "http://";
    new CallTypeUrl(url);
  }

  @Test
  public void testSetValueOnParams() {
    final String url = "http://some.host.com/";
    final CallType callType = new CallTypeUrl(url);

    final Params params = new Params();

    callType.setValuesOnParams(params);

    assertEquals(url, params.getURL());
    assertNull(params.getHtml());
    assertNull(params.getText());
  }
}
