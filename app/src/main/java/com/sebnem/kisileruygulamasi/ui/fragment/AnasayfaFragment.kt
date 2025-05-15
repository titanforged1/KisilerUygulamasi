package com.sebnem.kisileruygulamasi.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.sebnem.kisileruygulamasi.R
import com.sebnem.kisileruygulamasi.data.entity.Kisiler
import com.sebnem.kisileruygulamasi.databinding.FragmentAnasayfaBinding
import com.sebnem.kisileruygulamasi.ui.adapter.KisilerAdapter
import com.sebnem.kisileruygulamasi.ui.viewmodel.AnasayfaViewModel
import com.sebnem.kisileruygulamasi.utils.gecisYap
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnasayfaFragment : Fragment() {
    private lateinit var binding: FragmentAnasayfaBinding
   private lateinit var viewModel: AnasayfaViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAnasayfaBinding.inflate(inflater, container, false)

        binding.fab.setOnClickListener {
            //Navigation.findNavController(it).navigate(R.id.kisiKayitGecis)
            Navigation.gecisYap(it,R.id.kisiKayitGecis)
        }

        viewModel.kisilerListesi.observe(viewLifecycleOwner) {//dinleme
            val kisilerAdapter = KisilerAdapter(requireContext(),it,viewModel)
            binding.kisilerRv.adapter = kisilerAdapter
        }

        binding.kisilerRv.layoutManager = LinearLayoutManager(requireContext())

        // ----Yatayda Görüntüleme----
        //binding.kisilerRv.layoutManager = StaggerGridLayoutManager(1,StaggerGridLayoutManager.VERTICAL)
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String): Boolean {
                //harf girdikçe ve sildikçe
                viewModel.ara(newText)
                return true
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                //ara butonuna basılınca
                viewModel.ara(query)
                return true
            }
        })
        return binding.root
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: AnasayfaViewModel by viewModels()
        viewModel = tempViewModel
    }
//data binding çok kullanılmıyor 

    override fun onResume() {
        super.onResume()
        Log.e("Kişi Anasayfaya", "Dönüldü")
    }
}



