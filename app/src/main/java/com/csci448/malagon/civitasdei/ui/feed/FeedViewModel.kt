package com.csci448.malagon.civitasdei.ui.feed

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.csci448.malagon.civitasdei.FBdata.NODE_POSTS
import com.csci448.malagon.civitasdei.FBdata.Post
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.ktx.Firebase
import java.lang.Exception

class FeedViewModel : ViewModel() {

    private val _result = MutableLiveData<Exception?>()
    val result: LiveData<Exception?>
        get() = _result


    private val dbPosts = FirebaseDatabase.getInstance().getReference(NODE_POSTS)


    private val _posts = MutableLiveData<List<Post>>()

    val posts: LiveData<List<Post>>
        get() = _posts


    private val _post = MutableLiveData<Post>()

    val post: LiveData<Post>
        get() = _post


    fun fetchPosts(){
        dbPosts.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {

                if(snapshot.exists()){
                    val posts = mutableListOf<Post>()
                    for (snap in snapshot.children) {

                        val post = snap.getValue(Post::class.java)
                        post?.id = snap.key.toString()
                        post.let {
                            if (it != null) {
                                posts.add(it)
                            }
                        }
                    }
                    _posts.value = posts
                }


            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }


        })
    }
}