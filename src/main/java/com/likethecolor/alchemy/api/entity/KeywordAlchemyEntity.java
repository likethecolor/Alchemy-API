/**
 * File: KeywordAlchemyEntity.java
 * Original Author: Dan Brown <dan@likethecolor.com>
 * Copyright 2012 Dan Brown <Dan Brown <dan@likethecolor.com>>
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

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * AlchemyAPI provides easy-to-use facilities for extracting topic keywords from
 * content.
 * Example usage: @see <a href="http://www.alchemyapi.com/api/keyword/urls.html">http://www.alchemyapi.com/api/keyword/urls.html</a>
 */
public class KeywordAlchemyEntity extends AbstractAlchemyEntity {
  private String keyword;
  private SentimentAlchemyEntity sentiment;

  public KeywordAlchemyEntity(final String keyword, final Double score) {
    super(score);
    setKeyword(keyword);
  }

  public KeywordAlchemyEntity(final String keyword, final Double score, final SentimentAlchemyEntity sentiment) {
    super(score);
    setKeyword(keyword);
    setSentiment(sentiment);
  }

  /**
   * Set the detected keyword text.
   *
   * @param keyword detected keyword text
   */
  public void setKeyword(String keyword) {
    if(keyword != null) {
      keyword = keyword.trim();
    }
    this.keyword = keyword;
  }

  /**
   * Return the detected keyword text.
   *
   * @return detected keyword text
   */
  public String getKeyword() {
    return keyword;
  }

  /**
   * Set sentiment for the detected keyword (sent only if keyword-level sentiment
   * analysis is enabled).
   *
   * @param sentiment sentiment for the detected keyword
   */
  public void setSentiment(final SentimentAlchemyEntity sentiment) {
    this.sentiment = sentiment;
  }

  /**
   * Return sentiment for the detected keyword (sent only if keyword-level sentiment
   * analysis is enabled).
   *
   * @return sentiment for the detected keyword
   */
  public SentimentAlchemyEntity getSentiment() {
    if(sentiment == null) {
      return null;
    }
    return sentiment.clone();
  }

  /**
   * Return a copy of this object.
   *
   * @return copy of this object
   */
  public KeywordAlchemyEntity clone() {
    return new KeywordAlchemyEntity(getKeyword(), getScore(), getSentiment());
  }

  @Override
  public boolean equals(Object o) {
    if(this == o) {
      return true;
    }
    if(o == null || getClass() != o.getClass()) {
      return false;
    }
    if(!super.equals(o)) {
      return false;
    }

    KeywordAlchemyEntity entity = (KeywordAlchemyEntity) o;

    if(keyword != null ? !keyword.equals(entity.keyword)
                       : entity.keyword != null) {
      return false;
    }
    if(sentiment != null ? !sentiment.equals(entity.sentiment)
                         : entity.sentiment != null) {
      return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + (keyword != null ? keyword.hashCode() : 0);
    result = 31 * result + (sentiment != null ? sentiment.hashCode() : 0);
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
        .append("keyword", getKeyword())
        .append("score", getScore())
        .append("sentiment", sentiment)
        .toString();
  }
}
