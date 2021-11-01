package ru.princesch.princeschconverterjpgtopng.view

import android.net.Uri
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface MainView : ProgressView, ErrorView, MvpView {
    fun init()
    fun showOriginImage(uri: Uri)
    fun showConvertedImage(uri: Uri)
    fun btnStartConvertEnable()
    fun btnStartConvertDisabled()
    fun btnAbortConvertEnabled()
    fun btnAbortConvertDisabled()
    fun signAbortConvertShow()
    fun signAbortConvertHide()
    fun signGetStartedShow()
    fun signGetStartedHide()
    fun signWaitingShow()
    fun signWaitingHide()
}

@StateStrategyType(AddToEndSingleStrategy::class)
interface ProgressView {
    fun showProgressBar()
    fun hideProgressBar()
}

@StateStrategyType(AddToEndSingleStrategy::class)
interface ErrorView {
    fun showErrorBar()
    fun hideErrorBar()
}