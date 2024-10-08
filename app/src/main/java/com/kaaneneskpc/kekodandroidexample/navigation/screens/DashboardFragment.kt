package com.kaaneneskpc.kekodandroidexample.navigation.screens

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.kaaneneskpc.R


class DashboardFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val dashboardButton = view.findViewById<Button>(R.id.dashboardButton)  // fragmentlar direkt findViewById func sahip değiller activitylerin aksine
        val dialogButton = view.findViewById<Button>(R.id.dialogButton)
        val activityButton = view.findViewById<Button>(R.id.activityButton)
        dashboardButton.setOnClickListener {
            findNavController().navigate(R.id.action_dashboardFragment_to_profileFragment)
        }
        dialogButton.setOnClickListener {
            findNavController().navigate(R.id.action_dashboardFragment_to_settingsDialogFragment)
        }
        activityButton.setOnClickListener {
            val userId = 123
            val deepLinkUri = Uri.parse("https://www.example.com/profile/$userId")
            findNavController().navigate(deepLinkUri)
        }
    }
}