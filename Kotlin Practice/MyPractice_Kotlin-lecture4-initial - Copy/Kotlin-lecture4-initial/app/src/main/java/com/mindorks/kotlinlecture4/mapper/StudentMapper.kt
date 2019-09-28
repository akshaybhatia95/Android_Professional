package com.mindorks.kotlinlecture4.mapper

import com.mindorks.kotlinlecture4.model.ApiStudent
import com.mindorks.kotlinlecture4.model.Student

object StudentMapper { // used to create a singleton class without any parameter and is thread safe

    fun map(apiStudent: ApiStudent):Student{
        return Student(apiStudent.firsName+" "+apiStudent.lastName,apiStudent.averageMark)
    }
}