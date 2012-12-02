/**
 * File: ActionAlchemyEntity.java
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

public class AlchemyAction {
  private String lematized;
  private AlchemyVerb verb;
  private String text;

  public AlchemyAction() {
  }

  public AlchemyAction(final String lematized, final AlchemyVerb verb, final String text) {
    setLematized(lematized);
    setVerb(verb);
    setText(text);
  }

  /**
   * Set the lemmatized base form of the detected action.
   *
   * @param lematized lemmatized base form of the detected action
   */
  public void setLematized(String lematized) {
    if(lematized != null) {
      lematized = lematized.trim();
    }
    this.lematized = lematized;
  }

  /**
   * Return the lemmatized base form of the detected action.
   *
   * @return lemmatized base form of the detected action
   */
  public String getLematized() {
    return lematized;
  }

  /**
   * Set the detected action text.
   *
   * @param text detected action text
   */
  public void setText(String text) {
    if(text != null) {
      text = text.trim();
    }
    this.text = text;
  }

  /**
   * Return the detected action text.
   *
   * @return detected action text
   */
  public String getText() {
    return text;
  }

  /**
   * Set the verb data for the detected action.
   *
   * @param verb verb data for the detected action
   *
   * @see AlchemyVerb
   */
  public void setVerb(AlchemyVerb verb) {
    this.verb = verb;
  }

  /**
   * Return the verb data for the detected action.
   *
   * @return verb data for the detected action
   *
   * @see AlchemyVerb
   */
  public AlchemyVerb getVerb() {
    if(verb == null) {
      return null;
    }
    return verb.clone();
  }

  /**
   * Return a clone of this object.
   *
   * @return clone of this object
   */
  public AlchemyAction clone() {
    AlchemyAction clone = new AlchemyAction();
    clone.setLematized(getLematized());
    clone.setText(getText());
    clone.setVerb(getVerb());
    return clone;
  }

  @Override
  public boolean equals(Object o) {
    if(this == o) {
      return true;
    }
    if(o == null || getClass() != o.getClass()) {
      return false;
    }

    AlchemyAction that = (AlchemyAction) o;

    if(lematized != null ? !lematized.equals(that.lematized)
                         : that.lematized != null) {
      return false;
    }
    if(text != null ? !text.equals(that.text) : that.text != null) {
      return false;
    }
    if(verb != null ? !verb.equals(that.verb) : that.verb != null) {
      return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int result = 31 * (lematized != null ? lematized.hashCode() : 0);
    result = 31 * result + (text != null ? text.hashCode() : 0);
    result = 31 * result + (verb != null ? verb.hashCode() : 0);
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
        .append("lematized", getLematized())
        .append("text", getText())
        .append("verb", verb == null ? null : verb.toString(style))
        .toString();
  }
}
