/**
 * File: SentimentAlchemyEntity.java
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

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * AlchemyAPI provides easy-to-use facilities for extracting positive/negative
 * sentiment from your publicly-accessible web-based content.
 * Example usage: @see <a href="http://www.alchemyapi.com/api/sentiment/urls.html">http://www.alchemyapi.com/api/sentiment/urls.html</a>
 */
public class SentimentAlchemyEntity extends AbstractAlchemyEntity {
  public enum TYPE {
    POSITIVE,
    NEGATIVE,
    NEUTRAL,
    UNSET
  }

  private TYPE type;
  private boolean isMixed;

  public SentimentAlchemyEntity() {
    super();
    setIsMixed(false);
    setType(TYPE.UNSET);
  }

  public SentimentAlchemyEntity(final boolean isMixed, final Double score, final String type) {
    super(score);
    setIsMixed(isMixed);
    setType(type);
  }

  /**
   * Set whether the sentiment is mixed (both positive and negative).
   *
   * @param isMixed whether sentiment is mixed
   */
  public void setIsMixed(final boolean isMixed) {
    this.isMixed = isMixed;
  }

  /**
   * Set whether the sentiment is mixed (both positive and negative) (1 = mixed).
   *
   * @param isMixed whether sentiment is mixed
   *
   * @see #setIsMixed(boolean)
   */
  public void setIsMixed(final int isMixed) {
    if(isMixed == 0) {
      setIsMixed(false);
    }
    if(isMixed == 1) {
      setIsMixed(true);
    }
  }

  /**
   * Return true if the sentiment is mixed (both negative and positive).
   *
   * @return true if sentiment is mixed
   */
  public boolean isMixed() {
    return isMixed;
  }

  /**
   * Set sentiment polarity: "positive", "negative", or "neutral".
   *
   * @param type sentiment polarity
   */
  public void setType(TYPE type) {
    if(type == null) {
      type = TYPE.UNSET;
    }
    this.type = type;
  }

  /**
   * Set sentiment polarity: "positive", "negative", or "neutral".
   *
   * @param type sentiment polarity
   *
   * @see #setType(SentimentAlchemyEntity.TYPE)
   */
  public void setType(String type) {
    if(StringUtils.isBlank(type)) {
      setType(TYPE.UNSET);
    }
    else {
      if(TYPE.NEGATIVE.toString().equalsIgnoreCase(type.trim())) {
        setType(TYPE.NEGATIVE);
      }
      if(TYPE.NEUTRAL.toString().equalsIgnoreCase(type.trim())) {
        setType(TYPE.NEUTRAL);
      }
      if(TYPE.POSITIVE.toString().equalsIgnoreCase(type.trim())) {
        setType(TYPE.POSITIVE);
      }
      if(TYPE.UNSET.toString().equalsIgnoreCase(type.trim())) {
        setType(TYPE.UNSET);
      }
    }
  }

  /**
   * Return sentiment polarity: "positive", "negative", or "neutral".
   *
   * @return sentiment polarity
   */
  public TYPE getType() {
    return type;
  }

  /**
   * Return a copy of this object.
   *
   * @return copy of this object
   */
  public SentimentAlchemyEntity clone() {
    return new SentimentAlchemyEntity(isMixed(), getScore(), getType().toString());
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

    SentimentAlchemyEntity that = (SentimentAlchemyEntity) o;

    if(isMixed != that.isMixed) {
      return false;
    }
    if(type != that.type) {
      return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + type.hashCode();
    result = 31 * result + (isMixed ? 1 : 0);
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
        .append("is mixed", isMixed())
        .append("score", getScore())
        .append("type", getType())
        .toString();
  }
}
