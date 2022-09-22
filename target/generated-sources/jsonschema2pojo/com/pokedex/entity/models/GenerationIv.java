
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
    "diamond-pearl",
    "heartgold-soulsilver",
    "platinum"
})
public class GenerationIv {

    @JsonProperty("diamond-pearl")
    private DiamondPearl diamondPearl;
    @JsonProperty("heartgold-soulsilver")
    private HeartgoldSoulsilver heartgoldSoulsilver;
    @JsonProperty("platinum")
    private Platinum platinum;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("diamond-pearl")
    public DiamondPearl getDiamondPearl() {
        return diamondPearl;
    }

    @JsonProperty("diamond-pearl")
    public void setDiamondPearl(DiamondPearl diamondPearl) {
        this.diamondPearl = diamondPearl;
    }

    @JsonProperty("heartgold-soulsilver")
    public HeartgoldSoulsilver getHeartgoldSoulsilver() {
        return heartgoldSoulsilver;
    }

    @JsonProperty("heartgold-soulsilver")
    public void setHeartgoldSoulsilver(HeartgoldSoulsilver heartgoldSoulsilver) {
        this.heartgoldSoulsilver = heartgoldSoulsilver;
    }

    @JsonProperty("platinum")
    public Platinum getPlatinum() {
        return platinum;
    }

    @JsonProperty("platinum")
    public void setPlatinum(Platinum platinum) {
        this.platinum = platinum;
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
        sb.append(GenerationIv.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("diamondPearl");
        sb.append('=');
        sb.append(((this.diamondPearl == null)?"<null>":this.diamondPearl));
        sb.append(',');
        sb.append("heartgoldSoulsilver");
        sb.append('=');
        sb.append(((this.heartgoldSoulsilver == null)?"<null>":this.heartgoldSoulsilver));
        sb.append(',');
        sb.append("platinum");
        sb.append('=');
        sb.append(((this.platinum == null)?"<null>":this.platinum));
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
        result = ((result* 31)+((this.platinum == null)? 0 :this.platinum.hashCode()));
        result = ((result* 31)+((this.heartgoldSoulsilver == null)? 0 :this.heartgoldSoulsilver.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.diamondPearl == null)? 0 :this.diamondPearl.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof GenerationIv) == false) {
            return false;
        }
        GenerationIv rhs = ((GenerationIv) other);
        return (((((this.platinum == rhs.platinum)||((this.platinum!= null)&&this.platinum.equals(rhs.platinum)))&&((this.heartgoldSoulsilver == rhs.heartgoldSoulsilver)||((this.heartgoldSoulsilver!= null)&&this.heartgoldSoulsilver.equals(rhs.heartgoldSoulsilver))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.diamondPearl == rhs.diamondPearl)||((this.diamondPearl!= null)&&this.diamondPearl.equals(rhs.diamondPearl))));
    }

}
