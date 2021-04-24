package com.example.movieapp

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.movieapp.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false)
        val args = DetailFragmentArgs.fromBundle(requireArguments())
        binding.movie = Movie(
            args.movie.title,
            args.movie.description,
            args.movie.rating,
            args.movie.genres,
            args.movie.creators,
            args.movie.actors,
            args.movie.picture
        )

        binding.titleImage.setImageResource(args.movie.picture)
        binding.floatingActionButton.setOnClickListener {
            Toast.makeText(requireContext(), "added to watchlist", Toast.LENGTH_SHORT).show()
        }
        return binding.root
    }

}