package com.example.week6

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.week6.databinding.FragmentHomeBinding
import com.example.week6.databinding.ItemClassBinding

class SubjectRVAdapter(private var subjectList : ArrayList<Subject>):RecyclerView.Adapter<SubjectRVAdapter.ViewHolder>() {
    override fun onCreateViewHolder(viewgroup: ViewGroup, viewType: Int): SubjectRVAdapter.ViewHolder {
        val binding:ItemClassBinding = ItemClassBinding.inflate(LayoutInflater.from(viewgroup.context), viewgroup, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SubjectRVAdapter.ViewHolder, position: Int) {
        holder.bind(subjectList[position])
    }

    override fun getItemCount(): Int = subjectList.size

    inner class ViewHolder(val binding:ItemClassBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(subject: Subject){
            binding.itemClassColor.setCardBackgroundColor(Color.parseColor(subject.color))
            binding.itemClassSubjectTextBig.text = subject.name
            binding.itemClassSubjectTextSmall.text = subject.name
        }
    }
}