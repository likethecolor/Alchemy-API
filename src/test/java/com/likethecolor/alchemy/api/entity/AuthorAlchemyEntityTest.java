/**
 * File: AuthorTest.java
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

public class AuthorAlchemyEntityTest {
  @Test
  public void testConstructor() {
    final String expectedAuthor = "John Doe";

    final AuthorAlchemyEntity entity = new AuthorAlchemyEntity(expectedAuthor);

    assertEquals(expectedAuthor, entity.getAuthor());
  }

  @Test
  public void testAuthor() {
    final String expectedAuthor = "John Doe";
    final String expectedAuthor2 = "Jane Q. Public";
    final AuthorAlchemyEntity entity = new AuthorAlchemyEntity(expectedAuthor);

    String actualAuthor = entity.getAuthor();

    assertEquals(expectedAuthor, actualAuthor);


    entity.setAuthor(expectedAuthor2);

    actualAuthor = entity.getAuthor();

    assertEquals(expectedAuthor2, actualAuthor);

    // null - should change value
    entity.setAuthor(null);

    actualAuthor = entity.getAuthor();

    assertNull(actualAuthor);

    // empty string - should change value
    entity.setAuthor(expectedAuthor);
    entity.setAuthor("");

    actualAuthor = entity.getAuthor();

    assertEquals("", actualAuthor);

    // empty white space string - should change value and be trimmed
    entity.setAuthor(expectedAuthor);
    entity.setAuthor("\t  \t\r\n");

    actualAuthor = entity.getAuthor();

    assertEquals("", actualAuthor);

    // should trim
    entity.setAuthor("\n\r  " + expectedAuthor + "   \t  ");

    actualAuthor = entity.getAuthor();

    assertEquals(expectedAuthor, actualAuthor);
  }

  @Test
  public void testClone() {
    final String author = "Jane Q. Public";
    final String author2 = "Jon Doe";

    final AuthorAlchemyEntity entity = new AuthorAlchemyEntity(author);

    AuthorAlchemyEntity clone = entity.clone();

    assertTrue(entity.equals(clone));
    assertNotSame(entity, clone);


    entity.setAuthor(author2);
    clone = entity.clone();

    assertTrue(entity.equals(clone));
    assertNotSame(entity, clone);
  }

  @Test
  public void testEquals() {
    final String author = "Jon Doe";

    final AuthorAlchemyEntity entity = new AuthorAlchemyEntity(author);

    assertFalse(entity.equals(null));
    assertFalse(entity.equals(new Double(1312D)));

    assertTrue(entity.equals(entity));
    assertEquals(entity, entity);
    assertSame(entity, entity);


    final AuthorAlchemyEntity other = new AuthorAlchemyEntity(author);

    assertTrue(entity.equals(other));
    assertEquals(entity, other);
    assertNotSame(entity, other);


    // author
    entity.setAuthor(null);
    other.setAuthor(author + "foo");

    assertFalse(entity.equals(other));
    assertNotSame(entity, other);


    entity.setAuthor(author);

    assertFalse(entity.equals(other));
    assertNotSame(entity, other);


    other.setAuthor(author);

    assertTrue(entity.equals(other));
    assertEquals(entity, other);
    assertNotSame(entity, other);
  }

  @Test
  public void testToString() {
    final String author = "Jon Doe";

    final AuthorAlchemyEntity entity = new AuthorAlchemyEntity(author);

    final String expectedString = new ToStringBuilder(entity)
        .append("author", author)
        .toString();

    final String actualString = entity.toString();

    assertEquals(expectedString, actualString);
  }

  @Test
  public void testToString_Formatted() {
    final ToStringStyle style = ToStringStyle.MULTI_LINE_STYLE;
    final String author = "Jon Doe";

    final AuthorAlchemyEntity entity = new AuthorAlchemyEntity(author);

    final String expectedString = new ToStringBuilder(entity, style)
        .append("author", author)
        .toString();

    final String actualString = entity.toString(style);

    assertEquals(expectedString, actualString);
  }
}
