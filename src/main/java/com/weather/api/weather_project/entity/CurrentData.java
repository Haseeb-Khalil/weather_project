package com.weather.api.weather_project.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CurrentData {
    private double temp_c;
    private ConditionData condition;

    public double getTempC() {
        return temp_c;
    }

    public void setTempC(double tempC) {
        this.temp_c = tempC;
    }

    public ConditionData getCondition() {
        return condition;
    }

    public void setCondition(ConditionData condition) {
        this.condition = condition;
    }
}
