package cubex.mahesh.mvp_oct7am.presenter

import cubex.mahesh.mvp_oct7am.beans.IncExpBean

interface PresenterAPI {
    fun insertIncExp(bean:IncExpBean)
    fun readIncExp()
}