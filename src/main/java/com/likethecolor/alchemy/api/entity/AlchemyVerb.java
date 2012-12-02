/**
 * File: VerbAlchemyEntity.java
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
 * Verb data for the detected action.
 * Example usage {@link <a href="http://www.alchemyapi.com/api/relation/urls.html">http://www.alchemyapi.com/api/relation/urls.html</a>}
 */
public class AlchemyVerb {
  public enum TENSE {
    FUTURE,
    PAST,
    PRESENT,
    UNSET
  }

  private boolean isNegated;
  private TENSE tense;
  private String text;

  public AlchemyVerb() {
    super();
    setIsNegated(false);
    setTense(TENSE.UNSET);
  }

  public AlchemyVerb(final boolean isNegated, final String tense, final String text) {
    super();
    setIsNegated(isNegated);
    setTense(tense);
    setText(text);
  }

  public AlchemyVerb(final Integer isNegated, final String tense, final String text) {
    super();
    setIsNegated(isNegated);
    setTense(tense);
    setText(text);
  }

  /**
   * Set whether this action verb was negated.
   *
   * @param isNegated whether this action verb was negated
   */
  public void setIsNegated(final Integer isNegated) {
    if(isNegated != null) {
      if(isNegated == 1) {
        setIsNegated(true);
      }
      if(isNegated == 0) {
        setIsNegated(false);
      }
    }
  }

  public void setIsNegated(final boolean isNegated) {
    this.isNegated = isNegated;
  }

  /**
   * Return whether this action verb was negated.
   *
   * @return whether this action verb was negated
   */
  public boolean isNegated() {
    return isNegated;
  }

  /**
   * Set the detected action verb: "positive", "negative", or "neutral".
   *
   * @param tense detected action verb
   */
  public void setTense(TENSE tense) {
    if(tense == null) {
      tense = TENSE.UNSET;
    }
    this.tense = tense;
  }

  /**
   * Set the detected action verb: "positive", "negative", or "neutral".
   *
   * @param tense detected action verb
   *
   * @see #setTense(AlchemyVerb.TENSE)
   */
  public void setTense(String tense) {
    if(StringUtils.isBlank(tense)) {
      setTense(TENSE.UNSET);
    }
    else {
      if(TENSE.FUTURE.toString().equalsIgnoreCase(tense.trim())) {
        setTense(TENSE.FUTURE);
      }
      if(TENSE.PAST.toString().equalsIgnoreCase(tense.trim())) {
        setTense(TENSE.PAST);
      }
      if(TENSE.PRESENT.toString().equalsIgnoreCase(tense.trim())) {
        setTense(TENSE.PRESENT);
      }
      if(TENSE.UNSET.toString().equalsIgnoreCase(tense.trim())) {
        setTense(TENSE.UNSET);
      }
    }
  }

  /**
   * Return detected action verb: "positive", "negative", or "neutral".
   *
   * @return detected action verb
   */
  public TENSE getTense() {
    return tense;
  }

  /**
   * Set the lemmatized base form of the detected action verb.
   *
   * @param text lemmatized base form of the detected action verb
   */
  public void setText(String text) {
    if(text != null) {
      text = text.trim();
    }
    this.text = text;
  }

  /**
   * Return the lemmatized base form of the detected action verb.
   *
   * @return lemmatized base form of the detected action verb
   */
  public String getText() {
    return text;
  }

  /**
   * Return a copy of this object.
   *
   * @return copy of this object
   */
  public AlchemyVerb clone() {
    return new AlchemyVerb(isNegated(), getTense().toString(), getText());
  }

  @Override
  public boolean equals(Object o) {
    if(this == o) {
      return true;
    }
    if(o == null || getClass() != o.getClass()) {
      return false;
    }

    AlchemyVerb that = (AlchemyVerb) o;

    if(isNegated != that.isNegated) {
      return false;
    }
    if(tense != that.tense) {
      return false;
    }
    if(text != null ? !text.equals(that.text) : that.text != null) {
      return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + (isNegated ? 1 : 0);
    result = 31 * result + tense.hashCode();
    result = 31 * result + (text != null ? text.hashCode() : 0);
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
    return new ToStringBuilder(this, style)
        .append("is negated", isNegated())
        .append("tense", getTense())
        .append("text", getText())
        .toString();
  }
}
