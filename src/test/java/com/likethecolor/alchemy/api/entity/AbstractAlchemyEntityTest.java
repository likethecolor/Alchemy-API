/**
 * File: AlchemyEntityTest.java
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

public class AbstractAlchemyEntityTest {
  @Test
  public void testConstructor_NoArgs() {
    final Double expectedScore = Constants.DEFAULT_SCORE;

    final AbstractAlchemyEntity entity = new MockAbstractAlchemyEntity();

    assertEquals(expectedScore, entity.getScore());
  }

  @Test
  public void testConstructor() {
    final Double expectedScore = 12321.123131D;

    final AbstractAlchemyEntity entity = new MockAbstractAlchemyEntity(expectedScore);

    assertEquals(expectedScore, entity.getScore());
  }

  @Test
  public void testScore() {
    final Double expectedScore = 12321.123131D;

    final AbstractAlchemyEntity entity = new MockAbstractAlchemyEntity();

    assertEquals(Constants.DEFAULT_SCORE, entity.getScore());


    entity.setScore(expectedScore);

    assertEquals(expectedScore, entity.getScore());


    // null - set default
    entity.setScore(expectedScore);
    entity.setScore(null);

    assertEquals(Constants.DEFAULT_SCORE, entity.getScore());
  }

  @Test
  public void testEquals() {
    final Double score = 12321.123131D;

    final AbstractAlchemyEntity entity = new MockAbstractAlchemyEntity(score);

    assertFalse(entity.equals(null));
    assertFalse(entity.equals(new Double(1312D)));

    assertTrue(entity.equals(entity));
    assertEquals(entity, entity);
    assertSame(entity, entity);


    final AbstractAlchemyEntity other = new MockAbstractAlchemyEntity(score);

    assertTrue(entity.equals(other));
    assertEquals(entity, other);
    assertNotSame(entity, other);


    // score
    other.setScore(score);

    assertTrue(entity.equals(other));
    assertEquals(entity, other);
    assertNotSame(entity, other);
  }

  @Test
  public void testToString() {
    final Double score = 12321.123131D;

    final AbstractAlchemyEntity entity = new MockAbstractAlchemyEntity(score);

    final String expectedString = new ToStringBuilder(entity)
        .append("score", score)
        .toString();

    final String actualString = entity.toString();

    assertEquals(expectedString, actualString);
  }

  @Test
  public void testToString_Formatted() {
    final ToStringStyle style = ToStringStyle.MULTI_LINE_STYLE;

    final Double score = 12321.123131D;
    final AbstractAlchemyEntity entity = new MockAbstractAlchemyEntity(score);

    final String expectedString = new ToStringBuilder(entity, style)
        .append("score", score)
        .toString();

    final String actualString = entity.toString(style);

    assertEquals(expectedString, actualString);
  }

  class MockAbstractAlchemyEntity extends AbstractAlchemyEntity {
    public MockAbstractAlchemyEntity(final Double score) {
      super(score);
    }

    public MockAbstractAlchemyEntity() {
    }
  }
}
