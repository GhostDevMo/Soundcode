
package android.databinding;
import com.soundcode.chat.BR;
import android.util.SparseArray;
class V1CompatDataBinderMapperImpl extends android.databinding.DataBinderMapper {
    public V1CompatDataBinderMapperImpl() {
    }
    @Override
    public android.databinding.ViewDataBinding getDataBinder(android.databinding.DataBindingComponent bindingComponent, android.view.View view, int layoutId) {
        switch(layoutId) {
                case com.applandeo.filepicker.R.layout.file_row:
 {
                        final Object tag = view.getTag();
                        if(tag == null) throw new java.lang.RuntimeException("view must have a tag");
                    if ("layout/file_row_0".equals(tag)) {
                            return new com.applandeo.filepicker.databinding.FileRowBinding(bindingComponent, view);
                    }
                        throw new java.lang.IllegalArgumentException("The tag for file_row is invalid. Received: " + tag);
                }
                case com.applandeo.filepicker.R.layout.picker_dialog:
 {
                        final Object tag = view.getTag();
                        if(tag == null) throw new java.lang.RuntimeException("view must have a tag");
                    if ("layout/picker_dialog_0".equals(tag)) {
                            return new com.applandeo.filepicker.databinding.PickerDialogBinding(bindingComponent, view);
                    }
                        throw new java.lang.IllegalArgumentException("The tag for picker_dialog is invalid. Received: " + tag);
                }
        }
        return null;
    }
    @Override
    public android.databinding.ViewDataBinding getDataBinder(android.databinding.DataBindingComponent bindingComponent, android.view.View[] views, int layoutId) {
        switch(layoutId) {
        }
        return null;
    }
    @Override
    public int getLayoutId(String tag) {
        if (tag == null) {
            return 0;
        }
        final int code = tag.hashCode();
        switch(code) {
            case 1005329037: {
                if(tag.equals("layout/file_row_0")) {
                    return com.applandeo.filepicker.R.layout.file_row;
                }
                break;
            }
            case -495918427: {
                if(tag.equals("layout/picker_dialog_0")) {
                    return com.applandeo.filepicker.R.layout.picker_dialog;
                }
                break;
            }
        }
        return 0;
    }
    @Override
    public String convertBrIdToString(int id) {
        final String value = InnerBrLookup.sKeys.get(id);
        return value;
    }
    private static class InnerBrLookup {
        static final SparseArray<String> sKeys = new SparseArray<>();
        static {
                sKeys.put(0, "_all");
                sKeys.put(0, "_all");
                sKeys.put(1, "data");
                sKeys.put(2, "rowViewModel");
                sKeys.put(3, "file");
                sKeys.put(4, "adapter");
                sKeys.put(5, "parentDirectory");
                sKeys.put(6, "viewModel");
                sKeys.put(7, "currentFile");
                sKeys.put(8, "position");
                sKeys.put(9, "fileIconResource");
                sKeys.put(10, "fileList");
                sKeys.put(11, "notificationEnabled");
                sKeys.put(12, "positiveBtn");
                sKeys.put(13, "phoneNumber");
                sKeys.put(14, "hint");
                sKeys.put(15, "isvibrateEnabled");
                sKeys.put(16, "myName");
                sKeys.put(17, "model");
                sKeys.put(18, "finishedTyping5");
                sKeys.put(19, "myNumber");
                sKeys.put(20, "finishedTyping6");
                sKeys.put(21, "finishedTyping3");
                sKeys.put(22, "finishedTyping4");
                sKeys.put(23, "finishedTyping1");
                sKeys.put(24, "finishedTyping2");
        }
    }
}