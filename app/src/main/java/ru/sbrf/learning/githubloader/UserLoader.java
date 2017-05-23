package ru.sbrf.learning.githubloader;

import android.content.AsyncTaskLoader;
import android.content.Context;

/**
 * Created by User25 on 23.05.2017.
 */

public class UserLoader extends AsyncTaskLoader<GithubUser> {

    private GithubUser cachedUser;

    public UserLoader(Context context) {
        super(context);
    }

    @Override
    public GithubUser loadInBackground() {
        return null;
    }

    @Override
    public void deliverResult(GithubUser data) {
        super.deliverResult(data);
        cachedUser = data;
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        if(cachedUser==null)
          forceLoad();
    }
}
