/**
 * Original Author: Dan Brown <dan@likethecolor.com>
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
package com.likethecolor.alchemy.api;

public interface Constants {
  String DEFAULT_OUTPUT_FORMAT = "json";
  String CALL_TYPE_PREFIX_HTML = "HTML";
  String CALL_TYPE_HTML = CALL_TYPE_PREFIX_HTML.toLowerCase();
  String CALL_TYPE_PREFIX_TEXT = "Text";
  String CALL_TYPE_TEXT = CALL_TYPE_PREFIX_TEXT.toLowerCase();
  String CALL_TYPE_PREFIX_URL = "URL";
  String CALL_TYPE_URL = CALL_TYPE_PREFIX_URL.toLowerCase();

  String CALL_NAME_AUTHOR = "GetAuthor";
  String CALL_NAME_RANKED_NAMED_ENTITIES = "GetRankedNamedEntities";
  String CALL_NAME_RANKED_KEYWORDS = "GetRankedKeywords";
  String CALL_NAME_RANKED_CONCEPTS = "GetRankedConcepts";
  String CALL_NAME_MICROFORMAT_DATA = "GetMicroformatData";
  String CALL_NAME_LANGUAGE = "GetLanguage";
  String CALL_NAME_RANKED_TAXONOMY = "GetRankedTaxonomy";
  String CALL_NAME_TITLE = "GetTitle";
  String CALL_NAME_TEXT = "GetText";
  String CALL_NAME_RAW_TEXT = "GetRawText";
  String CALL_NAME_SENTIMENT = "GetTextSentiment";
  String CALL_NAME_TARGETED_SENTIMENT = "GetTargetedSentiment";
  String CALL_NAME_RELATIONS = "GetRelations";
  String CALL_NAME_IMAGE_RANKED_KEYWORDS = "GetRankedImageKeywords";

  String DEFAULT_ENCODING = "UTF-8";
  Double DEFAULT_SCORE = 0.0D;
  Double DEFAULT_LATITUDE = -500.0D;
  Double DEFAULT_LONGITUDE = -500.0D;
  int DEFAULT_MAX_RETRIEVE = 50;
  int MAX_MAX_RETRIEVE = 100;
  int MIN_MAX_RETRIEVE = 1;


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
  String SOURCE_TEXT_CLEANED_OR_RAW = "cleaned_or_raw";
  String SOURCE_TEXT_CLEANED = "cleaned";
  String SOURCE_TEXT_CONSTRAINTS_QUERY = "cquery";
  String SOURCE_TEXT_RAW = "raw";
  String SOURCE_TEXT_XPATH = "xpath";

  String KEYWORD_EXTRACT_MODE_STRICT = "strict";

  String PARAM_BASE_URL = "baseUrl";
  String PARAM_CONSTRAINT_QUERY = "cquery";
  String PARAM_COREFERENCE = "coreference";
  String PARAM_DISAMBIGUATE = "disambiguate";
  String PARAM_ENTITIES = "entities";
  String PARAM_EXTRACT_LINKS = "extractLinks";
  String PARAM_HTML = "html";
  String PARAM_KEYWORD_EXTRACT_MODE = "keywordExtractMode";
  String PARAM_LANGUAGE = "language";
  String PARAM_LINKED_DATA = "linkedData";
  String PARAM_MAX_RETRIEVE = "maxRetrieve";
  String PARAM_OUTPUT_FORMAT = "outputMode";
  String PARAM_QUOTATION = "quotations";
  String PARAM_REQUIRE_ENTITIES = "requireEntities";
  String PARAM_SHOW_SENTIMENT = "sentiment";
  String PARAM_SHOW_SENTIMENT_EXCLUDE_ENTITIES = "sentimentExcludeEntities";
  String PARAM_SHOW_SOURCE_TEXT = "showSourceText";
  String PARAM_SOURCE_TEXT = "sourceText";
  String PARAM_TARGET = "target";
  String PARAM_TEXT = "text";
  String PARAM_USE_META_DATA = "useMetaData";
  String PARAM_URL = "url";
  String PARAM_XPATH = "xpath";
}
