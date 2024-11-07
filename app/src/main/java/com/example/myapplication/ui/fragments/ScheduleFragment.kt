package com.example.myapplication.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintSet.Constraint
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.ui.fragments.adapters.ScheduleAdapter
import com.example.myapplication.data.model.Schedule
import com.example.myapplication.databinding.FragmentScheduleBinding

class ScheduleFragment(private val menuId: Int? = null) : Fragment() {
    private var _binding: FragmentScheduleBinding? = null
    private val binding: FragmentScheduleBinding
        get() = requireNotNull(_binding)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentScheduleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.layoutManager = LinearLayoutManager(context)

        val scheduleAdapter = ScheduleAdapter()
        binding.recyclerView.adapter = scheduleAdapter

        if (menuId == R.id.button_today) {
            val todaySchedule = Schedule.getFlattenFormat(Schedule.getToday())
            scheduleAdapter.updateScheduleItems(todaySchedule)
        } else {
            val weekSchedule = Schedule.getFlattenFormat(Schedule.getWeek())
            scheduleAdapter.updateScheduleItems(weekSchedule)
            Log.d("1", "$weekSchedule")
        }
    }
}
