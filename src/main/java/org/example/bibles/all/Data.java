package org.example.bibles.all;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "data"
})

public class Data {
    @JsonPropertyOrder({
            "id",
            "dblId",
            "relatedDbl",
            "name",
            "nameLocal",
            "abbreviation",
            "abbreviationLocal",
            "description",
            "descriptionLocal",
            "language",
            "countries",
            "type",
            "updatedAt",
            "audioBibles"
    })


    @JsonProperty("id")
    private String id;
    @JsonProperty("dblId")
    private String dblId;
    @JsonProperty("relatedDbl")
    private Object relatedDbl;
    @JsonProperty("name")
    private String name;
    @JsonProperty("nameLocal")
    private String nameLocal;
    @JsonProperty("abbreviation")
    private String abbreviation;
    @JsonProperty("abbreviationLocal")
    private String abbreviationLocal;
    @JsonProperty("description")
    private Object description;
    @JsonProperty("descriptionLocal")
    private String descriptionLocal;
    @JsonProperty("language")
    private Language language;
    @JsonProperty("countries")
    private List<Country> countries;
    @JsonProperty("type")
    private String type;
    @JsonProperty("updatedAt")
    private String updatedAt;
    @JsonProperty("audioBibles")
    private List<Object> audioBibles;

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("dblId")
    public String getDblId() {
        return dblId;
    }

    @JsonProperty("dblId")
    public void setDblId(String dblId) {
        this.dblId = dblId;
    }

    @JsonProperty("relatedDbl")
    public Object getRelatedDbl() {
        return relatedDbl;
    }

    @JsonProperty("relatedDbl")
    public void setRelatedDbl(Object relatedDbl) {
        this.relatedDbl = relatedDbl;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("nameLocal")
    public String getNameLocal() {
        return nameLocal;
    }

    @JsonProperty("nameLocal")
    public void setNameLocal(String nameLocal) {
        this.nameLocal = nameLocal;
    }

    @JsonProperty("abbreviation")
    public String getAbbreviation() {
        return abbreviation;
    }

    @JsonProperty("abbreviation")
    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    @JsonProperty("abbreviationLocal")
    public String getAbbreviationLocal() {
        return abbreviationLocal;
    }

    @JsonProperty("abbreviationLocal")
    public void setAbbreviationLocal(String abbreviationLocal) {
        this.abbreviationLocal = abbreviationLocal;
    }

    @JsonProperty("description")
    public Object getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(Object description) {
        this.description = description;
    }

    @JsonProperty("descriptionLocal")
    public String getDescriptionLocal() {
        return descriptionLocal;
    }

    @JsonProperty("descriptionLocal")
    public void setDescriptionLocal(String descriptionLocal) {
        this.descriptionLocal = descriptionLocal;
    }

    @JsonProperty("language")
    public Language getLanguage() {
        return language;
    }

    @JsonProperty("language")
    public void setLanguage(Language language) {
        this.language = language;
    }

    @JsonProperty("countries")
    public List<Country> getCountries() {
        return countries;
    }

    @JsonProperty("countries")
    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("updatedAt")
    public String getUpdatedAt() {
        return updatedAt;
    }

    @JsonProperty("updatedAt")
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    @JsonProperty("audioBibles")
    public List<Object> getAudioBibles() {
        return audioBibles;
    }

    @JsonProperty("audioBibles")
    public void setAudioBibles(List<Object> audioBibles) {
        this.audioBibles = audioBibles;
    }

}

