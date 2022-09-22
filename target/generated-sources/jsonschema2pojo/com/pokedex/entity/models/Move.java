
package com.pokedex.entity.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "move",
    "version_group_details"
})
public class Move {

    @JsonProperty("move")
    private Move__1 move;
    @JsonProperty("version_group_details")
    private List<VersionGroupDetail> versionGroupDetails = new ArrayList<VersionGroupDetail>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("move")
    public Move__1 getMove() {
        return move;
    }

    @JsonProperty("move")
    public void setMove(Move__1 move) {
        this.move = move;
    }

    @JsonProperty("version_group_details")
    public List<VersionGroupDetail> getVersionGroupDetails() {
        return versionGroupDetails;
    }

    @JsonProperty("version_group_details")
    public void setVersionGroupDetails(List<VersionGroupDetail> versionGroupDetails) {
        this.versionGroupDetails = versionGroupDetails;
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
        sb.append(Move.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("move");
        sb.append('=');
        sb.append(((this.move == null)?"<null>":this.move));
        sb.append(',');
        sb.append("versionGroupDetails");
        sb.append('=');
        sb.append(((this.versionGroupDetails == null)?"<null>":this.versionGroupDetails));
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
        result = ((result* 31)+((this.move == null)? 0 :this.move.hashCode()));
        result = ((result* 31)+((this.versionGroupDetails == null)? 0 :this.versionGroupDetails.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Move) == false) {
            return false;
        }
        Move rhs = ((Move) other);
        return ((((this.move == rhs.move)||((this.move!= null)&&this.move.equals(rhs.move)))&&((this.versionGroupDetails == rhs.versionGroupDetails)||((this.versionGroupDetails!= null)&&this.versionGroupDetails.equals(rhs.versionGroupDetails))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))));
    }

}
