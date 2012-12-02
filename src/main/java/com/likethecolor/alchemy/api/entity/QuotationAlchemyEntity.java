/**
 * File: QuotationEntity.java
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

public class QuotationAlchemyEntity extends AbstractAlchemyEntity {
  private String quotation;
  private SentimentAlchemyEntity sentimentAlchemyEntity;

  // for testing
  QuotationAlchemyEntity() {
  }

  public QuotationAlchemyEntity(final String quotation) {
    this(quotation, null);
  }

  public QuotationAlchemyEntity(final String quotation, final SentimentAlchemyEntity sentimentAlchemyEntity) {
    setQuotation(quotation);
    setSentiment(sentimentAlchemyEntity);
  }

  public void setQuotation(String quotation) {
    if(quotation != null) {
      quotation = quotation.trim();
    }
    this.quotation = quotation;
  }

  public String getQuotation() {
    return quotation;
  }

  public void setSentiment(SentimentAlchemyEntity sentimentAlchemyEntity) {
    this.sentimentAlchemyEntity = sentimentAlchemyEntity;
  }

  public SentimentAlchemyEntity getSentiment() {
    return sentimentAlchemyEntity;
  }

  public QuotationAlchemyEntity clone() {
    return new QuotationAlchemyEntity(getQuotation(), getSentiment());
  }

  @Override
  public boolean equals(Object o) {
    if(this == o) {
      return true;
    }
    if(o == null || getClass() != o.getClass()) {
      return false;
    }

    QuotationAlchemyEntity that = (QuotationAlchemyEntity) o;

    if(quotation != null ? !quotation.equals(that.quotation)
                         : that.quotation != null) {
      return false;
    }
    if(sentimentAlchemyEntity != null
       ? !sentimentAlchemyEntity.equals(that.sentimentAlchemyEntity)
       : that.sentimentAlchemyEntity != null) {
      return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + (quotation != null ? quotation.hashCode() : 0);
    result = 31 * result + (sentimentAlchemyEntity != null
                            ? sentimentAlchemyEntity.hashCode() : 0);
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
        .append("quotation", getQuotation())
        .append("sentiment", getSentiment())
        .toString();
  }
}
