package com.example.cvapplication.viewmodel

import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cvapplication.model.PersonalInformation
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class PersonalInformationSharedViewModel : ViewModel() {

    private var _personalInformation : MutableStateFlow<PersonalInformation> = MutableStateFlow(PersonalInformation())
    val personalInformation : StateFlow<PersonalInformation> = _personalInformation

    private var currentFullName = ""
    private var currentSlackUsername = ""
    private var currentGithubHandle = ""
    private var currentBio = ""

    fun savePersonalDetails() {
        viewModelScope.launch {
            _personalInformation.update { personalInformation ->
                personalInformation.copy(
                    fullName = currentFullName,
                    slackUsername = currentSlackUsername,
                    githubHandle = currentGithubHandle,
                    personalBio = currentBio
                )
            }
        }
    }

    val fullNameTextChangedListener : TextWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
            currentFullName = s.toString()
        }
        override fun afterTextChanged(s: Editable) {}
    }

    val slackUserNameTextChangedListener : TextWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
            currentSlackUsername = s.toString()
        }
        override fun afterTextChanged(s: Editable) {}
    }

    val githubHandleTextChangedListener : TextWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
            currentGithubHandle = s.toString()
        }
        override fun afterTextChanged(s: Editable) {}
    }

    val bioTextChangedListener : TextWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
            currentBio = s.toString()
        }
        override fun afterTextChanged(s: Editable) {}
    }

    fun detailsCheck() : Boolean {
        return !(TextUtils.isEmpty(currentFullName) || TextUtils.isEmpty(currentSlackUsername) || TextUtils.isEmpty(currentGithubHandle) || TextUtils.isEmpty(currentBio))
    }
}