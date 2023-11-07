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

        var deletedUsers: Int = 0

        val usersList: MutableList<User> = mutableListOf<User>()
        val validate = Validate()

        updateCounts(usersList, deletedUsers)

        binding.btnAdd.setOnClickListener {
            clearFields()
            if (validate.validateMainUser(binding = binding, this)) {
                val user = User(
                    etFirstName.text.toString(),
                    etLastName.text.toString(),
                    etAge.text.toString().toInt(),
                    etEmail.text.toString()
                )
                if (!usersList.contains(user)) {
                    usersList.add(user)
                    updateCounts(usersList, deletedUsers)
                    binding.tvStatus.text = getString(R.string.success_user_added)
                    binding.tvStatus.setTextColor(ContextCompat.getColor(this, R.color.success))
                } else {
                    binding.tvStatus.text = getString(R.string.fail_user_added)
                    binding.tvStatus.setTextColor(ContextCompat.getColor(this, R.color.error))
                }
            }
        }
        binding.btnDelete.setOnClickListener {
            clearFields()
            if (validate.validateMainUser(binding = binding, this)) {
                val user = User(
                    etFirstName.text.toString(),
                    etLastName.text.toString(),
                    etAge.text.toString().toInt(),
                    etEmail.text.toString()
                )
                if (!usersList.contains(user)) {
                    binding.tvStatus.text = getString(R.string.fail_user_not_found)
                    binding.tvStatus.setTextColor(ContextCompat.getColor(this, R.color.error))
                } else {
                    usersList.remove(user)
                    deletedUsers++
                    updateCounts(usersList, deletedUsers)
                    binding.tvStatus.text = getString(R.string.success_user_deleted)
                    binding.tvStatus.setTextColor(ContextCompat.getColor(this, R.color.success))
                }
            }
        }
        binding.btnEdit.setOnClickListener {
            clearFields()
            if (validate.validateMainUser(binding = binding, this)) {
                val user = User(
                    etFirstName.text.toString(),
                    etLastName.text.toString(),
                    etAge.text.toString().toInt(),
                    etEmail.text.toString()
                )
                if (!usersList.contains(user)) {
                    binding.tvStatus.text = getString(R.string.error_email_format)
                    binding.tvStatus.setTextColor(ContextCompat.getColor(this, R.color.error))
                } else {
                    val updateUserIntent = Intent(this, UpdateUserActivity::class.java).apply {
                        putExtra("userList", ArrayList(usersList))
                        putExtra("user", user)
                    }
                    startActivity(updateUserIntent)
                }
            }
        }
    }

    private fun clearFields() {
        binding.etFirstName.text.clear()
        binding.tvErrorFirstName.text = ""
        binding.etLastName.text.clear()
        binding.tvErrorLastName.text = ""
        binding.etAge.text.clear()
        binding.tvErrorAge.text = ""
        binding.etEmail.text.clear()
        binding.tvErrorEmail.text = ""
        binding.tvStatus.text = ""
    }

    private fun updateCounts(usersList: MutableList<User>, deletedUsers: Int) {
        binding.tvUserCount.text = "Users: " + usersList.size.toString()
        binding.tvDeletedUserCount.text = "Deleted Users: " + deletedUsers.toString()
    }
}