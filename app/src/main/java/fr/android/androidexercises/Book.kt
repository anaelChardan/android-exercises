package fr.android.androidexercises


class Book(val name: String, val price: Float) {

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false

        val book = o as Book?

        return if (java.lang.Float.compare(book!!.price, price) != 0) false else name == book.name

    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + if (price != +0.0f) java.lang.Float.floatToIntBits(price) else 0
        return result
    }
}