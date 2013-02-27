/**
 * File: CategoryParser.java
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
import org.json.JSONObject;

public class CategoryParser extends AbstractParser<CategoryAlchemyEntity> {
	protected void populateResponse(final Response<CategoryAlchemyEntity> response) {
		final JSONObject jsonObject = getJSONObject();
		final String category = getString(JSONConstants.CATEGORY_KEY, jsonObject);
		final Double score = getDouble(JSONConstants.CATEGORY_SCORE_KEY, jsonObject);

		if (isValidCategory(category, score)) {
			response.addEntity(new CategoryAlchemyEntity(category, score));
		}
	}

	/**
	 * Return true if at least one of the values is not null/empty.
	 *
	 * @param category the category text
	 * @param score    the sentiment score
	 * @return true if at least one of the values is not null/empty
	 */
	private boolean isValidCategory(final String category, final Double score) {
		return !StringUtils.isBlank(category)
			|| score != null;
	}
}
