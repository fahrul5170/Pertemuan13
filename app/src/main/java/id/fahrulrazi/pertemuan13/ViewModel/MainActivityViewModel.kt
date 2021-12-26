package id.fahrulrazi.pertemuan13.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import id.fahrulrazi.pertemuan13.Model.MovieModel
import id.fahrulrazi.pertemuan13.Repositories.MainRepo

class MainActivityViewModel: ViewModel() {
    private val mainRepo: MainRepo
    val getMovieList: LiveData<MutableList<MovieModel>>
    get() = mainRepo.getMovieModelLiveData

    init {
        mainRepo = MainRepo()
    }
}