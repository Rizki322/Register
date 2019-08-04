package com.example.registeractivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    var editName : EditText? = null
    var SpinnerGender : Spinner? = null
    var editEmail : EditText? = null
    var editTelp : EditText? = null
    var editAlamat : EditText? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editName = findViewById(R.id.Editname)
        SpinnerGender = findViewById(R.id.spinnergender)
        editEmail = findViewById(R.id.Email)
        editTelp = findViewById(R.id.Telp)
        editAlamat = findViewById(R.id.Alamat)

        button.setOnClickListener{
         validasiinput()
        }
        setDataSpinner()

    }
    fun setDataSpinner(){
        val adapter = ArrayAdapter.createFromResource(this,R.array.gender_list,android.R.layout.simple_spinner_item)

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        SpinnerGender?.adapter = adapter
    }



    fun validasiinput(){
        val namaInput :String = editName?.text.toString()
        val emailInput :String = editEmail?.text.toString()
        val telpInput :String = editTelp?.text.toString()
        val alamatInput :String = editAlamat?.text.toString()
        val genderInput : String = SpinnerGender?.selectedItem.toString()

        when  {

            genderInput.equals("Pilih jenis kelamin") ->
                Toast.makeText(this,"Data valid",Toast.LENGTH_SHORT).show()
            namaInput.isEmpty() -> editName?.error = "Nama belom diisi"
            emailInput.isEmpty() -> editAlamat?.error = "Email belom diisi"
            telpInput.isEmpty() -> editTelp?.error = "Nomer Telepon belom diisi"
            alamatInput.isEmpty() -> editAlamat?.error = "Alamat belom diisi"

            else ->{
                Toast.makeText(this,"Data valid",Toast.LENGTH_SHORT).show()
            }
        }
    }
}
