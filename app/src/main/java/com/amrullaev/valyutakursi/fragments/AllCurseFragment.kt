package com.amrullaev.valyutakursi.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.amrullaev.valyutakursi.R
import com.amrullaev.valyutakursi.adapters.AllCourseAdapter
import com.amrullaev.valyutakursi.api.RetrofitClient
import com.amrullaev.valyutakursi.databinding.FragmentAllCurseBinding
import kotlinx.coroutines.launch


class AllCurseFragment : Fragment() {
    private var _binding: FragmentAllCurseBinding? = null
    private val binding get() = requireNotNull(_binding)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAllCurseBinding.inflate(layoutInflater)
        val retrofitClient = RetrofitClient.getRetrofitClient()

        try {
            lifecycleScope.launch {
                val response = retrofitClient.getCurse()
                if (response.isSuccessful) {
                    val allCourseAdapter =
                        AllCourseAdapter(response.body()!!)
                    binding.rv.adapter = allCourseAdapter
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return binding.root
    }


}