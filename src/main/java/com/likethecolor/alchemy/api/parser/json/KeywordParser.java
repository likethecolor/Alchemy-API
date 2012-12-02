/**
 * File: KeywordParser.java
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

import com.likethecolor.alchemy.api.entity.KeywordAlchemyEntity;
import com.likethecolor.alchemy.api.entity.Response;
import com.likethecolor.alchemy.api.entity.SentimentAlchemyEntity;
import org.apache.commons.lang.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class KeywordParser extends AbstractParser<KeywordAlchemyEntity> {
  @Override
  protected void populateResponse(final Response response) {
    final JSONObject jsonObject = getJSONObject();
    final JSONArray keywords = getJSONArray(JSONConstants.RANKED_KEYWORDS, jsonObject);
    if(keywords.length() > 0) {
      KeywordAlchemyEntity entity;
      JSONObject keywordJsonObject;
      String keyword;
      Double score;
      for(int i = 0; i < keywords.length(); i++) {
        keywordJsonObject = getKeyword(keywords, i);

        keyword = getString(JSONConstants.RANKED_KEYWORDS_TEXT_KEY, keywordJsonObject);
        score = getDouble(JSONConstants.RANKED_KEYWORDS_SCORE_KEY, keywordJsonObject);
        if(isValidKeyword(keyword, score)) {
          entity = new KeywordAlchemyEntity(keyword, score);
          entity.setSentiment(getSentiment(keywordJsonObject));
          response.addEntity(entity);
        }
      }
    }
  }

  /**
   * Return a json object from the provided array.  Return an empty object if
   * there is any problems fetching the keyword data.
   *
   * @param keywords array of keyword data
   * @param index of the object to fetch
   *
   * @return json object from the provided array
   */
  private JSONObject getKeyword(final JSONArray keywords, final int index) {
    JSONObject object = new JSONObject();
    try {
      object = (JSONObject) keywords.get(index);
    }
    catch(JSONException e) {
      e.printStackTrace();
    }
    return object;
  }

  /**
   * Return a sentiment object populated by the values in the json object.  Return
   * null if there are no sentiment data.
   *
   * @param jsonKeyword object containing the keyword values
   *
   * @return sentiment object populated by the values in the json object
   */
  private SentimentAlchemyEntity getSentiment(final JSONObject jsonKeyword) {
    SentimentAlchemyEntity sentiment = null;
    final JSONObject sentimentObject = getJSONObject(JSONConstants.SENTIMENT_KEY, jsonKeyword);
    if(sentimentObject == null) {
      return sentiment;
    }

    final String type = getString(JSONConstants.SENTIMENT_TYPE_KEY, sentimentObject);
    final Double score = getDouble(JSONConstants.SENTIMENT_SCORE_KEY, sentimentObject);
    final Integer mixed = getInteger(JSONConstants.SENTIMENT_MIXED_KEY, sentimentObject);

    if(isValidSentiment(type, score, mixed)) {
      sentiment = new SentimentAlchemyEntity();
      if(!StringUtils.isBlank(type)) {
        sentiment.setType(type);
      }
      if(score != null) {
        sentiment.setScore(score);
      }
      if(mixed != null) {
        sentiment.setIsMixed(mixed);
      }
    }
    return sentiment;
  }

  /**
   * Return true if at least one of the values is not null/empty.
   *
   * @param keyword the sentiment keyword
   * @param score the sentiment score
   *
   * @return true if at least one of the values is not null/empty
   */
  private boolean isValidKeyword(final String keyword, final Double score) {
    return !StringUtils.isBlank(keyword)
           || score != null;
  }

  /**
   * Return true if at least one of the values is not null/empty.
   *
   * @param type the sentiment type
   * @param score the sentiment score
   * @param mixed whether the sentiment is mixed
   *
   * @return true if at least one of the values is not null/empty
   */
  private boolean isValidSentiment(final String type, final Double score, final Integer mixed) {
    return !StringUtils.isBlank(type)
           || score != null
           || mixed != null;
  }
}
