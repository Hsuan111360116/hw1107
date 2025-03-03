package com.example.lab5

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


class FirstFragment : Fragment() {

    private fun logLifecycle(methodName: String) {
        Log.e("FirstFragment", methodName)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context);logLifecycle("onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);logLifecycle("onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        logLifecycle("onCreateView")
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState);logLifecycle("onViewCreated")
    }

    override fun onStart() {
        super.onStart();logLifecycle("onStart")
    }

    override fun onResume() {
        super.onResume();logLifecycle("onResume")
    }

    override fun onPause() {
        super.onPause();logLifecycle("onPause")
    }

    override fun onStop() {
        super.onStop();logLifecycle("onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView();logLifecycle("onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy();logLifecycle("onDestroy")
    }

    override fun onDetach() {
        super.onDetach();logLifecycle("onDetach")
    }
}