package com.example.dora.vm

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.DividerItemDecoration
import dora.brvah.BaseAdapter
import dora.util.GlobalContext
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

open class BaseViewModel : ViewModel() {

    var listDecoration = ObservableField<DividerItemDecoration>()
    var adapter = ObservableField<BaseAdapter<*, *>>()
    var viewState = ObservableField<ViewState>()
    private val disposable: CompositeDisposable by lazy { CompositeDisposable() }

    init {
        listDecoration.set(DividerItemDecoration(GlobalContext.get(), DividerItemDecoration.VERTICAL))
    }

    fun setLoading() {
        viewState.set(ViewState.LOADING)
    }

    fun setSuccess() {
        viewState.set(ViewState.SUCCESS)
    }

    fun setError() {
        viewState.set(ViewState.ERROR)
    }

    fun setEmpty() {
        viewState.set(ViewState.EMPTY)
    }

    protected inline fun <T> apiReq(
        observable: Observable<T>,
        crossinline onSuccess: (T) -> Unit,
        crossinline onError: (Throwable) -> Unit
    ) {
        addDisposable(
            observable.subscribe(
                { result -> onSuccess(result) },
                { error -> onError(error) }
            )
        )
    }

    protected inline fun <T, reified R : Any> apiReq(
        observable1: Observable<T>,
        observable2: Observable<T>,
        mergeType: MergeType,
        crossinline onSuccess: (R) -> Unit,
        crossinline onError: (Throwable) -> Unit,
        noinline combine: (T, T) -> R
    ) {
        val combinedObservable = when (mergeType) {
            MergeType.MERGE -> Observable.merge(observable1, observable2)
            MergeType.COMBINE_LATEST -> Observable.combineLatest(observable1, observable2, combine)
            MergeType.ZIP -> observable1.zipWith(observable2, combine)
        }
        addDisposable(
            combinedObservable.subscribe(
                { result ->
                    onSuccess(result as R)
                },
                { error ->
                    onError(error)
                }
            )
        )
    }

    protected inline fun <T> apiReq(
        crossinline block: suspend () -> T,
        crossinline onSuccess: (T) -> Unit,
        crossinline onError: (Throwable) -> Unit
    ) {
        viewModelScope.launch {
            try {
                val result = withContext(Dispatchers.IO) { block() }
                onSuccess(result)
            } catch (e: Throwable) {
                onError(e)
            }
        }
    }

    protected fun addDisposable(d: Disposable) {
        disposable.add(d)
    }

    private fun dispose() {
        disposable.dispose()
    }

    override fun onCleared() {
        super.onCleared()
        dispose()
    }

    enum class MergeType {
        MERGE,
        COMBINE_LATEST,
        ZIP
    }

    enum class ViewState {
        LOADING,
        SUCCESS,
        ERROR,
        EMPTY
    }
}