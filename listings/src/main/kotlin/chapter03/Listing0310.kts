fun twice(f: (Int) -> Int): (Int) -> Int = { x -> f(f(x)) }  // Applies ‘f’ twice
// ---------

val plusTwo = twice { it +1 }  // Uses lambda
val plus2   = twice(Int::inc)    // Uses function reference

val res1=plusTwo(1)
val res2=plus2(1)
println(res1)
println(res2)
