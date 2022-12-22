package com.merio.visualparadise.features.searchscreen.video

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.merio.visualparadise.databinding.FragmentVideoScreenSearchBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchScreenVideoFragment : Fragment() {

    private var _binding: FragmentVideoScreenSearchBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentVideoScreenSearchBinding.inflate(inflater, container, false)
        return binding.root
     }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?): Unit = with(binding) {

        searchBtn.setOnClickListener {
            val bundle = Bundle().apply {
                putString("q", videoSearchScreen.text.toString())
            }
            if(videoSearchScreen.text.toString().isEmpty()) {
               Toast.makeText(activity,"The input field is empty. Try again!",
                   Toast.LENGTH_SHORT)
                    .show()
            }
            else findNavController().navigate(com.merio.visualparadise.R.id.videosScreenFragment, args = bundle)
        }
    }
}
