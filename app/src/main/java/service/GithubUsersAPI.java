package service;

import model.GithubUsersResponse;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Fred Adewole on 12/03/2018.
 */

public interface GithubUsersAPI {
    @GET("/search/users?q=location:nairobi+language:java&per_page=10")
    Call<GithubUsersResponse> getGithubUsers();
}
