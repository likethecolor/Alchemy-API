/**
 * File: MicroformatAlchemyEntityTest.java
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

public class MicroformatAlchemyEntityTest {
  @Test
  public void testConstructor() {
    final String expectedData = "RelTagLink";
    final String expectedField = "/wiki/Category:Specifications";

    final MicroformatAlchemyEntity entity = new MicroformatAlchemyEntity(expectedData, expectedField);

    assertEquals(expectedData, entity.getData());
    assertEquals(expectedField, entity.getField());
  }

  @Test
  public void testConstructor_NoArgs() {
    final MicroformatAlchemyEntity entity = new MicroformatAlchemyEntity();

    assertNull(entity.getData());
    assertNull(entity.getField());
  }

  @Test
  public void testData() {
    final String expectedData = "RelTagLink";
    final MicroformatAlchemyEntity entity = new MicroformatAlchemyEntity();

    entity.setData(expectedData);

    String actualData = entity.getData();

    assertEquals(expectedData, actualData);

    // null - should change value
    entity.setData(null);

    actualData = entity.getData();

    assertNull(actualData);

    // empty string - should change value
    entity.setData(expectedData);
    entity.setData("");

    actualData = entity.getData();

    assertEquals("", actualData);

    // empty white space string - should change value and be trimmed
    entity.setData(expectedData);
    entity.setData("\t  \t\r\n");

    actualData = entity.getData();

    assertEquals("", actualData);

    // should trim
    entity.setData("\n\r  " + expectedData + "   \t  ");

    actualData = entity.getData();

    assertEquals(expectedData, actualData);
  }

  @Test
  public void testField() {
    final String expectedField = "/wiki/Category:Specifications";
    final MicroformatAlchemyEntity entity = new MicroformatAlchemyEntity();

    entity.setField(expectedField);

    String actualField = entity.getField();

    assertEquals(expectedField, actualField);

    // null - should change value
    entity.setField(null);

    actualField = entity.getField();

    assertNull(actualField);

    // empty string - should change value
    entity.setField(expectedField);
    entity.setField("");

    actualField = entity.getField();

    assertEquals("", actualField);

    // empty white space string - should change value and be trimmed
    entity.setField(expectedField);
    entity.setField("\t  \t\r\n");

    actualField = entity.getField();

    assertEquals("", actualField);

    // should trim
    entity.setField("\n\r  " + expectedField + "   \t  ");

    actualField = entity.getField();

    assertEquals(expectedField, actualField);
  }

  @Test
  public void testClone() {
    final String data = "RelTagLink";
    final String field = "/wiki/Category:Specifications";

    final MicroformatAlchemyEntity entity = new MicroformatAlchemyEntity();

    MicroformatAlchemyEntity clone = new MicroformatAlchemyEntity();

    assertTrue(entity.equals(clone));
    assertNotSame(entity, clone);


    entity.setData(data);
    clone = entity.clone();

    assertTrue(entity.equals(clone));
    assertNotSame(entity, clone);


    entity.setField(field);
    clone = entity.clone();

    assertTrue(entity.equals(clone));
    assertNotSame(entity, clone);
  }

  @Test
  public void testEquals() {
    final String data = "RelTagLink";
    final String field = "/wiki/Category:Specifications";

    final MicroformatAlchemyEntity entity = new MicroformatAlchemyEntity();

    assertFalse(entity.equals(null));
    assertFalse(entity.equals(new Double(1312D)));

    assertTrue(entity.equals(entity));
    assertEquals(entity, entity);
    assertSame(entity, entity);


    final MicroformatAlchemyEntity other = new MicroformatAlchemyEntity();

    assertTrue(entity.equals(other));
    assertEquals(entity, other);
    assertNotSame(entity, other);


    // data
    entity.setData(data);
    other.setData(null);

    assertFalse(entity.equals(other));
    assertNotSame(entity, other);


    entity.setData(null);
    other.setData(data);

    assertFalse(entity.equals(other));
    assertNotSame(entity, other);


    entity.setData(data);
    other.setData(data);

    assertTrue(entity.equals(other));
    assertEquals(entity, other);
    assertNotSame(entity, other);


    // field
    entity.setField(field);
    other.setField(null);

    assertFalse(entity.equals(other));
    assertNotSame(entity, other);


    entity.setField(null);
    other.setField(field);

    assertFalse(entity.equals(other));
    assertNotSame(entity, other);


    entity.setField(field);
    other.setField(field);

    assertTrue(entity.equals(other));
    assertEquals(entity, other);
    assertNotSame(entity, other);
  }

  @Test
  public void testToString() {
    final String data = "RelTagLink";
    final String field = "/wiki/Category:Specifications";

    final MicroformatAlchemyEntity entity = new MicroformatAlchemyEntity(data, field);

    final String expectedString = new ToStringBuilder(entity)
        .append("data", data)
        .append("field", field)
        .toString();

    final String actualString = entity.toString();

    assertEquals(expectedString, actualString);
  }

  @Test
  public void testToString_Formatted() {
    final ToStringStyle style = ToStringStyle.MULTI_LINE_STYLE;

    final String data = "RelTagLink";
    final String field = "/wiki/Category:Specifications";

    final MicroformatAlchemyEntity entity = new MicroformatAlchemyEntity(data, field);

    final String expectedString = new ToStringBuilder(entity, style)
        .append("data", data)
        .append("field", field)
        .toString();

    final String actualString = entity.toString(style);

    assertEquals(expectedString, actualString);
  }
}
