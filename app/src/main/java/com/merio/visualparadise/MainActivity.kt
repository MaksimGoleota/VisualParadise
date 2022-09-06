package com.merio.visualparadise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.merio.visualparadise.example.UjunaldAdapter
import com.merio.visualparadise.example.UjunaldViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val navController: NavController by lazy {
        findNavController(R.id.nav_fragment)
    }

//    private lateinit var ujunaldList: RecyclerView
//    private val mViewModel: UjunaldViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val graph = navController.navInflater.inflate(R.navigation.navigation)
        navController.graph = graph

//        ujunaldList = findViewById<RecyclerView>(R.id.cryptocurrency_list)
//        ujunaldList.layoutManager = LinearLayoutManager(this)
//
//        observeUjunald()
    }

//    private fun observeUjunald() {
//        mViewModel.ujunaldEmitter.observe(this) {
//            ujunaldList.adapter = UjunaldAdapter(it)
//        }
//    }


}