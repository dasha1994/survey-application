package com.agile.mentorship.surveyApplication.model;


import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document("chronoTags")
public class ChronoTag {

    @Id
    private ObjectId id;
    private String value;
    private int displayOrder;
    private int setupId;
    private boolean isDefault;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChronoTag chronoTag = (ChronoTag) o;
        return id == chronoTag.id &&
                displayOrder == chronoTag.displayOrder &&
                setupId == chronoTag.setupId &&
                isDefault == chronoTag.isDefault &&
                Objects.equals(value, chronoTag.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, value, displayOrder, setupId, isDefault);
    }

    @Override
    public String toString() {
        return "ChronoTag{" +
                "id='" + id + '\'' +
                ", value='" + value + '\'' +
                ", displayOrder=" + displayOrder +
                ", setupId=" + setupId +
                ", isDefault=" + isDefault +
                '}';
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(int displayOrder) {
        this.displayOrder = displayOrder;
    }

    public int getSetupId() {
        return setupId;
    }

    public void setSetupId(int setupId) {
        this.setupId = setupId;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean aDefault) {
        isDefault = aDefault;
    }
}
