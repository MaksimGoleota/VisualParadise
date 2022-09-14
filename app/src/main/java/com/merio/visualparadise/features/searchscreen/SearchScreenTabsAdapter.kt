package com.merio.visualparadise.features.searchscreen

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.merio.visualparadise.features.searchscreen.image.SearchScreenImageFragment
import com.merio.visualparadise.features.searchscreen.video.SearchScreenVideoFragment

class SearchScreenTabsAdapter(
    activity: FragmentActivity
): FragmentStateAdapter(activity) {

    override fun createFragment(position: Int): Fragment {

        return when (position) {
            0 -> SearchScreenImageFragment()
            else -> SearchScreenVideoFragment()
        }
    }

    override fun getItemCount(): Int {
        return 2
    }
}
