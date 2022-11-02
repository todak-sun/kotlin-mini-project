package io.study.kotlin.kotlinminiproject.practice


class Person(
    val name: String, // 읽기 전용 / 비공개 / Getter 생성
    var isMarried: Boolean // 수정 가능 / 비공개 / Getter, Setter 생성
)

enum class Fruit(name: String) {
    APPLE("사과"),
    BANANA("바나나"),
    CITRON("유자"),
}

fun getNameByKorean(fruit: Fruit) =
    when(fruit) {
        Fruit.APPLE -> Fruit.APPLE.name
        Fruit.BANANA -> Fruit.BANANA.name
        Fruit.CITRON -> Fruit.CITRON.name
    }



