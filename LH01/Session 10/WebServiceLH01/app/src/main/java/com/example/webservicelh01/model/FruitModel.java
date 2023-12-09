package com.example.webservicelh01.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FruitModel {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("family")
    @Expose
    private String family;
    @SerializedName("order")
    @Expose
    private String order;
    @SerializedName("genus")
    @Expose
    private String genus;
    @SerializedName("nutritions")
    @Expose
    private Nutritions nutritions;

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

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getGenus() {
        return genus;
    }

    public void setGenus(String genus) {
        this.genus = genus;
    }

    public Nutritions getNutritions() {
        return nutritions;
    }

    public void setNutritions(Nutritions nutritions) {
        this.nutritions = nutritions;
    }

    public class Nutritions {

        @SerializedName("calories")
        @Expose
        private Integer calories;
        @SerializedName("fat")
        @Expose
        private Double fat;
        @SerializedName("sugar")
        @Expose
        private Double sugar;
        @SerializedName("carbohydrates")
        @Expose
        private Double carbohydrates;
        @SerializedName("protein")
        @Expose
        private Double protein;

        public Integer getCalories() {
            return calories;
        }

        public void setCalories(Integer calories) {
            this.calories = calories;
        }

        public Double getFat() {
            return fat;
        }

        public void setFat(Double fat) {
            this.fat = fat;
        }

        public Double getSugar() {
            return sugar;
        }

        public void setSugar(Double sugar) {
            this.sugar = sugar;
        }

        public Double getCarbohydrates() {
            return carbohydrates;
        }

        public void setCarbohydrates(Double carbohydrates) {
            this.carbohydrates = carbohydrates;
        }

        public Double getProtein() {
            return protein;
        }

        public void setProtein(Double protein) {
            this.protein = protein;
        }

    }

}
