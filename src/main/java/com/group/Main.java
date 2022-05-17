package com.group;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;
import static spark.Spark.staticFileLocation;


public class Main {
    public static void main(String[] args) {
        port(5431);
        staticFileLocation("/public");

        Map<String, Object> model = new HashMap<String, Object>();

        get("/login", (request, response) -> {
            return new ModelAndView(model, "login.hbs");
        }, new HandlebarsTemplateEngine());

        get("/signup", (request, response) -> {
            return new ModelAndView(model, "signup.hbs");
        }, new HandlebarsTemplateEngine());

        get("/profile/", (request, response) -> {
            return new ModelAndView(model, "profile.hbs");
        }, new HandlebarsTemplateEngine());

        get("/profiledetails", (request, response) -> {
            return new ModelAndView(model, "profdetails.hbs");
        }, new HandlebarsTemplateEngine());
    }
}