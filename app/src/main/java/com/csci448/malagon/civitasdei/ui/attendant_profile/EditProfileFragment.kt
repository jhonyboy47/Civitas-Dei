package com.csci448.malagon.civitasdei.ui.attendant_profile

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.csci448.malagon.civitasdei.FBdata.Christian
import com.csci448.malagon.civitasdei.FBdata.NODE_CHRISTIANS
import com.csci448.malagon.civitasdei.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.edit_profile_fragment.*

class EditProfileFragment : Fragment() {

    companion object {
         private const val LOG_TAG = "EditProfileFragment"
    }

    private lateinit var viewModel: AttendantProfileViewModel
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(LOG_TAG, "onCreateView() called")

        viewModel = ViewModelProvider(this).get(AttendantProfileViewModel::class.java)
        firebaseAuth = FirebaseAuth.getInstance()

        val root = inflater.inflate(R.layout.edit_profile_fragment, container, false)

        val applyButton: Button = root.findViewById(R.id.edit_profile_apply_button)

        applyButton.setOnClickListener{
            Log.d(LOG_TAG, "Recognizing click")
            Navigation.findNavController(root).navigate(R.id.action_editProfileFragment_to_attendantProfileFragment)
         }

        return root
    }



    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Log.d(LOG_TAG, "onActivityCreated() called")
        super.onActivityCreated(savedInstanceState)

        viewModel.result.observe(viewLifecycleOwner, Observer {
            if (it == null) {
                Log.d(LOG_TAG, "Christian added succesfully")
            } else {

                Log.d(LOG_TAG, it.message.toString())
            }
        })






        //This should only be executed the first time a user signs in
        edit_profile_apply_button.setOnClickListener{

            Log.d(LOG_TAG, "Recognizing click")
            val name = full_name_edit_text.text.toString().trim()
            val church = church_edit_text.text.toString().trim()
            val favoriteVerse = favorite_verse_edit_text.text.toString().trim()


            //If one with the name of the user is not made make one
            val christian = Christian(firebaseAuth.currentUser.uid.toString(), name, favoriteVerse, church)

            viewModel.updateChristian(christian)


        }


     }

}