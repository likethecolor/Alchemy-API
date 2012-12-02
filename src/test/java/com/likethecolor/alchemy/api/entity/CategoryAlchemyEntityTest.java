/**
 * File: CategoryAlchemyEntityTest.java
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

public class CategoryAlchemyEntityTest {
  @Test
  public void testConstructor_NoArgs() {
    final Double expectedScore = Constants.DEFAULT_SCORE;

    final CategoryAlchemyEntity entity = new CategoryAlchemyEntity();

    assertEquals(expectedScore, entity.getScore());
  }

  @Test
  public void testConstructor() {
    final Double expectedScore = 0.1467D;
    final String expectedCategory = "culture_politics";

    final CategoryAlchemyEntity entity = new CategoryAlchemyEntity(expectedCategory, expectedScore);

    assertEquals(expectedScore, entity.getScore());
    assertEquals(expectedCategory, entity.getCategory());
  }

  @Test
  public void testCategory() {
    final String expectedCategory = "culture_politics";
    final CategoryAlchemyEntity entity = new CategoryAlchemyEntity();

    entity.setCategory(expectedCategory);

    String actualCategory = entity.getCategory();

    assertEquals(expectedCategory, actualCategory);

    // null - should change value
    entity.setCategory(null);

    actualCategory = entity.getCategory();

    assertNull(actualCategory);

    // empty string - should change value
    entity.setCategory(expectedCategory);
    entity.setCategory("");

    actualCategory = entity.getCategory();

    assertEquals("", actualCategory);

    // empty white space string - should change value and be trimmed
    entity.setCategory(expectedCategory);
    entity.setCategory("\t  \t\r\n");

    actualCategory = entity.getCategory();

    assertEquals("", actualCategory);

    // should trim
    entity.setCategory("\n\r  " + expectedCategory + "   \t  ");

    actualCategory = entity.getCategory();

    assertEquals(expectedCategory, actualCategory);
  }

  @Test
  public void testClone() {
    final Double score = 0.1467D;
    final String category = "culture_politics";

    final CategoryAlchemyEntity entity = new CategoryAlchemyEntity();

    CategoryAlchemyEntity clone = entity.clone();

    assertTrue(entity.equals(clone));
    assertNotSame(entity, clone);


    entity.setScore(score);
    clone = entity.clone();

    assertTrue(entity.equals(clone));
    assertNotSame(entity, clone);


    entity.setCategory(category);
    clone = entity.clone();

    assertTrue(entity.equals(clone));
    assertNotSame(entity, clone);
  }

  @Test
  public void testEquals() {
    final Double score = 0.1467D;
    final String category = "culture_politics";

    final CategoryAlchemyEntity entity = new CategoryAlchemyEntity();

    assertFalse(entity.equals(null));
    assertFalse(entity.equals(new Double(1312D)));

    assertTrue(entity.equals(entity));
    assertEquals(entity, entity);
    assertSame(entity, entity);


    final CategoryAlchemyEntity other = new CategoryAlchemyEntity();

    assertTrue(entity.equals(other));
    assertEquals(entity, other);
    assertNotSame(entity, other);


    // category
    entity.setCategory(null);
    other.setCategory(category + "foo");

    assertFalse(entity.equals(other));
    assertNotSame(entity, other);


    entity.setCategory(category);

    assertFalse(entity.equals(other));
    assertNotSame(entity, other);


    other.setCategory(category);

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
  }

  @Test
  public void testToString() {
    final Double score = 0.1467D;
    final String category = "culture_politics";

    final CategoryAlchemyEntity entity = new CategoryAlchemyEntity(category, score);

    final String expectedString = new ToStringBuilder(entity)
        .append("category", category)
        .append("score", score)
        .toString();

    final String actualString = entity.toString();

    assertEquals(expectedString, actualString);
  }

  @Test
  public void testToString_Formatted() {
    final ToStringStyle style = ToStringStyle.MULTI_LINE_STYLE;
    final Double score = 0.1467D;
    final String category = "culture_politics";

    final CategoryAlchemyEntity entity = new CategoryAlchemyEntity(category, score);

    final String expectedString = new ToStringBuilder(entity, style)
        .append("category", category)
        .append("score", score)
        .toString();

    final String actualString = entity.toString(style);

    assertEquals(expectedString, actualString);
  }
}
