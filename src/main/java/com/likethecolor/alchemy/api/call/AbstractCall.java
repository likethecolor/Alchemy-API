/**
 * File: AbstractCall.java
 * Original Author: Dan Brown <dan@likethecolor.com>
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
import com.likethecolor.alchemy.api.entity.AbstractAlchemyEntity;
import com.likethecolor.alchemy.api.entity.Response;
import com.likethecolor.alchemy.api.params.Params;

public abstract class AbstractCall<T extends AbstractAlchemyEntity> {
  private CallType callType;
  private Params params;

  public AbstractCall(final CallType callType) {
    this(callType, new Params());
  }

  public AbstractCall(final CallType callType, final Params params) {
    setCallType(callType);
    setParams(params);
  }

  public abstract String getName();

  public abstract Response<T> parse(final String jsonString);

  public void setCallType(final CallType callType) {
    this.callType = callType;
  }

  public CallType getCallType() {
    return callType;
  }

  public AbstractCall setParams(final Params params) {
    this.params = params;
    return this;
  }

  public Params getParams() {
    if(params != null) {
      return params;
    }
    return new Params();
  }
}
