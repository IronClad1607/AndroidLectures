package com.example.marvelvsdc


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.fragment_fragment_dc.view.*

class FragmentDC : Fragment() {

    val DCMovies = arrayOf(
        "Batman",
        "The Dark Knight",
        "The Dark Knight Returns",
        "Green Latern",
        "Man of Steel",
        "Batman VS Superman",
        "Justice League",
        "Wonder Woman",
        "Aquaman",
        "Shazam",
        "Suicide Squad"
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_fragment_dc, container, false)
        val argument = arguments
        argument?.getString("NAME")
        view.dcLV.adapter = ArrayAdapter<String>(requireContext(), android.R.layout.simple_list_item_1, DCMovies)
        return view
    }


}
