package com.example.heroiki

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.heroiki.databinding.FragmentAllHeroesBinding


class AllHeroesFragment : Fragment(R.layout.fragment_all_heroes) {

    private val binding: FragmentAllHeroesBinding by viewBinding(FragmentAllHeroesBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerview = binding.recyclerView
        recyclerview.layoutManager = LinearLayoutManager(context)
        val items = ArrayList<ItemViewModel>()

        for (i in 1..20) {
            items.add(ItemViewModel(R.drawable.spiderman, "Item $i", "Description $i"))
        }

        val adapter = HeroesAdapter(items)
        recyclerview.adapter = adapter
    }
}