package com.merio.visualparadise.features.searchresultsscreen.image

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.merio.visualparadise.R
import com.merio.visualparadise.databinding.FragmentImagesScreenBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ImagesScreenFragment : Fragment() {

    private val mViewModel: ImagesScreenViewModel by viewModels()

    private var _binding: FragmentImagesScreenBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel.search(arguments?.getString("q")?: "angel")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentImagesScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        progressBarImagesScreen.visibility = View.VISIBLE
        val adapter = ImagesScreenAdapter { url, views, downloads, likes ->
            val bundle = Bundle().apply {
                putString("largeImageURL", url)
                putInt("views", views)
                putInt("downloads", downloads)
                putInt("likes", likes)
            }
            findNavController().navigate(R.id.fullImageScreenFragment, args = bundle)
        }

        recyclerviewImages.adapter = adapter
        recyclerviewImages.setHasFixedSize(true)

        mViewModel.imageLiveData.observe(viewLifecycleOwner) { image ->
            adapter.setData(image)
            progressBarImagesScreen.visibility = View.INVISIBLE
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
