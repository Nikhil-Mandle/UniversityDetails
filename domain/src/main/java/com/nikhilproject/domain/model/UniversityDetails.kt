package com.nikhilproject.domain.model

import androidx.annotation.DrawableRes


data class University(
    val genreName: String,
    @DrawableRes
    val coverImage: Int,
    val universitiesCourses: List<Course>
)

data class Course(
    val name: String,
    @DrawableRes
    val image: Int,
    val professor: String,
)