package com.tanmaysuryawanshi.githubapp.featureIssues.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.Gson

import com.google.gson.reflect.TypeToken
import com.tanmaysuryawanshi.githubapp.featureIssues.data.util.JsonParser
import com.tanmaysuryawanshi.githubapp.featureIssues.domain.model.User
import com.tanmaysuryawanshi.githubapp.featureIssues.domain.model.label

@ProvidedTypeConverter
class Converters(private val jsonParser: JsonParser) {


    val gson = Gson()

    @TypeConverter
    fun userToString(user: User): String {
        return gson.toJson(user)
    }

    @TypeConverter
    fun stringToUser(recipeString: String): User {
        val objectType = object : TypeToken<User>() {}.type
        return gson.fromJson(recipeString, objectType)
    }

@TypeConverter
fun fromLabelsJson(json:String):List<label>{
    return jsonParser.fromJson<ArrayList<label>>(
        json,
        object : TypeToken<ArrayList<label>>(){}.type
    )?: emptyList()
}



    @TypeConverter
    fun toLabelsJson(labels:List<label>):String{

        return jsonParser.toJson(
            labels,
            object : TypeToken<ArrayList<label>>(){}.type
        )?:"[]"
    }

}