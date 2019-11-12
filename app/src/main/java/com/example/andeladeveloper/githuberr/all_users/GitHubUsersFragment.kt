package com.example.andeladeveloper.githuberr.all_users


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.andeladeveloper.githuberr.GithubAdapter

import com.example.andeladeveloper.githuberr.R
import com.example.andeladeveloper.githuberr.model.GithubUser
import com.example.andeladeveloper.githuberr.selected_user.SelectedUserFragment
import com.example.andeladeveloper.githuberr.utils.CoordinatorUtil
import com.example.andeladeveloper.githuberr.GithubUserListener

/**
 * A simple [Fragment] subclass.
 */
class GitHubUsersFragment : Fragment(), GithubUserListener, SwipeRefreshLayout.OnRefreshListener {

    private lateinit var viewModel: MainViewModel
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout
    private lateinit var recyclerView: RecyclerView
    private val threadLocal = ThreadLocal<GithubAdapter>()
    private lateinit var adapter: GithubAdapter

    companion object {
        @JvmStatic fun newInstance() : GitHubUsersFragment {
            return GitHubUsersFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.activity?.let {
            viewModel = ViewModelProviders.of(it)[MainViewModel::class.java]
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_git_hub_users, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.setupViews(view)
    }

    private fun setupViews(view: View) {
        this.swipeRefreshLayout = view.findViewById(R.id.swiperefresh)
        this.swipeRefreshLayout.setOnRefreshListener(this)

        this.recyclerView = view.findViewById(R.id.recyclerView)
        this.setUpAdapter()
        this.registerObserver()
    }

    override fun onRefresh() {
        this.registerObserver()
    }

    private fun setUpAdapter() {
        this.adapter = GithubAdapter(this)
        this.activity?.let { activity ->
            val layoutManager = LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false)
            this.recyclerView.also {
                it.layoutManager = layoutManager
                this.adapter.also { adapter -> this.threadLocal.set(adapter) }
                it.adapter = this.adapter
            }
        }
    }

    private fun registerObserver() {
        this.viewModel.getAllUsers().observe(this, Observer<ArrayList<GithubUser>> {
            this.swipeRefreshLayout.isRefreshing = false
            if (!it.isNullOrEmpty()) {
                Log.e("Size issss", "${it.size}")
                this.adapter.updateUser(it)
            }
        })
    }

    override fun onGithubUserClicked(githubUser: GithubUser) {
        this.activity?.let {
            val activity = it as AppCompatActivity
            Bundle().apply {
                this.putParcelable("user", githubUser)
            }.also { bundle ->
                SelectedUserFragment.newInstance(bundle).also { fragment ->
                    CoordinatorUtil.switchFragmentScreens(activity, fragment , R.id.fragmentContainer)
                }
            }
        }
    }

}
