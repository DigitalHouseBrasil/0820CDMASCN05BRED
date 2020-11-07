package com.digitalhouse.aula29navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat

class SegundoFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_segundo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.txtNome).text =
            arguments?.getString(DetalheFragment.KEY_NOME)

        val avatarId = arguments?.getInt(DetalheFragment.KEY_IMAGE)

        if (avatarId != null) {
            val avatarDrawable = ContextCompat.getDrawable(view.context, avatarId);

            view.findViewById<ImageView>(R.id.imgAvatar)
                .setImageDrawable(avatarDrawable)
        }
    }
}