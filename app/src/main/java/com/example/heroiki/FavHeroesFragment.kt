package com.example.heroiki

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.heroiki.databinding.ActivityMainBinding


class FavHeroesFragment : Fragment(R.layout.fragment_fav_heroes) {

    private val binding: ActivityMainBinding by viewBinding(ActivityMainBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }
}