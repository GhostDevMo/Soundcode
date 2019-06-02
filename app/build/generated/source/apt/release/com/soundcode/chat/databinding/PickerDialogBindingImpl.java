package com.soundcode.chat.databinding;
import com.soundcode.chat.R;
import com.soundcode.chat.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class PickerDialogBindingImpl extends PickerDialogBinding implements com.soundcode.chat.generated.callback.OnClickListener.Listener {

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
    private final android.widget.LinearLayout mboundView0;
    @NonNull
    private final android.support.v7.widget.AppCompatTextView mboundView3;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback4;
    @Nullable
    private final android.view.View.OnClickListener mCallback3;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public PickerDialogBindingImpl(@Nullable android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 6, sIncludes, sViewsWithIds));
    }
    private PickerDialogBindingImpl(android.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2
            , (android.support.v7.widget.AppCompatButton) bindings[5]
            , (android.support.v7.widget.RecyclerView) bindings[2]
            , (android.support.v7.widget.AppCompatButton) bindings[4]
            , (android.support.v7.widget.Toolbar) bindings[1]
            );
        this.cancelButton.setTag(null);
        this.fileList.setTag(null);
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView3 = (android.support.v7.widget.AppCompatTextView) bindings[3];
        this.mboundView3.setTag(null);
        this.selectButton.setTag(null);
        this.toolbar.setTag(null);
        setRootTag(root);
        // listeners
        mCallback4 = new com.soundcode.chat.generated.callback.OnClickListener(this, 2);
        mCallback3 = new com.soundcode.chat.generated.callback.OnClickListener(this, 1);
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x40L;
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
        if (BR.viewModel == variableId) {
            setViewModel((com.applandeo.viewmodels.PickerDialogViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setViewModel(@Nullable com.applandeo.viewmodels.PickerDialogViewModel ViewModel) {
        updateRegistration(1, ViewModel);
        this.mViewModel = ViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.viewModel);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeViewModelFileList((android.databinding.ObservableList<com.applandeo.viewmodels.FileRowViewModel>) object, fieldId);
            case 1 :
                return onChangeViewModel((com.applandeo.viewmodels.PickerDialogViewModel) object, fieldId);
        }
        return false;
    }
    private boolean onChangeViewModelFileList(android.databinding.ObservableList<com.applandeo.viewmodels.FileRowViewModel> ViewModelFileList, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewModel(com.applandeo.viewmodels.PickerDialogViewModel ViewModel, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        else if (fieldId == BR.currentFile) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
            }
            return true;
        }
        else if (fieldId == BR.parentDirectory) {
            synchronized(this) {
                    mDirtyFlags |= 0x8L;
            }
            return true;
        }
        else if (fieldId == BR.adapter) {
            synchronized(this) {
                    mDirtyFlags |= 0x10L;
            }
            return true;
        }
        else if (fieldId == BR.position) {
            synchronized(this) {
                    mDirtyFlags |= 0x20L;
            }
            return true;
        }
        else if (fieldId == BR.fileList) {
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
        java.io.File viewModelCurrentFile = null;
        java.lang.String stringUtilsIsNullOrEmptyViewModelCurrentFileNameViewModelCurrentFileNameToolbarAndroidStringRootDirectory = null;
        int viewModelFileListIsEmptyViewVISIBLEViewGONE = 0;
        int viewModelPosition = 0;
        int viewModelParentDirectoryEqualsViewModelCurrentFileComApplandeoFilepickerRDrawableIcClearWhite24dpComApplandeoFilepickerRDrawableIcArrowBackWhite24dp = 0;
        boolean stringUtilsIsNullOrEmptyViewModelCurrentFileName = false;
        com.applandeo.adapters.FileAdapter viewModelAdapter = null;
        boolean viewModelFileListIsEmpty = false;
        java.lang.String viewModelCurrentFileName = null;
        android.support.v7.widget.RecyclerView.OnScrollListener viewModelScrollListener = null;
        android.view.View.OnClickListener viewModelOnToolbarIconClickListener = null;
        java.io.File viewModelParentDirectory = null;
        boolean StringUtilsIsNullOrEmptyViewModelCurrentFileName1 = false;
        android.databinding.ObservableList<com.applandeo.viewmodels.FileRowViewModel> viewModelFileList = null;
        boolean viewModelParentDirectoryEqualsViewModelCurrentFile = false;
        com.applandeo.viewmodels.PickerDialogViewModel viewModel = mViewModel;

        if ((dirtyFlags & 0x7fL) != 0) {


            if ((dirtyFlags & 0x4eL) != 0) {

                    if (viewModel != null) {
                        // read viewModel.currentFile
                        viewModelCurrentFile = viewModel.getCurrentFile();
                        // read viewModel.parentDirectory
                        viewModelParentDirectory = viewModel.getParentDirectory();
                    }

                if ((dirtyFlags & 0x46L) != 0) {

                        if (viewModelCurrentFile != null) {
                            // read viewModel.currentFile.name
                            viewModelCurrentFileName = viewModelCurrentFile.getName();
                        }


                        // read StringUtils.isNullOrEmpty(viewModel.currentFile.name)
                        StringUtilsIsNullOrEmptyViewModelCurrentFileName1 = com.applandeo.utils.StringUtils.isNullOrEmpty(viewModelCurrentFileName);


                        // read !StringUtils.isNullOrEmpty(viewModel.currentFile.name)
                        stringUtilsIsNullOrEmptyViewModelCurrentFileName = !StringUtilsIsNullOrEmptyViewModelCurrentFileName1;
                    if((dirtyFlags & 0x46L) != 0) {
                        if(stringUtilsIsNullOrEmptyViewModelCurrentFileName) {
                                dirtyFlags |= 0x100L;
                        }
                        else {
                                dirtyFlags |= 0x80L;
                        }
                    }
                }

                    if (viewModelParentDirectory != null) {
                        // read viewModel.parentDirectory.equals(viewModel.currentFile)
                        viewModelParentDirectoryEqualsViewModelCurrentFile = viewModelParentDirectory.equals(viewModelCurrentFile);
                    }
                if((dirtyFlags & 0x4eL) != 0) {
                    if(viewModelParentDirectoryEqualsViewModelCurrentFile) {
                            dirtyFlags |= 0x1000L;
                    }
                    else {
                            dirtyFlags |= 0x800L;
                    }
                }


                    // read viewModel.parentDirectory.equals(viewModel.currentFile) ? com.applandeo.filepicker.R.drawable.ic_clear_white_24dp : com.applandeo.filepicker.R.drawable.ic_arrow_back_white_24dp
                    viewModelParentDirectoryEqualsViewModelCurrentFileComApplandeoFilepickerRDrawableIcClearWhite24dpComApplandeoFilepickerRDrawableIcArrowBackWhite24dp = ((viewModelParentDirectoryEqualsViewModelCurrentFile) ? (com.applandeo.filepicker.R.drawable.ic_clear_white_24dp) : (com.applandeo.filepicker.R.drawable.ic_arrow_back_white_24dp));
            }
            if ((dirtyFlags & 0x62L) != 0) {

                    if (viewModel != null) {
                        // read viewModel.position
                        viewModelPosition = viewModel.getPosition();
                    }
            }
            if ((dirtyFlags & 0x52L) != 0) {

                    if (viewModel != null) {
                        // read viewModel.adapter
                        viewModelAdapter = viewModel.getAdapter();
                    }
            }
            if ((dirtyFlags & 0x42L) != 0) {

                    if (viewModel != null) {
                        // read viewModel.scrollListener
                        viewModelScrollListener = viewModel.scrollListener;
                        // read viewModel.onToolbarIconClickListener
                        viewModelOnToolbarIconClickListener = viewModel.onToolbarIconClickListener;
                    }
            }
            if ((dirtyFlags & 0x43L) != 0) {

                    if (viewModel != null) {
                        // read viewModel.fileList
                        viewModelFileList = viewModel.getFileList();
                    }
                    updateRegistration(0, viewModelFileList);


                    if (viewModelFileList != null) {
                        // read viewModel.fileList.isEmpty()
                        viewModelFileListIsEmpty = viewModelFileList.isEmpty();
                    }
                if((dirtyFlags & 0x43L) != 0) {
                    if(viewModelFileListIsEmpty) {
                            dirtyFlags |= 0x400L;
                    }
                    else {
                            dirtyFlags |= 0x200L;
                    }
                }


                    // read viewModel.fileList.isEmpty() ? View.VISIBLE : View.GONE
                    viewModelFileListIsEmptyViewVISIBLEViewGONE = ((viewModelFileListIsEmpty) ? (android.view.View.VISIBLE) : (android.view.View.GONE));
            }
        }
        // batch finished

        if ((dirtyFlags & 0x46L) != 0) {

                // read !StringUtils.isNullOrEmpty(viewModel.currentFile.name) ? viewModel.currentFile.name : @android:string/root_directory
                stringUtilsIsNullOrEmptyViewModelCurrentFileNameViewModelCurrentFileNameToolbarAndroidStringRootDirectory = ((stringUtilsIsNullOrEmptyViewModelCurrentFileName) ? (viewModelCurrentFileName) : (toolbar.getResources().getString(R.string.root_directory)));
        }
        // batch finished
        if ((dirtyFlags & 0x40L) != 0) {
            // api target 1

            this.cancelButton.setOnClickListener(mCallback4);
            this.selectButton.setOnClickListener(mCallback3);
        }
        if ((dirtyFlags & 0x42L) != 0) {
            // api target 1

            com.applandeo.utils.BindingUtils.addOnScrollListener(this.fileList, viewModelScrollListener);
            com.applandeo.utils.BindingUtils.setNavigationOnClickListener(this.toolbar, viewModelOnToolbarIconClickListener);
        }
        if ((dirtyFlags & 0x52L) != 0) {
            // api target 1

            com.applandeo.utils.BindingUtils.setAdapter(this.fileList, viewModelAdapter);
        }
        if ((dirtyFlags & 0x62L) != 0) {
            // api target 1

            com.applandeo.utils.BindingUtils.setListPosition(this.fileList, viewModelPosition);
        }
        if ((dirtyFlags & 0x43L) != 0) {
            // api target 1

            this.mboundView3.setVisibility(viewModelFileListIsEmptyViewVISIBLEViewGONE);
        }
        if ((dirtyFlags & 0x4eL) != 0) {
            // api target 1

            this.toolbar.setNavigationIcon(viewModelParentDirectoryEqualsViewModelCurrentFileComApplandeoFilepickerRDrawableIcClearWhite24dpComApplandeoFilepickerRDrawableIcArrowBackWhite24dp);
        }
        if ((dirtyFlags & 0x46L) != 0) {
            // api target 1

            this.toolbar.setTitle(stringUtilsIsNullOrEmptyViewModelCurrentFileNameViewModelCurrentFileNameToolbarAndroidStringRootDirectory);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        switch(sourceId) {
            case 2: {
                // localize variables for thread safety
                // viewModel
                com.applandeo.viewmodels.PickerDialogViewModel viewModel = mViewModel;
                // viewModel != null
                boolean viewModelJavaLangObjectNull = false;



                viewModelJavaLangObjectNull = (viewModel) != (null);
                if (viewModelJavaLangObjectNull) {


                    viewModel.onCancel();
                }
                break;
            }
            case 1: {
                // localize variables for thread safety
                // viewModel
                com.applandeo.viewmodels.PickerDialogViewModel viewModel = mViewModel;
                // viewModel != null
                boolean viewModelJavaLangObjectNull = false;



                viewModelJavaLangObjectNull = (viewModel) != (null);
                if (viewModelJavaLangObjectNull) {


                    viewModel.onSelect();
                }
                break;
            }
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): viewModel.fileList
        flag 1 (0x2L): viewModel
        flag 2 (0x3L): viewModel.currentFile
        flag 3 (0x4L): viewModel.parentDirectory
        flag 4 (0x5L): viewModel.adapter
        flag 5 (0x6L): viewModel.position
        flag 6 (0x7L): null
        flag 7 (0x8L): !StringUtils.isNullOrEmpty(viewModel.currentFile.name) ? viewModel.currentFile.name : @android:string/root_directory
        flag 8 (0x9L): !StringUtils.isNullOrEmpty(viewModel.currentFile.name) ? viewModel.currentFile.name : @android:string/root_directory
        flag 9 (0xaL): viewModel.fileList.isEmpty() ? View.VISIBLE : View.GONE
        flag 10 (0xbL): viewModel.fileList.isEmpty() ? View.VISIBLE : View.GONE
        flag 11 (0xcL): viewModel.parentDirectory.equals(viewModel.currentFile) ? com.applandeo.filepicker.R.drawable.ic_clear_white_24dp : com.applandeo.filepicker.R.drawable.ic_arrow_back_white_24dp
        flag 12 (0xdL): viewModel.parentDirectory.equals(viewModel.currentFile) ? com.applandeo.filepicker.R.drawable.ic_clear_white_24dp : com.applandeo.filepicker.R.drawable.ic_arrow_back_white_24dp
    flag mapping end*/
    //end
}