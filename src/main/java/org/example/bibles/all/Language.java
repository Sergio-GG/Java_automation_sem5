package org.example.bibles.all;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "name",
        "nameLocal",
        "script",
        "scriptDirection"
})

public class Language {

    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("nameLocal")
    private String nameLocal;
    @JsonProperty("script")
    private String script;
    @JsonProperty("scriptDirection")
    private String scriptDirection;

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
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

    @JsonProperty("script")
    public String getScript() {
        return script;
    }

    @JsonProperty("script")
    public void setScript(String script) {
        this.script = script;
    }

    @JsonProperty("scriptDirection")
    public String getScriptDirection() {
        return scriptDirection;
    }

    @JsonProperty("scriptDirection")
    public void setScriptDirection(String scriptDirection) {
        this.scriptDirection = scriptDirection;
    }

}

