package com.project.functional.u9_designpatternsinfunctional.s56_strategy;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Stock {

    private String symbol;
    private double price;
    private double units;

}
