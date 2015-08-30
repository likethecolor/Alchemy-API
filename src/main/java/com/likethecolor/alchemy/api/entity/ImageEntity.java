package com.likethecolor.alchemy.api.entity;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * Created by ainurminibaev on 30.08.15.
 */
public class ImageEntity extends AbstractAlchemyEntity {

    private String text;

    public ImageEntity(Double score, String text) {
        super(score);
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    /**
     * @return string representing this object
     * @see #toString(org.apache.commons.lang.builder.ToStringStyle)
     */
    @Override
    public String toString() {
        return toString(ToStringStyle.DEFAULT_STYLE);
    }

    /**
     * @return string representing this object
     * @see ToStringBuilder
     */
    public String toString(final ToStringStyle style) {
        // note - do not do super.toString
        // it will result in a StackOverflowError from ToStringStyle
        return new ToStringBuilder(this, style)
                .append("score", getScore())
                .append("text", getText())
                .toString();
    }
}
