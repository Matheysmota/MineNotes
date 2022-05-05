package com.matheus.mota.minenotes.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.matheus.mota.minenotes.viewModel.home.HomeNoteViewModel

class HomeNoteViewModelFactory() : ViewModelProvider.Factory {

    //ViewModelFactory implementation to instantiate and return ViewModel
//    private val retrofitService = GalleryRetrofit.getGalleryRetrofit()

    //    override fun <T : ViewModel> create(modelClass: Class<T>) : T {
//        return if (modelClass.isAssignableFrom(HomeNoteViewModel::class.java)){
////            val repository = GalleryRepository(GalleryRetrofit.create)
////            GalleryViewModel(repository) as T
//
//        } else {
//            throw IllegalArgumentException("ViewModel Not Found")
//        }
//    }
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        TODO("Not yet implemented")
    }
}