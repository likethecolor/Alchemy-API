/**
 * File: AlchemyEntityTitleTest.java
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

import static org.junit.Assert.*;

public class TitleAlchemyEntityTest {
  @Test
  public void testConstructor_NoArg() {
    final TitleAlchemyEntity entity = new TitleAlchemyEntity();

    assertNull(entity.getTitle());
  }

  @Test
  public void testConstructor() {
    final String expectedTitle = "Authorities: Pilot accused of faking death found in Florida - CNN.com";

    final TitleAlchemyEntity entity = new TitleAlchemyEntity(expectedTitle);

    assertEquals(expectedTitle, entity.getTitle());
  }

  @Test
  public void testTitle() {
    final String expectedTitle = "Authorities: Pilot accused of faking death found in Florida - CNN.com";
    final TitleAlchemyEntity entity = new TitleAlchemyEntity();

    entity.setTitle(expectedTitle);

    String actualTitle = entity.getTitle();

    assertEquals(expectedTitle, actualTitle);

    // null - should change value
    entity.setTitle(null);

    actualTitle = entity.getTitle();

    assertNull(actualTitle);

    // empty string - should change value
    entity.setTitle(expectedTitle);
    entity.setTitle("");

    actualTitle = entity.getTitle();

    assertEquals("", actualTitle);

    // empty white space string - should change value and be trimmed
    entity.setTitle(expectedTitle);
    entity.setTitle("\t  \t\r\n");

    actualTitle = entity.getTitle();

    assertEquals("", actualTitle);

    // should trim
    entity.setTitle("\n\r  " + expectedTitle + "   \t  ");

    actualTitle = entity.getTitle();

    assertEquals(expectedTitle, actualTitle);
  }

  @Test
  public void testClone() {
    final String title = "Authorities: Pilot accused of faking death found in Florida - CNN.com";

    final TitleAlchemyEntity entity = new TitleAlchemyEntity();

    TitleAlchemyEntity clone = new TitleAlchemyEntity();

    assertTrue(entity.equals(clone));
    assertNotSame(entity, clone);

    entity.setTitle(title);
    clone = entity.clone();

    assertTrue(entity.equals(clone));
    assertNotSame(entity, clone);
  }

  @Test
  public void testEquals() {
    final String title = "Authorities: Pilot accused of faking death found in Florida - CNN.com";

    final TitleAlchemyEntity entity = new TitleAlchemyEntity();
    assertFalse(entity.equals(null));
    assertFalse(entity.equals(new Double(1312D)));

    assertTrue(entity.equals(entity));
    assertEquals(entity, entity);
    assertSame(entity, entity);

    final TitleAlchemyEntity other = new TitleAlchemyEntity();

    assertTrue(entity.equals(other));
    assertEquals(entity, other);
    assertNotSame(entity, other);

    // title
    entity.setTitle(title);
    other.setTitle(null);

    assertFalse(entity.equals(other));
    assertNotSame(entity, other);


    entity.setTitle(null);
    other.setTitle(title);

    assertFalse(entity.equals(other));
    assertNotSame(entity, other);


    entity.setTitle(title);
    other.setTitle(title);

    assertTrue(entity.equals(other));
    assertEquals(entity, other);
    assertNotSame(entity, other);
  }

  @Test
  public void testToString() {
    final String title = "Authorities: Pilot accused of faking death found in Florida - CNN.com";

    final TitleAlchemyEntity entity = new TitleAlchemyEntity(title);

    final String expectedString = new ToStringBuilder(entity)
        .append("title", title)
        .toString();

    final String actualString = entity.toString();

    assertEquals(expectedString, actualString);
  }

  @Test
  public void testToString_Formatted() {
    final ToStringStyle style = ToStringStyle.MULTI_LINE_STYLE;
    final String title = "Authorities: Pilot accused of faking death found in Florida - CNN.com";

    final TitleAlchemyEntity entity = new TitleAlchemyEntity(title);

    final String expectedString = new ToStringBuilder(entity, style)
        .append("title", title)
        .toString();

    final String actualString = entity.toString(style);

    assertEquals(expectedString, actualString);
  }
}
