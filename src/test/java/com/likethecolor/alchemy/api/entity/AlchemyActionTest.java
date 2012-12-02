/**
 * File: ActionAlchemyEntityTest.java
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

public class AlchemyActionTest {
  @Test
  public void testLematized() {
    final String expectedLematized = "have be find";
    final AlchemyAction entity = new AlchemyAction();

    entity.setLematized(expectedLematized);

    String actualLematized = entity.getLematized();

    assertEquals(expectedLematized, actualLematized);

    // null - should change value
    entity.setLematized(null);

    actualLematized = entity.getLematized();

    assertNull(actualLematized);

    // empty string - should change value
    entity.setLematized(expectedLematized);
    entity.setLematized("");

    actualLematized = entity.getLematized();

    assertEquals("", actualLematized);

    // empty white space string - should change value and be trimmed
    entity.setLematized(expectedLematized);
    entity.setLematized("\t  \t\r\n");

    actualLematized = entity.getLematized();

    assertEquals("", actualLematized);

    // should trim
    entity.setLematized("\n\r  " + expectedLematized + "   \t  ");

    actualLematized = entity.getLematized();

    assertEquals(expectedLematized, actualLematized);
  }

  @Test
  public void testText() {
    final String expectedText = "has been found";
    final AlchemyAction entity = new AlchemyAction();

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
  public void testVerb() {
    final boolean isNegated = true;
    final String verbText = "find";
    final AlchemyVerb.TENSE tense = AlchemyVerb.TENSE.PAST;

    final AlchemyVerb expectedVerbEntity = new AlchemyVerb();

    expectedVerbEntity.setIsNegated(isNegated);
    expectedVerbEntity.setTense(tense);
    expectedVerbEntity.setText(verbText);

    final AlchemyAction entity = new AlchemyAction();

    entity.setVerb(expectedVerbEntity);

    assertEquals(expectedVerbEntity, entity.getVerb());
    assertNotSame(expectedVerbEntity, entity.getVerb());
  }

  @Test
  public void testClone() {
    final String expectedLematized = "have be find";
    final String expectedText = "has been found";
    final boolean isNegated = true;
    final String verbText = "find";
    final AlchemyVerb.TENSE tense = AlchemyVerb.TENSE.PAST;

    final AlchemyVerb expectedVerbEntity = new AlchemyVerb();

    expectedVerbEntity.setIsNegated(isNegated);
    expectedVerbEntity.setTense(tense);
    expectedVerbEntity.setText(verbText);

    final AlchemyAction entity = new AlchemyAction();
    AlchemyAction clone = entity.clone();

    assertTrue(entity.equals(clone));
    assertNotSame(entity, clone);


    entity.setLematized(expectedLematized);
    clone = entity.clone();

    assertTrue(entity.equals(clone));
    assertNotSame(entity, clone);


    entity.setText(expectedText);
    clone = entity.clone();

    assertTrue(entity.equals(clone));
    assertNotSame(entity, clone);

    entity.setVerb(expectedVerbEntity);
    clone = entity.clone();

    assertTrue(entity.equals(clone));
    assertNotSame(entity, clone);
  }

  @Test
  public void testEquals() {
    final String lematized = "have be find";
    final String text = "has been found";
    final boolean isNegated = true;
    final String verbText = "find";
    final AlchemyVerb.TENSE tense = AlchemyVerb.TENSE.PAST;

    final AlchemyVerb verbEntity = new AlchemyVerb();

    verbEntity.setIsNegated(isNegated);
    verbEntity.setTense(tense);
    verbEntity.setText(verbText);

    final AlchemyAction entity = new AlchemyAction();

    assertFalse(entity.equals(null));
    assertFalse(entity.equals(new Double(92341.123D)));

    assertTrue(entity.equals(entity));
    assertEquals(entity, entity);
    assertSame(entity, entity);


    AlchemyAction other = new AlchemyAction();

    assertTrue(entity.equals(other));
    assertEquals(entity, other);
    assertNotSame(entity, other);


    // lematized
    entity.setLematized(null);
    other.setLematized(lematized + "foo");

    assertFalse(entity.equals(other));
    assertNotSame(entity, other);


    entity.setLematized(lematized);

    assertFalse(entity.equals(other));
    assertNotSame(entity, other);


    other.setLematized(lematized + "foo");

    assertFalse(entity.equals(other));
    assertNotSame(entity, other);


    other.setLematized(lematized);

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


    other.setText(text);

    assertTrue(entity.equals(other));
    assertEquals(entity, other);
    assertNotSame(entity, other);


    // verb
    entity.setVerb(null);
    other.setVerb(verbEntity);

    assertFalse(entity.equals(other));
    assertNotSame(entity, other);


    other.setVerb(null);
    entity.setVerb(verbEntity);

    assertFalse(entity.equals(other));
    assertNotSame(entity, other);


    // all values in both objects are the same
    other.setVerb(verbEntity);

    assertTrue(entity.equals(other));
    assertEquals(entity, other);
    assertNotSame(entity, other);
  }

  @Test
  public void testToString() {
    final String lematized = "have be find";
    final String text = "has been found";
    final boolean isNegated = true;
    final String verbText = "find";
    final AlchemyVerb.TENSE tense = AlchemyVerb.TENSE.PAST;

    final AlchemyVerb verbEntity = new AlchemyVerb();

    verbEntity.setIsNegated(isNegated);
    verbEntity.setTense(tense);
    verbEntity.setText(verbText);

    final AlchemyAction entity = new AlchemyAction();
    entity.setLematized(lematized);
    entity.setText(text);
    entity.setVerb(verbEntity);

    final String expectedString = new ToStringBuilder(entity)
        .append("lematized", lematized)
        .append("text", text)
        .append("verb", verbEntity)
        .toString();

    final String actualString = entity.toString();

    assertEquals(expectedString, actualString);
  }

  @Test
  public void testToString_Formatted() {
    final String lematized = "have be find";
    final String text = "has been found";
    final boolean isNegated = true;
    final String verbText = "find";
    final AlchemyVerb.TENSE tense = AlchemyVerb.TENSE.PAST;
    final ToStringStyle style = ToStringStyle.MULTI_LINE_STYLE;

    final AlchemyVerb verbEntity = new AlchemyVerb();

    verbEntity.setIsNegated(isNegated);
    verbEntity.setTense(tense);
    verbEntity.setText(verbText);

    final AlchemyAction entity = new AlchemyAction();
    entity.setLematized(lematized);
    entity.setText(text);
    entity.setVerb(verbEntity);

    final String expectedString = new ToStringBuilder(entity, style)
        .append("lematized", lematized)
        .append("text", text)
        .append("verb", verbEntity.toString(style))
        .toString();

    final String actualString = entity.toString(style);

    assertEquals(expectedString, actualString);
  }
}
