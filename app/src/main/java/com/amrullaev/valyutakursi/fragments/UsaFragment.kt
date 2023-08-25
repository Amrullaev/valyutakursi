package com.amrullaev.valyutakursi.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.amrullaev.valyutakursi.api.RetrofitClient
import com.amrullaev.valyutakursi.databinding.FragmentUsaBinding
import com.amrullaev.valyutakursi.models.CurseDataItem
import kotlinx.coroutines.launch


class UsaFragment : Fragment() {
    private var _binding: FragmentUsaBinding? = null
    private val binding get() = requireNotNull(_binding)
    private lateinit var curseDataItem: CurseDataItem


    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentUsaBinding.inflate(layoutInflater)
        val retrofitClient = RetrofitClient.getRetrofitClient()


        try {
            lifecycleScope.launch {
                val response = retrofitClient.getCurse()

                if (response.isSuccessful) {
                    val vp = curseDataItem.Rate.toInt() - curseDataItem.Diff.toInt()
                    curseDataItem = response.body()!![0]
                    binding.uszKursVp.text =vp.toString()
                    binding.uszKursOlinishiVp.text = curseDataItem.Rate
                    binding.dayVp.text = curseDataItem.Date
                    response.body()
                    Log.d("TAG", "onCreateView: $response")
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }


        return binding.root
    }


}