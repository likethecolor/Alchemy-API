/**
 * File: CallTypeHtml.java
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
package com.likethecolor.alchemy.api.call.type;

import com.likethecolor.alchemy.api.Constants;
import com.likethecolor.alchemy.api.params.Params;
import com.likethecolor.alchemy.api.validator.HtmlValidator;

public class CallTypeHtml implements CallType {
  private String html;
  private String url;

  public CallTypeHtml(final String url, final String html) {
    HtmlValidator.validate(html, url);
    this.html = html.trim();
    this.url = url.trim();
  }

  public void setValuesOnParams(final Params params) {
    params.setHtml(html);
    params.setURL(url);
  }

  public String getPrefix() {
    return Constants.CALL_TYPE_PREFIX_HTML;
  }

  public String getType() {
    return Constants.CALL_TYPE_HTML;
  }
}
