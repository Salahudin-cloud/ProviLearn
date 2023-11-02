package com.example.provilearn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.provilearn.data.Provinsi
import com.example.provilearn.databinding.ActivityListProvinsiBinding

class ListProvinsi : AppCompatActivity() {

    private lateinit var binding: ActivityListProvinsiBinding
    private val list = ArrayList<Provinsi>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListProvinsiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.listViewRecyler.setHasFixedSize(true)

        actionBar?.setDisplayHomeAsUpEnabled(true)

        list.addAll(getListProvince())
        showRecyclerList()
    }

    private fun showRecyclerList() {
        binding.listViewRecyler.layoutManager = LinearLayoutManager(this)
        val provinsiAdapter = ProvinceAdapter(list)
        binding.listViewRecyler.adapter = provinsiAdapter

       provinsiAdapter.setOnItemClickCallback(object : ProvinceAdapter.OnItemClickCallback {
           override fun onItemClicked(data: Provinsi) {
               showSelectedHero(data)
           }
       })
    }

    private fun getListProvince(): ArrayList<Provinsi> {
        val dataNamaProvinsi = resources.getStringArray(R.array.data_nama_provinsi)
        val dataLogoProvinsi = resources.getStringArray(R.array.data_logo_provinsi)
        val dataNamaIbuKota = resources.getStringArray(R.array.data_nama_ibu_kota_provinsi)
        val dataLuasProvinsi = resources.getStringArray(R.array.data_luas_provinsi)
        val dataTotalPenduduk = resources.getStringArray(R.array.data_total_penduduk)
        val dataDeskripsiProvinsi = resources.getStringArray(R.array.data_deskripsi_provinsi)

        val listProvinsi = ArrayList<Provinsi>()
        for (i in dataNamaProvinsi.indices) {
            val prov = Provinsi(dataNamaProvinsi[i], dataLogoProvinsi[i], dataNamaIbuKota[i], dataLuasProvinsi[i],
                dataTotalPenduduk[i],dataDeskripsiProvinsi[i] )
            listProvinsi.add(prov)
        }

        return listProvinsi

    }

    private fun showSelectedHero(provinsi: Provinsi) {
        Toast.makeText(this, "Kamu memilih " + provinsi.namaProvinsi, Toast.LENGTH_SHORT).show()
    }
}