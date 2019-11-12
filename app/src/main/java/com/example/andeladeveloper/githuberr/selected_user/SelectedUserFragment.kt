package com.example.andeladeveloper.githuberr.selected_user


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.andeladeveloper.githuberr.R
import com.example.andeladeveloper.githuberr.all_users.MainViewModel
import com.example.andeladeveloper.githuberr.model.GithubUser
import com.squareup.picasso.Picasso

/**
 * A simple [Fragment] subclass.
 */
class SelectedUserFragment : Fragment() {

    private lateinit var viewModel: MainViewModel
//    private lateinit var userName: TextView
    private lateinit var userImage: ImageView

    companion object {
        @JvmStatic fun newInstance(bundle: Bundle): SelectedUserFragment {
            val fragment = SelectedUserFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.activity?.let {
            this.viewModel = ViewModelProviders.of(it)[MainViewModel::class.java]
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_selected_user, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.setUpViews(view)
    }

    private fun setUpViews(view: View) {
        this.userImage = view.findViewById(R.id.mainUserImage)
//        this.userName = view.findViewById(R.id.)
        this.arguments?.let { bundle ->
            val githubUser = bundle.getParcelable<GithubUser>("user")
            return@let githubUser.also {
                it?.let {
//                    this.userName.text = it.username
                    Picasso.get().load(it.avatar).into(this.userImage)
                }
            }


        }
    }

}
