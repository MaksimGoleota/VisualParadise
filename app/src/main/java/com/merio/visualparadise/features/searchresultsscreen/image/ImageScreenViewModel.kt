package com.merio.visualparadise.features.searchresultsscreen.image

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.merio.visualparadise.data.network.models.Image
import com.merio.visualparadise.data.repository.VisualParadiseRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

@HiltViewModel
class ImageScreenViewModel @Inject constructor(
    private val visualParadiseRepository: VisualParadiseRepository
): ViewModel() {

    val imageLiveData = MutableLiveData<List<Image>>()
    private val compositeDisposable = CompositeDisposable()

    fun search(q: String) {
        compositeDisposable.add(
            visualParadiseRepository.getImages(q)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError {
                    Log.d("Network error", it.toString())
                }
                .doOnSuccess {
                    imageLiveData.value = it
                }
                .subscribe()
        )
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}
