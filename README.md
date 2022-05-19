# Auction Center 
By Violet Auko,Chacha John, Brian Omondi, Drucilla Mumba and Ymelda Monari



## Table of contents
+ [Description](#Description)
+ [Project resources](#project-resources)
+ [Setup/Installation Requirements](#setupinstallation-requirements)
+ [Technologies used](#technologies-used)
+ [Contact Information](#contact-information)
+ [Copyright and License](#copyright-and-license-information)


## Description
This is an auction website where a user can bid and auction items.
## Project resources
The following is a live-link to the project's site

Link : `https://auction.soloo.me`


## Setup/Installation Requirements
#### To recreate database:

1.Launch postgres.
2.Run psql
3.CREATE DATABASE auction;
- \c auction
- CREATE TABLE bids(id SERIAL PRIMARY KEY, auctionitem INTEGER, biddername TEXT, userid INTEGER, bidamount INTEGER, biddate TIMESTAMP default CURRENT_TIMESTAMP, status BOOLEAN);
- CREATE TABLE users(id SERIAL PRIMARY KEY, email VARCHAR(255), fullname TEXT, password VARCHAR(255));
- CREATE TABLE auctions(id SERIAL PRIMARY KEY, createdby INTEGER, itemname TEXT, imageurl VARCHAR(255), baseprice INTEGER, description TEXT, createdat TIMESTAMP default CURRENT_TIMESTAMP);


#### To clone the repository:
- Clone this repository using:
  git clone 'https://github.com/ynyanchoka/auction'
- Navigate to the directory:
  cd auction
- Open the directory with your preferred text editor.

## Technologies used
+ IntelliJ IDEA
+ Java
+ Maven
+ Heroku
+ Postgres
+ Javascript




## Contact information
+ Ymelda Monari : `monaryymelda@gmail.com`
+ Drucilla Mumba : `drusademumba@gmail.com`
+ Violet Auko:`violetauko@gmail.com`
+ Brian Omondi:`brian.omondi@student.moringaschool.com`
+ Chacha John:`chacha.john@student.moringaschool.com`

## Copyright and license information

Copyright (c) 2022 [click here to view license](LICENSE)