package com.agile.mentorship.surveyApplication.dto;

import java.util.Objects;

public class ChronoTagDto {
    private int id;
    private String value;
    private int displayOrder;
    private int setupId;
    private boolean isDefault;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChronoTagDto that = (ChronoTagDto) o;
        return displayOrder == that.displayOrder &&
                setupId == that.setupId &&
                isDefault == that.isDefault &&
                id == that.id &&
                value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, value, displayOrder, setupId, isDefault);
    }

    @Override
    public String toString() {
        return "ChronoTagDto{" +
                "id='" + id + '\'' +
                ", value='" + value + '\'' +
                ", displayOrder=" + displayOrder +
                ", setupId=" + setupId +
                ", isDefault=" + isDefault +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
