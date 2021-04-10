package defdeveu.lab.android.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.widget.addTextChangedListener
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        button.setOnClickListener {
            if (isCredentialsValid()) {
                startActivity(Intent(this, SecretActivity::class.java))
                finish()
            } else
                showError()
        }

        edit_text_password.addTextChangedListener {
            button.isEnabled = edit_text_username.text.isNotEmpty()
                    && edit_text_password.text.isNotEmpty()
        }

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }

    private fun isCredentialsValid(): Boolean =
            edit_text_username.text.toString() == "demo"
                    && edit_text_password.text.toString() == "demo"


    private fun showError() {
        Snackbar.make(content, "Incorrect username or password!", Snackbar.LENGTH_LONG).show()
    }
}