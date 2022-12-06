package com.example.gastoviagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.gastoviagem.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonCalculate.setOnClickListener(this)

    }
    /*
    * Função responsavel por fazer a função da Activity
    * */
    override fun onClick(view: View){
        if (view.id == R.id.button_calculate) {
            calculate()
        }
    }

    /*
    * Função responsavel por fazer qualquer evento de click nos elementos
    * */
    private fun isValue(): Boolean {
        return (binding.editDistance.text.toString() != ""
                &&  binding.editPrice.text.toString() != ""
                && binding.editAutonomy.text.toString() != ""
                && binding.editAutonomy.text.toString().toFloat() != 0f)
    }

    private fun calculate() {

        if (isValue()) {
            val distance = binding.editDistance.text.toString().toFloat()
            val price = binding.editPrice.text.toString().toFloat()
            val autonomy = binding.editAutonomy.text.toString().toFloat()

            val valorTotal = (distance * price) / autonomy
            binding.textTotalValue.text = "R$ ${"%.2f".format(valorTotal)}"
        } else {
            Toast.makeText(this, R.string.validation_fill_all_fields, Toast.LENGTH_SHORT).show()
        }

        // Toast notification
        //Toast.makeText(this, totalValueStr, Toast.LENGTH_SHORT).show()
    }
}