
package com.pokedex.entity.models;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "crystal",
    "gold",
    "silver"
})
public class GenerationIi {

    @JsonProperty("crystal")
    private Crystal crystal;
    @JsonProperty("gold")
    private Gold gold;
    @JsonProperty("silver")
    private Silver silver;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("crystal")
    public Crystal getCrystal() {
        return crystal;
    }

    @JsonProperty("crystal")
    public void setCrystal(Crystal crystal) {
        this.crystal = crystal;
    }

    @JsonProperty("gold")
    public Gold getGold() {
        return gold;
    }

    @JsonProperty("gold")
    public void setGold(Gold gold) {
        this.gold = gold;
    }

    @JsonProperty("silver")
    public Silver getSilver() {
        return silver;
    }

    @JsonProperty("silver")
    public void setSilver(Silver silver) {
        this.silver = silver;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(GenerationIi.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("crystal");
        sb.append('=');
        sb.append(((this.crystal == null)?"<null>":this.crystal));
        sb.append(',');
        sb.append("gold");
        sb.append('=');
        sb.append(((this.gold == null)?"<null>":this.gold));
        sb.append(',');
        sb.append("silver");
        sb.append('=');
        sb.append(((this.silver == null)?"<null>":this.silver));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null)?"<null>":this.additionalProperties));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.gold == null)? 0 :this.gold.hashCode()));
        result = ((result* 31)+((this.silver == null)? 0 :this.silver.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.crystal == null)? 0 :this.crystal.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof GenerationIi) == false) {
            return false;
        }
        GenerationIi rhs = ((GenerationIi) other);
        return (((((this.gold == rhs.gold)||((this.gold!= null)&&this.gold.equals(rhs.gold)))&&((this.silver == rhs.silver)||((this.silver!= null)&&this.silver.equals(rhs.silver))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.crystal == rhs.crystal)||((this.crystal!= null)&&this.crystal.equals(rhs.crystal))));
    }

}
