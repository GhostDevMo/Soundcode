package com.soundcode.chat.databinding;
import com.soundcode.chat.R;
import com.soundcode.chat.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class PhoneVerifiyActBindingImpl extends PhoneVerifiyActBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.text, 9);
    }
    // views
    @NonNull
    private final android.widget.RelativeLayout mboundView0;
    @NonNull
    private final carbon.widget.Button mboundView8;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public PhoneVerifiyActBindingImpl(@Nullable android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 10, sIncludes, sViewsWithIds));
    }
    private PhoneVerifiyActBindingImpl(android.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (android.widget.EditText) bindings[2]
            , (android.widget.EditText) bindings[3]
            , (android.widget.EditText) bindings[4]
            , (android.widget.EditText) bindings[5]
            , (android.widget.EditText) bindings[6]
            , (android.widget.EditText) bindings[7]
            , (android.widget.TextView) bindings[9]
            , (android.widget.TextView) bindings[1]
            );
        this.editText1.setTag(null);
        this.editText2.setTag(null);
        this.editText3.setTag(null);
        this.editText4.setTag(null);
        this.editText5.setTag(null);
        this.editText6.setTag(null);
        this.mboundView0 = (android.widget.RelativeLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView8 = (carbon.widget.Button) bindings[8];
        this.mboundView8.setTag(null);
        this.text2.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x100L;
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
        if (BR.model == variableId) {
            setModel((com.soundcode.chat.activities.authentication.VerifyModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setModel(@Nullable com.soundcode.chat.activities.authentication.VerifyModel Model) {
        updateRegistration(0, Model);
        this.mModel = Model;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.model);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeModel((com.soundcode.chat.activities.authentication.VerifyModel) object, fieldId);
        }
        return false;
    }
    private boolean onChangeModel(com.soundcode.chat.activities.authentication.VerifyModel Model, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        else if (fieldId == BR.phoneNumber) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        else if (fieldId == BR.finishedTyping1) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
            }
            return true;
        }
        else if (fieldId == BR.finishedTyping2) {
            synchronized(this) {
                    mDirtyFlags |= 0x8L;
            }
            return true;
        }
        else if (fieldId == BR.finishedTyping3) {
            synchronized(this) {
                    mDirtyFlags |= 0x10L;
            }
            return true;
        }
        else if (fieldId == BR.finishedTyping4) {
            synchronized(this) {
                    mDirtyFlags |= 0x20L;
            }
            return true;
        }
        else if (fieldId == BR.finishedTyping5) {
            synchronized(this) {
                    mDirtyFlags |= 0x40L;
            }
            return true;
        }
        else if (fieldId == BR.finishedTyping6) {
            synchronized(this) {
                    mDirtyFlags |= 0x80L;
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
        android.graphics.drawable.Drawable modelFinishedTyping2EditText2AndroidDrawableRoundEditTextGreenBgEditText2AndroidDrawableRoundEditTextBg = null;
        java.lang.Boolean modelFinishedTyping3 = null;
        android.graphics.drawable.Drawable modelFinishedTyping1EditText1AndroidDrawableRoundEditTextGreenBgEditText1AndroidDrawableRoundEditTextBg = null;
        boolean androidDatabindingViewDataBindingSafeUnboxModelFinishedTyping2 = false;
        android.graphics.drawable.Drawable modelFinishedTyping6EditText6AndroidDrawableRoundEditTextGreenBgEditText6AndroidDrawableRoundEditTextBg = null;
        android.graphics.drawable.Drawable modelFinishedTyping3EditText3AndroidDrawableRoundEditTextGreenBgEditText3AndroidDrawableRoundEditTextBg = null;
        boolean modelFinishedTyping6 = false;
        int modelFinishedTyping6MboundView8AndroidColorWhiteMboundView8AndroidColorColorPrimary = 0;
        java.lang.Boolean ModelFinishedTyping61 = null;
        java.lang.Boolean modelFinishedTyping2 = null;
        boolean androidDatabindingViewDataBindingSafeUnboxModelFinishedTyping4 = false;
        boolean androidDatabindingViewDataBindingSafeUnboxModelFinishedTyping1 = false;
        com.soundcode.chat.activities.authentication.VerifyModel model = mModel;
        java.lang.String javaLangStringPleaseTypeTheVerificationCodeSentToModelPhoneNumber = null;
        boolean androidDatabindingViewDataBindingSafeUnboxModelFinishedTyping6 = false;
        java.lang.Boolean modelFinishedTyping5 = null;
        boolean androidDatabindingViewDataBindingSafeUnboxModelFinishedTyping5 = false;
        java.lang.Boolean modelFinishedTyping1 = null;
        android.graphics.drawable.Drawable modelFinishedTyping4EditText4AndroidDrawableRoundEditTextGreenBgEditText4AndroidDrawableRoundEditTextBg = null;
        boolean androidDatabindingViewDataBindingSafeUnboxModelFinishedTyping3 = false;
        java.lang.String modelPhoneNumber = null;
        java.lang.Boolean modelFinishedTyping4 = null;
        int ModelFinishedTyping6MboundView8AndroidColorWhiteMboundView8AndroidColorColorPrimary1 = 0;
        android.graphics.drawable.Drawable modelFinishedTyping5EditText5AndroidDrawableRoundEditTextGreenBgEditText5AndroidDrawableRoundEditTextBg = null;

        if ((dirtyFlags & 0x1ffL) != 0) {


            if ((dirtyFlags & 0x111L) != 0) {

                    if (model != null) {
                        // read model.finishedTyping3
                        modelFinishedTyping3 = model.getFinishedTyping3();
                    }


                    // read android.databinding.ViewDataBinding.safeUnbox(model.finishedTyping3)
                    androidDatabindingViewDataBindingSafeUnboxModelFinishedTyping3 = android.databinding.ViewDataBinding.safeUnbox(modelFinishedTyping3);
                if((dirtyFlags & 0x111L) != 0) {
                    if(androidDatabindingViewDataBindingSafeUnboxModelFinishedTyping3) {
                            dirtyFlags |= 0x10000L;
                    }
                    else {
                            dirtyFlags |= 0x8000L;
                    }
                }


                    // read android.databinding.ViewDataBinding.safeUnbox(model.finishedTyping3) ? @android:drawable/round_edit_text_green_bg : @android:drawable/round_edit_text_bg
                    modelFinishedTyping3EditText3AndroidDrawableRoundEditTextGreenBgEditText3AndroidDrawableRoundEditTextBg = ((androidDatabindingViewDataBindingSafeUnboxModelFinishedTyping3) ? (getDrawableFromResource(editText3, R.drawable.round_edit_text_green_bg)) : (getDrawableFromResource(editText3, R.drawable.round_edit_text_bg)));
            }
            if ((dirtyFlags & 0x181L) != 0) {

                    if (model != null) {
                        // read model.finishedTyping6
                        ModelFinishedTyping61 = model.getFinishedTyping6();
                    }


                    // read android.databinding.ViewDataBinding.safeUnbox(model.finishedTyping6)
                    androidDatabindingViewDataBindingSafeUnboxModelFinishedTyping6 = android.databinding.ViewDataBinding.safeUnbox(ModelFinishedTyping61);
                if((dirtyFlags & 0x181L) != 0) {
                    if(androidDatabindingViewDataBindingSafeUnboxModelFinishedTyping6) {
                            dirtyFlags |= 0x4000L;
                            dirtyFlags |= 0x400000L;
                    }
                    else {
                            dirtyFlags |= 0x2000L;
                            dirtyFlags |= 0x200000L;
                    }
                }


                    // read android.databinding.ViewDataBinding.safeUnbox(model.finishedTyping6) ? @android:drawable/round_edit_text_green_bg : @android:drawable/round_edit_text_bg
                    modelFinishedTyping6EditText6AndroidDrawableRoundEditTextGreenBgEditText6AndroidDrawableRoundEditTextBg = ((androidDatabindingViewDataBindingSafeUnboxModelFinishedTyping6) ? (getDrawableFromResource(editText6, R.drawable.round_edit_text_green_bg)) : (getDrawableFromResource(editText6, R.drawable.round_edit_text_bg)));
                    // read !android.databinding.ViewDataBinding.safeUnbox(model.finishedTyping6)
                    modelFinishedTyping6 = !androidDatabindingViewDataBindingSafeUnboxModelFinishedTyping6;
                    // read android.databinding.ViewDataBinding.safeUnbox(model.finishedTyping6) ? @android:color/white : @android:color/colorPrimary
                    ModelFinishedTyping6MboundView8AndroidColorWhiteMboundView8AndroidColorColorPrimary1 = ((androidDatabindingViewDataBindingSafeUnboxModelFinishedTyping6) ? (getColorFromResource(mboundView8, R.color.white)) : (getColorFromResource(mboundView8, R.color.colorPrimary)));
                if((dirtyFlags & 0x181L) != 0) {
                    if(modelFinishedTyping6) {
                            dirtyFlags |= 0x40000L;
                    }
                    else {
                            dirtyFlags |= 0x20000L;
                    }
                }


                    // read !android.databinding.ViewDataBinding.safeUnbox(model.finishedTyping6) ? @android:color/white : @android:color/colorPrimary
                    modelFinishedTyping6MboundView8AndroidColorWhiteMboundView8AndroidColorColorPrimary = ((modelFinishedTyping6) ? (getColorFromResource(mboundView8, R.color.white)) : (getColorFromResource(mboundView8, R.color.colorPrimary)));
            }
            if ((dirtyFlags & 0x109L) != 0) {

                    if (model != null) {
                        // read model.finishedTyping2
                        modelFinishedTyping2 = model.getFinishedTyping2();
                    }


                    // read android.databinding.ViewDataBinding.safeUnbox(model.finishedTyping2)
                    androidDatabindingViewDataBindingSafeUnboxModelFinishedTyping2 = android.databinding.ViewDataBinding.safeUnbox(modelFinishedTyping2);
                if((dirtyFlags & 0x109L) != 0) {
                    if(androidDatabindingViewDataBindingSafeUnboxModelFinishedTyping2) {
                            dirtyFlags |= 0x400L;
                    }
                    else {
                            dirtyFlags |= 0x200L;
                    }
                }


                    // read android.databinding.ViewDataBinding.safeUnbox(model.finishedTyping2) ? @android:drawable/round_edit_text_green_bg : @android:drawable/round_edit_text_bg
                    modelFinishedTyping2EditText2AndroidDrawableRoundEditTextGreenBgEditText2AndroidDrawableRoundEditTextBg = ((androidDatabindingViewDataBindingSafeUnboxModelFinishedTyping2) ? (getDrawableFromResource(editText2, R.drawable.round_edit_text_green_bg)) : (getDrawableFromResource(editText2, R.drawable.round_edit_text_bg)));
            }
            if ((dirtyFlags & 0x141L) != 0) {

                    if (model != null) {
                        // read model.finishedTyping5
                        modelFinishedTyping5 = model.getFinishedTyping5();
                    }


                    // read android.databinding.ViewDataBinding.safeUnbox(model.finishedTyping5)
                    androidDatabindingViewDataBindingSafeUnboxModelFinishedTyping5 = android.databinding.ViewDataBinding.safeUnbox(modelFinishedTyping5);
                if((dirtyFlags & 0x141L) != 0) {
                    if(androidDatabindingViewDataBindingSafeUnboxModelFinishedTyping5) {
                            dirtyFlags |= 0x1000000L;
                    }
                    else {
                            dirtyFlags |= 0x800000L;
                    }
                }


                    // read android.databinding.ViewDataBinding.safeUnbox(model.finishedTyping5) ? @android:drawable/round_edit_text_green_bg : @android:drawable/round_edit_text_bg
                    modelFinishedTyping5EditText5AndroidDrawableRoundEditTextGreenBgEditText5AndroidDrawableRoundEditTextBg = ((androidDatabindingViewDataBindingSafeUnboxModelFinishedTyping5) ? (getDrawableFromResource(editText5, R.drawable.round_edit_text_green_bg)) : (getDrawableFromResource(editText5, R.drawable.round_edit_text_bg)));
            }
            if ((dirtyFlags & 0x105L) != 0) {

                    if (model != null) {
                        // read model.finishedTyping1
                        modelFinishedTyping1 = model.getFinishedTyping1();
                    }


                    // read android.databinding.ViewDataBinding.safeUnbox(model.finishedTyping1)
                    androidDatabindingViewDataBindingSafeUnboxModelFinishedTyping1 = android.databinding.ViewDataBinding.safeUnbox(modelFinishedTyping1);
                if((dirtyFlags & 0x105L) != 0) {
                    if(androidDatabindingViewDataBindingSafeUnboxModelFinishedTyping1) {
                            dirtyFlags |= 0x1000L;
                    }
                    else {
                            dirtyFlags |= 0x800L;
                    }
                }


                    // read android.databinding.ViewDataBinding.safeUnbox(model.finishedTyping1) ? @android:drawable/round_edit_text_green_bg : @android:drawable/round_edit_text_bg
                    modelFinishedTyping1EditText1AndroidDrawableRoundEditTextGreenBgEditText1AndroidDrawableRoundEditTextBg = ((androidDatabindingViewDataBindingSafeUnboxModelFinishedTyping1) ? (getDrawableFromResource(editText1, R.drawable.round_edit_text_green_bg)) : (getDrawableFromResource(editText1, R.drawable.round_edit_text_bg)));
            }
            if ((dirtyFlags & 0x103L) != 0) {

                    if (model != null) {
                        // read model.phoneNumber
                        modelPhoneNumber = model.getPhoneNumber();
                    }


                    // read ("Please type the verification code sent to ") + (model.phoneNumber)
                    javaLangStringPleaseTypeTheVerificationCodeSentToModelPhoneNumber = ("Please type the verification code sent to ") + (modelPhoneNumber);
            }
            if ((dirtyFlags & 0x121L) != 0) {

                    if (model != null) {
                        // read model.finishedTyping4
                        modelFinishedTyping4 = model.getFinishedTyping4();
                    }


                    // read android.databinding.ViewDataBinding.safeUnbox(model.finishedTyping4)
                    androidDatabindingViewDataBindingSafeUnboxModelFinishedTyping4 = android.databinding.ViewDataBinding.safeUnbox(modelFinishedTyping4);
                if((dirtyFlags & 0x121L) != 0) {
                    if(androidDatabindingViewDataBindingSafeUnboxModelFinishedTyping4) {
                            dirtyFlags |= 0x100000L;
                    }
                    else {
                            dirtyFlags |= 0x80000L;
                    }
                }


                    // read android.databinding.ViewDataBinding.safeUnbox(model.finishedTyping4) ? @android:drawable/round_edit_text_green_bg : @android:drawable/round_edit_text_bg
                    modelFinishedTyping4EditText4AndroidDrawableRoundEditTextGreenBgEditText4AndroidDrawableRoundEditTextBg = ((androidDatabindingViewDataBindingSafeUnboxModelFinishedTyping4) ? (getDrawableFromResource(editText4, R.drawable.round_edit_text_green_bg)) : (getDrawableFromResource(editText4, R.drawable.round_edit_text_bg)));
            }
        }
        // batch finished
        if ((dirtyFlags & 0x105L) != 0) {
            // api target 1

            android.databinding.adapters.ViewBindingAdapter.setBackground(this.editText1, modelFinishedTyping1EditText1AndroidDrawableRoundEditTextGreenBgEditText1AndroidDrawableRoundEditTextBg);
        }
        if ((dirtyFlags & 0x109L) != 0) {
            // api target 1

            android.databinding.adapters.ViewBindingAdapter.setBackground(this.editText2, modelFinishedTyping2EditText2AndroidDrawableRoundEditTextGreenBgEditText2AndroidDrawableRoundEditTextBg);
        }
        if ((dirtyFlags & 0x111L) != 0) {
            // api target 1

            android.databinding.adapters.ViewBindingAdapter.setBackground(this.editText3, modelFinishedTyping3EditText3AndroidDrawableRoundEditTextGreenBgEditText3AndroidDrawableRoundEditTextBg);
        }
        if ((dirtyFlags & 0x121L) != 0) {
            // api target 1

            android.databinding.adapters.ViewBindingAdapter.setBackground(this.editText4, modelFinishedTyping4EditText4AndroidDrawableRoundEditTextGreenBgEditText4AndroidDrawableRoundEditTextBg);
            this.mboundView8.setClickable(androidDatabindingViewDataBindingSafeUnboxModelFinishedTyping4);
        }
        if ((dirtyFlags & 0x141L) != 0) {
            // api target 1

            android.databinding.adapters.ViewBindingAdapter.setBackground(this.editText5, modelFinishedTyping5EditText5AndroidDrawableRoundEditTextGreenBgEditText5AndroidDrawableRoundEditTextBg);
        }
        if ((dirtyFlags & 0x181L) != 0) {
            // api target 1

            android.databinding.adapters.ViewBindingAdapter.setBackground(this.editText6, modelFinishedTyping6EditText6AndroidDrawableRoundEditTextGreenBgEditText6AndroidDrawableRoundEditTextBg);
            android.databinding.adapters.ViewBindingAdapter.setBackground(this.mboundView8, android.databinding.adapters.Converters.convertColorToDrawable(modelFinishedTyping6MboundView8AndroidColorWhiteMboundView8AndroidColorColorPrimary));
            this.mboundView8.setTextColor(ModelFinishedTyping6MboundView8AndroidColorWhiteMboundView8AndroidColorColorPrimary1);
        }
        if ((dirtyFlags & 0x103L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.text2, javaLangStringPleaseTypeTheVerificationCodeSentToModelPhoneNumber);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): model
        flag 1 (0x2L): model.phoneNumber
        flag 2 (0x3L): model.finishedTyping1
        flag 3 (0x4L): model.finishedTyping2
        flag 4 (0x5L): model.finishedTyping3
        flag 5 (0x6L): model.finishedTyping4
        flag 6 (0x7L): model.finishedTyping5
        flag 7 (0x8L): model.finishedTyping6
        flag 8 (0x9L): null
        flag 9 (0xaL): android.databinding.ViewDataBinding.safeUnbox(model.finishedTyping2) ? @android:drawable/round_edit_text_green_bg : @android:drawable/round_edit_text_bg
        flag 10 (0xbL): android.databinding.ViewDataBinding.safeUnbox(model.finishedTyping2) ? @android:drawable/round_edit_text_green_bg : @android:drawable/round_edit_text_bg
        flag 11 (0xcL): android.databinding.ViewDataBinding.safeUnbox(model.finishedTyping1) ? @android:drawable/round_edit_text_green_bg : @android:drawable/round_edit_text_bg
        flag 12 (0xdL): android.databinding.ViewDataBinding.safeUnbox(model.finishedTyping1) ? @android:drawable/round_edit_text_green_bg : @android:drawable/round_edit_text_bg
        flag 13 (0xeL): android.databinding.ViewDataBinding.safeUnbox(model.finishedTyping6) ? @android:drawable/round_edit_text_green_bg : @android:drawable/round_edit_text_bg
        flag 14 (0xfL): android.databinding.ViewDataBinding.safeUnbox(model.finishedTyping6) ? @android:drawable/round_edit_text_green_bg : @android:drawable/round_edit_text_bg
        flag 15 (0x10L): android.databinding.ViewDataBinding.safeUnbox(model.finishedTyping3) ? @android:drawable/round_edit_text_green_bg : @android:drawable/round_edit_text_bg
        flag 16 (0x11L): android.databinding.ViewDataBinding.safeUnbox(model.finishedTyping3) ? @android:drawable/round_edit_text_green_bg : @android:drawable/round_edit_text_bg
        flag 17 (0x12L): !android.databinding.ViewDataBinding.safeUnbox(model.finishedTyping6) ? @android:color/white : @android:color/colorPrimary
        flag 18 (0x13L): !android.databinding.ViewDataBinding.safeUnbox(model.finishedTyping6) ? @android:color/white : @android:color/colorPrimary
        flag 19 (0x14L): android.databinding.ViewDataBinding.safeUnbox(model.finishedTyping4) ? @android:drawable/round_edit_text_green_bg : @android:drawable/round_edit_text_bg
        flag 20 (0x15L): android.databinding.ViewDataBinding.safeUnbox(model.finishedTyping4) ? @android:drawable/round_edit_text_green_bg : @android:drawable/round_edit_text_bg
        flag 21 (0x16L): android.databinding.ViewDataBinding.safeUnbox(model.finishedTyping6) ? @android:color/white : @android:color/colorPrimary
        flag 22 (0x17L): android.databinding.ViewDataBinding.safeUnbox(model.finishedTyping6) ? @android:color/white : @android:color/colorPrimary
        flag 23 (0x18L): android.databinding.ViewDataBinding.safeUnbox(model.finishedTyping5) ? @android:drawable/round_edit_text_green_bg : @android:drawable/round_edit_text_bg
        flag 24 (0x19L): android.databinding.ViewDataBinding.safeUnbox(model.finishedTyping5) ? @android:drawable/round_edit_text_green_bg : @android:drawable/round_edit_text_bg
    flag mapping end*/
    //end
}