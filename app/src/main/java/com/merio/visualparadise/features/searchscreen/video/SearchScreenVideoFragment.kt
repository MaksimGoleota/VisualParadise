package com.merio.visualparadise.features.searchscreen.video

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.merio.visualparadise.R

class SearchScreenVideoFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_video_screen_search, container, false)
    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?): Unit = with(binding) {
//
//        searchBtn.setOnClickListener {
//            val bundle = Bundle().apply {
//                putString("q", imageSearchScreen.text.toString())
//            }
//            if(imageSearchScreen.text.toString().isEmpty()) {
//                android.widget.Toast.makeText(activity,"The input field is empty. Try again!",
//                    android.widget.Toast.LENGTH_SHORT)
//                    .show()
//            }
//            else findNavController().navigate(com.merio.visualparadise.R.id.imagesScreenFragment, args = bundle)
//        }
//    }
}
