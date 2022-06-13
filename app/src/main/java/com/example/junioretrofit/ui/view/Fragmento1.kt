package com.example.junioretrofit.ui.view

import android.os.Bundle
import android.view.*
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.junioretrofit.R
import com.example.junioretrofit.databinding.FragmentFragmento1Binding


class Fragmento1 : Fragment() {
    private var _binding: FragmentFragmento1Binding? = null
    var ciudad:String = ""
    var fecha:String = ""
    var mascota:String = ""
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        _binding = DataBindingUtil.inflate( inflater,
            R.layout.fragment_fragmento1,
            container,
            false)
        val view = binding.root


        binding.button2.setOnClickListener{
            if(binding.textInputLayout.editText?.text.isNullOrEmpty() || binding.editTextDate.text.isNullOrEmpty() ||
                (!binding.radioButton.isChecked && !binding.radioButton2.isChecked)){
                    Toast.makeText(context,"No has completado todos los campos",Toast.LENGTH_SHORT).show()
            }else{
                ciudad = binding.spinner.selectedItem.toString()
                fecha = binding.editTextDate.text.toString()
                mascota = binding.textInputLayout.editText?.text.toString()
                val bundle = bundleOf("ciudad" to ciudad,
                                            "fecha" to fecha,
                                            "mascota" to mascota)
            findNavController().navigate(R.id.action_fragmento1_to_fragmento2, bundle)
            }
        }

        setHasOptionsMenu(true)

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