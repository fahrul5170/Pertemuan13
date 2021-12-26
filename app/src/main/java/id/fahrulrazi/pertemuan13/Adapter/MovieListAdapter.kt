package id.fahrulrazi.pertemuan13.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import id.fahrulrazi.pertemuan13.Model.MovieModel
import id.fahrulrazi.pertemuan13.R

class MovieListAdapter(var context: Context, var movieModelList: MutableList<MovieModel>):
    RecyclerView.Adapter<MovieListAdapter.MyViewModel> (){
    inner class MyViewModel(itemView: View ) : RecyclerView.ViewHolder(itemView) {

        var imgMovie: ImageView
        var txtMovieName: TextView
        var txtTeam: TextView
        var txtCreatedby: TextView

        init {
            imgMovie = itemView.findViewById(R.id.imgMovie)
            txtMovieName = itemView.findViewById(R.id.txtMovieName)
            txtTeam = itemView.findViewById(R.id.txtTeam)
            txtCreatedby = itemView.findViewById(R.id.txtCreatedBy)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewModel {
        return MyViewModel(LayoutInflater.from(context).inflate(R.layout.layout_movie_list, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewModel, position: Int) {
        Picasso.get().load(movieModelList[position].imageurl).into(holder.imgMovie)
        holder.txtMovieName.text = movieModelList[position].name
        holder.txtTeam.text = movieModelList[position].team
        holder.txtCreatedby.text = movieModelList[position].createdby
    }

    override fun getItemCount(): Int {
        return movieModelList.size
    }
}