package cubex.mahesh.mvp_oct7am.view

import cubex.mahesh.mvp_oct7am.beans.IncExpBean

interface ViewAPI {
    fun insertIncExp(status:String)
    fun readIncExp(list:MutableList<IncExpBean>)
}