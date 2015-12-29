/**
 * Contributing Author: Ainur Minibaev <rapper01@list.ru>
 * Copyright 2015 Dan Brown <dan@likethecolor.com>
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.likethecolor.alchemy.api.parser.json;

import com.likethecolor.alchemy.api.entity.ImageEntity;
import com.likethecolor.alchemy.api.entity.Response;
import org.apache.commons.lang.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ImageParser extends AbstractParser<ImageEntity> {
  public ImageParser() {
    super();
  }
  
  @Override
  protected void populateResponse(Response<ImageEntity> response) {
    JSONObject jsonObject = getJSONObject();
    JSONArray imageKeywords = getJSONArray(JSONConstants.IMAGE_KEYWORDS_KEY, jsonObject);

    if(imageKeywords.length() > 0) {
      ImageEntity entity;
      JSONObject imageJsonObject;
      String imageKeyword;
      Double score;
      for(int i = 0; i < imageKeywords.length(); i++) {
        imageJsonObject = getImageKeyword(imageKeywords, i);

        imageKeyword = getString(JSONConstants.IMAGE_KEYWORD_TEXT_KEY, imageJsonObject);
        score = getDouble(JSONConstants.IMAGE_KEYWORD_SCORE_KEY, imageJsonObject);
        if(isValidImage(imageKeyword, score)) {
          entity = new ImageEntity(imageKeyword, score);
          response.addEntity(entity);
        }
      }
    }
  }

  /**
   * Return a json object from the provided array.  Return an empty object if
   * there is any problems fetching the concept data.
   *
   * @param imageKeywords array of image keyword data
   * @param index of the object to fetch
   *
   * @return json object from the provided array
   */
  private JSONObject getImageKeyword(final JSONArray imageKeywords, final int index) {
    JSONObject object = new JSONObject();
    try {
      object = (JSONObject) imageKeywords.get(index);
    }
    catch(JSONException e) {
      e.printStackTrace();
    }
    return object;
  }

  /**
   * Return true if at least one of the values is not null/empty.
   *
   * @param imageKeyword the image keyword
   * @param score the score
   *
   * @return true if at least one of the values is not null/empty
   */
  private boolean isValidImage(final String imageKeyword, final Double score) {
    return !StringUtils.isBlank(imageKeyword)
           || score != null;
  }
}
