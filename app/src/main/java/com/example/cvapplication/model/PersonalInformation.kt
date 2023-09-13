package com.example.cvapplication.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PersonalInformation(
    val fullName : String = "Daniel Iroka Chinedum",
    val slackUsername : String = "Daniel Chinedum Iroka",
    val githubHandle : String = "daniel-iroka",
    val personalBio : String = "An entry-level Android Application Developer with 2+ years of experience," +
            " I am hardworking and eager to learn. I strive to provide and adopt the best possible business " +
            "solutions for real-life problems, utilizing the available skills needed."
) : Parcelable