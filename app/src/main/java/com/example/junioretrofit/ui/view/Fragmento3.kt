package com.example.junioretrofit.ui.view

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.junioretrofit.R
import com.example.junioretrofit.database.Cuidador
import com.example.junioretrofit.databinding.FragmentFragmento3Binding
import com.example.junioretrofit.ui.viewmodel.Fragmento3ViewModel

class Fragmento3 : Fragment() {
    private var _binding: FragmentFragmento3Binding? = null
    private lateinit var viewModel:Fragmento3ViewModel
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var ciudad:String
    private lateinit var fecha:String
    private lateinit var mascota:String
    private lateinit var cuidador:String

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        _binding = FragmentFragmento3Binding.inflate(inflater, container, false)
        val view = binding.root
        viewModel = ViewModelProvider(this).get(Fragmento3ViewModel::class.java)
        arguments?.let {
            ciudad = it.getString("ciudad").toString()
            fecha = it.getString("fecha").toString()
            mascota = it.getString("mascota").toString()
            cuidador = it.getString("cuidador").toString()
        }
        binding.ciudadTv.text = ciudad
        binding.cuidadorTv.text = cuidador
        binding.fechaTv.text = fecha
        binding.mascotaTv.text = mascota
        binding.button2.setOnClickListener {
            insert()
            findNavController().navigate(R.id.action_fragmento3_to_fragmento1)
        }
        return view
    }
    private fun insert(){
        val cuidador = Cuidador(0,mascota,fecha, localidad = ciudad, cuidador = cuidador)
        viewModel.add(cuidador)
        Toast.makeText(requireContext(),"Añadido con éxito",Toast.LENGTH_LONG).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.overflow_menu, menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }
}