package com.right2vote.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class ClothingCombinationService {
	
public List<String> getCombinations(double budget) throws Exception {
    	
        Map<String, Double> prices = new HashMap<>();
        
        prices.put("T-shirt", 50.00);
        prices.put("Jeans", 80.00);
        prices.put("Jacket", 100.00);
        
        if (budget < 230) {
             throw new Exception("Your budget is insufficient !");
        }


        List<String> combinations = new ArrayList<>();
        
        int count=0;
        
        for (int tShirts = 1; tShirts * prices.get("T-shirt") <= budget; tShirts++) {
        	
            for (int jeans = 1; jeans * prices.get("Jeans") <= budget - tShirts * prices.get("T-shirt"); jeans++) {
            	
                double remainingBudget = budget - (tShirts * prices.get("T-shirt") + jeans * prices.get("Jeans"));
                
                double jacketPrice = prices.get("Jacket");

                if (remainingBudget >= jacketPrice) {
                	
                    int jackets = (int) (remainingBudget / jacketPrice);
                    
                    
                    double totalSpent = tShirts * prices.get("T-shirt") + jeans * prices.get("Jeans") + jackets * jacketPrice;
                    
                    double remainingMoney=budget- totalSpent;
                    
                    if (remainingMoney < 50) {
                    	count++;
                        combinations.add("Combination:"+ count +" ->"+" "+" "+" "+" "+"T-shirts = " + tShirts +" "+" "+" "+" "+"Jeans = " + jeans +" "+" "+" "+" "+"Jackets = " + jackets +" "+" "+" "+" "+ "RemainingBudget = "+"₹ " + remainingMoney);
                    }
                }
            }
        }

       
        for (String combo : combinations) {
        	
            System.out.println(combo);
        }
        
        System.out.println("Total valid combinations: " + combinations.size());

        return combinations;
    }

}
