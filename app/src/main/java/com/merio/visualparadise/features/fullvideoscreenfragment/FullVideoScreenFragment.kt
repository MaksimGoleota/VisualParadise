package com.merio.visualparadise.features.fullvideoscreenfragment

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import androidx.fragment.app.Fragment
import com.merio.visualparadise.databinding.FragmentFullVideoScreenBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class FullVideoScreenFragment : Fragment() {

    private var _binding: FragmentFullVideoScreenBinding? = null
    private val binding get() = _binding!!

        override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       _binding = FragmentFullVideoScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        progressBarFullVideoScreen.visibility = View.VISIBLE

        val videoPath = arguments?.getString("url")
        val uri: Uri = Uri.parse(videoPath)

        videoView.setVideoURI(uri)
        val mediaController = MediaController(context)

        mediaController.setAnchorView(videoView)
        mediaController.setMediaPlayer(videoView)

        videoView.setMediaController(mediaController)
        videoView.start()

        viewsTextView.text = arguments?.getInt("views").toString()
        downloadsTextView.text = arguments?.getInt("downloads").toString()
        likesTextView.text = arguments?.getInt("likes").toString()


    }
}
