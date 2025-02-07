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
     val numbers = arrayOf(1,2,3,4,5,6,7,8,9,10)
    isEven(numbers)

    println(getDay(1))
    val person = person("Miguel", 22)
    person.displayInformation()
    println(person.name)
    println(person.age)
}

fun add():Int{
    val x = 10
    val y = 5
    return (x+y)
}

fun producto(x:Int,y:Int):Int{
    return (x*y)
}

fun printarray(names:Array<String>) {
    println(names)
    //El for separa los nombres del array y va imprimiendo cada uno 
    for (name in names) {
        println(" hello $name")
    }
}
    fun isEven(numbers:Array<Int>) {
        for (number in numbers) {
            if (number % 2 == 0) {
                println("the number $number is even")
            } else {
                println("the number $number is odd")
            }
        }
    }

    fun getDay(day:Int): String{
        var name= ""
        when (day){
            //Si la operacion que se asigna a cada caso se utilizaran llaves
            1 -> name ="Monday"
            2 -> name ="Tuesday"
            3 -> name ="Wednesday"
            4 -> name ="Thursday"
            5 -> name ="Friday"
            6 -> name ="Saturday"
            7 -> name ="Sunday"
            else -> name ="Incorrect value"

        }
        return name
    }

class person (val name:String, val age:Int){
    fun displayInformation(){
        println("Name $name Age $age")
    }
}

