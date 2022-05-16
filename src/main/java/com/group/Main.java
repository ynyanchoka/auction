package com.group;

import spark.ModelAndView;

import java.util.HashMap;
import java.util.Map;

import static spark.SparkBase.staticFileLocation;

public class Main {
    public static void main(String[] args) {
        staticFileLocation("/public");
    }
//    get("/about", (request, response) -> {
//        Map<String, Object> model = new HashMap<String, Object>();
//        return new ModelAndView(new HashMap(), "about.hbs");
//    }, new HandlebarsTemplateEngine());
}