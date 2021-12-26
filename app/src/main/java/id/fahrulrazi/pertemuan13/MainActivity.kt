package id.fahrulrazi.pertemuan13

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dmax.dialog.SpotsDialog
import id.fahrulrazi.pertemuan13.Adapter.MovieListAdapter
import id.fahrulrazi.pertemuan13.ViewModel.MainActivityViewModel

class MainActivity : AppCompatActivity() {

    var mainActivityViewModel: MainActivityViewModel? = null
    var recyclerView: RecyclerView? = null
    var adapter: MovieListAdapter? = null
    var layoutManager: LinearLayoutManager? = null
    var dialog: AlertDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainActivityViewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]

        dialog = SpotsDialog.Builder().setCancelable(false).setContext(this).build()
        dialog!!.show()

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView!!.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(this)
        recyclerView!!.layoutManager = layoutManager

        mainActivityViewModel!!.getMovieList.observe(this){movieModels ->
            Log.e("MainActivity", "MovieLists: "+ movieModels.get(0).name)

            if (movieModels != null){
                adapter = MovieListAdapter(this, movieModels)
                adapter!!.notifyDataSetChanged()
                recyclerView!!.adapter = adapter
                dialog!!.dismiss()
            }
        }

    }
}