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
public class CategoryAlchemyEntity extends AbstractAlchemyEntity {
  private String category;

  public CategoryAlchemyEntity() {
    super();
  }

  public CategoryAlchemyEntity(final String category, final Double score) {
    super(score);
    setCategory(category);
  }

  public void setCategory(String category) {
    if(category != null) {
      category = category.trim();
    }
    this.category = category;
  }

  public String getCategory() {
    return category;
  }

  public CategoryAlchemyEntity clone() {
    return new CategoryAlchemyEntity(getCategory(), getScore());
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

    CategoryAlchemyEntity entity = (CategoryAlchemyEntity) o;

    if(category != null ? !category.equals(entity.category)
                        : entity.category != null) {
      return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + (category != null ? category.hashCode() : 0);
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
        .append("category", getCategory())
        .append("score", getScore())
        .toString();
  }
}
