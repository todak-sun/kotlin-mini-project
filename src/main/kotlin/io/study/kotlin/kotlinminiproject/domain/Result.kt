package io.study.kotlin.kotlinminiproject.domain

data class Result(val order: Int,
             val participant: String,
             val destination: String,
             val routes: List<Int>) {
}