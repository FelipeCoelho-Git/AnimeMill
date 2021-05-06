package com.felipe.animemill

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.felipe.animemill.Adapter.AnimesAdapter
import com.felipe.animemill.Model.addAnimes
import com.felipe.animemill.databinding.ActivityAnimeInfoBinding
import com.squareup.picasso.Picasso

class AnimeInfo : AppCompatActivity() {

    private  lateinit var binding: ActivityAnimeInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimeInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()

        val recycler_more  = binding.recyclerMore
        recycler_more.adapter = AnimesAdapter(addAnimes())
        recycler_more.layoutManager = GridLayoutManager(applicationContext, 3)

        Toolbar()

        val coverHorimiya = "https://firebasestorage.googleapis.com/v0/b/animemill-f16d4.appspot.com/o/Captura%20de%20tela%202021-05-05%20235452.png?alt=media&token=86385f82-59a7-42e2-8265-ad84cc77a854"
        Picasso.get().load(coverHorimiya).fit().into(binding.cover)

        binding.playAnime.setOnClickListener{
            val intent = Intent(this, Player::class.java)
            startActivity(intent)
        }
    }

    private fun Toolbar(){
        val toolbar_info = binding.toolbarInfo
        toolbar_info.setNavigationIcon(getDrawable(R.drawable.ic_back))
        toolbar_info.setNavigationOnClickListener {
            val intent = Intent(this, AnimeListScreen::class.java)
            startActivity(intent)
            finish()
        }
    }
}