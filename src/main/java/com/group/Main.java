package com.group;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;
import static spark.SparkBase.staticFileLocation;

public class Main {
    public static void main(String[] args) {
        staticFileLocation("/public");
        //about
        get("/about", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(new HashMap(), "about.hbs");
        }, new HandlebarsTemplateEngine());

        //item page
        get("/item", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(new HashMap(), "about.hbs");
        }, new HandlebarsTemplateEngine());
    }

}