/**
 * File: CallType.java
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

import com.likethecolor.alchemy.api.params.Params;

public interface CallType {
  /**
   * This method will set the call type values onto the params.
   *
   * @param params params object on which to set call type values
   */
  public void setValuesOnParams(final Params params);

  /**
   * A call to the Alchemy API changes the end point name based on the call type.
   * For example, a call to the GetTextSentiment will have the name <b>URL</b>GetTextSentiment
   * when getting the sentiment from a page based on the url.  It will have the
   * name <b>Text</b>GetTextSentiment when receiving the text to process.  This method
   * returns that prefix (HTML, URL, Text).
   *
   * @return prefix for the endpoint name
   */
  public String getPrefix();

  /**
   * A call to the Alchemy API changes the url based on the call type.  For example,
   * a call to the TextGetTextSentiment will use http://access.alchemyapi.com/calls/<b>text</b>/TextGetTextSentiment?....
   * A call to the UrlGetTextSentiment will use http://access.alchemyapi.com/calls/<b>url</b>/URLGetTextSentiment?....
   * A call to the HTMLGetTextSentiment will use http://access.alchemyapi.com/calls/<b>html</b>/HTMLGetTextSentiment?....
   * This method returns that string that appears between ".../calls/" and the
   * end point.
   *
   * @return text used in the url string
   */
  public String getType();
}
