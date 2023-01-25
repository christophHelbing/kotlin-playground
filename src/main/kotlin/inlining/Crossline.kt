package inlining

/*
    Even though we’re exiting from a lambda, the lambda itself is inlined in the main function. Therefore,
    this return statement happens directly in the main function and not in the lambda.
    That’s the reason we can use normal returns inside inline functions.
 */
inline fun foo(f: () -> Unit) {
    f()
}

/*
    Can't pass the parameter of an inline function to a noinline function, because it may contain
    local returns
 */
inline fun barFoo(crossinline f: () -> Unit) {
    bar { f() } // Won't compile without crossinline
}

fun bar(f: () -> Unit) {
    f()
}

fun main() {
    foo {
        println("Hello World")
        return
    }

    barFoo {
        println("Hello World 2")
        // return -> Won't compile because non-local return are not allowed
    }
}
