/**
 * File: NamedEntityParser.java
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

import com.likethecolor.alchemy.api.entity.DisambiguatedAlchemyEntity;
import com.likethecolor.alchemy.api.entity.NamedEntityAlchemyEntity;
import com.likethecolor.alchemy.api.entity.QuotationAlchemyEntity;
import com.likethecolor.alchemy.api.entity.Response;
import com.likethecolor.alchemy.api.entity.SentimentAlchemyEntity;
import org.apache.commons.lang.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class NamedEntityParser extends AbstractParser<NamedEntityAlchemyEntity> {
  @Override
  protected void populateResponse(final Response<NamedEntityAlchemyEntity> response) {
    final JSONObject jsonObject = getJSONObject();
    final JSONArray namedEntities = getJSONArray(JSONConstants.RANKED_NAMED_ENTITIES, jsonObject);
    if(namedEntities.length() > 0) {
      NamedEntityAlchemyEntity entity;
      SentimentAlchemyEntity sentimentAlchemyEntity;
      JSONObject namedEntityJsonObject;
      Integer count;
      Double score;
      String text;
      String type;
      for(int i = 0; i < namedEntities.length(); i++) {
        namedEntityJsonObject = getJSONObject(namedEntities, i);

        text = getString(JSONConstants.RANKED_NAMED_ENTITIES_TEXT_KEY, namedEntityJsonObject);
        type = getString(JSONConstants.RANKED_NAMED_ENTITIES_TYPE_KEY, namedEntityJsonObject);
        score = getDouble(JSONConstants.RANKED_NAMED_ENTITIES_SCORE_KEY, namedEntityJsonObject);
        count = getInteger(JSONConstants.RANKED_NAMED_ENTITIES_COUNT_KEY, namedEntityJsonObject);
        if(isValidNamedEntity(score, text)) {
          entity = new NamedEntityAlchemyEntity(text, type, count, score);
          sentimentAlchemyEntity = getSentiment(namedEntityJsonObject);
          if(sentimentAlchemyEntity != null) {
            entity.setSentiment(sentimentAlchemyEntity);
          }

          addQuotations(entity, namedEntityJsonObject);
          addDisambiguated(entity, namedEntityJsonObject);
          response.addEntity(entity);
        }
      }
    }
  }

  private void addDisambiguated(final NamedEntityAlchemyEntity entity, final JSONObject namedEntityJsonObject) {
    final JSONObject disambiguatedJsonObject = getJSONObject(JSONConstants.RANKED_NAMED_ENTITIES_DISAMBIGUATED_KEY, namedEntityJsonObject);

    final DisambiguatedEntityParser parser = new DisambiguatedEntityParser();

    DisambiguatedAlchemyEntity disambiguatedAlchemyEntity = parser.getEntity(disambiguatedJsonObject);
    if(disambiguatedAlchemyEntity == null) {
      return;
    }
    entity.setDisambiguatedAlchemyEntity(disambiguatedAlchemyEntity);
  }

  private void addQuotations(final NamedEntityAlchemyEntity entity, final JSONObject namedEntityJsonObject) {
    JSONArray quotations = getJSONArray(JSONConstants.QUOTATIONS_KEY, namedEntityJsonObject);
    if(quotations.length() > 0) {
      JSONObject quotationJsonObject;
      String quotation;
      QuotationAlchemyEntity quotationAlchemyEntity;
      SentimentAlchemyEntity sentimentAlchemyEntity;
      for(int i = 0; i < quotations.length(); i++) {
        quotationJsonObject = getJSONObject(quotations, i);
        quotation = getString(JSONConstants.QUOTATIONS_QUOTATION_KEY, quotationJsonObject);

        if(!StringUtils.isBlank(quotation)) {
          quotationAlchemyEntity = new QuotationAlchemyEntity(quotation);
          sentimentAlchemyEntity = getSentiment(quotationJsonObject);
          if(sentimentAlchemyEntity != null) {
            quotationAlchemyEntity.setSentiment(sentimentAlchemyEntity);
          }
          entity.addQuotation(quotationAlchemyEntity);
        }
      }
    }
  }

  private SentimentAlchemyEntity getSentiment(final JSONObject namedEntityJsonObject) {
    final JSONObject sentimentJsonObject = getJSONObject(JSONConstants.SENTIMENT_KEY, namedEntityJsonObject);
    final Integer sentimentIsMixed = getInteger(JSONConstants.SENTIMENT_MIXED_KEY, sentimentJsonObject);
    final Double sentimentScore = getDouble(JSONConstants.SENTIMENT_SCORE_KEY, sentimentJsonObject);
    final String sentimentType = getString(JSONConstants.SENTIMENT_TYPE_KEY, sentimentJsonObject);

    SentimentAlchemyEntity sentimentAlchemyEntity = null;
    if(isValidSentiment(sentimentJsonObject, sentimentIsMixed, sentimentScore, sentimentType)) {
      sentimentAlchemyEntity = new SentimentAlchemyEntity();
      if(sentimentIsMixed != null) {
        sentimentAlchemyEntity.setIsMixed(sentimentIsMixed);
      }
      if(sentimentScore != null) {
        sentimentAlchemyEntity.setScore(sentimentScore);
      }
      if(!StringUtils.isBlank(sentimentType)) {
        sentimentAlchemyEntity.setType(sentimentType);
      }
    }
    return sentimentAlchemyEntity;
  }

  /**
   * Return true if at least one of the values is not null/empty.
   *
   * @param score relevance score
   * @param text detected entity text
   *
   * @return true if at least one of the values is not null/empty
   */
  private boolean isValidNamedEntity(final Double score, final String text) {
    return !StringUtils.isBlank(text)
           || score != null;
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
