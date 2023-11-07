package com.example.tbc_academy_android_task_6.Util

import android.content.Context
import com.example.tbc_academy_android_task_6.R
import com.example.tbc_academy_android_task_6.databinding.ActivityMainBinding
import com.example.tbc_academy_android_task_6.databinding.ActivityUpdateUserBinding

class Validate {
    private val emailRegex = Regex("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");
    private var validationPassed: Boolean = true;

    fun startValidation(): Unit {
        validationPassed = true
    }

    fun valueFilled(input: String): Boolean {
        if (input.trim().isEmpty()) {
            validationPassed = false
            return false
        }
        return true
    }

    fun isEmail(input: String): Boolean {
        if (!input.matches(emailRegex)) {
            validationPassed = false
            return false
        }
        return true
    }

    fun validateMainUser(binding: ActivityMainBinding, context: Context): Boolean {
        startValidation()
        if (!this.valueFilled(binding.etFirstName.text.toString())) {
            binding.tvErrorFirstName.text = context.getString(R.string.error_value_required)
        }
        if (!this.valueFilled(binding.etLastName.text.toString())) {
            binding.tvErrorLastName.text = context.getString(R.string.error_value_required)
        }
        if (!this.valueFilled(binding.etAge.text.toString())) {
            binding.tvErrorAge.text = context.getString(R.string.error_value_required)
        }
        if (!this.isEmail(binding.etEmail.text.toString())) {
            binding.tvErrorEmail.text = context.getString(R.string.error_email_format)
        }
        if (!this.valueFilled(binding.etEmail.text.toString())) {
            binding.tvErrorEmail.text = context.getString(R.string.error_value_required)
        }
        return this.validationPassed;
    }

    fun validateUpdateUser(binding: ActivityUpdateUserBinding, context: Context): Boolean {
        startValidation()
        if (!this.valueFilled(binding.etFirstName.text.toString())) {
            binding.tvErrorFirstName.text = context.getString(R.string.error_value_required)
        }
        if (!this.valueFilled(binding.etLastName.text.toString())) {
            binding.tvErrorLastName.text = context.getString(R.string.error_value_required)
        }
        if (!this.valueFilled(binding.etAge.text.toString())) {
            binding.tvErrorAge.text = context.getString(R.string.error_value_required)
        }
        if (!this.isEmail(binding.etEmail.text.toString())) {
            binding.tvErrorEmail.text = context.getString(R.string.error_email_format)
        }
        if (!this.valueFilled(binding.etEmail.text.toString())) {
            binding.tvErrorEmail.text = context.getString(R.string.error_value_required)
        }
        return this.validationPassed;
    }
}