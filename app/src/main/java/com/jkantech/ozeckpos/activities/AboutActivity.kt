package com.jkantech.ozeckpos.activities

import android.annotation.SuppressLint
import android.content.*
import android.os.Bundle
import android.preference.PreferenceManager
import android.telephony.PhoneNumberUtils
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.jkantech.ozeckpos.utils.DateUtils
import com.jkantech.ozeckpos.BuildConfig
import com.jkantech.ozeckpos.R
import java.text.SimpleDateFormat
import java.util.*


/**
 * Created by Jonas Kaninda on 10/07/2020.
 */
class AboutActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var prefs: SharedPreferences
    lateinit var app_version:TextView
    lateinit var build_date:TextView

    lateinit var back:ImageView
    lateinit var feedback:Button
    @SuppressLint("SetTextI18n", "SimpleDateFormat")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        prefs= PreferenceManager.getDefaultSharedPreferences(this)

        setContentView(R.layout.activity_about)
        feedback=findViewById(R.id.feedback)
        app_version=findViewById(R.id.app_version)
        build_date=findViewById(R.id.build_date)
        back=findViewById(R.id.back)

      //  source_code_btn.setOnClickListener(this)
        val versionCode:Int= BuildConfig.VERSION_CODE
        val versionName:String=BuildConfig.VERSION_NAME
        app_version.text= "Version: $versionName ($versionCode)"
        feedback.setOnClickListener(this)

        back.setOnClickListener(this)

         val buildDate = Date(BuildConfig.BUILD_DATE)
        //Build date: 20210209_2105
        val formatter = SimpleDateFormat("yyyy-MM-dd-hh-mm-ss")
        val time = formatter.format(buildDate).toString()
        build_date.text="Build date: ${DateUtils.formatDate(time,"yyyy-MM-dd-hh-mm-ss","yyyyMMdd_hh:mm", Locale.ENGLISH)} "


    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onClick(view: View) {
        when (view.id) {
            /*
            R.id.dev_fb_btn -> {
                val browserIntent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://www.facebook.com/jkantech")
                )
                startActivity(browserIntent)
            }
            R.id.dev_mail_btn -> {
                val intent = Intent(
                    Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto", "contact.jkantech@gmail.com", null
                    )

                )
                val subject: String? = null
                intent.putExtra(Intent.EXTRA_SUBJECT, subject)
                val message: String? = null
                intent.putExtra(Intent.EXTRA_TEXT, message)
                startActivity(Intent.createChooser(intent, ""))
            }
            R.id.dev_gitub_btn -> {
                val githublien = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://www.github.com/jkantech")
                )
                startActivity(githublien)
            }
            R.id.dev_whatsapp_btn -> {
                val whatssap = Intent("android.intent.action.Main")
                whatssap.component = ComponentName("com.whatsapp", "com.whatsapp.Conversation")
                val stringBuilder = StringBuilder()
                stringBuilder.append(PhoneNumberUtils.stripSeparators("243892390948"))
                stringBuilder.append("@s.whatsapp.net")
                whatssap.putExtra("jid", stringBuilder.toString())
                startActivity(whatssap)
            }
            /*
            R.id.source_code_btn->{
                val githublien = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://www.github.com/jkantech/jadonotes")
                )
                startActivity(githublien)
            }

             */

             */



            R.id.feedback ->{
                val whatssap = Intent("android.intent.action.Main")
                whatssap.component = ComponentName("com.whatsapp", "com.whatsapp.Conversation")
                val stringBuilder = StringBuilder()
                stringBuilder.append(PhoneNumberUtils.stripSeparators("243892390948"))
                stringBuilder.append("@s.whatsapp.net")
                whatssap.putExtra("jid", stringBuilder.toString())
                startActivity(whatssap)
            }
            R.id.back->{
                onBackPressed()
            }

        }



    }




}