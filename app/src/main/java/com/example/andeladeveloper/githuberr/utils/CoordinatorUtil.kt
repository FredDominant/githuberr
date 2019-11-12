package com.example.andeladeveloper.githuberr.utils

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class CoordinatorUtil {

    companion object {
        fun switchFragmentScreens(activity: AppCompatActivity, fragment: Fragment, containerId: Int) {
            val fragmentManager = activity.supportFragmentManager
            val isBackStackEmpty = fragmentManager.backStackEntryCount == 0
            fragmentManager.beginTransaction().also {
                if (isBackStackEmpty) {
                    it.add(containerId, fragment)
                } else {
                    it.replace(containerId, fragment)
                }
                it.addToBackStack(null)
                it.commit()
            }
        }
    }
}