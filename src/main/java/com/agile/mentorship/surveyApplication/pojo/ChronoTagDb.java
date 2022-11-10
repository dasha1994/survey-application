package com.agile.mentorship.surveyApplication.pojo;


import java.util.Objects;

public class ChronoTagDb {
    private String id;
    private String value;
    private int displayOrder;
    private int setupId;
    private boolean isDefault;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChronoTagDb that = (ChronoTagDb) o;
        return displayOrder == that.displayOrder &&
                setupId == that.setupId &&
                isDefault == that.isDefault &&
                id.equals(that.id) &&
                value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, value, displayOrder, setupId, isDefault);
    }

    @Override
    public String toString() {
        return "ChronoTagDb{" +
                "id='" + id + '\'' +
                ", value='" + value + '\'' +
                ", displayOrder=" + displayOrder +
                ", setupId=" + setupId +
                ", isDefault=" + isDefault +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
