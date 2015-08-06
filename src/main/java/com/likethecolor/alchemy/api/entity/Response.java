/**
 * File: Results.java
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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Response<T extends AbstractAlchemyEntity> {
  private HeaderAlchemyEntity entityHeaderAlchemyEntity;
  private List<T> entities;

  public static enum STATUS {
    OK,
    ERROR,
    UNSET
  }

  public Response() {
    entities = new ArrayList<T>();
    entityHeaderAlchemyEntity = new HeaderAlchemyEntity();
  }

  public int size() {
    return entities.size();
  }

  public void setLanguage(String language) {
    entityHeaderAlchemyEntity.setLanguage(language);
  }

  public String getLanguage() {
    return entityHeaderAlchemyEntity.getLanguage();
  }

  public void setStatus(String status) {
    entityHeaderAlchemyEntity.setStatus(status);
  }

  public STATUS getStatus() {
    return entityHeaderAlchemyEntity.getStatus();
  }

  public void setStatusInfo(String statusInfo) {
    entityHeaderAlchemyEntity.setStatusInfo(statusInfo);
  }

  public String getStatusInfo() {
    return entityHeaderAlchemyEntity.getStatusInfo();
  }

  public void setText(String text) {
    entityHeaderAlchemyEntity.setText(text);
  }

  public String getText() {
    return entityHeaderAlchemyEntity.getText();
  }

  public void setURL(String url) {
    entityHeaderAlchemyEntity.setURL(url);
  }

  public String getURL() {
    return entityHeaderAlchemyEntity.getURL();
  }

  public void setUsage(String usage) {
    entityHeaderAlchemyEntity.setUsage(usage);
  }

  public String getUsage() {
    return entityHeaderAlchemyEntity.getUsage();
  }

  public void addEntity(final T entity) {
    if(entity != null && !entities.contains(entity)) {
      entities.add(entity);
    }
  }

  public Iterator<T> iterator() {
    sort(entities);
    return entities.iterator();
  }

  /**
   * Return a copy of this object.
   *
   * @return copy of this object
   */
  public Response<T> clone() {
    final Response<T> clone = new Response<T>();
    clone.setLanguage(getLanguage());
    clone.setStatus(getStatus().toString());
    clone.setStatusInfo(getStatusInfo());
    clone.setText(getText());
    clone.setURL(getURL());
    clone.setUsage(getUsage());
    if(size() > 0) {
      final Iterator<T> iter = iterator();
      while(iter.hasNext()) {
        clone.addEntity(iter.next());
      }
    }
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

    Response response = (Response) o;

    if(entities != null ? !entities.equals(response.entities)
                        : response.entities != null) {
      return false;
    }
    if(entityHeaderAlchemyEntity != null
       ? !entityHeaderAlchemyEntity.equals(response.entityHeaderAlchemyEntity)
       : response.entityHeaderAlchemyEntity != null) {
      return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int result =
        entityHeaderAlchemyEntity != null ? entityHeaderAlchemyEntity.hashCode()
                                          : 0;
    result = 31 * result + (entities != null ? entities.hashCode() : 0);
    return result;
  }

  /**
   * @return string representing this object
   *
   * @see #toString(org.apache.commons.lang.builder.ToStringStyle)
   *
   */
  @Override
  public String toString() {
    return toString(ToStringStyle.DEFAULT_STYLE);
  }

  public List<T> getEntities() {
    return entities;
  }

  /**
   * @return string representing this object
   *
   * @see ToStringBuilder
   */
  public String toString(final ToStringStyle style) {
    sort(entities);

    // note - do not do super.toString
    // it will result in a StackOverflowError from ToStringStyle
    return new ToStringBuilder(this, style)
        .append("language", getLanguage())
        .append("status", getStatus())
        .append("text", getText())
        .append("url", getURL())
        .append("usage", getUsage())
        .append("entities", entities)
        .toString();
  }

  private void sort(final List<T> entities) {
    // entities should never be null but to be safe...
    if(entities != null) {
      Collections.sort(entities, getComparator());
    }
  }

  protected Comparator<T> getComparator() {
    return new Comparator<T>() {
      public int compare(T entity0, T entity1) {
        // sort is not called if there are no entities
        // and addEntity will not add a null entity or one that already exists
        if(entity0 == null & entity1 == null) {
          return 0;
        }
        if(entity0 == null) {
          return -1;
        }
        if(entity1 == null) {
          return -1;
        }
        return entity1.getScore().compareTo(entity0.getScore());
      }
    };
  }
}
