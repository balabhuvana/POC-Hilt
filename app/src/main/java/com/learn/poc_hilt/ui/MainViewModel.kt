package com.learn.poc_hilt.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.learn.poc_hilt.repo.MainRepository
import com.learn.poc_hilt.UserUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(var mainRepository: MainRepository) : ViewModel() {
    private var uiState: MutableStateFlow<UserUIState> = MutableStateFlow(UserUIState.Success(emptyList()))
    var _uiState = uiState

    fun fetchUserList() {
        viewModelScope.launch {
            mainRepository.fetch()
                .catch { exception ->
                    _uiState.value = UserUIState.Failure(exception)
                }
                .collect {
                    Log.i("---->", "User list:${it.userModelList} ")
                    _uiState.value = UserUIState.Success(it.userModelList)
                }
        }
    }

}