package com.epam.jmp.jabs.module2.task2.avro.kafka.producer.domain;

import java.util.Objects;

public class UserRequest {
    private String name;
    private Integer id;
    private Integer favoriteNumber;
    private String favoriteColor;

    public UserRequest() {
        super();
    }

    public UserRequest(String name, Integer id, Integer favoriteNumber, String favoriteColor) {
        this.name = name;
        this.id = id;
        this.favoriteNumber = favoriteNumber;
        this.favoriteColor = favoriteColor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFavoriteNumber() {
        return favoriteNumber;
    }

    public void setFavoriteNumber(Integer favoriteNumber) {
        this.favoriteNumber = favoriteNumber;
    }

    public String getFavoriteColor() {
        return favoriteColor;
    }

    public void setFavoriteColor(String favoriteColor) {
        this.favoriteColor = favoriteColor;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UserRequest that = (UserRequest) o;
        return Objects.equals(name, that.name) && Objects.equals(id, that.id) && Objects.equals(favoriteNumber, that.favoriteNumber) && Objects.equals(favoriteColor, that.favoriteColor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, favoriteNumber, favoriteColor);
    }
}