package org.nbicocchi.utils;

import java.util.UUID;

public class Sausage {
    UUID id;
    double length;
    double diameter;
    double weight;
    String quality;

    public Sausage(UUID id, double length, double diameter, double weight, String quality) {
        this.id = id;
        this.length = length;
        this.diameter = diameter;
        this.weight = weight;
        this.quality = quality;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    @Override
    public String toString() {
        return "sausage{" +
                "id=" + id +
                ", length=" + length +
                ", diameter=" + diameter +
                ", weight=" + weight +
                ", quality='" + quality + '\'' +
                '}';
    }
}
