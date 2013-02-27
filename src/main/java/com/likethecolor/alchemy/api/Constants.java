/**
 * File: Constants.java
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
package com.likethecolor.alchemy.api;

public interface Constants {
	static final String DEFAULT_OUTPUT_FORMAT = "json";
	static final String CALL_TYPE_PREFIX_HTML = "HTML";
	static final String CALL_TYPE_HTML = CALL_TYPE_PREFIX_HTML.toLowerCase();
	static final String CALL_TYPE_PREFIX_TEXT = "Text";
	static final String CALL_TYPE_TEXT = CALL_TYPE_PREFIX_TEXT.toLowerCase();
	static final String CALL_TYPE_PREFIX_URL = "URL";
	static final String CALL_TYPE_URL = CALL_TYPE_PREFIX_URL.toLowerCase();

	static final String CALL_NAME_AUTHOR = "GetAuthor";
	static final String CALL_NAME_RANKED_NAMED_ENTITIES = "GetRankedNamedEntities";
	static final String CALL_NAME_RANKED_KEYWORDS = "GetRankedKeywords";
	static final String CALL_NAME_RANKED_CONCEPTS = "GetRankedConcepts";
	static final String CALL_NAME_MICROFORMAT_DATA = "GetMicroformatData";
	static final String CALL_NAME_LANGUAGE = "GetLanguage";
	static final String CALL_NAME_FEED_LINKS = "GetFeedLinks";
	static final String CALL_NAME_CONSTRAINT_QUERY = "GetConstraintQuery";
	static final String CALL_NAME_CATEGORY = "GetCategory";
	static final String CALL_NAME_RANKED_CATEGORY = "GetRankedCategories";
	static final String CALL_NAME_TITLE = "GetTitle";
	static final String CALL_NAME_TEXT = "GetText";
	static final String CALL_NAME_RAW_TEXT = "GetRawText";
	static final String CALL_NAME_SENTIMENT = "GetTextSentiment";
	static final String CALL_NAME_TARGETED_SENTIMENT = "GetTargetedSentiment";
	static final String CALL_NAME_RELATIONS = "GetRelations";

	static final String DEFAULT_ENCODING = "UTF-8";
	static final Double DEFAULT_SCORE = 0.0D;
	static final Double DEFAULT_LATITUDE = -500.0D;
	static final Double DEFAULT_LONGITUDE = -500.0D;
	static final int DEFAULT_MAX_RETRIEVE = 50;
	static final int MAX_MAX_RETRIEVE = 100;
	static final int MIN_MAX_RETRIEVE = 1;
	static final int DEFAULT_CLIENT_TIMEOUT = 5000;


	/**
	 * Valid values for source text.  That is the source of the text that will be
	 * processed by this API.
	 * <p/>
	 * The alchemy interface supports several modes of text:
	 * - web page cleaning (removes ads, navigation links, etc.)
	 * - raw text extraction (processes all web page text, including ads / nav links)
	 * - visual constraint queries
	 * - XPath queries.
	 * <p/>
	 * Possible values:
	 * - cleaned_or_raw: cleaning enabled, fallback to raw when cleaning produces no text (default)
	 * - cleaned: operate on 'cleaned' web page text (web page cleaning enabled)
	 * - cquery: operate on the results of a visual constraints query
	 * - Note: The 'cquery' http argument must also be set to a valid visual constraints query.
	 * - http://www.alchemyapi.com/api/scrape/
	 * - raw: operate on raw web page text (web page cleaning disabled)
	 * - xpath: operate on the results of an XPath query
	 * - Note: The 'xpath' http argument must also be set to a valid XPath query.
	 */
	static final String SOURCE_TEXT_CLEANED_OR_RAW = "cleaned_or_raw";
	static final String SOURCE_TEXT_CLEANED = "cleaned";
	static final String SOURCE_TEXT_CONSTRAINTS_QUERY = "cquery";
	static final String SOURCE_TEXT_RAW = "raw";
	static final String SOURCE_TEXT_XPATH = "xpath";

	static final String KEYWORD_EXTRACT_MODE_STRICT = "strict";

	static final String PARAM_BASE_URL = "baseUrl";
	static final String PARAM_CONSTRAINT_QUERY = "cquery";
	static final String PARAM_COREFERENCE = "coreference";
	static final String PARAM_DISAMBIGUATE = "disambiguate";
	static final String PARAM_ENTITIES = "entities";
	static final String PARAM_EXTRACT_LINKS = "extractLinks";
	static final String PARAM_HTML = "html";
	static final String PARAM_KEYWORD_EXTRACT_MODE = "keywordExtractMode";
	static final String PARAM_LINKED_DATA = "linkedData";
	static final String PARAM_MAX_RETRIEVE = "maxRetrieve";
	static final String PARAM_OUTPUT_FORMAT = "outputMode";
	static final String PARAM_QUOTATION = "quotations";
	static final String PARAM_REQUIRE_ENTITIES = "requireEntities";
	static final String PARAM_SHOW_SENTIMENT = "sentiment";
	static final String PARAM_SHOW_SENTIMENT_EXCLUDE_ENTITIES = "sentimentExcludeEntities";
	static final String PARAM_SHOW_SOURCE_TEXT = "showSourceText";
	static final String PARAM_SOURCE_TEXT = "sourceText";
	static final String PARAM_TARGET = "target";
	static final String PARAM_TEXT = "text";
	static final String PARAM_USE_META_DATA = "useMetaData";
	static final String PARAM_URL = "url";
	static final String PARAM_XPATH = "xpath";
}
