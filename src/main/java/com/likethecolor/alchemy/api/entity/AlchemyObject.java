/**
 * File: ObjectAlchemyEntity.java
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

public class AlchemyObject {
  private AlchemyEntity entity;
  private SentimentAlchemyEntity sentiment;
  private SentimentAlchemyEntity sentimentFromSubject;
  private String text;

  public AlchemyObject() {
  }

  public AlchemyObject(final AlchemyEntity entity, final SentimentAlchemyEntity sentiment, final SentimentAlchemyEntity sentimentFromSubject, final String text) {
    setEntity(entity);
    setSentiment(sentiment);
    setSentimentFromSubject(sentimentFromSubject);
    setText(text);
  }

  public void setEntity(AlchemyEntity entity) {
    this.entity = entity;
  }

  public AlchemyEntity getEntity() {
    if(entity == null) {
      return null;
    }
    return entity.clone();
  }

  public void setSentiment(SentimentAlchemyEntity sentiment) {
    this.sentiment = sentiment;
  }

  public SentimentAlchemyEntity getSentiment() {
    if(sentiment == null) {
      return null;
    }
    return sentiment.clone();
  }

  public void setSentimentFromSubject(SentimentAlchemyEntity sentimentFromSubject) {
    this.sentimentFromSubject = sentimentFromSubject;
  }

  public SentimentAlchemyEntity getSentimentFromSubject() {
    if(sentimentFromSubject == null) {
      return null;
    }
    return sentimentFromSubject.clone();
  }

  public void setText(String text) {
    if(text != null) {
      text = text.trim();
    }
    this.text = text;
  }

  public String getText() {
    return text;
  }

  public AlchemyObject clone() {
    final AlchemyObject clone = new AlchemyObject();
    clone.setEntity(getEntity());
    clone.setSentiment(getSentiment());
    clone.setSentimentFromSubject(getSentimentFromSubject());
    clone.setText(getText());
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

    AlchemyObject that = (AlchemyObject) o;

    if(entity != null ? !entity.equals(that.entity) : that.entity != null) {
      return false;
    }
    if(sentiment != null ? !sentiment.equals(that.sentiment)
                         : that.sentiment != null) {
      return false;
    }
    if(sentimentFromSubject != null
       ? !sentimentFromSubject.equals(that.sentimentFromSubject)
       : that.sentimentFromSubject != null) {
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
    result = 31 * result + (entity != null ? entity.hashCode() : 0);
    result = 31 * result + (sentiment != null ? sentiment.hashCode() : 0);
    result = 31 * result + (sentimentFromSubject != null
                            ? sentimentFromSubject.hashCode() : 0);
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
        .append("entity", entity == null ? null : entity.toString(style))
        .append("sentiment",
            sentiment == null ? null : sentiment.toString(style))
        .append("sentiment from subject", sentimentFromSubject == null ? null
                                                                       : sentimentFromSubject.toString(style))
        .append("text", getText())
        .toString();
  }
}
