package com.merio.visualparadise.features.searchresultsscreen

import android.R
import android.R.attr.data
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.merio.visualparadise.databinding.FragmentImagesScreenBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ImagesScreenFragment : Fragment() {

    private val mViewModel: ImageScreenViewModel by viewModels()

    private var _binding: FragmentImagesScreenBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentImagesScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        mViewModel.search(arguments?.getString("q")?: "angel")

        var adapter = ImageScreenAdapter()

        recyclerviewImages.adapter = adapter
        recyclerviewImages.setHasFixedSize(true)

        mViewModel.imageLiveData.observe(viewLifecycleOwner) { image ->
            adapter.setData(image)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
