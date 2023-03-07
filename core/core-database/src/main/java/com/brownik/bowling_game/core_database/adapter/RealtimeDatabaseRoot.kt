package com.brownik.bowling_game.core_database.adapter

import com.google.firebase.database.FirebaseDatabase

class RealtimeDatabaseRoot {
    val rootInstance = FirebaseDatabase.getInstance()


    fun checkAutoSignIn() = rootInstance.reference.child(TableConstants.USER_INFO_TABLE)
}