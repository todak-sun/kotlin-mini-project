package io.study.kotlin.kotlinminiproject.domain

class Rung(count: Int?) {
    var count: Int
    init {
        if (count != null) {
            if (count < 3 || count > 20) {
                throw IllegalArgumentException("사다리의 단계는 3개 이상 20개 이하 이어야 합니다.")
            }
        }
        val range = (3..20)
        this.count = count ?: range.random()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Rung

        if (count != other.count) return false

        return true
    }

    override fun hashCode(): Int {
        return count
    }

}
