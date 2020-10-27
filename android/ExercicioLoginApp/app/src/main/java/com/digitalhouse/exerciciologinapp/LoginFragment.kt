package com.digitalhouse.exerciciologinapp

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doOnTextChanged
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class LoginFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        view.findViewById<MaterialButton>(R.id.btnLogin).setOnClickListener {
            if (validaEntradas(view)) {
                Toast.makeText(view.context, "Login realizado", Toast.LENGTH_LONG).show()
            }
        }

        view.findViewById<TextInputEditText>(R.id.editTextUserNameLogin).addTextChangedListener(object :
            TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                view.findViewById<TextInputLayout>(R.id.txtUserNameLogin).error = ""
            }
        })

        view.findViewById<TextInputEditText>(R.id.editTextPasswordLogin).addTextChangedListener(object :
            TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                view.findViewById<TextInputLayout>(R.id.txtPasswordLogin).error = ""
            }
        })

        return view
    }

    fun validaEntradas(view: View): Boolean {
        var resultado = true

        val edtUserName = view.findViewById<TextInputEditText>(R.id.editTextUserNameLogin)
        val edtPassword = view.findViewById<TextInputEditText>(R.id.editTextPasswordLogin)

        if (edtUserName.text?.trim()!!.isBlank()) {
            view.findViewById<TextInputLayout>(R.id.txtUserNameLogin).error = "Username Vazio"
            resultado = false
        }

        if (edtPassword.text?.trim()!!.isBlank()) {
            view.findViewById<TextInputLayout>(R.id.txtPasswordLogin).error = "Password Vazio"
            resultado = false
        }

        return resultado
    }
}