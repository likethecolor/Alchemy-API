/**
 * File: QuotationEntityTest.java
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
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

public class QuotationAlchemyEntityTest {
  @Test
  public void testConstructor_NoArgs() {
    final QuotationAlchemyEntity entity = new QuotationAlchemyEntity();

    assertNull(entity.getQuotation());
    assertNull(entity.getSentiment());
  }

  @Test
  public void testConstructor_OneArg() {
    final String expectedQuotation = "They should have run the complete, original version,” Finley told ...";

    final QuotationAlchemyEntity entity = new QuotationAlchemyEntity(expectedQuotation);

    assertEquals(expectedQuotation, entity.getQuotation());
    assertNull(entity.getSentiment());
  }

  @Test
  public void testConstructor_TwoArgs() {
    final String expectedQuotation = "They should have run the complete, original version,” Finley told ...";
    final Double sentimentScore = -0.233275D;
    final boolean sentimentIsMixed = true;
    final SentimentAlchemyEntity.TYPE sentimentType = SentimentAlchemyEntity.TYPE.NEGATIVE;
    final SentimentAlchemyEntity expectedSentiment = new SentimentAlchemyEntity(sentimentIsMixed, sentimentScore, sentimentType.toString());

    final QuotationAlchemyEntity entity = new QuotationAlchemyEntity(expectedQuotation, expectedSentiment);

    assertEquals(expectedQuotation, entity.getQuotation());
    assertEquals(expectedSentiment, entity.getSentiment());
  }

  @Test
  public void testQuotation() {
    final String expectedQuotation = "They should have run the complete, original version,” Finley told ...";

    final QuotationAlchemyEntity entity = new QuotationAlchemyEntity();

    entity.setQuotation(expectedQuotation);

    String actualQuotation = entity.getQuotation();

    assertEquals(expectedQuotation, actualQuotation);

    // null - should change value
    entity.setQuotation(null);

    actualQuotation = entity.getQuotation();

    assertNull(actualQuotation);

    // empty string - should change value
    entity.setQuotation(expectedQuotation);
    entity.setQuotation("");

    actualQuotation = entity.getQuotation();

    assertEquals("", actualQuotation);

    // empty white space string - should change value and be trimmed
    entity.setQuotation(expectedQuotation);
    entity.setQuotation("\t  \t\r\n");

    actualQuotation = entity.getQuotation();

    assertEquals("", actualQuotation);

    // should trim
    entity.setQuotation("\n\r  " + expectedQuotation + "   \t  ");

    actualQuotation = entity.getQuotation();

    assertEquals(expectedQuotation, actualQuotation);
  }


  @Test
  public void testSentiment() {
    final Double score = -0.233275D;
    final boolean isMixed = true;
    final SentimentAlchemyEntity.TYPE type = SentimentAlchemyEntity.TYPE.NEGATIVE;
    final SentimentAlchemyEntity expectedSentiment = new SentimentAlchemyEntity(isMixed, score, type.toString());

    final QuotationAlchemyEntity entity = new QuotationAlchemyEntity();

    entity.setSentiment(expectedSentiment);

    SentimentAlchemyEntity actualSentiment = entity.getSentiment();

    assertEquals(expectedSentiment, actualSentiment);

    // null - should change value
    entity.setSentiment(expectedSentiment);
    entity.setSentiment(null);

    actualSentiment = entity.getSentiment();

    assertNull(actualSentiment);
  }

  @Test
  public void testClone() {
    final String quotation = "They should have run the complete, original version,” Finley told ...";
    final Double sentimentScore = -0.233275D;
    final boolean sentimentIsMixed = true;
    final SentimentAlchemyEntity.TYPE sentimentType = SentimentAlchemyEntity.TYPE.NEGATIVE;
    final SentimentAlchemyEntity sentiment = new SentimentAlchemyEntity(sentimentIsMixed, sentimentScore, sentimentType.toString());

    final QuotationAlchemyEntity entity = new QuotationAlchemyEntity();

    QuotationAlchemyEntity clone = entity.clone();

    assertTrue(entity.equals(clone));
    assertNotSame(entity, clone);


    entity.setQuotation(quotation);
    clone = entity.clone();

    assertTrue(entity.equals(clone));
    assertNotSame(entity, clone);


    entity.setSentiment(sentiment);
    clone = entity.clone();

    assertTrue(entity.equals(clone));
    assertNotSame(entity, clone);
  }

  @Test
  public void testEquals() {
    final String quotation = "They should have run the complete, original version,” Finley told ...";
    final Double sentimentScore = -0.233275D;
    final boolean sentimentIsMixed = true;
    final SentimentAlchemyEntity.TYPE sentimentType = SentimentAlchemyEntity.TYPE.NEGATIVE;
    final SentimentAlchemyEntity sentiment = new SentimentAlchemyEntity(sentimentIsMixed, sentimentScore, sentimentType.toString());

    final QuotationAlchemyEntity entity = new QuotationAlchemyEntity();

    assertFalse(entity.equals(null));
    assertFalse(entity.equals(new Double(1312D)));

    assertTrue(entity.equals(entity));
    assertEquals(entity, entity);
    assertSame(entity, entity);


    final QuotationAlchemyEntity other = new QuotationAlchemyEntity();

    assertTrue(entity.equals(other));
    assertEquals(entity, other);
    assertNotSame(entity, other);


    // quotation
    entity.setQuotation(null);
    other.setQuotation(quotation + "foo");

    assertFalse(entity.equals(other));
    assertNotSame(entity, other);


    entity.setQuotation(quotation);

    assertFalse(entity.equals(other));
    assertNotSame(entity, other);


    other.setQuotation(quotation);

    assertTrue(entity.equals(other));
    assertEquals(entity, other);
    assertNotSame(entity, other);


    // sentiment
    entity.setSentiment(sentiment);
    other.setSentiment(null);

    assertFalse(entity.equals(other));
    assertNotSame(entity, other);


    entity.setSentiment(null);
    other.setSentiment(sentiment);

    assertFalse(entity.equals(other));
    assertNotSame(entity, other);


    entity.setSentiment(sentiment);
    other.setSentiment(sentiment);
    assertTrue(entity.equals(other));
    assertEquals(entity, other);
    assertNotSame(entity, other);
  }

  @Test
  public void testToString() {
    final String quotation = "They should have run the complete, original version,” Finley told ...";
    final Double sentimentScore = -0.233275D;
    final boolean sentimentIsMixed = true;
    final SentimentAlchemyEntity.TYPE sentimentType = SentimentAlchemyEntity.TYPE.NEGATIVE;
    final SentimentAlchemyEntity sentiment = new SentimentAlchemyEntity(sentimentIsMixed, sentimentScore, sentimentType.toString());

    final QuotationAlchemyEntity entity = new QuotationAlchemyEntity(quotation, sentiment);

    final String expectedString = new ToStringBuilder(entity)
        .append("quotation", quotation)
        .append("sentiment", sentiment)
        .toString();

    final String actualString = entity.toString();

    assertEquals(expectedString, actualString);
  }

  @Test
  public void testToString_Formatted() {
    final ToStringStyle style = ToStringStyle.MULTI_LINE_STYLE;
    final String quotation = "They should have run the complete, original version,” Finley told ...";
    final Double sentimentScore = -0.233275D;
    final boolean sentimentIsMixed = true;
    final SentimentAlchemyEntity.TYPE sentimentType = SentimentAlchemyEntity.TYPE.NEGATIVE;
    final SentimentAlchemyEntity sentiment = new SentimentAlchemyEntity(sentimentIsMixed, sentimentScore, sentimentType.toString());

    final QuotationAlchemyEntity entity = new QuotationAlchemyEntity(quotation, sentiment);

    final String expectedString = new ToStringBuilder(entity, style)
        .append("quotation", quotation)
        .append("sentiment", sentiment)
        .toString();

    final String actualString = entity.toString(style);

    assertEquals(expectedString, actualString);
  }
}
