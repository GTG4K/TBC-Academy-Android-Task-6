package com.example.tbc_academy_android_task_6

import android.app.Activity
import android.content.Intent
import android.media.MediaRouter.UserRouteInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import com.example.tbc_academy_android_task_6.Util.Validate
import com.example.tbc_academy_android_task_6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val etFirstName = binding.etFirstName
        val etLastName = binding.etLastName
        val etAge = binding.etAge
        val etEmail = binding.etEmail

        var usersList: MutableList<User> = mutableListOf<User>()
        val validate = Validate()

        binding.btnAdd.setOnClickListener {
            validate.startValidation()
            clearFields()
            if (!validate.valueFilled(etFirstName.text.toString())) {
                binding.tvErrorFirstName.text = "First name Value must be filled"
            }
            if (!validate.valueFilled(etLastName.text.toString())) {
                binding.tvErrorLastName.text = "Last name Value must be filled"
            }
            if (!validate.valueFilled(etAge.text.toString())) {
                binding.tvErrorAge.text = "Age Value must be filled"
            }
            if (!validate.isEmail(etEmail.text.toString())) {
                binding.tvErrorEmail.text = "Email formatted incorrectly"
            }
            if (!validate.valueFilled(etEmail.text.toString())) {
                binding.tvErrorEmail.text = "Email Value must be filled"
            }

            if (validate.validationPassed) {
                val user = User(
                    etFirstName.text.toString(),
                    etLastName.text.toString(),
                    etAge.text.toString().toInt(),
                    etEmail.text.toString()
                )
                if (!usersList.contains(user)) {
                    usersList.add(user)
                    binding.tvStatus.text = "User added successfully"
                    binding.tvStatus.setTextColor(ContextCompat.getColor(this, R.color.success))
                } else {
                    binding.tvStatus.text = "User already exists"
                    binding.tvStatus.setTextColor(ContextCompat.getColor(this, R.color.error))
                }
            }
        }
        binding.btnDelete.setOnClickListener {
            validate.startValidation()
            clearFields()
            if (!validate.valueFilled(etFirstName.text.toString())) {
                binding.tvErrorFirstName.text = "First name Value must be filled"
            }
            if (!validate.valueFilled(etLastName.text.toString())) {
                binding.tvErrorLastName.text = "Last name Value must be filled"
            }
            if (!validate.valueFilled(etAge.text.toString())) {
                binding.tvErrorAge.text = "Age Value must be filled"
            }
            if (!validate.isEmail(etEmail.text.toString())) {
                binding.tvErrorEmail.text = "Email formatted incorrectly"
            }
            if (!validate.valueFilled(etEmail.text.toString())) {
                binding.tvErrorEmail.text = "Email Value must be filled"
            }

            if (validate.validationPassed) {
                val user = User(
                    etFirstName.text.toString(),
                    etLastName.text.toString(),
                    etAge.text.toString().toInt(),
                    etEmail.text.toString()
                )
                if (!usersList.contains(user)) {
                    binding.tvStatus.text = "User does not exist"
                    binding.tvStatus.setTextColor(ContextCompat.getColor(this, R.color.error))
                } else {
                    usersList.remove(user)
                    binding.tvStatus.text = "User deleted successfully"
                    binding.tvStatus.setTextColor(ContextCompat.getColor(this, R.color.success))
                }
            }
        }
        binding.btnEdit.setOnClickListener {
            validate.startValidation()
            clearFields()
            if (!validate.valueFilled(etFirstName.text.toString())) {
                binding.tvErrorFirstName.text = "First name Value must be filled"
            }
            if (!validate.valueFilled(etLastName.text.toString())) {
                binding.tvErrorLastName.text = "Last name Value must be filled"
            }
            if (!validate.valueFilled(etAge.text.toString())) {
                binding.tvErrorAge.text = "Age Value must be filled"
            }
            if (!validate.isEmail(etEmail.text.toString())) {
                binding.tvErrorEmail.text = "Email formatted incorrectly"
            }
            if (!validate.valueFilled(etEmail.text.toString())) {
                binding.tvErrorEmail.text = "Email Value must be filled"
            }
            if (validate.validationPassed) {
                val user = User(
                    etFirstName.text.toString(),
                    etLastName.text.toString(),
                    etAge.text.toString().toInt(),
                    etEmail.text.toString()
                )
                if (!usersList.contains(user)) {
                    binding.tvStatus.text = "User not found"
                    binding.tvStatus.setTextColor(ContextCompat.getColor(this, R.color.error))
                } else {
                    val updateUserIntent = Intent(this, UpdateUserActivity::class.java).apply {
                        putExtra("userList",ArrayList(usersList))
                        putExtra("user", user)
                    }
                    startActivity(updateUserIntent)
                }
            }
        }
    }

    fun clearFields() {
        binding.tvErrorFirstName.text = ""
        binding.tvErrorLastName.text = ""
        binding.tvErrorAge.text = ""
        binding.tvErrorEmail.text = ""
    }
}