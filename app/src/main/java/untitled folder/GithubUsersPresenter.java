package presenter;

import android.util.Log;
import android.view.View;

import com.example.andeladeveloper.githuberr.MainActivity;

import model.GithubUsersResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import service.GithubService;

import static android.content.ContentValues.TAG;

/**
 * Created by andeladeveloper on 12/03/2018.
 */

public class GithubUsersPresenter {
    GithubService githubService;
    public GithubUsersPresenter (MainActivity view) {
        if (githubService == null) {
            GithubService githubService = new GithubService();
        }
    }

    public void getGithubers() {
        githubService
                .getApi()
                .getGithubUsers()
                .enqueue(new Callback<GithubUsersResponse>() {
                    @Override
                    public void onResponse(Call<GithubUsersResponse> call, Response<GithubUsersResponse> response) {
                        GithubUsersResponse githubUsersResponse = response.body();
                        Log.d(TAG, "onResponse: " + githubUsersResponse);
                    }

                    @Override
                    public void onFailure(Call<GithubUsersResponse> call, Throwable t) {

                    }
                });
    }
}
