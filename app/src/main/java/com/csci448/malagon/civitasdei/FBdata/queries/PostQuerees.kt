package com.csci448.malagon.civitasdei.FBdata.queries

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.csci448.malagon.civitasdei.FBdata.Church
import com.csci448.malagon.civitasdei.FBdata.NODE_CHURCHES
import com.csci448.malagon.civitasdei.FBdata.NODE_POSTS
import com.csci448.malagon.civitasdei.FBdata.Post
import com.google.firebase.database.*

class PostQuerees {

    private val dbPosts = FirebaseDatabase.getInstance().getReference(NODE_POSTS)

    private val _posts = MutableLiveData<List<Post>>()
    val posts: LiveData<List<Post>>
        get() = _posts


    private val _post  = MutableLiveData< Post >()
    val post :  LiveData< Post >
        get() = _post

    fun addPost(post: Post) {

        post.id = dbPosts.push().key.toString()
        dbPosts.child(post.id).setValue(post)

    }

    //TODO: For future this ensures faster speed on the app (Once we have a viewModel)
//    private val childEventListener = object : ChildEventListener{
//        override fun onCancelled(error: DatabaseError) {
//            TODO("Not yet implemented")
//        }
//
//
//        override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) {
//            TODO("Not yet implemented")
//        }
//
//        override fun onChildChanged(snapshot: DataSnapshot, previousChildName: String?) {
//            TODO("Not yet implemented")
//        }
//
//        //Only one being implemented
//        override fun onChildAdded(snapshot: DataSnapshot, previousChildName: String?) {
//            val post = snapshot.getValue(Post::class.java)
//            post?.id = snapshot.key.toString()
//            _post.value = post!!
//        }
//        override fun onChildRemoved(snapshot: DataSnapshot) {
//            TODO("Not yet implemented")
//        }
//
//
//    }

//    fun getRealTimeUpdates(){
//        dbPosts.addChildEventListener(childEventListener)
//    }

    fun fetchChurches(){
        dbPosts.addListenerForSingleValueEvent(object: ValueEventListener {


            override fun onDataChange(snapshot: DataSnapshot) {

                if(snapshot.exists()){

                    val tempPostList = mutableListOf<Post>()
                    for(churchSnapshot in snapshot.children){
                        val post = churchSnapshot.getValue(Post::class.java)

                        post?.id = churchSnapshot.key.toString()
                        post?.let { tempPostList.add(it) }


                    }
                    _posts.value = tempPostList
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })

    }


}