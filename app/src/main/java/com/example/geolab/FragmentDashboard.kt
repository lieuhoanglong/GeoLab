package com.example.geolab

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import com.example.geolab.databinding.FragmentDashboardBinding
import com.google.firebase.auth.FirebaseAuth

class FragmentDashboard: Fragment(R.layout.fragment_dashboard) {

    private lateinit var binding: FragmentDashboardBinding

    private lateinit var auth: FirebaseAuth

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDashboardBinding.bind(view)

        auth = FirebaseAuth.getInstance()

        val logout_btn : CardView? = binding.logoutBtn

        if (logout_btn != null) {
            logout_btn.setOnClickListener {
                auth.signOut()
                (activity as TestFragmentActivity).showSignInFragment()
            }
        }
    }

}