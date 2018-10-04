package cubex.mahesh.mvp_oct7am.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import cubex.mahesh.mvp_oct7am.R
import cubex.mahesh.mvp_oct7am.beans.IncExpBean
import cubex.mahesh.mvp_oct7am.model.IncExpModel
import cubex.mahesh.mvp_oct7am.presenter.PresenterAPI
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),ViewAPI {
    override fun insertIncExp(status: String) {
        Toast.makeText(this@MainActivity,
                status,Toast.LENGTH_LONG ).show()
    }

    override fun readIncExp(list: MutableList<IncExpBean>) {
        var temp_list = mutableListOf<String>()
        var income_sum = 0
        var expense_sum = 0
        for(bean in list)
        {
            temp_list.add(bean.date+"\t"+bean.money+"\n"+
                                bean.desc+"\t"+bean.type)
            if(bean.type.equals("income")){
                income_sum = income_sum+bean.money
            }else{
                expense_sum = expense_sum+bean.money
            }
        }
        var adapter = ArrayAdapter<String>(this@MainActivity,
                android.R.layout.simple_list_item_single_choice,temp_list)
        lview.adapter = adapter
        isum.text = income_sum.toString()
        esum.text = expense_sum.toString()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        insert.setOnClickListener {
            var bean = IncExpBean(et1.text.toString(),
                    et2.text.toString().toInt(),
                    et3.text.toString(),
                    sp1.selectedItem.toString())
            var api:PresenterAPI = IncExpModel(this)
            api.insertIncExp(bean)

        }
        read.setOnClickListener {
            var api:PresenterAPI = IncExpModel(this)
            api.readIncExp()
        }

    }
}
