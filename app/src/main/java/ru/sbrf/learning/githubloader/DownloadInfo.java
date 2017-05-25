package ru.sbrf.learning.githubloader;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by User25 on 23.05.2017.
 */

public class DownloadInfo {

    public static GithubUser downloadUserInfo(String username){
        GithubUser returnedUser = new GithubUser();
        String result;
        InputStream inputStream = null;
        try {
            URL url = new URL("https://api.github.com/users/"+username);
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            connection.connect();
            /*GithubUser result = serializer.read(CurrenciesList.class,
                    new BufferedReader(new InputStreamReader(connection.getInputStream(),
                            Charset.forName("windows-1251"))));
            */
            inputStream = connection.getInputStream();
            BufferedReader bReader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"), 8);
            StringBuilder sBuilder = new StringBuilder();
            String line = null;

            while((line = bReader.readLine())!=null){
                sBuilder.append(line);
            }
            result = sBuilder.toString();
            inputStream.close();
            JSONObject object = new JSONObject(result);
            if(object.has("message")){
                return null;
            }
            else {
                returnedUser.setFollowers(((int) object.get("followers")));
                returnedUser.setFollowing(((int) object.get("following")));
                returnedUser.setRepos(((int) object.get("public_repos")));
                returnedUser.setFullname((object.get("name")).toString());
                returnedUser.setRepoUrl((object.get("url").toString()));
                returnedUser.setStars(((int) object.get("public_gists")));
                returnedUser.setUsername((object.get("login")).toString());
                URL imageURL = new URL(object.getString("avatar_url"));
                Bitmap bmp = BitmapFactory.decodeStream(imageURL.openStream());
                returnedUser.setIcon(new BitmapDrawable(bmp));
            }
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return returnedUser;
    }
}