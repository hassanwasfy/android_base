package com.deshanddezz.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

abstract class BaseViewModel<BaseUiState, BaseUiEffect>(
    uiState: BaseUiState, effect: ScreenEvents<BaseUiEffect>
) : ViewModel() {

    protected val _state: MutableStateFlow<BaseUiState> by lazy { MutableStateFlow(uiState) }
    val state: StateFlow<BaseUiState> by lazy { _state.asStateFlow() }

    protected val _event: MutableStateFlow<ScreenEvents<BaseUiEffect>> by lazy {
        MutableStateFlow(
            effect
        )
    }
    val event: StateFlow<ScreenEvents<BaseUiEffect>> by lazy { _event.asStateFlow() }

    protected fun <T> tryToExecute(
        call: suspend () -> T,
        onSuccess: (T) -> Unit,
        onError: (Throwable) -> Unit,
        dispatcher: CoroutineDispatcher = Dispatchers.IO
    ) {
        viewModelScope.launch(dispatcher) {
            try {
                call().also(onSuccess)
            } catch (throwable: Throwable) {
                onError(throwable)
            }
        }
    }

    protected fun <T> tryToExecuteSuspend(
        call: () -> T,
        onSuccess: suspend (T) -> Unit,
        onError: (Throwable) -> Unit,
        dispatcher: CoroutineDispatcher = Dispatchers.IO
    ) {
        viewModelScope.launch(dispatcher) {
            try {
                onSuccess(call.invoke())
            } catch (throwable: Throwable) {
                onError(throwable)
            }
        }
    }

    protected fun <T> collectFlow(
        flow: Flow<T>,
        updateState: BaseUiState.(T) -> BaseUiState
    ) {
        viewModelScope.launch {
            flow.collect { value ->
                _state.update { currentState ->
                    currentState.updateState(value)
                }
            }
        }
    }

}