package com.example.tbc_academy_android_task_6

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.tbc_academy_android_task_6.Util.Validate
import com.example.tbc_academy_android_task_6.databinding.ActivityUpdateUserBinding

class UpdateUserActivity : AppCompatActivity() {
    lateinit var binding: ActivityUpdateUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val etFirstName = binding.etFirstName
        val etLastName = binding.etLastName
        val etAge = binding.etAge
        val etEmail = binding.etEmail

        val validate = Validate()
        val userList = intent.getSerializableExtra("userList") as MutableList<User>
        val user = intent.getSerializableExtra("user") as User

        binding.btnConfirm.setOnClickListener {
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
                val newUser = User(
                    etFirstName.text.toString(),
                    etLastName.text.toString(),
                    etAge.text.toString().toInt(),
                    etEmail.text.toString()
                )
                val index = userList.indexOf(user)

                userList[index].firstName = newUser.firstName
                userList[index].lastName = newUser.lastName
                userList[index].age = newUser.age
                userList[index].email = newUser.email

                finish()
            }
        }

        binding.btnCancel.setOnClickListener {
            finish()
        }
    }

    fun clearFields() {
        binding.tvErrorFirstName.text = ""
        binding.tvErrorLastName.text = ""
        binding.tvErrorAge.text = ""
        binding.tvErrorEmail.text = ""
    }
}