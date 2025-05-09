package com.sebnem.kisileruygulamasi.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.sebnem.kisileruygulamasi.R
import com.sebnem.kisileruygulamasi.data.entity.Kisiler
import com.sebnem.kisileruygulamasi.databinding.FragmentAnasayfaBinding
import com.sebnem.kisileruygulamasi.ui.adapter.KisilerAdapter


class AnasayfaFragment : Fragment() {
    private lateinit var binding: FragmentAnasayfaBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAnasayfaBinding.inflate(inflater, container, false)

        binding.fab.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.kisiKayitGecis)
        }

        val kisilerListesi = ArrayList<Kisiler>()
        val k1 = Kisiler(1, "Ahmet", "0000")
        val k2 = Kisiler(1, "Merve", "1212")
        val k3 = Kisiler(1, "Furkan", "9898")
        kisilerListesi.add(k1)
        kisilerListesi.add(k2)
        kisilerListesi.add(k3)
        val kisilerAdapter = KisilerAdapter(requireContext(), kisilerListesi)
        binding.kisilerRv.adapter = kisilerAdapter
        binding.kisilerRv.layoutManager = LinearLayoutManager(requireContext())

        // ----Yatayda Görüntüleme----
        //binding.kisilerRv.layoutManager = StaggerGridLayoutManager(1,StaggerGridLayoutManager.VERTICAL)
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String): Boolean {
                //harf girdikçe ve sildikçe
                ara(newText)
                return true
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                //ara butonuna basılınca
                ara(query)
                return true
            }
        })
        return binding.root
    }

    fun ara(aramKelimesi: String) {
        Log.e("Kişi Ara", aramKelimesi)
    }

    override fun onResume() {
        super.onResume()
        Log.e("ERROR ON ANASAYFA", "Kişi Anasayfaya Dönüldü")
    }
}



