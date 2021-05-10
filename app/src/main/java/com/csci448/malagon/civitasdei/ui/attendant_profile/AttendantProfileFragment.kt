package com.csci448.malagon.civitasdei.ui.attendant_profile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.bumptech.glide.Glide
import com.csci448.malagon.civitasdei.LogInActivity
import com.csci448.malagon.civitasdei.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.fragment_attendant_profile.*

/**
 * Author: Jeremiah Navarro
 * March 13, 2021
 *
 * Fragment for the attendant_profile page of a church attendant
 */
class AttendantProfileFragment: Fragment() {

//    val args: AttendantProfileFragmentArgs by navArgs()

    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var viewModel: AttendantProfileViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        firebaseAuth = FirebaseAuth.getInstance()
        val currentUser = firebaseAuth.currentUser


        viewModel = ViewModelProvider(this).get(AttendantProfileViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_attendant_profile, container, false)
        val nameTextView: TextView = root.findViewById(R.id.post_title_tv)
        val logOutButton: Button = root.findViewById(R.id.log_out_button)
        val profilePicture: ImageView = root.findViewById(R.id.profile_picture_image_view)
        val editProfile: Button = root.findViewById(R.id.edit_profile_button)
        val bio: TextView = root.findViewById(R.id.favorite_verse_text_view)

        //This is for profile picture sinced with google picture
        Glide.with(this).load(currentUser?.photoUrl).into(profilePicture);


        updateUI(currentUser)


        editProfile.setOnClickListener {

            val action = AttendantProfileFragmentDirections.actionAttendantProfileFragmentToEditProfileFragment()
            Navigation.findNavController(root).navigate(action)
        }


        logOutButton.setOnClickListener {
            //Signs us out
            firebaseAuth.signOut()
            val intent = Intent(this.context,  LogInActivity::class.java)
            startActivity(intent)
        }



        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val currentUser = firebaseAuth.currentUser

        updateUI(currentUser)


    }

    private fun updateUI(currentUser: FirebaseUser?) {
        viewModel.fetchChristians()
        viewModel.christians.observe(viewLifecycleOwner, Observer {

            for (christian in it) {

                //User id is what is being used here to find unique
                if (christian.id == currentUser?.uid.toString()) {

                    favorite_verse_text_view.setText(christian.favoriteVerse.toString())
                    post_content.setText("Attends: ${christian.church}")
                    post_title_tv.setText(christian.name)

                }
            }

            //            favorite_verse_text_view.text =     ("We are testing herrre")

        })
    }


}