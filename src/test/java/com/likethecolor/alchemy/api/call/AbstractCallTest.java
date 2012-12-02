/**
 * File: AbstractCallTest.java
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
package com.likethecolor.alchemy.api.call;

import com.likethecolor.alchemy.api.call.type.CallType;
import com.likethecolor.alchemy.api.call.type.CallTypeUrl;
import com.likethecolor.alchemy.api.entity.Response;
import com.likethecolor.alchemy.api.params.Params;
import com.likethecolor.alchemy.api.params.RelationParams;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AbstractCallTest {
  @Test
  public void testConstructor() {
    final Params params = new Params();
    final CallType callType = new CallTypeUrl("http://www.example.com/");

    final MockCall call = new MockCall(callType, params);

    assertEquals(params, call.getParams());
    assertEquals(callType, call.getCallType());
  }

  @Test
  public void testConstructor_OneArg() {
    final CallType callType = new CallTypeUrl("http://www.example.com/");

    final MockCall call = new MockCall(callType);

    assertTrue(call.getParams().getClass().getName().endsWith(".Params"));
    assertEquals(callType, call.getCallType());
  }

  @Test
  public void testCallType() {
    final CallType callType = new CallTypeUrl("http://www.example.com/");

    final MockCall call = new MockCall(callType);

    assertEquals(callType, call.getCallType());
  }

  @Test
  public void testParams_DefaultParams() {
    MockCall call = new MockCall(null, null);

    Params actualParams = call.getParams();

    assertTrue(actualParams.getClass().getName().endsWith(".Params"));
  }

  @Test
  public void testParams() {
    Params params = new RelationParams();
    final MockCall call = new MockCall(null);

    call.setParams(params);

    final Params actualParams = call.getParams();

    assertTrue(actualParams.getClass().getName().endsWith(".RelationParams"));
  }

  // have to extend it - it's abstract
  class MockCall extends AbstractCall {
    public MockCall(final CallType callType) {
      super(callType);
    }

    public MockCall(final CallType callType, final Params params) {
      super(callType, params);
    }

    @Override
    public String getName() {
      return null;
    }

    @Override
    public Response parse(String jsonString) {
      return null;
    }
  }
}
