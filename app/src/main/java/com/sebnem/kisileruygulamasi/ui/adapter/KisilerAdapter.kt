package com.sebnem.kisileruygulamasi.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.sebnem.kisileruygulamasi.data.entity.Kisiler
import com.sebnem.kisileruygulamasi.databinding.CardTasarimBinding
import com.sebnem.kisileruygulamasi.databinding.FragmentAnasayfaBinding
import com.sebnem.kisileruygulamasi.ui.fragment.AnasayfaFragmentDirections

//context: hangi sayfada olduğumuz belirten nesne
class KisilerAdapter(val mContext : Context,var kisilerListesi: List<Kisiler>)
    : RecyclerView.Adapter<KisilerAdapter.CardTasarimTutucu>() {

    inner class CardTasarimTutucu(var tasarım : CardTasarimBinding): RecyclerView.ViewHolder(tasarım.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val tasarım = CardTasarimBinding.inflate(LayoutInflater.from(mContext),parent, false)
        return CardTasarimTutucu(tasarım)
    }

    override fun getItemCount(): Int {

return kisilerListesi.size
    }
    fun sil(kisi_id: Int){
        Log.e("Kişi Sİl",kisi_id.toString())
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
       val kisi = kisilerListesi.get(position)
       val t = holder.tasarım
        t.textViewKisiAd.text = kisi.kisi_ad
        t.textViewKisiTel.text = kisi.kisi_tel

        t.cardViewSatir.setOnClickListener{
            val gecis = AnasayfaFragmentDirections.kisiDetayGecis(kisi = kisi)
            Navigation.findNavController(it).navigate(gecis)

        }
        t.imageViewSil.setOnClickListener{
Snackbar.make(it,"${kisi.kisi_ad}  silinsin mi?", Snackbar.LENGTH_SHORT )
    .setAction("EVET"){
        sil(kisi.kisi_id)

    }.show()
        }
    }
}