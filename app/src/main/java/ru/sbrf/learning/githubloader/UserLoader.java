package ru.sbrf.learning.githubloader;

import android.content.AsyncTaskLoader;
import android.content.Context;

/**
 * Created by User25 on 23.05.2017.
 */

public class UserLoader extends AsyncTaskLoader<GithubUser> {

    private GithubUser cachedUser;
    public final String username;

    public UserLoader(Context context, String username) {
        super(context);
        this.username=username;
    }

    @Override
    public GithubUser loadInBackground() {
        GithubUser user  = DownloadInfo.downloadUserInfo(username);
        return user;
    }

    @Override
    public void deliverResult(GithubUser data) {
        super.deliverResult(data);
        cachedUser = data;
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        //if(cachedUser==null)
          forceLoad();
    }
}
