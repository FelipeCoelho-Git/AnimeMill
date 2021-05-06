package com.felipe.animemill

import android.net.Uri
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import com.felipe.animemill.databinding.ActivityPlayerBinding

class Player : AppCompatActivity() {

    private lateinit var binding: ActivityPlayerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlayerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()

        val AnimeUrl = Uri.parse("https://firebasestorage.googleapis.com/v0/b/animemill-f16d4.appspot.com/o/%5BAnimesTC%5D%20Horimiya%20-%2001%20%5B1080p%5D.mkv?alt=media&token=97a08749-4e3e-4c2d-9572-0e048ea269f9")

        val player = binding.player
        player.setMediaController(MediaController(this))
        player.setVideoURI(AnimeUrl)
        player.requestFocus()
        player.start()
    }
}