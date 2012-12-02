/**
 * File: RelationAlchemyEntity.java
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

public class RelationAlchemyEntity extends AbstractAlchemyEntity {
  private AlchemySubject subject;
  private AlchemyAction action;
  private AlchemyObject object;

  public RelationAlchemyEntity() {
  }

  public RelationAlchemyEntity(final AlchemyAction action, final AlchemyObject object, final AlchemySubject subject) {
    setAction(action);
    setObject(object);
    setSubject(subject);
  }

  /**
   * Set the action.
   *
   * @param action action
   */
  public void setAction(final AlchemyAction action) {
    this.action = action;
  }

  /**
   * Return the action.
   *
   * @return action
   */

  public AlchemyAction getAction() {
    if(action == null) {
      return null;
    }
    return action.clone();
  }

  /**
   * Set the object.
   *
   * @param object object
   */
  public void setObject(final AlchemyObject object) {
    this.object = object;
  }

  /**
   * Return the object.
   *
   * @return object
   */

  public AlchemyObject getObject() {
    if(object == null) {
      return null;
    }
    return object.clone();
  }

  /**
   * Set the subject.
   *
   * @param subject subject
   */
  public void setSubject(final AlchemySubject subject) {
    this.subject = subject;
  }

  /**
   * Return the subject.
   *
   * @return subject
   */

  public AlchemySubject getSubject() {
    if(subject == null) {
      return null;
    }
    return subject.clone();
  }

  public RelationAlchemyEntity clone() {
    RelationAlchemyEntity clone = new RelationAlchemyEntity();
    clone.setAction(getAction());
    clone.setSubject(getSubject());
    clone.setObject(getObject());
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

    if(!super.equals(o)) {
      return false;
    }

    RelationAlchemyEntity other = (RelationAlchemyEntity) o;

    if(action != null ? !action.equals(other.action)
                      : other.action != null) {
      return false;
    }
    if(subject != null ? !subject.equals(other.subject)
                       : other.subject != null) {
      return false;
    }
    if(object != null ? !object.equals(other.object)
                      : other.object != null) {
      return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int result = 31 * (action != null ? action.hashCode() : 0);
    result = 31 * result + (subject != null ? subject.hashCode() : 0);
    result = 31 * result + (object != null ? object.hashCode() : 0);
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
        .append("action", action == null ? null : action.toString(style))
        .append("object", object == null ? null : object.toString(style))
        .append("subject", subject == null ? null : subject.toString(style))
        .toString();
  }
}
