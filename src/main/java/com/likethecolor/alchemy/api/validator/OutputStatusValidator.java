/**
 * File: OutputStatusValidator.java
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
package com.likethecolor.alchemy.api.validator;

import com.likethecolor.alchemy.api.entity.Response;
import com.likethecolor.alchemy.api.parser.json.HeaderParser;
import org.apache.commons.lang.StringUtils;

import java.io.IOException;

public class OutputStatusValidator {
  public static void validate(final String jsonString) throws IOException {
    OutputDocumentValidator.validate(jsonString);

    final Response response = new HeaderParser().parse(jsonString);
    final Response.STATUS status = response.getStatus();
    final String statusInfo = response.getStatusInfo();
    validate(status, statusInfo, jsonString);
  }

  private static void validate(final Response.STATUS status, final String statusInfo, final String originalJsonString) throws IOException {
    if(null == status || status != Response.STATUS.OK) {
      if(!StringUtils.isBlank(statusInfo)) {
        throw new IOException("Error making API call: " + statusInfo + " - original json string: " + originalJsonString);
      }
      throw new IOException("Error making API call: " + status + " - original json string: " + originalJsonString);
    }
  }
}
