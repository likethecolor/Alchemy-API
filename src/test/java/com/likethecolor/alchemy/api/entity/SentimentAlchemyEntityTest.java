/**
 * File: SentimentAlchemyEntityTest.java
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

import com.likethecolor.alchemy.api.Constants;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.junit.Test;

import static org.junit.Assert.*;

public class SentimentAlchemyEntityTest {
  @Test
  public void testConstructor_NoArgs() {
    final boolean expectedIsMixed = false;
    final Double expectedScore = Constants.DEFAULT_SCORE;
    final SentimentAlchemyEntity.TYPE expectedType = SentimentAlchemyEntity.TYPE.UNSET;

    final SentimentAlchemyEntity entity = new SentimentAlchemyEntity();

    assertEquals(expectedIsMixed, entity.isMixed());
    assertEquals(expectedScore, entity.getScore());
    assertEquals(expectedType, entity.getType());
  }

  @Test
  public void testConstructor() {
    final boolean expectedIsMixed = true;
    final Double expectedScore = 0.3343D;
    final SentimentAlchemyEntity.TYPE expectedType = SentimentAlchemyEntity.TYPE.POSITIVE;

    final SentimentAlchemyEntity entity = new SentimentAlchemyEntity(expectedIsMixed, expectedScore, expectedType.toString());

    assertEquals(expectedIsMixed, entity.isMixed());
    assertEquals(expectedScore, entity.getScore());
    assertEquals(expectedType, entity.getType());
  }

  @Test
  public void testIsMixed() {
    final boolean expectedIsMixed = true;

    final SentimentAlchemyEntity entity = new SentimentAlchemyEntity();

    // default is false
    assertFalse(entity.isMixed());

    entity.setIsMixed(expectedIsMixed);

    assertEquals(expectedIsMixed, entity.isMixed());
  }

  @Test
  public void testIsMixed_Integer() {
    final SentimentAlchemyEntity entity = new SentimentAlchemyEntity();

    entity.setIsMixed(1);

    assertTrue(entity.isMixed());

    entity.setIsMixed(0);

    assertFalse(entity.isMixed());
  }

  @Test
  public void testType() {
    final SentimentAlchemyEntity.TYPE defaultType = SentimentAlchemyEntity.TYPE.UNSET;
    final SentimentAlchemyEntity.TYPE expectedType0 = SentimentAlchemyEntity.TYPE.POSITIVE;
    final SentimentAlchemyEntity.TYPE expectedType1 = SentimentAlchemyEntity.TYPE.NEGATIVE;
    final SentimentAlchemyEntity.TYPE expectedType2 = SentimentAlchemyEntity.TYPE.NEUTRAL;

    final SentimentAlchemyEntity entity = new SentimentAlchemyEntity();

    // default is unset
    assertEquals(defaultType, entity.getType());

    entity.setType(expectedType0);

    assertEquals(expectedType0, entity.getType());

    entity.setType(expectedType0);
    entity.setType((SentimentAlchemyEntity.TYPE) null);

    assertEquals(defaultType, entity.getType());

    entity.setType(expectedType1);

    assertEquals(expectedType1, entity.getType());

    entity.setType(expectedType2);

    assertEquals(expectedType2, entity.getType());
  }

  @Test
  public void testType_String() {
    final String tense0 = SentimentAlchemyEntity.TYPE.POSITIVE.toString();
    final String tense1 = SentimentAlchemyEntity.TYPE.NEGATIVE.toString();
    final String tense2 = SentimentAlchemyEntity.TYPE.NEUTRAL.toString();
    final String tense3 = SentimentAlchemyEntity.TYPE.UNSET.toString();
    final SentimentAlchemyEntity.TYPE defaultType = SentimentAlchemyEntity.TYPE.UNSET;
    final SentimentAlchemyEntity.TYPE expectedType0 = SentimentAlchemyEntity.TYPE.POSITIVE;
    final SentimentAlchemyEntity.TYPE expectedType1 = SentimentAlchemyEntity.TYPE.NEGATIVE;
    final SentimentAlchemyEntity.TYPE expectedType2 = SentimentAlchemyEntity.TYPE.NEUTRAL;
    final SentimentAlchemyEntity.TYPE expectedType3 = SentimentAlchemyEntity.TYPE.UNSET;

    final SentimentAlchemyEntity entity = new SentimentAlchemyEntity();

    // default is unset
    assertEquals(defaultType, entity.getType());

    entity.setType(tense0);

    assertEquals(expectedType0, entity.getType());

    entity.setType(tense1);

    assertEquals(expectedType1, entity.getType());

    entity.setType(tense2);

    assertEquals(expectedType2, entity.getType());

    entity.setType(tense3);

    assertEquals(expectedType3, entity.getType());

    // null - default
    entity.setType(tense0);
    entity.setType((String) null);

    assertEquals(defaultType, entity.getType());

    // empty string - default
    entity.setType(tense0);
    entity.setType("");

    assertEquals(defaultType, entity.getType());

    // empty white space string - default
    entity.setType(tense0);
    entity.setType("\t  \r \n");

    assertEquals(defaultType, entity.getType());
  }

  @Test
  public void testClone() {
    final boolean isMixed = true;
    final Double score = 0.3343D;
    final SentimentAlchemyEntity.TYPE type = SentimentAlchemyEntity.TYPE.POSITIVE;

    final SentimentAlchemyEntity entity = new SentimentAlchemyEntity();

    SentimentAlchemyEntity clone = entity.clone();

    assertTrue(entity.equals(clone));
    assertNotSame(entity, clone);


    entity.setIsMixed(isMixed);
    clone = entity.clone();

    assertTrue(entity.equals(clone));
    assertNotSame(entity, clone);


    entity.setScore(score);
    clone = entity.clone();

    assertTrue(entity.equals(clone));
    assertNotSame(entity, clone);


    entity.setType(type);
    clone = entity.clone();

    assertTrue(entity.equals(clone));
    assertNotSame(entity, clone);
  }

  @Test
  public void testEquals() {
    final boolean isMixed = true;
    final Double score = 0.3343D;
    final SentimentAlchemyEntity.TYPE type = SentimentAlchemyEntity.TYPE.POSITIVE;

    final SentimentAlchemyEntity entity = new SentimentAlchemyEntity();

    assertFalse(entity.equals(null));
    assertFalse(entity.equals(new Double(1312D)));

    assertTrue(entity.equals(entity));
    assertEquals(entity, entity);
    assertSame(entity, entity);


    final SentimentAlchemyEntity other = new SentimentAlchemyEntity();

    assertTrue(entity.equals(other));
    assertEquals(entity, other);
    assertNotSame(entity, other);


    // mixed
    entity.setIsMixed(isMixed);

    assertFalse(entity.equals(other));
    assertNotSame(entity, other);


    other.setIsMixed(isMixed);

    assertTrue(entity.equals(other));
    assertEquals(entity, other);
    assertNotSame(entity, other);


    // score
    entity.setScore(score);

    assertFalse(entity.equals(other));
    assertNotSame(entity, other);


    other.setScore(score);

    assertTrue(entity.equals(other));
    assertEquals(entity, other);
    assertNotSame(entity, other);


    // type
    entity.setType(type);

    assertFalse(entity.equals(other));
    assertNotSame(entity, other);


    other.setType(type);

    assertTrue(entity.equals(other));
    assertEquals(entity, other);
    assertNotSame(entity, other);
  }

  @Test
  public void testToString() {
    final boolean isMixed = true;
    final Double score = 0.3343D;
    final SentimentAlchemyEntity.TYPE type = SentimentAlchemyEntity.TYPE.POSITIVE;

    final SentimentAlchemyEntity entity = new SentimentAlchemyEntity(isMixed, score, type.toString());

    final String expectedString = new ToStringBuilder(entity)
        .append("is mixed", isMixed)
        .append("score", score)
        .append("type", type)
        .toString();

    final String actualString = entity.toString();

    assertEquals(expectedString, actualString);
  }

  @Test
  public void testToString_Formatted() {
    final boolean isMixed = true;
    final Double score = 0.3343D;
    final SentimentAlchemyEntity.TYPE type = SentimentAlchemyEntity.TYPE.POSITIVE;
    final ToStringStyle style = ToStringStyle.SHORT_PREFIX_STYLE;

    final SentimentAlchemyEntity entity = new SentimentAlchemyEntity(isMixed, score, type.toString());

    final String expectedString = new ToStringBuilder(entity, style)
        .append("is mixed", isMixed)
        .append("score", score)
        .append("type", type)
        .toString();

    final String actualString = entity.toString(style);

    assertEquals(expectedString, actualString);
  }
}
