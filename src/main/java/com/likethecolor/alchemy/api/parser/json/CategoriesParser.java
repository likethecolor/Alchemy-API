/**
 * File: CategoriesParser.java
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
package com.likethecolor.alchemy.api.parser.json;

import com.likethecolor.alchemy.api.entity.CategoryAlchemyEntity;
import com.likethecolor.alchemy.api.entity.Response;
import org.apache.commons.lang.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CategoriesParser extends AbstractParser<CategoryAlchemyEntity> {
  protected void populateResponse(final Response<CategoryAlchemyEntity> response) {
    final JSONObject jsonObject = getJSONObject();
    final JSONArray categories = getJSONArray(JSONConstants.RANKED_CATEGORIES, jsonObject);

    if(categories.length() > 0) {
      JSONObject categoryJsonObject;
      CategoryAlchemyEntity entity;
      String category;
      Double score;
      for(int i = 0; i < categories.length(); i++) {
        categoryJsonObject = getCategory(categories, i);

        category = getString(JSONConstants.RANKED_CATEGORIES_TEXT_KEY, categoryJsonObject);
        score = getDouble(JSONConstants.RANKED_CATEGORIES_SCORE_KEY, categoryJsonObject);
        if(isValidCategory(category, score)) {
          entity = new CategoryAlchemyEntity(category, score);
          response.addEntity(entity);
        }
      }
    }
  }

  /**
   * Return a json object from the provided array.  Return an empty object if
   * there is any problems fetching the category data.
   *
   * @param categories array of category data
   * @param index of the object to fetch
   *
   * @return json object from the provided array
   */
  private JSONObject getCategory(final JSONArray categories, final int index) {
    JSONObject object = new JSONObject();
    try {
      object = (JSONObject) categories.get(index);
    }
    catch(JSONException e) {
      e.printStackTrace();
    }
    return object;
  }

  /**
   * Return true if at least one of the values is not null/empty.
   *
   * @param category the category text
   * @param score the sentiment score
   *
   * @return true if at least one of the values is not null/empty
   */
  private boolean isValidCategory(final String category, final Double score) {
    return !StringUtils.isBlank(category)
           || score != null;
  }
}
