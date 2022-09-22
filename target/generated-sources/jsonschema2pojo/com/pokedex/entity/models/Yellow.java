
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
    "back_default",
    "back_gray",
    "back_transparent",
    "front_default",
    "front_gray",
    "front_transparent"
})
public class Yellow {

    @JsonProperty("back_default")
    private String backDefault;
    @JsonProperty("back_gray")
    private String backGray;
    @JsonProperty("back_transparent")
    private String backTransparent;
    @JsonProperty("front_default")
    private String frontDefault;
    @JsonProperty("front_gray")
    private String frontGray;
    @JsonProperty("front_transparent")
    private String frontTransparent;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("back_default")
    public String getBackDefault() {
        return backDefault;
    }

    @JsonProperty("back_default")
    public void setBackDefault(String backDefault) {
        this.backDefault = backDefault;
    }

    @JsonProperty("back_gray")
    public String getBackGray() {
        return backGray;
    }

    @JsonProperty("back_gray")
    public void setBackGray(String backGray) {
        this.backGray = backGray;
    }

    @JsonProperty("back_transparent")
    public String getBackTransparent() {
        return backTransparent;
    }

    @JsonProperty("back_transparent")
    public void setBackTransparent(String backTransparent) {
        this.backTransparent = backTransparent;
    }

    @JsonProperty("front_default")
    public String getFrontDefault() {
        return frontDefault;
    }

    @JsonProperty("front_default")
    public void setFrontDefault(String frontDefault) {
        this.frontDefault = frontDefault;
    }

    @JsonProperty("front_gray")
    public String getFrontGray() {
        return frontGray;
    }

    @JsonProperty("front_gray")
    public void setFrontGray(String frontGray) {
        this.frontGray = frontGray;
    }

    @JsonProperty("front_transparent")
    public String getFrontTransparent() {
        return frontTransparent;
    }

    @JsonProperty("front_transparent")
    public void setFrontTransparent(String frontTransparent) {
        this.frontTransparent = frontTransparent;
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
        sb.append(Yellow.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("backDefault");
        sb.append('=');
        sb.append(((this.backDefault == null)?"<null>":this.backDefault));
        sb.append(',');
        sb.append("backGray");
        sb.append('=');
        sb.append(((this.backGray == null)?"<null>":this.backGray));
        sb.append(',');
        sb.append("backTransparent");
        sb.append('=');
        sb.append(((this.backTransparent == null)?"<null>":this.backTransparent));
        sb.append(',');
        sb.append("frontDefault");
        sb.append('=');
        sb.append(((this.frontDefault == null)?"<null>":this.frontDefault));
        sb.append(',');
        sb.append("frontGray");
        sb.append('=');
        sb.append(((this.frontGray == null)?"<null>":this.frontGray));
        sb.append(',');
        sb.append("frontTransparent");
        sb.append('=');
        sb.append(((this.frontTransparent == null)?"<null>":this.frontTransparent));
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
        result = ((result* 31)+((this.backTransparent == null)? 0 :this.backTransparent.hashCode()));
        result = ((result* 31)+((this.frontTransparent == null)? 0 :this.frontTransparent.hashCode()));
        result = ((result* 31)+((this.backDefault == null)? 0 :this.backDefault.hashCode()));
        result = ((result* 31)+((this.frontDefault == null)? 0 :this.frontDefault.hashCode()));
        result = ((result* 31)+((this.frontGray == null)? 0 :this.frontGray.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.backGray == null)? 0 :this.backGray.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Yellow) == false) {
            return false;
        }
        Yellow rhs = ((Yellow) other);
        return ((((((((this.backTransparent == rhs.backTransparent)||((this.backTransparent!= null)&&this.backTransparent.equals(rhs.backTransparent)))&&((this.frontTransparent == rhs.frontTransparent)||((this.frontTransparent!= null)&&this.frontTransparent.equals(rhs.frontTransparent))))&&((this.backDefault == rhs.backDefault)||((this.backDefault!= null)&&this.backDefault.equals(rhs.backDefault))))&&((this.frontDefault == rhs.frontDefault)||((this.frontDefault!= null)&&this.frontDefault.equals(rhs.frontDefault))))&&((this.frontGray == rhs.frontGray)||((this.frontGray!= null)&&this.frontGray.equals(rhs.frontGray))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.backGray == rhs.backGray)||((this.backGray!= null)&&this.backGray.equals(rhs.backGray))));
    }

}
