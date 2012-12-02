/**
 * File: KeywordAlchemyEntityTest.java
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

public class KeywordAlchemyEntityTest {
  @Test
  public void testConstructor_2_Args() {
    final String keyword = "Florida";
    final Double score = 0.956742D;

    final KeywordAlchemyEntity entity = new KeywordAlchemyEntity(keyword, score);

    assertEquals(keyword, entity.getKeyword());
    assertEquals(score, entity.getScore());
    assertNull(entity.getSentiment());
  }

  @Test
  public void testConstructor_3_Args() {
    final String keyword = "Florida";
    final Double score = 0.956742D;
    final boolean isMixed = true;
    final Double sentimentScore = -0.152724D;
    final SentimentAlchemyEntity.TYPE type = SentimentAlchemyEntity.TYPE.NEGATIVE;

    final SentimentAlchemyEntity sentimentEntity = new SentimentAlchemyEntity(isMixed, sentimentScore, type.toString());

    final KeywordAlchemyEntity entity = new KeywordAlchemyEntity(keyword, score, sentimentEntity);

    assertEquals(keyword, entity.getKeyword());
    assertEquals(score, entity.getScore());
    assertEquals(sentimentEntity, entity.getSentiment());
  }

  @Test
  public void testKeyword() {
    final String expectedKeyword = "Marshals Service";
    final Double score = 0.9287172D;
    final KeywordAlchemyEntity entity = new KeywordAlchemyEntity(expectedKeyword, score);

    String actualKeyword = entity.getKeyword();

    assertEquals(expectedKeyword, actualKeyword);


    // null - should change value
    entity.setKeyword(null);

    actualKeyword = entity.getKeyword();

    assertNull(actualKeyword);

    // empty string - should change value
    entity.setKeyword(expectedKeyword);
    entity.setKeyword("");

    actualKeyword = entity.getKeyword();

    assertEquals("", actualKeyword);

    // empty white space string - should change value and be trimmed
    entity.setKeyword(expectedKeyword);
    entity.setKeyword("\t  \t\r\n");

    actualKeyword = entity.getKeyword();

    assertEquals("", actualKeyword);

    // should trim
    entity.setKeyword("\n\r  " + expectedKeyword + "   \t  ");

    actualKeyword = entity.getKeyword();

    assertEquals(expectedKeyword, actualKeyword);
  }

  @Test
  public void testClone() {
    final String keyword = "Marshals Service";
    final Double score = 0.9287172D;
    final boolean isMixed = true;
    final Double sentimentScore = -0.152724D;
    final SentimentAlchemyEntity.TYPE type = SentimentAlchemyEntity.TYPE.NEGATIVE;

    final SentimentAlchemyEntity sentimentEntity = new SentimentAlchemyEntity(isMixed, sentimentScore, type.toString());

    final KeywordAlchemyEntity entity = new KeywordAlchemyEntity(null, null);

    KeywordAlchemyEntity clone = entity.clone();

    assertTrue(entity.equals(clone));
    assertNotSame(entity, clone);


    entity.setKeyword(keyword);
    clone = entity.clone();

    assertTrue(entity.equals(clone));
    assertNotSame(entity, clone);


    entity.setScore(score);
    clone = entity.clone();

    assertTrue(entity.equals(clone));
    assertNotSame(entity, clone);


    entity.setSentiment(sentimentEntity);
    clone = entity.clone();

    assertTrue(entity.equals(clone));
    assertNotSame(entity, clone);
  }

  @Test
  public void testEquals() {
    final String keyword = "Santa Rosa County";
    final Double score = 0.656468D;
    final boolean isMixed = true;
    final Double sentimentScore = -0.152724D;
    final SentimentAlchemyEntity.TYPE type = SentimentAlchemyEntity.TYPE.NEGATIVE;

    final SentimentAlchemyEntity sentimentEntity = new SentimentAlchemyEntity(isMixed, sentimentScore, type.toString());

    final KeywordAlchemyEntity entity = new KeywordAlchemyEntity(null, null);

    assertFalse(entity.equals(null));
    assertFalse(entity.equals(new Double(1312D)));

    assertTrue(entity.equals(entity));
    assertEquals(entity, entity);
    assertSame(entity, entity);


    final KeywordAlchemyEntity other = new KeywordAlchemyEntity(null, null);

    assertTrue(entity.equals(other));
    assertEquals(entity, other);
    assertNotSame(entity, other);


    // keyword
    entity.setKeyword(null);
    other.setKeyword(keyword + "foo");

    assertFalse(entity.equals(other));
    assertNotSame(entity, other);


    entity.setKeyword(keyword);

    assertFalse(entity.equals(other));
    assertNotSame(entity, other);


    other.setKeyword(keyword + "foo");

    assertFalse(entity.equals(other));
    assertNotSame(entity, other);


    other.setKeyword(keyword);

    assertTrue(entity.equals(other));
    assertEquals(entity, other);
    assertNotSame(entity, other);


    // score
    entity.setScore(score);

    assertFalse(entity.equals(other));
    assertNotSame(entity, other);


    other.setScore(score);

    assertTrue(entity.equals(other));
    assertNotSame(entity, other);


    // sentiment
    entity.setSentiment(null);
    other.setSentiment(sentimentEntity);

    assertFalse(entity.equals(other));
    assertNotSame(entity, other);


    entity.setSentiment(sentimentEntity);
    other.setSentiment(null);

    assertFalse(entity.equals(other));
    assertNotSame(entity, other);


    entity.setSentiment(sentimentEntity);
    other.setSentiment(sentimentEntity);

    assertTrue(entity.equals(other));
    assertEquals(entity, other);
    assertNotSame(entity, other);
  }

  @Test
  public void testToString() {
    final String keyword = "Santa Rosa County";
    final Double score = 0.656468D;
    final boolean isMixed = true;
    final Double sentimentScore = -0.152724D;
    final SentimentAlchemyEntity.TYPE type = SentimentAlchemyEntity.TYPE.NEGATIVE;

    final SentimentAlchemyEntity sentimentEntity = new SentimentAlchemyEntity(isMixed, sentimentScore, type.toString());

    final KeywordAlchemyEntity entity = new KeywordAlchemyEntity(keyword, score, sentimentEntity);

    final String expectedString = new ToStringBuilder(entity)
        .append("keyword", keyword)
        .append("score", score)
        .append("sentiment", sentimentEntity)
        .toString();

    final String actualString = entity.toString();

    assertEquals(expectedString, actualString);
  }

  @Test
  public void testToString_Formatted() {
    final ToStringStyle style = ToStringStyle.SHORT_PREFIX_STYLE;
    final String keyword = "Santa Rosa County";
    final Double score = 0.656468D;
    final boolean isMixed = true;
    final Double sentimentScore = -0.152724D;
    final SentimentAlchemyEntity.TYPE type = SentimentAlchemyEntity.TYPE.NEGATIVE;

    final SentimentAlchemyEntity sentimentEntity = new SentimentAlchemyEntity(isMixed, sentimentScore, type.toString());

    final KeywordAlchemyEntity entity = new KeywordAlchemyEntity(keyword, score, sentimentEntity);

    final String expectedString = new ToStringBuilder(entity, style)
        .append("keyword", keyword)
        .append("score", score)
        .append("sentiment", sentimentEntity)
        .toString();

    final String actualString = entity.toString(style);

    assertEquals(expectedString, actualString);
  }
}
