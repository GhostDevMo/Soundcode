package com.soundcode.chat.databinding;
import com.soundcode.chat.R;
import com.soundcode.chat.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class SettingsActBindingImpl extends SettingsActBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new android.databinding.ViewDataBinding.IncludedLayouts(14);
        sIncludes.setIncludes(0, 
            new String[] {"layout_app_bar"},
            new int[] {1},
            new int[] {R.layout.layout_app_bar});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.BtnProfileStatus, 2);
        sViewsWithIds.put(R.id.profileImage, 3);
        sViewsWithIds.put(R.id.name, 4);
        sViewsWithIds.put(R.id.status, 5);
        sViewsWithIds.put(R.id.BtnProfile, 6);
        sViewsWithIds.put(R.id.profile, 7);
        sViewsWithIds.put(R.id.BtnNotifications, 8);
        sViewsWithIds.put(R.id.notifications, 9);
        sViewsWithIds.put(R.id.BtnChat, 10);
        sViewsWithIds.put(R.id.chat, 11);
        sViewsWithIds.put(R.id.BtnAbout, 12);
        sViewsWithIds.put(R.id.about, 13);
    }
    // views
    @NonNull
    private final carbon.widget.LinearLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public SettingsActBindingImpl(@Nullable android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 14, sIncludes, sViewsWithIds));
    }
    private SettingsActBindingImpl(android.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (android.widget.LinearLayout) bindings[12]
            , (android.widget.LinearLayout) bindings[10]
            , (android.widget.LinearLayout) bindings[8]
            , (android.widget.LinearLayout) bindings[6]
            , (android.widget.LinearLayout) bindings[2]
            , (android.widget.TextView) bindings[13]
            , (com.soundcode.chat.databinding.LayoutAppBarBinding) bindings[1]
            , (android.widget.TextView) bindings[11]
            , (android.widget.TextView) bindings[4]
            , (android.widget.TextView) bindings[9]
            , (android.widget.TextView) bindings[7]
            , (de.hdodenhof.circleimageview.CircleImageView) bindings[3]
            , (android.widget.TextView) bindings[5]
            );
        this.mboundView0 = (carbon.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
        }
        appBar.invalidateAll();
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        if (appBar.hasPendingBindings()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
            return variableSet;
    }

    @Override
    public void setLifecycleOwner(@Nullable android.arch.lifecycle.LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        appBar.setLifecycleOwner(lifecycleOwner);
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeAppBar((com.soundcode.chat.databinding.LayoutAppBarBinding) object, fieldId);
        }
        return false;
    }
    private boolean onChangeAppBar(com.soundcode.chat.databinding.LayoutAppBarBinding AppBar, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
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
        // batch finished
        executeBindingsOn(appBar);
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): appBar
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}