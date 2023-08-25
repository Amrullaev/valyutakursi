package com.amrullaev.valyutakursi.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.amrullaev.valyutakursi.databinding.ItemCurseBinding
import com.amrullaev.valyutakursi.models.CurseDataItem

class AllCourseAdapter(private val list: List<CurseDataItem>) :
    RecyclerView.Adapter<AllCourseAdapter.VH>() {

    inner class VH(private val itemCurseBinding: ItemCurseBinding) :
        RecyclerView.ViewHolder(itemCurseBinding.root) {
        fun onBind(curseDataItem: CurseDataItem) {
            itemCurseBinding.courseName.text = curseDataItem.CcyNm_EN
            itemCurseBinding.rate.text = curseDataItem.Rate
            itemCurseBinding.diff.text = curseDataItem.Diff
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(ItemCurseBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}