package com.group.utils;

import spark.Request;
import spark.Response;

import static spark.Spark.halt;

public class RouterUtil {
    protected static  void checkLogin(Request req, Response res) {
        if (req.session().attribute("user") == null) {
            res.redirect("/login");
            halt();
        }
    }
}
