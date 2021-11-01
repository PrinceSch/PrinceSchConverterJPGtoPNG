package ru.princesch.princeschconverterjpgtopng.view

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binging = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == 1000) {
            imageUri = data?.data
            imageUri?.let { presenter.originalImageSelected(it) }
        }
    }

    override fun init() {
        hideProgressBar()
        hideErrorBar()
        btnStartConvertDisabled()
        btnAbortConvertDisabled()
        signGetStartedShow()
        signAbortConvertHide()
        signWaitingShow()
        binding.btnImageSelection.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/jpg"
            startActivityForResult(intent, 1000)
        }
        binding.btnStartConverting.setOnClickListener {
            imageUri?.let(presenter::startConvertingPressed)
        }
        binding.btnAbort.setOnClickListener {
            presenter.abortConvertImagePressed()
        }
    }

    override fun showOriginImage(uri: Uri) {
        binding.imgViewOriginal.setImageURI(uri)
    }

    override fun showConvertedImage(uri: Uri) {
        binding.imgViewConvertedImg.setImageURI(uri)
    }

    override fun showProgressBar() {
        binding.progressBar2.visibility = View.VISIBLE
    }

    override fun hideProgressBar() {
        binding.progressBar2.visibility = View.GONE
    }

    override fun showErrorBar() {
        binding.imgViewConvertedImg.setImageURI(null)
        binding.imgViewErrorSign.visibility = View.VISIBLE
    }

    override fun hideErrorBar() {
        binding.imgViewErrorSign.visibility = View.GONE
    }

    override fun btnStartConvertEnable() {
        binding.btnStartConverting.isEnabled = true
    }

    override fun btnStartConvertDisabled() {
        binding.btnStartConverting.isEnabled = false
    }

    override fun btnAbortConvertEnabled() {
        binding.btnAbort.isEnabled = true
    }

    override fun btnAbortConvertDisabled() {
        binding.btnAbort.isEnabled = false
    }

    override fun signAbortConvertShow() {
        binding.imgViewConvertedImg.setImageURI(null)
        binding.imgViewCancelSign.visibility = View.VISIBLE
    }

    override fun signAbortConvertHide() {
        binding.imgViewCancelSign.visibility = View.GONE
    }

    override fun signGetStartedShow() {
        binding.imgViewGetStartedSign.visibility = View.VISIBLE
    }

    override fun signGetStartedHide() {
        binding.imgViewGetStartedSign.visibility = View.GONE
    }

    override fun signWaitingShow() {
        binding.imgViewConvertedImg.setImageURI(null)
        binding.imgViewWaitingSign.visibility = View.VISIBLE
    }

    override fun signWaitingHide() {
        binding.imgViewWaitingSign.visibility = View.GONE
    }
}
