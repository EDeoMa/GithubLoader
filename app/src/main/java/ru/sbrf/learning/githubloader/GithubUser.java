package ru.sbrf.learning.githubloader;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

/**
 * Created by User25 on 23.05.2017.
 */

public class GithubUser {
    private String username;
    private String fullname;
    private String repoUrl;
    private int followers;
    private int following;
    private int repos;
    private int stars;
    private Drawable icon;

    public GithubUser(){};

    public GithubUser(String username, String fullname, String repoUrl, int followers, int following, int repos, int stars, BitmapDrawable icon) {
        this.username = username;
        this.fullname = fullname;
        this.repoUrl = repoUrl;
        this.followers = followers;
        this.following = following;
        this.repos = repos;
        this.stars = stars;
        this.icon = icon;
    }

    public String getUsername() {
        return username;
    }

    public String getFullname() {
        return fullname;
    }

    public String getRepoUrl() {
        return repoUrl;
    }

    public int getFollowers() {
        return followers;
    }

    public int getFollowing() {
        return following;
    }

    public int getRepos() {
        return repos;
    }

    public int getStars() {
        return stars;
    }

    public Drawable getIcon() {
        return icon;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setRepoUrl(String repoUrl) {
        this.repoUrl = repoUrl;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public void setFollowing(int following) {
        this.following = following;
    }

    public void setRepos(int repos) {
        this.repos = repos;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }
}