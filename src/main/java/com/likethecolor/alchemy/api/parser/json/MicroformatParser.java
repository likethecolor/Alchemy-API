/**
 * File: MicroformatParser.java
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

import com.likethecolor.alchemy.api.entity.MicroformatAlchemyEntity;
import com.likethecolor.alchemy.api.entity.Response;
import org.apache.commons.lang.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class MicroformatParser extends AbstractParser<MicroformatAlchemyEntity> {
  @Override
  protected void populateResponse(Response<MicroformatAlchemyEntity> response) {
    final JSONObject jsonObject = getJSONObject();
    final JSONArray microformats = getJSONArray(JSONConstants.MICROFORMATS_KEY, jsonObject);

    MicroformatAlchemyEntity entity;
    JSONObject microformat;
    String data;
    String field;
    if(microformats.length() > 0) {
      for(int i = 0; i < microformats.length(); i++) {
        microformat = getJSONObject(microformats, i);
        data = getString(JSONConstants.MICROFORMATS_DATA_KEY, microformat);
        field = getString(JSONConstants.MICROFORMATS_FIELD_KEY, microformat);
        if(isValid(data, field)) {
          entity = new MicroformatAlchemyEntity(data, field);
          response.addEntity(entity);
        }
      }
    }
  }

  private boolean isValid(final String data, final String field) {
    return !StringUtils.isBlank(data)
        || !StringUtils.isBlank(field);
  }
}
