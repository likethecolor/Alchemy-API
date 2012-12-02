/**
 * File: SentimentParser.java
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

import com.likethecolor.alchemy.api.entity.SentimentAlchemyEntity;
import com.likethecolor.alchemy.api.entity.Response;
import com.likethecolor.alchemy.api.entity.SentimentAlchemyEntity;
import org.apache.commons.lang.StringUtils;
import org.json.JSONObject;

public class SentimentParser extends AbstractParser<SentimentAlchemyEntity> {
  @Override
  protected void populateResponse(final Response<SentimentAlchemyEntity> response) {
    final JSONObject jsonObject = getJSONObject();
    final JSONObject sentimentJsonObject = getJSONObject(JSONConstants.TARGETED_SENTIMENT_KEY, jsonObject);
    final Integer isMixed = getInteger(JSONConstants.TARGETED_SENTIMENT_MIXED_KEY, sentimentJsonObject);
    final Double score = getDouble(JSONConstants.TARGETED_SENTIMENT_SCORE_KEY, sentimentJsonObject);
    final String type = getString(JSONConstants.TARGETED_SENTIMENT_TYPE_KEY, sentimentJsonObject);

    if(isValidSentiment(sentimentJsonObject, isMixed, score, type)) {
      SentimentAlchemyEntity sentimentAlchemyEntity = new SentimentAlchemyEntity();
      if(isMixed != null) {
        sentimentAlchemyEntity.setIsMixed(isMixed);
      }
      if(!StringUtils.isBlank(type)) {
        sentimentAlchemyEntity.setType(type);
      }
      if(score != null) {
        sentimentAlchemyEntity.setScore(score);
      }
      response.addEntity(sentimentAlchemyEntity);
    }
  }

  /**
   * Return true if at least one of the values is not null/empty.
   *
   * @param mixed whether the sentiment is mixed
   * @param score the sentiment score
   * @param type the sentiment type
   *
   * @return true if at least one of the values is not null/empty
   */
  private boolean isValidSentiment(final JSONObject sentimentJsonObject, final Integer mixed, final Double score, final String type) {
    return sentimentJsonObject != null
           || !StringUtils.isBlank(type)
           || score != null
           || mixed != null;
  }
}
