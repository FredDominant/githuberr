package com.example.andeladeveloper.githuberr.presenter;

import android.content.Context;
import com.example.andeladeveloper.githuberr.service.GithubService;

/**
 * Created by andeladeveloper on 12/03/2018.
 */
public class GithubUsersPresenter {
    /**
     * The Github service.
     */
    GithubService githubService;
    /**
     * The Context.
     */
    Context context;

    /**
     * Instantiates a new Github users presenter.
     *
     * @param context the context
     */
    public GithubUsersPresenter(Context context) {
        this.context = context;
        if (githubService == null) {
            githubService = new GithubService();
        }
    }

//    public void getGithubers(final RecyclerView recyclerView) {
//        githubService
//                .getApi()
//                .getAllGithubJavaUsers() // to access the Nairobi users api
//                .enqueue(new Callback<GithubUsersResponse>() {
//                    @Override
//                    public void onResponse(Call<GithubUsersResponse> call,
// Response<GithubUsersResponse> response) {
//                        GithubUsersResponse githubUsersResponse = response.body();
//                        if (githubUsersResponse != null
// && githubUsersResponse.getGithubUsers() != null) {
//                            users = githubUsersResponse.getGithubUsers();
//
//                            recyclerView.setHasFixedSize(true);
//                            RecyclerView.LayoutManager mLayoutManager =
// new LinearLayoutManager(context);
//                            recyclerView.setLayoutManager(mLayoutManager);
//                            GithubAdapter adapter = new GithubAdapter(users, context);
//                            recyclerView.setAdapter(adapter);
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<GithubUsersResponse> call, Throwable t) {
//                        try {
//                            users = null;
//                            throw new InterruptedException("Something went wrong");
//                            // Do other stuff here
//                        }
//                        catch (InterruptedException e) {
//                            e.printStackTrace();
//                            // Do other stuff
//                        }
//                    }
//                });
//    }

}
