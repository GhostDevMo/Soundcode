package com.soundcode.chat.databinding;
import com.soundcode.chat.R;
import com.soundcode.chat.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class LayoutSpinnerBindingImpl extends LayoutSpinnerBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.dropdown, 2);
    }
    // views
    @NonNull
    private final carbon.widget.RelativeLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public LayoutSpinnerBindingImpl(@Nullable android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 3, sIncludes, sViewsWithIds));
    }
    private LayoutSpinnerBindingImpl(android.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.ImageView) bindings[2]
            , (com.soundcode.chat.utils.custom_spinner.SearchableSpinner) bindings[1]
            );
        this.mboundView0 = (carbon.widget.RelativeLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.spinner.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x4L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.positiveBtn == variableId) {
            setPositiveBtn((java.lang.String) variable);
        }
        else if (BR.hint == variableId) {
            setHint((java.lang.String) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setPositiveBtn(@Nullable java.lang.String PositiveBtn) {
        this.mPositiveBtn = PositiveBtn;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.positiveBtn);
        super.requestRebind();
    }
    public void setHint(@Nullable java.lang.String Hint) {
        this.mHint = Hint;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.hint);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        java.lang.String positiveBtn = mPositiveBtn;
        java.lang.String hint = mHint;

        if ((dirtyFlags & 0x5L) != 0) {
        }
        if ((dirtyFlags & 0x6L) != 0) {
        }
        // batch finished
        if ((dirtyFlags & 0x5L) != 0) {
            // api target 1

            com.soundcode.chat.utils.BindingUtils.setSpinnerPositiveBtn(this.spinner, positiveBtn);
        }
        if ((dirtyFlags & 0x6L) != 0) {
            // api target 1

            com.soundcode.chat.utils.BindingUtils.setSpinnerTitle(this.spinner, hint);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): positiveBtn
        flag 1 (0x2L): hint
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}