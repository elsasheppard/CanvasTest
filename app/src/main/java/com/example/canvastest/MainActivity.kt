package com.example.canvastest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.SYSTEM_UI_FLAG_FULLSCREEN
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {

    // toolbar vars
    private lateinit var mtoolbarBottom: Toolbar
    private lateinit var myCanvasView : MyCanvasView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        myCanvasView =  MyCanvasView(this)

        // this makes drawing view fulscreen. not sure why its crossed out tho
        myCanvasView.systemUiVisibility = SYSTEM_UI_FLAG_FULLSCREEN
        myCanvasView.contentDescription = getString(R.string.canvasContentDescription)
        setContentView(R.layout.activity_main)

        // toolbar functions
        mtoolbarBottom = findViewById(R.id.toolbar_bottom)
        mtoolbarBottom.inflateMenu(R.menu.menu_drawing)
        mtoolbarBottom.setOnMenuItemClickListener(Toolbar.OnMenuItemClickListener { item ->
            handleDrawingIconTouched(item.itemId)
            false
        })
    }

    // toolbar function
    private fun handleDrawingIconTouched(itemId: Int) {
        when (itemId) {
            R.id.action_brush -> {
                myCanvasView?.setOnTouchListener { view, motionEvent ->
                    myCanvasView?.performClick(motionEvent)!!

                }
            }
        }
    }
}