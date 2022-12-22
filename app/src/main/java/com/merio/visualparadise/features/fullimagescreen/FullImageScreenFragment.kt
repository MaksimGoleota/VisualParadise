package com.merio.visualparadise.features.fullimagescreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.merio.visualparadise.databinding.FragmentFullImageScreenBinding
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class FullImageScreenFragment : Fragment() {

    private var _binding: FragmentFullImageScreenBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFullImageScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        progressBarFullImageScreen.visibility = View.VISIBLE
        Picasso.get()
            .load(arguments?.getString("largeImageURL"))
            .centerCrop()
            .fit()
            .into(fullImage)

        viewsTextView.text = arguments?.getInt("views").toString()
        downloadsTextView.text = arguments?.getInt("downloads").toString()
        likesTextView.text = arguments?.getInt("likes").toString()
    }
}
