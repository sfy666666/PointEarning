package com.example.pointearning.contact

import android.content.Context
import android.text.TextUtils
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pointearning.R
import kotlinx.android.synthetic.main.contact_list_layout.view.*
import java.util.*


class ContactRecyclerView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : FrameLayout(context, attrs, defStyleAttr), SideBarView.LetterTouchListener {

    var ll_top_title: LinearLayout? = null
    var tv_letter: TextView? = null
    var mLetterHeight = 0
    var mCurrentPosition = 0
    var mLayoutManager: LinearLayoutManager? = null
    var mData: MutableList<SortModel> = mutableListOf()
    var mParser: CharacterParser = CharacterParser.getInstance()

    init {
        LayoutInflater.from(context).inflate(R.layout.contact_list_layout, this)
        ll_top_title = findViewById(R.id.ll_top_title)
        tv_letter = findViewById(R.id.tv_letter)
        view_sidebar?.setLetterTouchListener(this)
        recycler_view?.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                mLetterHeight = ll_top_title?.height!!
            }

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                mLayoutManager = recyclerView?.layoutManager as LinearLayoutManager
                //找到列表下一个可见的View
                var view = mLayoutManager?.findViewByPosition(mCurrentPosition + 1)
                // 检查列表中的letter布局是否显示
                if (view != null && view.top <= mLetterHeight && view?.findViewById<TextView>(R.id.tv_letter)?.visibility == View.VISIBLE) {
                    //被顶掉的效果
                    ll_top_title?.y = (-(mLetterHeight - view.top)).toFloat()
                } else {
                    ll_top_title?.y = 0f
                }
                //判断是否需要更新悬浮条
                if (mCurrentPosition != mLayoutManager?.findFirstVisibleItemPosition()) {
                    ll_top_title?.y = 0f
                    updateLetter()
                }
            }

        })
    }

    fun getRecycler(): RecyclerView {
        return recycler_view
    }

    override fun setLetterVisibility(visibility: Int) {
        tv_letter_show?.visibility = visibility
    }

    override fun setLetter(letter: String?) {
        if (TextUtils.isEmpty(letter) || letter!!.isEmpty()) {
            return
        }
        tv_letter_show?.text = letter
        var position = getPositionForSection(letter!![0].toInt())
        if (position != -1) {
            updateLetter()
            mLetterHeight = ll_top_title?.height!!
            mLayoutManager?.scrollToPositionWithOffset(position, 0) // 使当前位置处于最顶端
        }
    }


    fun updateLetter() {
        mCurrentPosition = mLayoutManager?.findFirstVisibleItemPosition() ?: -1
        if (mData.size > 0 && mCurrentPosition > -1 && mCurrentPosition < mData.size) {
            tv_letter?.text = mData[mCurrentPosition].letter
        }
    }


    fun sortData(data: MutableList<SortModel>): MutableList<SortModel> {
        val list = mutableListOf<SortModel>()
        for (i in data.indices) {
            val sm = SortModel()
            sm.name = data[i].name
            val pinyin = mParser.getSelling(data[i].name)
            val sortString = pinyin.substring(0, 1).toUpperCase()
            if (sortString.matches("[A-Z]".toRegex())) {
                sm.letter = sortString
            } else {
                sm.letter = "#"
            }
            list.add(sm)
        }
        Collections.sort(list, PinyinComparator())
        return list
    }


    fun initData(data: MutableList<SortModel>?) {
        mData.clear()
        mData.addAll(data ?: mutableListOf())
        updateLetter()
    }


    fun updateData(filterStr: String): MutableList<SortModel> {
        var newData = mutableListOf<SortModel>()
        if (mData != null && mData!!.size > 0) {
            if ("" == filterStr) {
                newData = mData!!
            } else {
                for (sortModel in mData!!) {
                    val name = sortModel.name
                    if (name.indexOf(filterStr) != -1 || mParser.getSelling(name).startsWith(filterStr)) {
                        newData.add(sortModel)
                    }
                }
            }
        }
        mData?.clear()
        mData?.addAll(newData)
        updateLetter()
        return mData
    }


    fun getPositionForSection(section: Int): Int {
        if (mData == null || mData!!.size == 0) {
            return -1
        }
        for (i in 0 until mData!!.size) {
            val s = mData!![i].letter
            val firstChar = s.toUpperCase()[0]
            if (firstChar.toInt() == section) {
                return i
            }
        }
        return -1
    }

}
