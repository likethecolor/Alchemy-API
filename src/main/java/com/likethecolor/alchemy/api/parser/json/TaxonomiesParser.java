/**
 * File: TaxonomiesParser.java
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

import com.likethecolor.alchemy.api.entity.TaxonomyAlchemyEntity;
import com.likethecolor.alchemy.api.entity.Response;
import org.apache.commons.lang.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TaxonomiesParser extends AbstractParser<TaxonomyAlchemyEntity> {
  protected void populateResponse(final Response<TaxonomyAlchemyEntity> response) {
    final JSONObject jsonObject = getJSONObject();
    final JSONArray taxonomies = getJSONArray(JSONConstants.TAXONOMY_KEY, jsonObject);

    if(taxonomies.length() > 0) {
      JSONObject taxonomyJsonObject;
      TaxonomyAlchemyEntity entity;
      Boolean isConfident; // big-B since it can be no value
      String label;
      Double score;
      for(int i = 0; i < taxonomies.length(); i++) {
        taxonomyJsonObject = getTaxonomy(taxonomies, i);

        isConfident = getBoolean(JSONConstants.TAXONOMY_CONFIDENCE_KEY, taxonomyJsonObject);
        label = getString(JSONConstants.TAXONOMY_LABEL_KEY, taxonomyJsonObject);
        score = getDouble(JSONConstants.TAXONOMY_SCORE_KEY, taxonomyJsonObject);
        if(isValidTaxonomy(label, score)) {
          entity = new TaxonomyAlchemyEntity(label, score, isConfident);
          response.addEntity(entity);
        }
      }
    }
  }

  /**
   * Return a json object from the provided array.  Return an empty object if
   * there is any problems fetching the taxonomy data.
   *
   * @param taxonomies array of taxonomy data
   * @param index of the object to fetch
   *
   * @return json object from the provided array
   */
  private JSONObject getTaxonomy(final JSONArray taxonomies, final int index) {
    JSONObject object = new JSONObject();
    try {
      object = (JSONObject) taxonomies.get(index);
    }
    catch(JSONException e) {
      e.printStackTrace();
    }
    return object;
  }

  /**
   * Return true if at least one of the values is not null/empty.
   *
   * @param label the label text
   * @param score the sentiment score
   *
   * @return true if at least one of the values is not null/empty
   */
  private boolean isValidTaxonomy(final String label, final Double score) {
    return !StringUtils.isBlank(label)
           || score != null;
  }
}
