/**
 * File: RelationAlchemyEntityTest.java
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

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

public class RelationAlchemyEntityTest {
  @Test
  public void testConstructor_NoArgs() {
    final RelationAlchemyEntity entity = new RelationAlchemyEntity();

    assertNull(entity.getAction());
    assertNull(entity.getSubject());
    assertNull(entity.getObject());
  }

  @Test
  public void testConstructor() {
    final AlchemyAction action = getAction();
    final AlchemyObject object = getObject();
    final AlchemySubject subject = getSubject();


    final RelationAlchemyEntity entity = new RelationAlchemyEntity(action, object, subject);

    assertEquals(action, entity.getAction());
    assertNotSame(action, entity.getAction());

    assertEquals(object, entity.getObject());
    assertNotSame(object, entity.getObject());

    assertEquals(subject, entity.getSubject());
    assertNotSame(subject, entity.getSubject());
  }

  @Test
  public void testAction() {
    final AlchemyAction action = getAction();
    final RelationAlchemyEntity entity = new RelationAlchemyEntity();

    entity.setAction(action);

    assertEquals(action, entity.getAction());
    assertNotSame(action, entity.getAction());
    assertNull(entity.getSubject());
    assertNull(entity.getObject());
  }

  @Test
  public void testObject() {
    final AlchemyObject object = getObject();
    final RelationAlchemyEntity entity = new RelationAlchemyEntity();

    entity.setObject(object);

    assertEquals(object, entity.getObject());
    assertNotSame(object, entity.getObject());
    assertNull(entity.getAction());
    assertNull(entity.getSubject());
  }

  @Test
  public void testSubject() {
    final AlchemySubject subject = getSubject();
    final RelationAlchemyEntity entity = new RelationAlchemyEntity();

    entity.setSubject(subject);

    assertEquals(subject, entity.getSubject());
    assertNotSame(subject, entity.getSubject());
    assertNull(entity.getAction());
    assertNull(entity.getObject());
  }

  @Test
  public void testClone() {
    final AlchemyAction action = getAction();
    final AlchemyObject object = getObject();
    final AlchemySubject subject = getSubject();


    final RelationAlchemyEntity entity = new RelationAlchemyEntity();
    RelationAlchemyEntity clone = new RelationAlchemyEntity();

    assertEquals(entity, clone);
    assertNotSame(entity, clone);

    entity.setAction(action);
    clone = entity.clone();

    assertEquals(entity, clone);
    assertNotSame(entity, clone);

    entity.setSubject(subject);
    clone = entity.clone();

    assertEquals(entity, clone);
    assertNotSame(entity, clone);

    entity.setObject(object);
    clone = entity.clone();

    assertEquals(entity, clone);
    assertNotSame(entity, clone);
  }

  @Test
  public void testEquals() {
    final AlchemyAction action = getAction();
    final AlchemyObject object = getObject();
    final AlchemySubject subject = getSubject();


    final RelationAlchemyEntity entity = new RelationAlchemyEntity();

    assertFalse(entity.equals(null));
    assertFalse(entity.equals(new Double(1312D)));

    assertTrue(entity.equals(entity));
    assertEquals(entity, entity);
    assertSame(entity, entity);


    final RelationAlchemyEntity other = new RelationAlchemyEntity();

    assertTrue(entity.equals(other));
    assertEquals(entity, other);
    assertNotSame(entity, other);


    // action
    entity.setAction(action);
    other.setAction(null);

    assertFalse(entity.equals(other));
    assertNotSame(entity, other);


    entity.setAction(null);
    other.setAction(action);

    assertFalse(entity.equals(other));
    assertNotSame(entity, other);


    entity.setAction(action);
    other.setAction(action);

    assertTrue(entity.equals(other));
    assertEquals(entity, other);
    assertNotSame(entity, other);


    // object
    entity.setObject(object);
    other.setObject(null);

    assertFalse(entity.equals(other));
    assertNotSame(entity, other);


    entity.setObject(null);
    other.setObject(object);

    assertFalse(entity.equals(other));
    assertNotSame(entity, other);


    entity.setObject(object);
    other.setObject(object);

    assertTrue(entity.equals(other));
    assertEquals(entity, other);
    assertNotSame(entity, other);


    // subject
    entity.setSubject(subject);
    other.setSubject(null);

    assertFalse(entity.equals(other));
    assertNotSame(entity, other);


    entity.setSubject(null);
    other.setSubject(subject);

    assertFalse(entity.equals(other));
    assertNotSame(entity, other);


    entity.setSubject(subject);
    other.setSubject(subject);

    assertTrue(entity.equals(other));
    assertEquals(entity, other);
    assertNotSame(entity, other);
  }

  @Test
  public void testToString() {
    final AlchemyAction action = getAction();
    final AlchemyObject object = getObject();
    final AlchemySubject subject = getSubject();

    final RelationAlchemyEntity entity = new RelationAlchemyEntity(action, object, subject);

    String expectedString = new ToStringBuilder(entity)
        .append("action", action.toString())
        .append("object", object.toString())
        .append("subject", subject.toString())
        .toString();

    String actualString = entity.toString();

    assertEquals(expectedString, actualString);

    // null action
    entity.setAction(null);

    expectedString = new ToStringBuilder(entity)
        .append("action", (String) null)
        .append("object", object.toString())
        .append("subject", subject.toString())
        .toString();

    actualString = entity.toString();

    assertEquals(expectedString, actualString);

    // null object
    entity.setAction(action);
    entity.setObject(null);

    expectedString = new ToStringBuilder(entity)
        .append("action", action.toString())
        .append("object", (String) null)
        .append("subject", subject.toString())
        .toString();

    actualString = entity.toString();

    assertEquals(expectedString, actualString);

    // null subject
    entity.setAction(action);
    entity.setObject(object);
    entity.setSubject(null);

    expectedString = new ToStringBuilder(entity)
        .append("action", action.toString())
        .append("object", object.toString())
        .append("subject", (String) null)
        .toString();

    actualString = entity.toString();

    assertEquals(expectedString, actualString);
  }

  @Test
  public void testToString_Formatted() {
    final ToStringStyle style = ToStringStyle.SIMPLE_STYLE;
    final AlchemyAction action = getAction();
    final AlchemyObject object = getObject();
    final AlchemySubject subject = getSubject();

    final RelationAlchemyEntity entity = new RelationAlchemyEntity(action, object, subject);

    String expectedString = new ToStringBuilder(entity, style)
        .append("action", action.toString(style))
        .append("object", object.toString(style))
        .append("subject", subject.toString(style))
        .toString();

    String actualString = entity.toString(style);

    assertEquals(expectedString, actualString);

    // null action
    entity.setAction(null);

    expectedString = new ToStringBuilder(entity, style)
        .append("action", (String) null)
        .append("object", object.toString(style))
        .append("subject", subject.toString(style))
        .toString();

    actualString = entity.toString(style);

    assertEquals(expectedString, actualString);

    // null object
    entity.setAction(action);
    entity.setObject(null);

    expectedString = new ToStringBuilder(entity, style)
        .append("action", action.toString(style))
        .append("object", (String) null)
        .append("subject", subject.toString(style))
        .toString();

    actualString = entity.toString(style);

    assertEquals(expectedString, actualString);

    // null subject
    entity.setAction(action);
    entity.setObject(object);
    entity.setSubject(null);

    expectedString = new ToStringBuilder(entity, style)
        .append("action", action.toString(style))
        .append("object", object.toString(style))
        .append("subject", (String) null)
        .toString();

    actualString = entity.toString(style);

    assertEquals(expectedString, actualString);
  }


  private AlchemyObject getObject() {
    final String text = "his disregard for life";
    final SentimentAlchemyEntity sentimentEntity = getSentiment();

    final AlchemyObject object = new AlchemyObject();
    object.setSentiment(sentimentEntity);
    object.setText(text);
    return object;
  }

  private AlchemyAction getAction() {
    final String lematized = "say";
    final String actionText = "said";
    final AlchemyVerb verb = getVerb();

    final AlchemyAction action = new AlchemyAction();
    action.setLematized(lematized);
    action.setText(actionText);
    action.setVerb(verb);
    return action;
  }

  private AlchemySubject getSubject() {
    final String text = "Marcus Schrenker";
    return new AlchemySubject(getEntity(), text);
  }

  private SentimentAlchemyEntity getSentiment() {
    final boolean isMixed = true;
    final Double score = 0.9734D;
    final SentimentAlchemyEntity.TYPE type = SentimentAlchemyEntity.TYPE.NEGATIVE;

    return new SentimentAlchemyEntity(isMixed, score, type.toString());
  }

  private AlchemyVerb getVerb() {
    final boolean isNegated = false;
    final String text = "say";
    final String tense = "past";
    return new AlchemyVerb(isNegated, tense, text);
  }

  private AlchemyEntity getEntity() {
    final String census = "http://census.org/resource/Israel";
    final String ciaFactbook = "http://www4.wiwiss.fu-berlin.de/factbook/resource/Israel";
    final String crunchbase = "http://crunchbase.com/resource/Israel";
    final String dbPedia = "http://dbpedia.org/resource/Israel";
    final String freebase = "http://rdf.freebase.com/ns/guid.9202a8c04000641f800000000001e2be";
    final Double latitude = 31.0D;
    final Double longitude = 35.0D;
    final String geo = latitude + " " + longitude;
    final String geonames = "http://geonames.com/Israel";
    final String musicBrainz = "http://musicbrainz.com/Israel";
    final String name = "Israel";
    final String opencyc = "http://sw.opencyc.org/concept/Mx4rvViP55wpEbGdrcN5Y29ycA";
    final String semanticCrunchbase = "http://semanticcrunchbase.com/concept/Mx4rvViP55wpEbGdrcN5Y29ycA";
    final String type = "Country";
    final String entityText = "Israel";
    final String umbel = "http://umbel.org/umbel/ne/wikipedia/Israel";
    final String website = "http://www.knesset.gov.il/";
    final String yago = "http://mpii.de/yago/resource/Israel";
    final List<String> subtypes = new ArrayList<String>();
    subtypes.add("Location");
    subtypes.add("Country");
    subtypes.add("GovernmentalJurisdiction");

    final AlchemyEntity alchemyEntity = new AlchemyEntity();
    alchemyEntity.setCensus(census);
    alchemyEntity.setCIAFactbook(ciaFactbook);
    alchemyEntity.setCrunchbase(crunchbase);
    alchemyEntity.setDBPedia(dbPedia);
    alchemyEntity.setFreebase(freebase);
    alchemyEntity.setGeo(geo);
    alchemyEntity.setGeonames(geonames);
    alchemyEntity.setMusicBrainz(musicBrainz);
    alchemyEntity.setName(name);
    alchemyEntity.setOpencyc(opencyc);
    alchemyEntity.setSemanticCrunchbase(semanticCrunchbase);
    alchemyEntity.setText(entityText);
    alchemyEntity.setType(type);
    alchemyEntity.setUmbel(umbel);
    alchemyEntity.setWebsite(website);
    alchemyEntity.setYago(yago);
    for(String subtype : subtypes) {
      alchemyEntity.addSubtype(subtype);
    }
    return alchemyEntity;
  }
}
