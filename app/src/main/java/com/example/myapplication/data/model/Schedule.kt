package com.example.myapplication.data.model


sealed class ScheduleItem {
    data class DayItem(
        val day: String,
        val lessons: List<LessonItem> = emptyList()
    ) : ScheduleItem()

    data class LessonItem(
        val room: String,
        val subject: String,
        val teacher: String,
        val startTime: String,
        val endTime: String
    ) : ScheduleItem()
}

object Schedule {
    private val ourSchedule: List<ScheduleItem> = listOf(
        ScheduleItem.DayItem(
            day = "Monday",
            lessons = listOf(
                ScheduleItem.LessonItem("A-17", "Базы и хранилища данных (лек.)", "Барабанщиков И.В.", "18:20", "19:50"),
                ScheduleItem.LessonItem("132", "Базы и хранилища данных (пр.)", "Барабанщиков И.В.", "19:55", "21:25")
            )
        ),
        ScheduleItem.DayItem(
            day = "Tuesday",
            lessons = listOf(
                ScheduleItem.LessonItem("A-21", "Управление ИТ-проектами и жизненным циклом ПО (лек.)", "Воробьев В.И.,\nПущев А.А.", "18:20", "19:50"),
                ScheduleItem.LessonItem("A-21", "Управление ИТ-проектами и жизненным циклом ПО (пр.)", "Воробьев В.И.,\nПущев А.А.", "19:55", "21:25")
            )
        ),
        ScheduleItem.DayItem(
            day = "Wednesday",
            lessons = listOf(
                ScheduleItem.LessonItem("None", "Отдых", "None", "00:00", "00:00")
            )
        ),
        ScheduleItem.DayItem(
            day = "Thursday",
            lessons = listOf(
                ScheduleItem.LessonItem("дистант", "Разработка интернет-приложений (лек.)", "Павличенков Е.А.", "19:30", "21:25"),
                ScheduleItem.LessonItem("дистант", "Разработка интернет-приложений (пр.)", "Павличенков Е.А.", "19:30", "21:25")
            )
        ),
        ScheduleItem.DayItem(
            day = "Friday",
            lessons = listOf(
                ScheduleItem.LessonItem("215 (2 корпус)", "Экономика программной инженерии (пр.)", "Ткач Е.С.", "13:15", "14:45"),
                ScheduleItem.LessonItem("120 (2 корпус)", "Экономика программной инженерии (лек.)", "Ткач Е.С.", "15:00", "16:30"),
                ScheduleItem.LessonItem("120 (2 корпус)", "Экономика программной инженерии (лек.)", "Ткач Е.С.", "16:40", "18:10"),
                ScheduleItem.LessonItem("дистант", "Тестирование ПО (лек.)", "Булавин Р.С.", "19:30", "21:00")
            )
        ),
        ScheduleItem.DayItem(
            day = "Saturday",
            lessons = listOf(
                ScheduleItem.LessonItem("132", "Тестирование ПО (пр.)", "Булавин Р.С.", "11:20", "12:50"),
                ScheduleItem.LessonItem("132", "Тестирование ПО (пр.)", "Булавин Р.С.", "13:15", "14:45"),
                ScheduleItem.LessonItem("326", "Технологии прикладного программирования (лек.)", "Веригин Н.В.", "15:00", "16:30"),
                ScheduleItem.LessonItem("326", "Технологии прикладного программирования (пр.)", "Веригин Н.В.", "16:40", "18:10")
            )
        ),
        ScheduleItem.DayItem(
            day = "Sunday",
            lessons = listOf(
                ScheduleItem.LessonItem("None", "Отдых", "None", "00:00", "00:00")
            )
        )
    )


    fun getToday(): List<ScheduleItem> {
        return listOf(ourSchedule[0])
    }

    fun getWeek(): List<ScheduleItem> {
        return ourSchedule
    }

    fun getFlattenFormat(items: List<ScheduleItem>): List<ScheduleItem> {
        val result = mutableListOf<ScheduleItem>()
        for (item in items) {
            result.add(item)
            if (item is ScheduleItem.DayItem) {
                result.addAll(item.lessons)
            }
        }
        return result
    }
}