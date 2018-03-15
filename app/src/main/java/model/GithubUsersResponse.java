package model;


import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Fred Adewole on 12/03/2018.
 */

public class GithubUsersResponse {
    List<GithubUsers> users;

    public GithubUsersResponse () {
        users = new ArrayList<GithubUsers>();
    }
}
