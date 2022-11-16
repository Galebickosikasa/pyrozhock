package com.runningcherry.pyrozhock

import java.util.Date

data class Event (
    var name : String,
    var date: String,
    var start : String,
    var end : String,
    var done: Boolean = false
)