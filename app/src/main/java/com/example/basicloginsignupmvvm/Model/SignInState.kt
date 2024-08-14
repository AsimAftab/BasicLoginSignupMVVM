package com.example.basicloginsignupmvvm.Model

data class SignInState(
    val isSignInSuccessful: Boolean =false,
    val signInError:String? =null
)
