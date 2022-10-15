package com.merio.visualparadise.features.searchresultsscreen.video

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.merio.visualparadise.data.network.models.Video
import com.merio.visualparadise.data.repository.VisualParadiseRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class VideosScreenViewModel @Inject constructor(
    private val visualParadiseRepository: VisualParadiseRepository
): ViewModel() {

    val videoLiveData = MutableLiveData<List<Video>>()
    private val compositeDisposable = CompositeDisposable()

    fun search(q: String) {
        compositeDisposable.add(
            visualParadiseRepository.getVideos(q)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError {
                    Log.d("Network error", it.toString())
                }
                .doOnSuccess {
                    videoLiveData.value = it
                }
                .subscribe()
        )
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}
