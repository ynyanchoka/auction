package com.group.utils;

import com.group.dao.AuctionDao;
import com.group.dao.BidDao;
import com.group.dao.UserDao;
import com.group.interfaces.IAuction;
import com.group.interfaces.IBid;
import com.group.models.Auctions;
import com.group.models.Bids;
import com.group.models.Users;
import org.sql2o.Connection;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.group.utils.MD5Util.md5Hex;
import static spark.Spark.*;
import static spark.SparkBase.staticFileLocation;

public class Router extends RouterUtil {
    public static void run(Connection connection) {
        staticFileLocation("/public");
        port(8085);


        get("/", (req, res) -> {
            checkLogin(req, res);
            IAuction auctionDao = new AuctionDao();
            List<Auctions> auctions = auctionDao.getAllItems(connection);
            Map<String, Object> model = new HashMap<>();

            model.put("auctions", auctions);
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/login", (req, res) -> {
            return new ModelAndView(null, "login.hbs");
        }, new HandlebarsTemplateEngine());

        get("/register", (req, res) -> {
            return new ModelAndView(null, "login.hbs");/*edit*/
        }, new HandlebarsTemplateEngine());

        get("/logout", (req, res) -> {
            req.session().removeAttribute("user");
            res.redirect("/login");
            return "";
        });


        get("/profile", (req, res) -> {
            checkLogin(req, res);
            Users user = req.session().attribute("user");
            IAuction auctionDao = new AuctionDao();
            List<Auctions> auctions = auctionDao.getUsersAuctionItems(connection, user.getId());
            Map<String, Object> model = new HashMap<>();
            String hash = md5Hex(user.getEmail());
            model.put("auctions", auctions);
            model.put("user", user);
            model.put("image", "https://www.gravatar.com/avatar/"+hash);
            return new ModelAndView(model, "profile.hbs");
        }, new HandlebarsTemplateEngine());

        get("/auction/:id", (req, res) -> {
            checkLogin(req, res);
            IAuction auctionDao = new AuctionDao();
            IBid bidDao = new BidDao();
            List<Auctions> allAuctions = auctionDao.getAllItems(connection);
            Auctions auction = auctionDao.getItemById(connection, Integer.parseInt(req.params("id")));
            List<Bids> bids = bidDao.getBidsByAuctionId(connection, Integer.parseInt(req.params("id")));
            Map<String, Object> model = new HashMap<>();
            System.out.println(bids.size());
            boolean isMe = auction.getCreatedBy() == Users.getCurrentUser().getId();
            model.put("auction", auction);
            model.put("auctions", allAuctions);
            model.put("bids", bids);
            model.put("isMe", isMe);
            model.put("bidCount", bids.size());

            return new ModelAndView(model, "auction-item.hbs");
        }, new HandlebarsTemplateEngine());

        get("/about", (req, res) -> {
            return new ModelAndView(null, "about.hbs");
        }, new HandlebarsTemplateEngine());

        post("/auction/:id/bid", (req, res) -> {
            checkLogin(req, res);
            Users user = Users.getCurrentUser();
            int auctionId = Integer.parseInt(req.params("id"));
            // Get Bid amount
            int amount = Integer.parseInt(req.queryParams("bidAmount"));
            Bids bid = new Bids(user.getId(), user.getFullName(), auctionId, amount, false);
            new BidDao().createBid(connection, bid);
            res.redirect("/auction/" + auctionId);
            return null;
        });

        patch("/auction/:id/bid/:bid", (req, res) -> {
            checkLogin(req, res);
            int bidId = Integer.parseInt(req.params("bid"));
            new BidDao().updateBid(connection, bidId, true);
            res.redirect("/auction/" + req.params("id"));
            return null;
        });

        delete("/auction/:id/bid/:bid", (req, res) -> {
            checkLogin(req, res);
            int bidId = Integer.parseInt(req.params("bid"));
            new BidDao().deleteBid(connection, bidId);
            res.redirect("/auction/" + req.params("id"));
            return null;
        }, new HandlebarsTemplateEngine());

        delete("/auction/:id/", (req, res) -> {
            checkLogin(req, res);
            int auctionId = Integer.parseInt(req.params("id"));
            new AuctionDao().deleteAuctionItem(connection, auctionId);
            res.redirect("/profile");
            return null;
        }, new HandlebarsTemplateEngine());

        post("/register", (req, res) -> {
            String fullName = req.queryParams("fullName");
            String email = req.queryParams("email");
            String password = req.queryParams("password");
            Users user = new Users(email, fullName, password);
            new UserDao().createUser(connection, user);
            return new ModelAndView(null, "login.hbs");
        }, new HandlebarsTemplateEngine());

        post("/login", (req, res) -> {
            String email = req.queryParams("email");
            String password = req.queryParams("password");
            Users user = new UserDao().loginUser(connection, email, password);
            if (user != null) {
                req.session().attribute("user", user);
                res.redirect("/");
            } else {
                res.redirect("/login");
            }
            return new ModelAndView(null, "login.hbs");
        }, new HandlebarsTemplateEngine());

        post("/auction", (req, res) -> {
            checkLogin(req, res);
            Users user = Users.getCurrentUser();
            String title = req.queryParams("name");
            String description = req.queryParams("description");
            int startingBid = Integer.parseInt(req.queryParams("price"));
            //Upload image
            String url = "https://picsum.photos/200/300";
            Auctions auction = new Auctions(user.getId(), title, url, startingBid, description);
            new AuctionDao().createItem(connection, auction);
            res.redirect("/");
            return null;
        });

    }
}
