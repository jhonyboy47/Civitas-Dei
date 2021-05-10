package com.csci448.malagon.civitasdei.ui.map

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.maps.SupportMapFragment

class MapFragment : SupportMapFragment() {
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val mapView = super.onCreateView(inflater,
            container,
            savedInstanceState)
        return mapView
    }
}