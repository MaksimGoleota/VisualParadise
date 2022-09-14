package com.merio.visualparadise.features.searchscreen.image

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.merio.visualparadise.R
import com.merio.visualparadise.databinding.FragmentImageScreenSearchBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchScreenImageFragment : Fragment() {

    private var _binding: FragmentImageScreenSearchBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentImageScreenSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?): Unit = with(binding) {

        searchBtn.setOnClickListener {
            val bundle = Bundle().apply {
                putString("q", imageSearchScreen.text.toString())
            }
            findNavController().navigate(R.id.imagesScreenFragment, args = bundle)
        }
    }
}
