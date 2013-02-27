/**
 * File: ConceptParser.java
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

import com.likethecolor.alchemy.api.entity.ConceptAlchemyEntity;
import com.likethecolor.alchemy.api.entity.DisambiguatedAlchemyEntity;
import com.likethecolor.alchemy.api.entity.Response;
import org.apache.commons.lang.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ConceptParser extends AbstractParser<ConceptAlchemyEntity> {
	public ConceptParser() {
		super();
	}

	@Override
	protected void populateResponse(final Response<ConceptAlchemyEntity> response) {
		final JSONObject jsonObject = getJSONObject();
		final JSONArray concepts = getJSONArray(JSONConstants.RANKED_CONCEPTS, jsonObject);

		if (concepts.length() > 0) {
			ConceptAlchemyEntity entity;
			JSONObject conceptJsonObject;
			String concept;
			Double score;
			for (int i = 0; i < concepts.length(); i++) {
				conceptJsonObject = getConcept(concepts, i);

				concept = getString(JSONConstants.RANKED_CONCEPTS_TEXT_KEY, conceptJsonObject);
				score = getDouble(JSONConstants.RANKED_CONCEPTS_SCORE_KEY, conceptJsonObject);
				if (isValidConcept(concept, score)) {
					entity = new ConceptAlchemyEntity(concept, score);
					addDisambiguated(entity, conceptJsonObject);

					response.addEntity(entity);
				}
			}
		}
	}

	private void addDisambiguated(final ConceptAlchemyEntity entity, final JSONObject conceptJsonObject) {
		final DisambiguatedEntityParser parser = new DisambiguatedEntityParser();

		DisambiguatedAlchemyEntity disambiguatedAlchemyEntity = parser.getEntity(conceptJsonObject);
		if (disambiguatedAlchemyEntity == null) {
			return;
		}
		entity.setDisambiguatedAlchemyEntity(disambiguatedAlchemyEntity);
	}

	/**
	 * Return a json object from the provided array.  Return an empty object if
	 * there is any problems fetching the concept data.
	 *
	 * @param concepts array of concept data
	 * @param index    of the object to fetch
	 * @return json object from the provided array
	 */
	private JSONObject getConcept(final JSONArray concepts, final int index) {
		JSONObject object = new JSONObject();
		try {
			object = (JSONObject) concepts.get(index);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return object;
	}

	/**
	 * Return true if at least one of the values is not null/empty.
	 *
	 * @param concept the sentiment concept
	 * @param score   the sentiment score
	 * @return true if at least one of the values is not null/empty
	 */
	private boolean isValidConcept(final String concept, final Double score) {
		return !StringUtils.isBlank(concept)
			|| score != null;
	}
}
