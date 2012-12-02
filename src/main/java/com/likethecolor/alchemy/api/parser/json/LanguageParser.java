/**
 * File: LanguageParser.java
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
package com.likethecolor.alchemy.api.parser.json;

import com.likethecolor.alchemy.api.entity.LanguageAlchemyEntity;
import com.likethecolor.alchemy.api.entity.Response;
import org.apache.commons.lang.StringUtils;
import org.json.JSONObject;

public class LanguageParser extends AbstractParser<LanguageAlchemyEntity> {
  @Override
  protected void populateResponse(Response<LanguageAlchemyEntity> response) {
    final JSONObject jsonObject = getJSONObject();
    final String ethnologue = getString(JSONConstants.LANGUAGE_ETHNOLOGUE_KEY, jsonObject);
    final String language = getString(JSONConstants.LANGUAGE_LANGUAGE_KEY, jsonObject);
    final String iso6391 = getString(JSONConstants.LANGUAGE_ISO6391_KEY, jsonObject);
    final String iso6392 = getString(JSONConstants.LANGUAGE_ISO6392_KEY, jsonObject);
    final String iso6393 = getString(JSONConstants.LANGUAGE_ISO6393_KEY, jsonObject);
    final String numberOfNativeSpeakers = getString(JSONConstants.LANGUAGE_NUMBER_OF_NATIVE_SPEAKERS_KEY, jsonObject);
    final String wikipedia = getString(JSONConstants.LANGUAGE_WIKIPEDIA_KEY, jsonObject);

    if(!StringUtils.isBlank(language)) {
      final LanguageAlchemyEntity entity = new LanguageAlchemyEntity(language);
      entity.setEthnologue(ethnologue);
      entity.setIso6391(iso6391);
      entity.setIso6392(iso6392);
      entity.setIso6393(iso6393);
      entity.setNumberOfNativeSpeakers(numberOfNativeSpeakers);
      entity.setWikipedia(wikipedia);

      response.addEntity(entity);
    }
  }
}
