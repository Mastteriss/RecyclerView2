package com.example.recyclerview

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SecondActivity : AppCompatActivity() {
    private val carderobs = mutableListOf(
        Garderob("Куртка","Зимняя мужская куртка", R.drawable.winter),
        Garderob("Обувь","Зимняя мужская обувь", R.drawable.bots),
        Garderob("Шапка","Зимняя мужская шапка", R.drawable.sha),
        Garderob("Шарф","Зимний мужской шарф", R.drawable.charf),
        Garderob("Штаны","Зимние мужские штаны", R.drawable.inat),
        Garderob("Куртка","Зимняя женская куртка", R.drawable.women),
        Garderob("Обувь","Зимняя женская обувь", R.drawable.womenbots),
        Garderob("Шапка","Зимняя женская шапка", R.drawable.womanshapka),
        Garderob("Шарф","Зимний женский шарф", R.drawable.womansharf),
        Garderob("Штаны","Зимние женские штаны", R.drawable.womanshatnu),
        Garderob("Комбинезон","Детский комбинезон зимний на мальчика", R.drawable.kidman),
        Garderob("Комбинезон","Детский комбинезон зимний на девочку", R.drawable.kidsgirl),
        Garderob("Ботинки","Ботинки детские зимние на мальчика", R.drawable.botskid),
        Garderob("Ботинки","Ботинки детские зимние на девочку", R.drawable.botskidsgirl),
        Garderob("Шарф","Зимний шарф детский на мальчика", R.drawable.sharfkidman),
        Garderob("Шарф","Зимний шарф детский на девочку", R.drawable.sharfkidsgirl),
        Garderob("Шапка","Шапка зимнияя детская на мальчика", R.drawable.shapkakisman),
        Garderob("Шапка","Шапка зимнияя детская на девочку", R.drawable.shapkakidgirl),
        Garderob("Куртка","Зимняя детская куртка на мальчика", R.drawable.kyrtkakidman),
        Garderob("Куртка","Зимняя детская куртка на девочку", R.drawable.kyrtkakidgirl),
    )
    private lateinit var recyclerViewRV:RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)


        recyclerViewRV = findViewById(R.id.recyclerViewRV)
        recyclerViewRV.layoutManager = LinearLayoutManager(this)
        val adapter = CustomAdapter(carderobs)
        recyclerViewRV.adapter = adapter
        recyclerViewRV.setHasFixedSize(true)
        adapter.setOnUserClickListener(object :
        CustomAdapter.OnUserClickListener{
            override fun onUserClick(garderob: Garderob, position: Int) {
                val intent = Intent(this@SecondActivity, DetailsActivity::class.java)
                intent.putExtra("garderob", garderob)
                startActivity(intent)
            }

        }
        )
    }
}