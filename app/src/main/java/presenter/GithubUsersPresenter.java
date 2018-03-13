package presenter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.andeladeveloper.githuberr.MainActivity;
import com.example.andeladeveloper.githuberr.MyAdapter;
import com.example.andeladeveloper.githuberr.R;

import java.io.InterruptedIOException;
import java.util.List;

import model.GithubUsers;
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
    Context context;
    public GithubUsersPresenter (Context context) {
        this.context = context;
        if (githubService == null) {
            githubService = new GithubService();
        }
    }

    public void getGithubers(final RecyclerView recyclerView) {
        githubService
                .getApi()
                .getGithubUsers()
                .enqueue(new Callback<GithubUsersResponse>() {
                    @Override
                    public void onResponse(Call<GithubUsersResponse> call, Response<GithubUsersResponse> response) {
                        GithubUsersResponse githubUsersResponse = response.body();
                        Log.d(TAG, "onResponse: " + githubUsersResponse);
                        if (githubUsersResponse != null && githubUsersResponse.getGithubUsers() != null) {
                            List<GithubUsers> users = githubUsersResponse.getGithubUsers();

                            recyclerView.setHasFixedSize(true);
                            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context);
                            recyclerView.setLayoutManager(mLayoutManager);
                            MyAdapter adapter = new MyAdapter(users, context);
                            recyclerView.setAdapter(adapter);
                        }
                    }

                    @Override
                    public void onFailure(Call<GithubUsersResponse> call, Throwable t) {
                        try {
                            throw new InterruptedException("Something went wrong");
                            // Do other stuff here
                        }
                        catch (InterruptedException e) {
                            e.printStackTrace();
                            // Do other stuff
                        }
                    }
                });
    }
}
