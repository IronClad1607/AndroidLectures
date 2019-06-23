package com.example.fragmets


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.fragment_fragment_marvel.view.*


class FragmentMarvel : Fragment() {

    val MarvelMovies = arrayOf(
        "Iron Man",
        "Iron Man 2",
        "Incredible Hulk",
        "Captain America",
        "Thor",
        "Avengers",
        "Iron Man 3",
        "Captain America 2",
        "Thor 2",
        "GOTG",
        "Avengers:Age of Ultron",
        "Ant-Man",
        "Captain America : Civil War",
        "Doctor Strange",
        "GOTG 2",
        "Spider Man : Homecoming",
        "Thor : Ragnarok",
        "Avengers : Infinity War",
        "Ant-Man and the Wasp",
        "Captain Marvel",
        "Avengers:Endgame"
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_fragment_marvel, container, false)
        view.marvelLV.adapter =
            ArrayAdapter<String>(requireContext(), android.R.layout.simple_list_item_1, MarvelMovies)


        return view
    }


}
