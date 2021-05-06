package com.felipe.animemill.Model

import com.felipe.animemill.R

data class Animes (

    val coverAnime: Int

        )

class AnimeBuilder{
    var coverAnime: Int = 0
    fun build (): Animes = Animes(coverAnime)
}

fun animes (block: AnimeBuilder.() -> Unit): Animes = AnimeBuilder().apply(block).build()

fun addAnimes(): MutableList<Animes> = mutableListOf(

    animes {
        coverAnime = R.drawable.anime8
    },

    animes {
        coverAnime = R.drawable.anime2
    },
    animes {
        coverAnime = R.drawable.anime3
    },
    animes {
        coverAnime = R.drawable.anime4
    },

    animes {
        coverAnime = R.drawable.anime5
    },
    animes {
        coverAnime = R.drawable.anime6
    },
    animes {
        coverAnime = R.drawable.anime7
    },

    animes {
        coverAnime = R.drawable.anime1
    },
    animes {
        coverAnime = R.drawable.anime9
    },
    animes {
        coverAnime = R.drawable.anime10
    },

    animes {
        coverAnime = R.drawable.anime11
    },
    animes {
        coverAnime = R.drawable.anime12
    },
    animes {
        coverAnime = R.drawable.anime13
    }


    )

