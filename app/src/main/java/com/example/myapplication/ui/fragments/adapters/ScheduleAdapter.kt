package com.example.myapplication.ui.fragments.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.data.model.ScheduleItem
import com.example.myapplication.databinding.DayHeaderBinding
import com.example.myapplication.databinding.ScheduleLessonBinding

//https://androidacademic.blogspot.com/2023/03/recyclerview-multiple-view-type-android-kotlin.html

class ScheduleAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var schedule: List<ScheduleItem> = listOf()

    inner class ScheduleDayViewHolder(private val binding: DayHeaderBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(day: ScheduleItem.DayItem) {
            binding.dayHeader.text = day.day
        }
    }

    inner class ScheduleLessonsViewHolder(private val binding: ScheduleLessonBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(lesson: ScheduleItem.LessonItem) {
            binding.subject.text = lesson.subject
            binding.time.text = "${lesson.startTime} - ${lesson.endTime}"
            binding.room.text = lesson.room
            binding.teacher.text = lesson.teacher
        }
    }

    override fun getItemViewType(position: Int): Int {
        val item = schedule[position]

        return when(item) {
            is ScheduleItem.DayItem -> R.layout.day_header
            is ScheduleItem.LessonItem -> R.layout.schedule_lesson
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType) {
            R.layout.day_header -> ScheduleDayViewHolder(DayHeaderBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            R.layout.schedule_lesson -> ScheduleLessonsViewHolder(ScheduleLessonBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = schedule[position]
        when (item) {
            is ScheduleItem.DayItem -> (holder as ScheduleDayViewHolder).bind(item)
            is ScheduleItem.LessonItem-> (holder as ScheduleLessonsViewHolder).bind(item)
        }
    }

    override fun getItemCount(): Int = schedule.size

    fun updateScheduleItems(schedule: List<ScheduleItem>) {
        this.schedule = schedule
        notifyDataSetChanged()
    }
}