package ru.princesch.princeschconverterjpgtopng.view

import android.net.Uri
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.princesch.princeschconverterjpgtopng.databinding.MainFragmentBinding
import ru.princesch.princeschconverterjpgtopng.model.ConverterJpgToPng
import ru.princesch.princeschconverterjpgtopng.model.MySchedulersFactory
import ru.princesch.princeschconverterjpgtopng.presenter.MainFragmentPresenter

class MainFragment: MvpAppCompatFragment(), MainView {

    private var _binging: MainFragmentBinding? = null
    private val binding get() = _binging!!
    private var imageUri: Uri? = null
    private val presenter: MainFragmentPresenter by moxyPresenter {
        MainFragmentPresenter(
            ConverterJpgToPng(requireContext()),
            MySchedulersFactory.create())
    }



    override fun init() {
        TODO("Not yet implemented")
    }

    override fun showOriginImage(uri: Uri) {
        TODO("Not yet implemented")
    }

    override fun showConvertedImage(uri: Uri) {
        TODO("Not yet implemented")
    }

    override fun btnStartConvertEnable() {
        TODO("Not yet implemented")
    }

    override fun btnStartConvertDisabled() {
        TODO("Not yet implemented")
    }

    override fun btnAbortConvertEnabled() {
        TODO("Not yet implemented")
    }

    override fun btnAbortConvertDisabled() {
        TODO("Not yet implemented")
    }

    override fun signAbortConvertShow() {
        TODO("Not yet implemented")
    }

    override fun signAbortConvertHide() {
        TODO("Not yet implemented")
    }

    override fun signGetStartedShow() {
        TODO("Not yet implemented")
    }

    override fun signGetStartedHide() {
        TODO("Not yet implemented")
    }

    override fun signWaitingShow() {
        TODO("Not yet implemented")
    }

    override fun signWaitingHide() {
        TODO("Not yet implemented")
    }

    override fun showProgressBar() {
        TODO("Not yet implemented")
    }

    override fun hideProgressBar() {
        TODO("Not yet implemented")
    }

    override fun showErrorBar() {
        TODO("Not yet implemented")
    }

    override fun hideErrorBar() {
        TODO("Not yet implemented")
    }


}
