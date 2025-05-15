package com.sebnem.kisileruygulamasi.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.sebnem.kisileruygulamasi.databinding.FragmentKisiKayitBinding
import com.sebnem.kisileruygulamasi.ui.viewmodel.KisiKayitViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class KisiKayitFragment : Fragment() {
    private lateinit var binding: FragmentKisiKayitBinding
    private lateinit var viewModel: KisiKayitViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentKisiKayitBinding.inflate(inflater, container, false)

        binding.buttonKaydet.setOnClickListener {
            val kisi_ad = binding.editTextKisiAd.text.toString()
            val kisi_tel = binding.editTextKisiTel.text.toString()
            viewModel.kaydet(kisi_ad,kisi_tel)

        }

        return binding.root


    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: KisiKayitViewModel by viewModels()
        viewModel = tempViewModel
    }


}