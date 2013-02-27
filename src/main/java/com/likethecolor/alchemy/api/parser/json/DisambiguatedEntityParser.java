/**
 * File: DisambiguatedEntityParser.java
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
import com.likethecolor.alchemy.api.entity.Response;
import org.json.JSONArray;
import org.json.JSONObject;

class DisambiguatedEntityParser extends AbstractParser<DisambiguatedAlchemyEntity> {
	@Override
	protected void populateResponse(final Response<DisambiguatedAlchemyEntity> response) {
	}

	public DisambiguatedAlchemyEntity getEntity(final JSONObject jsonObject) {
		DisambiguatedAlchemyEntity entity = new DisambiguatedAlchemyEntity();

		String value = getString(JSONConstants.DISAMBIGUATED_NAME_KEY, jsonObject);
		entity.setName(value);

		value = getString(JSONConstants.DISAMBIGUATED_CENSUS_KEY, jsonObject);
		entity.setCensus(value);

		value = getString(JSONConstants.DISAMBIGUATED_CIA_FACTBOOK_KEY, jsonObject);
		entity.setCIAFactbook(value);

		value = getString(JSONConstants.DISAMBIGUATED_CRUNCHBASE_KEY, jsonObject);
		entity.setCrunchbase(value);

		value = getString(JSONConstants.DISAMBIGUATED_DBPEDIA_KEY, jsonObject);
		entity.setDBPedia(value);

		value = getString(JSONConstants.DISAMBIGUATED_FREEBASE_KEY, jsonObject);
		entity.setFreebase(value);

		value = getString(JSONConstants.DISAMBIGUATED_GEO_KEY, jsonObject);
		entity.setGeo(value);

		value = getString(JSONConstants.DISAMBIGUATED_GEONAMES_KEY, jsonObject);
		entity.setGeonames(value);

		value = getString(JSONConstants.DISAMBIGUATED_MUSIC_BRAINZ_KEY, jsonObject);
		entity.setMusicBrainz(value);

		value = getString(JSONConstants.DISAMBIGUATED_OPENCYC_KEY, jsonObject);
		entity.setOpencyc(value);

		value = getString(JSONConstants.DISAMBIGUATED_SEMANTIC_CRUNCHBASE_KEY, jsonObject);
		entity.setSemanticCrunchbase(value);

		value = getString(JSONConstants.DISAMBIGUATED_UMBEL_KEY, jsonObject);
		entity.setUmbel(value);

		value = getString(JSONConstants.DISAMBIGUATED_WEBSITE_KEY, jsonObject);
		entity.setWebsite(value);

		value = getString(JSONConstants.DISAMBIGUATED_YAGO_KEY, jsonObject);
		entity.setYago(value);

		final JSONArray subtypeArray = getJSONArray(JSONConstants.DISAMBIGUATED_SUBTYPE_KEY, jsonObject);
		if (subtypeArray.length() > 0) {
			for (int i = 0; i < subtypeArray.length(); i++) {
				entity.addSubtype(getString(i, subtypeArray));
			}
		}
		return entity;
	}
}
