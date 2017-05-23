package ru.sbrf.learning.githubloader;

import android.app.Activity;
import android.app.LoaderManager;
import android.content.Loader;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewActivity extends Activity {

    ImageView iconView;
    TextView username, fullname, url, repos, stars, followers, following;
    private String receivedUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watch);
        receivedUsername = getIntent().getStringExtra(getString(R.string.passed_string));
        iconView = (ImageView) findViewById(R.id.avatar);
        username = (TextView) findViewById(R.id.username);
        fullname = (TextView) findViewById(R.id.user_fullname);
        url = (TextView) findViewById(R.id.repo_url);
        repos = (TextView) findViewById(R.id.pub_repos_count);
        stars = (TextView) findViewById(R.id.pub_gists_count);
        followers = (TextView) findViewById(R.id.followers_count);
        following = (TextView) findViewById(R.id.following_count);
    }

    private class UserLoaderCallbacks implements LoaderManager.LoaderCallbacks<GithubUser>{

        @Override
        public Loader<GithubUser> onCreateLoader(int id, Bundle args) {
            return new UserLoader(ViewActivity.this);
        }

        @Override
        public void onLoadFinished(Loader<GithubUser> loader, GithubUser data) {

        }

        @Override
        public void onLoaderReset(Loader<GithubUser> loader) {

        }
    }
}
