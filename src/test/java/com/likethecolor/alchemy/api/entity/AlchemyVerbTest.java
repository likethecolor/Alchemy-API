/**
 * File: VerbAlchemyEntityTest.java
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

public class AlchemyVerbTest {
  @Test
  public void testConstructor_NoArg() {
    final boolean expectedIsNegated = false;
    final AlchemyVerb.TENSE expectedTense = AlchemyVerb.TENSE.UNSET;
    final String expectedText = null;

    final AlchemyVerb entity = new AlchemyVerb();

    assertEquals(expectedIsNegated, entity.isNegated());
    assertEquals(expectedTense, entity.getTense());
    assertEquals(expectedText, entity.getText());
  }

  @Test
  public void testConstructor() {
    final boolean expectedIsNegated = true;
    final AlchemyVerb.TENSE expectedTense = AlchemyVerb.TENSE.PAST;
    final String tense = AlchemyVerb.TENSE.PAST.toString();
    final String expectedText = "find";

    final AlchemyVerb entity = new AlchemyVerb(expectedIsNegated, tense, expectedText);

    assertEquals(expectedIsNegated, entity.isNegated());
    assertEquals(expectedTense, entity.getTense());
    assertEquals(expectedText, entity.getText());
  }

  @Test
  public void testConstructor_IsNegatedInt() {
    final boolean expectedIsNegated = true;
    final int isNegated = 1;
    final AlchemyVerb.TENSE expectedTense = AlchemyVerb.TENSE.PAST;
    final String tense = AlchemyVerb.TENSE.PAST.toString();
    final String expectedText = "find";

    final AlchemyVerb entity = new AlchemyVerb(isNegated, tense, expectedText);

    assertEquals(expectedIsNegated, entity.isNegated());
    assertEquals(expectedTense, entity.getTense());
    assertEquals(expectedText, entity.getText());
  }

  @Test
  public void testIsNegated() {
    final boolean expectedIsNegated = true;

    final AlchemyVerb entity = new AlchemyVerb();

    // default is false
    assertFalse(entity.isNegated());

    entity.setIsNegated(expectedIsNegated);

    assertEquals(expectedIsNegated, entity.isNegated());
  }

  @Test
  public void testIsNegated_Int() {
    final AlchemyVerb entity = new AlchemyVerb();

    // default is false
    assertFalse(entity.isNegated());

    entity.setIsNegated(1);

    assertTrue(entity.isNegated());

    entity.setIsNegated(0);

    assertFalse(entity.isNegated());
  }

  @Test
  public void testTense() {
    final AlchemyVerb.TENSE defaultTense = AlchemyVerb.TENSE.UNSET;
    final AlchemyVerb.TENSE expectedTense0 = AlchemyVerb.TENSE.PAST;
    final AlchemyVerb.TENSE expectedTense1 = AlchemyVerb.TENSE.PRESENT;
    final AlchemyVerb.TENSE expectedTense2 = AlchemyVerb.TENSE.FUTURE;

    final AlchemyVerb entity = new AlchemyVerb();

    // default is unset
    assertEquals(defaultTense, entity.getTense());

    entity.setTense(expectedTense0);

    assertEquals(expectedTense0, entity.getTense());

    entity.setTense(expectedTense0);
    entity.setTense((AlchemyVerb.TENSE) null);

    assertEquals(defaultTense, entity.getTense());

    entity.setTense(expectedTense1);

    assertEquals(expectedTense1, entity.getTense());

    entity.setTense(expectedTense2);

    assertEquals(expectedTense2, entity.getTense());
  }

  @Test
  public void testTense_String() {
    final String tense0 = AlchemyVerb.TENSE.PAST.toString();
    final String tense1 = AlchemyVerb.TENSE.PRESENT.toString();
    final String tense2 = AlchemyVerb.TENSE.FUTURE.toString();
    final String tense3 = AlchemyVerb.TENSE.UNSET.toString();
    final AlchemyVerb.TENSE defaultTense = AlchemyVerb.TENSE.UNSET;
    final AlchemyVerb.TENSE expectedTense0 = AlchemyVerb.TENSE.PAST;
    final AlchemyVerb.TENSE expectedTense1 = AlchemyVerb.TENSE.PRESENT;
    final AlchemyVerb.TENSE expectedTense2 = AlchemyVerb.TENSE.FUTURE;
    final AlchemyVerb.TENSE expectedTense3 = AlchemyVerb.TENSE.UNSET;

    final AlchemyVerb entity = new AlchemyVerb();

    // default is unset
    assertEquals(defaultTense, entity.getTense());

    entity.setTense(tense0);

    assertEquals(expectedTense0, entity.getTense());

    entity.setTense(tense1);

    assertEquals(expectedTense1, entity.getTense());

    entity.setTense(tense2);

    assertEquals(expectedTense2, entity.getTense());

    entity.setTense(tense3);

    assertEquals(expectedTense3, entity.getTense());

    // null - default
    entity.setTense(tense0);
    entity.setTense((String) null);

    assertEquals(defaultTense, entity.getTense());

    // empty string - default
    entity.setTense(tense0);
    entity.setTense("");

    assertEquals(defaultTense, entity.getTense());

    // empty white space string - default
    entity.setTense(tense0);
    entity.setTense("\t  \r \n");

    assertEquals(defaultTense, entity.getTense());
  }

  @Test
  public void testText() {
    final String expectedText = "find";
    final AlchemyVerb entity = new AlchemyVerb();

    entity.setText(expectedText);

    String actualText = entity.getText();

    assertEquals(expectedText, actualText);

    // null - should change value
    entity.setText(null);

    actualText = entity.getText();

    assertNull(actualText);

    // empty string - should change value
    entity.setText(expectedText);
    entity.setText("");

    actualText = entity.getText();

    assertEquals("", actualText);

    // empty white space string - should change value and be trimmed
    entity.setText(expectedText);
    entity.setText("\t  \t\r\n");

    actualText = entity.getText();

    assertEquals("", actualText);

    // should trim
    entity.setText("\n\r  " + expectedText + "   \t  ");

    actualText = entity.getText();

    assertEquals(expectedText, actualText);
  }

  @Test
  public void testClone() {
    final boolean isNegated = true;
    final String text = "find";
    final AlchemyVerb.TENSE tense = AlchemyVerb.TENSE.PAST;

    final AlchemyVerb entity = new AlchemyVerb();

    AlchemyVerb clone = entity.clone();

    assertTrue(entity.equals(clone));
    assertNotSame(entity, clone);


    entity.setIsNegated(isNegated);
    clone = entity.clone();

    assertTrue(entity.equals(clone));
    assertNotSame(entity, clone);


    entity.setTense(tense);
    clone = entity.clone();

    assertTrue(entity.equals(clone));
    assertNotSame(entity, clone);


    entity.setText(text);
    clone = entity.clone();

    assertTrue(entity.equals(clone));
    assertNotSame(entity, clone);
  }

  @Test
  public void testEquals() {
    final boolean isNegated = true;
    final String text = "find";
    final AlchemyVerb.TENSE tense = AlchemyVerb.TENSE.PAST;

    final AlchemyVerb entity = new AlchemyVerb();

    assertFalse(entity.equals(null));
    assertFalse(entity.equals(new Double(1312D)));

    assertTrue(entity.equals(entity));
    assertEquals(entity, entity);
    assertSame(entity, entity);


    final AlchemyVerb other = new AlchemyVerb();

    assertTrue(entity.equals(other));
    assertEquals(entity, other);
    assertNotSame(entity, other);


    // negated
    entity.setIsNegated(isNegated);

    assertFalse(entity.equals(other));
    assertNotSame(entity, other);


    other.setIsNegated(isNegated);

    assertTrue(entity.equals(other));
    assertEquals(entity, other);
    assertNotSame(entity, other);


    // tense
    entity.setTense(tense);

    assertFalse(entity.equals(other));
    assertNotSame(entity, other);


    other.setTense(tense);

    assertTrue(entity.equals(other));
    assertEquals(entity, other);
    assertNotSame(entity, other);


    // text
    entity.setText(null);
    other.setText(text + "foo");

    assertFalse(entity.equals(other));
    assertNotSame(entity, other);


    entity.setText(text);

    assertFalse(entity.equals(other));
    assertNotSame(entity, other);


    other.setText(text + "foo");

    assertFalse(entity.equals(other));
    assertNotSame(entity, other);


    // all values in both objects are the same
    other.setText(text);

    assertTrue(entity.equals(other));
    assertEquals(entity, other);
    assertNotSame(entity, other);
  }

  @Test
  public void testToString() {
    final boolean isNegated = true;
    final String text = "find";
    final AlchemyVerb.TENSE tense = AlchemyVerb.TENSE.PAST;

    final AlchemyVerb entity = new AlchemyVerb();
    entity.setIsNegated(isNegated);
    entity.setTense(tense);
    entity.setText(text);

    final String expectedString = new ToStringBuilder(entity)
        .append("is negated", isNegated)
        .append("tense", tense)
        .append("text", text)
        .toString();

    final String actualString = entity.toString();

    assertEquals(expectedString, actualString);
  }

  @Test
  public void testToString_Formatted() {
    final boolean isNegated = true;
    final String text = "find";
    final AlchemyVerb.TENSE tense = AlchemyVerb.TENSE.PAST;
    final ToStringStyle style = ToStringStyle.MULTI_LINE_STYLE;

    final AlchemyVerb entity = new AlchemyVerb();

    final String expectedString = new ToStringBuilder(entity, style)
        .append("is negated", isNegated)
        .append("tense", tense)
        .append("text", text)
        .toString();

    entity.setIsNegated(isNegated);
    entity.setTense(tense);
    entity.setText(text);

    final String actualString = entity.toString(style);

    assertEquals(expectedString, actualString);
  }
}
