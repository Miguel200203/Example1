package com.rick.workclass.ejemplo

//class variables {
//}

fun main(){
    //Numeric variables
    val age:Int =20
    val long_number:Long = 789123128937
    val temperature:Float = 27.33f
    val weight:Double = 64.1231

    //String variables
    val gender:Char = 'M'
    val name:String = "Ricardo Reyes"

    //Bool variables
    val isGreater:Boolean = false

    //Collection variables
    val names = arrayOf("Erick", "Sofia", "Javier", "Veronica")

    println(age)

    println ("Welcome $name, to your first Kotlin project")
    println(add())
    println(producto(5,8))
    printarray(names)

}

fun add():Int{
    val x = 10
    val y = 5
    return (x+y)
}

fun producto(x:Int,y:Int):Int{
    return (x*y)
}

fun printarray(names:Array<String>){
    println(names)
    //El for separa los nombres del array y va imprimiendo cada uno 
    for(name in names){
        println(" hello $name")
    }

}