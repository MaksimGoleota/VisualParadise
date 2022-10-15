package com.merio.visualparadise.features.searchresultsscreen.video

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.merio.visualparadise.R
import com.merio.visualparadise.databinding.FragmentVideosScreenBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class VideosScreenFragment : Fragment() {

    private val mViewModel: VideosScreenViewModel by viewModels()

    private var _binding: FragmentVideosScreenBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel.search(arguments?.getString("q")?: "angel")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentVideosScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        progressBarVideosScreen.visibility = View.VISIBLE
        val adapter = VideosScreenAdapter { url, views, downloads, likes ->
            val bundle = Bundle().apply {
                putString("url", url)
                putInt("views", views)
                putInt("downloads", downloads)
                putInt("likes", likes)
            }
            findNavController().navigate(R.id.fullVideoScreenFragment, args = bundle)
        }

        recyclerviewVideos.adapter = adapter
        recyclerviewVideos.setHasFixedSize(true)

        mViewModel.videoLiveData.observe(viewLifecycleOwner) { video ->
            adapter.setData(video)
            progressBarVideosScreen.visibility = View.INVISIBLE
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
