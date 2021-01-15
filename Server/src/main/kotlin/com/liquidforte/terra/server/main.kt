package com.liquidforte.terra.server

fun main(vararg args: String) {
    println("Welcome to Project Terra!")
    if (args.isNullOrEmpty()) {
        TerraApplication().run("server", "config.yml")
    } else {
        TerraApplication().run(*args)
    }
}