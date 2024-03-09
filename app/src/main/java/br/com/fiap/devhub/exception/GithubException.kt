package br.com.fiap.devhub.exception

import java.lang.RuntimeException

class GithubException : RuntimeException() {

    fun invalidUser(){
        println("Usuario inválido")
    }
}