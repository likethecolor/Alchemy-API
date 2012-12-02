/**
 * File: ApiKeyResourceValidator.java
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

import java.io.File;
import java.net.URL;

public class ApiKeyResourceValidator {
  public static void validate(final String apiKeyFileName) {
    final URL resourceUrl = ApiKeyResourceValidator.class.getResource(apiKeyFileName);
    if(resourceUrl == null || !new File(resourceUrl.getPath()).exists()) {
      throw new IllegalArgumentException("File containing API key does not exist: " + apiKeyFileName);
    }
  }
}
