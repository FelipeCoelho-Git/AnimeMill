package com.felipe.animemill.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.felipe.animemill.Model.Animes
import com.felipe.animemill.databinding.ActivityAnimeListScreenBinding
import com.felipe.animemill.databinding.AnimeListBinding

class AnimesAdapter (val animes: MutableList<Animes>):RecyclerView.Adapter<AnimesAdapter.AnimesViewHolder>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimesViewHolder {
        val binding = AnimeListBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return AnimesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AnimesViewHolder, position: Int) {
        with(holder){
            with(animes[position]){
                binding.coverAnime.setImageResource(coverAnime)
            }
        }
    }

    override fun getItemCount() = animes.size

    inner class AnimesViewHolder(val binding: AnimeListBinding): RecyclerView.ViewHolder(binding.root){

    }
}