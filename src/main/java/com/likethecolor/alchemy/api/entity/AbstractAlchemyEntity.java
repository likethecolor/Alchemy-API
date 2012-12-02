/**
 * File: AlchemyEntity.java
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

import com.likethecolor.alchemy.api.Constants;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public abstract class AbstractAlchemyEntity {
  private Double score;

  public AbstractAlchemyEntity() {
    score = Constants.DEFAULT_SCORE;
  }

  public AbstractAlchemyEntity(final Double score) {
    this();
    setScore(score);
  }

  /**
   * Set the score (0.0 = neutral).
   *
   * @param score score
   */
  public void setScore(Double score) {
    if(score == null) {
      score = Constants.DEFAULT_SCORE;
    }
    this.score = score;
  }

  /**
   * Return the score (0.0 = neutral).
   *
   * @return score
   */
  public Double getScore() {
    return score;
  }

  @Override
  public boolean equals(Object o) {
    if(this == o) {
      return true;
    }
    if(!(o instanceof AbstractAlchemyEntity)) {
      return false;
    }

    AbstractAlchemyEntity that = (AbstractAlchemyEntity) o;

    if(score != null ? !score.equals(that.score) : that.score != null) {
      return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return score != null ? score.hashCode() : 0;
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
        .append("score", getScore())
        .toString();
  }
}
