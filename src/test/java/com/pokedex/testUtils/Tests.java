package com.pokedex.testUtils;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@NoArgsConstructor
public class Tests {

    private List<Step> steps = new ArrayList<>();

    @Getter
    private String overallPlanId;

    @Getter
    private AbstractIT container;

    public static Tests create() {
        return new Tests();
    }

    public Tests overallPlanId(String overallPlanId) {
        this.overallPlanId = overallPlanId;
        return this;
    }

    public Tests step(Step step) {
        steps.add(step);
        return this;
    }

    public Tests steps(Step... steps) {
        this.steps.addAll(Arrays.asList(steps));
        return this;
    }

    @SneakyThrows
    public void exec(AbstractIT abstractFullMappingIntegrationTest) {
        this.container = abstractFullMappingIntegrationTest;
        int i = 0;
        for (Step step : steps) {
            i++;
            System.out.println(String.format("EXECUTING STEP %d: %s", i, step.getClass().getSimpleName()));
            step.exec(this);
            step.verify(this);
        }
    }

}
