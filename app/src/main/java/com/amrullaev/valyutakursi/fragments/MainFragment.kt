package com.amrullaev.valyutakursi.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.amrullaev.valyutakursi.R
import com.amrullaev.valyutakursi.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = requireNotNull(_binding)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(layoutInflater)


//        val fr = requireActivity().supportFragmentManager.beginTransaction()
//        fr.add(R.id.fragmentsBox, HomeFragment())
//        fr.addToBackStack(null)
//        fr.commit()
//
//        binding.bottomView.setOnItemSelectedListener {
//            Log.d("TAG", "onCreateView: ${it.itemId}")
//            when (it.itemId) {
//                R.id.homeFragment -> {
//                    fr.add(R.id.fragmentsBox, HomeFragment())
//
//                }
//                R.id.allCurseFragment -> {
//                    fr.add(R.id.fragmentsBox, AllCurseFragment())
//                    fr.commit()
//
//                }
//                R.id.calcFragment -> {
//                    fr.add(R.id.fragmentsBox, CalcFragment())
//                    fr.commit()
//                }
//            }
//            return@setOnItemSelectedListener true
//        }


        return binding.root
    }


}