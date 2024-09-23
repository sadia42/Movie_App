package com.example.myapp;

public class Movies {

    private String name,year,genre,rated;

    public Movies(String name,String year,String genre,String rated)
    {
        this.name=name;
        this.year=year;
        this.genre=genre;
        this.rated=rated;


    }
    public Movies()
    {

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
    public String getRated() {
        return rated;
    }

    public void setRated(String rated) {
        this.rated = rated;
    }


}
