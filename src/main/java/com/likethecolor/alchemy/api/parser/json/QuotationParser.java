/**
 * File: QuotationParser.java
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

import com.likethecolor.alchemy.api.entity.QuotationAlchemyEntity;
import com.likethecolor.alchemy.api.entity.Response;
import org.json.JSONArray;
import org.json.JSONObject;

public class QuotationParser extends AbstractParser<QuotationAlchemyEntity> {
  @Override
  protected void populateResponse(Response<QuotationAlchemyEntity> response) {
    final JSONObject jsonObject = getJSONObject();
    final JSONArray quotation = getJSONArray(JSONConstants.QUOTATIONS_QUOTATION_KEY, jsonObject);
  }
}
