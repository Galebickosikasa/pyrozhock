package com.runningcherry.pyrozhock

import java.util.Date

data class Event (
    var name : String,
    private var date: Date,
    var start : String,
    var end : String,
    var done: Boolean = false
)