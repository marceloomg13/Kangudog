package com.example.junioretrofit.ui.view


import android.os.Bundle
import android.view.*
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.junioretrofit.R
import com.example.junioretrofit.databinding.FragmentFragmento2Binding
import com.example.junioretrofit.ui.viewmodel.GhibliViewModel

class Fragmento2 : Fragment() {
    private var _binding: FragmentFragmento2Binding? = null
    private val ghibliViewModel: GhibliViewModel by viewModels()
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var ciudad:String
    private lateinit var fecha:String
    private lateinit var mascota:String
    private lateinit var cuidador:String

    private var idActor:Int=0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        _binding = FragmentFragmento2Binding.inflate(inflater, container, false)
        arguments?.let {
            ciudad = it.getString("ciudad").toString()
            fecha = it.getString("fecha").toString()
            mascota = it.getString("mascota").toString()
        }
        if(ciudad.equals("Cadiz")){
            idActor=0
        }else if (ciudad.equals("San Fernando")){
            idActor=1
        }
        print(idActor)

        ghibliViewModel.onCreate(idActor)

        ghibliViewModel.GhibliModel.observe(viewLifecycleOwner, Observer{
            cuidador=it.name
            binding.name.text = "-Cuidador: "+it.name
            binding.age.text = "-Edad: "+it.age
            binding.gender.text = "-Género: "+it.gender
        })


        val view = binding.root
        binding.modificar.setOnClickListener {
            findNavController().navigate(R.id.action_fragmento2_to_fragmento1)
        }
        binding.button3.setOnClickListener{
            val bundle = bundleOf("ciudad" to ciudad,
                "fecha" to fecha,
                "mascota" to mascota,
                "cuidador" to cuidador)
            findNavController().navigate(R.id.action_fragmento2_to_fragmento3,bundle)
        }
        return view
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