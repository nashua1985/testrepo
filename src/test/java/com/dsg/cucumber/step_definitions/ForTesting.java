package com.dsg.cucumber.step_definitions;

public class ForTesting {
    public static void main(String[] args) {
            String text = "| 3 MI";
            String newText = text.replace("|", "");
            String asd[] = newText.split(" ");
            double dbl = Double.parseDouble(asd[1]);
        System.out.println(dbl);

    }
}
