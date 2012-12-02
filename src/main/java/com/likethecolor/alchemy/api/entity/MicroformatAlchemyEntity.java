/**
 * File: AlchemyEntityMicroformat.java
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

public class MicroformatAlchemyEntity extends AbstractAlchemyEntity {
  private String data;
  private String field;

  public MicroformatAlchemyEntity() {
  }

  public MicroformatAlchemyEntity(final String data, final String field) {
    setData(data);
    setField(field);
  }

  public void setData(String data) {
    if(data != null) {
      data = data.trim();
    }
    this.data = data;
  }

  public String getData() {
    return data;
  }

  public void setField(String field) {
    if(field != null) {
      field = field.trim();
    }
    this.field = field;
  }

  public String getField() {
    return field;
  }

  public MicroformatAlchemyEntity clone() {
    return new MicroformatAlchemyEntity(getData(), getField());
  }

  @Override
  public boolean equals(Object o) {
    if(this == o) {
      return true;
    }
    if(o == null || getClass() != o.getClass()) {
      return false;
    }

    MicroformatAlchemyEntity that = (MicroformatAlchemyEntity) o;

    if(data != null ? !data.equals(that.data) : that.data != null) {
      return false;
    }
    if(field != null ? !field.equals(that.field) : that.field != null) {
      return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int result = (data != null ? data.hashCode() : 0);
    result = 31 * result + (field != null ? field.hashCode() : 0);
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
   * @see org.apache.commons.lang.builder.ToStringBuilder
   */
  public String toString(final ToStringStyle style) {
    // note - do not do super.toString
    // it will result in a StackOverflowError from ToStringStyle
    return new ToStringBuilder(this, style)
        .append("data", data)
        .append("field", field)
        .toString();
  }
}
