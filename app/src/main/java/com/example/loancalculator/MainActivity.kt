package com.example.loancalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener {
            calculateLoan()
        }

        buttonReset.setOnClickListener {
            resetInput(buttonReset)
        }
    }

    private fun calculateLoan(){
        //Getting input data from user
        val car_price = editTextCarPrice.text.toString().toInt()
        val down_payment = editTextDownPayment.text.toString().toInt()
        val loan_period = editTextLoanPeriod.text.toString().toInt()
        val interest_rate = editTextInterestRate.text.toString().toFloat()

        val car_loan = car_price - down_payment
        val interest = car_loan * interest_rate * loan_period
        val monthly_repayment = (car_loan + interest) / loan_period / 12

        textViewCarLoan.text = getString(R.string.car_loan) + ": ${car_loan}"
        textViewInterest.text = getString(R.string.interest) + ": ${interest}"
        textViewMonthlyRepayment.text = getString(R.string.monthly_repayment) + ": ${monthly_repayment}"
    }

    fun resetInput(view : View){
        editTextCarPrice.text.clear()
        editTextDownPayment.text.clear()
        editTextLoanPeriod.text.clear()
        editTextInterestRate.text.clear()
        textViewCarLoan.text = getString(R.string.car_loan)
        textViewInterest.text = getString(R.string.interest)
        textViewMonthlyRepayment.text = getString(R.string.monthly_repayment)
    }
}
