package com.merio.visualparadise.features.searchscreen

import android.graphics.PorterDuff
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.merio.visualparadise.R
import com.merio.visualparadise.databinding.FragmentSearchScreenBinding

class SearchScreenFragment : Fragment() {

    private var _binding: FragmentSearchScreenBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {

        viewPager.adapter = SearchScreenTabsAdapter(requireActivity())

        val tabsArray = arrayOf(
            NameTabs.IMAGE.value,
            NameTabs.VIDEO.value
        )

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = tabsArray[position]
            when (position) {
                0 -> tab.setIcon(R.drawable.ic_image)
                1 -> tab.setIcon(R.drawable.ic_video)
            }
            tabLayout.getTabAt(0)?.icon
                ?.setColorFilter(resources.getColor(R.color.red), PorterDuff.Mode.SRC_IN)
        }.attach()

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.icon?.setColorFilter(resources.getColor(R.color.red), PorterDuff.Mode.SRC_IN)
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                tab?.icon?.setColorFilter(resources.getColor(R.color.white), PorterDuff.Mode.SRC_IN)
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

enum class NameTabs(val value: String) {
    IMAGE("Image"),
    VIDEO("Video")
}
