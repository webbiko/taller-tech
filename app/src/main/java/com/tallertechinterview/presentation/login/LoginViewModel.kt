package com.tallertechinterview.presentation.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class LoginViewModel: ViewModel() {
    private val _userStatus = MutableLiveData<LoginStatus>()
    val userStatus = _userStatus
    fun login(userName: String, password: String) {
        viewModelScope.launch {
            if (password.isEmpty() || userName.isEmpty()) {
                userStatus.value = LoginStatus.LoginError(LoginErrorType.INVALID_PASSWORD)
            } else if (userName == "webbiko" && password == "1234") {
                userStatus.value = LoginStatus.Success
            }
        }
    }
}

enum class LoginErrorType {
    INVALID_PASSWORD,
    PASSWORD_RULES,
}
sealed interface LoginStatus {
    object Loaing: LoginStatus
    object Success: LoginStatus
    data class LoginError(val type: LoginErrorType): LoginStatus
}