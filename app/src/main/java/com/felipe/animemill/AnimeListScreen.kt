package com.felipe.animemill

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.felipe.animemill.Adapter.AnimesAdapter
import com.felipe.animemill.Model.addAnimes
import com.felipe.animemill.Onclick.OnItemClickListener
import com.felipe.animemill.Onclick.addOnItemClickListener
import com.felipe.animemill.databinding.ActivityAnimeListScreenBinding
import com.google.firebase.auth.FirebaseAuth

class AnimeListScreen : AppCompatActivity() {

    private lateinit var binding: ActivityAnimeListScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimeListScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recycler_animes = binding.recyclerview
        recycler_animes.adapter = AnimesAdapter(addAnimes())

        recycler_animes.layoutManager = GridLayoutManager(applicationContext, 3)

        recycler_animes.addOnItemClickListener(object: OnItemClickListener{
            override fun onItemClicked(position: Int, view: View) {

                when{
                    position == 0 -> InfoAnime()
                }
            }
        })

    }

    private fun InfoAnime () {
        val intent = Intent(this, AnimeInfo::class.java)
        startActivity(intent)
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflate = menuInflater
        inflate.inflate(R.menu.menu_main, menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.logout -> {
                FirebaseAuth.getInstance().signOut()
                returnLoginScreen()

            }
        }

        return super.onOptionsItemSelected(item)
    }


    private fun returnLoginScreen (){
        val intent = Intent(this, LoginScreenFinal::class.java)
        startActivity(intent)
        finish()
    }
}