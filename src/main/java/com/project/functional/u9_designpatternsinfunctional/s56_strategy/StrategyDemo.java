package com.project.functional.u9_designpatternsinfunctional.s56_strategy;

import java.util.ArrayList;
import java.util.List;

public class StrategyDemo {

    // Used when we have multiple solution or algorithms to
    // ... solve a specific task and client decides the specific
    // ... implementation which is to be used at runtime.

    public static void main(String[] args) {
        List<Stock> stockList = new ArrayList<>();
        stockList.add(new Stock("AAPL", 318.65, 10));
        stockList.add(new Stock("MSTF", 166.86, 45));
        stockList.add(new Stock("GOOGL", 99, 12.5));
        stockList.add(new Stock("AMZ", 1866.74, 45));
        stockList.add(new Stock("GOOGL", 1480.2, 3.5));
        stockList.add(new Stock("AAPL", 318.65, 8));
        stockList.add(new Stock("AMZ", 1866.74, 9));

        // We used to create different strategies / methods
        StockFilters.bySymbol(stockList, "AMZ").forEach(System.out::println);
        System.out.println("-------------------");
        StockFilters.byPriceAbove(stockList, 300).forEach(System.out::println);
        System.out.println("-------------------");

        // Now, we don't need to create functions, we just can pass lambdas
        StockFilters.filter(stockList, stock -> stock.getSymbol().equals("AMZ"))
                .forEach(System.out::println);

    }
}
