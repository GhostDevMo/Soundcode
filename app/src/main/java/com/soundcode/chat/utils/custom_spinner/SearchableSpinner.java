package com.soundcode.chat.utils.custom_spinner;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;

import com.soundcode.chat.R;

import java.util.ArrayList;
import java.util.List;


public class SearchableSpinner extends android.support.v7.widget.AppCompatSpinner implements View.OnTouchListener,
        SearchableListDialog.SearchableItem {

    public static final int NO_ITEM_SELECTED = -1;
    private Context context;
    private List items;
    private SearchableListDialog searchableListDialog;

    private boolean isDirty;
    private ArrayAdapter arrayAdapter;
    private String strHintText;
    private boolean isFromInit;

    public SearchableSpinner(Context context) {
        super(context);
        this.context = context;
        init();
    }

    public SearchableSpinner(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.SearchableSpinner);
        final int N = a.getIndexCount();
        for (int i = 0; i < N; ++i) {
            int attr = a.getIndex(i);
            if (attr == R.styleable.SearchableSpinner_hintText) {
                strHintText = a.getString(attr);
            }
        }
        a.recycle();
        init();
    }

    public SearchableSpinner(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        init();
    }

    @Override
    public void setSelection(int position) {
        super.setSelection(position);
    }

    private void init() {
        items = new ArrayList();
        searchableListDialog = SearchableListDialog.newInstance
                (items);
        searchableListDialog.setOnSearchableItemClickListener(this);
        setOnTouchListener(this);
        arrayAdapter = (ArrayAdapter) getAdapter();
        setHintText(strHintText);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_UP) {
            if (null != arrayAdapter) {
                // Refresh content #6
                // Change Start
                // Description: The items were only set initially, not reloading the data in the
                // spinner every time it is loaded with items in the adapter.
                items.clear();
                for (int i = 0; i < arrayAdapter.getCount(); i++) {
                    items.add(arrayAdapter.getItem(i));
                }
                // Change end.
                showDialog();
            }
        }
        return true;
    }

    public void showDialog() {
        if (!searchableListDialog.isAdded())
            searchableListDialog.show(scanForActivity(context).getFragmentManager(), "TAG");
    }

    @Override
    public void setAdapter(SpinnerAdapter adapter) {
        if (!isFromInit) {
            arrayAdapter = (ArrayAdapter) adapter;
            if (!TextUtils.isEmpty(strHintText) && !isDirty) {
                ArrayAdapter arrayAdapter = new ArrayAdapter(context, android.R.layout
                        .simple_list_item_1, new String[]{strHintText});
                super.setAdapter(arrayAdapter);
            } else {
                super.setAdapter(adapter);
            }

        } else {
            isFromInit = false;
            super.setAdapter(adapter);
        }
    }

    public void setHintText(String hintText) {
        this.strHintText = hintText;
        if (!TextUtils.isEmpty(strHintText)) {
            ArrayAdapter arrayAdapter = new ArrayAdapter(context, android.R.layout
                    .simple_list_item_1, new String[]{strHintText});
            isFromInit = true;
            setAdapter(arrayAdapter);
        }
    }

    public void setSelectionDelayed(int position, boolean... animate) {
        new Handler().postDelayed(new Runnable() {
            public void run() {
                if (animate != null && animate.length > 0)
                    setSelection(position, animate[0]);
                else setSelection(position);
            }
        }, 1000);


    }

    @Override
    public void onSearchableItemClicked(Object item, int position) {
        setSelection(items.indexOf(item));
        if (!isDirty) {
            isDirty = true;
            setAdapter(arrayAdapter);
            setSelection(items.indexOf(item));
        }
    }

    public void setTitle(String strTitle) {
        searchableListDialog.setTitle(strTitle);
    }

    public void setPositiveButton(String strPositiveButtonText) {
        searchableListDialog.setPositiveButton(strPositiveButtonText);
    }

    public void setPositiveButton(String strPositiveButtonText, DialogInterface.OnClickListener onClickListener) {
        searchableListDialog.setPositiveButton(strPositiveButtonText, onClickListener);
    }

    public void setOnSearchTextChangedListener(SearchableListDialog.OnSearchTextChanged onSearchTextChanged) {
        searchableListDialog.setOnSearchTextChangedListener(onSearchTextChanged);
    }

    private Activity scanForActivity(Context cont) {
        if (cont == null)
            return null;
        else if (cont instanceof Activity)
            return (Activity) cont;
        else if (cont instanceof ContextWrapper)
            return scanForActivity(((ContextWrapper) cont).getBaseContext());
        return null;
    }

    @Override
    public int getSelectedItemPosition() {
        if (!TextUtils.isEmpty(strHintText) && !isDirty) {
            return NO_ITEM_SELECTED;
        } else {
            return super.getSelectedItemPosition();
        }
    }

    @Override
    public Object getSelectedItem() {
        if (!TextUtils.isEmpty(strHintText) && !isDirty) {
            return null;
        } else {
            return super.getSelectedItem();
        }
    }

    public void setDirty(boolean dirty) {
        isDirty = dirty;
    }
}