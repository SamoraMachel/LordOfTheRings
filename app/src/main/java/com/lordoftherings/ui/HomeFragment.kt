package com.lordoftherings.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.lordoftherings.R
import com.lordoftherings.databinding.FragmentBookBinding
import com.lordoftherings.shared.Constants

class HomeFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentBookBinding.inflate(inflater)

        Glide.with(requireContext())
            .load(Constants.USER_PROFILE_IMAGE)
            .circleCrop()
            .into(binding.profileImage)


        return binding.root
    }


}