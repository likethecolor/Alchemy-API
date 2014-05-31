/**
 * File: LabelAlchemyEntityTest.java
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

public class TaxonomyAlchemyEntityTest {
  @Test
  public void testConstructor_NoArgs() {
    final Double expectedScore = Constants.DEFAULT_SCORE;

    final TaxonomyAlchemyEntity entity = new TaxonomyAlchemyEntity();

    assertEquals(expectedScore, entity.getScore());
  }

  @Test
  public void testConstructor() {
    final boolean expectedIsConfident = true;
    final Double expectedScore = 0.1467D;
    final String expectedLabel = "culture_politics";

    final TaxonomyAlchemyEntity entity = new TaxonomyAlchemyEntity(expectedLabel, expectedScore, expectedIsConfident);

    assertEquals(expectedScore, entity.getScore());
    assertEquals(expectedLabel, entity.getLabel());
  }

  @Test
  public void testLabel() {
    final String expectedLabel = "culture_politics";
    final TaxonomyAlchemyEntity entity = new TaxonomyAlchemyEntity();

    entity.setLabel(expectedLabel);

    String actualLabel = entity.getLabel();

    assertEquals(expectedLabel, actualLabel);

    // null - should change value
    entity.setLabel(null);

    actualLabel = entity.getLabel();

    assertNull(actualLabel);

    // empty string - should change value
    entity.setLabel(expectedLabel);
    entity.setLabel("");

    actualLabel = entity.getLabel();

    assertEquals("", actualLabel);

    // empty white space string - should change value and be trimmed
    entity.setLabel(expectedLabel);
    entity.setLabel("\t  \t\r\n");

    actualLabel = entity.getLabel();

    assertEquals("", actualLabel);

    // should trim
    entity.setLabel("\n\r  " + expectedLabel + "   \t  ");

    actualLabel = entity.getLabel();

    assertEquals(expectedLabel, actualLabel);
  }

  @Test
  public void testIsConfident() {
    final TaxonomyAlchemyEntity entity = new TaxonomyAlchemyEntity();

    entity.setIsConfident(true);

    assertTrue(entity.isConfident());

    entity.setIsConfident(false);

    assertFalse(entity.isConfident());

    entity.setIsConfident(true);

    assertTrue(entity.isConfident());
  }

  @Test
  public void testClone() {
    final boolean isConfident = true;
    final Double score = 0.1467D;
    final String label = "culture_politics";

    final TaxonomyAlchemyEntity entity = new TaxonomyAlchemyEntity();

    TaxonomyAlchemyEntity clone = entity.clone();

    assertTrue(entity.equals(clone));
    assertNotSame(entity, clone);


    entity.setScore(score);
    clone = entity.clone();

    assertTrue(entity.equals(clone));
    assertNotSame(entity, clone);


    entity.setLabel(label);
    clone = entity.clone();

    assertTrue(entity.equals(clone));
    assertNotSame(entity, clone);


    entity.setIsConfident(isConfident);
    clone = entity.clone();

    assertTrue(entity.equals(clone));
    assertNotSame(entity, clone);
  }

  @Test
  public void testEquals() {
    final boolean isConfident = true;
    final Double score = 0.1467D;
    final String label = "culture_politics";

    final TaxonomyAlchemyEntity entity = new TaxonomyAlchemyEntity();

    assertFalse(entity.equals(null));
    assertFalse(entity.equals(new Double(1312D)));

    assertTrue(entity.equals(entity));
    assertEquals(entity, entity);
    assertSame(entity, entity);


    final TaxonomyAlchemyEntity other = new TaxonomyAlchemyEntity();

    assertTrue(entity.equals(other));
    assertEquals(entity, other);
    assertNotSame(entity, other);


    // label
    entity.setLabel(null);
    other.setLabel(label + "foo");

    assertFalse(entity.equals(other));
    assertNotSame(entity, other);


    entity.setLabel(label);

    assertFalse(entity.equals(other));
    assertNotSame(entity, other);


    other.setLabel(label);

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
    
    // is confident
    entity.setIsConfident(isConfident);

    assertFalse(entity.equals(other));
    assertNotSame(entity, other);


    other.setIsConfident(isConfident);

    assertTrue(entity.equals(other));
    assertEquals(entity, other);
    assertNotSame(entity, other);
  }

  @Test
  public void testToString() {
    final boolean isConfident = true;
    final Double score = 0.1467D;
    final String label = "culture_politics";

    final TaxonomyAlchemyEntity entity = new TaxonomyAlchemyEntity(label, score, isConfident);

    final String expectedString = new ToStringBuilder(entity)
        .append("is confident", isConfident)
        .append("label", label)
        .append("score", score)
        .toString();

    final String actualString = entity.toString();

    assertEquals(expectedString, actualString);
  }

  @Test
  public void testToString_Formatted() {
    final ToStringStyle style = ToStringStyle.MULTI_LINE_STYLE;
    final boolean isConfident = false;
    final Double score = 0.1467D;
    final String label = "culture_politics";

    final TaxonomyAlchemyEntity entity = new TaxonomyAlchemyEntity(label, score, isConfident);

    final String expectedString = new ToStringBuilder(entity, style)
        .append("is confident", isConfident)
        .append("label", label)
        .append("score", score)
        .toString();

    final String actualString = entity.toString(style);

    assertEquals(expectedString, actualString);
  }
}
