package com.soundcode.chat.databinding;
import com.soundcode.chat.R;
import com.soundcode.chat.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FileRowBindingImpl extends FileRowBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = null;
    }
    // views
    @NonNull
    private final android.support.constraint.ConstraintLayout mboundView0;
    @NonNull
    private final android.widget.ImageView mboundView1;
    @NonNull
    private final android.support.v7.widget.AppCompatTextView mboundView2;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FileRowBindingImpl(@Nullable android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 3, sIncludes, sViewsWithIds));
    }
    private FileRowBindingImpl(android.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            );
        this.mboundView0 = (android.support.constraint.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (android.widget.ImageView) bindings[1];
        this.mboundView1.setTag(null);
        this.mboundView2 = (android.support.v7.widget.AppCompatTextView) bindings[2];
        this.mboundView2.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x8L;
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
        if (BR.rowViewModel == variableId) {
            setRowViewModel((com.applandeo.viewmodels.FileRowViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setRowViewModel(@Nullable com.applandeo.viewmodels.FileRowViewModel RowViewModel) {
        updateRegistration(0, RowViewModel);
        this.mRowViewModel = RowViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.rowViewModel);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeRowViewModel((com.applandeo.viewmodels.FileRowViewModel) object, fieldId);
        }
        return false;
    }
    private boolean onChangeRowViewModel(com.applandeo.viewmodels.FileRowViewModel RowViewModel, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        else if (fieldId == BR.file) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        else if (fieldId == BR.fileIconResource) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
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
        java.io.File rowViewModelFile = null;
        com.applandeo.viewmodels.FileRowViewModel rowViewModel = mRowViewModel;
        android.graphics.drawable.Drawable rowViewModelFileIconResource = null;
        java.lang.String rowViewModelFileName = null;

        if ((dirtyFlags & 0xfL) != 0) {



                if (rowViewModel != null) {
                    // read rowViewModel.file
                    rowViewModelFile = rowViewModel.getFile();
                    // read rowViewModel.fileIconResource
                    rowViewModelFileIconResource = rowViewModel.getFileIconResource();
                }

            if ((dirtyFlags & 0xbL) != 0) {

                    if (rowViewModelFile != null) {
                        // read rowViewModel.file.name
                        rowViewModelFileName = rowViewModelFile.getName();
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0xfL) != 0) {
            // api target 1

            com.applandeo.utils.BindingUtils.loadFileIcon(this.mboundView1, rowViewModelFile, rowViewModelFileIconResource);
        }
        if ((dirtyFlags & 0xbL) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView2, rowViewModelFileName);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): rowViewModel
        flag 1 (0x2L): rowViewModel.file
        flag 2 (0x3L): rowViewModel.fileIconResource
        flag 3 (0x4L): null
    flag mapping end*/
    //end
}