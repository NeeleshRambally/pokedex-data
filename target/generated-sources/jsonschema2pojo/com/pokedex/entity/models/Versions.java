
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
    "generation-i",
    "generation-ii",
    "generation-iii",
    "generation-iv",
    "generation-v",
    "generation-vi",
    "generation-vii",
    "generation-viii"
})
public class Versions {

    @JsonProperty("generation-i")
    private GenerationI generationI;
    @JsonProperty("generation-ii")
    private GenerationIi generationIi;
    @JsonProperty("generation-iii")
    private GenerationIii generationIii;
    @JsonProperty("generation-iv")
    private GenerationIv generationIv;
    @JsonProperty("generation-v")
    private GenerationV generationV;
    @JsonProperty("generation-vi")
    private GenerationVi generationVi;
    @JsonProperty("generation-vii")
    private GenerationVii generationVii;
    @JsonProperty("generation-viii")
    private GenerationViii generationViii;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("generation-i")
    public GenerationI getGenerationI() {
        return generationI;
    }

    @JsonProperty("generation-i")
    public void setGenerationI(GenerationI generationI) {
        this.generationI = generationI;
    }

    @JsonProperty("generation-ii")
    public GenerationIi getGenerationIi() {
        return generationIi;
    }

    @JsonProperty("generation-ii")
    public void setGenerationIi(GenerationIi generationIi) {
        this.generationIi = generationIi;
    }

    @JsonProperty("generation-iii")
    public GenerationIii getGenerationIii() {
        return generationIii;
    }

    @JsonProperty("generation-iii")
    public void setGenerationIii(GenerationIii generationIii) {
        this.generationIii = generationIii;
    }

    @JsonProperty("generation-iv")
    public GenerationIv getGenerationIv() {
        return generationIv;
    }

    @JsonProperty("generation-iv")
    public void setGenerationIv(GenerationIv generationIv) {
        this.generationIv = generationIv;
    }

    @JsonProperty("generation-v")
    public GenerationV getGenerationV() {
        return generationV;
    }

    @JsonProperty("generation-v")
    public void setGenerationV(GenerationV generationV) {
        this.generationV = generationV;
    }

    @JsonProperty("generation-vi")
    public GenerationVi getGenerationVi() {
        return generationVi;
    }

    @JsonProperty("generation-vi")
    public void setGenerationVi(GenerationVi generationVi) {
        this.generationVi = generationVi;
    }

    @JsonProperty("generation-vii")
    public GenerationVii getGenerationVii() {
        return generationVii;
    }

    @JsonProperty("generation-vii")
    public void setGenerationVii(GenerationVii generationVii) {
        this.generationVii = generationVii;
    }

    @JsonProperty("generation-viii")
    public GenerationViii getGenerationViii() {
        return generationViii;
    }

    @JsonProperty("generation-viii")
    public void setGenerationViii(GenerationViii generationViii) {
        this.generationViii = generationViii;
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
        sb.append(Versions.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("generationI");
        sb.append('=');
        sb.append(((this.generationI == null)?"<null>":this.generationI));
        sb.append(',');
        sb.append("generationIi");
        sb.append('=');
        sb.append(((this.generationIi == null)?"<null>":this.generationIi));
        sb.append(',');
        sb.append("generationIii");
        sb.append('=');
        sb.append(((this.generationIii == null)?"<null>":this.generationIii));
        sb.append(',');
        sb.append("generationIv");
        sb.append('=');
        sb.append(((this.generationIv == null)?"<null>":this.generationIv));
        sb.append(',');
        sb.append("generationV");
        sb.append('=');
        sb.append(((this.generationV == null)?"<null>":this.generationV));
        sb.append(',');
        sb.append("generationVi");
        sb.append('=');
        sb.append(((this.generationVi == null)?"<null>":this.generationVi));
        sb.append(',');
        sb.append("generationVii");
        sb.append('=');
        sb.append(((this.generationVii == null)?"<null>":this.generationVii));
        sb.append(',');
        sb.append("generationViii");
        sb.append('=');
        sb.append(((this.generationViii == null)?"<null>":this.generationViii));
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
        result = ((result* 31)+((this.generationV == null)? 0 :this.generationV.hashCode()));
        result = ((result* 31)+((this.generationIii == null)? 0 :this.generationIii.hashCode()));
        result = ((result* 31)+((this.generationIv == null)? 0 :this.generationIv.hashCode()));
        result = ((result* 31)+((this.generationVii == null)? 0 :this.generationVii.hashCode()));
        result = ((result* 31)+((this.generationVi == null)? 0 :this.generationVi.hashCode()));
        result = ((result* 31)+((this.generationIi == null)? 0 :this.generationIi.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.generationViii == null)? 0 :this.generationViii.hashCode()));
        result = ((result* 31)+((this.generationI == null)? 0 :this.generationI.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Versions) == false) {
            return false;
        }
        Versions rhs = ((Versions) other);
        return ((((((((((this.generationV == rhs.generationV)||((this.generationV!= null)&&this.generationV.equals(rhs.generationV)))&&((this.generationIii == rhs.generationIii)||((this.generationIii!= null)&&this.generationIii.equals(rhs.generationIii))))&&((this.generationIv == rhs.generationIv)||((this.generationIv!= null)&&this.generationIv.equals(rhs.generationIv))))&&((this.generationVii == rhs.generationVii)||((this.generationVii!= null)&&this.generationVii.equals(rhs.generationVii))))&&((this.generationVi == rhs.generationVi)||((this.generationVi!= null)&&this.generationVi.equals(rhs.generationVi))))&&((this.generationIi == rhs.generationIi)||((this.generationIi!= null)&&this.generationIi.equals(rhs.generationIi))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.generationViii == rhs.generationViii)||((this.generationViii!= null)&&this.generationViii.equals(rhs.generationViii))))&&((this.generationI == rhs.generationI)||((this.generationI!= null)&&this.generationI.equals(rhs.generationI))));
    }

}
