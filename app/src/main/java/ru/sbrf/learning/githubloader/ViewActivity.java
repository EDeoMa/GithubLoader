package ru.sbrf.learning.githubloader;

import android.app.Activity;
import android.app.LoaderManager;
import android.app.ProgressDialog;
import android.content.Loader;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewActivity extends Activity {

    ImageView iconView;
    TextView username, fullname, url, repos, stars, followers, following;
    private String receivedUsername;
    private static final int LOADER_ID = 1;

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
        getLoaderManager().initLoader(LOADER_ID, null, new UserLoaderCallbacks());
    }

    private class UserLoaderCallbacks implements LoaderManager.LoaderCallbacks<GithubUser>{

        ProgressDialog progressDialog = new ProgressDialog(ViewActivity.this);

        @Override
        public Loader<GithubUser> onCreateLoader(int id, Bundle args) {
            progressDialog.setTitle("Loading...");
            progressDialog.setMessage("Wait for information to download");
            progressDialog.setCancelable(false);
            progressDialog.show();
            return new UserLoader(ViewActivity.this, receivedUsername);
        }

        @Override
        public void onLoadFinished(Loader<GithubUser> loader, GithubUser data) {
            username.setText(data.getUsername());
            fullname.setText(data.getFullname());
            url.setText(data.getRepoUrl());
            repos.setText(Integer.toString(data.getRepos()));
            stars.setText(Integer.toString(data.getStars()));
            followers.setText(Integer.toString(data.getFollowers()));
            following.setText(Integer.toString(data.getFollowing()));
            iconView.setImageDrawable(data.getIcon());
            progressDialog.dismiss();
        }


        @Override
        public void onLoaderReset(Loader<GithubUser> loader) {

        }
    }
}
