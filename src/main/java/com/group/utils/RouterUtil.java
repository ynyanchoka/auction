package com.group.utils;

import com.group.models.Users;
import spark.Request;
import spark.Response;
import spark.utils.IOUtils;

import javax.servlet.MultipartConfigElement;
import javax.servlet.http.Part;
import java.io.InputStream;
import java.io.OutputStream;

import static spark.Spark.halt;

public class RouterUtil {
    protected static void checkLogin(Request req, Response res) {
        if (req.session().attribute("user") == null) {
            res.redirect("/login");
            halt();
        }
        Users user = req.session().attribute("user");
        user.setCurrentUser(user);
    }

    protected static String uploadFile(Request req) {
        try {
            req.attribute("org.eclipse.jetty.multipartConfig", new MultipartConfigElement("/temp"));
            Part filePart = req.raw().getPart("file");
            InputStream inputStream = filePart.getInputStream();
            OutputStream outputStream = new java.io.FileOutputStream("/temp/" + filePart.getName());
            IOUtils.copy(inputStream, outputStream);
            inputStream.close();
            return "/temp/" + filePart.getName();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error uploading file");
        }
    }
}
