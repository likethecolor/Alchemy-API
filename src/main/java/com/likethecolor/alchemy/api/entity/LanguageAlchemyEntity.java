/**
 * File: LanguageAlchemyEntity.java
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
package com.likethecolor.alchemy.api.entity;

import com.likethecolor.alchemy.api.util.NumberUtil;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class LanguageAlchemyEntity extends AbstractAlchemyEntity {
  private String ethnologue;
  private String iso6391;
  private String iso6392;
  private String iso6393;
  private String language;
  private String numberOfNativeSpeakers = null;
  private int minimumNumberOfNativeSpeakers = 0;
  private int maximumNumberOfNativeSpeakers = 0;
  private String wikipedia;

  // for testing
  LanguageAlchemyEntity() {
  }

  public LanguageAlchemyEntity(String language) {
    if(language != null) {
      language = language.trim();
    }
    this.language = language;
  }

  /**
   * Set link to Ethnologue containing information on the detected language.
   * <p/>
   * For more information on Ethnologue: @see <a href="http://www.ethnologue.com/info.asp">http://www.ethnologue.com/info.asp</a>
   *
   * @param ethnologue link to Ethnologue containing information on the detected language
   */
  public void setEthnologue(String ethnologue) {
    if(ethnologue != null) {
      ethnologue = ethnologue.trim();
    }
    this.ethnologue = ethnologue;
  }

  /**
   * Return link to Ethnologue containing information on the detected language.
   * <p/>
   * For more information on Ethnologue: @see <a href="http://www.ethnologue.com/info.asp">http://www.ethnologue.com/info.asp</a>
   *
   * @return link to Ethnologue containing information on the detected language
   */
  public String getEthnologue() {
    return ethnologue;
  }

  /**
   * Set ISO-639-1 code for the detected language.
   * <p/>
   * For more information on ISO-639-1: @see <a href="http://en.wikipedia.org/wiki/ISO_639-1">http://en.wikipedia.org/wiki/ISO_639-1</a></a>
   *
   * @param iso6391 ISO-639-1 code for the detected language
   */
  public void setIso6391(String iso6391) {
    if(iso6391 != null) {
      iso6391 = iso6391.trim();
    }
    this.iso6391 = iso6391;
  }

  /**
   * Return ISO-639-1 code for the detected language.
   * <p/>
   * For more information on ISO-639-1: @see <a href="http://en.wikipedia.org/wiki/ISO_639-1">http://en.wikipedia.org/wiki/ISO_639-1</a></a>
   *
   * @return ISO-639-1 code for the detected language
   */
  public String getIso6391() {
    return iso6391;
  }

  /**
   * Set ISO-639-2 code for the detected language.
   * <p/>
   * For more information on ISO-639-2: @see <a href="http://en.wikipedia.org/wiki/ISO_639-2">http://en.wikipedia.org/wiki/ISO_639-2</a></a>
   *
   * @param iso6392 ISO-639-2 code for the detected language
   */
  public void setIso6392(String iso6392) {
    if(iso6392 != null) {
      iso6392 = iso6392.trim();
    }
    this.iso6392 = iso6392;
  }

  /**
   * Return ISO-639-2 code for the detected language.
   * <p/>
   * For more information on ISO-639-2: @see <a href="http://en.wikipedia.org/wiki/ISO_639-2">http://en.wikipedia.org/wiki/ISO_639-2</a></a>
   *
   * @return ISO-639-2 code for the detected language
   */
  public String getIso6392() {
    return iso6392;
  }

  /**
   * Set ISO-639-3 code for the detected language.
   * <p/>
   * For more information on ISO-639-3: @see <a href="http://en.wikipedia.org/wiki/ISO_639-3">http://en.wikipedia.org/wiki/ISO_639-3</a></a>
   *
   * @param iso6393 ISO-639-3 code for the detected language
   */
  public void setIso6393(String iso6393) {
    if(iso6393 != null) {
      iso6393 = iso6393.trim();
    }
    this.iso6393 = iso6393;
  }

  /**
   * Return ISO-639-3 code for the detected language.
   * <p/>
   * For more information on ISO-639-3: @see <a href="http://en.wikipedia.org/wiki/ISO_639-3">http://en.wikipedia.org/wiki/ISO_639-3</a></a>
   *
   * @return ISO-639-3 code for the detected language
   */
  public String getIso6393() {
    return iso6393;
  }

  /**
   * Set detected language for the specified http url.
   * <p/>
   * For a list of all languages (90+) that are detected: @see <a href="http://www.alchemyapi.com/api/lang/langs.html">http://www.alchemyapi.com/api/lang/langs.html</a>
   *
   * @param language detected language for the specified http url
   */
  public void setLanguage(String language) {
    if(language != null) {
      language = language.trim();
    }
    this.language = language;
  }

  /**
   * Return detected language for the specified http url.
   * <p/>
   * For a list of all languages (90+) that are detected: @see <a href="http://www.alchemyapi.com/api/lang/langs.html">http://www.alchemyapi.com/api/lang/langs.html</a>
   *
   * @return detected language for the specified http url
   */
  public String getLanguage() {
    return language;
  }

  /**
   * Set number of persons who natively speak the detected language.
   * <p>
   * Based on the wikipedia page there will be no fewer than 1 million speakers.
   * Based on results from calling the alchemy api this will be a string in the
   * format:
   * <p>
   * 6.45 million
   * <p>
   * 105 million
   * <p>
   * 309-400 million
   *
   * @param numberOfNativeSpeakers number of persons who natively speak the detected language
   *
   * @see <a href="https://en.wikipedia.org/wiki/List_of_languages_by_number_of_native_speakers">https://en.wikipedia.org/wiki/List_of_languages_by_number_of_native_speakers</a>
   */
  public void setNumberOfNativeSpeakers(String numberOfNativeSpeakers) {
    if(numberOfNativeSpeakers != null) {
      numberOfNativeSpeakers = numberOfNativeSpeakers.trim();
    }
    this.numberOfNativeSpeakers = numberOfNativeSpeakers;

    setMinimumNumberOfNativeSpeakers(NumberUtil.minimumFromRange(numberOfNativeSpeakers));
    setMaximumNumberOfNativeSpeakers(NumberUtil.maximumFromRange(numberOfNativeSpeakers));
  }

  /**
   * Return number of persons who natively speak the detected language.
   *
   * @return number of persons who natively speak the detected language
   */
  public String getNumberOfNativeSpeakers() {
    return numberOfNativeSpeakers;
  }

  /**
   * Set the maximum number of persons who natively speak the detected
   * language.
   *
   * @param maximumNumberOfNativeSpeakers maximum number of persons who natively speak the detected language
   */
  private void setMaximumNumberOfNativeSpeakers(final int maximumNumberOfNativeSpeakers) {
    this.maximumNumberOfNativeSpeakers = maximumNumberOfNativeSpeakers;
  }

  /**
   * Return the maximum number of persons who natively speak the detected
   * language.
   *
   * @return maximum number of persons who natively speak the detected language
   */
  public int getMaximumNumberOfNativeSpeakers() {
    return maximumNumberOfNativeSpeakers;
  }

  /**
   * Set the minimum number of persons who natively speak the detected
   * language.
   *
   * @param minimumNumberOfNativeSpeakers minimum number of persons who natively speak the detected language
   */
  private void setMinimumNumberOfNativeSpeakers(final int minimumNumberOfNativeSpeakers) {
    this.minimumNumberOfNativeSpeakers = minimumNumberOfNativeSpeakers;
  }

  /**
   * Return the minimum number of persons who natively speak the detected
   * language.
   *
   * @return minimum number of persons who natively speak the detected language
   */
  public int getMinimumNumberOfNativeSpeakers() {
    return minimumNumberOfNativeSpeakers;
  }

  /**
   * Set link to the Wikipedia page for the detected language.
   *
   * @param wikipedia link to the Wikipedia page for the detected language
   */
  public void setWikipedia(String wikipedia) {
    if(wikipedia != null) {
      wikipedia = wikipedia.trim();
    }
    this.wikipedia = wikipedia;
  }

  /**
   * Return link to the Wikipedia page for the detected language.
   *
   * @return link to the Wikipedia page for the detected language
   */
  public String getWikipedia() {
    return wikipedia;
  }

  /**
   * Return a copy of this object.
   *
   * @return copy of this object
   */
  public LanguageAlchemyEntity clone() {
    final LanguageAlchemyEntity entity = new LanguageAlchemyEntity();
    entity.setEthnologue(getEthnologue());
    entity.setIso6391(getIso6391());
    entity.setIso6392(getIso6392());
    entity.setIso6393(getIso6393());
    entity.setLanguage(getLanguage());
    entity.setNumberOfNativeSpeakers(getNumberOfNativeSpeakers());
    entity.setWikipedia(getWikipedia());
    return entity;
  }

  @Override
  public boolean equals(Object o) {
    if(this == o) {
      return true;
    }
    if(o == null || getClass() != o.getClass()) {
      return false;
    }

    LanguageAlchemyEntity entity = (LanguageAlchemyEntity) o;

    if(ethnologue != null ? !ethnologue.equals(entity.ethnologue)
                          : entity.ethnologue != null) {
      return false;
    }
    if(iso6391 != null ? !iso6391.equals(entity.iso6391)
                       : entity.iso6391 != null) {
      return false;
    }
    if(iso6392 != null ? !iso6392.equals(entity.iso6392)
                       : entity.iso6392 != null) {
      return false;
    }
    if(iso6393 != null ? !iso6393.equals(entity.iso6393)
                       : entity.iso6393 != null) {
      return false;
    }
    if(language != null ? !language.equals(entity.language)
                        : entity.language != null) {
      return false;
    }
    if(numberOfNativeSpeakers != null
       ? !numberOfNativeSpeakers.equals(entity.numberOfNativeSpeakers)
       : entity.numberOfNativeSpeakers != null) {
      return false;
    }
    if(wikipedia != null ? !wikipedia.equals(entity.wikipedia)
                         : entity.wikipedia != null) {
      return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + (ethnologue != null ? ethnologue.hashCode() : 0);
    result = 31 * result + (iso6391 != null ? iso6391.hashCode() : 0);
    result = 31 * result + (iso6392 != null ? iso6392.hashCode() : 0);
    result = 31 * result + (iso6393 != null ? iso6393.hashCode() : 0);
    result = 31 * result + (language != null ? language.hashCode() : 0);
    result = 31 * result + (numberOfNativeSpeakers != null
                            ? numberOfNativeSpeakers.hashCode() : 0);
    result = 31 * result + (wikipedia != null ? wikipedia.hashCode() : 0);
    return result;
  }

  /**
   * @return string representing this object
   *
   * @see #toString(org.apache.commons.lang.builder.ToStringStyle)
   */
  @Override
  public String toString() {
    return toString(ToStringStyle.DEFAULT_STYLE);
  }

  /**
   * @return string representing this object
   *
   * @see ToStringBuilder
   */
  public String toString(final ToStringStyle style) {
    // note - do not do super.toString
    // it will result in a StackOverflowError from ToStringStyle
    return new ToStringBuilder(this, style)
        .append("ethnologue", getEthnologue())
        .append("iso-639-1", getIso6391())
        .append("iso-639-2", getIso6392())
        .append("iso-639-3", getIso6393())
        .append("number of native speakers", getNumberOfNativeSpeakers())
        .append("wikipedia", getWikipedia())
        .toString();
  }
}
