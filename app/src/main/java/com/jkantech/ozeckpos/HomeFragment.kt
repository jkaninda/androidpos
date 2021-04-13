package com.jkantech.ozeckpos

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jkantech.ozeckpos.activities.AboutActivity
import com.jkantech.ozeckpos.activities.PrintInvoiceActivity
import com.jkantech.ozeckpos.databinding.FragmentHomeBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.cardPrint.setOnClickListener {
            let {
                val intent=Intent(requireContext(),PrintInvoiceActivity::class.java)
                it.startActivity(intent)
            }
        }

        binding.cardAbout.setOnClickListener {
            let {
                val intent=Intent(requireContext(),AboutActivity::class.java)
                it.startActivity(intent)
            }
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}