package com.debug.authentication.ui.main

import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Bundle
import android.provider.CalendarContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.debug.authentication.R
import java.util.*

class CurrentInvoiceFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.current_invoice_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnPay = view?.findViewById<Button>(R.id.home_btn_pagar)
        btnPay?.setOnClickListener {

            val calendarBegin: Calendar = Calendar.getInstance()
            calendarBegin.set(2023, 2, 21, 10, 30)
            val calendarEnd: Calendar = Calendar.getInstance()
            calendarEnd.set(2023, 2, 21, 11, 30)

            val intentCalendar = Intent(Intent.ACTION_EDIT)
            intentCalendar.type = "vnd.android.cursor.item/event"
            intentCalendar.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, calendarBegin.timeInMillis)
            intentCalendar.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, calendarEnd.timeInMillis)
            intentCalendar.putExtra(CalendarContract.Events.TITLE, "Título 21/03")
            intentCalendar.putExtra(CalendarContract.Events.DESCRIPTION, "Descrição")
            intentCalendar.putExtra(CalendarContract.Events.EVENT_LOCATION, "Localização")
            intentCalendar.putExtra(CalendarContract.Events.ALL_DAY, false)
            intentCalendar.putExtra(Intent.EXTRA_EMAIL, "mvocampos@yahoo.com.br")

            intentCalendar.putExtra(CalendarContract.Reminders.METHOD, CalendarContract.Reminders.METHOD_ALERT)
            intentCalendar.putExtra(CalendarContract.Reminders.MINUTES, 30)

            try {
                startActivity(intentCalendar)
            } catch (ErrVar: ActivityNotFoundException) {
                Toast.makeText(context, "Install Calender App", Toast.LENGTH_LONG).show()
            }
        }
    }
}