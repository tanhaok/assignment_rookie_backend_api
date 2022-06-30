package com.assignment.backend.utils;

import java.util.Set;

import com.assignment.backend.data.entities.ProductRate;

public class Calculate {
    public static double rate(Set<ProductRate> listRate) {
        double result = 0.0;
        if (listRate.isEmpty()) {
            return 1.0;
        }

        // calculate average of rate
        result = 5.0;
        return result;
    }
}
