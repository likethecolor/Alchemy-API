/**
 * File: LanguageAlchemyEntityTest.java
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

public class LanguageAlchemyEntityTest {
  @Test
  public void testConstructor_NoArgs() {
    final LanguageAlchemyEntity entity = new LanguageAlchemyEntity();

    assertNull(entity.getEthnologue());
    assertNull(entity.getIso6391());
    assertNull(entity.getIso6392());
    assertNull(entity.getIso6392());
    assertNull(entity.getLanguage());
    assertNull(entity.getNumberOfNativeSpeakers());
    assertEquals(0, entity.getMinimumNumberOfNativeSpeakers());
    assertEquals(0, entity.getMaximumNumberOfNativeSpeakers());
    assertNull(entity.getWikipedia());
  }

  @Test
  public void testConstructor() {
    final String expectedLanguage = "english";

    LanguageAlchemyEntity entity = new LanguageAlchemyEntity(expectedLanguage);

    assertNull(entity.getEthnologue());
    assertNull(entity.getIso6391());
    assertNull(entity.getIso6392());
    assertNull(entity.getIso6392());
    assertEquals(expectedLanguage, entity.getLanguage());
    assertNull(entity.getNumberOfNativeSpeakers());
    assertEquals(0, entity.getMinimumNumberOfNativeSpeakers());
    assertEquals(0, entity.getMaximumNumberOfNativeSpeakers());
    assertNull(entity.getWikipedia());

    // should be trimmed
    entity = new LanguageAlchemyEntity("\t  \r \n" + expectedLanguage + "    ");

    assertEquals(expectedLanguage, entity.getLanguage());

    // null - should change value
    entity = new LanguageAlchemyEntity(null);

    assertNull(entity.getLanguage());
  }

  @Test
  public void testLanguage() {
    final String expectedLanguage = "english";
    final String expectedLanguage2 = "spanish";
    final LanguageAlchemyEntity entity = new LanguageAlchemyEntity(expectedLanguage);

    String actualLanguage = entity.getLanguage();

    assertEquals(expectedLanguage, actualLanguage);


    entity.setLanguage(expectedLanguage2);

    actualLanguage = entity.getLanguage();

    assertEquals(expectedLanguage2, actualLanguage);

    // null - should change value
    entity.setLanguage(null);

    actualLanguage = entity.getLanguage();

    assertNull(actualLanguage);

    // empty string - should change value
    entity.setLanguage(expectedLanguage);
    entity.setLanguage("");

    actualLanguage = entity.getLanguage();

    assertEquals("", actualLanguage);

    // empty white space string - should change value and be trimmed
    entity.setLanguage(expectedLanguage);
    entity.setLanguage("\t  \t\r\n");

    actualLanguage = entity.getLanguage();

    assertEquals("", actualLanguage);

    // should trim
    entity.setLanguage("\n\r  " + expectedLanguage + "   \t  ");

    actualLanguage = entity.getLanguage();

    assertEquals(expectedLanguage, actualLanguage);
  }

  @Test
  public void testEthnologue() {
    final String expectedEthnologue = "http://www.ethnologue.com/show_language.asp?code=eng";
    final String expectedEthnologue2 = "http://www.ethnologue.com/show_language.asp?code=afr";

    final LanguageAlchemyEntity entity = new LanguageAlchemyEntity();

    entity.setEthnologue(expectedEthnologue);

    String actualEthnologue = entity.getEthnologue();

    assertEquals(expectedEthnologue, actualEthnologue);


    entity.setEthnologue(expectedEthnologue2);

    actualEthnologue = entity.getEthnologue();

    assertEquals(expectedEthnologue2, actualEthnologue);

    // null - should change value
    entity.setEthnologue(null);

    actualEthnologue = entity.getEthnologue();

    assertNull(actualEthnologue);

    // empty string - should change value
    entity.setEthnologue(expectedEthnologue);
    entity.setEthnologue("");

    actualEthnologue = entity.getEthnologue();

    assertEquals("", actualEthnologue);

    // empty white space string - should change value and be trimmed
    entity.setEthnologue(expectedEthnologue);
    entity.setEthnologue("\t  \t\r\n");

    actualEthnologue = entity.getEthnologue();

    assertEquals("", actualEthnologue);

    // should trim
    entity.setEthnologue("\n\r  " + expectedEthnologue + "   \t  ");

    actualEthnologue = entity.getEthnologue();

    assertEquals(expectedEthnologue, actualEthnologue);
  }

  @Test
  public void testIso6391() {
    final String expectedIso6391 = "en";
    final String expectedIso63912 = "af";
    final LanguageAlchemyEntity entity = new LanguageAlchemyEntity();

    entity.setIso6391(expectedIso6391);

    String actualIso6391 = entity.getIso6391();

    assertEquals(expectedIso6391, actualIso6391);


    entity.setIso6391(expectedIso63912);

    actualIso6391 = entity.getIso6391();

    assertEquals(expectedIso63912, actualIso6391);

    // null - should change value
    entity.setIso6391(null);

    actualIso6391 = entity.getIso6391();

    assertNull(actualIso6391);

    // empty string - should change value
    entity.setIso6391(expectedIso6391);
    entity.setIso6391("");

    actualIso6391 = entity.getIso6391();

    assertEquals("", actualIso6391);

    // empty white space string - should change value and be trimmed
    entity.setIso6391(expectedIso6391);
    entity.setIso6391("\t  \t\r\n");

    actualIso6391 = entity.getIso6391();

    assertEquals("", actualIso6391);

    // should trim
    entity.setIso6391("\n\r  " + expectedIso6391 + "   \t  ");

    actualIso6391 = entity.getIso6391();

    assertEquals(expectedIso6391, actualIso6391);
  }

  @Test
  public void testIso6392() {
    final String expectedIso6392 = "eng";
    final String expectedIso63922 = "afr";
    final LanguageAlchemyEntity entity = new LanguageAlchemyEntity();

    entity.setIso6392(expectedIso6392);

    String actualIso6392 = entity.getIso6392();

    assertEquals(expectedIso6392, actualIso6392);


    entity.setIso6392(expectedIso63922);

    actualIso6392 = entity.getIso6392();

    assertEquals(expectedIso63922, actualIso6392);

    // null - should change value
    entity.setIso6392(null);

    actualIso6392 = entity.getIso6392();

    assertNull(actualIso6392);

    // empty string - should change value
    entity.setIso6392(expectedIso6392);
    entity.setIso6392("");

    actualIso6392 = entity.getIso6392();

    assertEquals("", actualIso6392);

    // empty white space string - should change value and be trimmed
    entity.setIso6392(expectedIso6392);
    entity.setIso6392("\t  \t\r\n");

    actualIso6392 = entity.getIso6392();

    assertEquals("", actualIso6392);

    // should trim
    entity.setIso6392("\n\r  " + expectedIso6392 + "   \t  ");

    actualIso6392 = entity.getIso6392();

    assertEquals(expectedIso6392, actualIso6392);
  }

  @Test
  public void testIso6393() {
    final String expectedIso6393 = "eng";
    final String expectedIso63932 = "afr";
    final LanguageAlchemyEntity entity = new LanguageAlchemyEntity();

    entity.setIso6393(expectedIso6393);

    String actualIso6393 = entity.getIso6393();

    assertEquals(expectedIso6393, actualIso6393);


    entity.setIso6393(expectedIso63932);

    actualIso6393 = entity.getIso6393();

    assertEquals(expectedIso63932, actualIso6393);

    // null - should change value
    entity.setIso6393(null);

    actualIso6393 = entity.getIso6393();

    assertNull(actualIso6393);

    // empty string - should change value
    entity.setIso6393(expectedIso6393);
    entity.setIso6393("");

    actualIso6393 = entity.getIso6393();

    assertEquals("", actualIso6393);

    // empty white space string - should change value and be trimmed
    entity.setIso6393(expectedIso6393);
    entity.setIso6393("\t  \t\r\n");

    actualIso6393 = entity.getIso6393();

    assertEquals("", actualIso6393);

    // should trim
    entity.setIso6393("\n\r  " + expectedIso6393 + "   \t  ");

    actualIso6393 = entity.getIso6393();

    assertEquals(expectedIso6393, actualIso6393);
  }

  @Test
  public void testNumberOfNativeSpeakers_Thousands() {
    int minimumNumberOfNativeSpeakers = 9342;
    int maximumNumberOfNativeSpeakers = 9342;
    String numberOfNativeSpeakers = "9342";

    LanguageAlchemyEntity entity = new LanguageAlchemyEntity();

    entity.setNumberOfNativeSpeakers(numberOfNativeSpeakers);

    String actualNumberOfNativeSpeakers = entity.getNumberOfNativeSpeakers();
    int actualMinimumNumberOfNativeSpeakers = entity.getMinimumNumberOfNativeSpeakers();
    int actualMaximumNumberOfNativeSpeakers = entity.getMaximumNumberOfNativeSpeakers();

    assertEquals(numberOfNativeSpeakers, actualNumberOfNativeSpeakers);
    assertEquals(minimumNumberOfNativeSpeakers, actualMinimumNumberOfNativeSpeakers);
    assertEquals(maximumNumberOfNativeSpeakers, actualMaximumNumberOfNativeSpeakers);
  }

  @Test
  public void testNumberOfNativeSpeakers_Range_Thousands() {
    int minimumNumberOfNativeSpeakers = 674;
    int maximumNumberOfNativeSpeakers = 9342;
    String numberOfNativeSpeakers = "674-9342";

    LanguageAlchemyEntity entity = new LanguageAlchemyEntity();

    entity.setNumberOfNativeSpeakers(numberOfNativeSpeakers);

    String actualNumberOfNativeSpeakers = entity.getNumberOfNativeSpeakers();
    int actualMinimumNumberOfNativeSpeakers = entity.getMinimumNumberOfNativeSpeakers();
    int actualMaximumNumberOfNativeSpeakers = entity.getMaximumNumberOfNativeSpeakers();

    assertEquals(numberOfNativeSpeakers, actualNumberOfNativeSpeakers);
    assertEquals(minimumNumberOfNativeSpeakers, actualMinimumNumberOfNativeSpeakers);
    assertEquals(maximumNumberOfNativeSpeakers, actualMaximumNumberOfNativeSpeakers);
  }

  @Test
  public void testNumberOfNativeSpeakers_Millions() {
    int minimumNumberOfNativeSpeakers = 6450000;
    int maximumNumberOfNativeSpeakers = 6450000;
    String numberOfNativeSpeakers = "6.45 million";

    LanguageAlchemyEntity entity = new LanguageAlchemyEntity();

    entity.setNumberOfNativeSpeakers(numberOfNativeSpeakers);

    String actualNumberOfNativeSpeakers = entity.getNumberOfNativeSpeakers();
    int actualMinimumNumberOfNativeSpeakers = entity.getMinimumNumberOfNativeSpeakers();
    int actualMaximumNumberOfNativeSpeakers = entity.getMaximumNumberOfNativeSpeakers();

    assertEquals(numberOfNativeSpeakers, actualNumberOfNativeSpeakers);
    assertEquals(minimumNumberOfNativeSpeakers, actualMinimumNumberOfNativeSpeakers);
    assertEquals(maximumNumberOfNativeSpeakers, actualMaximumNumberOfNativeSpeakers);
  }

  @Test
  public void testNumberOfNativeSpeakers_Range_Millions() {
    int minimumNumberOfNativeSpeakers = 1322307;
    int maximumNumberOfNativeSpeakers = 6021120;
    String numberOfNativeSpeakers = "1.322307-6.021120 million";

    LanguageAlchemyEntity entity = new LanguageAlchemyEntity();

    entity.setNumberOfNativeSpeakers(numberOfNativeSpeakers);

    String actualNumberOfNativeSpeakers = entity.getNumberOfNativeSpeakers();
    int actualMinimumNumberOfNativeSpeakers = entity.getMinimumNumberOfNativeSpeakers();
    int actualMaximumNumberOfNativeSpeakers = entity.getMaximumNumberOfNativeSpeakers();

    assertEquals(numberOfNativeSpeakers, actualNumberOfNativeSpeakers);
    assertEquals(minimumNumberOfNativeSpeakers, actualMinimumNumberOfNativeSpeakers);
    assertEquals(maximumNumberOfNativeSpeakers, actualMaximumNumberOfNativeSpeakers);
  }

  @Test
  public void testWikipedia() {
    final String expectedWikipedia = "http://en.wikipedia.org/wiki/English_language";
    final String expectedWikipedia2 = "http://en.wikipedia.org/wiki/Afrikaans_language";

    final LanguageAlchemyEntity entity = new LanguageAlchemyEntity();

    entity.setWikipedia(expectedWikipedia);

    String actualWikipedia = entity.getWikipedia();

    assertEquals(expectedWikipedia, actualWikipedia);


    entity.setWikipedia(expectedWikipedia2);

    actualWikipedia = entity.getWikipedia();

    assertEquals(expectedWikipedia2, actualWikipedia);

    // null - should change value
    entity.setWikipedia(null);

    actualWikipedia = entity.getWikipedia();

    assertNull(actualWikipedia);

    // empty string - should change value
    entity.setWikipedia(expectedWikipedia);
    entity.setWikipedia("");

    actualWikipedia = entity.getWikipedia();

    assertEquals("", actualWikipedia);

    // empty white space string - should change value and be trimmed
    entity.setWikipedia(expectedWikipedia);
    entity.setWikipedia("\t  \t\r\n");

    actualWikipedia = entity.getWikipedia();

    assertEquals("", actualWikipedia);

    // should trim
    entity.setWikipedia("\n\r  " + expectedWikipedia + "   \t  ");

    actualWikipedia = entity.getWikipedia();

    assertEquals(expectedWikipedia, actualWikipedia);
  }

  @Test
  public void testClone() {
    final String ethnologue = "http://www.ethnologue.com/show_language.asp?code=eng";
    final String iso6391 = "en";
    final String iso6392 = "eng";
    final String iso6393 = "eng";
    final String numberOfNativeSpeakers = "309-400 million";
    final String language = "english";
    final String wikipedia = "http://en.wikipedia.org/wiki/English_language";

    final LanguageAlchemyEntity entity = new LanguageAlchemyEntity();

    LanguageAlchemyEntity clone = entity.clone();

    assertTrue(entity.equals(clone));
    assertNotSame(entity, clone);


    entity.setEthnologue(ethnologue);
    clone = entity.clone();

    assertTrue(entity.equals(clone));
    assertNotSame(entity, clone);


    entity.setIso6391(iso6391);
    clone = entity.clone();

    assertTrue(entity.equals(clone));
    assertNotSame(entity, clone);


    entity.setIso6392(iso6392);
    clone = entity.clone();

    assertTrue(entity.equals(clone));
    assertNotSame(entity, clone);


    entity.setIso6393(iso6393);
    clone = entity.clone();

    assertTrue(entity.equals(clone));
    assertNotSame(entity, clone);


    entity.setNumberOfNativeSpeakers(numberOfNativeSpeakers);
    clone = entity.clone();

    assertTrue(entity.equals(clone));
    assertNotSame(entity, clone);


    entity.setWikipedia(wikipedia);
    clone = entity.clone();

    assertTrue(entity.equals(clone));
    assertNotSame(entity, clone);
  }

  @Test
  public void testEquals() {
    final String language = "english";
    final String ethnologue = "http://www.ethnologue.com/show_language.asp?code=eng";
    final String iso6391 = "eng";
    final String iso6392 = "eng";
    final String iso6393 = "eng";
    final String numberOfNativeSpeakers = "1.322307-6.021120 million";
    final String wikipedia = "http://en.wikipedia.org/wiki/English_language";

    final LanguageAlchemyEntity entity = new LanguageAlchemyEntity();

    assertFalse(entity.equals(null));
    assertFalse(entity.equals(new Double(1312D)));

    assertTrue(entity.equals(entity));
    assertEquals(entity, entity);
    assertSame(entity, entity);


    final LanguageAlchemyEntity other = new LanguageAlchemyEntity();

    assertTrue(entity.equals(other));
    assertEquals(entity, other);
    assertNotSame(entity, other);


    // ethnologue
    entity.setEthnologue(null);
    other.setEthnologue(ethnologue + "foo");

    assertFalse(entity.equals(other));
    assertNotSame(entity, other);


    entity.setEthnologue(ethnologue);

    assertFalse(entity.equals(other));
    assertNotSame(entity, other);


    other.setEthnologue(ethnologue);

    assertTrue(entity.equals(other));
    assertEquals(entity, other);
    assertNotSame(entity, other);


    // language
    entity.setLanguage(null);
    other.setLanguage(language + "foo");

    assertFalse(entity.equals(other));
    assertNotSame(entity, other);


    entity.setLanguage(language);

    assertFalse(entity.equals(other));
    assertNotSame(entity, other);


    other.setLanguage(language);

    assertTrue(entity.equals(other));
    assertEquals(entity, other);
    assertNotSame(entity, other);


    // iso6391
    entity.setIso6391(null);
    other.setIso6391(iso6391 + "foo");

    assertFalse(entity.equals(other));
    assertNotSame(entity, other);


    entity.setIso6391(iso6391);

    assertFalse(entity.equals(other));
    assertNotSame(entity, other);


    other.setIso6391(iso6391);

    assertTrue(entity.equals(other));
    assertEquals(entity, other);
    assertNotSame(entity, other);


    // iso6392
    entity.setIso6392(null);
    other.setIso6392(iso6392 + "foo");

    assertFalse(entity.equals(other));
    assertNotSame(entity, other);


    entity.setIso6392(iso6392);

    assertFalse(entity.equals(other));
    assertNotSame(entity, other);


    other.setIso6392(iso6392);

    assertTrue(entity.equals(other));
    assertEquals(entity, other);
    assertNotSame(entity, other);


    // iso6393
    entity.setIso6393(null);
    other.setIso6393(iso6393 + "foo");

    assertFalse(entity.equals(other));
    assertNotSame(entity, other);


    entity.setIso6393(iso6393);

    assertFalse(entity.equals(other));
    assertNotSame(entity, other);


    other.setIso6393(iso6393);

    assertTrue(entity.equals(other));
    assertEquals(entity, other);
    assertNotSame(entity, other);


    // numberOfNativeSpeakers
    entity.setNumberOfNativeSpeakers(null);
    other.setNumberOfNativeSpeakers(numberOfNativeSpeakers + "foo");

    assertFalse(entity.equals(other));
    assertNotSame(entity, other);


    entity.setNumberOfNativeSpeakers(numberOfNativeSpeakers);

    assertFalse(entity.equals(other));
    assertNotSame(entity, other);


    other.setNumberOfNativeSpeakers(numberOfNativeSpeakers);

    assertTrue(entity.equals(other));
    assertEquals(entity, other);
    assertNotSame(entity, other);


    // wikipedia
    entity.setWikipedia(null);
    other.setWikipedia(wikipedia + "foo");

    assertFalse(entity.equals(other));
    assertNotSame(entity, other);


    entity.setWikipedia(wikipedia);

    assertFalse(entity.equals(other));
    assertNotSame(entity, other);


    other.setWikipedia(wikipedia);

    assertTrue(entity.equals(other));
    assertEquals(entity, other);
    assertNotSame(entity, other);
  }

  @Test
  public void testToString() {
    final String language = "english";
    final String ethnologue = "http://www.ethnologue.com/show_language.asp?code=eng";
    final String iso6391 = "eng";
    final String iso6392 = "eng";
    final String iso6393 = "eng";
    final String numberOfNativeSpeakers = "1.322307-6.021120 million";
    final String wikipedia = "http://en.wikipedia.org/wiki/English_language";

    final LanguageAlchemyEntity entity = new LanguageAlchemyEntity(language);
    entity.setEthnologue(ethnologue);
    entity.setIso6391(iso6391);
    entity.setIso6392(iso6392);
    entity.setIso6393(iso6393);
    entity.setNumberOfNativeSpeakers(numberOfNativeSpeakers);
    entity.setWikipedia(wikipedia);

    final String expectedString = new ToStringBuilder(entity)
        .append("ethnologue", ethnologue)
        .append("iso-639-1", iso6391)
        .append("iso-639-2", iso6392)
        .append("iso-639-3", iso6393)
        .append("number of native speakers", numberOfNativeSpeakers)
        .append("wikipedia", wikipedia)
        .toString();

    final String actualString = entity.toString();

    assertEquals(expectedString, actualString);
  }

  @Test
  public void testToString_Formatted() {
    final ToStringStyle style = ToStringStyle.MULTI_LINE_STYLE;
    final String language = "english";
    final String ethnologue = "http://www.ethnologue.com/show_language.asp?code=eng";
    final String iso6391 = "eng";
    final String iso6392 = "eng";
    final String iso6393 = "eng";
    final String numberOfNativeSpeakers = "1.322307-6.021120 million";
    final String wikipedia = "http://en.wikipedia.org/wiki/English_language";

    final LanguageAlchemyEntity entity = new LanguageAlchemyEntity(language);
    entity.setEthnologue(ethnologue);
    entity.setIso6391(iso6391);
    entity.setIso6392(iso6392);
    entity.setIso6393(iso6393);
    entity.setNumberOfNativeSpeakers(numberOfNativeSpeakers);
    entity.setWikipedia(wikipedia);

    final String expectedString = new ToStringBuilder(entity, style)
        .append("ethnologue", ethnologue)
        .append("iso-639-1", iso6391)
        .append("iso-639-2", iso6392)
        .append("iso-639-3", iso6393)
        .append("number of native speakers", numberOfNativeSpeakers)
        .append("wikipedia", wikipedia)
        .toString();

    final String actualString = entity.toString(style);

    assertEquals(expectedString, actualString);
  }
}
