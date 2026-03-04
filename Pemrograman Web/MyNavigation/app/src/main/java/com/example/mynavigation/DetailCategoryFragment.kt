package com.example.mynavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.mynavigation.databinding.FragmentDetailCategoryBinding
import androidx.navigation.fragment.navArgs

class DetailCategoryFragment : Fragment() {

    private var _binding: FragmentDetailCategoryBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate layout menggunakan View Binding
        _binding = FragmentDetailCategoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Mengambil argumen menggunakan Safe Args (Pastikan plugin safeargs sudah aktif di build.gradle)
        val args: DetailCategoryFragmentArgs by navArgs()

        val dataName = args.name
        val dataDescription = args.stock

        // Menampilkan data ke TextView yang ada di layout
        binding.tvCategoryName.text = dataName
        binding.tvCategoryDescription.text = "Stock : $dataDescription"
        binding.btnHome.setOnClickListener (
            Navigation.createNavigateOnClickListener(R.id.action_detailCategoryFragment_to_homeFragment)
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        // Membersihkan binding untuk menghindari memory leak
        _binding = null
    }
}