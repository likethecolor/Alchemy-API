/**
 * File: JSONConstants.java
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

public interface JSONConstants {
  static final String RESULTS_LANGUAGE = "language";
  static final String RESULTS_STATUS = "status";
  static final String RESULTS_STATUS_INFO = "statusInfo";
  static final String RESULTS_TEXT = "text";
  static final String RESULTS_URL = "url";
  static final String RESULTS_USAGE = "usage";

  static final String AUTHOR_KEY = "author";

  static final String DISAMBIGUATED_KEY = "disambiguated";
  static final String DISAMBIGUATED_CENSUS_KEY = "census";
  static final String DISAMBIGUATED_CIA_FACTBOOK_KEY = "ciaFactbook";
  static final String DISAMBIGUATED_CRUNCHBASE_KEY = "crunchbase";
  static final String DISAMBIGUATED_DBPEDIA_KEY = "dbpedia";
  static final String DISAMBIGUATED_FREEBASE_KEY = "freebase";
  static final String DISAMBIGUATED_GEO_KEY = "geo";
  static final String DISAMBIGUATED_GEONAMES_KEY = "geonames";
  static final String DISAMBIGUATED_MUSIC_BRAINZ_KEY = "musicBrainz";
  static final String DISAMBIGUATED_NAME_KEY = "name";
  static final String DISAMBIGUATED_OPENCYC_KEY = "opencyc";
  static final String DISAMBIGUATED_SEMANTIC_CRUNCHBASE_KEY = "semanticCrunchbase";
  static final String DISAMBIGUATED_SUBTYPE_KEY = "subType";
  static final String DISAMBIGUATED_UMBEL_KEY = "umbel";
  static final String DISAMBIGUATED_WEBSITE_KEY = "website";
  static final String DISAMBIGUATED_YAGO_KEY = "yago";

  static final String SENTIMENT_KEY = "sentiment";
  static final String SENTIMENT_MIXED_KEY = "mixed";
  static final String SENTIMENT_SCORE_KEY = "score";
  static final String SENTIMENT_TYPE_KEY = "type";

  static final String RELATIONS_KEY = "relations";
  static final String RELATIONS_RELATION_KEY = "relation";
  static final String RELATIONS_ACTION_KEY = "action";
  static final String RELATIONS_ACTION_TEXT_KEY = "text";
  static final String RELATIONS_SUBJECT_KEY = "subject";
  static final String RELATIONS_SUBJECT_TEXT_KEY = "text";
  static final String RELATIONS_LEMMATIZED_KEY = "lemmatized";
  static final String RELATIONS_SENTIMENT_FROM_SUBJECT_KEY = "sentimentFromSubject";
  static final String RELATIONS_OBJECT_KEY = "object";
  static final String RELATIONS_OBJECT_TEXT_KEY = "text";
  static final String RELATIONS_VERB_KEY = "verb";
  static final String RELATIONS_VERB_NEGATED_KEY = "negated";
  static final String RELATIONS_VERB_TENSE_KEY = "tense";
  static final String RELATIONS_VERB_TEXT_KEY = "text";
  static final String RELATIONS_ENTITY_KEY = "entity";
  static final String RELATIONS_ENTITY_TEXT_KEY = "text";
  static final String RELATIONS_ENTITY_TYPE_KEY = "type";

  static final String CATEGORY_KEY = "category";
  static final String CATEGORY_SCORE_KEY = "score";

  static final String LANGUAGE_LANGUAGE_KEY = "language";
  static final String LANGUAGE_ETHNOLOGUE_KEY = "ethnologue";
  static final String LANGUAGE_ISO6391_KEY = "iso-639-1";
  static final String LANGUAGE_ISO6392_KEY = "iso-639-2";
  static final String LANGUAGE_ISO6393_KEY = "iso-639-3";
  static final String LANGUAGE_NUMBER_OF_NATIVE_SPEAKERS_KEY = "native-speakers";
  static final String LANGUAGE_WIKIPEDIA_KEY = "wikipedia";

  static final String MICROFORMATS_KEY = "microformats";
  static final String MICROFORMATS_MICROFORMAT_KEY = "microformat";
  static final String MICROFORMATS_FIELD_KEY = "field";
  static final String MICROFORMATS_DATA_KEY = "data";


  static final String RANKED_CATEGORIES = "categories";
  static final String RANKED_CATEGORIES_TEXT_KEY = "text";
  static final String RANKED_CATEGORIES_SCORE_KEY = "relevance";

  static final String RANKED_CONCEPTS = "concepts";
  static final String RANKED_CONCEPTS_TEXT_KEY = "text";
  static final String RANKED_CONCEPTS_SCORE_KEY = "relevance";
  static final String RANKED_CONCEPTS_CENSUS_KEY = DISAMBIGUATED_CENSUS_KEY;
  static final String RANKED_CONCEPTS_CIA_FACTBOOK_KEY = DISAMBIGUATED_CIA_FACTBOOK_KEY;
  static final String RANKED_CONCEPTS_CRUNCHBASE_KEY = DISAMBIGUATED_CRUNCHBASE_KEY;
  static final String RANKED_CONCEPTS_DBPEDIA_KEY = DISAMBIGUATED_DBPEDIA_KEY;
  static final String RANKED_CONCEPTS_FREEBASE_KEY = DISAMBIGUATED_FREEBASE_KEY;
  static final String RANKED_CONCEPTS_GEO_KEY = DISAMBIGUATED_GEO_KEY;
  static final String RANKED_CONCEPTS_GEONAMES_KEY = DISAMBIGUATED_GEONAMES_KEY;
  static final String RANKED_CONCEPTS_MUSIC_BRAINZ_KEY = DISAMBIGUATED_MUSIC_BRAINZ_KEY;
  static final String RANKED_CONCEPTS_OPENCYC_KEY = DISAMBIGUATED_OPENCYC_KEY;
  static final String RANKED_CONCEPTS_SEMANTIC_CRUNCHBASE_KEY = DISAMBIGUATED_SEMANTIC_CRUNCHBASE_KEY;
  static final String RANKED_CONCEPTS_WEBSITE_KEY = DISAMBIGUATED_WEBSITE_KEY;
  static final String RANKED_CONCEPTS_YAGO_KEY = DISAMBIGUATED_YAGO_KEY;

  static final String RANKED_KEYWORDS = "keywords";
  static final String RANKED_KEYWORDS_TEXT_KEY = "text";
  static final String RANKED_KEYWORDS_SCORE_KEY = "relevance";

  static final String RANKED_NAMED_ENTITIES = "entities";
  static final String RANKED_NAMED_ENTITIES_ENTITY = "entity";
  static final String RANKED_NAMED_ENTITIES_COUNT_KEY = "count";
  static final String RANKED_NAMED_ENTITIES_TEXT_KEY = "text";
  static final String RANKED_NAMED_ENTITIES_TYPE_KEY = "type";
  static final String RANKED_NAMED_ENTITIES_SCORE_KEY = "relevance";
  static final String RANKED_NAMED_ENTITIES_DISAMBIGUATED_KEY = DISAMBIGUATED_KEY;

  static final String QUOTATIONS_KEY = "quotations";
  static final String QUOTATIONS_QUOTATION_KEY = "quotation";

  static final String TARGETED_SENTIMENT_KEY = "docSentiment";
  static final String TARGETED_SENTIMENT_MIXED_KEY = SENTIMENT_MIXED_KEY;
  static final String TARGETED_SENTIMENT_SCORE_KEY = SENTIMENT_SCORE_KEY;
  static final String TARGETED_SENTIMENT_TYPE_KEY = SENTIMENT_TYPE_KEY;

  static final String TITLE_KEY = "title";
}
