/**
 * File: TargetedSentimentParams.java
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
package com.likethecolor.alchemy.api.params;

import com.likethecolor.alchemy.api.Constants;

public class TargetedSentimentParams extends Params {
  private boolean isShowSourceText;
  private String target;

  public void setIsShowSourceText(boolean isShowSourceText) {
    this.isShowSourceText = isShowSourceText;
  }

  public boolean isShowSourceText() {
    return isShowSourceText;
  }

  public void setTarget(String target) {
    if(target != null) {
      target = target.trim();
    }
    this.target = target;
  }

  public String getTarget() {
    return target;
  }

  public String toString() {
    return new StringBuilder(super.toString())
        .append(createParam(Constants.PARAM_SHOW_SOURCE_TEXT,
            isShowSourceText ? 1 : 0))
        .append(createParam(Constants.PARAM_TARGET, encode(target)))
        .toString();
  }
}
