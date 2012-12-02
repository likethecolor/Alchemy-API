/**
 * File: AuthorEntity.java
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

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class AuthorAlchemyEntity extends AbstractAlchemyEntity {
  private String author;

  public AuthorAlchemyEntity(String author) {
    super();
    setAuthor(author);
  }

  public void setAuthor(String author) {
    if(author != null) {
      author = author.trim();
    }
    this.author = author;
  }

  public String getAuthor() {
    return author;
  }

  /**
   * Return a copy of this object.
   *
   * @return copy of this object
   */
  public AuthorAlchemyEntity clone() {
    return new AuthorAlchemyEntity(author);
  }

  @Override
  public boolean equals(Object o) {
    if(this == o) {
      return true;
    }
    if(o == null || getClass() != o.getClass()) {
      return false;
    }

    AuthorAlchemyEntity that = (AuthorAlchemyEntity) o;

    if(author != null ? !author.equals(that.author) : that.author != null) {
      return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + (author != null ? author.hashCode() : 0);
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
        .append("author", author)
        .toString();
  }
}
