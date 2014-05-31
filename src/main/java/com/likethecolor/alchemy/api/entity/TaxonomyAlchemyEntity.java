/**
 * File: CategoryAlchemyEntity.java
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
 * AlchemyAPI provides easy-to-use facilities for categorizing your content.
 * Example usage: @see <a href="http://www.alchemyapi.com/api/categ/urls.html">http://www.alchemyapi.com/api/categ/urls.html</a>
 */
public class TaxonomyAlchemyEntity extends AbstractAlchemyEntity {
  private Boolean isConfident; // using big-B Boolean since there may be no value
  private String label;

  public TaxonomyAlchemyEntity() {
    super();
  }

  public TaxonomyAlchemyEntity(final String label, final Double score, final Boolean isConfident) {
    super(score);
    setLabel(label);
    setIsConfident(isConfident);
  }

  public void setIsConfident(Boolean isConfident) {
    this.isConfident = isConfident;
  }

  public Boolean isConfident() {
    return isConfident;
  }

  public void setLabel(String label) {
    if(label != null) {
      label = label.trim();
    }
    this.label = label;
  }

  public String getLabel() {
    return label;
  }

  public TaxonomyAlchemyEntity clone() {
    return new TaxonomyAlchemyEntity(getLabel(), getScore(), isConfident);
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

    TaxonomyAlchemyEntity that = (TaxonomyAlchemyEntity) o;

    if(isConfident != null ? !isConfident.equals(that.isConfident)
                           : that.isConfident != null) {
      return false;
    }
    if(label != null ? !label.equals(that.label) : that.label != null) {
      return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + (isConfident != null ? isConfident.hashCode() : 0);
    result = 31 * result + (label != null ? label.hashCode() : 0);
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
        .append("is confident", isConfident())
        .append("label", getLabel())
        .append("score", getScore())
        .toString();
  }
}
