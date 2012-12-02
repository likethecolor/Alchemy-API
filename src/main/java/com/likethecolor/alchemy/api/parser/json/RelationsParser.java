/**
 * File: RelationsParser.java
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

import com.likethecolor.alchemy.api.entity.AlchemyAction;
import com.likethecolor.alchemy.api.entity.AlchemyEntity;
import com.likethecolor.alchemy.api.entity.AlchemyObject;
import com.likethecolor.alchemy.api.entity.AlchemySubject;
import com.likethecolor.alchemy.api.entity.AlchemyVerb;
import com.likethecolor.alchemy.api.entity.DisambiguatedAlchemyEntity;
import com.likethecolor.alchemy.api.entity.RelationAlchemyEntity;
import com.likethecolor.alchemy.api.entity.Response;
import com.likethecolor.alchemy.api.entity.SentimentAlchemyEntity;
import org.apache.commons.lang.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class RelationsParser extends AbstractParser<RelationAlchemyEntity> {
  @Override
  protected void populateResponse(Response<RelationAlchemyEntity> response) {
    final JSONObject jsonObject = getJSONObject();
    final JSONArray relations = getJSONArray(JSONConstants.RELATIONS_KEY, jsonObject);
    if(relations != null) {
      RelationAlchemyEntity entity;

      for(int i = 0; i < relations.length(); i++) {
        entity = new RelationAlchemyEntity();
        JSONObject o = getJSONObject(relations, i);
        addAction(entity, getJSONObject(JSONConstants.RELATIONS_ACTION_KEY, o));
        addSubject(entity, getJSONObject(JSONConstants.RELATIONS_SUBJECT_KEY, o));
        addObject(entity, getJSONObject(JSONConstants.RELATIONS_OBJECT_KEY, o));
        response.addEntity(entity);
      }
    }
  }

  private void addAction(final RelationAlchemyEntity entity, final JSONObject jsonObject) {
    if(jsonObject != null) {
      final String text = getString(JSONConstants.RELATIONS_ACTION_TEXT_KEY, jsonObject);
      final String lematized = getString(JSONConstants.RELATIONS_LEMMATIZED_KEY, jsonObject);
      final AlchemyAction action = new AlchemyAction();
      action.setText(text);
      action.setLematized(lematized);

      final JSONObject verbJson = getJSONObject(JSONConstants.RELATIONS_VERB_KEY, jsonObject);
      if(verbJson != null) {
        final String verbText = getString(JSONConstants.RELATIONS_VERB_TEXT_KEY, verbJson);
        final String tense = getString(JSONConstants.RELATIONS_VERB_TENSE_KEY, verbJson);
        final Integer isNegated = getInteger(JSONConstants.RELATIONS_VERB_NEGATED_KEY, verbJson);
        final AlchemyVerb verb = new AlchemyVerb(isNegated, tense, verbText);
        if(isValidVerb(verb)) {
          action.setVerb(verb);
        }
      }

      if(isValidAction(action)) {
        entity.setAction(action);
      }
    }
  }

  private void addSubject(final RelationAlchemyEntity entity, final JSONObject jsonObject) {
    if(jsonObject != null) {
      final String text = getString(JSONConstants.RELATIONS_SUBJECT_TEXT_KEY, jsonObject);

      final AlchemySubject subject = new AlchemySubject();
      subject.setText(text);

      final SentimentAlchemyEntity sentimentAlchemyEntity = getSentiment(JSONConstants.SENTIMENT_KEY, jsonObject);
      if(sentimentAlchemyEntity != null) {
        subject.setSentiment(sentimentAlchemyEntity);
      }

      AlchemyEntity alchemyEntity = getEntity(jsonObject);
      if(alchemyEntity != null) {
        subject.setEntity(alchemyEntity);
      }

      if(isValidSubject(subject)) {
        entity.setSubject(subject);
      }
    }
  }

  private void addObject(final RelationAlchemyEntity entity, final JSONObject jsonObject) {
    if(jsonObject != null) {
      final String text = getString(JSONConstants.RELATIONS_OBJECT_TEXT_KEY, jsonObject);
      final AlchemyObject object = new AlchemyObject();
      object.setText(text);

      SentimentAlchemyEntity sentimentAlchemyEntity = getSentiment(JSONConstants.SENTIMENT_KEY, jsonObject);
      if(sentimentAlchemyEntity != null) {
        object.setSentiment(sentimentAlchemyEntity);
      }

      sentimentAlchemyEntity = getSentiment(JSONConstants.RELATIONS_SENTIMENT_FROM_SUBJECT_KEY, jsonObject);
      if(sentimentAlchemyEntity != null) {
        object.setSentimentFromSubject(sentimentAlchemyEntity);
      }

      AlchemyEntity alchemyEntity = getEntity(jsonObject);
      if(alchemyEntity != null) {
        object.setEntity(alchemyEntity);
      }

      if(isValidObject(object)) {
        entity.setObject(object);
      }
    }
  }

  private void addDisambiguated(final AlchemyEntity entity, final JSONObject json) {
    final JSONObject disambiguatedJsonObject = getJSONObject(JSONConstants.DISAMBIGUATED_KEY, json);

    final DisambiguatedEntityParser parser = new DisambiguatedEntityParser();

    DisambiguatedAlchemyEntity disambiguatedAlchemyEntity = parser.getEntity(disambiguatedJsonObject);
    if(disambiguatedAlchemyEntity == null) {
      return;
    }
    entity.setDisambiguatedAlchemyEntity(disambiguatedAlchemyEntity);
  }

  private AlchemyEntity getEntity(final JSONObject jsonObject) {
    final JSONObject entityJsonObject = getJSONObject(JSONConstants.RELATIONS_ENTITY_KEY, jsonObject);
    final String type = getString(JSONConstants.RELATIONS_ENTITY_TYPE_KEY, entityJsonObject);
    final String text = getString(JSONConstants.RELATIONS_ENTITY_TEXT_KEY, entityJsonObject);

    AlchemyEntity entity = null;
    if(!StringUtils.isBlank(type) || !StringUtils.isBlank(text)) {
      entity = new AlchemyEntity(text, type);

      addDisambiguated(entity, entityJsonObject);
    }
    return entity;
  }

  private SentimentAlchemyEntity getSentiment(final String key, final JSONObject jsonObject) {
    final JSONObject sentimentJsonObject = getJSONObject(key, jsonObject);
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

  private boolean isValidAction(final AlchemyAction action) {
    return !StringUtils.isBlank(action.getLematized()) || !StringUtils.isBlank(action.getText());
  }

  private boolean isValidSubject(final AlchemySubject subject) {
    return subject != null
           && (subject.getEntity() != null
               || subject.getSentiment() != null
               || !StringUtils.isBlank(subject.getText()));
  }

  private boolean isValidObject(final AlchemyObject object) {
    return object != null
           && (object.getEntity() != null
               || object.getSentiment() != null
               || object.getSentimentFromSubject() != null
               || !StringUtils.isBlank(object.getText()));
  }

  private boolean isValidVerb(final AlchemyVerb verb) {
    return !StringUtils.isBlank(verb.getText()) ||
           !verb.getTense().equals(AlchemyVerb.TENSE.UNSET);
  }
}
