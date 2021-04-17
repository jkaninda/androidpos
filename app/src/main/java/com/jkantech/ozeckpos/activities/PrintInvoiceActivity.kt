package com.jkantech.ozeckpos.activities

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.ahmedelsayed.sunmiprinterutill.PrintMe
import com.jkantech.ozeckpos.R
import com.jkantech.ozeckpos.databinding.ActivityPrintInvoiceBinding
import com.jkantech.ozeckpos.utils.DateUtils
import com.jkantech.ozeckpos.utils.showToast
import kotlinx.coroutines.launch
import java.util.*

class PrintInvoiceActivity : AppCompatActivity() {
    private lateinit var printMe:PrintMe
    private lateinit var bindig: ActivityPrintInvoiceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindig= ActivityPrintInvoiceBinding.inflate(layoutInflater)
        setContentView(bindig.root)
        title="Facturation"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        printMe = PrintMe(this)

        bindig.printBtn.setOnClickListener {
            when{
                bindig.editName.editText?.text.toString() =="" ->showToast(this,"Veuillez entrer le nom du client")
                bindig.editProduct.editText?.text.toString() == "" ->showToast(this,"Veuillez entrer le nom de l'article")
                bindig.editSalePrice.editText?.text.toString() == "" ->showToast(this,"Veuillez entrer le prix de vente")
                bindig.editQty.editText?.text.toString() == "" ->showToast(this,"Veuillez entrer la quantité")
                else->printInvoice()
            }
        }




    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }


    @SuppressLint("UseCompatLoadingForDrawables")
    private fun printInvoice() {
        lifecycleScope.launch {

            printMe.sendTextToPrinter("Ets Ozeck Business 2", 35F, true, false, 1)
            printMe.sendImageToPrinter(
                printMe.convertDrawableToBitmap(
                    getDrawable(R.drawable.logo),
                    100,
                    40
                )
            )
            printMe.sendTextToPrinter(" Vente des téléphones cellulaire", 25F, false, false, 1)
            printMe.sendTextToPrinter(" NIF : A1706298Q", 25F, false, false, 1)
            printMe.sendTextToPrinter(" Nº31, Boulevard Kamanyola,   C/Likasi", 25F, false, false, 1)
            printMe.sendTextToPrinter(" Tél: 0978088622 - 0812146485", 25F, false, false, 1)

            //printMe.sendTextToPrinter("Contact@ozeckbusiness.com",20F,true,false,1)
            printMe.sendTextToPrinter(" Contact@ozeckbusiness.com", 25F, false, false, 1)
            printMe.sendTextToPrinter("www.ozeckbusiness.com", 25F, false, false, 1)
            printMe.sendTextToPrinter("============================", 25F, true, false, 1)
            printMe.sendTextToPrinter(
                "Date: ${
                    DateUtils.formatDate(DateUtils.now(), "yyyy-MM-dd HH:mm:ss", "dd/MM/yyyy HH:mm:ss",
                        Locale.FRANCE
                    )
                }", 25F, false, false, 1
            )
            printMe.sendTextToPrinter("Facture No.: 00", 25F, false, false, 1)
            printMe.sendTextToPrinter("Nom client : ${bindig.editName.editText?.text.toString()}", 25F, false, false, 1)
            printMe.sendTextToPrinter("*****************************", 25F, true, false, 1)
            printMe.sendTextToPrinter("Désignation : ${bindig.editProduct.editText?.text.toString()}", 25F, false, false, 1)
            printMe.sendTextToPrinter("Quantités :  ${bindig.editQty.editText?.text.toString()}", 25F, false, false, 1)
            printMe.sendTextToPrinter("Prix unitaire :  ${bindig.editSalePrice.editText?.text.toString()} Fc", 25F, false, false, 1)
            printMe.sendTextToPrinter("Prix Total :  ${bindig.editSalePrice.editText?.text.toString().toInt() * bindig.editQty.editText?.text.toString().toInt()} Fc", 30F, true, false, 1)
            printMe.sendTextToPrinter("", 25F, true, false, 1)
            printMe.sendTextToPrinter("*****************************", 25F, true, false, 1)
            printMe.sendTextToPrinter("La garantie du téléphone est de 4 jours. ", 25F, true, false, 1)
            printMe.sendTextToPrinter("Gardez bien le téléphone.", 25F, true, false, 1)
            printMe.sendTextToPrinter("NB: Pas de réclamation sans facture !!", 25F, true, false, 1)
            printMe.sendTextToPrinter("", 25F, true, false, 1)
            printMe.sendTextToPrinter(
                "Merci d'avoir payer chez nous & nous sommes impatients de vous servir à nouveau!",
                25F,
                true,
                false,
                1
            )
            printMe.sendTextToPrinter("******** "+getString(R.string.powered_by_jkantech)+" *********", 15F, false, false, 1)
            printMe.sendTextToPrinter("", 25F, true, false, 1)
            printMe.sendTextToPrinter("", 30F, true, false, 2)
            //printMe.aidlUtil.printBarCode(product_name,8,30,150,1)




        }
    }



}